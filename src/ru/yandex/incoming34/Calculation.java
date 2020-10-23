package ru.yandex.incoming34;

public class Calculation extends Thread {
	float[] myArray = null;
	private int initialArgument;
	String id = null;
	Thread myThread;
	Data myData;

	public Calculation(float[] myArray, int initArg, String str) {
		super();
		id = str;
		this.myArray = myArray;
		this.initialArgument = initArg;
		myThread = new Thread(this, str);
		myThread.start();

	}

	@Override
	public void run() {
		for (int i = 0; i < myArray.length; i++) {
			float currentValue = myArray[i];
			int argument = initialArgument + i;
			float newValue = (float) (currentValue * Math.sin(0.2f + argument / 5) * Math.cos(0.2f + argument / 5)
					* Math.cos(0.4f + argument / 2));
			myArray[i] = newValue;

		}
		MainClass.myData.checkWork();

	}
}
