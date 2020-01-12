package net.fion.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.fion.hashmap.CommonHashMap;

public class JsonJacksonMapMappingUtil {

	private static JSONParser jsonParser = new JSONParser();

	private static JSONArray readJsonFile(String filePath) {
		InputStream is = JsonJacksonMapMappingUtil.class.getResourceAsStream(filePath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
			return jsonArray;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void parseMatchType() {
		
		JSONArray jsonArray = readJsonFile("/matchtype.json");

		Iterator<JSONObject> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObj = iterator.next();
			String name = jsonObj.get("matchtype").toString();
			String content = (String) jsonObj.get("desc");
			if (content != null) {
				CommonHashMap.matchTypeHashMap.put(name, content.toString());
			}
		}
	}

}
