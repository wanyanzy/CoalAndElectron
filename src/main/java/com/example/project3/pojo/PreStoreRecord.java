package com.example.project3.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author 橙鼠鼠
 */
@Data
@Accessors(chain = true)
public class PreStoreRecord implements Serializable{
	Integer id;
	Byte enable;
	BigDecimal money;
	Date date;
	String proofUrl;
	Integer corporateId;
}
