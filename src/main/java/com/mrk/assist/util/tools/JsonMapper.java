package com.mrk.assist.util.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper{
	private static ObjectMapper mapper=new ObjectMapper();
	public static String writeValueAssString(Object arg0) throws JsonProcessingException{
			return mapper.writeValueAsString(arg0);
	} 

}
