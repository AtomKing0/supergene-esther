package com.unity3d.player;

import android.os.Build;
import java.lang.Thread;
import java.util.Arrays;

/* JADX INFO: renamed from: com.unity3d.player.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3238g0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Thread.UncaughtExceptionHandler f24109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24110b;

    C3238g0() {
    }

    final synchronized void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            return;
        }
        this.f24109a = defaultUncaughtExceptionHandler;
        this.f24110b = "Unknown";
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Error error = new Error(String.format("FATAL EXCEPTION [%s]\n", thread.getName()) + String.format("Unity version     : %s\n", "2022.3.62f2") + String.format("Device model      : %s %s\n", Build.MANUFACTURER, Build.MODEL) + String.format("Device fingerprint: %s\n", Build.FINGERPRINT) + String.format("CPU supported ABI : %s\n", Arrays.toString(Build.SUPPORTED_ABIS)) + String.format("Build Type        : %s\n", "Release") + String.format("Scripting Backend : %s\n", "IL2CPP") + String.format("Libs loaded from  : %s\n", this.f24110b) + String.format("Strip Engine Code : %s\n", Boolean.TRUE));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f24109a.uncaughtException(thread, error);
        } catch (Throwable unused) {
            this.f24109a.uncaughtException(thread, th);
        }
    }

    static void a(String str) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C3238g0) {
            C3238g0 c3238g0 = (C3238g0) defaultUncaughtExceptionHandler;
            int i10 = -1;
            int i11 = -1;
            while (true) {
                int iIndexOf = str.indexOf(47, i10 + 1);
                if (iIndexOf == -1) {
                    break;
                }
                i11 = i10;
                i10 = iIndexOf;
            }
            c3238g0.f24110b = i11 < 0 ? "Unknown" : str.substring(i11 + 1);
        }
    }
}
