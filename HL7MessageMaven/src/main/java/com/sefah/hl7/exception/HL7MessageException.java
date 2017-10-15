package com.sefah.hl7.exception;

import java.text.MessageFormat;

public class HL7MessageException extends Exception {

	private static final long serialVersionUID = -3583645039772320922L;
	private final String errorCode;
	private final String errorMsg;
	private final StackTraceElement[] stackTrace;

	public HL7MessageException(HL7MessageErrorCode code) {
		this.errorMsg = code.getDescription();
		this.errorCode = code.getCode();
		this.stackTrace = Thread.currentThread().getStackTrace();
	}

	public HL7MessageException(HL7MessageErrorCode code, Object ... string) {
		this.errorMsg = MessageFormat.format(code.getDescription(), string);
		this.errorCode = code.getCode();

		this.stackTrace = Thread.currentThread().getStackTrace();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}
	
	public String getError() {
		StringBuilder sb = new StringBuilder();
		sb.append(errorMsg);
		
		if (stackTrace != null) {
			for (int i = 2; i < stackTrace.length; i++) {
				sb.append("\n").append("\t").append(stackTrace[i]);
			}
		} else {
			sb.append("\n").append("\t").append("<No Stacktrace available>");
		}

		return sb.toString();
	}
}
