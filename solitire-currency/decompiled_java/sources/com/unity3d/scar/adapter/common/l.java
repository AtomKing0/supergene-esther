package com.unity3d.scar.adapter.common;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes4.dex */
public class l {
    public static void a(Runnable runnable) {
        b(runnable, 0L);
    }

    public static void b(Runnable runnable, long j10) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, j10);
    }
}
