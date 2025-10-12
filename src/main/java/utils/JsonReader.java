package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static String getTestData(String key) {
        return (String)getJsonData().get(key);
    }

    public static JSONObject getJsonData() {

        JSONObject jsonObject = null;

        try{
            // Pass testdata.json file
            File file = new File("resources/testData/testdata.json");

            // Convert json file to string
            String jsonData = FileUtils.readFileToString(file, "UTF-8");

            // Pass string to object
            Object obj = new JSONParser().parse(jsonData);

            // give JSON object so that it can be returned to the function everytime it get called
            jsonObject = (JSONObject) obj;

        } catch(IOException|ParseException e){
            e.printStackTrace();
        }

        return jsonObject;
    }
}
