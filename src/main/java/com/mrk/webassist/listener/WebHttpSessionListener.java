package com.mrk.webassist.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
import com.mrk.webassist.filter.WebFilter;
 

/**
 * @author mrk
 *
 */
@Component
public class WebHttpSessionListener implements HttpSessionListener{
	public static int online = 0;
	private static final Logger LOGGER = LoggerFactory.getLogger(WebFilter.class);
    @Override
    public void sessionCreated(HttpSessionEvent se) { 
    	LOGGER.info("[--------创建session----------]"+new Date().toString());
        online ++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    	LOGGER.info("[--------销毁session----------]"+new Date().toString());
    	online --;
    }
    

}
