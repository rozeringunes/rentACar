package com.turkcell.rentACar1.core.utilities.exceptions.problemDetails;

public class BusinessProblemDetails  extends ProblemDetails{
    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("400");
    }
}
