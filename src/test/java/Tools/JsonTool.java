package Tools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

abstract public class JsonTool {

    public static JSONObject getRootJSONObject(String fileName) {
        JSONParser parser = new JSONParser();
        JSONObject rootJsonObject = null;
        try (FileReader reader = new FileReader("src/test/resources/" + fileName)) {
            rootJsonObject = (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return rootJsonObject;
    }

    public static Object[][] getJSONObjectByName(String fileName, String testCaseName) {
        JSONObject rootJsonObject = getRootJSONObject(fileName);
        JSONObject jsonObject = (JSONObject) rootJsonObject.get(testCaseName);
        return new Object[][]{{jsonObject}};
    }

    public static Object[][] getArrayOnObject(String fileName, String testCaseName) {
        List<String> list = new ArrayList<>();
        JSONArray languagesJsonArr = (JSONArray) getRootJSONObject(fileName).get(testCaseName);
        for (Object o : languagesJsonArr) {
            list.add(o.toString());
        }
        return new Object[][]{{list}};
    }

    public static List<String> strJsonToArray(String jsonStr) {
        jsonStr = jsonStr.replace("\\\"", "{quotationMarks}")
                .replace("\"", "")
                .replace("{quotationMarks}", "\"");
        jsonStr = removeFirstAndLastSymbol(jsonStr);
        List<String> list = new LinkedList<>(Arrays.asList(jsonStr.split(",")));
        return list;
    }

    public static HashMap<String, String> parseJsonObjectToHashMap(JSONObject jsonObject) {
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        Set jsonObjKeys = jsonObject.keySet();
        for (Object jsonObjKey : jsonObjKeys) {
            hashMap.put(jsonObjKey.toString(), jsonObject.get(jsonObjKey).toString());
        }
        return hashMap;
    }

    public static String removeFirstAndLastSymbol(String str) {
        return str.substring(1, str.length() - 1);
    }
}
