package ru.yandex.incoming34;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainClass {

	static Data myData = new Data();
	static TwoThreads myTwoThreads = new TwoThreads();
	

	public static void main(String[] args) {

			Work myWork = new Work();
			myWork.doWork();
	}

}
