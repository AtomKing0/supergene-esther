package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;

/* JADX INFO: compiled from: Metadata.java */
/* JADX INFO: loaded from: classes3.dex */
class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private String f10437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    private String f10438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private int f10439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private int f10440e = 0;

    j0(Context context) {
        this.f10436a = context;
    }

    static String c(i5.e eVar) {
        String strD = eVar.m().d();
        if (strD != null) {
            return strD;
        }
        String strC = eVar.m().c();
        if (!strC.startsWith("1:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f10436a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("FirebaseMessaging", "Failed to find package " + e10);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo packageInfoF = f(this.f10436a.getPackageName());
        if (packageInfoF != null) {
            this.f10437b = Integer.toString(packageInfoF.versionCode);
            this.f10438c = packageInfoF.versionName;
        }
    }

    synchronized String a() {
        if (this.f10437b == null) {
            h();
        }
        return this.f10437b;
    }

    synchronized String b() {
        if (this.f10438c == null) {
            h();
        }
        return this.f10438c;
    }

    synchronized int d() {
        PackageInfo packageInfoF;
        if (this.f10439d == 0 && (packageInfoF = f("com.google.android.gms")) != null) {
            this.f10439d = packageInfoF.versionCode;
        }
        return this.f10439d;
    }

    synchronized int e() {
        int i10 = this.f10440e;
        if (i10 != 0) {
            return i10;
        }
        PackageManager packageManager = this.f10436a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.f10440e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.f10440e = 2;
            return 2;
        }
        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.isAtLeastO()) {
            this.f10440e = 2;
        } else {
            this.f10440e = 1;
        }
        return this.f10440e;
    }

    boolean g() {
        return e() != 0;
    }
}
