package e8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends g8.v {
    public l() {
        this(0, 1, null);
    }

    @Override // g8.v
    protected void l(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        super.l(name);
        o.f25274a.a(name);
    }

    @Override // g8.v
    protected void m(@NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
        super.m(value);
        o.f25274a.b(value);
    }

    @NotNull
    public k n() {
        return new m(i());
    }

    public l(int i10) {
        super(true, i10);
    }

    public /* synthetic */ l(int i10, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? 8 : i10);
    }
}
