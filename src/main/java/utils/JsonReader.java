package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public String getTestData(String key) throws IOException, ParseException {
        return (String)getJsonData().get(key);
    }

    public JSONObject getJsonData() throws IOException, ParseException {

        // Pass testdata.json file
        File file = new File("resources/testData/testdata.json");

        // Convert json file to string
        String jsonData = FileUtils.readFileToString(file, "UTF-8");

        // Pass string to object
        Object obj = new JSONParser().parse(jsonData);

        // Give JSON object so that it can be returned to the function everytime it get called
        return (JSONObject) obj;
    }
}
