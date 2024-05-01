package com.ruoyi.web.controller.platform;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.controller.WordCount;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.IBlogService;
import com.ruoyi.system.service.ICartService;
import com.ruoyi.system.service.ISysOrderService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.impl.CartServiceImpl;
import com.ruoyi.system.service.impl.ExpositionServiceImpl;
import com.ruoyi.system.service.impl.HistoryServiceImpl;
import com.ruoyi.system.service.impl.ProductServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class PageController {


    @Autowired
    private ProductServiceImpl productService;


    @Autowired
    private CartServiceImpl cartService;


    @Autowired
    private ExpositionServiceImpl expositionService;




    @GetMapping("/index")
    public String getIndex(ModelMap modelMap){
        Product product = new Product();
        product.setStatus("1");
        List<Product> products = productService.selectProductList(product);
        List<ProductPlus> productPluses = new ArrayList<>();
        for(Product pro:products){
            ProductPlus productPlus = new ProductPlus();
            BeanUtils.copyProperties(pro,productPlus);
            List<String> list = Arrays.asList(pro.getImglist().split(","));
            productPlus.setImgs(list);
            productPluses.add(productPlus);
        }
        List<ProductPlus> productPluses1 = new ArrayList<>(productPluses);
        List<ProductPlus> productPluses2 = new ArrayList<>(productPluses);

        if (productPluses.size() > 3) {
            Collections.shuffle(productPluses, new Random());
            productPluses1 = productPluses1.subList(0, 3);
        }
        //热销产品

        if (productPluses.size() >= 12) {
            productPluses2 = productPluses2.subList(0, 12);
        }
        List<Blog> blogs = blogService.selectBlogList(new Blog());
        if(blogs.size()>3){
            blogs = blogs.subList(0,3);
        }

        Exposition exposition = new Exposition();
        exposition.setStatus("1");
        List<Exposition> expositions = expositionService.selectExpositionList(exposition);
        List<Exposition> expositions1 = expositions.subList(0, Math.min(expositions.size(), 4));



        System.out.println(productPluses1.size());
        modelMap.put("pros",productPluses2);
//        modelMap.put("indexpro",productPluses1);
        modelMap.put("exps",expositions1);
        modelMap.put("blogs",blogs);
        return "platform/index";
    }

    @GetMapping("/userreg")
    public String UserLogin(){
        return "platform/login-register";
    }
    @GetMapping("/cart")
    public String getCart(ModelMap modelMap, HttpSession session) {

        Long userId = ShiroUtils.getSysUser().getUserId();
        Cart cart = new Cart();
        cart.setUserId(userId);
        List<Cart> carts = cartService.selectCartList(cart);
        List<CartFront> cartFronts = new ArrayList<>();
        for(Cart cart1:carts){
            CartFront cartFront = new CartFront();
            BeanUtils.copyProperties(cart1,cartFront);
            Product product = productService.selectProductById(cartFront.getProductId());
            String s = product.getImglist().split(",")[0];
            product.setImglist(s);
            cartFront.setProduct(product);
            cartFronts.add(cartFront);
        }
        modelMap.put("info",cartFronts);
        System.out.println(cartFronts);
        return "platform/cart";
    }

    @GetMapping("/cartdelete/{id}")
    @ResponseBody
    public AjaxResult CartDelete(@PathVariable Long id){
        int i = cartService.deleteCartById(id);
        return AjaxResult.success();
    }


    @GetMapping("/addcart/{id}/{number}")
    @ResponseBody
    public AjaxResult AddCart(@PathVariable("id")Long id,@PathVariable Long number){
        Cart cart = new Cart();
        cart.setProductId(id);
        cart.setUserId(ShiroUtils.getUserId());
        cart.setNumber(number);
        cartService.insertCart(cart);
        return AjaxResult.success();
    }



    @Autowired
    private IBlogService blogService;
    @GetMapping("/bloglist")
    public String getBloglist(@RequestParam(value = "page",defaultValue = "1")Integer page,ModelMap modelMap) {
        PageHelper.startPage(page,6);
        List<Blog> blogs = blogService.selectBlogList(new Blog());
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        modelMap.put("pageinfo",pageInfo);
        return "platform/bloglist";
    }

    @Autowired
    private HistoryServiceImpl historyService;
    @GetMapping("/blogdetail/{id}")
    public String getBlogDetail(@PathVariable Long id,ModelMap modelMap) {
        Long userId = ShiroUtils.getUserId();
        History history = new History();
        history.setBlogId(id);
        Blog blog = blogService.selectBlogById(id);
        history.setUserId(userId);
        history.setTitle(blog.getTitle());
        modelMap.put("blog",blog);
        historyService.insertHistory(history);
        return "platform/blog-details";
    }


    @Autowired
    private ISysUserService sysUserService;



    @GetMapping("/chart")
    public String getChart(ModelMap modelMap) throws IOException {
        List<SysUser> sysUsers = sysUserService.selectUserList(new SysUser());
        modelMap.put("usercount",sysUsers.size());
        int size = orderService.selectSysOrderList(new SysOrder()).size();
        modelMap.put("ordercount",size);
        int size1 = blogService.selectBlogList(new Blog()).size();
        modelMap.put("blogcount",size1);
        int size2 = productService.selectProductList(new Product()).size();
        modelMap.put("procount",size2);

        List<Blog> blogs = blogService.selectBlogList(new Blog());
        StringBuffer sb = new StringBuffer();
        for(Blog blog :blogs){
            sb.append(blog.getTitle()).append(" ");
        }
        List<Map.Entry<String, Integer>> entries = WordCount.wordFrequency(sb.toString());
        for (Map.Entry<String, Integer> entry : entries) {
            entry.setValue(entry.getValue() * 10); // 这里假设放大10倍
        }
        List<Map.Entry<String, Integer>> entries1 = entries.subList(0, Math.min(entries.size(), 5));
        System.out.println(entries1);
        modelMap.put("topFourEntries",entries1);
        System.out.println(entries);
        return "platform/chart";
    }

    @GetMapping("/aboutus")
    public String Checkout() {
        return "platform/about-us";
    }

    @PostMapping("/checkoutpost")
    @ResponseBody
    public AjaxResult getAboutus(@RequestBody List<CartItem> cartItems,HttpSession httpSession) {
        httpSession.setAttribute("cartitems",cartItems);
        return AjaxResult.success();
    }

    @Autowired
    private ISysOrderService orderService;


    @PostMapping("/orderpost")
    @ResponseBody
    public AjaxResult OrderPost(@RequestBody CheckoutRequest checkoutRequest){
        //存储订单
        // 修改购物车
        SysOrder order = new SysOrder();
        order.setAddress(checkoutRequest.getAddress());
        order.setContact(checkoutRequest.getName());
        order.setPhone(checkoutRequest.getPhone());
        StringBuffer sb= new StringBuffer();
        Long userId = ShiroUtils.getUserId();
        for(ProductFront pr:checkoutRequest.getProducts()){
            //修改购物车
            sb.append(pr.getName()).append("   ");
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart.setProductId(pr.getId());
            List<Cart> carts = cartService.selectCartList(cart);

            if(!carts.isEmpty()){
                Cart cart1 = carts.get(0);
                cartService.deleteCartById(cart1.getId());
            }
        }
        order.setStatus("0");
        order.setGoodsList(sb.toString());
        order.setUserId(ShiroUtils.getUserId());
        orderService.insertSysOrder(order);

        return AjaxResult.success();
    }


    @GetMapping("/checkout")
    public String checkout(HttpSession session,ModelMap modelMap){
        List<CartItem> cartitems = (List<CartItem>) session.getAttribute("cartitems");
        session.removeAttribute("cartItems");
        List<Product> products = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        if(cartitems==null){
            cartitems = new ArrayList<>();
        }
        for(CartItem cartItem:cartitems){
            Product product = productService.selectProductById(cartItem.getId());
            BigDecimal qu = new BigDecimal(cartItem.getQuantity());
            BigDecimal multiply = product.getPrice().multiply(qu);
            product.setPrice(multiply);
            total = total.add(multiply);
            System.out.println(multiply);
            product.setCount(Long.valueOf(cartItem.getQuantity()));
            products.add(product);
        }
        modelMap.put("total",total);
        modelMap.put("products",products);
        return "platform/checkout";
    }


    @GetMapping("/productlist")
    public String getProductlist(@RequestParam(value = "page",defaultValue = "1") Integer page, ModelMap modelMap) {
        PageHelper.startPage(page,6);
        Product product = new Product();
        product.setStatus("1");
        List<Product> products = productService.selectProductList(product);
        List<ProductPlus> productPluses = new ArrayList<>();
        for(Product pro:products){
            ProductPlus productPlus = new ProductPlus();
            BeanUtils.copyProperties(pro,productPlus);
            List<String> list = Arrays.asList(pro.getImglist().split(","));
            productPlus.setImgs(list);
            productPluses.add(productPlus);
        }

        PageInfo<ProductPlus> pageInfo = new PageInfo<>(productPluses);
        modelMap.put("pageinfo",pageInfo);
        System.out.println(pageInfo);
        return "platform/productlist";
    }

    @PostMapping("/productlist")
    public String getProduct(ModelMap modelMap,@RequestParam(value = "province",defaultValue = "",required = false) String province,
                             @RequestParam(value = "city",defaultValue = "",required = false) String city,
                                 @RequestParam(value = "startDate",defaultValue = "",required = false) String startDate,
                                 @RequestParam(value = "endDate",defaultValue = "",required = false) String endDate) {

        Product product = new Product();
        product.setProv(province+city);
        Map<String,Object> map = new HashMap<>();
        map.put("beginCreateTime",startDate);
        map.put("endCreateTime",endDate);
        product.setParams(map);
        List<Product> products = productService.selectProductList(product);
        List<ProductPlus> productPluses = new ArrayList<>();
        for(Product pro:products){
            ProductPlus productPlus = new ProductPlus();
            BeanUtils.copyProperties(pro,productPlus);
            List<String> list = Arrays.asList(pro.getImglist().split(","));
            productPlus.setImgs(list);
            productPluses.add(productPlus);
        }
        PageInfo<ProductPlus> pageInfo = new PageInfo<>(productPluses);
        modelMap.put("pageinfo",pageInfo);
        if(!"".equals(province)&&"".equals(city)&&"".equals(startDate)&&"".equals(endDate)){
            modelMap.put("flag",false);
        }

        System.out.println(pageInfo);
        return "platform/productlist";
    }


    @PostMapping("/bloglist")
    public String getbloglsit(ModelMap modelMap,@RequestParam(value = "province",defaultValue = "",required = false) String province,
                              @RequestParam(value = "city",defaultValue = "",required = false) String city){
        Blog blog = new Blog();
        blog.setAddress(province+city);
        List<Blog> blogs = blogService.selectBlogList(blog);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogs);
        if(!"".equals(province)&&"".equals(city)){
            modelMap.put("flag",false);
        }
        modelMap.put("pageinfo",blogPageInfo);

        return "platform/bloglist";
    }


    @GetMapping("/productdetail/{id}")
    public String getProductdetail(@PathVariable Long id,ModelMap modelMap) {
        Product product = productService.selectProductById(id);
        ProductPlus productPlus = new ProductPlus();
        BeanUtils.copyProperties(product,productPlus);
        List<String> list = Arrays.asList(product.getImglist().split(","));
        productPlus.setImgs(list);
        modelMap.put("pro",productPlus);
        return "platform/product-details";
    }




    /*
     *
     *       主页
     *       列表
     *       详情
     *       购物车
     *       结算
     *       博客
     *       详情
     *
     *          id
     *          user_id
     *          product_id
     *          number
     *
     *
     *          id
     *          user_id
     *          product_id
     *          number
     *
     *
     *
     * */

}