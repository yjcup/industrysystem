package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HistoryMapper;
import com.ruoyi.system.domain.History;
import com.ruoyi.system.service.IHistoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 浏览记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-02
 */
@Service
public class HistoryServiceImpl implements IHistoryService 
{
    @Autowired
    private HistoryMapper historyMapper;

    /**
     * 查询浏览记录
     * 
     * @param id 浏览记录主键
     * @return 浏览记录
     */
    @Override
    public History selectHistoryById(Long id)
    {
        return historyMapper.selectHistoryById(id);
    }

    /**
     * 查询浏览记录列表
     * 
     * @param history 浏览记录
     * @return 浏览记录
     */
    @Override
    public List<History> selectHistoryList(History history)
    {
        return historyMapper.selectHistoryList(history);
    }

    /**
     * 新增浏览记录
     * 
     * @param history 浏览记录
     * @return 结果
     */
    @Override
    public int insertHistory(History history)
    {
        history.setCreateTime(DateUtils.getNowDate());
        return historyMapper.insertHistory(history);
    }

    /**
     * 修改浏览记录
     * 
     * @param history 浏览记录
     * @return 结果
     */
    @Override
    public int updateHistory(History history)
    {
        return historyMapper.updateHistory(history);
    }

    /**
     * 批量删除浏览记录
     * 
     * @param ids 需要删除的浏览记录主键
     * @return 结果
     */
    @Override
    public int deleteHistoryByIds(String ids)
    {
        return historyMapper.deleteHistoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除浏览记录信息
     * 
     * @param id 浏览记录主键
     * @return 结果
     */
    @Override
    public int deleteHistoryById(Long id)
    {
        return historyMapper.deleteHistoryById(id);
    }
}
