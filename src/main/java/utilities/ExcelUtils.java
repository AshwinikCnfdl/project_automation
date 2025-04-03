package utilities;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static utilities.demo_utils.writing_data;

public class ExcelUtils {

	public static int[] get_num_rows_col(String file_path , String sheet_name) throws IOException {

		File excel_file = new  File(file_path);

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

		System.out.println(num_rows + " "  + num_col);
		int [] row_col = {num_rows - 1,num_col - 1};
		return row_col;

	}
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

	public static void writeData(String filePath,String sheetName,Object[][] data) {
			File file = new File(filePath);
			Workbook workbook = null;
			Sheet sheet;

			try {
				if (file.exists()) {
					FileInputStream fis = new FileInputStream(file);
					workbook = new XSSFWorkbook(fis);
					fis.close();
				} else {
					workbook = new XSSFWorkbook();
				}

				sheet = workbook.getSheet(sheetName);
				if (sheet == null) {
					sheet = workbook.createSheet(sheetName);
				}

				int rowCount = sheet.getLastRowNum();

				for (Object[] rowData : data) {
					Row row = sheet.createRow(++rowCount);
					for (int i = 0; i < rowData.length; i++) {
						Cell cell = row.createCell(i);

						// Type handling
						if (rowData[i] instanceof String) {
							cell.setCellValue((String) rowData[i]);
						} else if (rowData[i] instanceof Integer) {
							cell.setCellValue((Integer) rowData[i]);
						} else if (rowData[i] instanceof Double) {
							cell.setCellValue((Double) rowData[i]);
						} else if (rowData[i] instanceof Boolean) {
							cell.setCellValue((Boolean) rowData[i]);
						} else {
							cell.setCellValue(rowData[i] != null ? rowData[i].toString() : ""); // Default case
						}
					}
				}

				// Write output to file
				FileOutputStream fos = new FileOutputStream(file);
				workbook.write(fos);
				fos.close();
				workbook.close();

				System.out.println("Data written successfully to " + filePath);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		public static void updateCell(String filePath, String sheetName, int rowNum, int colNum, String result) throws Exception {
			FileInputStream fis = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			Row row = sheet.getRow(rowNum);
			if (row == null) {
				row = sheet.createRow(rowNum);
			}

			Cell cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
			}
			cell.setCellValue(result);

			fis.close();

			FileOutputStream fos = new FileOutputStream(new File(filePath));
			workbook.write(fos);
			fos.close();
			workbook.close();
		}



	public static void main(String[] args) throws Exception {
//		testData_excel("C:/Users/hp/IdeaProjects/demowebshop/Test_data/Test_data.xlsx","Reg");

		Object[][] data = {
				{"Name", "Age", "Score"},
				{"Alice", 25, 85.5},
				{"Bob", 30, 90},
				{"Charlie", 28, 88}
		};

		writing_data("./Test_data/Test_data.xlsx", "Sheet1", data);
}}