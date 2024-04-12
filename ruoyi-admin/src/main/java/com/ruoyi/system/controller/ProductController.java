package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.DistrictEntity;
import com.ruoyi.system.mapper.DistrictMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Product;
import com.ruoyi.system.service.IProductService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品信息管理Controller
 * 
 * @author ruoyi
 * @date 2024-02-06
 */
@Controller
@RequestMapping("/platform/product")
public class ProductController extends BaseController
{
    private String prefix_merchant = "platform/product_merchant";
    private String prefix_manager = "platform/product_manager";


    @Autowired
    private IProductService productService;

    @RequiresPermissions("platform:product:view")
    @GetMapping()
    public String product()
    {
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        System.out.println(roles);
        if(roles.get(0).getRoleKey().equals("manager")){
            System.out.println("asdfasdfsdafas");
            return prefix_manager+"/product";
        }
        return prefix_merchant + "/product";
    }

    /**
     * 查询商品信息管理列表
     */
    @RequiresPermissions("platform:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出商品信息管理列表
     */
    @RequiresPermissions("platform:product:export")
    @Log(title = "商品信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        return util.exportExcel(list, "商品信息管理数据");
    }

    /**
     * 新增商品信息管理
     */
    @GetMapping("/add")
    public String add()
    {
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        if(roles.get(0).getRoleKey().equals("manager")){
            return prefix_manager+"/add";
        }
        return prefix_merchant + "/add";
    }

    /**
     * 新增保存商品信息管理
     */

    @Autowired
    private DistrictMapper districtMapper;

    @RequiresPermissions("platform:product:add")
    @Log(title = "商品信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Product product,@RequestParam("provinceName") String provinceName,
                              @RequestParam("cityName") String cityName)
    {
        System.out.println(provinceName);
        System.out.println(cityName);
        System.out.println(product);
//        productService.insertProduct(product)
        // 拼接prov
        StringBuffer sb = new StringBuffer();
        if(!"-1".equals(provinceName)){
            DistrictEntity cityInfoById = districtMapper.getCityInfoById(Integer.valueOf(provinceName));
            sb.append(cityInfoById.getDistrictName());
        }
        if(!"-1".equals(cityName)){
            DistrictEntity cityInfoById = districtMapper.getCityInfoById(Integer.valueOf(cityName));
            sb.append(cityInfoById.getDistrictName());
        }
        product.setProv(sb.toString());
        return AjaxResult.success(productService.insertProduct(product));
    }

    /**
     * 修改商品信息管理
     */
    @RequiresPermissions("platform:product:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Product product = productService.selectProductById(id);
        mmap.put("product", product);
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        if(roles.get(0).getRoleKey().equals("manager")){
            return prefix_manager+"/edit";
        }
        return prefix_merchant + "/edit";    }

    /**
     * 修改保存商品信息管理
     */
    @RequiresPermissions("platform:product:edit")
    @Log(title = "商品信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Product product,@RequestParam(value = "provinceName",defaultValue = "-1") String provinceName,
                               @RequestParam(value = "cityName",defaultValue = "-1") String cityName)
    {
        // 拼接prov
        StringBuffer sb = new StringBuffer();
        if(!"-1".equals(provinceName)){
            DistrictEntity cityInfoById = districtMapper.getCityInfoById(Integer.valueOf(provinceName));
            sb.append(cityInfoById.getDistrictName());
        }
        if(!"-1".equals(cityName)){
            DistrictEntity cityInfoById = districtMapper.getCityInfoById(Integer.valueOf(cityName));
            sb.append(cityInfoById.getDistrictName());
        }
        if(!sb.toString().isEmpty()){
           product.setProv(sb.toString());
        }
        SysRole sysRole = ShiroUtils.getSysUser().getRoles().get(0);
        if("merchant".equals(sysRole.getRoleName())){
            product.setStatus("0");
        }
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除商品信息管理
     */
    @RequiresPermissions("platform:product:remove")
    @Log(title = "商品信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productService.deleteProductByIds(ids));
    }
}
