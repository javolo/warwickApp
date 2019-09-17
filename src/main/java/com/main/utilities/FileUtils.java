package com.main.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

import com.main.exception.FileException;
import com.main.model.WarwickConstants;

public class FileUtils {

	// Method to translate the file into a list of Lenders
	public static List<BigDecimal> transformCSVFileIntoList(final File inputFile) throws FileNotFoundException, FileException{

		List<BigDecimal> result = new ArrayList<>();

		if (!FilenameUtils.getExtension(inputFile.getName()).equals("csv")){
			throw new FileException(WarwickConstants.INCORRECTFILEEXTENSION);
		} else {
			Scanner scanner = new Scanner(inputFile);
			
			// Variables used in the scan
			String line = scanner.nextLine();
			String[] fields;
			List<BigDecimal> rowNumbers;
			
			while(scanner.hasNextLine()){

				rowNumbers = new ArrayList<>();
				line = scanner.nextLine();
				fields = line.split(",");
				
				for (int i=0; i<fields.length; i++) {
					rowNumbers.add(new BigDecimal(fields[1]));
				}
				
			}
			scanner.close();
		}
		return result;
	}

}
