package messen;

import com.codemercs.iow.IowKit;

public class MCP3008 {

	private long h; /* Geraetezugriff */
	private int pipe = 1; /* SPI benutzt immer Pipe 1 */
	private int[] lsSend = new int[8];
	private int[] lsReceive = new int[8];

	public MCP3008() {

		h = IowKit.openDevice();

		lsSend[0] = 0x9; /* ReportID */
		lsSend[1] = 3; /* write 3 Bytes */
		lsSend[2] = 1; // Start Bit
		lsSend[3] = 128; // -> default Channel 0
		lsSend[4] = 0; // do not care byte
	}

	public void open() {

		/* enable SPI */
		int[] report = new int[8];
		report[0] = 0x8; /* ReportID */
		report[1] = 1; /* SPI on */
		report[2] = 15; /* 0.0625 MBit/S CPHA=1,CPOL=1 */
		/* lsSend[3-7] sind default auf 0 */
		long result = IowKit.write(h, pipe, report);
		if (result != report.length)
			System.out.println("ERROR: MCP3008.open()");

	}

	public int read(int channel) {

		/* step 1: Report schreiben um den Datentransfer einzuleiten */
		// lsSend[0] = 0x9; /* ReportID */
		// lsSend[1] = 3; /* write 3 Bytes */
		// lsSend[2] = 1; // Start Bit
		lsSend[3] = 128 + (channel << 4); // Single + Channel
		// lsSend[4] = 0 - do not care byte - already set
		IowKit.write(h, pipe, lsSend);
		/* step 2: Report lesen und Daten auswerten */
		lsReceive = IowKit.read(h, pipe, 8);

		int highByte = lsReceive[3];
		int lowByte = lsReceive[4];

		/* maskieren mit 11 */
		highByte = highByte & 3;
		/* verschieben */
		highByte = highByte << 8;
		int result = highByte + lowByte;
		return result;

	}

	public double read(int channel, double vref /* In mV */) {
		return read(channel) * vref / 1024.0;
	}

	public void close() {

		int[] report = new int[8];
		report[0] = 0x8; /* ReportID */
		report[1] = 0; /* SPI off */
		long result = IowKit.write(h, pipe, report);

		if (result != report.length)
			System.out.println("ERROR: MCP3008.close()");

		IowKit.closeDevice(0L);

	}

	

	/**
	 * Method to measure elapsed time since start time until now
	 * 
	 * Example: long startup = System.nanoTime();
	 * System.out.println("This took " + stopWatch(startup) + " seconds.");
	 * 
	 * @param startTime
	 *            Time of start in Nanoseconds
	 * @return Elapsed time in milliseconds as double
	 */
	public static double stopWatch(long startTime) {
		double elapsedTime = 0.0;
		elapsedTime = System.nanoTime() - startTime;

		return (double) elapsedTime / 1000000.0;
	}

}
