import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataManager {
	public static String queryBuilder(String[] fields, String[] values) {
		String query = "https://www.alphavantage.co/query?";
		for(int i = 0; i < fields.length; i++) {
			String pair=fields[i]+"="+values[i]+"&";
			query+=pair;
		}
		query+="apikey=P57XDKMXBG29HRP0";
		return query;
	}
	public static JSONObject toJSONObject(String query) {
		try {
			URL obj = new URL(query);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent","Mozilla/5.0");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			JSONObject obj_JSONObject = new JSONObject(response.toString());
			return obj_JSONObject;
		} catch(Exception e) {
			return null;
		}
	}
	public static String[][] jtsa(JSONObject obj, String name, String[] times, String[] values) {
		String[][] results = new String[times.length][values.length];
		try {
			JSONObject j2 = obj.getJSONObject(name);
			for(int i = 0; i < times.length; i++) {
				JSONObject j3 = j2.getJSONObject(times[i]);
				for(int j = 0; j < values.length; j++) {
					results[i][j] = j3.getString(values[j]);
				}
			}
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String[] allTimes(String start, String end, int interval) {
		String firstPart = start.substring(0,11);
		int startHour = Integer.parseInt(start.substring(11,13));
		int startMinute = Integer.parseInt(start.substring(14));
		int endHour = Integer.parseInt(end.substring(11,13));
		int endMinute = Integer.parseInt(end.substring(14));
		int numTimes = ((endHour-startHour) * 60 + endMinute - startMinute) / interval + 1;
		String[] result = new String[numTimes];
		int ch = endHour, cm = endMinute;
		for(int i = 0; i < numTimes; i++) {
			String hs = ""+ch;
			if(hs.length()==1) hs = "0" + hs;
			String ms = ""+cm;
			if(ms.length()==1) ms = "0" + ms;
			result[i] = firstPart + hs + ":" + ms;
			cm--;
			if(cm==-1) {
				cm=59;
				ch--;
			}
		}
		return result;
	}
}
