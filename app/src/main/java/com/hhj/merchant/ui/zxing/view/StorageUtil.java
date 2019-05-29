package com.hhj.merchant.ui.zxing.view;

public class StorageUtil {
	/**
	 * ����
	 * 
	 * @return
	 */
	public static boolean isExternalStorageAvailable() {
		return android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState());
	}
}
