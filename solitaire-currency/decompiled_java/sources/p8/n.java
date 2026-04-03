package p8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputArrays.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final void a(@NotNull m mVar, @NotNull a dst, int i10) throws Throwable {
        t.i(mVar, "<this>");
        t.i(dst, "dst");
        boolean z10 = true;
        q8.a aVarB = q8.g.b(mVar, 1);
        if (aVarB != null) {
            while (true) {
                try {
                    int iMin = Math.min(i10, aVarB.j() - aVarB.h());
                    f.a(aVarB, dst, iMin);
                    i10 -= iMin;
                    if (!(i10 > 0)) {
                        break;
                    }
                    try {
                        q8.a aVarC = q8.g.c(mVar, aVarB);
                        if (aVarC == null) {
                            z10 = false;
                            break;
                        }
                        aVarB = aVarC;
                    } catch (Throwable th) {
                        th = th;
                        z10 = false;
                        if (z10) {
                            q8.g.a(mVar, aVarB);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z10) {
                q8.g.a(mVar, aVarB);
            }
        }
        if (i10 <= 0) {
            return;
        }
        s.a(i10);
        throw new v8.h();
    }

    public static final void b(@NotNull m mVar, @NotNull byte[] dst, int i10, int i11) {
        t.i(mVar, "<this>");
        t.i(dst, "dst");
        boolean z10 = true;
        q8.a aVarB = q8.g.b(mVar, 1);
        if (aVarB != null) {
            while (true) {
                try {
                    int iMin = Math.min(i11, aVarB.j() - aVarB.h());
                    f.b(aVarB, dst, i10, iMin);
                    i11 -= iMin;
                    i10 += iMin;
                    if (!(i11 > 0)) {
                        break;
                    }
                    try {
                        q8.a aVarC = q8.g.c(mVar, aVarB);
                        if (aVarC == null) {
                            z10 = false;
                            break;
                        }
                        aVarB = aVarC;
                    } catch (Throwable th) {
                        th = th;
                        z10 = false;
                        if (z10) {
                            q8.g.a(mVar, aVarB);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z10) {
                q8.g.a(mVar, aVarB);
            }
        }
        if (i11 <= 0) {
            return;
        }
        s.a(i11);
        throw new v8.h();
    }
}
