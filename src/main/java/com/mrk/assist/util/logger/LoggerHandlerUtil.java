package com.mrk.assist.util.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class LoggerHandlerUtil { 

    private static final String mobile_regex = "(1[3-9])\\d{9}$";  
    private static final String sus_regex = "\n|\t|\r";
	private LoggerHandlerUtil() {
        throw new IllegalStateException("java IllegalStateException ");
    }
	
	/**
     * 手机号码保留前三位和后四位，其他隐藏<如:188******1234>
     * @param mobile 手机号
     * @return String
     */
    public static String mobileHandler(String mobile,String type){
 
        switch (type) {
		case mobile_regex:
			if (StringUtils.isNoneBlank(mobile)) {
	            mobile =mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
	        }
			break;

		default:
			break;
		}
        return mobile;
    }
    
    public static String reHandler(String msg) {  
    	String result = msg;
    	result = result.replaceAll(sus_regex, "_");
    	result = reHandlerUtilM(result,mobile_regex);
    	return result;
    }
    
    public static String reHandlerUtilM(String msg,String type) {
    	Pattern pattern = Pattern.compile(type); 
        Matcher matcher = pattern.matcher(msg); 
        StringBuffer sb = new StringBuffer() ;
        while(matcher.find()){ 
            String tmp = matcher.group() ;  
            String v = mobileHandler(tmp,type); 
            matcher.appendReplacement(sb, v) ;
            matcher.appendTail(sb) ;
            msg = sb.toString();
        } 
            return msg; 
    }

}
