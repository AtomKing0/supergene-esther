package com.king.amp.sa;

import android.app.Activity;
import android.app.ActivityManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Debug;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.autofill.HintConstants;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public final class AdsPlatformAbstraction {
    private static final String NETWORK_OPERATOR_UNAVAILABLE = "";
    private static final String OS_VERSION_UNAVAILABLE = "0.0";
    private static NetworkListener sNetworkListener;
    private Activity mActivity;
    private p0 mAdIdSource;
    private q0 mAttitudeManager;

    private p0 createAdvertisingIdSource() {
        try {
            return (p0) l6.a.class.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            return new s0();
        }
    }

    public static GLSurfaceView findSurfaceView(ViewGroup viewGroup) {
        GLSurfaceView gLSurfaceViewFindSurfaceView;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof GLSurfaceView) {
                return (GLSurfaceView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (gLSurfaceViewFindSurfaceView = findSurfaceView((ViewGroup) childAt)) != null) {
                return gLSurfaceViewFindSurfaceView;
            }
        }
        return null;
    }

    private NetworkInfo getCurrentNetworkInfo() {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mActivity.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
            return activeNetworkInfo;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo.getType() != 7) {
                if (activeNetworkInfo == null && networkInfo.getType() == 0) {
                    activeNetworkInfo = networkInfo;
                }
                if (networkInfo.isAvailable() && (activeNetworkInfo == null || !activeNetworkInfo.isAvailable())) {
                    activeNetworkInfo = networkInfo;
                }
                if (networkInfo.isConnected() && (activeNetworkInfo == null || !activeNetworkInfo.isConnected())) {
                    return networkInfo;
                }
            }
        }
        return activeNetworkInfo;
    }

    public String GetCmpAdditionalConsentString() {
        return PreferenceManager.getDefaultSharedPreferences(this.mActivity).getString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, "-1");
    }

    public String GetCmpCcpaConsentString() {
        return PreferenceManager.getDefaultSharedPreferences(this.mActivity).getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, "-1");
    }

    public String GetCmpGdprConsentString() {
        return PreferenceManager.getDefaultSharedPreferences(this.mActivity).getString("IABTCF_TCString", "-1");
    }

    public String GetCmpGdprPurposeConsentString() {
        return PreferenceManager.getDefaultSharedPreferences(this.mActivity).getString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, "-1");
    }

    public String getAdvertisingIdentifier() {
        return this.mAdIdSource.c();
    }

    public double[] getAttitude() {
        Activity activity;
        if (this.mAttitudeManager == null && (activity = this.mActivity) != null) {
            this.mAttitudeManager = new q0(activity);
        }
        q0 q0Var = this.mAttitudeManager;
        if (q0Var != null) {
            if (q0Var.a().length >= 3) {
                return new double[]{-Math.toDegrees(r0[1]), Math.toDegrees(r0[2]), Math.toDegrees(r0[0])};
            }
        }
        return new double[]{0.0d, 0.0d, 0.0d};
    }

    public String getBrowserUserAgent() {
        return System.getProperty("http.agent");
    }

    public String getBundleId() {
        Activity activity = this.mActivity;
        return activity != null ? activity.getApplicationContext().getPackageName() : "";
    }

    public String getCountryCode() {
        return Locale.getDefault().getCountry();
    }

    public String getDeviceMake() {
        return Build.MANUFACTURER;
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public int getHeight() {
        Activity activity = this.mActivity;
        return (activity != null ? activity.getResources().getDisplayMetrics() : new DisplayMetrics()).heightPixels;
    }

    public String getLanguageCode() {
        return Locale.getDefault().getLanguage();
    }

    public synchronized long[] getMemoryUsageStats() {
        try {
            Activity activity = this.mActivity;
            if (activity == null) {
                return new long[]{0, 0, 0, 0};
            }
            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            Debug.getMemoryInfo(new Debug.MemoryInfo());
            return new long[]{memoryInfo.totalMem / 1024, memoryInfo.availMem / 1024, r8.getTotalPss(), Runtime.getRuntime().maxMemory() / 1024};
        } catch (Throwable unused) {
            return new long[]{0, 0, 0, 0};
        }
    }

    public String getNetworkOperator() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return "";
        }
        try {
            return ((TelephonyManager) activity.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    public int getNetworkType() {
        NetworkInfo currentNetworkInfo = getCurrentNetworkInfo();
        if (currentNetworkInfo == null) {
            return 0;
        }
        int type = currentNetworkInfo.getType();
        if (type == 0) {
            return 1;
        }
        if (type != 1) {
            return type != 9 ? 4 : 3;
        }
        return 2;
    }

    public int getOrientation() {
        Activity activity = this.mActivity;
        return (activity != null && activity.getResources().getConfiguration().orientation == 2) ? 1 : 0;
    }

    public String getOsVersionAsString() {
        try {
            return String.valueOf(Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return OS_VERSION_UNAVAILABLE;
        }
    }

    public float getVolume() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) activity.getSystemService("audio");
        return audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
    }

    public int getWidth() {
        Activity activity = this.mActivity;
        return (activity != null ? activity.getResources().getDisplayMetrics() : new DisplayMetrics()).widthPixels;
    }

    @RequiresApi(api = 24)
    public void initNetworkListener(long j10) {
        NetworkListener networkListener = sNetworkListener;
        if (networkListener != null) {
            networkListener.f();
            sNetworkListener = null;
        }
        sNetworkListener = new NetworkListener(this.mActivity.getApplicationContext(), j10);
    }

    public boolean isAdvertisingTrackingEnabled() {
        return this.mAdIdSource.b();
    }

    public boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isInternetPermissionGranted() {
        return ContextCompat.checkSelfPermission(this.mActivity, "android.permission.INTERNET") == 0 && ContextCompat.checkSelfPermission(this.mActivity, "android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    public boolean isInternetReachable() {
        NetworkInfo currentNetworkInfo = getCurrentNetworkInfo();
        if (currentNetworkInfo != null) {
            return currentNetworkInfo.isConnected();
        }
        return false;
    }

    public boolean isLoaded() {
        return this.mAdIdSource.isLoaded();
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
        p0 p0VarCreateAdvertisingIdSource = createAdvertisingIdSource();
        this.mAdIdSource = p0VarCreateAdvertisingIdSource;
        p0VarCreateAdvertisingIdSource.a(activity);
    }

    public void uninit() {
        NetworkListener networkListener = sNetworkListener;
        if (networkListener != null) {
            networkListener.f();
        }
        sNetworkListener = null;
        this.mAdIdSource = null;
        this.mAttitudeManager = null;
        this.mActivity = null;
    }
}
