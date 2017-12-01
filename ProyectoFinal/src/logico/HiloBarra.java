package logico;

import java.io.IOException;

import visual.EjecutandoMatcheo;

public class HiloBarra extends Thread {

	private int value;

	public void run() {
		while (value < 100) {
			value++;
			EjecutandoMatcheo.loadBar(value);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Controladora.getInstance().match();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
