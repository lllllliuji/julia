package com.lzw.julia.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void encoderTest() {
        String rawPassword = "123456";
        String result = passwordEncoder.encode(rawPassword);
        String result_1 = passwordEncoder.encode(rawPassword);

        /*
            同一个密码，两次encoder的结果不相同
            result: $2a$10$qK.cpgtenxvE8cQs5XpVRuOEu.vCwj2k2ItV1hOYZ.f/rtpRoCHSm
            result_1: $2a$10$WJeDOOJ9OKHNkYiEr00biemExgeYkd4IsvKEtcmgOA27lpd70PL9e
         */
        System.out.println(result);
        System.out.println(result_1);

        Assertions.assertTrue(passwordEncoder.matches(rawPassword, result));
        Assertions.assertTrue(passwordEncoder.matches(rawPassword, result_1));
    }
}
