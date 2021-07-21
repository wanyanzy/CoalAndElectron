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
public class OfferPrice implements Serializable,Cloneable {
	Integer id;
	Byte enable;
	BigDecimal price;
	Integer amount;
	Integer userId;
	Integer bidId;
	String message;
}
