package com.volvo.vehiclemgmt.exceptions;

public class BusinessExceptionError extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	    private String errorMessage;

	    public BusinessExceptionError(Throwable throwable) {
	        super(throwable);
	    }

	    public BusinessExceptionError(String msg, Throwable throwable) {
	        super(msg, throwable);
	    }

	    public BusinessExceptionError(String msg) {
	        super(msg);
	    }

	    public BusinessExceptionError(String message, int errorCode) {
	        super();
	        this.errorCode = errorCode;
	        this.errorMessage = message;
	    }


	    public void setErrorCode(int errorCode) {
	        this.errorCode = errorCode;
	    }

	    public int getErrorCode() {
	        return errorCode;
	    }

	    public void setErrorMessage(String errorMessage) {
	        this.errorMessage = errorMessage;
	    }

	    public String getErrorMessage() {
	        return errorMessage;
	    }

	    @Override
	    public String toString() {
	        return this.errorCode + " : " + this.getErrorMessage();
	    }

}
