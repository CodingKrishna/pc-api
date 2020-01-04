package org.pioneercoders.dto.response;

public class Response {

	private String status;
	private ErrorDetail errordetail;
	private boolean isSuccess;

	private Object response;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ErrorDetail getErrordetail() {
		return errordetail;
	}

	public void setErrordetail(ErrorDetail errordetail) {
		this.errordetail = errordetail;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", errordetail=" + errordetail
				+ ", isSuccess=" + isSuccess + ", response=" + response + "]";
	}

}
