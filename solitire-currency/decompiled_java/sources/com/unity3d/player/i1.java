package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnityPlayer f24121a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h1 f24123c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f24122b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Semaphore f24124d = new Semaphore(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReentrantLock f24125e = new ReentrantLock();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a1 f24126f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24127g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f24128h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f24129i = false;

    i1(UnityPlayer unityPlayer) {
        this.f24121a = null;
        this.f24121a = unityPlayer;
    }

    protected void runOnUiThread(Runnable runnable) {
        Context context = this.f24122b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            AbstractC3275z.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }

    public final void a() {
        this.f24125e.lock();
        a1 a1Var = this.f24126f;
        if (a1Var != null) {
            a1Var.updateVideoLayout();
        }
        this.f24125e.unlock();
    }

    public final void b() {
        this.f24125e.lock();
        a1 a1Var = this.f24126f;
        if (a1Var != null) {
            if (this.f24127g == 0) {
                a1Var.cancelOnPrepare();
            } else if (this.f24129i) {
                boolean zA = a1Var.a();
                this.f24128h = zA;
                if (!zA) {
                    this.f24126f.pause();
                }
            }
        }
        this.f24125e.unlock();
    }

    public final void c() {
        this.f24125e.lock();
        a1 a1Var = this.f24126f;
        if (a1Var != null && this.f24129i && !this.f24128h) {
            a1Var.start();
        }
        this.f24125e.unlock();
    }

    public final boolean a(Context context, String str, int i10, int i11, int i12, boolean z10, long j10, long j11, h1 h1Var) {
        this.f24125e.lock();
        this.f24123c = h1Var;
        this.f24122b = context;
        this.f24124d.drainPermits();
        this.f24127g = 2;
        runOnUiThread(new d1(this, str, i10, i11, i12, z10, j10, j11));
        boolean z11 = false;
        try {
            this.f24125e.unlock();
            this.f24124d.acquire();
            this.f24125e.lock();
            if (this.f24127g != 2) {
                z11 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new e1(this));
        runOnUiThread((!z11 || this.f24127g == 3) ? new g1(this) : new f1(this));
        this.f24125e.unlock();
        return z11;
    }
}
