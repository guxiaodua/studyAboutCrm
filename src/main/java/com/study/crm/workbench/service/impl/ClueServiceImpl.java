package com.study.crm.workbench.service.impl;

import com.study.crm.utils.SqlSessionUtil;
import com.study.crm.workbench.dao.ClueDao;
import com.study.crm.workbench.domain.Clue;
import com.study.crm.workbench.service.ClueService;

public class ClueServiceImpl implements ClueService {

    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);

    public boolean save(Clue c) {

        boolean flag = true;

        int count = clueDao.save(c);

        if (count!=1){

            flag = false;

        }

        return flag;
    }
}
