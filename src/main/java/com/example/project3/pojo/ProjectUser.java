package com.example.project3.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 橙鼠鼠
 */
@Data
@Accessors(chain = true)
public class ProjectUser implements Serializable,Cloneable {
	Integer id;
	Byte enable;
	String userName;
	String password;
	String role;
	String name;
	String tel;
	String department;
	Integer corporateId;
}
