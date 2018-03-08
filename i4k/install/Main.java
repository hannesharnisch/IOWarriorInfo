import com.codemercs.iow.IowKit;

public class Main{

	public static void main(String[] args) {

		long h = IowKit.openDevice();
		System.out.println("Product = "	+ Long.toHexString(IowKit.getProductId(h)));
		System.out.println(" Serial = " + IowKit.getSerialNumber(h));		
		IowKit.closeDevice(h);
	}
}
