package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Product;

/**
 * 商品信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-06
 */
public interface ProductMapper 
{
    /**
     * 查询商品信息管理
     * 
     * @param id 商品信息管理主键
     * @return 商品信息管理
     */
    public Product selectProductById(Long id);

    /**
     * 查询商品信息管理列表
     * 
     * @param product 商品信息管理
     * @return 商品信息管理集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增商品信息管理
     * 
     * @param product 商品信息管理
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改商品信息管理
     * 
     * @param product 商品信息管理
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 删除商品信息管理
     * 
     * @param id 商品信息管理主键
     * @return 结果
     */
    public int deleteProductById(Long id);

    /**
     * 批量删除商品信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductByIds(String[] ids);
}
