package p8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Output.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final void a(@NotNull p pVar, @NotNull a src, int i10) {
        t.i(pVar, "<this>");
        t.i(src, "src");
        q8.a aVarD = q8.g.d(pVar, 1, null);
        while (true) {
            try {
                int iMin = Math.min(i10, aVarD.f() - aVarD.j());
                f.c(aVarD, src, iMin);
                i10 -= iMin;
                if (!(i10 > 0)) {
                    return;
                } else {
                    aVarD = q8.g.d(pVar, 1, aVarD);
                }
            } finally {
                pVar.c();
            }
        }
    }

    public static final void b(@NotNull p pVar, @NotNull byte[] src, int i10, int i11) {
        t.i(pVar, "<this>");
        t.i(src, "src");
        q8.a aVarD = q8.g.d(pVar, 1, null);
        while (true) {
            try {
                int iMin = Math.min(i11, aVarD.f() - aVarD.j());
                f.d(aVarD, src, i10, iMin);
                i10 += iMin;
                i11 -= iMin;
                if (!(i11 > 0)) {
                    return;
                } else {
                    aVarD = q8.g.d(pVar, 1, aVarD);
                }
            } finally {
                pVar.c();
            }
        }
    }

    public static /* synthetic */ void c(p pVar, a aVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = aVar.j() - aVar.h();
        }
        a(pVar, aVar, i10);
    }
}
