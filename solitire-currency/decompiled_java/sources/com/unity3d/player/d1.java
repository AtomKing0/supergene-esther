package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f24087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f24090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f24091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f24092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f24093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ i1 f24094h;

    d1(i1 i1Var, String str, int i10, int i11, int i12, boolean z10, long j10, long j11) {
        this.f24094h = i1Var;
        this.f24087a = str;
        this.f24088b = i10;
        this.f24089c = i11;
        this.f24090d = i12;
        this.f24091e = z10;
        this.f24092f = j10;
        this.f24093g = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i1 i1Var = this.f24094h;
        if (i1Var.f24126f != null) {
            AbstractC3275z.Log(5, "Video already playing");
            i1 i1Var2 = this.f24094h;
            i1Var2.f24127g = 2;
            i1Var2.f24124d.release();
            return;
        }
        i1 i1Var3 = this.f24094h;
        i1Var.f24126f = new a1(i1Var3.f24122b, i1Var3.f24121a, this.f24087a, this.f24088b, this.f24089c, this.f24090d, this.f24091e, this.f24092f, this.f24093g, new c1(this));
        i1 i1Var4 = this.f24094h;
        if (i1Var4.f24126f != null) {
            i1Var4.f24121a.bringToFront();
            i1 i1Var5 = this.f24094h;
            i1Var5.f24121a.addView(i1Var5.f24126f);
        }
    }
}
