package n2;

import androidx.media3.common.C;

/* JADX INFO: compiled from: Buffer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f31560a;

    public final void a(int i10) {
        this.f31560a = i10 | this.f31560a;
    }

    public void c() {
        this.f31560a = 0;
    }

    public final void d(int i10) {
        this.f31560a = (~i10) & this.f31560a;
    }

    protected final boolean e(int i10) {
        return (this.f31560a & i10) == i10;
    }

    public final boolean f() {
        return e(268435456);
    }

    public final boolean g() {
        return e(Integer.MIN_VALUE);
    }

    public final boolean h() {
        return e(4);
    }

    public final boolean i() {
        return e(C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    public final boolean j() {
        return e(1);
    }

    public final void k(int i10) {
        this.f31560a = i10;
    }
}
