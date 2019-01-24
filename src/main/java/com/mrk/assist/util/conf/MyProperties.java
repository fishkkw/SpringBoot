package com.mrk.assist.util.conf;

 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mrk.webassist.interceptor.TicketInterceptor;

@Configuration
@PropertySource(value = "classpath:my.properties")
@ConfigurationProperties(prefix = "com.web")
public class MyProperties {

	private String ticket;  
	private String ticketURL;
	private String ticketTime;
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketInterceptor.class);
	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		if(this.ticket ==null) {
			this.ticket = ticket;
		}
	}
	/**
	 * @return the ticketURL
	 */
	public String getTicketURL() {
		return ticketURL;
	}
	/**
	 * @param ticketURL the ticketURL to set
	 */
	public void setTicketURL(String ticketURL) {
		if(this.ticketURL==null) {
		this.ticketURL = ticketURL;
		}
	}
	/**
	 * @return the ticketTime
	 */
	public int getTicketTime() {
		try {
			return Integer.valueOf(ticketTime)*1000*60;
		} catch (Exception e) { 
			LOGGER.info("---my.properties:ticketTime----------------------------java.lang.NumberFormatException--"); 
		}
		return 60*1000*60;
	}
	/**
	 * @param ticketTime the ticketTime to set
	 */
	public void setTicketTime(String ticketTime) {
		if(this.ticketTime==null){
		this.ticketTime = ticketTime;
		}
	} 
	
	 
}
