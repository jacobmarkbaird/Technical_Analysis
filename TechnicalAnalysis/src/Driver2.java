import org.json.JSONObject;

public class Driver2 {
	public static void main(String[] args) {
		long ct = System.currentTimeMillis();
		DailySet ds = new DailySet("MSFT","2018-02-01");
		System.out.println(""+(System.currentTimeMillis()-ct)/1000 + "s");
	}
}