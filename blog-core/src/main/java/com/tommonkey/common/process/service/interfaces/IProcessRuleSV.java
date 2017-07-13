package com.tommonkey.common.process.service.interfaces;

import com.tommonkey.common.process.entity.CfgTaskInsEntity;

/**
 * Created by dizl on 2017/2/20.
 */
public interface IProcessRuleSV {
    public boolean validate(CfgTaskInsEntity taskInsEntity, String ruleParam,String ruleValue) throws Exception;
}
