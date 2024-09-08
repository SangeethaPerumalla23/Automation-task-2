package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSuppliers {
	

	@DataProvider(name="LoginData")
 public  String[][] method() throws IOException{
	 
	 File excel_file=new File("C:\\Users\\Sangeetha\\Desktop\\Facebook.xlsx\\");
	 FileInputStream fis= new  FileInputStream(excel_file);
	 XSSFWorkbook wb=new XSSFWorkbook(fis);
	 XSSFSheet sheet=wb.getSheet("Sheet1");
	 int Row_count=sheet.getPhysicalNumberOfRows();
	 int columns_count=sheet.getRow(0).getLastCellNum();
	 String[][] data=new String[Row_count-1][columns_count];
	
	 for (int i = 0; i < Row_count-1; i++) {
		 for (int j = 0; j < columns_count; j++) {
			DataFormatter df= new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			
			
			
		}
	 }
		 wb.close();
		 fis.close();
		 return data;
		 
		 
		
	}
	 
 }

