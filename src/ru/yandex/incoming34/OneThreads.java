package ru.yandex.incoming34;

public class OneThreads {
	private float[] array = null;
	private long startTime = 0;
	private long finishTime = 0;
	private long time = 0;
	private Data myData = new Data();

	public OneThreads() {
		array = myData.getArr().clone();
	}

	public void procedure() {
		System.out.println("Calculating began in one thread...");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			float currentValue = array[i];
			float newValue = (float) (currentValue * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
					* Math.cos(0.4f + i / 2));
			array[i] = newValue;
		}
		finishTime = System.currentTimeMillis();
		time = finishTime - startTime;
		System.out.println("Finished! One thread perfomance time: " + time + " ms.");
		MainClass.myData.setArrayFromOneThread(array);

	}

}
