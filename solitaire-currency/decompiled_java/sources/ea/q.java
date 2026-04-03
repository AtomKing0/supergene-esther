package ea;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f25473c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull o0 writer, boolean z10) {
        super(writer);
        kotlin.jvm.internal.t.i(writer, "writer");
        this.f25473c = z10;
    }

    @Override // ea.j
    public void d(byte b10) {
        boolean z10 = this.f25473c;
        String strF = v8.a0.f(v8.a0.c(b10));
        if (z10) {
            m(strF);
        } else {
            j(strF);
        }
    }

    @Override // ea.j
    public void h(int i10) {
        boolean z10 = this.f25473c;
        int iC = v8.c0.c(i10);
        if (z10) {
            m(Long.toString(((long) iC) & 4294967295L, 10));
        } else {
            j(Long.toString(((long) iC) & 4294967295L, 10));
        }
    }

    @Override // ea.j
    public void i(long j10) {
        boolean z10 = this.f25473c;
        long jC = v8.e0.c(j10);
        if (z10) {
            m(p.a(jC, 10));
        } else {
            j(o.a(jC, 10));
        }
    }

    @Override // ea.j
    public void k(short s10) {
        boolean z10 = this.f25473c;
        String strF = v8.h0.f(v8.h0.c(s10));
        if (z10) {
            m(strF);
        } else {
            j(strF);
        }
    }
}
