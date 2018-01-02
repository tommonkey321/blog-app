/**
 * $Id: SecManage.java,v 1.0 2016/8/26 13:49 zhangrp Exp $
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.sec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangrp
 * @version $Id: SecManage.java,v 1.1 2016/8/26 13:49 zhangrp Exp $
 *          Created on 2016/8/26 13:49
 */
public class SecManage {
    public static final String SEC_PRE = "sec_";
    public static final String OPER_CACHE_NAME = "UserInfoCache";
    public static final String SEC_USER_INFO = "secUserInfo_";
    public static final String OPER_FUNCTIONS = "operFunctions_";
    public static final String OPER_STATIONS = "operStations_";
    public static final String OPER_STATIONTYPES = "operStationTypes_";
    public static final String STATIONTYPE_STATIONS = "stationTypeStations_";
    public static final String STATION_OPERATORS = "stationOperators_";
    public static final String ORGANIZE_OPERATORS = "organizeOperators_";
    public static final String ORGANIZE_ORGANIZES = "organizeOrganizes_";

    public static final String BASE_STATION = "BASE_STATION_";

    /**
     * 根据操作员账号获取操作员信息
     * */
    public static com.tommonkey.utils.sec.entity.UserInfoInterface getUser(String code) {
        return (com.tommonkey.utils.sec.entity.UserInfoInterface) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + SEC_PRE + code);
    }

    /**
     * 根据操作员编号获取操作员默认岗位菜单信息
     * */
    public static List<com.tommonkey.utils.sec.entity.Function> getFunctionByOperId(Long operatorId){
        List<com.tommonkey.utils.sec.entity.Function> functions= null;
        Object obj = com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + OPER_FUNCTIONS + operatorId);
        if (obj != null && obj instanceof Map) {
            Map<Long, List<com.tommonkey.utils.sec.entity.Function>> opFuncMap = (Map)obj;
            Long stationId = (Long) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + BASE_STATION + operatorId);
            if (stationId!=null && opFuncMap.containsKey(stationId)) {
                functions = opFuncMap.get(stationId);
            } else {
                //取默认岗位，却没有默认岗位时，取第一个
                functions = (List<com.tommonkey.utils.sec.entity.Function>) opFuncMap.values().toArray()[0];
            }
        }
        return functions;
    }

    /**
     * 根据操作员编号获取操作员默认岗位
     * */
    public static Long getBaseStation(Long operatorId){
        return (Long) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + BASE_STATION + operatorId);
    }

    /**
     * 根据操作员编号及岗位获取操作员菜单信息
     * */
    public static List<com.tommonkey.utils.sec.entity.Function> getFunctionByOperId(Long operatorId, Long stationId) {
        List<com.tommonkey.utils.sec.entity.Function> functions = null;
        if (stationId == 0L) {
            //取默认岗位
            functions = getFunctionByOperId(operatorId);
        } else {
            Object obj = com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + OPER_FUNCTIONS + operatorId);
            if (obj != null && obj instanceof Map) {
                Map opFuncMap = (Map) obj;
                if (opFuncMap.containsKey(stationId)) {
                    functions = (List<com.tommonkey.utils.sec.entity.Function>) opFuncMap.get(stationId);
                }
            }
        }
        return functions;
    }

    /**
     * 根据操作员编号获取操作员岗位
     * */
    public static List<com.tommonkey.utils.sec.entity.Station> getStationByOperId(Long operatorId){
        return (List<com.tommonkey.utils.sec.entity.Station>) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + OPER_STATIONS + operatorId);
    }

    /**
     * 根据操作员编号获取操作员信息
     * */
    public static com.tommonkey.utils.sec.entity.Operator getOperatorByOperId(Long operatorId){
        //TODO
        return new com.tommonkey.utils.sec.entity.Operator();
    }

    /**
     *根据操作员编号获取岗位类型
     * */
    public static List<com.tommonkey.utils.sec.entity.StationType> getStationTypeByOperId(Long operatorId){
        List<com.tommonkey.utils.sec.entity.StationType> stationTypes = null;
        List<com.tommonkey.utils.sec.entity.Station> stations = (List<com.tommonkey.utils.sec.entity.Station>) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + OPER_STATIONS +operatorId);
        if (stations != null && stations.size() >0){
            stationTypes = new ArrayList<com.tommonkey.utils.sec.entity.StationType>();
            for (com.tommonkey.utils.sec.entity.Station station : stations) {
                com.tommonkey.utils.sec.entity.StationType stationType = new com.tommonkey.utils.sec.entity.StationType();
                stationType.setStationTypeId(station.getStationTypeId());
                stationType.setName(station.getStationTypeName());
                if (!stationTypes.contains(stationType)){
                    stationTypes.add(stationType);
                }
            }
        }
        return stationTypes;
    }

    /**
     * 根据岗位类型获取所有岗位
     * */
    public static List<com.tommonkey.utils.sec.entity.Station> getStationByStationType(Long stationTypeId){
        return (List<com.tommonkey.utils.sec.entity.Station>) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + STATIONTYPE_STATIONS + stationTypeId);
    }

    /**
     * 根据岗位获取所有操作员
     * */
    public static List<com.tommonkey.utils.sec.entity.Operator> getOperatorByStation(Long stationId){
        return (List<com.tommonkey.utils.sec.entity.Operator>) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + STATION_OPERATORS + stationId);
    }

    /**
     * 根据岗位类型获取所有操作员
     * */
    public static List<com.tommonkey.utils.sec.entity.Operator> getOperatorByStationType(Long stationTypeId){
        //TODO
        return null;
    }

    /**
     * 根据组织编号获取所有员工信息
     * */
    public static List<com.tommonkey.utils.sec.entity.Operator> getOperatorByOrgId(Long orgId){
        return (List<com.tommonkey.utils.sec.entity.Operator>) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + ORGANIZE_OPERATORS + orgId);
    }

    /**
     * 根据父组织编号获取所有组织信息
     * */
    public static List<com.tommonkey.utils.sec.entity.Organize> getOrganizeByParentOrgId(Long parentOrgId){
        return (List<com.tommonkey.utils.sec.entity.Organize>) com.tommonkey.utils.common.JedisUtils.getObject(OPER_CACHE_NAME + "_" + ORGANIZE_ORGANIZES + parentOrgId);
    }

}
