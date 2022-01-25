package com.hidalgomarcelo.demotest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoTestApplicationTests {

    @Autowired
    private HomeController homeController;

    @Test
    void contextLoads() {
        Assertions.assertThat(homeController).isNotNull();
    }

}
