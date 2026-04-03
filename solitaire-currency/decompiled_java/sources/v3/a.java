package v3;

import a4.c0;
import a4.o0;
import a4.t;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.C;
import e5.e;
import java.util.List;
import n3.b;
import n3.h;
import n3.i;
import n3.k;

/* JADX INFO: compiled from: Tx3gDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final c0 f35103o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f35104p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f35105q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f35106r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f35107s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final float f35108t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f35109u;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f35103o = new c0();
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.f35105q = 0;
            this.f35106r = -1;
            this.f35107s = C.SANS_SERIF_NAME;
            this.f35104p = false;
            this.f35108t = 0.85f;
            this.f35109u = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.f35105q = bArr[24];
        this.f35106r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f35107s = "Serif".equals(o0.B(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : str;
        int i10 = bArr[25] * 20;
        this.f35109u = i10;
        boolean z10 = (bArr[0] & 32) != 0;
        this.f35104p = z10;
        if (z10) {
            this.f35108t = o0.o(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i10, 0.0f, 0.95f);
        } else {
            this.f35108t = 0.85f;
        }
    }

    private static void A(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            int i15 = i14 | 33;
            boolean z10 = (i10 & 1) != 0;
            boolean z11 = (i10 & 2) != 0;
            if (z10) {
                if (z11) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i12, i13, i15);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i12, i13, i15);
                }
            } else if (z11) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i12, i13, i15);
            }
            boolean z12 = (i10 & 4) != 0;
            if (z12) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i12, i13, i15);
            }
            if (z12 || z10 || z11) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i12, i13, i15);
        }
    }

    private static void B(SpannableStringBuilder spannableStringBuilder, String str, int i10, int i11) {
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i10, i11, 16711713);
        }
    }

    private static String C(c0 c0Var) throws k {
        char cG;
        y(c0Var.a() >= 2);
        int iJ = c0Var.J();
        return iJ == 0 ? "" : (c0Var.a() < 2 || !((cG = c0Var.g()) == 65279 || cG == 65534)) ? c0Var.B(iJ, e.f25140c) : c0Var.B(iJ, e.f25143f);
    }

    private void x(c0 c0Var, SpannableStringBuilder spannableStringBuilder) throws k {
        y(c0Var.a() >= 12);
        int iJ = c0Var.J();
        int iJ2 = c0Var.J();
        c0Var.Q(2);
        int iD = c0Var.D();
        c0Var.Q(1);
        int iN = c0Var.n();
        if (iJ2 > spannableStringBuilder.length()) {
            t.i("Tx3gDecoder", "Truncating styl end (" + iJ2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iJ2 = spannableStringBuilder.length();
        }
        if (iJ < iJ2) {
            int i10 = iJ2;
            A(spannableStringBuilder, iD, this.f35105q, iJ, i10, 0);
            z(spannableStringBuilder, iN, this.f35106r, iJ, i10, 0);
            return;
        }
        t.i("Tx3gDecoder", "Ignoring styl with start (" + iJ + ") >= end (" + iJ2 + ").");
    }

    private static void y(boolean z10) throws k {
        if (!z10) {
            throw new k("Unexpected subtitle format.");
        }
    }

    private static void z(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i10 >>> 8) | ((i10 & 255) << 24)), i12, i13, i14 | 33);
        }
    }

    @Override // n3.h
    protected i v(byte[] bArr, int i10, boolean z10) throws k {
        this.f35103o.N(bArr, i10);
        String strC = C(this.f35103o);
        if (strC.isEmpty()) {
            return b.f35110b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strC);
        A(spannableStringBuilder, this.f35105q, 0, 0, spannableStringBuilder.length(), 16711680);
        z(spannableStringBuilder, this.f35106r, -1, 0, spannableStringBuilder.length(), 16711680);
        B(spannableStringBuilder, this.f35107s, 0, spannableStringBuilder.length());
        float fO = this.f35108t;
        while (this.f35103o.a() >= 8) {
            int iE = this.f35103o.e();
            int iN = this.f35103o.n();
            int iN2 = this.f35103o.n();
            if (iN2 == 1937013100) {
                y(this.f35103o.a() >= 2);
                int iJ = this.f35103o.J();
                for (int i11 = 0; i11 < iJ; i11++) {
                    x(this.f35103o, spannableStringBuilder);
                }
            } else if (iN2 == 1952608120 && this.f35104p) {
                y(this.f35103o.a() >= 2);
                fO = o0.o(this.f35103o.J() / this.f35109u, 0.0f, 0.95f);
            }
            this.f35103o.P(iE + iN);
        }
        return new b(new b.C0631b().o(spannableStringBuilder).h(fO, 0).i(0).a());
    }
}
