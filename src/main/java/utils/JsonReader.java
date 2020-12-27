package utils;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReader {
	public Map<String, String> readJsonElementInOrder(String fileName, String elementName) throws Exception {
		String filePath = null;
		filePath = "C:/unified_sample_framework_workspace/APITest/src/test/resources/testData" + File.separator + fileName;
		JsonElement root = new JsonParser().parse(new FileReader(filePath));
		JsonObject jsonObject = root.getAsJsonObject();
		JsonElement some = jsonObject.get(elementName);
		JsonObject testData = some.getAsJsonObject();
		Map<String, String> testDataMap = new LinkedHashMap<String, String>();
		for (Map.Entry<String, JsonElement> entry : testData.entrySet()) {
			testDataMap.put(entry.getKey().toString(), entry.getValue().getAsString());
		}
		return testDataMap;
	}

}
