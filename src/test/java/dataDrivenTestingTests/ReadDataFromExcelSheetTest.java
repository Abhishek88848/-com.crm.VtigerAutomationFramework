package dataDrivenTestingTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;




public class ReadDataFromExcelSheetTest 
{
	@Test
	public void readDataFromExcelSheetTest() throws EncryptedDocumentException, IOException
	{
		//step1: load the  excel file into file input stream
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//create workbook factory and load the file input stream object
		Workbook wb = WorkbookFactory.create(fise); // it will throws  2 exception one is EncryptedDocumentException  and another one is IOException and workbookFactory won't show until we
		                                            // add apache poi, apache poi ooxml dependencies.
		
		// navigate to sheet
		Sheet sh = wb.getSheet("Organizations"); 
		
		//navigate to row
		 Row row = sh.getRow(4); //row always start count from 0, from where we wrote at that pace 0 will start
		 
		 //nagivate to cell
		Cell cell = row.getCell(3); //cell will start to count the column from 0 from where we start to write from that 0 will start to count
		
		//get the value in String format from encrypted format
		String industryName = cell.getStringCellValue();
		System.out.println(industryName);
		 
		 
		
	}

}
