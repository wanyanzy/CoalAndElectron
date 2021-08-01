package com.example.project3.comons.transporter;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author 橙鼠鼠
 */
@Data
@NoArgsConstructor
@ApiModel("返回值")
@Scope("prototype")
public class Transporter{
	Integer code;
	HashMap<String,Object> dataList;

	public Transporter addData (String key, Object value) {
		this.getDataList().put(key, value);
		return this;
	}
}
