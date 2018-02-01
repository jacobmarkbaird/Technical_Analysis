
public class DailySet {
	private String[] fields = {
			"SMA_C", "SMA_O", "SMA_H", "SMA_L",
			"EMA_C", "EMA_O", "EMA_H", "EMA_L",
			"WMA_C", "WMA_O", "WMA_H", "WMA_L",
			"DEMA_C", "DEMA_O", "DEMA_H", "DEMA_L",
			"TEMA_C", "TEMA_O", "TEMA_H", "TEMA_L",
			"TRIMA_C", "TRIMA_O", "TRIMA_H", "TRIMA_L",
			"KAMA_C", "KAMA_O", "KAMA_H", "KAMA_L",
			"MAMA_C", "MAMA_O", "MAMA_H", "MAMA_L",
			"FAMA_C", "FAMA_O", "FAMA_H", "FAMA_L",
			"T3_C", "T3_O", "T3_H", "T3_L",
			"MACD_Signal_C","MACD_Signal_O","MACD_Signal_H","MACD_Signal_L",
			"MACD_C","MACD_O","MACD_H","MACD_L",
			"MACD_Hist_C","MACD_Hist_O","MACD_Hist_H","MACD_Hist_L"};
	private double[][] values;
	public DailySet(String ticker, String day) {
		String startTime = day + " 09:30";
		String endTime = day + " 16:00";
		String[] times = DataManager.allTimes(startTime, endTime, 1);
		values = new double[fields.length][];
		double[][] temp;
		
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
		
		values[16] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"TRIMA",ticker,"1min","60","close"})), "Technical Analysis: TRIMA",
				times, new String[]{"TRIMA"})[0];
		values[17] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"TRIMA",ticker,"1min","60","open"})), "Technical Analysis: TRIMA",
				times, new String[]{"TRIMA"})[0];
		values[18] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"TRIMA",ticker,"1min","60","high"})), "Technical Analysis: TRIMA",
				times, new String[]{"TRIMA"})[0];
		values[19] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"TRIMA",ticker,"1min","60","low"})), "Technical Analysis: TRIMA",
				times, new String[]{"TRIMA"})[0];
		
		values[20] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"KAMA",ticker,"1min","60","close"})), "Technical Analysis: KAMA",
				times, new String[]{"KAMA"})[0];
		values[21] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"KAMA",ticker,"1min","60","open"})), "Technical Analysis: KAMA",
				times, new String[]{"KAMA"})[0];
		values[22] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"KAMA",ticker,"1min","60","high"})), "Technical Analysis: KAMA",
				times, new String[]{"KAMA"})[0];
		values[23] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"KAMA",ticker,"1min","60","low"})), "Technical Analysis: KAMA",
				times, new String[]{"KAMA"})[0];
		
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MAMA",ticker,"1min","close"})), "Technical Analysis: MAMA",
				times, new String[]{"MAMA","FAMA"});
		values[24] = temp[0];
		values[28] = temp[1];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MAMA",ticker,"1min","open"})), "Technical Analysis: MAMA",
				times, new String[]{"MAMA","FAMA"});
		values[25] = temp[0];
		values[29] = temp[1];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MAMA",ticker,"1min","high"})), "Technical Analysis: MAMA",
				times, new String[]{"MAMA","FAMA"});
		values[26] = temp[0];
		values[30] = temp[1];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MAMA",ticker,"1min","low"})), "Technical Analysis: MAMA",
				times, new String[]{"MAMA","FAMA"});
		values[27] = temp[0];
		values[31] = temp[1];
		
		values[32] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"T3",ticker,"1min","60","close"})), "Technical Analysis: T3",
				times, new String[]{"T3"})[0];
		values[33] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"T3",ticker,"1min","60","open"})), "Technical Analysis: T3",
				times, new String[]{"T3"})[0];
		values[34] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"T3",ticker,"1min","60","high"})), "Technical Analysis: T3",
				times, new String[]{"T3"})[0];
		values[35] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"T3",ticker,"1min","60","low"})), "Technical Analysis: T3",
				times, new String[]{"T3"})[0];
		
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MACD",ticker,"1min","close"})), "Technical Analysis: MACD",
				times, new String[]{"MACD_Signal","MACD","MACD_Hist"});
		values[36] = temp[0];
		values[40] = temp[1];
		values[44] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MACD",ticker,"1min","open"})), "Technical Analysis: MACD",
				times, new String[]{"MACD_Signal","MACD","MACD_Hist"});
		values[37] = temp[0];
		values[41] = temp[1];
		values[45] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MACD",ticker,"1min","high"})), "Technical Analysis: MACD",
				times, new String[]{"MACD_Signal","MACD","MACD_Hist"});
		values[38] = temp[0];
		values[42] = temp[1];
		values[46] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MACD",ticker,"1min","low"})), "Technical Analysis: MACD",
				times, new String[]{"MACD_Signal","MACD","MACD_Hist"});
		values[39] = temp[0];
		values[43] = temp[1];
		values[47] = temp[2];
	}
}
