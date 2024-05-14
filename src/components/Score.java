package components;

public class Score {

	private final int SCORE = 1000;
	private int sum = 0;
	private boolean flag;

	public int ScoreAll() {

		flag = true;
		new Thread(new Runnable() {
			int i = 1;

			@Override
			public void run() {
				while (flag) {
					sum = SCORE * i;
					System.out.println(sum);
					i++;

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				flag = false;
			}
		}).start();

		return (int) sum;
	}

}