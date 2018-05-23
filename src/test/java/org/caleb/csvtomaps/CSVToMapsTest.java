package org.caleb.csvtomaps;

import static org.junit.Assert.*;

import java.io.InputStreamReader;
import java.util.*;

import org.junit.Test;

import com.opencsv.CSVReader;

public class CSVToMapsTest {
	public CSVReader getCSVReader(String file) {
		return new CSVReader(new InputStreamReader(CSVToMapsTest.class.getResourceAsStream(file)));
	}
	
	@Test
	public void csvToMap() throws Throwable {
		try(CSVToMaps csvToMaps = new CSVToMaps(getCSVReader("test1.csv"))) {
			List<Map<String, String>> maps = csvToMaps.parseCsv();
			assertEquals(1, maps.size());
			
			assertEquals("one", maps.get(0).get("first"));
			assertEquals("two", maps.get(0).get("second"));
		}
	}

	@Test
	public void headersTest() throws Throwable {
		try(CSVToMaps csvToMaps = new CSVToMaps(getCSVReader("test2.csv"))) {
			List<Map<String, String>> maps = csvToMaps.parseCsv();
			Map<String, String> row = maps.get(0);
			List<String> parsedList = new ArrayList<>(row.keySet());
			List<String> expectedList = new ArrayList<>();
			expectedList.add("header1");
			expectedList.add("header2");
			expectedList.add("header3");
			expectedList.add("header,4");
			expectedList.add("header5");
			assertEquals(expectedList, parsedList);
		}
	}
}
