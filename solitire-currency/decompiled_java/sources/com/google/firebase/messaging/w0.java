package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.ironsource.c3;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: ServiceStarter.java */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class w0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static w0 f10480e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private String f10481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f10482b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f10483c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue<Intent> f10484d = new ArrayDeque();

    private w0() {
    }

    private int a(Context context, Intent intent) {
        ComponentName componentNameStartService;
        String strF = f(context, intent);
        if (strF != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Restricting intent to a specific service: " + strF);
            }
            intent.setClassName(context.getPackageName(), strF);
        }
        try {
            if (e(context)) {
                componentNameStartService = h1.h(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return c3.a.b.f11495d;
        } catch (IllegalStateException e10) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e10);
            return TypedValues.CycleType.TYPE_VISIBILITY;
        } catch (SecurityException e11) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e11);
            return 401;
        }
    }

    static synchronized w0 b() {
        if (f10480e == null) {
            f10480e = new w0();
        }
        return f10480e;
    }

    @Nullable
    private synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2 = this.f10481a;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfoResolveService != null && (serviceInfo = resolveInfoResolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    this.f10481a = context.getPackageName() + serviceInfo.name;
                } else {
                    this.f10481a = serviceInfo.name;
                }
                return this.f10481a;
            }
            Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + serviceInfo.name);
            return null;
        }
        Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    @MainThread
    Intent c() {
        return this.f10484d.poll();
    }

    boolean d(Context context) {
        if (this.f10483c == null) {
            this.f10483c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f10482b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f10483c.booleanValue();
    }

    boolean e(Context context) {
        if (this.f10482b == null) {
            this.f10482b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f10482b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f10482b.booleanValue();
    }

    @MainThread
    public int g(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        this.f10484d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
