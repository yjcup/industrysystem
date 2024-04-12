package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.spring.web.config.ShiroWebConfiguration;
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
import com.ruoyi.system.domain.History;
import com.ruoyi.system.service.IHistoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 浏览记录Controller
 * 
 * @author ruoyi
 * @date 2024-04-02
 */
@Controller
@RequestMapping("/system/history")
public class HistoryController extends BaseController
{
    private String prefix = "system/history";

    @Autowired
    private IHistoryService historyService;

    @RequiresPermissions("system:history:view")
    @GetMapping()
    public String history()
    {
        return prefix + "/history";
    }

    /**
     * 查询浏览记录列表
     */
    @RequiresPermissions("system:history:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(History history)
    {
        startPage();
        history.setUserId(ShiroUtils.getUserId());
        List<History> list = historyService.selectHistoryList(history);
        return getDataTable(list);
    }

    /**
     * 导出浏览记录列表
     */
    @RequiresPermissions("system:history:export")
    @Log(title = "浏览记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(History history)
    {
        List<History> list = historyService.selectHistoryList(history);
        ExcelUtil<History> util = new ExcelUtil<History>(History.class);
        return util.exportExcel(list, "浏览记录数据");
    }

    /**
     * 新增浏览记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存浏览记录
     */
    @RequiresPermissions("system:history:add")
    @Log(title = "浏览记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(History history)
    {
        return toAjax(historyService.insertHistory(history));
    }

    /**
     * 修改浏览记录
     */
    @RequiresPermissions("system:history:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        History history = historyService.selectHistoryById(id);
        mmap.put("history", history);
        return prefix + "/edit";
    }

    /**
     * 修改保存浏览记录
     */
    @RequiresPermissions("system:history:edit")
    @Log(title = "浏览记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(History history)
    {
        return toAjax(historyService.updateHistory(history));
    }

    /**
     * 删除浏览记录
     */
    @RequiresPermissions("system:history:remove")
    @Log(title = "浏览记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(historyService.deleteHistoryByIds(ids));
    }
}
