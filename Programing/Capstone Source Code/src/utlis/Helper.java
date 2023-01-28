package utlis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Helper {

	public void toJson() {

	}

	public HashMap<String, Object> toHashMapTypeObject() {
		return null;
	}

	public static Logger getLogger(String className) {
		return Logger.getLogger(className);
	}

	public static String convertHashmapWithIteration(HashMap<String, Object> data) {
		StringBuilder mapAsString = new StringBuilder("{");
		for (String key : data.keySet()) {
			mapAsString.append(key + "=" + data.get(key) + ", ");
		}
		mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
		return mapAsString.toString();
	}

	public static BufferedReader handlerBuffer(HttpURLConnection connection) throws IOException {
		BufferedReader buffer;

		if (connection.getResponseCode() == 200) {
			buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} else {
			buffer = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		}
		return buffer;
	}

}
