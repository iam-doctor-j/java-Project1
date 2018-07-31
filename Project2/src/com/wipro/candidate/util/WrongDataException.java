package com.wipro.candidate.util;

@SuppressWarnings("serial")
public class WrongDataException extends Exception{

	@Override
	public String toString() {
		return "Data Incorrect";
	}

}
