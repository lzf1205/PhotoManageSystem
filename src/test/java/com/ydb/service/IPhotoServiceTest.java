package com.ydb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPhotoServiceTest {

    @Autowired
    IPhotoService photoService;

    @Test
    public void dropPhoto() {
    }

    @Test
    public void updatePhoto() {
    }

    @Test
    public void queryPhoto() {
        photoService.queryPhoto();
    }
}