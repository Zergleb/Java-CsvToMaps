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
}
