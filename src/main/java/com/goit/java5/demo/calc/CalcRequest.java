package com.goit.java5.demo.calc;

import lombok.Data;

@Data
public class CalcRequest {
	private String operation;
	private int param1;
	private int param2;
}
