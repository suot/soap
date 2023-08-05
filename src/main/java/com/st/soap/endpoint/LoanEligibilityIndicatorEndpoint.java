package com.st.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.st.loaneligibility.Acknowledgement;
import com.st.loaneligibility.CustomerRequest;
import com.st.soap.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {
    private static final String NAMESPACE = "http://www.st.com/loanEligibility";

    @Autowired
    LoanEligibilityService loanEligibilityService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request){
        return loanEligibilityService.checkLoanEligibility(request);
    }
}
