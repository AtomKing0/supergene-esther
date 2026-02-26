package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* JADX INFO: renamed from: com.unity3d.player.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3236f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f24099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C3234e0 f24100b;

    public C3236f0(Context context) {
        this.f24099a = context;
    }

    public final void a() {
        if (this.f24100b != null) {
            this.f24099a.getContentResolver().unregisterContentObserver(this.f24100b);
            this.f24100b = null;
        }
    }

    public final void a(InterfaceC3232d0 interfaceC3232d0) {
        this.f24100b = new C3234e0(new Handler(Looper.getMainLooper()), interfaceC3232d0);
        this.f24099a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f24100b);
    }
}
