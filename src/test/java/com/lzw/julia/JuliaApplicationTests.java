package com.lzw.julia;

import com.lzw.julia.dao.SysUserDao;
import com.lzw.julia.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class JuliaApplicationTests {

    @Autowired
    private SysUserDao sysUserDao;
    @Test
    void contextLoads() {
        SysUser admin = SysUser.builder().username("test1").nickname("xx").password("123456").creator("").createTime(new Date()).updateTime(new Date()).updater("").build();
        System.out.println(admin.getId());
        sysUserDao.insert(admin);
        System.out.println("id" + admin.getId());
    }

}
