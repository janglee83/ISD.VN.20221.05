package utlis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;

import business_layer.ReturnBike_BL;
import common.exception.CapstoneException;
import entity.bike.Bike;
import entity.bike.BikeType;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;
import provide.factory.BikeGenerate;
import provide.factory.StandardBikeFactory;
import provide.factory.StandardEBikeFactory;
import provide.factory.TwinBikeFactory;

public class Helper {

	private static final ReturnBike_BL returnBike_BL = new ReturnBike_BL();

	public static Logger getLogger(String className) {
		return Logger.getLogger(className);
	}

	public static String convertHashmapWithIteration(HashMap<String, Object> data) {
		StringBuilder mapAsString = new StringBuilder("{");
		for (String key : data.keySet()) {
			mapAsString.append(key + "=" + data.get(key) + ", ");
		}
		mapAsString.delete(mapAsString.length() - 2, mapAsString.length()).append("}");
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
		// get list bike type
        BikeType obj = new BikeType();
		obj.getEntityBikeType(obj);
		return obj.getNameBikeType(bikeType);
	}

	public static int getDepositeAmount(int bikeType) {
		switch (bikeType) {

			case StandardBike.BIKE_TYPE_VALUE:
				return 400000;
			case StandardEBike.BIKE_TYPE_VALUE:
				return 700000;
			case TwinBike.BIKE_TYPE_VALUE:
				return 550000;
			default:
				return 0;
		}
	}

	public static Bike createBike(int bikeType) {
		BikeGenerate bikeGenerate = new BikeGenerate();

		switch (bikeType) {
			case StandardBike.BIKE_TYPE_VALUE:
				bikeGenerate.setTypeBikeFactory(new StandardBikeFactory());
				return bikeGenerate.createBike();
			case StandardEBike.BIKE_TYPE_VALUE:
				bikeGenerate.setTypeBikeFactory(new StandardEBikeFactory());
				return bikeGenerate.createBike();
			case TwinBike.BIKE_TYPE_VALUE:
				bikeGenerate.setTypeBikeFactory(new TwinBikeFactory());
				return bikeGenerate.createBike();
			default:
				return null;
		}
	}

	public static void getListBikeType(BikeType bikeType) {
        try {
            returnBike_BL.getListBikeType(bikeType);
        } catch (SQLException e) {
            throw new CapstoneException(e.getMessage());
        }
	}


}
