package ru.yandex.incoming34;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Data {

	private final float VAL = 1;
	private final int SIZE = 1_000_000;
	final int H = SIZE / 2;
	private float[] arr = null;
	private float[] arrayFromOneThread = null;

	private float[] arrayFromTwoThreads = null;
	AtomicInteger threadFinished = new AtomicInteger(0);

	Data() {
		initArray();
	}

	float[] getArr() {
		return arr;
	}

	public void initArray() {
		arr = new float[SIZE];
		Arrays.fill(arr, VAL);
	}

	public void setArrayFromOneThread(float[] arrayFrom1Thread) {
		arrayFromOneThread = arrayFrom1Thread;
	}

	public void setArrayFromTwoThreads(float[] arrayFrom2Threads) {
		arrayFromTwoThreads = arrayFrom2Threads;
	}

	public synchronized void checkWork() {
		threadFinished.incrementAndGet();
		if (threadFinished.intValue() == 2) {
			MainClass.myTwoThreads.finalizeTwoThreadsWork();
		}

	}

	public void compareArrays() {
		System.out.println("Comparing results...");
		if (Arrays.equals(arrayFromOneThread, arrayFromTwoThreads)) {
			System.out.println("Arrays are equal!");
			return;
		} else {
			System.out.println("Arrays are different");
		}
		if (arrayFromOneThread.length != arrayFromTwoThreads.length) {
			System.out.println("Arrays have got different length!");
			return;
		} else {
			for (int i = 0; i < arrayFromOneThread.length; i++) {
				if (arrayFromOneThread[i] == arrayFromTwoThreads[i]) {
					continue;
				} else {
					System.out.print("Found difference between cells " + i);
					System.out.println(" Values are: " + arrayFromOneThread[i] + " and " + arrayFromTwoThreads[i]);

				}
			}
		}
	}

}
