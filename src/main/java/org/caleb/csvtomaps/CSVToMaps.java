package org.caleb.csvtomaps;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

import sun.misc.IOUtils;

public class CSVToMaps implements Closeable {
	CSVReader csvReader;
	
	public CSVToMaps(CSVReader csvReader) {
		this.csvReader = csvReader;
	}
	
	public List<Map<String, String>> parseCsv() throws IOException {
		try(CSVToMaps thingy = this) {
			Iterator<String[]> valuesIterator = csvReader.iterator();
			
			String[] keys;
			if(valuesIterator.hasNext() == false) throw new IOException("Could not parse as a CSV file because the file was empty"); 
			else keys = valuesIterator.next();
			
			List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
			valuesIterator.forEachRemaining((String[] item) -> {
				Map<String, String> map = new HashMap<String, String>();
				for(int i = 0; i < keys.length; i++) {
					if(i >= item.length) {
						map.put(keys[i], "");
					} else {
						map.put(keys[i], item[i]);
					}
				}
				maps.add(map);
			});
			return maps;
		} 
	}

	public String[] getHeaders() throws IOException {
		try (CSVToMaps thingy = this) {
			Iterator<String[]> valuesIterator = csvReader.iterator();

			String[] keys;
			if(valuesIterator.hasNext() == false) throw new IOException("Could not parse as a CSV file because the file was empty");
			else keys = valuesIterator.next();
			return keys;
		}
	}

	@Override
	public void close() throws IOException {
		csvReader.close();
	}
}