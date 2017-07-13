package com.tommonkey.common.id.cache;

import com.tommonkey.common.cache.DefaultCache;
import com.tommonkey.common.id.IdGeneratorFactory;
import com.tommonkey.common.id.entity.IdGeneratorEntity;
import com.tommonkey.common.id.service.interfaces.IIdGeneratorSV;
import com.tommonkey.utils.common.SpringContextHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dizl on 2015/6/11.
 */
public class IdGeneratorCache extends DefaultCache {
    public static final String CACHE_NAME = "IdGeneratorCache";

    @Override
    protected Map getData() throws Exception {
        Map<String, IdGeneratorEntity> map = new HashMap<String, IdGeneratorEntity>();
        IIdGeneratorSV idGeneratorSV = SpringContextHolder.getBean(IIdGeneratorSV.class);
        List<IdGeneratorEntity> idGeneratorEntitieList = idGeneratorSV.getAllIdGeneratorEntity();
        if (idGeneratorEntitieList != null && idGeneratorEntitieList.size() > 0) {
            for (IdGeneratorEntity idGeneratorEntity : idGeneratorEntitieList) {
                map.put(idGeneratorEntity.getTableName(), idGeneratorEntity);
            }
            //系统初始化时，加载主键
            IdGeneratorFactory.loadNewId(idGeneratorEntitieList);
        }

        return map;
    }
}
