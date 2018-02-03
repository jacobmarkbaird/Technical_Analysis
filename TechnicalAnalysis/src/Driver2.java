import org.json.JSONObject;

public class Driver2 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			long ct = System.currentTimeMillis();
			System.out.println(DataManager.getTicker(i));
			DailySet ds = new DailySet(DataManager.getTicker(i),"2018-02-01");
			System.out.println(""+(System.currentTimeMillis()-ct)/1000 + "s");
		}
	}
}