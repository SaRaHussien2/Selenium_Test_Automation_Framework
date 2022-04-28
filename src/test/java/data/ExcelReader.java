package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fileSource = null ; 

	public FileInputStream getFileInputStream() 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/userData.xlsx"; 

		File srcFile = new File(filePath);

		try {
			fileSource = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
			System.exit(0);
		}
		return fileSource ; 
	}

	public Object[][] getExcelData() throws IOException
	{
		fileSource = getFileInputStream(); 
		XSSFWorkbook workBook = new XSSFWorkbook(fileSource);
		XSSFSheet sheet = workBook.getSheetAt(0); 

		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 5 ; 

		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 

		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}

		workBook.close();
		return arrayExcelData; 
	}
}
