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
	Corporation seller;
	Corporation buyer;
	Byte firstPartIsSeller;
	BigDecimal offerBond;
	String contractUrl;
	String transport;
	BigDecimal transportFee;
}
