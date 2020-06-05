package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper groupMapper;
    @Autowired
    private SpecParamMapper specParamMapper;

    public List<SpecGroup> queryGroupByCid(Long cid) {
        SpecGroup group = new SpecGroup();
        group.setCid(cid);
        List<SpecGroup> list = groupMapper.select(group);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.SPEC_GROUP_NOT_FOUND);
        }
        return list;
    }

    public void addGroup(Map<String, Object> map) {
        SpecGroup group = new SpecGroup();
        group.setCid(Long.parseLong(map.get("cid").toString()));
        group.setName(map.get("name").toString());
        int count = groupMapper.insert(group);
        if (count != 1) {
            throw new LyException(ExceptionEnum.SPEC_GROUP_SAVE_ERROR);
        }
    }

    public void editGroup(Map<String, Object> map) {
        SpecGroup group = new SpecGroup();
        group.setId(Long.parseLong(map.get("id").toString()));
        group.setName(map.get("name").toString());
        group.setCid(Long.parseLong(map.get("cid").toString()));
        int count = groupMapper.updateByPrimaryKey(group);
        if (count != 1) {
            throw new LyException(ExceptionEnum.SPEC_GROUP_SAVE_ERROR);
        }
    }

    public void deleteGroup(Long id) {
        int count = groupMapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new LyException(ExceptionEnum.SPEC_GROUP_DELETE_ERROR);
        }
    }

    public List<SpecParam> queryParamList(Long gid, Long cid, Boolean searching) {
        SpecParam param = new SpecParam();
        param.setGroupId(gid);
        param.setCid(cid);
        param.setSearching(searching);
        List<SpecParam> list = specParamMapper.select(param);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.SPEC_PARAM_NOT_FOUND);
        }
        return list;
    }

    public List<SpecGroup> queryListByCid(Long cid) {
        // 查询规格组
        List<SpecGroup> specGroups = queryGroupByCid(cid);
        // 查询当前分类下的参数
        List<SpecParam> specParams = queryParamList(null, cid, null);

        // 先把规格参数变成map,map的key是规格组id,map的值是组下的所有参数
        Map<Long, List<SpecParam>> map = new HashMap<>();
        for (SpecParam param : specParams) {
            if (!map.containsKey(param.getGroupId())) {
                // 这个组id在map中不存在，新增一个List
                map.put(param.getGroupId(), new ArrayList<>());
            }
            map.get(param.getGroupId()).add(param);
        }
        // 填充param到group
        for (SpecGroup specGroup : specGroups) {
            specGroup.setParams(map.get(specGroup.getId()));
        }
        return specGroups;
    }
}
