
public class Driver {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		double[] d = DataManager.getValues("MSFT", "2018-01-31 15:30");
		for(int i = 0; i < 40; i++) {
			System.out.println(DataManager.getFields()[i/4] + ", " + d[i]);
		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime)/1000);
	}
}
