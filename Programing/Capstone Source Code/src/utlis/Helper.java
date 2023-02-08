package utlis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import entity.bike.Bike;
import entity.card.Card;

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

	public static String convertToStringBikeType(int bikeType) {
		switch (bikeType) {
			case Bike.STANDARD_BICYCLE_VALUE:
				return Bike.STANDARD_BICYCLE_STRING;
			case Bike.STANDARD_E_BIKE_VALUE:
				return Bike.STANDARD_E_BIKE_STRING;
			default:
				return Bike.TWIN_BIKE_STRING;
		}
	}

	public static int getDepositeAmount(int bikeType) {
		switch (bikeType) {
			case Bike.STANDARD_BICYCLE_VALUE:
				return 400000;
			case Bike.STANDARD_E_BIKE_VALUE:
				return 700000;
			default:
				return 550000;
		}
	}

}
