package com.tommonkey.blog.sec;

import com.alibaba.dubbo.config.annotation.Service;
import com.tommonkey.blog.api.sec.ISecUserFSV;
import com.tommonkey.blog.sec.entity.SecUserEntity;
import com.tommonkey.blog.sec.service.interfaces.ISecUserSV;
import com.tommonkey.common.staticdata.StaticDataFactory;
import com.tommonkey.common.staticdata.entity.CfgStaticDataEntity;
import com.tommonkey.utils.common.JedisUtils;
import com.tommonkey.utils.common.JsonUtil;
import com.tommonkey.utils.response.Response;
import com.tommonkey.utils.sec.SessionManager;
import com.tommonkey.utils.sec.entity.UserInfoInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hyf on 2017/6/30.
 */
@Service
public class SecUserFSVImpl implements ISecUserFSV {

    @Autowired
    private ISecUserSV secUserSV;

    /**
     * 登陆校验
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public String login(Map param) throws Exception {
        List<SecUserEntity> restlutEntity=null;
        String userName = String.valueOf(param.get("username"));
        String password = String.valueOf(param.get("password"));
        try {
            SecUserEntity user = new SecUserEntity();
            user.setUserName(userName);
//            user.setPassword(K.j(password));//将密码加密后再去数据库匹配
            restlutEntity = secUserSV.findByEntity(user);
            if(restlutEntity!=null && restlutEntity.size() ==1){
            }else{
                throw new Exception("用户名不存在");
            }
        } catch (Exception e) {
            throw e;
        }
        return com.tommonkey.utils.common.JsonUtil.object2Json(restlutEntity);
    }

    /**
     * 初始化首页数据
     * @return
     * @throws Exception
     */
    @Override
    public String initIndexData(String param) throws Exception {
        Response response = new Response();
        try {
            //1.从redis中获取当前用户信息判断是否登陆，登陆走个人信息，未登陆，走公共博客
            UserInfoInterface userInfoInterface = SessionManager.getUser();
            if(userInfoInterface == null || userInfoInterface.getUserId() == null){
                List<CfgStaticDataEntity> staticList = StaticDataFactory.getCfgStaticData("INITINDEX");
                Long userId = 1000L;
                if(staticList!= null && staticList.size()>0){
                    userId = Long.parseLong(staticList.get(0).getCodeValue());
                }
                SecUserEntity userEntity = (SecUserEntity) secUserSV.findById(userId);
                userInfoInterface = JsonUtil.changeObject(userEntity,UserInfoInterface.class);
            }
            response.setCode(Response.SUCCESS);
            response.setData(userInfoInterface);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
        }
        return response.toString();

    }

    /**
     * 校验当前会话状态是否正常
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public String checkStatus(String param) throws Exception {
        Response response = new Response();
        try {
            //1.从redis中获取当前用户信息判断是否登陆，登陆走个人信息，未登陆，走公共博客
            UserInfoInterface userInfoInterface = SessionManager.getUser();
            String stateInfo = "1";
            if(userInfoInterface != null && userInfoInterface.getUserId() != null){
                 stateInfo = JedisUtils.get(userInfoInterface.getUserId()+"");

            }
            response.setCode(Response.SUCCESS);
            Map m = new HashMap();
            m.put("state",stateInfo);
            response.setData(m);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
        }
        return response.toString();
    }

    /**
     * 获取当前登陆用户
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public String getInLineUser(String param) throws Exception {
        Response response = new Response();
        try {
            UserInfoInterface userInfoInterface = SessionManager.getUser();
            List<UserInfoInterface> listUser = SessionManager.getInLine();
            response.setCode(Response.SUCCESS);
            response.setData(listUser);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
        }
        return response.toString();
    }

    /**
     * 剔除用户下线
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public String outLineUserBySessionId(String param) throws Exception {
        Response response = new Response();
        Map<String, Object> map = JsonUtil.json2Map(param);
        try {
            String sessionId = (String) map.get("sessionId");

            SessionManager.outLine(sessionId,0,0);
            response.setCode(Response.SUCCESS);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
        }
        return response.toString();
    }

    /**
     * 根据条件剔除用户下线并锁定或关闭当前页面
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public String outLineByConn(String param) throws Exception {
        return null;
    }



}
