package com.ironsource;

import android.adservices.measurement.MeasurementManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.media3.common.PlaybackException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g1 f12196a = new g1();

    private g1() {
    }

    @SuppressLint({"WrongConstant", "NewApi"})
    public static final int a() {
        if (Build.VERSION.SDK_INT < 30) {
            return 0;
        }
        try {
            return SdkExtensions.getExtensionVersion(PlaybackException.CUSTOM_ERROR_CODE_BASE);
        } catch (Exception e10) {
            i9.d().a(e10);
            return 0;
        }
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public static final MeasurementManager a(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        if (Build.VERSION.SDK_INT < 30 || a() < 4) {
            return null;
        }
        try {
            return (MeasurementManager) context.getSystemService(MeasurementManager.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ void b() {
    }
}
