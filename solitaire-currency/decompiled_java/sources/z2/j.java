package z2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: DefaultTsPayloadReaderFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements i0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<o1> f37149b;

    public j(int i10) {
        this(i10, com.google.common.collect.y.q());
    }

    private d0 b(i0.b bVar) {
        return new d0(d(bVar));
    }

    private k0 c(i0.b bVar) {
        return new k0(d(bVar));
    }

    private List<o1> d(i0.b bVar) {
        String str;
        int i10;
        if (e(32)) {
            return this.f37149b;
        }
        a4.c0 c0Var = new a4.c0(bVar.f37142d);
        List<o1> arrayList = this.f37149b;
        while (c0Var.a() > 0) {
            int iD = c0Var.D();
            int iE = c0Var.e() + c0Var.D();
            if (iD == 134) {
                arrayList = new ArrayList<>();
                int iD2 = c0Var.D() & 31;
                for (int i11 = 0; i11 < iD2; i11++) {
                    String strA = c0Var.A(3);
                    int iD3 = c0Var.D();
                    boolean z10 = (iD3 & 128) != 0;
                    if (z10) {
                        i10 = iD3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i10 = 1;
                    }
                    byte bD = (byte) c0Var.D();
                    c0Var.Q(1);
                    arrayList.add(new o1.b().e0(str).V(strA).F(i10).T(z10 ? a4.e.b((bD & 64) != 0) : null).E());
                }
            }
            c0Var.P(iE);
        }
        return arrayList;
    }

    private boolean e(int i10) {
        return (i10 & this.f37148a) != 0;
    }

    @Override // z2.i0.c
    @Nullable
    public i0 a(int i10, i0.b bVar) {
        if (i10 != 2) {
            if (i10 == 3 || i10 == 4) {
                return new w(new t(bVar.f37140b));
            }
            if (i10 == 21) {
                return new w(new r());
            }
            if (i10 == 27) {
                if (e(4)) {
                    return null;
                }
                return new w(new p(b(bVar), e(1), e(8)));
            }
            if (i10 == 36) {
                return new w(new q(b(bVar)));
            }
            if (i10 == 89) {
                return new w(new l(bVar.f37141c));
            }
            if (i10 != 138) {
                if (i10 == 172) {
                    return new w(new f(bVar.f37140b));
                }
                if (i10 == 257) {
                    return new c0(new v(MimeTypes.APPLICATION_AIT));
                }
                if (i10 == 134) {
                    if (e(16)) {
                        return null;
                    }
                    return new c0(new v(MimeTypes.APPLICATION_SCTE35));
                }
                if (i10 != 135) {
                    switch (i10) {
                        case 15:
                            if (!e(2)) {
                                break;
                            }
                            break;
                        case 16:
                            break;
                        case 17:
                            if (!e(2)) {
                                break;
                            }
                            break;
                        default:
                            switch (i10) {
                                case 130:
                                    if (!e(64)) {
                                    }
                                    break;
                            }
                            break;
                    }
                    return null;
                }
                return new w(new c(bVar.f37140b));
            }
            return new w(new k(bVar.f37140b));
        }
        return new w(new n(c(bVar)));
    }

    @Override // z2.i0.c
    public SparseArray<i0> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    public j(int i10, List<o1> list) {
        this.f37148a = i10;
        this.f37149b = list;
    }
}
