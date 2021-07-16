package com.example.project3;

import com.example.project3.comons.transporter.SuccessFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Project3ApplicationTests {

	@Autowired
	private SuccessFactory successFactory;

	@Test
	void contextLoads () {
		try {
			var one = successFactory.getDeliverPackage("1");
			System.out.println(one.toString());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
