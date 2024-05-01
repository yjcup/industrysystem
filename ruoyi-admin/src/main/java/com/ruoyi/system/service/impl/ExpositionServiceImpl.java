package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Exposition;
import com.ruoyi.system.mapper.ExpositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.IExpositionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 博览会申请管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-01
 */
@Service
public class ExpositionServiceImpl implements IExpositionService 
{
    @Autowired
    private ExpositionMapper expositionMapper;

    /**
     * 查询博览会申请管理
     * 
     * @param id 博览会申请管理主键
     * @return 博览会申请管理
     */
    @Override
    public Exposition selectExpositionById(Long id)
    {
        return expositionMapper.selectExpositionById(id);
    }

    /**
     * 查询博览会申请管理列表
     * 
     * @param exposition 博览会申请管理
     * @return 博览会申请管理
     */
    @Override
    public List<Exposition> selectExpositionList(Exposition exposition)
    {
        return expositionMapper.selectExpositionList(exposition);
    }

    /**
     * 新增博览会申请管理
     * 
     * @param exposition 博览会申请管理
     * @return 结果
     */
    @Override
    public int insertExposition(Exposition exposition)
    {
        exposition.setCreateTime(DateUtils.getNowDate());
        return expositionMapper.insertExposition(exposition);
    }

    /**
     * 修改博览会申请管理
     * 
     * @param exposition 博览会申请管理
     * @return 结果
     */
    @Override
    public int updateExposition(Exposition exposition)
    {
        return expositionMapper.updateExposition(exposition);
    }

    /**
     * 批量删除博览会申请管理
     * 
     * @param ids 需要删除的博览会申请管理主键
     * @return 结果
     */
    @Override
    public int deleteExpositionByIds(String ids)
    {
        return expositionMapper.deleteExpositionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除博览会申请管理信息
     * 
     * @param id 博览会申请管理主键
     * @return 结果
     */
    @Override
    public int deleteExpositionById(Long id)
    {
        return expositionMapper.deleteExpositionById(id);
    }
}
