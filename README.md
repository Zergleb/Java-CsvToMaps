# Java-CsvToMaps
Tool to take csv files read them in and turn each row in to a map where the attributes are based on the top row of the column.

# Example

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
    
test1.csv

    first,second
    one,two

This is not hosted on maven central I just use https://jitpack.io/ for hosting.

    maven { url "https://jitpack.io" }
  
    compile 'com.github.Zergleb:Java-CsvToMaps:0.1.0' // You can see the releases in the releases tab.

