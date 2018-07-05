package com.zoom.photoplace.carousellayout.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DeviceUtils {

	public static final int SDK_VERSION_1_5 = 3;

	public static final int SDK_VERSION_1_6 = 4;

	public static final int SDK_VERSION_2_0 = 5;

	public static final int SDK_VERSION_2_0_1 = 6;

	public static final int SDK_VERSION_2_1 = 7;

	public static final int SDK_VERSION_2_2 = 8;

	public static final int SDK_VERSION_2_3 = 9;

	public static final int SDK_VERSION_2_3_3 = 10;

	public static final int SDK_VERSION_3_0 = 11;

	public static final int SDK_VERSION_3_1 = 12;

	public static final int SDK_VERSION_3_2 = 13;

	public static final int SDK_VERSION_4_0 = 14;

	public static final int SDK_VERSION_4_0_3 = 15;

	public static final int SDK_VERSION_4_1_2 = 16;

	public static final int SDK_VERSION_4_2_2 = 17;

	public static final int SDK_VERSION_4_3 = 18;

	public static final int SDK_VERSION_4_4_2 = 19;

	//	/** 缓存屏幕的宽度 */
	//	private static int mCacheWindowWidth = -1;
	//	/** 缓存屏幕的高度 */
	//	private static int mCacheWindowHeight = -1;

	/** >=2.2 8 */
	public static boolean hasFroyo() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
	}

	/** >=2.3 */
	public static boolean hasGingerbread() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
	}

	/** >=3.0 LEVEL:11 */
	public static boolean hasHoneycomb() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	}

	/** >=3.1 */
	public static boolean hasHoneycombMR1() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
	}

	/** >=4.0 14 */
	public static boolean hasICS() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
	}

	/**
	 * >= 4.1 16
	 * 
	 * @return
	 */
	public static boolean hasJellyBean() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
	}

	/** >= 4.2 17 */
	public static boolean hasJellyBeanMr1() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
	}
	
	public static int getSDKVersionInt() {
		return Build.VERSION.SDK_INT;
	}

	/**
	 * 判断是否是平板电脑
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isTablet(Context context) {
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}

	public static boolean isHoneycombTablet(Context context) {
		return hasHoneycomb() && isTablet(context);
	}
	

	/** 获取屏幕宽度 */
	@SuppressWarnings("deprecation")
	public static int getScreenWidth(Context context) {
		//		if (mCacheWindowWidth <= 0) {
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		return display.getWidth();
		//		}
		//		return mCacheWindowWidth;
	}

	@SuppressWarnings("deprecation")
	public static int getScreenHeight(Context context) {
		//		if (mCacheWindowHeight <= 0) {
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		return display.getHeight();
		//		}
		//		return mCacheWindowHeight;
	}

	/**
	 * 
	 * @param context
	 * @return 480_800
	 */
	@SuppressWarnings("deprecation")
	public static String getScreenResolution(Context context) {
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		return "" + display.getWidth() + "_" + display.getHeight();
	}

	/**
	 * 获得设备屏幕密度
	 */
	public static float getScreenDensity(Context context) {
		DisplayMetrics metrics = context.getApplicationContext().getResources().getDisplayMetrics();
		return metrics.density;
	}

	public static int[] getScreenSize(int w, int h, Context context) {
		int phoneW = getScreenWidth(context);
		int phoneH = getScreenHeight(context);

		if (w * phoneH > phoneW * h) {
			phoneH = phoneW * h / w;
		} else if (w * phoneH < phoneW * h) {
			phoneW = phoneH * w / h;
		}

		return new int[] { phoneW, phoneH };
	}

	public static int[] getScreenSize(int w, int h, int phoneW, int phoneH) {
		if (w * phoneH > phoneW * h) {
			phoneH = phoneW * h / w;
		} else if (w * phoneH < phoneW * h) {
			phoneW = phoneH * w / h;
		}
		return new int[] { phoneW, phoneH };
	}

	/** 设置屏幕亮度 */
	public static void setBrightness(final Activity context, float f) {
		WindowManager.LayoutParams lp = context.getWindow().getAttributes();
		lp.screenBrightness = f;
		if (lp.screenBrightness > 1.0f)
			lp.screenBrightness = 1.0f;
		else if (lp.screenBrightness < 0.01f)
			lp.screenBrightness = 0.01f;
		context.getWindow().setAttributes(lp);
	}

	// private static final long NO_STORAGE_ERROR = -1L;
	private static final long CANNOT_STAT_ERROR = -2L;

	
	@SuppressWarnings("deprecation")
	public static long getAvailableStorage() {
		try {
			String storageDirectory = Environment.getExternalStorageDirectory().toString();
			StatFs stat = new StatFs(storageDirectory);
			return (long) stat.getAvailableBlocks() * (long) stat.getBlockSize();
		} catch (RuntimeException ex) {
			// if we can't stat the filesystem then we don't know how many
			// free bytes exist. It might be zero but just leave it
			// blank since we really don't know.
			return CANNOT_STAT_ERROR;
		}
	}

	/** 隐藏软键盘 */
	public static void hideSoftInput(Context ctx, View v) {
		if (v != null && ctx != null) {
			InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
			// 这个方法可以实现输入法在窗口上切换显示，如果输入法在窗口上已经显示，则隐藏，如果隐藏，则显示输入法到窗口上
			imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/** 显示软键盘 */
	public static void showSoftInput(Context ctx) {
		InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm != null)
			imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);// (v,
		// InputMethodManager.SHOW_FORCED);
	}

	public static void showSoftInput(Context ctx, View v) {
		v.requestFocus();

		InputMethodManager m = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

		//		InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
		//		imm.showSoftInput(v.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED);
		//		imm.showSoftInputFromInputMethod(v.getApplicationWindowToken(), InputMethodManager.SHOW_IMPLICIT);
	}

	/**
	 * 软键盘是否已经打开
	 * 
	 * @return
	 */
	public static boolean isHardKeyboardOpen(Context ctx) {
		return ctx.getResources().getConfiguration().hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO;
	}

	public static String getCpuInfo() {
		String cpuInfo = "";
		try {
			if (new File("/proc/cpuinfo").exists()) {
				FileReader fr = new FileReader("/proc/cpuinfo");
				BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
				cpuInfo = localBufferedReader.readLine();
				localBufferedReader.close();

				if (cpuInfo != null) {
					cpuInfo = cpuInfo.split(":")[1].trim().split(" ")[0];
				}
			}
		} catch (IOException e) {
		} catch (Exception e) {
		}
		return cpuInfo;
	}

	/**
	 * 获得android_id
	 * 
	 * @param context
	 * @return
	 */
	public static String getAndroidId(Context context) {
		return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
	}

	public static int dipToPX(final Context ctx, float dip) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, ctx.getResources().getDisplayMetrics());
	}

	/** 判断是否支持闪光灯 */
	public static boolean isSupportCameraLedFlash(PackageManager pm) {
		if (pm != null) {
			FeatureInfo[] features = pm.getSystemAvailableFeatures();
			if (features != null) {
				for (FeatureInfo f : features) {
					if (f != null && PackageManager.FEATURE_CAMERA_FLASH.equals(f.name)) //判断设备是否支持闪光灯
						return true;
				}
			}
		}
		return false;
	}

	/** 检测设备是否支持相机 */
	public static boolean isSupportCameraHardware(Context context) {
		if (context != null && context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
			// this device has a camera
			return true;
		} else {
			// no camera on this device
			return false;
		}
	}

	@TargetApi(11)
	public static void showSystemUi(View mViewRoot, boolean visible) {
		if (DeviceUtils.hasHoneycomb() && mViewRoot != null) {
			int flag = visible ? 0 : View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LOW_PROFILE;
			mViewRoot.setSystemUiVisibility(flag);
		}
	}

	/** 
	 * 获取外置的sdcard列表
	 * 参考：http://blog.csdn.net/boystarzq09/article/details/9837535
	 * */
	public static ArrayList<String> getExtExternalStorage() {
		ArrayList<String> result = new ArrayList<String>();
		Process proc = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			Runtime runtime = Runtime.getRuntime();
			proc = runtime.exec("mount");//检测系统挂载
			is = proc.getInputStream();
			isr = new InputStreamReader(is);
			String line;

			final String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath();
			br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				if (line.contains("secure") || line.contains("asec"))//	/mnt/secure/asec
					continue;

				if (line.contains("fat")) {//line.contains("fuse")
					String columns[] = line.split(" ");
					if (columns != null && columns.length > 1) {
						//ZET[/mnt/sdcard-ext, /mnt/sdcard]
						//SAMSUNG
						final String path = columns[1];
						File f = new File(path);
						if (f != null && f.canRead() && f.canWrite() && f.exists() && !sdcard.equals(path))
							result.add(path);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
				br = null;
			}

			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
				}
				isr = null;
			}

			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
				is = null;
			}

			if (proc != null) {
				try {
					proc.destroy();
				} catch (Exception e) {

				}
				proc = null;
			}
		}
		return result;
	}
}
