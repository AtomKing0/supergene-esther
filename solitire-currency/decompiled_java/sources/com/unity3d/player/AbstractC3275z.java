package com.unity3d.player;

import android.util.Log;

/* JADX INFO: renamed from: com.unity3d.player.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractC3275z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static boolean f24228a = false;

    protected static void Log(int i10, String str) {
        if (f24228a) {
            return;
        }
        if (i10 == 6) {
            Log.e("Unity", str);
        }
        if (i10 == 5) {
            Log.w("Unity", str);
        }
    }
}
