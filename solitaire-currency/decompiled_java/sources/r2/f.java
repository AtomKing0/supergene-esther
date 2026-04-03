package r2;

import a4.c0;
import androidx.annotation.Nullable;
import androidx.media3.extractor.avi.AviExtractor;
import com.google.common.collect.i1;
import com.google.common.collect.y;

/* JADX INFO: compiled from: ListChunk.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y<a> f33298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f33299b;

    private f(int i10, y<a> yVar) {
        this.f33299b = i10;
        this.f33298a = yVar;
    }

    @Nullable
    private static a a(int i10, int i11, c0 c0Var) {
        switch (i10) {
            case AviExtractor.FOURCC_strf /* 1718776947 */:
                return g.d(i11, c0Var);
            case AviExtractor.FOURCC_avih /* 1751742049 */:
                return c.b(c0Var);
            case AviExtractor.FOURCC_strh /* 1752331379 */:
                return d.c(c0Var);
            case AviExtractor.FOURCC_strn /* 1852994675 */:
                return h.a(c0Var);
            default:
                return null;
        }
    }

    public static f c(int i10, c0 c0Var) {
        y.a aVar = new y.a();
        int iF = c0Var.f();
        int iB = -2;
        while (c0Var.a() > 8) {
            int iQ = c0Var.q();
            int iE = c0Var.e() + c0Var.q();
            c0Var.O(iE);
            a aVarC = iQ == 1414744396 ? c(c0Var.q(), c0Var) : a(iQ, iB, c0Var);
            if (aVarC != null) {
                if (aVarC.getType() == 1752331379) {
                    iB = ((d) aVarC).b();
                }
                aVar.a(aVarC);
            }
            c0Var.P(iE);
            c0Var.O(iF);
        }
        return new f(i10, aVar.k());
    }

    @Nullable
    public <T extends a> T b(Class<T> cls) {
        i1<a> it = this.f33298a.iterator();
        while (it.hasNext()) {
            T t10 = (T) it.next();
            if (t10.getClass() == cls) {
                return t10;
            }
        }
        return null;
    }

    @Override // r2.a
    public int getType() {
        return this.f33299b;
    }
}
