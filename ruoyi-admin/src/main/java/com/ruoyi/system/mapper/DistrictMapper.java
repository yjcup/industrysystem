package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.DistrictEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistrictMapper extends BaseMapper<DistrictEntity> {
    /**
     * Description: 查找省份
     * @return 省级城市列表
     */
    List<DistrictEntity> getProvinceList();

    /**
     * Description: 根据当前省份/城市 id(下级城市 parent_id) 查询下级城市列表
     * @param lId 省份/城市 id(下级城市 parent_id)
     * @return 下级城市列表
     */
    List<DistrictEntity> getCityListByParentId(int lId);
    /**
     * Description: 根据 id 查询城市详情
     * @param lId 城市 id
     * @return 城市详细信息
     */
    DistrictEntity getCityInfoById(int lId);
}
