package com.example.project3;

import com.example.project3.comons.transporter.SuccessFactory;
import com.example.project3.manager.BidManager;
import com.example.project3.pojo.Bid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest

class Project3ApplicationTests {

	@Autowired
	private SuccessFactory successFactory;

	@Autowired
	private BidManager bidManager;



	@Test
	void contextLoads () {
		try {
			var one = successFactory.getDeliverPackage("1");
			System.out.println(one.toString());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	@Test
	void test_bid () {
		Bid bid = bidManager.select(3);
		bid.setCoal("水洗煤");
		bidManager.update(bid);
	}

}
