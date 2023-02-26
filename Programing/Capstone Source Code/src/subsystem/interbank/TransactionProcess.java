package subsystem.interbank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;

public class TransactionProcess {

	// connect
	private static final String PATCH = "PATCH";

	private static final String GET = "GET";

	private static final String POST = "POST";

	private static Logger LOGGER = utlis.Helper.getLogger(utlis.Helper.class.getName());

	public static String processTransaction(String payload) throws IOException {
		// // get payload
		// final String payload = utlis.Helper.convertHashmapWithIteration(body);

		//Start connect
		HttpURLConnection connection = generateConnection(utlis.Configs.URL, PATCH, null);
		Writer writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
		writer.write(payload);
		writer.close();

		BufferedReader bufferIn = utlis.Helper.handlerBuffer(connection);
		StringBuilder response = new StringBuilder();
		String inputLine;

		while ((inputLine = bufferIn.readLine()) != null) {
			response.append(inputLine);
		}
		bufferIn.close();
		LOGGER.info("Response Info: " + response.toString());
		return response.toString();
	}

	public static HashMap<String, Object> getBalance(HashMap<String, Object> body) {
		return null;
	}

	private static void processLogger(String url, String payload) {
		LOGGER.info("Request Info:\nRequest URL: " + url + "\n" + "Payload Data: " + payload + "\n");
	}

	private static HttpURLConnection generateConnection(String url, String requestMethod, String token) throws IOException {
		// setup conncection
		final var connection = (HttpURLConnection) turnStringIntoUrl(url).openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod(requestMethod);
		connection.setRequestProperty("Content-Type", "application/json");

		if (requestMethod.equals(GET) && token != null) {
			connection.setRequestProperty("Authorization", "Bearer " + token);
		}

		return connection;
	}

	private static URL turnStringIntoUrl(String stringUrl) throws MalformedURLException {
		final URL url = new URL(stringUrl);
		return url;
	}

}
