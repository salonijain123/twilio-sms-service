package com.devglan.springboothibernatelogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;



@RestController
public class GreetingController {

	@Autowired
	private SMSService smsService;

	@RequestMapping(value = "/")
	public String sendSMS1() {
		smsService.sendSMS();
		return "sendSMS1";
	
	}
}
