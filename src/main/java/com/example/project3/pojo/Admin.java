package com.example.project3.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 橙鼠鼠
 */
@Data
@Accessors(chain = true)
public class Admin implements Serializable {
	Integer id;
	Byte enable;
	String role;
	Integer level;
}
