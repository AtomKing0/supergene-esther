package com.king.firebaseanalytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.king.firebaseanalytics.ComplianceDMA;
import com.king.firebaseanalytics.FirebaseAnalyticsManager;
import com.king.usdk.logger.Logger;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class FirebaseAnalyticsManager {
    private static Map<FirebaseAnalytics.b, FirebaseAnalytics.a> mConsentMap;
    private static Context mContext;
    private static FirebaseAnalytics mFirebaseAnalytics;
    private static Logger mLogger;
    private static final ReentrantLock mNativeCallbackLock = new ReentrantLock();
    private static long mFirebaseAnalyticsPointer = 0;

    private static void callNativeOnFirebaseAnalytitcsInstanceId(String str) {
        ReentrantLock reentrantLock = mNativeCallbackLock;
        reentrantLock.lock();
        try {
            long j10 = mFirebaseAnalyticsPointer;
            if (j10 != 0) {
                onFirebaseAnalytitcsInstanceId(j10, str);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            mNativeCallbackLock.unlock();
            throw th;
        }
    }

    public static Bundle createEventParameters() {
        return new Bundle();
    }

    public static void disconnectFromNativeSide() {
        setFirebaseAnalyticsPointer(0L);
    }

    public static void init(Activity activity, long j10, long j11, boolean z10) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        mLogger = new Logger(j11, z10);
        setFirebaseAnalyticsPointer(j10);
        mContext = activity.getApplicationContext();
    }

    public static boolean isAdPersonalizationEnabled() {
        return mConsentMap.get(FirebaseAnalytics.b.AD_PERSONALIZATION) == FirebaseAnalytics.a.GRANTED;
    }

    public static boolean isAdStorageEnabled() {
        return mConsentMap.get(FirebaseAnalytics.b.AD_STORAGE) == FirebaseAnalytics.a.GRANTED;
    }

    public static boolean isAdUserDataEnabled() {
        return mConsentMap.get(FirebaseAnalytics.b.AD_USER_DATA) == FirebaseAnalytics.a.GRANTED;
    }

    public static boolean isAnalyticsStorageEnabled() {
        return mConsentMap.get(FirebaseAnalytics.b.ANALYTICS_STORAGE) == FirebaseAnalytics.a.GRANTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$triggerGetFirebaseInstanceId$0(Task task) {
        if (task.isSuccessful()) {
            callNativeOnFirebaseAnalytitcsInstanceId((String) task.getResult());
        } else {
            mLogger.w("Failed to obtain firebase instance id");
        }
    }

    public static void logEvent(String str, Bundle bundle) {
        mFirebaseAnalytics.b(str, bundle);
    }

    private static native void onFirebaseAnalytitcsInstanceId(long j10, String str);

    public static void refreshConsents() {
        Map<FirebaseAnalytics.b, FirebaseAnalytics.a> mapI = ComplianceDMA.a.i(mContext);
        mConsentMap = mapI;
        mFirebaseAnalytics.d(mapI);
    }

    public static void setCollectionEnabled(boolean z10) {
        mFirebaseAnalytics.c(z10);
    }

    public static void setConsent(boolean z10) {
        EnumMap enumMap = new EnumMap(FirebaseAnalytics.b.class);
        FirebaseAnalytics.a aVar = z10 ? FirebaseAnalytics.a.GRANTED : FirebaseAnalytics.a.DENIED;
        enumMap.put(FirebaseAnalytics.b.ANALYTICS_STORAGE, aVar);
        enumMap.put(FirebaseAnalytics.b.AD_STORAGE, aVar);
        enumMap.put(FirebaseAnalytics.b.AD_USER_DATA, aVar);
        enumMap.put(FirebaseAnalytics.b.AD_PERSONALIZATION, aVar);
        mFirebaseAnalytics.d(enumMap);
    }

    private static void setFirebaseAnalyticsPointer(long j10) {
        ReentrantLock reentrantLock = mNativeCallbackLock;
        reentrantLock.lock();
        try {
            mFirebaseAnalyticsPointer = j10;
            reentrantLock.unlock();
        } catch (Throwable th) {
            mNativeCallbackLock.unlock();
            throw th;
        }
    }

    public static void setParameter(Bundle bundle, String str, String str2) {
        bundle.putString(str, str2);
    }

    public static void setUserProperty(String str, String str2) {
        mFirebaseAnalytics.e(str, str2);
    }

    public static void triggerGetFirebaseInstanceId() {
        mFirebaseAnalytics.a().addOnCompleteListener(new OnCompleteListener() { // from class: m6.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseAnalyticsManager.lambda$triggerGetFirebaseInstanceId$0(task);
            }
        });
    }
}
