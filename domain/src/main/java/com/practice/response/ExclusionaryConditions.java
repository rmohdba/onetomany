package com.practice.response;

public class ExclusionaryConditions {

	private boolean errorsPresent;

	private Errors errors;

	public boolean isErrorsPresent() {
		return errorsPresent;
	}

	public void setErrorsPresent(boolean errorsPresent) {
		this.errorsPresent = errorsPresent;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

}
