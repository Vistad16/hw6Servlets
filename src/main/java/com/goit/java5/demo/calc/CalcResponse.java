package com.goit.java5.demo.calc;

import lombok.Data;

@Data
public class CalcResponse {
	private CalcRequest request;

	private int result;
}
