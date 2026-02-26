package o3;

import a4.b0;
import a4.c0;
import a4.t;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.media3.extractor.ts.TsExtractor;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import n3.b;
import n3.i;
import n3.k;
import n3.n;
import n3.o;
import o3.c;

/* JADX INFO: compiled from: Cea708Decoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c0 f31983g = new c0();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b0 f31984h = new b0();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31985i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f31986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f31987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b[] f31988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f31989m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private List<n3.b> f31990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private List<n3.b> f31991o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private C0640c f31992p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31993q;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Cea708Decoder.java */
    static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Comparator<a> f31994c = new Comparator() { // from class: o3.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.a.c((c.a) obj, (c.a) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n3.b f31995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31996b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12, boolean z10, int i13, int i14) {
            b.C0631b c0631bN = new b.C0631b().o(charSequence).p(alignment).h(f10, i10).i(i11).k(f11).l(i12).n(f12);
            if (z10) {
                c0631bN.s(i13);
            }
            this.f31995a = c0631bN.a();
            this.f31996b = i14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f31996b, aVar.f31996b);
        }
    }

    /* JADX INFO: compiled from: Cea708Decoder.java */
    private static final class b {
        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f31997w = h(2, 2, 2, 0);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f31998x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f31999y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final int[] f32000z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<SpannableString> f32001a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SpannableStringBuilder f32002b = new SpannableStringBuilder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f32003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f32004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f32005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f32006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f32007g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f32008h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f32009i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f32010j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f32011k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f32012l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f32013m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f32014n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f32015o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f32016p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f32017q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f32018r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f32019s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f32020t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f32021u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f32022v;

        static {
            int iH = h(0, 0, 0, 0);
            f31998x = iH;
            int iH2 = h(0, 0, 0, 3);
            f31999y = iH2;
            f32000z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{iH, iH2, iH, iH, iH2, iH, iH};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{iH, iH, iH, iH, iH, iH2, iH2};
        }

        public b() {
            l();
        }

        public static int g(int i10, int i11, int i12) {
            return h(i10, i11, i12, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                a4.a.c(r4, r0, r1)
                a4.a.c(r5, r0, r1)
                a4.a.c(r6, r0, r1)
                a4.a.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L21
                if (r7 == r1) goto L21
                r3 = 2
                if (r7 == r3) goto L1e
                r3 = 3
                if (r7 == r3) goto L1c
                goto L21
            L1c:
                r7 = r0
                goto L22
            L1e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L22
            L21:
                r7 = r2
            L22:
                if (r4 <= r1) goto L26
                r4 = r2
                goto L27
            L26:
                r4 = r0
            L27:
                if (r5 <= r1) goto L2b
                r5 = r2
                goto L2c
            L2b:
                r5 = r0
            L2c:
                if (r6 <= r1) goto L2f
                r0 = r2
            L2f:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: o3.c.b.h(int, int, int, int):int");
        }

        public void a(char c10) {
            if (c10 != '\n') {
                this.f32002b.append(c10);
                return;
            }
            this.f32001a.add(d());
            this.f32002b.clear();
            if (this.f32016p != -1) {
                this.f32016p = 0;
            }
            if (this.f32017q != -1) {
                this.f32017q = 0;
            }
            if (this.f32018r != -1) {
                this.f32018r = 0;
            }
            if (this.f32020t != -1) {
                this.f32020t = 0;
            }
            while (true) {
                if ((!this.f32011k || this.f32001a.size() < this.f32010j) && this.f32001a.size() < 15) {
                    return;
                } else {
                    this.f32001a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.f32002b.length();
            if (length > 0) {
                this.f32002b.delete(length - 1, length);
            }
        }

        @Nullable
        public a c() {
            Layout.Alignment alignment;
            float f10;
            float f11;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i10 = 0; i10 < this.f32001a.size(); i10++) {
                spannableStringBuilder.append((CharSequence) this.f32001a.get(i10));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i11 = this.f32012l;
            if (i11 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i11 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f32012l);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.f32006f) {
                f10 = this.f32008h / 99.0f;
                f11 = this.f32007g / 99.0f;
            } else {
                f10 = this.f32008h / 209.0f;
                f11 = this.f32007g / 74.0f;
            }
            float f12 = (f10 * 0.9f) + 0.05f;
            float f13 = (f11 * 0.9f) + 0.05f;
            int i12 = this.f32009i;
            return new a(spannableStringBuilder, alignment2, f13, 0, i12 / 3 == 0 ? 0 : i12 / 3 == 1 ? 1 : 2, f12, i12 % 3 == 0 ? 0 : i12 % 3 == 1 ? 1 : 2, -3.4028235E38f, this.f32015o != f31998x, this.f32015o, this.f32005e);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f32002b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f32016p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f32016p, length, 33);
                }
                if (this.f32017q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f32017q, length, 33);
                }
                if (this.f32018r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f32019s), this.f32018r, length, 33);
                }
                if (this.f32020t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f32021u), this.f32020t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f32001a.clear();
            this.f32002b.clear();
            this.f32016p = -1;
            this.f32017q = -1;
            this.f32018r = -1;
            this.f32020t = -1;
            this.f32022v = 0;
        }

        public void f(boolean z10, boolean z11, boolean z12, int i10, boolean z13, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f32003c = true;
            this.f32004d = z10;
            this.f32011k = z11;
            this.f32005e = i10;
            this.f32006f = z13;
            this.f32007g = i11;
            this.f32008h = i12;
            this.f32009i = i15;
            int i18 = i13 + 1;
            if (this.f32010j != i18) {
                this.f32010j = i18;
                while (true) {
                    if ((!z11 || this.f32001a.size() < this.f32010j) && this.f32001a.size() < 15) {
                        break;
                    } else {
                        this.f32001a.remove(0);
                    }
                }
            }
            if (i16 != 0 && this.f32013m != i16) {
                this.f32013m = i16;
                int i19 = i16 - 1;
                q(D[i19], f31999y, C[i19], 0, A[i19], B[i19], f32000z[i19]);
            }
            if (i17 == 0 || this.f32014n == i17) {
                return;
            }
            this.f32014n = i17;
            int i20 = i17 - 1;
            m(0, 1, 1, false, false, F[i20], E[i20]);
            n(f31997w, G[i20], f31998x);
        }

        public boolean i() {
            return this.f32003c;
        }

        public boolean j() {
            return !i() || (this.f32001a.isEmpty() && this.f32002b.length() == 0);
        }

        public boolean k() {
            return this.f32004d;
        }

        public void l() {
            e();
            this.f32003c = false;
            this.f32004d = false;
            this.f32005e = 4;
            this.f32006f = false;
            this.f32007g = 0;
            this.f32008h = 0;
            this.f32009i = 0;
            this.f32010j = 15;
            this.f32011k = true;
            this.f32012l = 0;
            this.f32013m = 0;
            this.f32014n = 0;
            int i10 = f31998x;
            this.f32015o = i10;
            this.f32019s = f31997w;
            this.f32021u = i10;
        }

        public void m(int i10, int i11, int i12, boolean z10, boolean z11, int i13, int i14) {
            if (this.f32016p != -1) {
                if (!z10) {
                    this.f32002b.setSpan(new StyleSpan(2), this.f32016p, this.f32002b.length(), 33);
                    this.f32016p = -1;
                }
            } else if (z10) {
                this.f32016p = this.f32002b.length();
            }
            if (this.f32017q == -1) {
                if (z11) {
                    this.f32017q = this.f32002b.length();
                }
            } else {
                if (z11) {
                    return;
                }
                this.f32002b.setSpan(new UnderlineSpan(), this.f32017q, this.f32002b.length(), 33);
                this.f32017q = -1;
            }
        }

        public void n(int i10, int i11, int i12) {
            if (this.f32018r != -1 && this.f32019s != i10) {
                this.f32002b.setSpan(new ForegroundColorSpan(this.f32019s), this.f32018r, this.f32002b.length(), 33);
            }
            if (i10 != f31997w) {
                this.f32018r = this.f32002b.length();
                this.f32019s = i10;
            }
            if (this.f32020t != -1 && this.f32021u != i11) {
                this.f32002b.setSpan(new BackgroundColorSpan(this.f32021u), this.f32020t, this.f32002b.length(), 33);
            }
            if (i11 != f31998x) {
                this.f32020t = this.f32002b.length();
                this.f32021u = i11;
            }
        }

        public void o(int i10, int i11) {
            if (this.f32022v != i10) {
                a('\n');
            }
            this.f32022v = i10;
        }

        public void p(boolean z10) {
            this.f32004d = z10;
        }

        public void q(int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
            this.f32015o = i10;
            this.f32012l = i15;
        }
    }

    /* JADX INFO: renamed from: o3.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cea708Decoder.java */
    private static final class C0640c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f32025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f32026d = 0;

        public C0640c(int i10, int i11) {
            this.f32023a = i10;
            this.f32024b = i11;
            this.f32025c = new byte[(i11 * 2) - 1];
        }
    }

    public c(int i10, @Nullable List<byte[]> list) {
        this.f31987k = i10 == -1 ? 1 : i10;
        this.f31986j = list != null && a4.e.f(list);
        this.f31988l = new b[8];
        for (int i11 = 0; i11 < 8; i11++) {
            this.f31988l[i11] = new b();
        }
        this.f31989m = this.f31988l[0];
    }

    private void A() {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f31988l[i10].l();
        }
    }

    private void k() {
        if (this.f31992p == null) {
            return;
        }
        z();
        this.f31992p = null;
    }

    private List<n3.b> l() {
        a aVarC;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 8; i10++) {
            if (!this.f31988l[i10].j() && this.f31988l[i10].k() && (aVarC = this.f31988l[i10].c()) != null) {
                arrayList.add(aVarC);
            }
        }
        Collections.sort(arrayList, a.f31994c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList2.add(((a) arrayList.get(i11)).f31995a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void m(int i10) {
        if (i10 != 0) {
            if (i10 == 3) {
                this.f31990n = l();
            }
            if (i10 == 8) {
                this.f31989m.b();
                return;
            }
            switch (i10) {
                case 12:
                    A();
                    break;
                case 13:
                    this.f31989m.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i10 >= 17 && i10 <= 23) {
                        t.i("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i10);
                        this.f31984h.r(8);
                    } else if (i10 >= 24 && i10 <= 31) {
                        t.i("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i10);
                        this.f31984h.r(16);
                    } else {
                        t.i("Cea708Decoder", "Invalid C0 command: " + i10);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void n(int i10) {
        int i11 = 1;
        switch (i10) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i12 = i10 - 128;
                if (this.f31993q != i12) {
                    this.f31993q = i12;
                    this.f31989m = this.f31988l[i12];
                }
                break;
            case 136:
                while (i11 <= 8) {
                    if (this.f31984h.g()) {
                        this.f31988l[8 - i11].e();
                    }
                    i11++;
                }
                break;
            case 137:
                for (int i13 = 1; i13 <= 8; i13++) {
                    if (this.f31984h.g()) {
                        this.f31988l[8 - i13].p(true);
                    }
                }
                break;
            case 138:
                while (i11 <= 8) {
                    if (this.f31984h.g()) {
                        this.f31988l[8 - i11].p(false);
                    }
                    i11++;
                }
                break;
            case TsExtractor.TS_STREAM_TYPE_DTS_UHD /* 139 */:
                for (int i14 = 1; i14 <= 8; i14++) {
                    if (this.f31984h.g()) {
                        this.f31988l[8 - i14].p(!r0.k());
                    }
                }
                break;
            case IronSourceConstants.USING_CACHE_FOR_INIT_EVENT /* 140 */:
                while (i11 <= 8) {
                    if (this.f31984h.g()) {
                        this.f31988l[8 - i11].l();
                    }
                    i11++;
                }
                break;
            case 141:
                this.f31984h.r(8);
                break;
            case 142:
                break;
            case 143:
                A();
                break;
            case 144:
                if (this.f31989m.i()) {
                    v();
                } else {
                    this.f31984h.r(16);
                }
                break;
            case 145:
                if (this.f31989m.i()) {
                    w();
                } else {
                    this.f31984h.r(24);
                }
                break;
            case 146:
                if (this.f31989m.i()) {
                    x();
                } else {
                    this.f31984h.r(16);
                }
                break;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                t.i("Cea708Decoder", "Invalid C1 command: " + i10);
                break;
            case 151:
                if (this.f31989m.i()) {
                    y();
                } else {
                    this.f31984h.r(32);
                }
                break;
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i15 = i10 - 152;
                q(i15);
                if (this.f31993q != i15) {
                    this.f31993q = i15;
                    this.f31989m = this.f31988l[i15];
                }
                break;
        }
    }

    private void o(int i10) {
        if (i10 <= 7) {
            return;
        }
        if (i10 <= 15) {
            this.f31984h.r(8);
        } else if (i10 <= 23) {
            this.f31984h.r(16);
        } else if (i10 <= 31) {
            this.f31984h.r(24);
        }
    }

    private void p(int i10) {
        if (i10 <= 135) {
            this.f31984h.r(32);
            return;
        }
        if (i10 <= 143) {
            this.f31984h.r(40);
        } else if (i10 <= 159) {
            this.f31984h.r(2);
            this.f31984h.r(this.f31984h.h(6) * 8);
        }
    }

    private void q(int i10) {
        b bVar = this.f31988l[i10];
        this.f31984h.r(2);
        boolean zG = this.f31984h.g();
        boolean zG2 = this.f31984h.g();
        boolean zG3 = this.f31984h.g();
        int iH = this.f31984h.h(3);
        boolean zG4 = this.f31984h.g();
        int iH2 = this.f31984h.h(7);
        int iH3 = this.f31984h.h(8);
        int iH4 = this.f31984h.h(4);
        int iH5 = this.f31984h.h(4);
        this.f31984h.r(2);
        int iH6 = this.f31984h.h(6);
        this.f31984h.r(2);
        bVar.f(zG, zG2, zG3, iH, zG4, iH2, iH3, iH5, iH6, iH4, this.f31984h.h(3), this.f31984h.h(3));
    }

    private void r(int i10) {
        if (i10 == 127) {
            this.f31989m.a((char) 9835);
        } else {
            this.f31989m.a((char) (i10 & 255));
        }
    }

    private void s(int i10) {
        this.f31989m.a((char) (i10 & 255));
    }

    private void t(int i10) {
        if (i10 == 32) {
            this.f31989m.a(' ');
        }
        if (i10 == 33) {
            this.f31989m.a((char) 160);
            return;
        }
        if (i10 == 37) {
            this.f31989m.a((char) 8230);
            return;
        }
        if (i10 == 42) {
            this.f31989m.a((char) 352);
            return;
        }
        if (i10 == 44) {
            this.f31989m.a((char) 338);
            return;
        }
        if (i10 == 63) {
            this.f31989m.a((char) 376);
            return;
        }
        if (i10 == 57) {
            this.f31989m.a((char) 8482);
            return;
        }
        if (i10 == 58) {
            this.f31989m.a((char) 353);
            return;
        }
        if (i10 == 60) {
            this.f31989m.a((char) 339);
            return;
        }
        if (i10 == 61) {
            this.f31989m.a((char) 8480);
            return;
        }
        switch (i10) {
            case 48:
                this.f31989m.a((char) 9608);
                break;
            case 49:
                this.f31989m.a((char) 8216);
                break;
            case 50:
                this.f31989m.a((char) 8217);
                break;
            case 51:
                this.f31989m.a((char) 8220);
                break;
            case 52:
                this.f31989m.a((char) 8221);
                break;
            case 53:
                this.f31989m.a((char) 8226);
                break;
            default:
                switch (i10) {
                    case 118:
                        this.f31989m.a((char) 8539);
                        break;
                    case 119:
                        this.f31989m.a((char) 8540);
                        break;
                    case 120:
                        this.f31989m.a((char) 8541);
                        break;
                    case 121:
                        this.f31989m.a((char) 8542);
                        break;
                    case 122:
                        this.f31989m.a((char) 9474);
                        break;
                    case 123:
                        this.f31989m.a((char) 9488);
                        break;
                    case 124:
                        this.f31989m.a((char) 9492);
                        break;
                    case 125:
                        this.f31989m.a((char) 9472);
                        break;
                    case 126:
                        this.f31989m.a((char) 9496);
                        break;
                    case 127:
                        this.f31989m.a((char) 9484);
                        break;
                    default:
                        t.i("Cea708Decoder", "Invalid G2 character: " + i10);
                        break;
                }
                break;
        }
    }

    private void u(int i10) {
        if (i10 == 160) {
            this.f31989m.a((char) 13252);
            return;
        }
        t.i("Cea708Decoder", "Invalid G3 character: " + i10);
        this.f31989m.a('_');
    }

    private void v() {
        this.f31989m.m(this.f31984h.h(4), this.f31984h.h(2), this.f31984h.h(2), this.f31984h.g(), this.f31984h.g(), this.f31984h.h(3), this.f31984h.h(3));
    }

    private void w() {
        int iH = b.h(this.f31984h.h(2), this.f31984h.h(2), this.f31984h.h(2), this.f31984h.h(2));
        int iH2 = b.h(this.f31984h.h(2), this.f31984h.h(2), this.f31984h.h(2), this.f31984h.h(2));
        this.f31984h.r(2);
        this.f31989m.n(iH, iH2, b.g(this.f31984h.h(2), this.f31984h.h(2), this.f31984h.h(2)));
    }

    private void x() {
        this.f31984h.r(4);
        int iH = this.f31984h.h(4);
        this.f31984h.r(2);
        this.f31989m.o(iH, this.f31984h.h(6));
    }

    private void y() {
        int iH = b.h(this.f31984h.h(2), this.f31984h.h(2), this.f31984h.h(2), this.f31984h.h(2));
        int iH2 = this.f31984h.h(2);
        int iG = b.g(this.f31984h.h(2), this.f31984h.h(2), this.f31984h.h(2));
        if (this.f31984h.g()) {
            iH2 |= 4;
        }
        boolean zG = this.f31984h.g();
        int iH3 = this.f31984h.h(2);
        int iH4 = this.f31984h.h(2);
        int iH5 = this.f31984h.h(2);
        this.f31984h.r(8);
        this.f31989m.q(iH, iG, zG, iH2, iH3, iH4, iH5);
    }

    private void z() {
        C0640c c0640c = this.f31992p;
        if (c0640c.f32026d != (c0640c.f32024b * 2) - 1) {
            t.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f31992p.f32024b * 2) - 1) + ", but current index is " + this.f31992p.f32026d + " (sequence number " + this.f31992p.f32023a + ");");
        }
        b0 b0Var = this.f31984h;
        C0640c c0640c2 = this.f31992p;
        b0Var.o(c0640c2.f32025c, c0640c2.f32026d);
        boolean z10 = false;
        while (true) {
            if (this.f31984h.b() <= 0) {
                break;
            }
            int iH = this.f31984h.h(3);
            int iH2 = this.f31984h.h(5);
            if (iH == 7) {
                this.f31984h.r(2);
                iH = this.f31984h.h(6);
                if (iH < 7) {
                    t.i("Cea708Decoder", "Invalid extended service number: " + iH);
                }
            }
            if (iH2 == 0) {
                if (iH != 0) {
                    t.i("Cea708Decoder", "serviceNumber is non-zero (" + iH + ") when blockSize is 0");
                }
            } else if (iH != this.f31987k) {
                this.f31984h.s(iH2);
            } else {
                int iE = this.f31984h.e() + (iH2 * 8);
                while (this.f31984h.e() < iE) {
                    int iH3 = this.f31984h.h(8);
                    if (iH3 == 16) {
                        int iH4 = this.f31984h.h(8);
                        if (iH4 <= 31) {
                            o(iH4);
                        } else {
                            if (iH4 <= 127) {
                                t(iH4);
                            } else if (iH4 <= 159) {
                                p(iH4);
                            } else if (iH4 <= 255) {
                                u(iH4);
                            } else {
                                t.i("Cea708Decoder", "Invalid extended command: " + iH4);
                            }
                            z10 = true;
                        }
                    } else if (iH3 <= 31) {
                        m(iH3);
                    } else {
                        if (iH3 <= 127) {
                            r(iH3);
                        } else if (iH3 <= 159) {
                            n(iH3);
                        } else if (iH3 <= 255) {
                            s(iH3);
                        } else {
                            t.i("Cea708Decoder", "Invalid base command: " + iH3);
                        }
                        z10 = true;
                    }
                }
            }
        }
        if (z10) {
            this.f31990n = l();
        }
    }

    @Override // o3.e
    protected i a() {
        List<n3.b> list = this.f31990n;
        this.f31991o = list;
        return new f((List) a4.a.e(list));
    }

    @Override // o3.e
    protected void b(n nVar) {
        ByteBuffer byteBuffer = (ByteBuffer) a4.a.e(nVar.f31586c);
        this.f31983g.N(byteBuffer.array(), byteBuffer.limit());
        while (this.f31983g.a() >= 3) {
            int iD = this.f31983g.D() & 7;
            int i10 = iD & 3;
            boolean z10 = (iD & 4) == 4;
            byte bD = (byte) this.f31983g.D();
            byte bD2 = (byte) this.f31983g.D();
            if (i10 == 2 || i10 == 3) {
                if (z10) {
                    if (i10 == 3) {
                        k();
                        int i11 = (bD & 192) >> 6;
                        int i12 = this.f31985i;
                        if (i12 != -1 && i11 != (i12 + 1) % 4) {
                            A();
                            t.i("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f31985i + " current=" + i11);
                        }
                        this.f31985i = i11;
                        int i13 = bD & 63;
                        if (i13 == 0) {
                            i13 = 64;
                        }
                        C0640c c0640c = new C0640c(i11, i13);
                        this.f31992p = c0640c;
                        byte[] bArr = c0640c.f32025c;
                        int i14 = c0640c.f32026d;
                        c0640c.f32026d = i14 + 1;
                        bArr[i14] = bD2;
                    } else {
                        a4.a.a(i10 == 2);
                        C0640c c0640c2 = this.f31992p;
                        if (c0640c2 == null) {
                            t.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0640c2.f32025c;
                            int i15 = c0640c2.f32026d;
                            int i16 = i15 + 1;
                            bArr2[i15] = bD;
                            c0640c2.f32026d = i16 + 1;
                            bArr2[i16] = bD2;
                        }
                    }
                    C0640c c0640c3 = this.f31992p;
                    if (c0640c3.f32026d == (c0640c3.f32024b * 2) - 1) {
                        k();
                    }
                }
            }
        }
    }

    @Override // o3.e
    @Nullable
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ n dequeueInputBuffer() throws k {
        return super.dequeueInputBuffer();
    }

    @Override // o3.e
    @Nullable
    /* JADX INFO: renamed from: d */
    public /* bridge */ /* synthetic */ o dequeueOutputBuffer() throws k {
        return super.dequeueOutputBuffer();
    }

    @Override // o3.e, n2.d
    public void flush() {
        super.flush();
        this.f31990n = null;
        this.f31991o = null;
        this.f31993q = 0;
        this.f31989m = this.f31988l[0];
        A();
        this.f31992p = null;
    }

    @Override // o3.e
    protected boolean g() {
        return this.f31990n != this.f31991o;
    }

    @Override // o3.e
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ void queueInputBuffer(n nVar) throws k {
        super.queueInputBuffer(nVar);
    }

    @Override // o3.e, n2.d
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // o3.e, n3.j
    public /* bridge */ /* synthetic */ void setPositionUs(long j10) {
        super.setPositionUs(j10);
    }
}
