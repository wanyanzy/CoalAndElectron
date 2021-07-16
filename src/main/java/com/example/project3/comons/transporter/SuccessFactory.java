package com.example.project3.comons.transporter;

import org.springframework.stereotype.Component;

/**
 * @author 橙鼠鼠
 */
@Component
public class SuccessFactory extends TransporterFactory{
	private static final Transporter PROTOTYPE=new Transporter();

	static {
		PROTOTYPE.setDataList(new CloneableHashMap(DEFAULT_SIZE));
		PROTOTYPE.setCode(0);
	}

	@Override
	public Transporter getDeliverPackage (String check) throws CloneNotSupportedException{
		var trans = PROTOTYPE.getTrans();
		trans.getDataList().put("check",check);
		return trans;
	}
}
