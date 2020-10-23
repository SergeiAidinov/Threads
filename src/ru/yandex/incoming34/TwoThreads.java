package ru.yandex.incoming34;

public class TwoThreads {
	private float[] array = null;
	private float[] firstPart = null;
	private float[] secondPart = null;
	private long startTime = 0;
	private long finishTime = 0;
	private long time = 0;
	private int cells;
	
	

	public TwoThreads() {
		array = MainClass.myData.getArr();
		firstPart = new float[MainClass.myData.H];
		secondPart = new float[MainClass.myData.H];
		cells = array.length / 2;

	}

	public void procedure() {
		System.out.println("Calculating began in two threads...");
		startTime = System.currentTimeMillis();
		System.arraycopy(array, 0, firstPart, 0, cells);
		System.arraycopy(array, MainClass.myData.H, secondPart, 0, cells);
		Calculation firstCalculation = new Calculation(firstPart, 0, "one");
		Calculation secondCalculation = new Calculation(secondPart, MainClass.myData.H, "     two");

	}

	

	public void finalizeTwoThreadsWork() {
		System.arraycopy(firstPart, 0, array, 0, cells);
		System.arraycopy(secondPart, 0, array, MainClass.myData.H, cells);
		finishTime = System.currentTimeMillis();
		time = finishTime - startTime;
		System.out.println("Finished! Two thread perfomance time: " + time + " ms.");
		MainClass.myData.setArrayFromTwoThreads(array);
		MainClass.myData.compareArrays();
	}

}
