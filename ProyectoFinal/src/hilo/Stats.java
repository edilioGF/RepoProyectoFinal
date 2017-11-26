package hilo;

import visual.Principal;

public class Stats extends Thread {
	public void run() {
		while (true) {

			Principal.loadStats();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
