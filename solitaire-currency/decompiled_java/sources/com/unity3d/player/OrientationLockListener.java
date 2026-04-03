package com.unity3d.player;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes4.dex */
public class OrientationLockListener implements InterfaceC3232d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3236f0 f23977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f23978b;

    OrientationLockListener(Context context) {
        this.f23978b = context;
        this.f23977a = new C3236f0(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0));
        this.f23977a.a(this);
    }

    public final void a() {
        this.f23977a.a();
        this.f23977a = null;
    }

    public final void b() {
        nativeUpdateOrientationLockState(Settings.System.getInt(this.f23978b.getContentResolver(), "accelerometer_rotation", 0));
    }

    public final native void nativeUpdateOrientationLockState(int i10);
}
