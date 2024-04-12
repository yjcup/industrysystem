package com.ruoyi.web.controller.platform;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.Blog;
import com.ruoyi.system.domain.Collect;
import com.ruoyi.system.domain.DistrictEntity;
import com.ruoyi.system.mapper.DistrictMapper;
import com.ruoyi.system.service.impl.BlogServiceImpl;
import com.ruoyi.system.service.impl.CollectServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/city")
public class FrontController {
    @Autowired
    private DistrictMapper districtMapper;

    @GetMapping("/getProvinceList")
    @ResponseBody
    public AjaxResult getProvinceList() {
//https://blog.csdn.net/kanke9527/article/details/114377000
        List<DistrictEntity> provinceList = districtMapper.getProvinceList();
        return AjaxResult.success(provinceList);
    }

    @GetMapping("/getCityListByid")
    @ResponseBody
    public AjaxResult getProvinceList(Integer id) {
        DistrictEntity cityInfoById = districtMapper.getCityInfoById(id);
        List<DistrictEntity> cityListByParentId = districtMapper.getCityListByParentId(cityInfoById.getDistrictId());
        return AjaxResult.success(cityListByParentId);
    }


    @Autowired
    private CollectServiceImpl collectService;
    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/addblog/{id}")
    @ResponseBody
    public AjaxResult getAddBlog(@PathVariable Integer id){
        Long userId = ShiroUtils.getUserId();
        Collect collect = new Collect();
        //
        collect.setBlogId(Long.valueOf(id));
        collect.setUserId(userId);
        List<Collect> collects = collectService.selectCollectList(collect);
        if(collects.isEmpty()){
            Blog blog = blogService.selectBlogById(Long.valueOf(id));
            collect.setTitle(blog.getTitle());
            collectService.insertCollect(collect);
        }
        return AjaxResult.success();
    }



}
