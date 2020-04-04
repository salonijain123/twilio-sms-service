package com.devglan.springboothibernatelogin;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
@Service
public class SMSServiceTwilio implements SMSService{
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACe51cc8ea191455e8126f7570cd62bc4e";
    public static final String AUTH_TOKEN = "68fbdab94ccca585b8c70cbfc1ee6dcc";

    @Override
    public void sendSMS() {
    	try {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+918168493090"),
                new com.twilio.type.PhoneNumber("+12029523904"),
                "Teaching is The new learning")
           .create();
        System.out.println(message.getSid());
        
        
    	}
    	catch(ApiException e){
    		e.getMessage();
    	}
       
    
    
    	 
		
    	 
    	
    
}
}