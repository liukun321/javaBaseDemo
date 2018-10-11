package com.lk.java.common.utils.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.lk.java.common.utils.StringUtils;

public class ExportExcel<T> implements Runnable{
	
	private Map<String, String> maps;
	private List<T> list;
	private File file;
	private String sheetName;
	private Workbook wb;
	
	public ExportExcel(Map<String, String> maps, List<T> list, File file, String sheetName, Workbook wb) {
		super();
		this.maps = maps;
		this.list = list;
		this.file = file;
		this.sheetName = sheetName;
		this.wb = wb;
	}

	@Override
	public void run() {
		System.out.println("----------" + Thread.currentThread().getName() + "--------" + sheetName);
		try {
			CreationHelper createHelper = wb.getCreationHelper();
			Sheet sheet = wb.createSheet(sheetName);
			Set<String> sets = maps.keySet();
			Row row = sheet.createRow(0);
			int i = 0;
			// 定义表头
			for (Iterator<String> it = sets.iterator(); it.hasNext();) {
				String key = it.next();
				Cell cell = row.createCell(i++);
				cell.setCellValue(createHelper.createRichTextString(maps.get(key)));
			}
			for (int j = 0; j < list.size(); j++) {
				T p = list.get(j);
				Class classType = p.getClass();
				int index = 0;
				Row row1 = sheet.createRow(j + 1);
				for (Iterator<String> it = sets.iterator(); it.hasNext();) {
					String key = it.next();
					String firstLetter = key.substring(0, 1).toUpperCase();
					// 获得和属性对应的getXXX()方法的名字
					String getMethodName = "get" + firstLetter + key.substring(1);
					// 获得和属性对应的getXXX()方法
					Method getMethod = classType.getMethod(getMethodName, new Class[] {});
					// 调用原对象的getXXX()方法
					Object value = getMethod.invoke(p, new Object[] {});
					Cell cell = row1.createCell(index++);
					if (!StringUtils.isNull(value))
						cell.setCellValue(value.toString());
				}
			}
			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			fileOut.close();
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IOException e) {
			
		}
		
	}
}
