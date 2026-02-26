package io.sentry;

/* JADX INFO: compiled from: HttpStatusCodeRange.java */
/* JADX INFO: loaded from: classes5.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28039b;

    public p0(int i10, int i11) {
        this.f28038a = i10;
        this.f28039b = i11;
    }

    public boolean a(int i10) {
        return i10 >= this.f28038a && i10 <= this.f28039b;
    }
}
