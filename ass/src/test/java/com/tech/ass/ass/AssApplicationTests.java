package com.tech.ass.ass;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=AssApplication.class)
@ActiveProfiles("")
public  abstract class AssApplicationTests {

	protected Logger logger= LoggerFactory.getLogger(this.getClass());

}
