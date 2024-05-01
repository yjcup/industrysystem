package com.ruoyi.framework.web.service;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.system.domain.Exposition;
import com.ruoyi.system.mapper.ExpositionMapper;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysDictTypeService;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 * 
 * @author ruoyi
 */
@Service("dict")
public class DictService
{
    @Autowired
    private ISysDictTypeService dictTypeService;

    @Autowired
    private ISysDictDataService dictDataService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictData> getType(String dictType)
    {
        return dictTypeService.selectDictDataByType(dictType);
    }


    @Autowired
    private ExpositionMapper expositionMapper;

    public List<SysDictData> getExpType(){
        Exposition exposition = new Exposition();
        exposition.setStatus("1");
        List<Exposition> expositions = expositionMapper.selectExpositionList(exposition);
        List<SysDictData> list = new ArrayList<>();
        for(Exposition ex:expositions){
            SysDictData data = new SysDictData();
            data.setDictLabel(ex.getName());
            data.setDictValue(String.valueOf(ex.getId()));
            list.add(data);
        }
        return list;
    }




    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }
}
