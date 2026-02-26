package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* JADX INFO: renamed from: com.unity3d.player.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3257q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f24170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f24171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C3253o f24172c;

    public C3257q(Context context) {
        this.f24170a = context;
        this.f24171b = (AudioManager) context.getSystemService("audio");
    }

    public final void a() {
        if (this.f24172c != null) {
            this.f24170a.getContentResolver().unregisterContentObserver(this.f24172c);
            this.f24172c = null;
        }
    }

    public final void a(InterfaceC3255p interfaceC3255p) {
        this.f24172c = new C3253o(new Handler(Looper.getMainLooper()), this.f24171b, interfaceC3255p);
        this.f24170a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f24172c);
    }
}
