package com.king.usdk.adinfo;

import android.app.Activity;
import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Keep;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AdvertisingId {
    private static final String TAG = "com.king.usdk.adinfo.AdvertisingId";
    private static final Executor executor = Executors.newFixedThreadPool(1);
    private static AdvertisingInfo advertisingInfo = null;

    @GuardedBy("AdvertisingId.this")
    private static String cachedAppSetId = null;

    @GuardedBy("AdvertisingId.this")
    private static long nativePtr = 0;

    @Keep
    private static class AdvertisingIdInitializer implements Runnable {
        Activity activity;

        AdvertisingIdInitializer(Activity activity) {
            this.activity = activity;
        }

        private boolean isGooglePlayServicesAvailable() {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.activity) == 0;
        }

        private void setAdvertisingIdForAlternativeServices() {
            try {
                ContentResolver contentResolver = this.activity.getContentResolver();
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                if (string == null || "".equals(string)) {
                    return;
                }
                AdvertisingInfo unused = AdvertisingId.advertisingInfo = new AdvertisingInfo(string, Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0);
            } catch (Settings.SettingNotFoundException unused2) {
                Log.w(AdvertisingId.TAG, "Setting not found. Unable to set AdvertisingInfo");
            }
        }

        private void setAdvertisingIdForGooglePlayServices() {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.activity);
                AdvertisingInfo unused = AdvertisingId.advertisingInfo = new AdvertisingInfo(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
            } catch (Exception e10) {
                Log.w(AdvertisingId.TAG, "Exception getting advertising id", e10);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isGooglePlayServicesAvailable()) {
                setAdvertisingIdForGooglePlayServices();
            } else {
                Log.w(AdvertisingId.TAG, "No google play services available");
                setAdvertisingIdForAlternativeServices();
            }
            if (AdvertisingId.isAdvertisingInfoReceived()) {
                return;
            }
            AdvertisingInfo unused = AdvertisingId.advertisingInfo = new AdvertisingInfo();
        }
    }

    public static AdvertisingInfo getAdvertisingInfo() {
        return advertisingInfo;
    }

    public static boolean isAdvertisingInfoReceived() {
        return advertisingInfo != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestAppSetId$0(AppSetIdInfo appSetIdInfo) {
        synchronized (AdvertisingId.class) {
            cachedAppSetId = appSetIdInfo.getId();
            if (nativePtr != 0) {
                onAppSetId(appSetIdInfo.getId(), nativePtr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestAppSetId$1(Exception exc) {
        Log.e(TAG, "Exception while requesting appSetId", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestAppSetId$2() {
        Log.e(TAG, "Request of appSetId was cancelled");
    }

    public static native void onAppSetId(String str, long j10);

    public static synchronized void registerNativePtr(long j10) {
        nativePtr = j10;
    }

    public static void requestAdvertisingInfo(Activity activity) {
        if (isAdvertisingInfoReceived()) {
            return;
        }
        if (activity != null) {
            executor.execute(new AdvertisingIdInitializer(activity));
        } else {
            Log.w(TAG, "No advertising id available");
        }
    }

    public static synchronized void requestAppSetId(Activity activity) {
        String str = cachedAppSetId;
        if (str != null) {
            long j10 = nativePtr;
            if (j10 != 0) {
                onAppSetId(str, j10);
                return;
            }
        }
        AppSet.getClient(activity.getApplicationContext()).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.king.usdk.adinfo.a
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                AdvertisingId.lambda$requestAppSetId$0((AppSetIdInfo) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.king.usdk.adinfo.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                AdvertisingId.lambda$requestAppSetId$1(exc);
            }
        }).addOnCanceledListener(new OnCanceledListener() { // from class: com.king.usdk.adinfo.c
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                AdvertisingId.lambda$requestAppSetId$2();
            }
        });
    }

    public static synchronized void unregisterNativePtr() {
        nativePtr = 0L;
    }

    @Keep
    public static class AdvertisingInfo {
        private final String id;
        private final boolean isLimitAdTrackingEnabled;
        private final boolean valid;

        public AdvertisingInfo() {
            this.valid = false;
            this.id = null;
            this.isLimitAdTrackingEnabled = false;
        }

        public String getId() {
            return this.id;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.isLimitAdTrackingEnabled;
        }

        public boolean isValid() {
            return this.valid;
        }

        public AdvertisingInfo(String str, boolean z10) {
            this.valid = true;
            this.id = str;
            this.isLimitAdTrackingEnabled = z10;
        }
    }
}
