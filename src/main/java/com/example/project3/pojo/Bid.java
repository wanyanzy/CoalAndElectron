package com.example.project3.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 橙鼠鼠
 */
@Accessors(chain = true)
@Data
public class Bid implements Cloneable, Serializable {
	Integer id;
	Byte enable;
	Integer corporateId;
	Integer amount;
	BigDecimal price;
	String coal;
	String transportWay;
	BigDecimal transportFee;
	String address;
	BigDecimal offerBond;
	BigDecimal performBond;
	String message;
	Double qnetar;
	Double mt;
	Double aar;
	Double varHigh;
	Double varLow;
	Double star;
	Double st;
	Double hgi;
	Double grain;
	Double fc;
	Double g;
	Double y;
	Double sodiumBasicOxide;
}
