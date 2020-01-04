package org.pioneercoders.dto.response;

import java.util.List;

public class ErrorDetail {

	public ErrorDetail() {

	}

	public ErrorDetail(int errorCategory) {
		this.errorCategory = errorCategory;
	}

	private int errorCategory;
	private List<Error> errors;

	public int getErrorCategory() {
		return errorCategory;
	}

	public void setErrorCategory(int errorCategory) {
		this.errorCategory = errorCategory;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
