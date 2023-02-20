package com.mini.money.service.impl;

import com.mini.money.dto.myinfo.UpdateInfoReqDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthServiceImplTest {

    @Autowired
    AuthServiceImpl authService;

    @Test
    void name() {
        String phone = "01012345687";
        String password = null;
        String email = "dong87070@naver.com";

        UpdateInfoReqDTO req = new UpdateInfoReqDTO(password, phone);

        System.out.println(authService.updateInfo(req, email));

    }
}