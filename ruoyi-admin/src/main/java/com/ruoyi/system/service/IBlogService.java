package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Blog;

/**
 * 游玩日记管理Service接口
 * 
 * @author ruoyi
 * @date 2024-02-06
 */
public interface IBlogService 
{
    /**
     * 查询游玩日记管理
     * 
     * @param id 游玩日记管理主键
     * @return 游玩日记管理
     */
    public Blog selectBlogById(Long id);

    /**
     * 查询游玩日记管理列表
     * 
     * @param blog 游玩日记管理
     * @return 游玩日记管理集合
     */
    public List<Blog> selectBlogList(Blog blog);

    /**
     * 新增游玩日记管理
     * 
     * @param blog 游玩日记管理
     * @return 结果
     */
    public int insertBlog(Blog blog);

    /**
     * 修改游玩日记管理
     * 
     * @param blog 游玩日记管理
     * @return 结果
     */
    public int updateBlog(Blog blog);

    /**
     * 批量删除游玩日记管理
     * 
     * @param ids 需要删除的游玩日记管理主键集合
     * @return 结果
     */
    public int deleteBlogByIds(String ids);

    /**
     * 删除游玩日记管理信息
     * 
     * @param id 游玩日记管理主键
     * @return 结果
     */
    public int deleteBlogById(Long id);
}
