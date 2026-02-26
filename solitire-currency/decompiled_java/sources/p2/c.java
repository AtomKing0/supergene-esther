package p2;

import androidx.media3.common.C;

/* JADX INFO: compiled from: CeaUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static void a(long j10, a4.c0 c0Var, e0[] e0VarArr) {
        while (true) {
            if (c0Var.a() <= 1) {
                return;
            }
            int iC = c(c0Var);
            int iC2 = c(c0Var);
            int iE = c0Var.e() + iC2;
            if (iC2 == -1 || iC2 > c0Var.a()) {
                a4.t.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iE = c0Var.f();
            } else if (iC == 4 && iC2 >= 8) {
                int iD = c0Var.D();
                int iJ = c0Var.J();
                int iN = iJ == 49 ? c0Var.n() : 0;
                int iD2 = c0Var.D();
                if (iJ == 47) {
                    c0Var.Q(1);
                }
                boolean z10 = iD == 181 && (iJ == 49 || iJ == 47) && iD2 == 3;
                if (iJ == 49) {
                    z10 &= iN == 1195456820;
                }
                if (z10) {
                    b(j10, c0Var, e0VarArr);
                }
            }
            c0Var.P(iE);
        }
    }

    public static void b(long j10, a4.c0 c0Var, e0[] e0VarArr) {
        int iD = c0Var.D();
        if ((iD & 64) != 0) {
            c0Var.Q(1);
            int i10 = (iD & 31) * 3;
            int iE = c0Var.e();
            for (e0 e0Var : e0VarArr) {
                c0Var.P(iE);
                e0Var.e(c0Var, i10);
                if (j10 != C.TIME_UNSET) {
                    e0Var.a(j10, 1, i10, 0, null);
                }
            }
        }
    }

    private static int c(a4.c0 c0Var) {
        int i10 = 0;
        while (c0Var.a() != 0) {
            int iD = c0Var.D();
            i10 += iD;
            if (iD != 255) {
                return i10;
            }
        }
        return -1;
    }
}
