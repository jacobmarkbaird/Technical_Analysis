
public class DataSet {
	private long timestamp;
	private String[] fields;
	private double[] values;
	public DataSet(String ticker) {
		timestamp = System.currentTimeMillis();
		fields = DataManager.getFields();
		values = DataManager.getValues(ticker, DataManager.currentTime());
	}
	public long getTimestamp() {
		return timestamp;
	}
	public String[] getFields() {
		return fields;
	}
	public double[] getValues() {
		return values;
	}
}
