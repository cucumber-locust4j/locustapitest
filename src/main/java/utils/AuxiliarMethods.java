package utils;

import cucumber.api.DataTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AuxiliarMethods {
	
	private static final Logger logger = LoggerFactory.getLogger(AuxiliarMethods.class);
	
	private static AuxiliarMethods _instance = new AuxiliarMethods();
	
	private AuxiliarMethods() {}
	
	public static AuxiliarMethods getInstance() {
		return _instance;
	}
	
    public String getDataTableValue(DataTable dataTable, String keyToSearch){   	
        String value = null;
        List<Map<String,String>> dataList = dataTable.asMaps(String.class, String.class);
        for (Map<String,String> row: dataList) {
        	for (Entry<String,String> entry : row.entrySet()) {
            if (entry.getKey().equals(keyToSearch)){
                value = entry.getValue();
            }
        	}
        }        
        if (value==null) {
        	logger.error("The key doesn't exists");
        }
        
        return value;
    }

}
