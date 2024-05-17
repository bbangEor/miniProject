package test;

import screen.MainScreen;

public class MiniGameEngine {

	MainScreen mainScreen;
	
	void gameStart() {
		System.out.println("게임을 시작합니다.");
		new MainScreen();
	}
	
	final void run() {
		gameStart();
	}
	
}
