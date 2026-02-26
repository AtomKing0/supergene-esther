package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes4.dex */
final class U0 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f24025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f24026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f24027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f24028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f24029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f24030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f24031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f24032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24033i;

    private U0(UnityPlayer unityPlayer) {
        this.f24033i = unityPlayer;
        this.f24026b = false;
        this.f24027c = false;
        this.f24028d = 2;
        this.f24029e = 0;
        this.f24032h = 5;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("UnityMain");
        Looper.prepare();
        this.f24025a = new Handler(Looper.myLooper(), new T0(this));
        Looper.loop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(S0 s02) {
        Handler handler = this.f24025a;
        if (handler != null) {
            Message.obtain(handler, 2269, s02).sendToTarget();
        }
    }
}
