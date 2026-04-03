package e8;

import androidx.webkit.ProxyConfig;
import com.king.amp.sa.AbmAdPlayer;
import e8.i;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final b f25197f = new b(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final c f25198g = new c(ProxyConfig.MATCH_ALL_SCHEMES, ProxyConfig.MATCH_ALL_SCHEMES, null, 4, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f25199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f25200e;

    /* JADX INFO: compiled from: ContentTypes.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f25201a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private static final c f25202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private static final c f25203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private static final c f25204d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private static final c f25205e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private static final c f25206f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private static final c f25207g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        private static final c f25208h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NotNull
        private static final c f25209i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NotNull
        private static final c f25210j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @NotNull
        private static final c f25211k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NotNull
        private static final c f25212l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @NotNull
        private static final c f25213m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @NotNull
        private static final c f25214n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @NotNull
        private static final c f25215o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @NotNull
        private static final c f25216p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @NotNull
        private static final c f25217q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @NotNull
        private static final c f25218r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @NotNull
        private static final c f25219s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @NotNull
        private static final c f25220t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @NotNull
        private static final c f25221u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @NotNull
        private static final c f25222v;

        static {
            List list = null;
            int i10 = 4;
            kotlin.jvm.internal.k kVar = null;
            f25202b = new c("application", ProxyConfig.MATCH_ALL_SCHEMES, list, i10, kVar);
            List list2 = null;
            int i11 = 4;
            kotlin.jvm.internal.k kVar2 = null;
            f25203c = new c("application", "atom+xml", list2, i11, kVar2);
            f25204d = new c("application", "cbor", list, i10, kVar);
            f25205e = new c("application", "json", list2, i11, kVar2);
            f25206f = new c("application", "hal+json", list, i10, kVar);
            f25207g = new c("application", "javascript", list2, i11, kVar2);
            f25208h = new c("application", "octet-stream", list, i10, kVar);
            f25209i = new c("application", "rss+xml", list2, i11, kVar2);
            f25210j = new c("application", "xml", list, i10, kVar);
            f25211k = new c("application", "xml-dtd", list2, i11, kVar2);
            f25212l = new c("application", "zip", list, i10, kVar);
            f25213m = new c("application", "gzip", list2, i11, kVar2);
            f25214n = new c("application", "x-www-form-urlencoded", list, i10, kVar);
            f25215o = new c("application", "pdf", list2, i11, kVar2);
            f25216p = new c("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", list, i10, kVar);
            f25217q = new c("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", list2, i11, kVar2);
            f25218r = new c("application", "vnd.openxmlformats-officedocument.presentationml.presentation", list, i10, kVar);
            f25219s = new c("application", "protobuf", list2, i11, kVar2);
            f25220t = new c("application", "wasm", list, i10, kVar);
            f25221u = new c("application", "problem+json", list2, i11, kVar2);
            f25222v = new c("application", "problem+xml", list, i10, kVar);
        }

        private a() {
        }

        @NotNull
        public final c a() {
            return f25208h;
        }

        @NotNull
        public final c b() {
            return f25219s;
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final c a() {
            return c.f25198g;
        }

        @NotNull
        public final c b(@NotNull String value) throws e8.a {
            kotlin.jvm.internal.t.i(value, "value");
            if (p9.q.z(value)) {
                return a();
            }
            i.a aVar = i.f25253c;
            g gVar = (g) kotlin.collections.d0.t0(n.b(value));
            String strB = gVar.b();
            List<h> listA = gVar.a();
            int iD0 = p9.r.d0(strB, '/', 0, false, 6, null);
            if (iD0 == -1) {
                if (kotlin.jvm.internal.t.d(p9.r.b1(strB).toString(), ProxyConfig.MATCH_ALL_SCHEMES)) {
                    return c.f25197f.a();
                }
                throw new e8.a(value);
            }
            String strSubstring = strB.substring(0, iD0);
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String string = p9.r.b1(strSubstring).toString();
            if (string.length() == 0) {
                throw new e8.a(value);
            }
            String strSubstring2 = strB.substring(iD0 + 1);
            kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
            String string2 = p9.r.b1(strSubstring2).toString();
            if (p9.r.O(string, ' ', false, 2, null) || p9.r.O(string2, ' ', false, 2, null)) {
                throw new e8.a(value);
            }
            if ((string2.length() == 0) || p9.r.O(string2, '/', false, 2, null)) {
                throw new e8.a(value);
            }
            return new c(string, string2, listA);
        }
    }

    /* JADX INFO: renamed from: e8.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContentTypes.kt */
    public static final class C0549c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0549c f25223a = new C0549c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private static final c f25224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private static final c f25225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private static final c f25226d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private static final c f25227e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private static final c f25228f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private static final c f25229g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        private static final c f25230h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NotNull
        private static final c f25231i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NotNull
        private static final c f25232j;

        static {
            List list = null;
            int i10 = 4;
            kotlin.jvm.internal.k kVar = null;
            f25224b = new c("text", ProxyConfig.MATCH_ALL_SCHEMES, list, i10, kVar);
            List list2 = null;
            int i11 = 4;
            kotlin.jvm.internal.k kVar2 = null;
            f25225c = new c("text", "plain", list2, i11, kVar2);
            f25226d = new c("text", "css", list, i10, kVar);
            f25227e = new c("text", "csv", list2, i11, kVar2);
            f25228f = new c("text", AbmAdPlayer.HTML, list, i10, kVar);
            f25229g = new c("text", "javascript", list2, i11, kVar2);
            f25230h = new c("text", "vcard", list, i10, kVar);
            f25231i = new c("text", "xml", list2, i11, kVar2);
            f25232j = new c("text", "event-stream", list, i10, kVar);
        }

        private C0549c() {
        }

        @NotNull
        public final c a() {
            return f25225c;
        }
    }

    private c(String str, String str2, String str3, List<h> list) {
        super(str3, list);
        this.f25199d = str;
        this.f25200e = str2;
    }

    private final boolean f(String str, String str2) {
        int size = b().size();
        if (size == 0) {
            return false;
        }
        if (size != 1) {
            List<h> listB = b();
            if ((listB instanceof Collection) && listB.isEmpty()) {
                return false;
            }
            for (h hVar : listB) {
                if (p9.q.x(hVar.a(), str, true) && p9.q.x(hVar.b(), str2, true)) {
                }
            }
            return false;
        }
        h hVar2 = b().get(0);
        if (!p9.q.x(hVar2.a(), str, true) || !p9.q.x(hVar2.b(), str2, true)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String e() {
        return this.f25199d;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (p9.q.x(this.f25199d, cVar.f25199d, true) && p9.q.x(this.f25200e, cVar.f25200e, true) && kotlin.jvm.internal.t.d(b(), cVar.b())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final c g(@NotNull String name, @NotNull String value) {
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(value, "value");
        return f(name, value) ? this : new c(this.f25199d, this.f25200e, a(), kotlin.collections.d0.B0(b(), new h(name, value)));
    }

    public int hashCode() {
        String str = this.f25199d;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.f25200e.toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return iHashCode + (iHashCode * 31) + lowerCase2.hashCode() + (b().hashCode() * 31);
    }

    public /* synthetic */ c(String str, String str2, List list, int i10, kotlin.jvm.internal.k kVar) {
        this(str, str2, (i10 & 4) != 0 ? kotlin.collections.v.l() : list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String contentType, @NotNull String contentSubtype, @NotNull List<h> parameters) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, parameters);
        kotlin.jvm.internal.t.i(contentType, "contentType");
        kotlin.jvm.internal.t.i(contentSubtype, "contentSubtype");
        kotlin.jvm.internal.t.i(parameters, "parameters");
    }
}
