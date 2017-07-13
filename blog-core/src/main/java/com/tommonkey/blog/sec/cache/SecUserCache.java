package com.tommonkey.blog.sec.cache;

import com.tommonkey.blog.sec.entity.SecUserEntity;
import com.tommonkey.blog.sec.service.interfaces.ISecUserSV;
import com.tommonkey.common.cache.DefaultCache;
import com.tommonkey.utils.sec.SecManage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hyf on 2017/7/1.
 */
public class SecUserCache extends DefaultCache {

    @Autowired
    private ISecUserSV userSV;


    @Override
    protected Map getData() throws Exception {
        Map retMap = new HashMap();
        SecUserEntity en = new SecUserEntity();
        en.setUserId(1000);
        List<SecUserEntity> secUserList = userSV.findByEntity(en);

//        List<SecUserEntity> secUserList =  userSV.getAllSecUser();
        if(secUserList!=null && secUserList.size()>0) {
            for (SecUserEntity userInfo : secUserList) {
                retMap.put(SecManage.SEC_USER_INFO+userInfo.getUserName(),userInfo);
            }
        }
        return retMap;
    }
}
