package com.demo.Swiggy;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Launch {

	public static void main(String[] args) {
		Map<Integer, String> restaurantdetail = new HashMap<Integer, String>();

		String path = "C:\\Users\\TAMIZHSELVI\\OneDrive\\Documents\\Bhuvana\\Java-Notes\\Excel-Swiggy\\RestaurantList.xlsx";
		try {
			FileInputStream inputstream = new FileInputStream(path);
			Workbook wb = new XSSFWorkbook(inputstream);
			Sheet sheet = wb.getSheet("List");
			Iterator<Row> rowiterator = sheet.iterator();
			while(rowiterator.hasNext())
			{
				String resname = null;
				int pin = 0;
				Row row = rowiterator.next();
				Iterator<Cell> celliterator = row.cellIterator(); 
				
				while(celliterator.hasNext())
				{
					Cell cell = celliterator.next();
					CellType ct = cell.getCellType();
					switch(ct)
					{
					case NUMERIC: 
						pin = (int) cell.getNumericCellValue();break;
						
					case STRING: 
						resname = cell.getStringCellValue();
					}
						restaurantdetail.put(pin,resname );				
					
				}
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Input output exception");
		}
		 Set set=restaurantdetail.entrySet();//Converting to Set so that we can traverse  
		    Iterator itr=set.iterator();  
		    while(itr.hasNext()){  
		        //Converting to Map.Entry so that we can get key and value separately  
		        Map.Entry entry=(Map.Entry)itr.next();  
		        System.out.println(entry.getKey()+" "+entry.getValue());  
	}

}
}
