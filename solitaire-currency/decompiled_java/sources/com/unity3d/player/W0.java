package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class W0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f24037e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24038a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24039b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24040c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f24041d = false;

    W0() {
    }

    static void e() {
        f24037e = true;
    }

    static void f() {
        f24037e = false;
    }

    final boolean a() {
        return this.f24041d;
    }

    final void b(boolean z10) {
        this.f24038a = z10;
    }

    final void c(boolean z10) {
        this.f24039b = z10;
    }

    final void d(boolean z10) {
        this.f24041d = z10;
    }

    public final String toString() {
        return super.toString();
    }

    static boolean d() {
        return f24037e;
    }

    final boolean a(boolean z10) {
        return f24037e && !((!z10 && !this.f24038a) || this.f24040c || this.f24039b);
    }

    final boolean b() {
        return this.f24040c;
    }

    final boolean c() {
        return this.f24039b;
    }

    final void e(boolean z10) {
        this.f24040c = z10;
    }
}
