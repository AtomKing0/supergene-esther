package ga;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.nb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f26168j = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f26169k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f26170l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f26171m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Pattern f26172n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f26173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f26174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f26176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f26177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f26178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f26179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f26180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f26181i;

    /* JADX INFO: compiled from: Cookie.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final int a(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L0:
                if (r7 >= r8) goto L49
                int r0 = r7 + 1
                char r1 = r6.charAt(r7)
                r2 = 32
                r3 = 1
                if (r1 >= r2) goto L11
                r2 = 9
                if (r1 != r2) goto L41
            L11:
                r2 = 127(0x7f, float:1.78E-43)
                if (r1 >= r2) goto L41
                r2 = 57
                r4 = 0
                if (r1 > r2) goto L20
                r2 = 48
                if (r2 > r1) goto L20
                r2 = r3
                goto L21
            L20:
                r2 = r4
            L21:
                if (r2 != 0) goto L41
                r2 = 122(0x7a, float:1.71E-43)
                if (r1 > r2) goto L2d
                r2 = 97
                if (r2 > r1) goto L2d
                r2 = r3
                goto L2e
            L2d:
                r2 = r4
            L2e:
                if (r2 != 0) goto L41
                r2 = 90
                if (r1 > r2) goto L3a
                r2 = 65
                if (r2 > r1) goto L3a
                r2 = r3
                goto L3b
            L3a:
                r2 = r4
            L3b:
                if (r2 != 0) goto L41
                r2 = 58
                if (r1 != r2) goto L42
            L41:
                r4 = r3
            L42:
                r1 = r9 ^ 1
                if (r4 != r1) goto L47
                return r7
            L47:
                r7 = r0
                goto L0
            L49:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.m.a.a(java.lang.String, int, int, boolean):int");
        }

        private final boolean b(String str, String str2) {
            if (kotlin.jvm.internal.t.d(str, str2)) {
                return true;
            }
            return p9.q.w(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !ha.d.i(str);
        }

        private final String f(String str) {
            if (!(!p9.q.w(str, ".", false, 2, null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String strE = ha.a.e(p9.r.v0(str, "."));
            if (strE != null) {
                return strE;
            }
            throw new IllegalArgumentException();
        }

        private final long g(String str, int i10, int i11) {
            int iA = a(str, i10, i11, false);
            Matcher matcher = m.f26172n.matcher(str);
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int iE0 = -1;
            int i15 = -1;
            int i16 = -1;
            while (iA < i11) {
                int iA2 = a(str, iA + 1, i11, true);
                matcher.region(iA, iA2);
                if (i13 == -1 && matcher.usePattern(m.f26172n).matches()) {
                    String strGroup = matcher.group(1);
                    kotlin.jvm.internal.t.h(strGroup, "matcher.group(1)");
                    i13 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    kotlin.jvm.internal.t.h(strGroup2, "matcher.group(2)");
                    i15 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    kotlin.jvm.internal.t.h(strGroup3, "matcher.group(3)");
                    i16 = Integer.parseInt(strGroup3);
                } else if (i14 == -1 && matcher.usePattern(m.f26171m).matches()) {
                    String strGroup4 = matcher.group(1);
                    kotlin.jvm.internal.t.h(strGroup4, "matcher.group(1)");
                    i14 = Integer.parseInt(strGroup4);
                } else if (iE0 == -1 && matcher.usePattern(m.f26170l).matches()) {
                    String strGroup5 = matcher.group(1);
                    kotlin.jvm.internal.t.h(strGroup5, "matcher.group(1)");
                    Locale US = Locale.US;
                    kotlin.jvm.internal.t.h(US, "US");
                    String lowerCase = strGroup5.toLowerCase(US);
                    kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = m.f26170l.pattern();
                    kotlin.jvm.internal.t.h(strPattern, "MONTH_PATTERN.pattern()");
                    iE0 = p9.r.e0(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i12 == -1 && matcher.usePattern(m.f26169k).matches()) {
                    String strGroup6 = matcher.group(1);
                    kotlin.jvm.internal.t.h(strGroup6, "matcher.group(1)");
                    i12 = Integer.parseInt(strGroup6);
                }
                iA = a(str, iA2 + 1, i11, false);
            }
            if (70 <= i12 && i12 < 100) {
                i12 += 1900;
            }
            if (i12 >= 0 && i12 < 70) {
                i12 += 2000;
            }
            if (!(i12 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iE0 != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i14 && i14 < 32)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i13 >= 0 && i13 < 24)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i15 >= 0 && i15 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i16 >= 0 && i16 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(ha.d.f26513f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i12);
            gregorianCalendar.set(2, iE0 - 1);
            gregorianCalendar.set(5, i14);
            gregorianCalendar.set(11, i13);
            gregorianCalendar.set(12, i15);
            gregorianCalendar.set(13, i16);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long h(String str) {
            try {
                long j10 = Long.parseLong(str);
                if (j10 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j10;
            } catch (NumberFormatException e10) {
                if (new p9.f("-?\\d+").a(str)) {
                    return p9.q.K(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e10;
            }
        }

        @Nullable
        public final m c(@NotNull v url, @NotNull String setCookie) {
            kotlin.jvm.internal.t.i(url, "url");
            kotlin.jvm.internal.t.i(setCookie, "setCookie");
            return d(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00dc A[PHI: r1
          0x00dc: PHI (r1v24 long) = (r1v8 long), (r1v12 long) binds: [B:45:0x00da, B:56:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ga.m d(long r26, @org.jetbrains.annotations.NotNull ga.v r28, @org.jetbrains.annotations.NotNull java.lang.String r29) {
            /*
                Method dump skipped, instruction units count: 368
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.m.a.d(long, ga.v, java.lang.String):ga.m");
        }

        @NotNull
        public final List<m> e(@NotNull v url, @NotNull u headers) {
            kotlin.jvm.internal.t.i(url, "url");
            kotlin.jvm.internal.t.i(headers, "headers");
            List<String> listJ = headers.j("Set-Cookie");
            int size = listJ.size();
            ArrayList arrayList = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                m mVarC = c(url, listJ.get(i10));
                if (mVarC != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(mVarC);
                }
                i10 = i11;
            }
            if (arrayList == null) {
                return kotlin.collections.v.l();
            }
            List<m> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            kotlin.jvm.internal.t.h(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }
    }

    public /* synthetic */ m(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, kotlin.jvm.internal.k kVar) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13);
    }

    @NotNull
    public final String e() {
        return this.f26176d;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (kotlin.jvm.internal.t.d(mVar.f26173a, this.f26173a) && kotlin.jvm.internal.t.d(mVar.f26174b, this.f26174b) && mVar.f26175c == this.f26175c && kotlin.jvm.internal.t.d(mVar.f26176d, this.f26176d) && kotlin.jvm.internal.t.d(mVar.f26177e, this.f26177e) && mVar.f26178f == this.f26178f && mVar.f26179g == this.f26179g && mVar.f26180h == this.f26180h && mVar.f26181i == this.f26181i) {
                return true;
            }
        }
        return false;
    }

    public final long f() {
        return this.f26175c;
    }

    public final boolean g() {
        return this.f26181i;
    }

    public final boolean h() {
        return this.f26179g;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26173a.hashCode()) * 31) + this.f26174b.hashCode()) * 31) + androidx.compose.animation.a.a(this.f26175c)) * 31) + this.f26176d.hashCode()) * 31) + this.f26177e.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f26178f)) * 31) + androidx.compose.foundation.e.a(this.f26179g)) * 31) + androidx.compose.foundation.e.a(this.f26180h)) * 31) + androidx.compose.foundation.e.a(this.f26181i);
    }

    @NotNull
    public final String i() {
        return this.f26173a;
    }

    @NotNull
    public final String j() {
        return this.f26177e;
    }

    public final boolean k() {
        return this.f26180h;
    }

    public final boolean l() {
        return this.f26178f;
    }

    @NotNull
    public final String m(boolean z10) {
        StringBuilder sb = new StringBuilder();
        sb.append(i());
        sb.append(nb.T);
        sb.append(n());
        if (k()) {
            if (f() == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(ma.c.b(new Date(f())));
            }
        }
        if (!g()) {
            sb.append("; domain=");
            if (z10) {
                sb.append(".");
            }
            sb.append(e());
        }
        sb.append("; path=");
        sb.append(j());
        if (l()) {
            sb.append("; secure");
        }
        if (h()) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "toString()");
        return string;
    }

    @NotNull
    public final String n() {
        return this.f26174b;
    }

    @NotNull
    public String toString() {
        return m(false);
    }

    private m(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f26173a = str;
        this.f26174b = str2;
        this.f26175c = j10;
        this.f26176d = str3;
        this.f26177e = str4;
        this.f26178f = z10;
        this.f26179g = z11;
        this.f26180h = z12;
        this.f26181i = z13;
    }
}
