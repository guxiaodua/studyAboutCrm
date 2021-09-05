package com.study.crm.workbench.service;

import com.study.crm.workbench.domain.Clue;

public interface ClueService {
    boolean save(Clue c);

    Clue detail(String id);

    boolean unbund(String id);

    boolean bund(String cid, String[] aids);
}
