package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysOrder;

/**
 * 订单管理Service接口
 * 
 * @author ruoyi
 * @date 2024-03-02
 */
public interface ISysOrderService 
{
    /**
     * 查询订单管理
     * 
     * @param id 订单管理主键
     * @return 订单管理
     */
    public SysOrder selectSysOrderById(Long id);

    /**
     * 查询订单管理列表
     * 
     * @param sysOrder 订单管理
     * @return 订单管理集合
     */
    public List<SysOrder> selectSysOrderList(SysOrder sysOrder);

    /**
     * 新增订单管理
     * 
     * @param sysOrder 订单管理
     * @return 结果
     */
    public int insertSysOrder(SysOrder sysOrder);

    /**
     * 修改订单管理
     * 
     * @param sysOrder 订单管理
     * @return 结果
     */
    public int updateSysOrder(SysOrder sysOrder);

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的订单管理主键集合
     * @return 结果
     */
    public int deleteSysOrderByIds(String ids);

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理主键
     * @return 结果
     */
    public int deleteSysOrderById(Long id);
}
