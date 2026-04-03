package ga;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.webkit.ProxyConfig;
import com.ironsource.nb;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class v {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final b f26216k = new b(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final char[] f26217l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f26218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f26219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f26220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f26221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f26222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<String> f26223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final List<String> f26224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f26225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final String f26226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f26227j;

    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NotNull
        public static final C0568a f26228i = new C0568a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f26229a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private String f26232d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private final List<String> f26234f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private List<String> f26235g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private String f26236h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private String f26230b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private String f26231c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f26233e = -1;

        /* JADX INFO: renamed from: ga.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpUrl.kt */
        public static final class C0568a {
            private C0568a() {
            }

            public /* synthetic */ C0568a(kotlin.jvm.internal.k kVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int e(String str, int i10, int i11) {
                try {
                    int i12 = Integer.parseInt(b.b(v.f26216k, str, i10, i11, "", false, false, false, false, null, 248, null));
                    boolean z10 = false;
                    if (1 <= i12 && i12 < 65536) {
                        z10 = true;
                    }
                    if (z10) {
                        return i12;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int f(String str, int i10, int i11) {
                while (i10 < i11) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt == '[') {
                        do {
                            i10++;
                            if (i10 < i11) {
                            }
                        } while (str.charAt(i10) != ']');
                    } else if (cCharAt == ':') {
                        return i10;
                    }
                    i10++;
                }
                return i11;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int g(String str, int i10, int i11) {
                if (i11 - i10 < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i10);
                if ((kotlin.jvm.internal.t.k(cCharAt, 97) < 0 || kotlin.jvm.internal.t.k(cCharAt, 122) > 0) && (kotlin.jvm.internal.t.k(cCharAt, 65) < 0 || kotlin.jvm.internal.t.k(cCharAt, 90) > 0)) {
                    return -1;
                }
                int i12 = i10 + 1;
                while (i12 < i11) {
                    int i13 = i12 + 1;
                    char cCharAt2 = str.charAt(i12);
                    if (!(((((('a' <= cCharAt2 && cCharAt2 < '{') || ('A' <= cCharAt2 && cCharAt2 < '[')) || ('0' <= cCharAt2 && cCharAt2 < ':')) || cCharAt2 == '+') || cCharAt2 == '-') || cCharAt2 == '.')) {
                        if (cCharAt2 == ':') {
                            return i12;
                        }
                        return -1;
                    }
                    i12 = i13;
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int h(String str, int i10, int i11) {
                int i12 = 0;
                while (i10 < i11) {
                    int i13 = i10 + 1;
                    char cCharAt = str.charAt(i10);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i12++;
                    i10 = i13;
                }
                return i12;
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f26234f = arrayList;
            arrayList.add("");
        }

        private final int d() {
            int i10 = this.f26233e;
            if (i10 != -1) {
                return i10;
            }
            b bVar = v.f26216k;
            String str = this.f26229a;
            kotlin.jvm.internal.t.f(str);
            return bVar.c(str);
        }

        private final boolean o(String str) {
            return kotlin.jvm.internal.t.d(str, ".") || p9.q.x(str, "%2e", true);
        }

        private final boolean p(String str) {
            return kotlin.jvm.internal.t.d(str, "..") || p9.q.x(str, "%2e.", true) || p9.q.x(str, ".%2e", true) || p9.q.x(str, "%2e%2e", true);
        }

        private final void s() {
            List<String> list = this.f26234f;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.f26234f.isEmpty())) {
                this.f26234f.add("");
            } else {
                List<String> list2 = this.f26234f;
                list2.set(list2.size() - 1, "");
            }
        }

        private final void u(String str, int i10, int i11, boolean z10, boolean z11) {
            String strB = b.b(v.f26216k, str, i10, i11, " \"<>^`{}|/\\?#", z11, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
            if (o(strB)) {
                return;
            }
            if (p(strB)) {
                s();
                return;
            }
            List<String> list = this.f26234f;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.f26234f;
                list2.set(list2.size() - 1, strB);
            } else {
                this.f26234f.add(strB);
            }
            if (z10) {
                this.f26234f.add("");
            }
        }

        private final void w(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f26234f.clear();
                this.f26234f.add("");
                i10++;
            } else {
                List<String> list = this.f26234f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i12 = i10;
                while (i12 < i11) {
                    i10 = ha.d.q(str, "/\\", i12, i11);
                    boolean z10 = i10 < i11;
                    u(str, i12, i10, z10, true);
                    if (z10) {
                        i12 = i10 + 1;
                    }
                }
                return;
            }
        }

        public final void A(@Nullable List<String> list) {
            this.f26235g = list;
        }

        public final void B(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<set-?>");
            this.f26230b = str;
        }

        public final void C(@Nullable String str) {
            this.f26232d = str;
        }

        public final void D(int i10) {
            this.f26233e = i10;
        }

        public final void E(@Nullable String str) {
            this.f26229a = str;
        }

        @NotNull
        public final a F(@NotNull String username) {
            kotlin.jvm.internal.t.i(username, "username");
            B(b.b(v.f26216k, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        @NotNull
        public final a a(@NotNull String encodedName, @Nullable String str) {
            kotlin.jvm.internal.t.i(encodedName, "encodedName");
            if (i() == null) {
                A(new ArrayList());
            }
            List<String> listI = i();
            kotlin.jvm.internal.t.f(listI);
            b bVar = v.f26216k;
            listI.add(b.b(bVar, encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_NEW_GROUP_ADDED, null));
            List<String> listI2 = i();
            kotlin.jvm.internal.t.f(listI2);
            listI2.add(str == null ? null : b.b(bVar, str, 0, 0, " \"'<>#&=", true, false, true, false, null, OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_NEW_GROUP_ADDED, null));
            return this;
        }

        @NotNull
        public final a b(@NotNull String name, @Nullable String str) {
            kotlin.jvm.internal.t.i(name, "name");
            if (i() == null) {
                A(new ArrayList());
            }
            List<String> listI = i();
            kotlin.jvm.internal.t.f(listI);
            b bVar = v.f26216k;
            listI.add(b.b(bVar, name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List<String> listI2 = i();
            kotlin.jvm.internal.t.f(listI2);
            listI2.add(str == null ? null : b.b(bVar, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            return this;
        }

        @NotNull
        public final v c() {
            ArrayList arrayList;
            String str = this.f26229a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = v.f26216k;
            String strH = b.h(bVar, this.f26230b, 0, 0, false, 7, null);
            String strH2 = b.h(bVar, this.f26231c, 0, 0, false, 7, null);
            String str2 = this.f26232d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iD = d();
            List<String> list = this.f26234f;
            ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.h(v.f26216k, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.f26235g;
            if (list2 == null) {
                arrayList = null;
            } else {
                List<String> list3 = list2;
                arrayList = new ArrayList(kotlin.collections.w.v(list3, 10));
                for (String str3 : list3) {
                    arrayList.add(str3 == null ? null : b.h(v.f26216k, str3, 0, 0, true, 3, null));
                }
            }
            String str4 = this.f26236h;
            return new v(str, strH, strH2, str2, iD, arrayList2, arrayList, str4 == null ? null : b.h(v.f26216k, str4, 0, 0, false, 7, null), toString());
        }

        @NotNull
        public final a e(@Nullable String str) {
            List<String> listJ = null;
            if (str != null) {
                b bVar = v.f26216k;
                String strB = b.b(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_NEW_GROUP_ADDED, null);
                if (strB != null) {
                    listJ = bVar.j(strB);
                }
            }
            A(listJ);
            return this;
        }

        @Nullable
        public final String f() {
            return this.f26236h;
        }

        @NotNull
        public final String g() {
            return this.f26231c;
        }

        @NotNull
        public final List<String> h() {
            return this.f26234f;
        }

        @Nullable
        public final List<String> i() {
            return this.f26235g;
        }

        @NotNull
        public final String j() {
            return this.f26230b;
        }

        @Nullable
        public final String k() {
            return this.f26232d;
        }

        public final int l() {
            return this.f26233e;
        }

        @Nullable
        public final String m() {
            return this.f26229a;
        }

        @NotNull
        public final a n(@NotNull String host) {
            kotlin.jvm.internal.t.i(host, "host");
            String strE = ha.a.e(b.h(v.f26216k, host, 0, 0, false, 7, null));
            if (strE == null) {
                throw new IllegalArgumentException(kotlin.jvm.internal.t.r("unexpected host: ", host));
            }
            C(strE);
            return this;
        }

        @NotNull
        public final a q(@Nullable v vVar, @NotNull String str) {
            int iQ;
            int i10;
            int i11;
            String str2;
            boolean z10;
            int i12;
            String str3;
            int i13;
            boolean z11;
            String input = str;
            kotlin.jvm.internal.t.i(input, "input");
            int iA = ha.d.A(input, 0, 0, 3, null);
            int iC = ha.d.C(input, iA, 0, 2, null);
            C0568a c0568a = f26228i;
            int iG = c0568a.g(input, iA, iC);
            String str4 = "this as java.lang.String…ing(startIndex, endIndex)";
            boolean z12 = true;
            byte b10 = -1;
            if (iG != -1) {
                if (p9.q.H(input, "https:", iA, true)) {
                    this.f26229a = "https";
                    iA += 6;
                } else {
                    if (!p9.q.H(input, "http:", iA, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input.substring(0, iG);
                        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f26229a = ProxyConfig.MATCH_HTTP;
                    iA += 5;
                }
            } else {
                if (vVar == null) {
                    if (str.length() > 6) {
                        input = kotlin.jvm.internal.t.r(p9.t.h1(input, 6), "...");
                    }
                    throw new IllegalArgumentException(kotlin.jvm.internal.t.r("Expected URL scheme 'http' or 'https' but no scheme was found for ", input));
                }
                this.f26229a = vVar.r();
            }
            int iH = c0568a.h(input, iA, iC);
            byte b11 = 63;
            byte b12 = 35;
            if (iH >= 2 || vVar == null || !kotlin.jvm.internal.t.d(vVar.r(), this.f26229a)) {
                int i14 = iA + iH;
                boolean z13 = false;
                boolean z14 = false;
                while (true) {
                    iQ = ha.d.q(input, "@/\\?#", i14, iC);
                    byte bCharAt = iQ != iC ? input.charAt(iQ) : b10;
                    if (bCharAt == b10 || bCharAt == b12 || bCharAt == 47 || bCharAt == 92 || bCharAt == b11) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z13) {
                            z10 = z12;
                            i12 = iC;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f26231c);
                            sb2.append("%40");
                            str3 = str4;
                            i13 = iQ;
                            sb2.append(b.b(v.f26216k, str, i14, iQ, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null));
                            this.f26231c = sb2.toString();
                        } else {
                            int iP = ha.d.p(input, ':', i14, iQ);
                            b bVar = v.f26216k;
                            z10 = z12;
                            i12 = iC;
                            String str5 = str4;
                            String strB = b.b(bVar, str, i14, iP, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                            if (z14) {
                                strB = this.f26230b + "%40" + strB;
                            }
                            this.f26230b = strB;
                            if (iP != iQ) {
                                this.f26231c = b.b(bVar, str, iP + 1, iQ, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                                z11 = z10;
                            } else {
                                z11 = z13;
                            }
                            z13 = z11;
                            str3 = str5;
                            z14 = z10;
                            i13 = iQ;
                        }
                        i14 = i13 + 1;
                        str4 = str3;
                        z12 = z10;
                        iC = i12;
                        b12 = 35;
                        b11 = 63;
                        b10 = -1;
                    }
                }
                boolean z15 = z12;
                String str6 = str4;
                i10 = iC;
                C0568a c0568a2 = f26228i;
                int iF = c0568a2.f(input, i14, iQ);
                int i15 = iF + 1;
                if (i15 < iQ) {
                    i11 = i14;
                    this.f26232d = ha.a.e(b.h(v.f26216k, str, i14, iF, false, 4, null));
                    int iE = c0568a2.e(input, i15, iQ);
                    this.f26233e = iE;
                    if (!(iE != -1 ? z15 : false)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String strSubstring2 = input.substring(i15, iQ);
                        kotlin.jvm.internal.t.h(strSubstring2, str6);
                        sb3.append(strSubstring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                    str2 = str6;
                } else {
                    i11 = i14;
                    str2 = str6;
                    b bVar2 = v.f26216k;
                    this.f26232d = ha.a.e(b.h(bVar2, str, i11, iF, false, 4, null));
                    String str7 = this.f26229a;
                    kotlin.jvm.internal.t.f(str7);
                    this.f26233e = bVar2.c(str7);
                }
                if (!(this.f26232d != null ? z15 : false)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String strSubstring3 = input.substring(i11, iF);
                    kotlin.jvm.internal.t.h(strSubstring3, str2);
                    sb4.append(strSubstring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iA = iQ;
            } else {
                this.f26230b = vVar.g();
                this.f26231c = vVar.c();
                this.f26232d = vVar.i();
                this.f26233e = vVar.n();
                this.f26234f.clear();
                this.f26234f.addAll(vVar.e());
                if (iA == iC || input.charAt(iA) == '#') {
                    e(vVar.f());
                }
                i10 = iC;
            }
            int i16 = i10;
            int iQ2 = ha.d.q(input, "?#", iA, i16);
            w(input, iA, iQ2);
            if (iQ2 < i16 && input.charAt(iQ2) == '?') {
                int iP2 = ha.d.p(input, '#', iQ2, i16);
                b bVar3 = v.f26216k;
                this.f26235g = bVar3.j(b.b(bVar3, str, iQ2 + 1, iP2, " \"'<>#", true, false, true, false, null, 208, null));
                iQ2 = iP2;
            }
            if (iQ2 < i16 && input.charAt(iQ2) == '#') {
                this.f26236h = b.b(v.f26216k, str, iQ2 + 1, i16, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        @NotNull
        public final a r(@NotNull String password) {
            kotlin.jvm.internal.t.i(password, "password");
            z(b.b(v.f26216k, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        @NotNull
        public final a t(int i10) {
            boolean z10 = false;
            if (1 <= i10 && i10 < 65536) {
                z10 = true;
            }
            if (!z10) {
                throw new IllegalArgumentException(kotlin.jvm.internal.t.r("unexpected port: ", Integer.valueOf(i10)).toString());
            }
            D(i10);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                Method dump skipped, instruction units count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.v.a.toString():java.lang.String");
        }

        @NotNull
        public final a v() {
            String strK = k();
            C(strK == null ? null : new p9.f("[\"<>^`{|}]").b(strK, ""));
            int size = h().size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                h().set(i11, b.b(v.f26216k, h().get(i11), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List<String> listI = i();
            if (listI != null) {
                int size2 = listI.size();
                while (i10 < size2) {
                    int i12 = i10 + 1;
                    String str = listI.get(i10);
                    listI.set(i10, str == null ? null : b.b(v.f26216k, str, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null));
                    i10 = i12;
                }
            }
            String strF = f();
            y(strF != null ? b.b(v.f26216k, strF, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null);
            return this;
        }

        @NotNull
        public final a x(@NotNull String scheme) {
            kotlin.jvm.internal.t.i(scheme, "scheme");
            if (p9.q.x(scheme, ProxyConfig.MATCH_HTTP, true)) {
                E(ProxyConfig.MATCH_HTTP);
            } else {
                if (!p9.q.x(scheme, "https", true)) {
                    throw new IllegalArgumentException(kotlin.jvm.internal.t.r("unexpected scheme: ", scheme));
                }
                E("https");
            }
            return this;
        }

        public final void y(@Nullable String str) {
            this.f26236h = str;
        }

        public final void z(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<set-?>");
            this.f26231c = str;
        }
    }

    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ String b(b bVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12, Object obj) {
            return bVar.a(str, (i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? str.length() : i11, str2, (i12 & 8) != 0 ? false : z10, (i12 & 16) != 0 ? false : z11, (i12 & 32) != 0 ? false : z12, (i12 & 64) != 0 ? false : z13, (i12 & 128) != 0 ? null : charset);
        }

        private final boolean e(String str, int i10, int i11) {
            int i12 = i10 + 2;
            return i12 < i11 && str.charAt(i10) == '%' && ha.d.I(str.charAt(i10 + 1)) != -1 && ha.d.I(str.charAt(i12)) != -1;
        }

        public static /* synthetic */ String h(b bVar, String str, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = str.length();
            }
            if ((i12 & 4) != 0) {
                z10 = false;
            }
            return bVar.g(str, i10, i11, z10);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0090 A[LOOP:1: B:49:0x008a->B:51:0x0090, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void l(ua.c r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lb9
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L28
                r8 = 9
                if (r7 == r8) goto L23
                r8 = 10
                if (r7 == r8) goto L23
                r8 = 12
                if (r7 == r8) goto L23
                r8 = 13
                if (r7 != r8) goto L28
            L23:
                r8 = r14
                r12 = r19
                goto Lb2
            L28:
                r8 = 43
                if (r7 != r8) goto L39
                if (r22 == 0) goto L39
                if (r20 == 0) goto L33
                java.lang.String r8 = "+"
                goto L35
            L33:
                java.lang.String r8 = "%2B"
            L35:
                r15.E(r8)
                goto L23
            L39:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L69
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L69
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L49
                if (r23 == 0) goto L69
            L49:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = p9.h.O(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L67
                if (r7 != r9) goto L62
                if (r20 == 0) goto L67
                if (r21 == 0) goto L62
                r8 = r14
                boolean r10 = r14.e(r1, r5, r2)
                if (r10 != 0) goto L63
                goto L6c
            L62:
                r8 = r14
            L63:
                r15.c1(r7)
                goto Lb2
            L67:
                r8 = r14
                goto L6c
            L69:
                r8 = r14
                r12 = r19
            L6c:
                if (r6 != 0) goto L73
                ua.c r6 = new ua.c
                r6.<init>()
            L73:
                if (r3 == 0) goto L87
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.t.d(r3, r10)
                if (r10 == 0) goto L7e
                goto L87
            L7e:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.Y0(r1, r5, r10, r3)
                goto L8a
            L87:
                r6.c1(r7)
            L8a:
                boolean r10 = r6.m0()
                if (r10 != 0) goto Lb2
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = ga.v.a()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = ga.v.a()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L8a
            Lb2:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lb9:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.v.b.l(ua.c, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void m(ua.c cVar, String str, int i10, int i11, boolean z10) {
            int i12;
            while (i10 < i11) {
                int iCodePointAt = str.codePointAt(i10);
                if (iCodePointAt == 37 && (i12 = i10 + 2) < i11) {
                    int I = ha.d.I(str.charAt(i10 + 1));
                    int I2 = ha.d.I(str.charAt(i12));
                    if (I == -1 || I2 == -1) {
                        cVar.c1(iCodePointAt);
                        i10 += Character.charCount(iCodePointAt);
                    } else {
                        cVar.writeByte((I << 4) + I2);
                        i10 = Character.charCount(iCodePointAt) + i12;
                    }
                } else if (iCodePointAt == 43 && z10) {
                    cVar.writeByte(32);
                    i10++;
                } else {
                    cVar.c1(iCodePointAt);
                    i10 += Character.charCount(iCodePointAt);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String a(@org.jetbrains.annotations.NotNull java.lang.String r14, int r15, int r16, @org.jetbrains.annotations.NotNull java.lang.String r17, boolean r18, boolean r19, boolean r20, boolean r21, @org.jetbrains.annotations.Nullable java.nio.charset.Charset r22) {
            /*
                r13 = this;
                r2 = r14
                r4 = r16
                r5 = r17
                java.lang.String r0 = "<this>"
                kotlin.jvm.internal.t.i(r14, r0)
                java.lang.String r0 = "encodeSet"
                kotlin.jvm.internal.t.i(r5, r0)
                r3 = r15
            L10:
                if (r3 >= r4) goto L6f
                int r0 = r14.codePointAt(r3)
                r1 = 32
                if (r0 < r1) goto L4c
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 == r1) goto L4c
                r1 = 128(0x80, float:1.8E-43)
                if (r0 < r1) goto L24
                if (r21 == 0) goto L4c
            L24:
                char r1 = (char) r0
                r6 = 2
                r7 = 0
                r8 = 0
                boolean r1 = p9.h.O(r5, r1, r8, r6, r7)
                if (r1 != 0) goto L4c
                r1 = 37
                if (r0 != r1) goto L3e
                if (r18 == 0) goto L4c
                if (r19 == 0) goto L3e
                r11 = r13
                boolean r1 = r13.e(r14, r3, r4)
                if (r1 == 0) goto L4d
                goto L3f
            L3e:
                r11 = r13
            L3f:
                r1 = 43
                if (r0 != r1) goto L46
                if (r20 == 0) goto L46
                goto L4d
            L46:
                int r0 = java.lang.Character.charCount(r0)
                int r3 = r3 + r0
                goto L10
            L4c:
                r11 = r13
            L4d:
                ua.c r12 = new ua.c
                r12.<init>()
                r0 = r15
                r12.b1(r14, r15, r3)
                r0 = r13
                r1 = r12
                r2 = r14
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r10 = r22
                r0.l(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                java.lang.String r0 = r12.K0()
                return r0
            L6f:
                r11 = r13
                r0 = r15
                java.lang.String r0 = r14.substring(r15, r16)
                java.lang.String r1 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.t.h(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.v.b.a(java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):java.lang.String");
        }

        public final int c(@NotNull String scheme) {
            kotlin.jvm.internal.t.i(scheme, "scheme");
            if (kotlin.jvm.internal.t.d(scheme, ProxyConfig.MATCH_HTTP)) {
                return 80;
            }
            return kotlin.jvm.internal.t.d(scheme, "https") ? 443 : -1;
        }

        @NotNull
        public final v d(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            return new a().q(null, str).c();
        }

        @Nullable
        public final v f(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            try {
                return d(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @NotNull
        public final String g(@NotNull String str, int i10, int i11, boolean z10) {
            kotlin.jvm.internal.t.i(str, "<this>");
            int i12 = i10;
            while (i12 < i11) {
                int i13 = i12 + 1;
                char cCharAt = str.charAt(i12);
                if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                    ua.c cVar = new ua.c();
                    cVar.b1(str, i10, i12);
                    m(cVar, str, i12, i11, z10);
                    return cVar.K0();
                }
                i12 = i13;
            }
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void i(@NotNull List<String> list, @NotNull StringBuilder out) {
            kotlin.jvm.internal.t.i(list, "<this>");
            kotlin.jvm.internal.t.i(out, "out");
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                out.append('/');
                out.append(list.get(i10));
            }
        }

        @NotNull
        public final List<String> j(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                int iD0 = p9.r.d0(str, '&', i10, false, 4, null);
                if (iD0 == -1) {
                    iD0 = str.length();
                }
                int i11 = iD0;
                int iD02 = p9.r.d0(str, nb.T, i10, false, 4, null);
                if (iD02 == -1 || iD02 > i11) {
                    String strSubstring = str.substring(i10, i11);
                    kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i10, iD02);
                    kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iD02 + 1, i11);
                    kotlin.jvm.internal.t.h(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i10 = i11 + 1;
            }
            return arrayList;
        }

        public final void k(@NotNull List<String> list, @NotNull StringBuilder out) {
            kotlin.jvm.internal.t.i(list, "<this>");
            kotlin.jvm.internal.t.i(out, "out");
            n9.g gVarT = n9.o.t(n9.o.u(0, list.size()), 2);
            int iB = gVarT.b();
            int iE = gVarT.e();
            int iF = gVarT.f();
            if ((iF <= 0 || iB > iE) && (iF >= 0 || iE > iB)) {
                return;
            }
            while (true) {
                int i10 = iB + iF;
                String str = list.get(iB);
                String str2 = list.get(iB + 1);
                if (iB > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append(nb.T);
                    out.append(str2);
                }
                if (iB == iE) {
                    return;
                } else {
                    iB = i10;
                }
            }
        }
    }

    public v(@NotNull String scheme, @NotNull String username, @NotNull String password, @NotNull String host, int i10, @NotNull List<String> pathSegments, @Nullable List<String> list, @Nullable String str, @NotNull String url) {
        kotlin.jvm.internal.t.i(scheme, "scheme");
        kotlin.jvm.internal.t.i(username, "username");
        kotlin.jvm.internal.t.i(password, "password");
        kotlin.jvm.internal.t.i(host, "host");
        kotlin.jvm.internal.t.i(pathSegments, "pathSegments");
        kotlin.jvm.internal.t.i(url, "url");
        this.f26218a = scheme;
        this.f26219b = username;
        this.f26220c = password;
        this.f26221d = host;
        this.f26222e = i10;
        this.f26223f = pathSegments;
        this.f26224g = list;
        this.f26225h = str;
        this.f26226i = url;
        this.f26227j = kotlin.jvm.internal.t.d(scheme, "https");
    }

    @NotNull
    public static final v h(@NotNull String str) {
        return f26216k.d(str);
    }

    @Nullable
    public final String b() {
        if (this.f26225h == null) {
            return null;
        }
        String strSubstring = this.f26226i.substring(p9.r.d0(this.f26226i, '#', 0, false, 6, null) + 1);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @NotNull
    public final String c() {
        if (this.f26220c.length() == 0) {
            return "";
        }
        String strSubstring = this.f26226i.substring(p9.r.d0(this.f26226i, ':', this.f26218a.length() + 3, false, 4, null) + 1, p9.r.d0(this.f26226i, '@', 0, false, 6, null));
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public final String d() {
        int iD0 = p9.r.d0(this.f26226i, '/', this.f26218a.length() + 3, false, 4, null);
        String str = this.f26226i;
        String strSubstring = this.f26226i.substring(iD0, ha.d.q(str, "?#", iD0, str.length()));
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public final List<String> e() {
        int iD0 = p9.r.d0(this.f26226i, '/', this.f26218a.length() + 3, false, 4, null);
        String str = this.f26226i;
        int iQ = ha.d.q(str, "?#", iD0, str.length());
        ArrayList arrayList = new ArrayList();
        while (iD0 < iQ) {
            int i10 = iD0 + 1;
            int iP = ha.d.p(this.f26226i, '/', i10, iQ);
            String strSubstring = this.f26226i.substring(i10, iP);
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iD0 = iP;
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof v) && kotlin.jvm.internal.t.d(((v) obj).f26226i, this.f26226i);
    }

    @Nullable
    public final String f() {
        if (this.f26224g == null) {
            return null;
        }
        int iD0 = p9.r.d0(this.f26226i, '?', 0, false, 6, null) + 1;
        String str = this.f26226i;
        String strSubstring = this.f26226i.substring(iD0, ha.d.p(str, '#', iD0, str.length()));
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public final String g() {
        if (this.f26219b.length() == 0) {
            return "";
        }
        int length = this.f26218a.length() + 3;
        String str = this.f26226i;
        String strSubstring = this.f26226i.substring(length, ha.d.q(str, ":@", length, str.length()));
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public int hashCode() {
        return this.f26226i.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f26221d;
    }

    public final boolean j() {
        return this.f26227j;
    }

    @NotNull
    public final a k() {
        a aVar = new a();
        aVar.E(this.f26218a);
        aVar.B(g());
        aVar.z(c());
        aVar.C(this.f26221d);
        aVar.D(this.f26222e != f26216k.c(this.f26218a) ? this.f26222e : -1);
        aVar.h().clear();
        aVar.h().addAll(e());
        aVar.e(f());
        aVar.y(b());
        return aVar;
    }

    @Nullable
    public final a l(@NotNull String link) {
        kotlin.jvm.internal.t.i(link, "link");
        try {
            return new a().q(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @NotNull
    public final List<String> m() {
        return this.f26223f;
    }

    public final int n() {
        return this.f26222e;
    }

    @Nullable
    public final String o() {
        if (this.f26224g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        f26216k.k(this.f26224g, sb);
        return sb.toString();
    }

    @NotNull
    public final String p() {
        a aVarL = l("/...");
        kotlin.jvm.internal.t.f(aVarL);
        return aVarL.F("").r("").c().toString();
    }

    @Nullable
    public final v q(@NotNull String link) {
        kotlin.jvm.internal.t.i(link, "link");
        a aVarL = l(link);
        if (aVarL == null) {
            return null;
        }
        return aVarL.c();
    }

    @NotNull
    public final String r() {
        return this.f26218a;
    }

    @NotNull
    public final URI s() {
        String string = k().v().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                URI uriCreate = URI.create(new p9.f("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").b(string, ""));
                kotlin.jvm.internal.t.h(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    @NotNull
    public final URL t() {
        try {
            return new URL(this.f26226i);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }

    @NotNull
    public String toString() {
        return this.f26226i;
    }
}
