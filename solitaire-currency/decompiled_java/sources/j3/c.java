package j3;

import a4.b0;
import a4.c0;
import a4.l0;
import c3.a;
import c3.h;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SpliceInfoDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f28632a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b0 f28633b = new b0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l0 f28634c;

    @Override // c3.h
    protected c3.a b(c3.e eVar, ByteBuffer byteBuffer) {
        l0 l0Var = this.f28634c;
        if (l0Var == null || eVar.f4495i != l0Var.e()) {
            l0 l0Var2 = new l0(eVar.f31588e);
            this.f28634c = l0Var2;
            l0Var2.a(eVar.f31588e - eVar.f4495i);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f28632a.N(bArrArray, iLimit);
        this.f28633b.o(bArrArray, iLimit);
        this.f28633b.r(39);
        long jH = (((long) this.f28633b.h(1)) << 32) | ((long) this.f28633b.h(32));
        this.f28633b.r(20);
        int iH = this.f28633b.h(12);
        int iH2 = this.f28633b.h(8);
        this.f28632a.Q(14);
        a.b bVarA = iH2 != 0 ? iH2 != 255 ? iH2 != 4 ? iH2 != 5 ? iH2 != 6 ? null : g.a(this.f28632a, jH, this.f28634c) : d.a(this.f28632a, jH, this.f28634c) : f.a(this.f28632a) : a.a(this.f28632a, iH, jH) : new e();
        return bVarA == null ? new c3.a(new a.b[0]) : new c3.a(bVarA);
    }
}
