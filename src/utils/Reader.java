package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    //method to read data and return the JSON object from a  json file
    public static JSONObject getJson(String name) {
        String jsonPath = System.getProperty("user.dir") + "\\src\\testdata\\files\\" + name + ".json";
        // "\\src\\testdata\\files\\mainuser.json"

        //read the json file from the specified location
        FileReader reader = null;
        try {
            reader = new FileReader(jsonPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //define the parser for the json content
        JSONParser jsonParser = new JSONParser();

        //define the JSONObject
        JSONObject obj = null;
        try {
            obj = (JSONObject) jsonParser.parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
