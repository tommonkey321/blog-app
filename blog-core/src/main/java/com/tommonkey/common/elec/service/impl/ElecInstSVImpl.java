package com.tommonkey.common.elec.service.impl;

import com.tommonkey.common.elec.dao.IElecInstDao;
import com.tommonkey.common.elec.service.interfaces.IElecInstSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElecInstSVImpl implements IElecInstSV {
    @Autowired
    private IElecInstDao dao;
}