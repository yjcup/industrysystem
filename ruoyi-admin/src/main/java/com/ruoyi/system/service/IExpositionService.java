package com.ruoyi.system.service;

import com.ruoyi.system.domain.Exposition;

import java.util.List;

/**
 * 博览会申请管理Service接口
 * 
 * @author ruoyi
 * @date 2024-05-01
 */
public interface IExpositionService 
{
    /**
     * 查询博览会申请管理
     * 
     * @param id 博览会申请管理主键
     * @return 博览会申请管理
     */
    public Exposition selectExpositionById(Long id);

    /**
     * 查询博览会申请管理列表
     * 
     * @param exposition 博览会申请管理
     * @return 博览会申请管理集合
     */
    public List<Exposition> selectExpositionList(Exposition exposition);

    /**
     * 新增博览会申请管理
     * 
     * @param exposition 博览会申请管理
     * @return 结果
     */
    public int insertExposition(Exposition exposition);

    /**
     * 修改博览会申请管理
     * 
     * @param exposition 博览会申请管理
     * @return 结果
     */
    public int updateExposition(Exposition exposition);

    /**
     * 批量删除博览会申请管理
     * 
     * @param ids 需要删除的博览会申请管理主键集合
     * @return 结果
     */
    public int deleteExpositionByIds(String ids);

    /**
     * 删除博览会申请管理信息
     * 
     * @param id 博览会申请管理主键
     * @return 结果
     */
    public int deleteExpositionById(Long id);
}
