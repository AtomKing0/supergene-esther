package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3256p0 implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC3258q0 f24169a;

    C3256p0(RunnableC3258q0 runnableC3258q0) {
        this.f24169a = runnableC3258q0;
    }

    public final void a() {
        RunnableC3258q0 runnableC3258q0 = this.f24169a;
        runnableC3258q0.f24173a = true;
        if (runnableC3258q0.f24174b) {
            runnableC3258q0.f24175c.release();
        }
    }
}
