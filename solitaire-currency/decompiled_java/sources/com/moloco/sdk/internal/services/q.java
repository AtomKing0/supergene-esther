package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.core.content.ContextCompat;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final v8.l f18812b;

    public static final class a extends kotlin.jvm.internal.v implements h9.a<Boolean> {
        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(q.this.f18811a.getResources().getBoolean(com.moloco.sdk.o.f18852a));
        }
    }

    public q(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f18811a = context;
        this.f18812b = v8.n.a(new a());
    }

    @Override // com.moloco.sdk.internal.services.h0
    @NotNull
    public g0 b() {
        String str = Build.MANUFACTURER;
        String str2 = str == null ? "" : str;
        String str3 = Build.MODEL;
        String str4 = str3 == null ? "" : str3;
        String str5 = Build.HARDWARE;
        String str6 = str5 == null ? "" : str5;
        boolean zE = e();
        String RELEASE = Build.VERSION.RELEASE;
        kotlin.jvm.internal.t.h(RELEASE, "RELEASE");
        int i10 = Build.VERSION.SDK_INT;
        String language = Locale.getDefault().getLanguage();
        kotlin.jvm.internal.t.h(language, "getDefault().language");
        TelephonyManager telephonyManager = (TelephonyManager) ContextCompat.getSystemService(this.f18811a, TelephonyManager.class);
        String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : null;
        if (networkOperatorName == null) {
            networkOperatorName = "";
        }
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        String str7 = str5 == null ? "" : str5;
        String str8 = Build.BRAND;
        return new g0(str2, str4, str6, zE, "android", RELEASE, i10, language, networkOperatorName, f10, jCurrentTimeMillis, str7, str8 == null ? "" : str8);
    }

    @Override // com.moloco.sdk.internal.services.h0
    @NotNull
    public String c() {
        String language = Locale.getDefault().getLanguage();
        kotlin.jvm.internal.t.h(language, "getDefault().language");
        return language;
    }

    @Override // com.moloco.sdk.internal.services.h0
    @Nullable
    public String d() {
        Object systemService = this.f18811a.getSystemService("input_method");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) systemService).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype != null) {
            return currentInputMethodSubtype.getLocale();
        }
        return null;
    }

    public final boolean e() {
        return ((Boolean) this.f18812b.getValue()).booleanValue();
    }

    @Override // com.moloco.sdk.internal.services.h0
    @NotNull
    public g0 invoke() {
        return b();
    }

    @Override // com.moloco.sdk.internal.services.h0
    @Nullable
    public Boolean a() {
        try {
            Object systemService = this.f18811a.getSystemService("sensor");
            kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            return Boolean.valueOf(((SensorManager) systemService).getDefaultSensor(4) != null);
        } catch (Exception unused) {
            return null;
        }
    }
}
