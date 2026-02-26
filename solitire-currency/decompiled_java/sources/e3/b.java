package e3;

import a4.c0;
import c3.e;
import c3.h;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: EventMessageDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends h {
    @Override // c3.h
    protected c3.a b(e eVar, ByteBuffer byteBuffer) {
        return new c3.a(c(new c0(byteBuffer.array(), byteBuffer.limit())));
    }

    public a c(c0 c0Var) {
        return new a((String) a4.a.e(c0Var.x()), (String) a4.a.e(c0Var.x()), c0Var.w(), c0Var.w(), Arrays.copyOfRange(c0Var.d(), c0Var.e(), c0Var.f()));
    }
}
