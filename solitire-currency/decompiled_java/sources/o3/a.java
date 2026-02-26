package o3;

import a4.c0;
import a4.o0;
import a4.t;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.PsExtractor;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n3.b;
import n3.i;
import n3.k;
import n3.n;
import n3.o;

/* JADX INFO: compiled from: Cea608Decoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f31955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f31956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f31957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f31958k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private List<n3.b> f31961n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private List<n3.b> f31962o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f31963p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31964q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f31965r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f31966s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private byte f31967t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private byte f31968u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f31970w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f31971x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int[] f31952y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f31953z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, -256, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] C = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, 201, OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_NEW_GROUP_ADDED, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c0 f31954g = new c0();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ArrayList<C0638a> f31959l = new ArrayList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private C0638a f31960m = new C0638a(0, 4);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f31969v = 0;

    /* JADX INFO: renamed from: o3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cea608Decoder.java */
    private static final class C0638a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<C0639a> f31972a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<SpannableString> f31973b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StringBuilder f31974c = new StringBuilder();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f31975d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f31976e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f31977f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f31978g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f31979h;

        /* JADX INFO: renamed from: o3.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Cea608Decoder.java */
        private static class C0639a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f31980a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f31981b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f31982c;

            public C0639a(int i10, boolean z10, int i11) {
                this.f31980a = i10;
                this.f31981b = z10;
                this.f31982c = i11;
            }
        }

        public C0638a(int i10, int i11) {
            j(i10);
            this.f31979h = i11;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f31974c);
            int length = spannableStringBuilder.length();
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            int i15 = 0;
            boolean z10 = false;
            while (i14 < this.f31972a.size()) {
                C0639a c0639a = this.f31972a.get(i14);
                boolean z11 = c0639a.f31981b;
                int i16 = c0639a.f31980a;
                if (i16 != 8) {
                    boolean z12 = i16 == 7;
                    if (i16 != 7) {
                        i13 = a.A[i16];
                    }
                    z10 = z12;
                }
                int i17 = c0639a.f31982c;
                i14++;
                if (i17 != (i14 < this.f31972a.size() ? this.f31972a.get(i14).f31982c : length)) {
                    if (i10 != -1 && !z11) {
                        q(spannableStringBuilder, i10, i17);
                        i10 = -1;
                    } else if (i10 == -1 && z11) {
                        i10 = i17;
                    }
                    if (i11 != -1 && !z10) {
                        o(spannableStringBuilder, i11, i17);
                        i11 = -1;
                    } else if (i11 == -1 && z10) {
                        i11 = i17;
                    }
                    if (i13 != i12) {
                        n(spannableStringBuilder, i15, i17, i12);
                        i12 = i13;
                        i15 = i17;
                    }
                }
            }
            if (i10 != -1 && i10 != length) {
                q(spannableStringBuilder, i10, length);
            }
            if (i11 != -1 && i11 != length) {
                o(spannableStringBuilder, i11, length);
            }
            if (i15 != length) {
                n(spannableStringBuilder, i15, length, i12);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12) {
            if (i12 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i12), i10, i11, 33);
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i10, int i11) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i10, i11, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i10, int i11) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i10, i11, 33);
        }

        public void e(char c10) {
            if (this.f31974c.length() < 32) {
                this.f31974c.append(c10);
            }
        }

        public void f() {
            int length = this.f31974c.length();
            if (length > 0) {
                this.f31974c.delete(length - 1, length);
                for (int size = this.f31972a.size() - 1; size >= 0; size--) {
                    C0639a c0639a = this.f31972a.get(size);
                    int i10 = c0639a.f31982c;
                    if (i10 != length) {
                        return;
                    }
                    c0639a.f31982c = i10 - 1;
                }
            }
        }

        @Nullable
        public n3.b g(int i10) {
            float f10;
            int i11 = this.f31976e + this.f31977f;
            int i12 = 32 - i11;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i13 = 0; i13 < this.f31973b.size(); i13++) {
                spannableStringBuilder.append(o0.O0(this.f31973b.get(i13), i12));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(o0.O0(h(), i12));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i12 - spannableStringBuilder.length();
            int i14 = i11 - length;
            if (i10 == Integer.MIN_VALUE) {
                i10 = (this.f31978g != 2 || (Math.abs(i14) >= 3 && length >= 0)) ? (this.f31978g != 2 || i14 <= 0) ? 0 : 2 : 1;
            }
            if (i10 != 1) {
                if (i10 == 2) {
                    i11 = 32 - length;
                }
                f10 = ((i11 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f10 = 0.5f;
            }
            int i15 = this.f31975d;
            if (i15 > 7) {
                i15 = (i15 - 15) - 2;
            } else if (this.f31978g == 1) {
                i15 -= this.f31979h - 1;
            }
            return new b.C0631b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i15, 1).k(f10).l(i10).a();
        }

        public boolean i() {
            return this.f31972a.isEmpty() && this.f31973b.isEmpty() && this.f31974c.length() == 0;
        }

        public void j(int i10) {
            this.f31978g = i10;
            this.f31972a.clear();
            this.f31973b.clear();
            this.f31974c.setLength(0);
            this.f31975d = 15;
            this.f31976e = 0;
            this.f31977f = 0;
        }

        public void k() {
            this.f31973b.add(h());
            this.f31974c.setLength(0);
            this.f31972a.clear();
            int iMin = Math.min(this.f31979h, this.f31975d);
            while (this.f31973b.size() >= iMin) {
                this.f31973b.remove(0);
            }
        }

        public void l(int i10) {
            this.f31978g = i10;
        }

        public void m(int i10) {
            this.f31979h = i10;
        }

        public void p(int i10, boolean z10) {
            this.f31972a.add(new C0639a(i10, z10, this.f31974c.length()));
        }
    }

    public a(String str, int i10, long j10) {
        this.f31958k = j10 > 0 ? j10 * 1000 : -9223372036854775807L;
        this.f31955h = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i10 == 1) {
            this.f31957j = 0;
            this.f31956i = 0;
        } else if (i10 == 2) {
            this.f31957j = 1;
            this.f31956i = 0;
        } else if (i10 == 3) {
            this.f31957j = 0;
            this.f31956i = 1;
        } else if (i10 != 4) {
            t.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f31957j = 0;
            this.f31956i = 0;
        } else {
            this.f31957j = 1;
            this.f31956i = 1;
        }
        I(0);
        H();
        this.f31970w = true;
        this.f31971x = C.TIME_UNSET;
    }

    private static boolean A(byte b10) {
        return (b10 & 240) == 16;
    }

    private boolean B(boolean z10, byte b10, byte b11) {
        if (!z10 || !A(b10)) {
            this.f31966s = false;
        } else {
            if (this.f31966s && this.f31967t == b10 && this.f31968u == b11) {
                this.f31966s = false;
                return true;
            }
            this.f31966s = true;
            this.f31967t = b10;
            this.f31968u = b11;
        }
        return false;
    }

    private static boolean C(byte b10) {
        return (b10 & 246) == 20;
    }

    private static boolean D(byte b10, byte b11) {
        return (b10 & 247) == 17 && (b11 & 240) == 48;
    }

    private static boolean E(byte b10, byte b11) {
        return (b10 & 247) == 23 && b11 >= 33 && b11 <= 35;
    }

    private static boolean F(byte b10) {
        return 1 <= b10 && b10 <= 15;
    }

    private void G(byte b10, byte b11) {
        if (F(b10)) {
            this.f31970w = false;
            return;
        }
        if (C(b10)) {
            if (b11 != 32 && b11 != 47) {
                switch (b11) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b11) {
                            case 42:
                            case 43:
                                this.f31970w = false;
                                break;
                        }
                }
            }
            this.f31970w = true;
        }
    }

    private void H() {
        this.f31960m.j(this.f31963p);
        this.f31959l.clear();
        this.f31959l.add(this.f31960m);
    }

    private void I(int i10) {
        int i11 = this.f31963p;
        if (i11 == i10) {
            return;
        }
        this.f31963p = i10;
        if (i10 == 3) {
            for (int i12 = 0; i12 < this.f31959l.size(); i12++) {
                this.f31959l.get(i12).l(i10);
            }
            return;
        }
        H();
        if (i11 == 3 || i10 == 1 || i10 == 0) {
            this.f31961n = Collections.emptyList();
        }
    }

    private void J(int i10) {
        this.f31964q = i10;
        this.f31960m.m(i10);
    }

    private boolean K() {
        return (this.f31958k == C.TIME_UNSET || this.f31971x == C.TIME_UNSET || f() - this.f31971x < this.f31958k) ? false : true;
    }

    private boolean L(byte b10) {
        if (v(b10)) {
            this.f31969v = m(b10);
        }
        return this.f31969v == this.f31957j;
    }

    private static char l(byte b10) {
        return (char) B[(b10 & 127) - 32];
    }

    private static int m(byte b10) {
        return (b10 >> 3) & 1;
    }

    private List<n3.b> n() {
        int size = this.f31959l.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i10 = 0; i10 < size; i10++) {
            n3.b bVarG = this.f31959l.get(i10).g(Integer.MIN_VALUE);
            arrayList.add(bVarG);
            if (bVarG != null) {
                iMin = Math.min(iMin, bVarG.f31631i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            n3.b bVar = (n3.b) arrayList.get(i11);
            if (bVar != null) {
                if (bVar.f31631i != iMin) {
                    bVar = (n3.b) a4.a.e(this.f31959l.get(i11).g(iMin));
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    private static char o(byte b10) {
        return (char) D[b10 & 31];
    }

    private static char p(byte b10) {
        return (char) E[b10 & 31];
    }

    private static char q(byte b10, byte b11) {
        return (b10 & 1) == 0 ? o(b11) : p(b11);
    }

    private static char r(byte b10) {
        return (char) C[b10 & 15];
    }

    private void s(byte b10) {
        this.f31960m.e(' ');
        this.f31960m.p((b10 >> 1) & 7, (b10 & 1) == 1);
    }

    private void t(byte b10) {
        if (b10 == 32) {
            I(2);
            return;
        }
        if (b10 == 41) {
            I(3);
            return;
        }
        switch (b10) {
            case 37:
                I(1);
                J(2);
                break;
            case 38:
                I(1);
                J(3);
                break;
            case 39:
                I(1);
                J(4);
                break;
            default:
                int i10 = this.f31963p;
                if (i10 != 0) {
                    if (b10 != 33) {
                        switch (b10) {
                            case 44:
                                this.f31961n = Collections.emptyList();
                                int i11 = this.f31963p;
                                if (i11 == 1 || i11 == 3) {
                                    H();
                                }
                                break;
                            case 45:
                                if (i10 == 1 && !this.f31960m.i()) {
                                    this.f31960m.k();
                                    break;
                                }
                                break;
                            case 46:
                                H();
                                break;
                            case 47:
                                this.f31961n = n();
                                H();
                                break;
                        }
                    } else {
                        this.f31960m.f();
                        break;
                    }
                }
                break;
        }
    }

    private void u(byte b10, byte b11) {
        int i10 = f31952y[b10 & 7];
        if ((b11 & 32) != 0) {
            i10++;
        }
        if (i10 != this.f31960m.f31975d) {
            if (this.f31963p != 1 && !this.f31960m.i()) {
                C0638a c0638a = new C0638a(this.f31963p, this.f31964q);
                this.f31960m = c0638a;
                this.f31959l.add(c0638a);
            }
            this.f31960m.f31975d = i10;
        }
        boolean z10 = (b11 & 16) == 16;
        boolean z11 = (b11 & 1) == 1;
        int i11 = (b11 >> 1) & 7;
        this.f31960m.p(z10 ? 8 : i11, z11);
        if (z10) {
            this.f31960m.f31976e = f31953z[i11];
        }
    }

    private static boolean v(byte b10) {
        return (b10 & 224) == 0;
    }

    private static boolean w(byte b10, byte b11) {
        return (b10 & 246) == 18 && (b11 & 224) == 32;
    }

    private static boolean x(byte b10, byte b11) {
        return (b10 & 247) == 17 && (b11 & 240) == 32;
    }

    private static boolean y(byte b10, byte b11) {
        return (b10 & 246) == 20 && (b11 & 240) == 32;
    }

    private static boolean z(byte b10, byte b11) {
        return (b10 & 240) == 16 && (b11 & 192) == 64;
    }

    @Override // o3.e
    protected i a() {
        List<n3.b> list = this.f31961n;
        this.f31962o = list;
        return new f((List) a4.a.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    @Override // o3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void b(n3.n r10) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.a.b(n3.n):void");
    }

    @Override // o3.e
    @Nullable
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ n dequeueInputBuffer() throws k {
        return super.dequeueInputBuffer();
    }

    @Override // o3.e, n2.d
    @Nullable
    /* JADX INFO: renamed from: d */
    public o dequeueOutputBuffer() throws k {
        o oVarE;
        o oVarDequeueOutputBuffer = super.dequeueOutputBuffer();
        if (oVarDequeueOutputBuffer != null) {
            return oVarDequeueOutputBuffer;
        }
        if (!K() || (oVarE = e()) == null) {
            return null;
        }
        this.f31961n = Collections.emptyList();
        this.f31971x = C.TIME_UNSET;
        oVarE.m(f(), a(), Long.MAX_VALUE);
        return oVarE;
    }

    @Override // o3.e, n2.d
    public void flush() {
        super.flush();
        this.f31961n = null;
        this.f31962o = null;
        I(0);
        J(4);
        H();
        this.f31965r = false;
        this.f31966s = false;
        this.f31967t = (byte) 0;
        this.f31968u = (byte) 0;
        this.f31969v = 0;
        this.f31970w = true;
        this.f31971x = C.TIME_UNSET;
    }

    @Override // o3.e
    protected boolean g() {
        return this.f31961n != this.f31962o;
    }

    @Override // o3.e
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ void queueInputBuffer(n nVar) throws k {
        super.queueInputBuffer(nVar);
    }

    @Override // o3.e, n3.j
    public /* bridge */ /* synthetic */ void setPositionUs(long j10) {
        super.setPositionUs(j10);
    }

    @Override // o3.e, n2.d
    public void release() {
    }
}
