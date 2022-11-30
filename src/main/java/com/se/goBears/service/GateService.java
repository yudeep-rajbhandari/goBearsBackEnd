package com.se.goBears.service;

import com.se.goBears.repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateService {

    @Autowired
    private GateRepository gateRepository;



}
