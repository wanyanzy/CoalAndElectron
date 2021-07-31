package com.example.project3.comons.transporter;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author 橙鼠鼠
 */
@Component
public class SuccessFactory extends TransporterFactory {

	@Override
	public Transporter getDeliverPackage (String check) throws CloneNotSupportedException {
		Transporter transporter = new Transporter();
		transporter.setCode(0);
		transporter.setDataList(new HashMap<>(DEFAULT_SIZE));
		transporter.getDataList().put("check", check);
		return transporter;
	}
}
