package w3;

import a4.c0;
import android.text.TextUtils;
import java.util.ArrayList;
import k2.j2;

/* JADX INFO: compiled from: WebvttDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends n3.h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final c0 f35417o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final c f35418p;

    public h() {
        super("WebvttDecoder");
        this.f35417o = new c0();
        this.f35418p = new c();
    }

    private static int x(c0 c0Var) {
        int i10 = -1;
        int iE = 0;
        while (i10 == -1) {
            iE = c0Var.e();
            String strP = c0Var.p();
            i10 = strP == null ? 0 : "STYLE".equals(strP) ? 2 : strP.startsWith("NOTE") ? 1 : 3;
        }
        c0Var.P(iE);
        return i10;
    }

    private static void y(c0 c0Var) {
        while (!TextUtils.isEmpty(c0Var.p())) {
        }
    }

    @Override // n3.h
    protected n3.i v(byte[] bArr, int i10, boolean z10) throws n3.k {
        e eVarM;
        this.f35417o.N(bArr, i10);
        ArrayList arrayList = new ArrayList();
        try {
            i.d(this.f35417o);
            while (!TextUtils.isEmpty(this.f35417o.p())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iX = x(this.f35417o);
                if (iX == 0) {
                    return new k(arrayList2);
                }
                if (iX == 1) {
                    y(this.f35417o);
                } else if (iX == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new n3.k("A style block was found after the first cue.");
                    }
                    this.f35417o.p();
                    arrayList.addAll(this.f35418p.d(this.f35417o));
                } else if (iX == 3 && (eVarM = f.m(this.f35417o, arrayList)) != null) {
                    arrayList2.add(eVarM);
                }
            }
        } catch (j2 e10) {
            throw new n3.k(e10);
        }
    }
}
