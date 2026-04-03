package b3;

import a4.o0;
import b3.b;
import b3.l;
import b3.x;
import java.io.IOException;

/* JADX INFO: compiled from: DefaultMediaCodecAdapterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements l.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1985a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1986b;

    @Override // b3.l.b
    public l a(l.a aVar) throws IOException {
        int i10;
        int i11 = o0.f214a;
        if (i11 < 23 || ((i10 = this.f1985a) != 1 && (i10 != 0 || i11 < 31))) {
            return new x.b().a(aVar);
        }
        int i12 = a4.x.i(aVar.f1994c.f29347l);
        a4.t.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + o0.g0(i12));
        return new b.C0148b(i12, this.f1986b).a(aVar);
    }
}
