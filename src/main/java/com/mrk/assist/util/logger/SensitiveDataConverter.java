package com.mrk.assist.util.logger; 

import org.apache.commons.lang3.StringUtils;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
	
public class SensitiveDataConverter extends MessageConverter{
	

	@Override
    public String convert(ILoggingEvent event){
        // 获取原始日志
        String oriLogMsg = event.getFormattedMessage();  
        return convertMsg(oriLogMsg);
	}
	 /**
     * 处理日志字符串，返回脱敏后的字符串
     * @param oriMsg
     * @return
     */
    public String convertMsg(final String oriMsg){
 
        String tempMsg = oriMsg;
        if (StringUtils.isNotBlank(tempMsg)){
            tempMsg = LoggerHandlerUtil.reHandler(tempMsg);
        }
        return tempMsg;
    } 
}
