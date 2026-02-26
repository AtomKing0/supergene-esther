package q9;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.onetrust.otpublishers.headless.Public.OTCCPAGeolocationConstants;
import kotlin.jvm.internal.t;
import n9.l;
import n9.o;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Comparable<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f33177b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f33178c = j(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f33179d = d.j(4611686018427387903L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f33180e = d.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f33181a;

    /* JADX INFO: compiled from: Duration.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final long a() {
            return b.f33179d;
        }

        public final long b() {
            return b.f33180e;
        }

        public final long c() {
            return b.f33178c;
        }

        public final long d(@NotNull String value) {
            t.i(value, "value");
            try {
                return d.p(value, true);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e10);
            }
        }
    }

    private /* synthetic */ b(long j10) {
        this.f33181a = j10;
    }

    private static final boolean A(long j10) {
        return (((int) j10) & 1) == 1;
    }

    private static final boolean B(long j10) {
        return (((int) j10) & 1) == 0;
    }

    public static final boolean C(long j10) {
        return j10 == f33179d || j10 == f33180e;
    }

    public static final boolean D(long j10) {
        return j10 < 0;
    }

    public static final long E(long j10, long j11) {
        if (C(j10)) {
            if (z(j11) || (j11 ^ j10) >= 0) {
                return j10;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (C(j11)) {
            return j11;
        }
        if ((((int) j10) & 1) != (((int) j11) & 1)) {
            return A(j10) ? e(j10, x(j10), x(j11)) : e(j10, x(j11), x(j10));
        }
        long jX = x(j10) + x(j11);
        return B(j10) ? d.m(jX) : d.k(jX);
    }

    public static final double F(long j10, @NotNull e unit) {
        t.i(unit, "unit");
        if (j10 == f33179d) {
            return Double.POSITIVE_INFINITY;
        }
        if (j10 == f33180e) {
            return Double.NEGATIVE_INFINITY;
        }
        return f.a(x(j10), w(j10), unit);
    }

    @NotNull
    public static final String G(long j10) {
        StringBuilder sb = new StringBuilder();
        if (D(j10)) {
            sb.append('-');
        }
        sb.append("PT");
        long jM = m(j10);
        long jP = p(jM);
        int iT = t(jM);
        int iV = v(jM);
        int iU = u(jM);
        if (C(j10)) {
            jP = 9999999999999L;
        }
        boolean z10 = true;
        boolean z11 = jP != 0;
        boolean z12 = (iV == 0 && iU == 0) ? false : true;
        if (iT == 0 && (!z12 || !z11)) {
            z10 = false;
        }
        if (z11) {
            sb.append(jP);
            sb.append('H');
        }
        if (z10) {
            sb.append(iT);
            sb.append('M');
        }
        if (z12 || (!z11 && !z10)) {
            f(j10, sb, iV, iU, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final long H(long j10, @NotNull e unit) {
        t.i(unit, "unit");
        if (j10 == f33179d) {
            return Long.MAX_VALUE;
        }
        if (j10 == f33180e) {
            return Long.MIN_VALUE;
        }
        return f.b(x(j10), w(j10), unit);
    }

    @NotNull
    public static String I(long j10) {
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f33179d) {
            return "Infinity";
        }
        if (j10 == f33180e) {
            return "-Infinity";
        }
        boolean zD = D(j10);
        StringBuilder sb = new StringBuilder();
        if (zD) {
            sb.append('-');
        }
        long jM = m(j10);
        long jO = o(jM);
        int iN = n(jM);
        int iT = t(jM);
        int iV = v(jM);
        int iU = u(jM);
        int i10 = 0;
        boolean z10 = jO != 0;
        boolean z11 = iN != 0;
        boolean z12 = iT != 0;
        boolean z13 = (iV == 0 && iU == 0) ? false : true;
        if (z10) {
            sb.append(jO);
            sb.append('d');
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb.append(' ');
            }
            sb.append(iN);
            sb.append('h');
            i10 = i11;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb.append(' ');
            }
            sb.append(iT);
            sb.append('m');
            i10 = i12;
        }
        if (z13) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb.append(' ');
            }
            if (iV != 0 || z10 || z11 || z12) {
                f(j10, sb, iV, iU, 9, CmcdData.Factory.STREAMING_FORMAT_SS, false);
            } else if (iU >= 1000000) {
                f(j10, sb, iU / PlaybackException.CUSTOM_ERROR_CODE_BASE, iU % PlaybackException.CUSTOM_ERROR_CODE_BASE, 6, "ms", false);
            } else if (iU >= 1000) {
                f(j10, sb, iU / 1000, iU % 1000, 3, OTCCPAGeolocationConstants.US, false);
            } else {
                sb.append(iU);
                sb.append("ns");
            }
            i10 = i13;
        }
        if (zD && i10 > 1) {
            sb.insert(1, '(').append(')');
        }
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final long J(long j10) {
        return d.i(-x(j10), ((int) j10) & 1);
    }

    private static final long e(long j10, long j11, long j12) {
        long jO = d.o(j12);
        long j13 = j11 + jO;
        if (!new l(-4611686018426L, 4611686018426L).g(j13)) {
            return d.j(o.p(j13, -4611686018427387903L, 4611686018427387903L));
        }
        return d.l(d.n(j13) + (j12 - d.n(jO)));
    }

    private static final void f(long j10, StringBuilder sb, int i10, int i11, int i12, String str, boolean z10) {
        sb.append(i10);
        if (i11 != 0) {
            sb.append('.');
            String strP0 = r.p0(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = strP0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (strP0.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (z10 || i15 >= 3) {
                sb.append((CharSequence) strP0, 0, ((i15 + 2) / 3) * 3);
                t.h(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) strP0, 0, i15);
                t.h(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ b g(long j10) {
        return new b(j10);
    }

    public static int i(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return t.l(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        return D(j10) ? -i10 : i10;
    }

    public static long j(long j10) {
        if (c.a()) {
            if (B(j10)) {
                if (!new l(-4611686018426999999L, 4611686018426999999L).g(x(j10))) {
                    throw new AssertionError(x(j10) + " ns is out of nanoseconds range");
                }
            } else {
                if (!new l(-4611686018427387903L, 4611686018427387903L).g(x(j10))) {
                    throw new AssertionError(x(j10) + " ms is out of milliseconds range");
                }
                if (new l(-4611686018426L, 4611686018426L).g(x(j10))) {
                    throw new AssertionError(x(j10) + " ms is denormalized");
                }
            }
        }
        return j10;
    }

    public static boolean k(long j10, Object obj) {
        return (obj instanceof b) && j10 == ((b) obj).K();
    }

    public static final boolean l(long j10, long j11) {
        return j10 == j11;
    }

    public static final long m(long j10) {
        return D(j10) ? J(j10) : j10;
    }

    public static final int n(long j10) {
        if (C(j10)) {
            return 0;
        }
        return (int) (p(j10) % ((long) 24));
    }

    public static final long o(long j10) {
        return H(j10, e.f33190h);
    }

    public static final long p(long j10) {
        return H(j10, e.f33189g);
    }

    public static final long q(long j10) {
        return (A(j10) && z(j10)) ? x(j10) : H(j10, e.f33186d);
    }

    public static final long r(long j10) {
        return H(j10, e.f33188f);
    }

    public static final long s(long j10) {
        return H(j10, e.f33187e);
    }

    public static final int t(long j10) {
        if (C(j10)) {
            return 0;
        }
        return (int) (r(j10) % ((long) 60));
    }

    public static final int u(long j10) {
        if (C(j10)) {
            return 0;
        }
        return (int) (A(j10) ? d.n(x(j10) % ((long) 1000)) : x(j10) % ((long) 1000000000));
    }

    public static final int v(long j10) {
        if (C(j10)) {
            return 0;
        }
        return (int) (s(j10) % ((long) 60));
    }

    private static final e w(long j10) {
        return B(j10) ? e.f33184b : e.f33186d;
    }

    private static final long x(long j10) {
        return j10 >> 1;
    }

    public static int y(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    public static final boolean z(long j10) {
        return !C(j10);
    }

    public final /* synthetic */ long K() {
        return this.f33181a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(b bVar) {
        return h(bVar.K());
    }

    public boolean equals(Object obj) {
        return k(this.f33181a, obj);
    }

    public int h(long j10) {
        return i(this.f33181a, j10);
    }

    public int hashCode() {
        return y(this.f33181a);
    }

    @NotNull
    public String toString() {
        return I(this.f33181a);
    }
}
