import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class DataManager {
	private static String[] tickerList;
	public static final double ERROR_CODE = -64.0;
	public static int getTickerCount() {
		if(tickerList==null)
			updateTickerList();
		return tickerList.length;
	}
	public static String getTicker(int i) {
		if(tickerList==null)
			updateTickerList();
		return tickerList[i];
	}
	public static void updateTickerList() {
		try {
			FileReader fr = new FileReader("resources/nasdaqlistings.csv");
			BufferedReader br = new BufferedReader(fr);
			String inputLine=br.readLine();
			int tickerCount=0;
			while((inputLine=br.readLine())!=null) {
				tickerCount++;
			}
			tickerList = new String[tickerCount];
			br.close();
			fr.close();
			fr = new FileReader("resources/nasdaqlistings.csv");
			br = new BufferedReader(fr);
			inputLine = br.readLine();
			for(int i = 0; i < tickerCount; i++) {
				inputLine = br.readLine();
				Scanner sc = new Scanner(inputLine);
				sc.useDelimiter(",");
				String ticker = sc.next();
				tickerList[i] = ticker.substring(1, ticker.length()-1);
			}
		} catch(Exception e) {
			tickerList = null;
		}
	}
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
	public static double[][] jtsa(JSONObject obj, String name, String[] times, String[] values) {
		double[][] results = new double[times.length][values.length];
		try {
			JSONObject j2 = obj.getJSONObject(name);
			for(int i = 0; i < times.length; i++) {
				try {
					JSONObject j3 = j2.getJSONObject(times[i]);
					for(int j = 0; j < values.length; j++) {
						results[i][j] = Double.parseDouble(j3.getString(values[j]));
					}
				} catch (Exception e) {
					for(int j = 0; j < values.length; j++) {
						results[i][j] = ERROR_CODE;
					}
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
