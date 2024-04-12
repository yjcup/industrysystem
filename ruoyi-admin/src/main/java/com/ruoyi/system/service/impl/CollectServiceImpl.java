package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CollectMapper;
import com.ruoyi.system.domain.Collect;
import com.ruoyi.system.service.ICollectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 我的云游计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-02
 */
@Service
public class CollectServiceImpl implements ICollectService 
{
    @Autowired
    private CollectMapper collectMapper;

    /**
     * 查询我的云游计划
     * 
     * @param id 我的云游计划主键
     * @return 我的云游计划
     */
    @Override
    public Collect selectCollectById(Long id)
    {
        return collectMapper.selectCollectById(id);
    }

    /**
     * 查询我的云游计划列表
     * 
     * @param collect 我的云游计划
     * @return 我的云游计划
     */
    @Override
    public List<Collect> selectCollectList(Collect collect)
    {
        return collectMapper.selectCollectList(collect);
    }

    /**
     * 新增我的云游计划
     * 
     * @param collect 我的云游计划
     * @return 结果
     */
    @Override
    public int insertCollect(Collect collect)
    {
        collect.setCreateTime(DateUtils.getNowDate());
        return collectMapper.insertCollect(collect);
    }

    /**
     * 修改我的云游计划
     * 
     * @param collect 我的云游计划
     * @return 结果
     */
    @Override
    public int updateCollect(Collect collect)
    {
        return collectMapper.updateCollect(collect);
    }

    /**
     * 批量删除我的云游计划
     * 
     * @param ids 需要删除的我的云游计划主键
     * @return 结果
     */
    @Override
    public int deleteCollectByIds(String ids)
    {
        return collectMapper.deleteCollectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除我的云游计划信息
     * 
     * @param id 我的云游计划主键
     * @return 结果
     */
    @Override
    public int deleteCollectById(Long id)
    {
        return collectMapper.deleteCollectById(id);
    }
}
