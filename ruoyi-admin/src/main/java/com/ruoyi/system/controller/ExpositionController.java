package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.Exposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.IExpositionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博览会申请管理Controller
 * 
 * @author ruoyi
 * @date 2024-05-01
 */
@Controller
@RequestMapping("/platform/exposition")
public class ExpositionController extends BaseController
{
    private String prefix = "platform/exposition";

    private String prefix_merchant = "platform/exposition_merchant";



    @Autowired
    private IExpositionService expositionService;

    @GetMapping()
    public String exposition()
    {
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        if(roles.get(0).getRoleKey().equals("merchant")) {
            return prefix_merchant + "/exposition";
        }
        return prefix + "/exposition";
    }

    /**
     * 查询博览会申请管理列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Exposition exposition)
    {
        startPage();
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        if(roles.get(0).getRoleKey().equals("merchant")) {
            exposition.setUserId(ShiroUtils.getUserId());
        }
        List<Exposition> list = expositionService.selectExpositionList(exposition);
        return getDataTable(list);
    }

    /**
     * 导出博览会申请管理列表
     */
    @Log(title = "博览会申请管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Exposition exposition)
    {
        List<Exposition> list = expositionService.selectExpositionList(exposition);
        ExcelUtil<Exposition> util = new ExcelUtil<Exposition>(Exposition.class);
        return util.exportExcel(list, "博览会申请管理数据");
    }

    /**
     * 新增博览会申请管理
     */
    @GetMapping("/add")
    public String add()
    {
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        if(roles.get(0).getRoleKey().equals("merchant")) {
            return prefix_merchant + "/add";
        }
        return prefix + "/add";
    }

    /**
     * 新增保存博览会申请管理
     */
    @Log(title = "博览会申请管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Exposition exposition)
    {
        exposition.setStatus("0");
        exposition.setUserId(ShiroUtils.getUserId());
        return toAjax(expositionService.insertExposition(exposition));
    }

    /**
     * 修改博览会申请管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Exposition exposition = expositionService.selectExpositionById(id);
        mmap.put("exposition", exposition);
        return prefix + "/edit";
    }

    /**
     * 修改保存博览会申请管理
     */
    @Log(title = "博览会申请管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Exposition exposition)
    {
        return toAjax(expositionService.updateExposition(exposition));
    }

    /**
     * 删除博览会申请管理
     */
    @Log(title = "博览会申请管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(expositionService.deleteExpositionByIds(ids));
    }
}
