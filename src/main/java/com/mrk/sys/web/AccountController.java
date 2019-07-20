package com.mrk.sys.web;
 
import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrk.assist.util.excal.ExcelUtils;
import com.mrk.assist.util.excal.PoiExcel;
import com.mrk.assist.util.redis.RedisUtil;
import com.mrk.sys.entity.Account;
import com.mrk.sys.entity.DfMoneyFile;
import com.mrk.sys.entity.Msg;
import com.mrk.sys.service.AccountService;
import com.mrk.sys.service.DfMoneyFileService;
@RestController
@RequestMapping("/account") 
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	@Qualifier("dfMoneyFileService")
	private DfMoneyFileService dfMoneyFileService;
	
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	
	/**导出excel
	 * @return
	 */
	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	public Msg excelOne() { 
		List<DfMoneyFile> es = dfMoneyFileService.selectByExample();
		PoiExcel excel = new PoiExcel();
		excel.setRows(es);
		excel.setName("aa");
		List<String> columnS = new ArrayList<>();
		columnS.add("第一行");
		columnS.add("第一行");
		columnS.add("第一行");
		columnS.add("第一行");
		columnS.add("第一行");
		excel.setColumnS(columnS);
		ExcelUtils.createExlOne(excel,"D:/excelOne.xlsx");
		return Msg.success();
	}
	
	/**导出excel
	 * @return
	 */
	@RequestMapping(value = "/excelMore", method = RequestMethod.GET)
	public Msg excelMore() { 
		List<DfMoneyFile> es = dfMoneyFileService.selectByExample();
		PoiExcel excel = new PoiExcel();
		excel.setRows(es);
		excel.setName("shtt111");
		List<String> columnS = new ArrayList<>();
		columnS.add("第一行");
		columnS.add("第一行");
		columnS.add("第一行");
		columnS.add("第一行");
		columnS.add("第一行");
		excel.setColumnS(columnS);
		List<PoiExcel> excels = new ArrayList<>();
		excels.add(excel);  
		PoiExcel excel2 = new PoiExcel();
		excel2.setRows(es);
		excel2.setName("shtt222");
		List<String> columnS2 = new ArrayList<>();
		columnS2.add("第一行");
		columnS2.add("第一行");
		columnS2.add("第一行");
		columnS2.add("第一行");
		columnS2.add("第一行");
		excel2.setColumnS(columnS2);
		excels.add(excel2); 
		ExcelUtils.createExlMore(excels, "D:/createExlMore.xlsx");
		return Msg.success();
	}
	
	/**日志安全
	 * @return
	 */
	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	public Msg logs() { 
		logger.info("\naaa\r\t13002963275"); 
		return Msg.success();
	}
	
	/**redis id
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Msg getAccount(@PathVariable("id")  Integer id,HttpServletRequest request) { 
		Account account = accountService.selectByPrimaryKey(id);
		redisUtil.set(account.getName(), account);
		return Msg.success();
	}

}
