package com.main.parser.bl;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.main.exception.FileException;
import com.main.model.Column;
import com.main.utilities.FileUtils;


public class FileParserBL {
		
	// Static variables or service to connect to DB
	
	
	//////////////////////////////////////////////////////////////////////////////
	
	public void parserFile (final File csvFile, final int limit, final float minValue, final OutputStream os) 
			throws FileException, IOException {
		
		List<List<Column>> listFromFile = FileUtils.transformCSVFileIntoList(csvFile, limit, minValue);
		
		// Workbook to parse
		final Workbook wb = new XSSFWorkbook();
		final Sheet sheet = wb.createSheet("Result");
		int rowNum = 0;
		int colNum = 0;
		Row row ;
		Cell cell;
		
		// We generate the output file
		for (List<Column> list : listFromFile) {
			row = sheet.createRow(rowNum);
			for (Column col: list) {
				cell = row.createCell(colNum);
				cell.setCellValue("C" + col.colNumber + ": " + col.getNumber());
				colNum++;
			}
			colNum = 0;
			rowNum++;
		}
		
		wb.write(os);
		
	}

	
}
