package com.biazinsistemas.biazinmc.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer StatusHttpError;
	private String msgError;
	private String data;

	public StandardError(Integer statusHttpError, String msgError, String timeStamp) {
		super();
		StatusHttpError = statusHttpError;
		this.msgError = msgError;
		this.data = timeStamp;
	}

	public Integer getStatusHttpError() {
		return StatusHttpError;
	}

	public void setStatusHttpError(Integer statusHttpError) {
		StatusHttpError = statusHttpError;
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	public String getTimeStamp() {
		return data;
	}

	public void setTimeStamp(String timeStamp) {
		this.data = timeStamp;
	}

}
