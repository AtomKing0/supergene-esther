package com.king.device;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.autofill.HintConstants;
import com.king.usdk.logger.Logger;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class DeviceImpl {
    private static final int USDK_CELLULAR_NETWORK_TYPE_CDMA = 3;
    private static final int USDK_CELLULAR_NETWORK_TYPE_EDGE = 4;
    private static final int USDK_CELLULAR_NETWORK_TYPE_EDVO0 = 6;
    private static final int USDK_CELLULAR_NETWORK_TYPE_EDVOA = 7;
    private static final int USDK_CELLULAR_NETWORK_TYPE_EDVOB = 8;
    private static final int USDK_CELLULAR_NETWORK_TYPE_EDVOC = 9;
    private static final int USDK_CELLULAR_NETWORK_TYPE_EHRPD = 5;
    private static final int USDK_CELLULAR_NETWORK_TYPE_GPRS = 10;
    private static final int USDK_CELLULAR_NETWORK_TYPE_GSM = 11;
    private static final int USDK_CELLULAR_NETWORK_TYPE_HSDPA = 14;
    private static final int USDK_CELLULAR_NETWORK_TYPE_HSPA = 12;
    private static final int USDK_CELLULAR_NETWORK_TYPE_HSPAP = 13;
    private static final int USDK_CELLULAR_NETWORK_TYPE_HSUPA = 15;
    private static final int USDK_CELLULAR_NETWORK_TYPE_IDEN = 16;
    private static final int USDK_CELLULAR_NETWORK_TYPE_IWLAN = 17;
    private static final int USDK_CELLULAR_NETWORK_TYPE_LTE = 18;
    private static final int USDK_CELLULAR_NETWORK_TYPE_NONE = 0;
    private static final int USDK_CELLULAR_NETWORK_TYPE_ONEXRTT = 2;
    private static final int USDK_CELLULAR_NETWORK_TYPE_TDSCDMA = 19;
    private static final int USDK_CELLULAR_NETWORK_TYPE_UMTS = 20;
    private static final int USDK_CELLULAR_NETWORK_TYPE_UNKNOWN = 1;
    private static final int USDK_NETWORK_TYPE_CELLULAR = 1;
    private static final int USDK_NETWORK_TYPE_ETHERNET = 3;
    private static final int USDK_NETWORK_TYPE_OFFLINE = 0;
    private static final int USDK_NETWORK_TYPE_UNKNOWN = 4;
    private static final int USDK_NETWORK_TYPE_WIFI = 2;
    private static volatile boolean cacheIsInternetReachable = false;
    private static volatile int cacheNetworkType = 4;
    private static Context mContext;
    private final AudioManager mAudioManager;
    private final String mClassName = "[com.king.device.DeviceImpl] ";
    private final long mDeviceState;
    private final BroadcastReceiver mLocaleReceiver;
    private final Logger mLogger;
    private final BroadcastReceiver mTimeZoneReceiver;

    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DeviceImpl.this.onLocaleChanged();
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f17040a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f17041b = new AtomicBoolean(true);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f17042c = new AtomicBoolean(true);

        class a extends ConnectivityManager.NetworkCallback {
            a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                c.this.b();
                super.onAvailable(network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                c.this.b();
                super.onCapabilitiesChanged(network, networkCapabilities);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                c.this.b();
                super.onLinkPropertiesChanged(network, linkProperties);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                c.this.b();
                super.onLost(network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                c.this.b();
                super.onUnavailable();
            }
        }

        public c() {
            if (Build.VERSION.SDK_INT >= 24) {
                c();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f17042c.set(true);
            this.f17041b.set(true);
        }

        @RequiresApi(api = 24)
        private void c() {
            ((ConnectivityManager) DeviceImpl.mContext.getSystemService("connectivity")).registerDefaultNetworkCallback(new a());
            this.f17040a = true;
        }

        public boolean d() {
            return this.f17042c.getAndSet(!this.f17040a);
        }

        public boolean e() {
            return this.f17041b.getAndSet(!this.f17040a);
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f17044a = new c();
    }

    private class e extends BroadcastReceiver {
        private e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DeviceImpl.this.onTimeZoneChanged();
        }
    }

    public DeviceImpl(Activity activity, long j10, long j11, boolean z10) {
        DisplayMetrics displayMetrics;
        int i10;
        int i11;
        int i12;
        this.mLogger = new Logger(j11, z10);
        Context applicationContext = activity.getApplicationContext();
        mContext = applicationContext;
        this.mAudioManager = (AudioManager) applicationContext.getSystemService("audio");
        this.mLocaleReceiver = new b();
        this.mTimeZoneReceiver = new e();
        this.mDeviceState = j10;
        TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 30) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            int iWidth = currentWindowMetrics.getBounds().width();
            int iHeight = currentWindowMetrics.getBounds().height();
            Configuration configuration = mContext.getResources().getConfiguration();
            displayMetrics = mContext.getResources().getDisplayMetrics();
            i10 = configuration.densityDpi;
            i12 = iHeight;
            i11 = iWidth;
        } else {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            Point point = new Point();
            defaultDisplay.getSize(point);
            int i14 = point.x;
            int i15 = point.y;
            i10 = displayMetrics.densityDpi;
            i11 = i14;
            i12 = i15;
        }
        DisplayMetrics displayMetrics2 = displayMetrics;
        setStatics(j10, new int[]{i13, 0, 0}, Build.MANUFACTURER, Build.MODEL, 0, isTablet(activity), getDeviceId(activity), i11, i12, i10, displayMetrics2.xdpi, displayMetrics2.ydpi, telephonyManager.getSimOperator(), telephonyManager.getSimOperatorName(), telephonyManager.getSimCountryIso());
    }

    private static int getCellularNetwork(int i10) {
        switch (i10) {
            case 1:
                return 10;
            case 2:
                return 4;
            case 3:
                return 20;
            case 4:
                return 3;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 2;
            case 8:
                return 14;
            case 9:
                return 15;
            case 10:
                return 12;
            case 11:
                return 16;
            case 12:
                return 8;
            case 13:
                return 18;
            case 14:
                return 5;
            case 15:
                return 13;
            case 16:
                return 11;
            case 17:
                return 19;
            case 18:
                return 17;
            default:
                return 1;
        }
    }

    private static String getDeviceId(Activity activity) {
        return Settings.Secure.getString(activity.getContentResolver(), "android_id");
    }

    private static c getNetworkConnectivityStatus() {
        return d.f17044a;
    }

    public static int getNetworkType() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 29) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return 0;
            }
            if (networkCapabilities.hasTransport(1)) {
                return 2;
            }
            return networkCapabilities.hasTransport(0) ? 1 : 4;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 4;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return 1;
        }
        if (type != 1) {
            return !activeNetworkInfo.isConnected() ? 0 : 4;
        }
        return 2;
    }

    public static int getNetworkTypeCached() {
        if (getNetworkConnectivityStatus().d()) {
            cacheNetworkType = getNetworkType();
        }
        return cacheNetworkType;
    }

    public static boolean isInternetReachable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 29) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            return networkCapabilities != null && (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(2));
        }
        for (NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
            if (networkInfo.isConnected() && networkInfo.getType() != 17) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInternetReachableCached() {
        if (getNetworkConnectivityStatus().e()) {
            cacheIsInternetReachable = isInternetReachable();
        }
        return cacheIsInternetReachable;
    }

    private static boolean isTablet(Activity activity) {
        return (activity.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private static boolean isValidOperator(String str) {
        return (str == null || str.equals("") || str.equals("00000")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLocaleChanged() {
        String language = Locale.getDefault().getLanguage();
        if (language.isEmpty()) {
            language = "en";
        }
        String str = language;
        String country = Locale.getDefault().getCountry();
        if (country.isEmpty()) {
            country = "US";
        }
        updateLocale(this.mDeviceState, str, country, Locale.getDefault().getScript());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeZoneChanged() {
        TimeZone timeZone = TimeZone.getDefault();
        int offset = timeZone.getOffset(System.currentTimeMillis()) / 1000;
        int i10 = offset / 60;
        updateTimeZone(this.mDeviceState, offset, String.format(Locale.US, "GMT%+03d:%02d", Integer.valueOf(i10 / 60), Integer.valueOf(Math.abs(i10) % 60)), timeZone.getDisplayName());
    }

    private native void setScreenInfo(long j10, int i10, int i11, float f10, float f11);

    private native void setStatics(long j10, int[] iArr, String str, String str2, int i10, boolean z10, String str3, int i11, int i12, int i13, float f10, float f11, String str4, String str5, String str6);

    private native void updateLocale(long j10, String str, String str2, String str3);

    private native void updateNetwork(long j10, int i10, boolean z10, boolean z11);

    private native void updateOperator(long j10, String str, String str2, String str3, int i10, boolean z10);

    private native void updateTimeZone(long j10, int i10, String str, String str2);

    public boolean detectHeadset() {
        if (!hasPermissionHeadset()) {
            this.mLogger.w("[com.king.device.DeviceImpl] : 'detectHeadset' was called even though hasPermissionHeadset is false.");
            return false;
        }
        AudioDeviceInfo[] devices = this.mAudioManager.getDevices(1);
        for (int i10 = 0; i10 < devices.length; i10++) {
            if (devices[i10].getType() == 7 || devices[i10].getType() == 3 || devices[i10].getType() == 4 || devices[i10].getType() == 22) {
                return true;
            }
        }
        return false;
    }

    public float getHardwareOutputVolume() {
        return this.mAudioManager.getStreamVolume(3) / this.mAudioManager.getStreamMaxVolume(3);
    }

    public void getScreenInfo() {
        DisplayMetrics displayMetrics;
        int i10;
        int i11;
        WindowManager windowManager = (WindowManager) mContext.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            int iWidth = currentWindowMetrics.getBounds().width();
            int iHeight = currentWindowMetrics.getBounds().height();
            mContext.getResources().getConfiguration();
            displayMetrics = mContext.getResources().getDisplayMetrics();
            i11 = iHeight;
            i10 = iWidth;
        } else {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            Point point = new Point();
            defaultDisplay.getSize(point);
            i10 = point.x;
            i11 = point.y;
        }
        setScreenInfo(this.mDeviceState, i10, i11, displayMetrics.xdpi, displayMetrics.ydpi);
    }

    public boolean hasPermissionHeadset() {
        boolean z10;
        if (mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS") != 0) {
            this.mLogger.i("[com.king.device.DeviceImpl] : Permission not granted to modify audio.");
            z10 = false;
        } else {
            z10 = true;
        }
        if (mContext.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0) {
            return z10;
        }
        this.mLogger.i("[com.king.device.DeviceImpl] : Permission not granted to access bluetooth.");
        return false;
    }

    public void start() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        mContext.registerReceiver(this.mLocaleReceiver, intentFilter);
        onLocaleChanged();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
        mContext.registerReceiver(this.mTimeZoneReceiver, intentFilter2);
        onTimeZoneChanged();
    }

    public void stop() {
        mContext.unregisterReceiver(this.mLocaleReceiver);
        mContext.unregisterReceiver(this.mTimeZoneReceiver);
    }
}
