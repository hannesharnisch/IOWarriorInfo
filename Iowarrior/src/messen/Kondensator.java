package messen;


public class Kondensator {

	public static void main(String[] args) throws InterruptedException {
		
		MCP3008 wandler = new MCP3008();
		int delay = 100; // eine Sekunde warten

		/* Verbindung oeffnen, SPI Aktivieren */
		wandler.open();

		for (int i = 0; i < 20100; i+=100) {
			double value = wandler.read(0 /* channel */, 5000 /* vRef/mV */);
			System.out.println(i+"  "+value);
			Thread.sleep(delay);
		}

		/* SPI deaktivieren, Verbindung schließen */
		wandler.close();

	}
	

}
