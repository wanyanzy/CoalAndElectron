package com.example.project3.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 橙鼠鼠
 */
@Data
@Accessors(chain = true)
public class Order implements Serializable {
	Integer id;
	Byte enable;
	BigDecimal price;
	Integer amount;
	Integer sellerId;
	Integer buyerId;
	Byte firstPartIsSeller;
	BigDecimal offerBond;
	BigDecimal performBond;
	String contractUrl;
	String transportWay;
	BigDecimal transportFee;
}
