package com.example.customtablegeneratorproject;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.jackson.plugin.JacksonPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomCustomGeneratorProjectApplicationTests {

    @Test
    void contextLoads() {
        FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
                .plugin(new JacksonPlugin())
                .build();

        OrderSheet orderSheet = fixtureMonkey.giveMeOne(OrderSheet.class);
        fixtureMonkey.giveMe(OrderSheet.class, 3);
    }

}
