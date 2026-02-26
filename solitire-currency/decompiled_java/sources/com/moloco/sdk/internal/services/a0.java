package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18401a;

    public a0(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f18401a = context;
    }

    @Override // com.moloco.sdk.internal.services.z
    public int a() {
        Intent intentRegisterReceiver = this.f18401a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return intentRegisterReceiver.getIntExtra("status", 1);
        }
        return 1;
    }

    @Override // com.moloco.sdk.internal.services.z
    public int b() {
        Intent intentRegisterReceiver = this.f18401a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return intentRegisterReceiver.getIntExtra("scale", -1);
        }
        return -1;
    }

    @Override // com.moloco.sdk.internal.services.z
    public boolean c() {
        Object systemService = this.f18401a.getSystemService("power");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isPowerSaveMode();
    }
}
