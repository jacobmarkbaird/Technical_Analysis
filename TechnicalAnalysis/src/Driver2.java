import org.json.JSONObject;

public class Driver2 {
	public static void main(String[] args) {
		String[] fields = {"function","symbol","interval","time_period","series_type"};
		String[] values = {"SMA","MSFT","1min","60","close"};
		String[] times = DataManager.allTimes("2018-01-29 10:43", "2018-01-29 11:33", 1);
		String[] qs = {"SMA"};
		String query = DataManager.queryBuilder(fields,values);
		JSONObject jobj = DataManager.toJSONObject(query);
		String[][] results = DataManager.jtsa(jobj, "Technical Analysis: SMA", times, qs);
		for(int i = 0; i < results.length; i++) {
			for(int j = 0; j < results[i].length; j++) {
				System.out.println(times[i] + ", " + qs[j] + ", " + results[i][j]);
			}
		}
	}
}
