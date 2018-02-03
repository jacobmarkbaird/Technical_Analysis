
public class DailySet {
	private String ticker;
	private String[] fields = {
			"SMA_C", "SMA_O", "SMA_H", "SMA_L",
			"EMA_C", "EMA_O", "EMA_H", "EMA_L",
			"MACD_Signal_C","MACD_Signal_O","MACD_Signal_H","MACD_Signal_L",
			"MACD_C","MACD_O","MACD_H","MACD_L",
			"MACD_Hist_C","MACD_Hist_O","MACD_Hist_H","MACD_Hist_L",
			"STOCH_SlowK","STOCK_SlowD",
			"RSI_C", "RSI_O", "RSI_H", "RSI_L",
			"ADX_C", "ADX_O", "ADX_H", "ADX_L",
			"CCI_C", "CCI_O", "CCI_H", "CCI_L",
			"AROON_DOWN","AROON_UP",
			"RMB_C","RMB_O","RMB_H","RMB_L",
			"RUB_C","RUB_O","RUB_H","RUB_L",
			"RLB_C","RLB_O","RLB_H","RLB_L",
			"AD","OBV",
			"open","high","low","close","volume"};
	private double[][] values;
	public String getTicker() {
		return ticker;
	}
	public double[][] getValues() {
		return values;
	}
	public DailySet(String ticker, String day) {
		this.ticker = ticker;
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
		
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MACD",ticker,"1min","close"})), "Technical Analysis: MACD",
				times, new String[]{"MACD_Signal","MACD","MACD_Hist"});
		values[8] = temp[0];
		values[12] = temp[1];
		values[16] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MACD",ticker,"1min","open"})), "Technical Analysis: MACD",
				times, new String[]{"MACD_Signal","MACD","MACD_Hist"});
		values[9] = temp[0];
		values[13] = temp[1];
		values[17] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MACD",ticker,"1min","high"})), "Technical Analysis: MACD",
				times, new String[]{"MACD_Signal","MACD","MACD_Hist"});
		values[10] = temp[0];
		values[14] = temp[1];
		values[18] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","series_type"},
				new String[]{"MACD",ticker,"1min","low"})), "Technical Analysis: MACD",
				times, new String[]{"MACD_Signal","MACD","MACD_Hist"});
		values[11] = temp[0];
		values[15] = temp[1];
		values[19] = temp[2];
		
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval"},
				new String[]{"STOCH",ticker,"1min"})), "Technical Analysis: STOCH",
				times, new String[]{"SlowK","SlowD"});
		values[20] = temp[0];
		values[21] = temp[1];
		
		values[22] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"RSI",ticker,"1min","60","close"})), "Technical Analysis: RSI",
				times, new String[]{"RSI"})[0];
		values[23] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"RSI",ticker,"1min","60","open"})), "Technical Analysis: RSI",
				times, new String[]{"RSI"})[0];
		values[24] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"RSI",ticker,"1min","60","high"})), "Technical Analysis: RSI",
				times, new String[]{"RSI"})[0];
		values[25] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"RSI",ticker,"1min","60","low"})), "Technical Analysis: RSI",
				times, new String[]{"RSI"})[0];
		
		values[26] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"ADX",ticker,"1min","60","close"})), "Technical Analysis: ADX",
				times, new String[]{"ADX"})[0];
		values[27] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"ADX",ticker,"1min","60","open"})), "Technical Analysis: ADX",
				times, new String[]{"ADX"})[0];
		values[28] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"ADX",ticker,"1min","60","high"})), "Technical Analysis: ADX",
				times, new String[]{"ADX"})[0];
		values[29] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"ADX",ticker,"1min","60","low"})), "Technical Analysis: ADX",
				times, new String[]{"ADX"})[0];
		
		values[30] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"CCI",ticker,"1min","60","close"})), "Technical Analysis: CCI",
				times, new String[]{"CCI"})[0];
		values[31] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"CCI",ticker,"1min","60","open"})), "Technical Analysis: CCI",
				times, new String[]{"CCI"})[0];
		values[32] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"CCI",ticker,"1min","60","high"})), "Technical Analysis: CCI",
				times, new String[]{"CCI"})[0];
		values[33] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"CCI",ticker,"1min","60","low"})), "Technical Analysis: CCI",
				times, new String[]{"CCI"})[0];
		
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period"},
				new String[]{"AROON",ticker,"1min","60"})), "Technical Analysis: AROON",
				times, new String[]{"Aroon Down", "Aroon Up"});
		values[34] = temp[0];
		values[35] = temp[1];
		
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"BBANDS",ticker,"1min","60","close"})), "Technical Analysis: BBANDS",
				times, new String[]{"Real Middle Band","Real Upper Band","Real Lower Band"});
		values[36] = temp[0];
		values[40] = temp[1];
		values[44] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"BBANDS",ticker,"1min","60","open"})), "Technical Analysis: BBANDS",
				times, new String[]{"Real Middle Band","Real Upper Band","Real Lower Band"});
		values[37] = temp[0];
		values[41] = temp[1];
		values[45] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"BBANDS",ticker,"1min","60","high"})), "Technical Analysis: BBANDS",
				times, new String[]{"Real Middle Band","Real Upper Band","Real Lower Band"});
		values[38] = temp[0];
		values[42] = temp[1];
		values[46] = temp[2];
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","time_period","series_type"},
				new String[]{"BBANDS",ticker,"1min","60","low"})), "Technical Analysis: BBANDS",
				times, new String[]{"Real Middle Band","Real Upper Band","Real Lower Band"});
		values[39] = temp[0];
		values[43] = temp[1];
		values[47] = temp[2];
		
		values[48] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval"},
				new String[]{"AD",ticker,"1min"})), "Technical Analysis: Chaikin A/D",
				times, new String[]{"Chaikin A/D"})[0];
		
		values[49] = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval"},
				new String[]{"OBV",ticker,"1min"})), "Technical Analysis: OBV",
				times, new String[]{"OBV"})[0];
		
		String[] times2 = new String[times.length];
		for(int i = 0; i < times.length; i++) {
			times2[i] = times[i] + ":00";
		}
		temp = DataManager.jtsa(DataManager.toJSONObject(DataManager.queryBuilder(
				new String[]{"function","symbol","interval","outputsize"},
				new String[]{"TIME_SERIES_INTRADAY",ticker,"1min","full"})), "Time Series (1min)",
				times2, new String[]{"1. open","2. high","3. low","4. close","5. volume"});
		values[50] = temp[0];
		values[51] = temp[1];
		values[52] = temp[2];
		values[53] = temp[3];
		values[54] = temp[4];
		
		}
}
