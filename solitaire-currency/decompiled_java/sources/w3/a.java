package w3;

import a4.c0;
import a4.o0;
import java.util.ArrayList;
import java.util.Collections;
import n3.b;

/* JADX INFO: compiled from: Mp4WebvttDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends n3.h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final c0 f35367o;

    public a() {
        super("Mp4WebvttDecoder");
        this.f35367o = new c0();
    }

    private static n3.b x(c0 c0Var, int i10) throws n3.k {
        CharSequence charSequenceQ = null;
        b.C0631b c0631bO = null;
        while (i10 > 0) {
            if (i10 < 8) {
                throw new n3.k("Incomplete vtt cue box header found.");
            }
            int iN = c0Var.n();
            int iN2 = c0Var.n();
            int i11 = iN - 8;
            String strB = o0.B(c0Var.d(), c0Var.e(), i11);
            c0Var.Q(i11);
            i10 = (i10 - 8) - i11;
            if (iN2 == 1937011815) {
                c0631bO = f.o(strB);
            } else if (iN2 == 1885436268) {
                charSequenceQ = f.q(null, strB.trim(), Collections.emptyList());
            }
        }
        if (charSequenceQ == null) {
            charSequenceQ = "";
        }
        return c0631bO != null ? c0631bO.o(charSequenceQ).a() : f.l(charSequenceQ);
    }

    @Override // n3.h
    protected n3.i v(byte[] bArr, int i10, boolean z10) throws n3.k {
        this.f35367o.N(bArr, i10);
        ArrayList arrayList = new ArrayList();
        while (this.f35367o.a() > 0) {
            if (this.f35367o.a() < 8) {
                throw new n3.k("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iN = this.f35367o.n();
            if (this.f35367o.n() == 1987343459) {
                arrayList.add(x(this.f35367o, iN - 8));
            } else {
                this.f35367o.Q(iN - 8);
            }
        }
        return new b(arrayList);
    }
}
