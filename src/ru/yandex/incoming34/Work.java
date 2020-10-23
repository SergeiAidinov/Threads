package ru.yandex.incoming34;

public class Work {

	public void doWork() {

		OneThreads myWithoutThreads = new OneThreads();
		myWithoutThreads.procedure();
		MainClass.myTwoThreads.procedure();

	}

}
