package com.ruoyi.system.controller;

import com.ruoyi.system.domain.GeoData;
import com.ruoyi.system.domain.Product;
import com.ruoyi.system.domain.SysOrder;
import com.ruoyi.system.service.IProductService;
import com.ruoyi.system.service.ISysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class EchartController {


    @Autowired
    private IProductService iProductService;


    @GetMapping("/echart2")
    public Map<String, Object> Chart2(){
        List<Product> products = iProductService.selectProductList(new Product());
        Map<String, Integer> provCountMap = new HashMap<>();
        for (Product product : products) {
            String prov = product.getProv();
            provCountMap.put(prov, provCountMap.getOrDefault(prov, 0) + 1);
        }

// 将map按值排序
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(provCountMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<Integer> data = new ArrayList<>();
        List<String> titlename = new ArrayList<>();
        Map<String, Object> responseData = new HashMap<>();

// 只选择前10个条目
        int flag = Math.min(sortedEntries.size(), 10);
        for (int i = 0; i < flag; i++) {
            Map.Entry<String, Integer> entry = sortedEntries.get(i);
            titlename.add(entry.getKey());
            data.add(entry.getValue());
        }

        responseData.put("data", data);
        responseData.put("titlename", titlename);
        return responseData;
    }


    @Autowired
    private ISysOrderService orderService;
    @GetMapping("/echart3")
    public Map<String, Object> Echart3(){
        List<SysOrder> sysOrders = orderService.selectSysOrderList(new SysOrder());
        Map<String, Integer> monthlyOrderCount = new HashMap<>();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM-yyyy");
        List<String> months = new ArrayList<>();
        List<Integer> orderCounts = new ArrayList<>();

        for (SysOrder order : sysOrders) {
            // 获取订单的创建时间
            Date createTime = order.getCreateTime();
            // 格式化成月份字符串
            String monthKey = monthFormat.format(createTime);
            // 更新对应月份的订单数量
            monthlyOrderCount.put(monthKey, monthlyOrderCount.getOrDefault(monthKey, 0) + 1);
        }

        // 将数据添加到月份和订单数量的列表中
        for (Map.Entry<String, Integer> entry : monthlyOrderCount.entrySet()) {
            months.add(entry.getKey());
            orderCounts.add(entry.getValue());
        }

        // 构建响应数据
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("months", months);
        responseData.put("orderCounts", orderCounts);

        return responseData;
    }


    @GetMapping("/echart4")
    public List<GeoData> echart4(){
        List<GeoData> list =new ArrayList<>();
        List<Product> products = iProductService.selectProductList(new Product());
        Map<String,Integer> map = new HashMap<>();
        for(Product product:products){
            String s = extractCity(product.getProv());
            if(map.containsKey(s)){
                    map.compute(s,(key,value)->{
                        return value+1;
                    });
            }else{
                map.put(s,1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String cityName = entry.getKey();
            int value = entry.getValue();
            list.add(new GeoData(cityName, value));
        }
        return list;
    }


    // 从省份信息中提取市的名称
    private static String extractCity(String prov) {
        String pattern = "[^省市]+市$"; // 匹配末尾是“市”的字符串（排除“省”）
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(prov);

        // 如果找到匹配的市的名称，则去掉末尾的“市”并返回
        if (m.find()) {
            String city = m.group();
            return city.substring(0, city.length() - 1); // 去掉末尾的“市”
        } else {
            // 否则返回原始字符串
            return prov;
        }
    }





}