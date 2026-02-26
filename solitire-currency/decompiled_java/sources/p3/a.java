package p3;

import a4.c0;
import java.util.List;
import n3.h;
import n3.i;

/* JADX INFO: compiled from: DvbDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final b f32555o;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        c0 c0Var = new c0(list.get(0));
        this.f32555o = new b(c0Var.J(), c0Var.J());
    }

    @Override // n3.h
    protected i v(byte[] bArr, int i10, boolean z10) {
        if (z10) {
            this.f32555o.r();
        }
        return new c(this.f32555o.b(bArr, i10));
    }
}
