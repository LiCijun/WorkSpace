/**
 * 
 */
package Keymantek.Android.DeviceInfo.test;

import Keymantek.Android.DeviceInfo.DeviceInfo;
import Keymantek.Android.SerialPort.SerialPort;
import android.util.Log;
/**
 * @author li
 *
 */
public class test {

	/**
	 * 
	 */
	public test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Log.println(0, "Keymantek a", "Keymantek b");
		System.out.print("Main Start");
		Log.d("Keymantek c", "Keymantek d");
		DeviceInfo di=DeviceInfo.CreateInstance();
		di.IR_Power(true);
		Keymantek.Android.SerialPort.SerialPort sp=new  SerialPort();
		sp.setPortName(0);
		sp.setBaudRate(1200);
	
		try {
			sp.Open();
			sp.wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
