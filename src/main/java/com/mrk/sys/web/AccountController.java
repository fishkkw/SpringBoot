package com.mrk.sys.web;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Msg getAccountName(@PathVariable("id")  Integer id,HttpServletRequest request) { 
		Account account = accountService.selectByPrimaryKey(id);
		//logger.info("\naaa\r\t13002963275");
		redisUtil.set("xxx", account); 
		logger.info(redisUtil.get("xxx").toString());
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
		ExcelUtils.createExlOne(excel,"D:/bigData111.xlsx");
		/*@SuppressWarnings("resource")
		SXSSFWorkbook wb = new SXSSFWorkbook(100);
		Sheet sheet = null; // 工作表对象
		Row nRow = null; // 行对象
		Cell nCell = null; // 列对象
		int rowNo = 0; // 总行号
		int pageRowNo = 0; // 页行号
		for(int i=0;i<es.size();i++) {
			if (rowNo % 300000 == 0) {
				System.out.println("当前sheet页为:" + rowNo / 300000 );
				sheet = wb.createSheet("我的第" + (rowNo / 300000 + 1) + "个工作簿");// 建立新的sheet对象
				sheet = wb.getSheetAt(rowNo / 300000); // 动态指定当前的工作表
				pageRowNo = 1; // 每当新建了工作表就将当前工作表的行号重置为1
				
			    //定义表头
			    nRow = sheet.createRow(0);
			    Cell cel0 = nRow.createCell(0);  
			    cel0.setCellValue("第一行");
			    Cell cel2 = nRow.createCell(1);  
			    cel2.setCellValue("第二行");  
			    Cell cel3 = nRow.createCell(2);  
			    cel3.setCellValue("第三行");  
			    Cell cel4 = nRow.createCell(3); 
			    cel4.setCellValue("第四行");
			    Cell cel5 = nRow.createCell(4); 
			    cel5.setCellValue("第五行");
			    Cell cel6 = nRow.createCell(5); 
			    cel6.setCellValue("第六行");
			}
			rowNo++;
			nRow = sheet.createRow(pageRowNo++); // 新建行对象
			DfMoneyFile dfMoneyFile = es.get(i); 
			System.out.println(dfMoneyFile.getComputeDate());
			String str =JSON.toJSONString(dfMoneyFile);
			JSONObject jsonObject = JSON.parseObject(str); 
			Map<String, Object> map = (Map<String, Object>) jsonObject;
			JSONArray array =JSONArray.parseArray(JSON.toJSONString(map.values()));
			for (int y = 0; y <array.size(); y++) {
				nCell = nRow.createCell(y);  
 				nCell.setCellValue(array.getString(i));
			}
			if (rowNo % 10000 == 0) {
				System.out.println("row no: " + rowNo);
			}
		} 
		
		try { 
			String excelFile = "D:/bigData111.xlsx"; 
			FileOutputStream fOut = new FileOutputStream(excelFile);//将数据写入Excel
			wb.write(fOut);
			fOut.flush(); // 刷新缓冲区
			fOut.close();
		} catch (Exception e) { 
		} */
		return Msg.success();
	}

}
