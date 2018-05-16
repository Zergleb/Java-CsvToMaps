package org.caleb.csvtomaps;

import static org.junit.Assert.*;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

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
			String[] headers = csvToMaps.getHeaders();
			assertEquals("header1", headers[0]);
			assertEquals("header2", headers[1]);
			assertEquals("header3", headers[2]);
			assertEquals("header,4", headers[3]);
			assertEquals("header5", headers[4]);
		}
	}
}
