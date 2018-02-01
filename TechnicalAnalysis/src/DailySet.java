
public class DailySet {
	private String[] fields = {
			"SMA_C", "SMA_O", "SMA_H", "SMA_L",
			"EMA_C", "EMA_O", "EMA_H", "EMA_L",
			"WMA_C", "WMA_O", "WMA_H", "WMA_L",
			"DEMA_C", "DEMA_O", "DEMA_H", "DEMA_L",
			"TEMA_C", "TEMA_O", "TEMA_H", "TEMA_L"};
	private double[][] values;
	public DailySet(String ticker, String day) {
		String startTime = day + " 09:30";
		String endTime = day + " 16:00";
		String[] times = DataManager.allTimes(startTime, endTime, 1);
		values = new double[fields.length][];
		
		values[0] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"SMA",ticker,"1min","60","close"})), "Technical Analysis: SMA",
				times, new String[]{"SMA"})[0];
		values[1] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"SMA",ticker,"1min","60","open"})), "Technical Analysis: SMA",
				times, new String[]{"SMA"})[0];
		values[2] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"SMA",ticker,"1min","60","high"})), "Technical Analysis: SMA",
				times, new String[]{"SMA"})[0];
		values[3] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"SMA",ticker,"1min","60","low"})), "Technical Analysis: SMA",
				times, new String[]{"SMA"})[0];
		
		values[4] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"EMA",ticker,"1min","60","close"})), "Technical Analysis: EMA",
				times, new String[]{"EMA"})[0];
		values[5] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"EMA",ticker,"1min","60","open"})), "Technical Analysis: EMA",
				times, new String[]{"EMA"})[0];
		values[6] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"EMA",ticker,"1min","60","high"})), "Technical Analysis: EMA",
				times, new String[]{"EMA"})[0];
		values[7] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"EMA",ticker,"1min","60","low"})), "Technical Analysis: EMA",
				times, new String[]{"EMA"})[0];
		
		values[8] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"WMA",ticker,"1min","60","close"})), "Technical Analysis: WMA",
				times, new String[]{"WMA"})[0];
		values[9] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"WMA",ticker,"1min","60","open"})), "Technical Analysis: WMA",
				times, new String[]{"WMA"})[0];
		values[10] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"WMA",ticker,"1min","60","high"})), "Technical Analysis: WMA",
				times, new String[]{"WMA"})[0];
		values[11] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"WMA",ticker,"1min","60","low"})), "Technical Analysis: WMA",
				times, new String[]{"WMA"})[0];
		
		values[12] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"DEMA",ticker,"1min","60","close"})), "Technical Analysis: DEMA",
				times, new String[]{"DEMA"})[0];
		values[13] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"DEMA",ticker,"1min","60","open"})), "Technical Analysis: DEMA",
				times, new String[]{"DEMA"})[0];
		values[14] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"DEMA",ticker,"1min","60","high"})), "Technical Analysis: DEMA",
				times, new String[]{"DEMA"})[0];
		values[15] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"DEMA",ticker,"1min","60","low"})), "Technical Analysis: DEMA",
				times, new String[]{"DEMA"})[0];
		
		values[16] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"TEMA",ticker,"1min","60","close"})), "Technical Analysis: TEMA",
				times, new String[]{"TEMA"})[0];
		values[17] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"TEMA",ticker,"1min","60","open"})), "Technical Analysis: TEMA",
				times, new String[]{"TEMA"})[0];
		values[18] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"TEMA",ticker,"1min","60","high"})), "Technical Analysis: TEMA",
				times, new String[]{"TEMA"})[0];
		values[19] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"TEMA",ticker,"1min","60","low"})), "Technical Analysis: TEMA",
				times, new String[]{"TEMA"})[0];
	}
}
