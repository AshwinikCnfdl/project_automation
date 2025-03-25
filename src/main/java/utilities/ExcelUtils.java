package utilities;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

public static Object[][] testData_excel(String path,String sheet_name ) throws Exception {
		
		//step1 :create file object 
		File excel_file = new  File(path);
		
		//step2:object File input stram
		FileInputStream fiStream = new FileInputStream(excel_file);
		
		//step3: Xssfworkbook object 
		XSSFWorkbook wb = new XSSFWorkbook(fiStream);
		
		//step4 : create a sheet 
		XSSFSheet sheet = wb.getSheet(sheet_name);
		
		// num of row and col
		int num_rows = sheet.getPhysicalNumberOfRows();
				
		//num col
		int num_col = sheet.getRow(0).getPhysicalNumberOfCells();
        Object [][] dataObjects = new Object[num_rows - 1][num_col];
		
		for(int row = 1 ; row < num_rows; row ++) {
			for(int col = 0 ; col < num_col ; col++) {
				
//				System.out.println(sheet.getRow(row).getCell(col).getStringCellValue());
				// get_data type
				XSSFCell  cell = sheet.getRow(row).getCell(col);
				if(cell!= null) {
					CellType cellType = cell.getCellType();
					
					 switch (cellType){
					 case STRING:
						 System.out.println(sheet.getRow(row).getCell(col).getStringCellValue());
						dataObjects [row -1] [col] =  sheet.getRow(row).getCell(col).getStringCellValue();
						 
						 break;
					 case NUMERIC:
						 dataObjects [row -1 ] [col] = sheet.getRow(row).getCell(col).getNumericCellValue();
						 System.out.println(sheet.getRow(row).getCell(col).getNumericCellValue());
						 break;
					 
					 default:
						 System.out.println(cellType);}

				}
				
			}
		}
		
		return dataObjects;
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		testData_excel("C:/Users/hp/IdeaProjects/demowebshop/Test_data/Test_data.xlsx","Reg");
	}
}