package com.main.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.main.exception.FileException;
import com.main.model.Column;

public class FileUtils {

	// Method to translate the file into a list of Column (column number, Big Decimal)
	public static List<List<Column>> transformCSVFileIntoList(final File inputFile, int limit, final float minValue) throws FileNotFoundException, FileException{

		List<List<Column>> result = new ArrayList<>();

		Scanner scanner = new Scanner(inputFile);

		// Variables used in the scan
		String line = scanner.nextLine();
		String[] fields;
		List<Column> rowNumbers;

		while(scanner.hasNextLine()){

			rowNumbers = new ArrayList<>();
			line = scanner.nextLine();
			fields = line.split(",");

			for (int i=1; i<fields.length; i++) {
				if (Float.parseFloat(fields[i]) > minValue) {
					rowNumbers.add(new Column(i, new BigDecimal(fields[i])));
				}
			}
			// We sort the list just obtained and we take only the first 3
			rowNumbers = rowNumbers.stream().sorted(Comparator.comparing(Column::getNumber).reversed()).collect(Collectors.toList());
			if (rowNumbers.size() > limit) {
				rowNumbers = rowNumbers.subList(0, limit);
			}
			// Only add to the output file if we found at least a number on the list that meet the criteria
			if (rowNumbers.size() > 0) {
				result.add(rowNumbers);
			}
		}
		scanner.close();

		return result;
	}

}
