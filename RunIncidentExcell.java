package testNgAssignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RunIncidentExcell {
	public  String[][] readExcellData() throws IOException {
		

	XSSFWorkbook wb = new XSSFWorkbook("./ExcellData/IncidentExcell.xlsx");
	XSSFSheet sheet = wb.getSheet("sheet1");
	int rowcount = sheet.getLastRowNum();
	int columcount = sheet.getRow(0).getLastCellNum();
	String data[][] = new String[rowcount][columcount];
	System.out.println(rowcount);
	System.out.println(columcount);
	
	for(int i = 1; i<=rowcount;i++) {
		for(int j =0;j<columcount;j++) {
	String text = sheet.getRow(i).getCell(j).getStringCellValue();
	System.out.println(text);
	data[i-1][j]=text;}}
	wb.close();
	return data;

}}
