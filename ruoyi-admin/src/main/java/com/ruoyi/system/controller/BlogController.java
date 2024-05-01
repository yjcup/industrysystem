package com.ruoyi.system.controller;

import java.util.List;

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
import com.ruoyi.system.domain.Blog;
import com.ruoyi.system.service.IBlogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游玩日记管理Controller
 * 
 * @author ruoyi
 * @date 2024-02-06
 */
@Controller
@RequestMapping("/platform/blog")
public class BlogController extends BaseController
{
    private String prefix = "platform/blog";

    @Autowired
    private IBlogService blogService;

    @RequiresPermissions("platform:blog:view")
    @GetMapping()
    public String blog()
    {
        return prefix + "/blog";
    }

    /**
     * 查询游玩日记管理列表
     */
    @RequiresPermissions("platform:blog:list")
        @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Blog blog)
    {
        startPage();
        blog.setUserId(ShiroUtils.getUserId());
        List<Blog> list = blogService.selectBlogList(blog);
        return getDataTable(list);
    }

    /**
     * 导出游玩日记管理列表
     */
    @RequiresPermissions("platform:blog:export")
    @Log(title = "游玩日记管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Blog blog)
    {
        List<Blog> list = blogService.selectBlogList(blog);
        ExcelUtil<Blog> util = new ExcelUtil<Blog>(Blog.class);
        return util.exportExcel(list, "游玩日记管理数据");
    }

    /**
     * 新增游玩日记管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }


    @Autowired
    private DistrictMapper districtMapper;

    /**
     * 新增保存游玩日记管理
     */
    @RequiresPermissions("platform:blog:add")
    @Log(title = "游玩日记管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Blog blog,@RequestParam("provinceName") String provinceName,
                              @RequestParam("cityName") String cityName)
    {
        StringBuffer sb = new StringBuffer();
        if(!"-1".equals(provinceName)){
            DistrictEntity cityInfoById = districtMapper.getCityInfoById(Integer.valueOf(provinceName));
            sb.append(cityInfoById.getDistrictName());
        }
        if(!"-1".equals(cityName)){
            DistrictEntity cityInfoById = districtMapper.getCityInfoById(Integer.valueOf(cityName));
            sb.append(cityInfoById.getDistrictName());
        }
        blog.setAddress(sb.toString());
        return toAjax(blogService.insertBlog(blog));
    }

    /**
     * 修改游玩日记管理
     */
    @RequiresPermissions("platform:blog:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Blog blog = blogService.selectBlogById(id);
        mmap.put("blog", blog);
        return prefix + "/edit";
    }

    /**
     * 修改保存游玩日记管理
     */
    @RequiresPermissions("platform:blog:edit")
    @Log(title = "游玩日记管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Blog blog,@RequestParam(value = "provinceName",defaultValue = "-1") String provinceName,
                               @RequestParam(value = "cityName",defaultValue = "-1") String cityName)
    {
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
            blog.setAddress(sb.toString());
        }
        return toAjax(blogService.updateBlog(blog));
    }

    /**
     * 删除游玩日记管理
     */
    @RequiresPermissions("platform:blog:remove")
    @Log(title = "游玩日记管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(blogService.deleteBlogByIds(ids));
    }
}
