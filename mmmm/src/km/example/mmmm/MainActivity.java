package km.example.mmmm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import keymantek.android.convert.DataConvert;
import keymantek.android.deviceinfo.DeviceInfo;
import keymantek.android.lang.PbyteArray;
import keymantek.android.meter645.ExeMeterCommand;
import keymantek.android.meterfunction.MeterComFunction;
import keymantek.android.serialport.Parity;
import keymantek.android.serialport.StopBits;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DeviceInfo dInfo = DeviceInfo.CreateInstance();
		dInfo.IR_Power(true);

		try {
//			ExeMeterCommand exeMeterCommand = new ExeMeterCommand();
//			exeMeterCommand.OpenPort(dInfo.IRPortName(), 1200, Parity.Even, 8, StopBits.One);
			MeterComFunction mcf = new MeterComFunction();
			mcf.OpenPort(dInfo.IRPortName(), 1200, Parity.Even, 8, StopBits.One);
			mcf.setFrameWaitTime(1200);
			PbyteArray meterNo = new PbyteArray();
			PbyteArray meterAddress = new PbyteArray();
			while (true) {
				try {
					if (mcf.GetMeterNoAndMeterAddressInOneCMD("", meterNo, meterAddress)) {
						System.out.print(DataConvert.ByteArrayToHexString(meterNo.pByteArray));
						 Log.d("TTT", DataConvert.ByteArrayToHexString(meterNo.pByteArray));
					} else {
						System.out.print("Error !");
					  Log.d("TTT","Error!");
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					Log.d("EX",e.getMessage());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
