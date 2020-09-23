package com.example.api.model.exception;

import java.io.Serializable;

public class APIException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public APIException(){
		super();
	}

	public APIException(String msg){
		super(msg);
	}
	
	public APIException(String msg, Exception e){
		super(msg,e);
	}
	
	public APIException(Exception e){
		super(e);
	}
}