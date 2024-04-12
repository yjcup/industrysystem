package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Collect;

/**
 * 我的云游计划Service接口
 * 
 * @author ruoyi
 * @date 2024-03-02
 */
public interface ICollectService 
{
    /**
     * 查询我的云游计划
     * 
     * @param id 我的云游计划主键
     * @return 我的云游计划
     */
    public Collect selectCollectById(Long id);

    /**
     * 查询我的云游计划列表
     * 
     * @param collect 我的云游计划
     * @return 我的云游计划集合
     */
    public List<Collect> selectCollectList(Collect collect);

    /**
     * 新增我的云游计划
     * 
     * @param collect 我的云游计划
     * @return 结果
     */
    public int insertCollect(Collect collect);

    /**
     * 修改我的云游计划
     * 
     * @param collect 我的云游计划
     * @return 结果
     */
    public int updateCollect(Collect collect);

    /**
     * 批量删除我的云游计划
     * 
     * @param ids 需要删除的我的云游计划主键集合
     * @return 结果
     */
    public int deleteCollectByIds(String ids);

    /**
     * 删除我的云游计划信息
     * 
     * @param id 我的云游计划主键
     * @return 结果
     */
    public int deleteCollectById(Long id);
}
