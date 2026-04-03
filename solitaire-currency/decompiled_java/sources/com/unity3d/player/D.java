package com.unity3d.player;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: loaded from: classes4.dex */
final class D extends C {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OnBackInvokedCallback f23924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OnBackInvokedDispatcher f23925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23926f;

    private D(OnBackInvokedDispatcher onBackInvokedDispatcher, int i10, Runnable runnable) {
        super(runnable);
        this.f23924d = null;
        this.f23926f = i10;
        this.f23925e = onBackInvokedDispatcher;
    }

    public static C a(Object obj, int i10, Runnable runnable) {
        C d10 = PlatformSupport.TIRAMISU_SUPPORT && ((obj instanceof Activity) || (obj instanceof Dialog)) ? new D(AbstractC3233e.a(obj), i10, runnable) : new C(runnable);
        d10.registerOnBackPressedCallback();
        return d10;
    }

    @Override // com.unity3d.player.C
    protected void registerOnBackPressedCallback() {
        if (this.f23918a != null) {
            return;
        }
        super.registerOnBackPressedCallback();
        if (PlatformSupport.TIRAMISU_SUPPORT) {
            C3231d c3231d = new C3231d(this.f23918a);
            this.f23924d = c3231d;
            AbstractC3233e.a(this.f23925e, this.f23926f, c3231d);
        }
    }

    @Override // com.unity3d.player.C
    protected void unregisterOnBackPressedCallback() {
        if (this.f23918a != null) {
            if (PlatformSupport.TIRAMISU_SUPPORT) {
                AbstractC3233e.a(this.f23925e, this.f23924d);
                this.f23924d = null;
            }
            super.unregisterOnBackPressedCallback();
        }
    }
}
