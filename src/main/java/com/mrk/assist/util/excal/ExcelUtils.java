package com.mrk.assist.util.excal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mrk
 *
 */
@Slf4j
public class ExcelUtils {

	/**
	 * 大数据导出一张excel表，按300000条数据分sheet 多sheet导出数据，限定每页数据不超过30000
	 */
	private static final int one_max = 300000;

	private static final int more_max = 30000;

	/**导出excel到浏览器
	 * @param response
	 * @param fileName
	 * @param excel
	 * @throws Exception
	 */
	public static void exportExcel(HttpServletResponse response, String fileName, PoiExcel excel) throws Exception {
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
		SXSSFWorkbook wb = createExlbyRowsOne(excel);
		writeExl(wb, response.getOutputStream());
	}
	
	/**创建exl
	 * @param excel
	 * @param fileName
	 */
	public static void createExlOne(PoiExcel excel,String fileName) {
		SXSSFWorkbook wb = createExlbyRowsOne(excel);
		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(fileName);
			writeExl(wb, fOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**创建单页excel
	 * @param excel
	 * @return
	 */
	public static SXSSFWorkbook createExlbyRowsOne(PoiExcel excel) {
		return createExlwb(null,excel,-1);
	}
	
	@SuppressWarnings("resource")
	public static SXSSFWorkbook createExlMore(List<PoiExcel> excels) throws Exception {
		SXSSFWorkbook wb = new SXSSFWorkbook(100);
		for(PoiExcel excel : excels) {
			if(excel.getRows().size()>more_max) {
				throw new Exception();
			}
		}
		for(int i=0;i<excels.size();i++) {
			createExlwb(wb,excels.get(i),i);
		}
		return wb;
	}
	
	/**创建SXSSFWorkbook
	 * @param excel
	 * @return
	 */
	public static SXSSFWorkbook createExlwb(SXSSFWorkbook wb,PoiExcel excel,int currunt) {
		if(null == wb) {
			wb = new SXSSFWorkbook(100);
		} 
		List<?> es = excel.getRows();
		Sheet sheet = null; // 工作表对象
		int rowNo = 0; // 总行号
		int pageRowNo = 0; // 页行号
		Row nRow = null; // 行对象
		Boolean flag = currunt == -1;
		for (int i = 0; i < es.size(); i++) {
			if (rowNo % one_max == 0) {
				sheet = flag?createSheet(excel.getName(), rowNo / one_max, wb):createSheet(excel.getName(), 0, wb); 
				sheet = flag?wb.getSheetAt(rowNo / one_max):wb.getSheetAt(currunt);
				pageRowNo = 1; 
				createTitle(sheet,0,excel.getColumnS());
			}
			rowNo++;
			nRow = sheet.createRow(pageRowNo++); // 新建行对象
			createnCell(nRow, es.get(i));
		}
		return wb;
	}
	
	/**创建titles
	 * @param sheet
	 * @param row
	 * @param titles
	 */
	public static void createTitle(Sheet sheet,int row,List<String> titles) {
		Row nRow = null; 
		nRow = sheet.createRow(row);
		for(int i=0;i<titles.size();i++) {
			nRow.createCell(i).setCellValue(titles.get(i)); 
		} 
	}
	
	/**写入文件
	 * @param wb
	 * @param fOut
	 */
	public static void writeExl(SXSSFWorkbook wb, OutputStream fOut) {
		try {
			wb.write(fOut);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**创建数据
	 * @param nRow
	 * @param obj
	 */
	public static void createnCell(Row nRow,Object obj) {
		Cell nCell = null;  
		Field[] fields = obj.getClass().getDeclaredFields();
		int cell =0;
		for(Field field : fields) {
			field.setAccessible(true); 
			nCell = nRow.createCell(cell);
			try {
				nCell.setCellValue(null==field.get(obj)?"":field.get(obj).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) { 
				e.printStackTrace();
			}
			cell++;
		}
	}

	/**
	 * 数据超过30000 设置页签名称
	 * @param name
	 * @param i
	 * @param wb
	 * @return
	 */
	public static Sheet createSheet(String name, int i, SXSSFWorkbook wb) {
		if (StringUtils.isEmpty(name)) {
			return wb.createSheet();
		}
		return wb.createSheet(i == 0 ? name : name + "(" + String.valueOf(i) + ")");
	}

}
