package com.king.usdk.lifecycle;

import android.content.Intent;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class UsdkLifecycle {
    public static native void nativeOnActivityResult(int i10, int i11, Intent intent);

    public static native void nativeOnCreate(Intent intent);

    public static native void nativeOnDestroy();

    public static native void nativeOnNewIntent(Intent intent);

    public static native void nativeOnPause();

    public static native void nativeOnRequestPermissionsResult(int i10, String[] strArr, int[] iArr);

    public static native void nativeOnRestart();

    public static native void nativeOnResume();

    public static native void nativeOnStart();

    public static native void nativeOnStop();

    public static void onActivityResult(int i10, int i11, Intent intent) {
        nativeOnActivityResult(i10, i11, intent);
    }

    public static void onCreate(Intent intent) {
        nativeOnCreate(intent);
    }

    public static void onDestroy() {
        nativeOnDestroy();
    }

    public static void onNewIntent(Intent intent) {
        nativeOnNewIntent(intent);
    }

    public static void onPause() {
        nativeOnPause();
    }

    public static void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        nativeOnRequestPermissionsResult(i10, strArr, iArr);
    }

    public static void onRestart() {
        nativeOnRestart();
    }

    public static void onResume() {
        nativeOnResume();
    }

    public static void onStart() {
        nativeOnStart();
    }

    public static void onStop() {
        nativeOnStop();
    }
}
