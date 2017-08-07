package com.practice.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseParser {

	public ResponseHandler handleResponse(Object response) {
		ResponseHandler responseHandler = null;
		if (response instanceof Exception) {
			responseHandler = handleErrorResponse(response);
		}
		return responseHandler;
	}

	private ResponseHandler handleErrorResponse(Object response) {
		Exception exception = (Exception) response;
		ResponseHandler responseHandler = new ResponseHandler();
		ExclusionaryConditions conditions = new ExclusionaryConditions();
		conditions.setErrorsPresent(true);
		responseHandler.setExclusionaryConditions(conditions);
		Errors errors = new Errors();
		// errors.setDescription(exception.get);
		errors.setErrorCode(1001);
		errors.setErrorMessage(exception.getMessage());
		conditions.setErrors(errors);
		return responseHandler;
	}

}
