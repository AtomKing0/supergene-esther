package e8;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Url.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class p0 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    public static final a f25326q = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final l0 f25327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f25328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f25329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<String> f25330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final z f25331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final String f25332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final String f25333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f25334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f25335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final String f25336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final v8.l f25337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final v8.l f25338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final v8.l f25339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final v8.l f25340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final v8.l f25341o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private final v8.l f25342p;

    /* JADX INFO: compiled from: Url.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Url.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.a<String> {
        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            int iD0 = p9.r.d0(p0.this.f25336j, '#', 0, false, 6, null) + 1;
            if (iD0 == 0) {
                return "";
            }
            String strSubstring = p0.this.f25336j.substring(iD0);
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
    }

    /* JADX INFO: compiled from: Url.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.a<String> {
        c() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        public final String invoke() {
            if (p0.this.h() == null) {
                return null;
            }
            if (p0.this.h().length() == 0) {
                return "";
            }
            String strSubstring = p0.this.f25336j.substring(p9.r.d0(p0.this.f25336j, ':', p0.this.k().d().length() + 3, false, 4, null) + 1, p9.r.d0(p0.this.f25336j, '@', 0, false, 6, null));
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
    }

    /* JADX INFO: compiled from: Url.kt */
    static final class d extends kotlin.jvm.internal.v implements h9.a<String> {
        d() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            int iD0;
            if (p0.this.i().isEmpty() || (iD0 = p9.r.d0(p0.this.f25336j, '/', p0.this.k().d().length() + 3, false, 4, null)) == -1) {
                return "";
            }
            int iG0 = p9.r.g0(p0.this.f25336j, new char[]{'?', '#'}, iD0, false, 4, null);
            if (iG0 == -1) {
                String strSubstring = p0.this.f25336j.substring(iD0);
                kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
            String strSubstring2 = p0.this.f25336j.substring(iD0, iG0);
            kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }
    }

    /* JADX INFO: compiled from: Url.kt */
    static final class e extends kotlin.jvm.internal.v implements h9.a<String> {
        e() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            int iD0 = p9.r.d0(p0.this.f25336j, '/', p0.this.k().d().length() + 3, false, 4, null);
            if (iD0 == -1) {
                return "";
            }
            int iD02 = p9.r.d0(p0.this.f25336j, '#', iD0, false, 4, null);
            if (iD02 == -1) {
                String strSubstring = p0.this.f25336j.substring(iD0);
                kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
            String strSubstring2 = p0.this.f25336j.substring(iD0, iD02);
            kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }
    }

    /* JADX INFO: compiled from: Url.kt */
    static final class f extends kotlin.jvm.internal.v implements h9.a<String> {
        f() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            int iD0 = p9.r.d0(p0.this.f25336j, '?', 0, false, 6, null) + 1;
            if (iD0 == 0) {
                return "";
            }
            int iD02 = p9.r.d0(p0.this.f25336j, '#', iD0, false, 4, null);
            if (iD02 == -1) {
                String strSubstring = p0.this.f25336j.substring(iD0);
                kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
            String strSubstring2 = p0.this.f25336j.substring(iD0, iD02);
            kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }
    }

    /* JADX INFO: compiled from: Url.kt */
    static final class g extends kotlin.jvm.internal.v implements h9.a<String> {
        g() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        public final String invoke() {
            if (p0.this.n() == null) {
                return null;
            }
            if (p0.this.n().length() == 0) {
                return "";
            }
            int length = p0.this.k().d().length() + 3;
            String strSubstring = p0.this.f25336j.substring(length, p9.r.g0(p0.this.f25336j, new char[]{':', '@'}, length, false, 4, null));
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
    }

    public p0(@NotNull l0 protocol, @NotNull String host, int i10, @NotNull List<String> pathSegments, @NotNull z parameters, @NotNull String fragment, @Nullable String str, @Nullable String str2, boolean z10, @NotNull String urlString) {
        kotlin.jvm.internal.t.i(protocol, "protocol");
        kotlin.jvm.internal.t.i(host, "host");
        kotlin.jvm.internal.t.i(pathSegments, "pathSegments");
        kotlin.jvm.internal.t.i(parameters, "parameters");
        kotlin.jvm.internal.t.i(fragment, "fragment");
        kotlin.jvm.internal.t.i(urlString, "urlString");
        this.f25327a = protocol;
        this.f25328b = host;
        this.f25329c = i10;
        this.f25330d = pathSegments;
        this.f25331e = parameters;
        this.f25332f = fragment;
        this.f25333g = str;
        this.f25334h = str2;
        this.f25335i = z10;
        this.f25336j = urlString;
        boolean z11 = true;
        if (!(i10 >= 0 && i10 < 65536) && i10 != 0) {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set".toString());
        }
        this.f25337k = v8.n.a(new d());
        this.f25338l = v8.n.a(new f());
        this.f25339m = v8.n.a(new e());
        this.f25340n = v8.n.a(new g());
        this.f25341o = v8.n.a(new c());
        this.f25342p = v8.n.a(new b());
    }

    @NotNull
    public final String b() {
        return (String) this.f25342p.getValue();
    }

    @Nullable
    public final String c() {
        return (String) this.f25341o.getValue();
    }

    @NotNull
    public final String d() {
        return (String) this.f25337k.getValue();
    }

    @NotNull
    public final String e() {
        return (String) this.f25338l.getValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && p0.class == obj.getClass() && kotlin.jvm.internal.t.d(this.f25336j, ((p0) obj).f25336j);
    }

    @Nullable
    public final String f() {
        return (String) this.f25340n.getValue();
    }

    @NotNull
    public final String g() {
        return this.f25328b;
    }

    @Nullable
    public final String h() {
        return this.f25334h;
    }

    public int hashCode() {
        return this.f25336j.hashCode();
    }

    @NotNull
    public final List<String> i() {
        return this.f25330d;
    }

    public final int j() {
        Integer numValueOf = Integer.valueOf(this.f25329c);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : this.f25327a.c();
    }

    @NotNull
    public final l0 k() {
        return this.f25327a;
    }

    public final int l() {
        return this.f25329c;
    }

    public final boolean m() {
        return this.f25335i;
    }

    @Nullable
    public final String n() {
        return this.f25333g;
    }

    @NotNull
    public String toString() {
        return this.f25336j;
    }
}
