package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.History;

/**
 * 浏览记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-02
 */
public interface HistoryMapper 
{
    /**
     * 查询浏览记录
     * 
     * @param id 浏览记录主键
     * @return 浏览记录
     */
    public History selectHistoryById(Long id);

    /**
     * 查询浏览记录列表
     * 
     * @param history 浏览记录
     * @return 浏览记录集合
     */
    public List<History> selectHistoryList(History history);

    /**
     * 新增浏览记录
     * 
     * @param history 浏览记录
     * @return 结果
     */
    public int insertHistory(History history);

    /**
     * 修改浏览记录
     * 
     * @param history 浏览记录
     * @return 结果
     */
    public int updateHistory(History history);

    /**
     * 删除浏览记录
     * 
     * @param id 浏览记录主键
     * @return 结果
     */
    public int deleteHistoryById(Long id);

    /**
     * 批量删除浏览记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHistoryByIds(String[] ids);
}
