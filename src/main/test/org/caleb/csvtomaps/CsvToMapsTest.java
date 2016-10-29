package org.caleb.csvtomaps;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CsvToMapsTest {
	
	@Test
	public void testCanBeConstructed() {
		String csvData = "first, second\n" + 
				"one, two\n";

		List<Map<String, Object>> maps = new CsvToMaps().parseCsv(csvData);
		
		
	}

}
