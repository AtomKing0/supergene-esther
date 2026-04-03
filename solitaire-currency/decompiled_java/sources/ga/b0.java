package ga;

import ga.u;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final v f25947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f25948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final u f25949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final c0 f25950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Map<Class<?>, Object> f25951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private d f25952f;

    public b0(@NotNull v url, @NotNull String method, @NotNull u headers, @Nullable c0 c0Var, @NotNull Map<Class<?>, ? extends Object> tags) {
        kotlin.jvm.internal.t.i(url, "url");
        kotlin.jvm.internal.t.i(method, "method");
        kotlin.jvm.internal.t.i(headers, "headers");
        kotlin.jvm.internal.t.i(tags, "tags");
        this.f25947a = url;
        this.f25948b = method;
        this.f25949c = headers;
        this.f25950d = c0Var;
        this.f25951e = tags;
    }

    @Nullable
    public final c0 a() {
        return this.f25950d;
    }

    @NotNull
    public final d b() {
        d dVar = this.f25952f;
        if (dVar != null) {
            return dVar;
        }
        d dVarB = d.f25999n.b(this.f25949c);
        this.f25952f = dVarB;
        return dVarB;
    }

    @NotNull
    public final Map<Class<?>, Object> c() {
        return this.f25951e;
    }

    @Nullable
    public final String d(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return this.f25949c.a(name);
    }

    @NotNull
    public final u e() {
        return this.f25949c;
    }

    @NotNull
    public final List<String> f(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return this.f25949c.j(name);
    }

    public final boolean g() {
        return this.f25947a.j();
    }

    @NotNull
    public final String h() {
        return this.f25948b;
    }

    @NotNull
    public final a i() {
        return new a(this);
    }

    @Nullable
    public final <T> T j(@NotNull Class<? extends T> type) {
        kotlin.jvm.internal.t.i(type, "type");
        return type.cast(this.f25951e.get(type));
    }

    @NotNull
    public final v k() {
        return this.f25947a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(h());
        sb.append(", url=");
        sb.append(k());
        if (e().size() != 0) {
            sb.append(", headers=[");
            int i10 = 0;
            for (v8.s<? extends String, ? extends String> sVar : e()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.v.u();
                }
                v8.s<? extends String, ? extends String> sVar2 = sVar;
                String strA = sVar2.a();
                String strB = sVar2.b();
                if (i10 > 0) {
                    sb.append(", ");
                }
                sb.append(strA);
                sb.append(':');
                sb.append(strB);
                i10 = i11;
            }
            sb.append(']');
        }
        if (!c().isEmpty()) {
            sb.append(", tags=");
            sb.append(c());
        }
        sb.append('}');
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: compiled from: Request.kt */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private v f25953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private String f25954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private u.a f25955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private c0 f25956d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private Map<Class<?>, Object> f25957e;

        public a() {
            this.f25957e = new LinkedHashMap();
            this.f25954b = "GET";
            this.f25955c = new u.a();
        }

        @NotNull
        public a a(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            e().a(name, value);
            return this;
        }

        @NotNull
        public b0 b() {
            v vVar = this.f25953a;
            if (vVar != null) {
                return new b0(vVar, this.f25954b, this.f25955c.f(), this.f25956d, ha.d.U(this.f25957e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        @NotNull
        public a c(@NotNull d cacheControl) {
            kotlin.jvm.internal.t.i(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? k("Cache-Control") : g("Cache-Control", string);
        }

        @NotNull
        public a d() {
            return i("GET", null);
        }

        @NotNull
        public final u.a e() {
            return this.f25955c;
        }

        @NotNull
        public final Map<Class<?>, Object> f() {
            return this.f25957e;
        }

        @NotNull
        public a g(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            e().j(name, value);
            return this;
        }

        @NotNull
        public a h(@NotNull u headers) {
            kotlin.jvm.internal.t.i(headers, "headers");
            m(headers.f());
            return this;
        }

        @NotNull
        public a i(@NotNull String method, @Nullable c0 c0Var) {
            kotlin.jvm.internal.t.i(method, "method");
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (c0Var == null) {
                if (!(true ^ ma.f.e(method))) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!ma.f.b(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            n(method);
            l(c0Var);
            return this;
        }

        @NotNull
        public a j(@NotNull c0 body) {
            kotlin.jvm.internal.t.i(body, "body");
            return i("POST", body);
        }

        @NotNull
        public a k(@NotNull String name) {
            kotlin.jvm.internal.t.i(name, "name");
            e().i(name);
            return this;
        }

        public final void l(@Nullable c0 c0Var) {
            this.f25956d = c0Var;
        }

        public final void m(@NotNull u.a aVar) {
            kotlin.jvm.internal.t.i(aVar, "<set-?>");
            this.f25955c = aVar;
        }

        public final void n(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<set-?>");
            this.f25954b = str;
        }

        public final void o(@NotNull Map<Class<?>, Object> map) {
            kotlin.jvm.internal.t.i(map, "<set-?>");
            this.f25957e = map;
        }

        public final void p(@Nullable v vVar) {
            this.f25953a = vVar;
        }

        @NotNull
        public <T> a q(@NotNull Class<? super T> type, @Nullable T t10) {
            kotlin.jvm.internal.t.i(type, "type");
            if (t10 == null) {
                f().remove(type);
            } else {
                if (f().isEmpty()) {
                    o(new LinkedHashMap());
                }
                Map<Class<?>, Object> mapF = f();
                T tCast = type.cast(t10);
                kotlin.jvm.internal.t.f(tCast);
                mapF.put(type, tCast);
            }
            return this;
        }

        @NotNull
        public a r(@NotNull v url) {
            kotlin.jvm.internal.t.i(url, "url");
            p(url);
            return this;
        }

        @NotNull
        public a s(@NotNull String url) {
            kotlin.jvm.internal.t.i(url, "url");
            if (p9.q.I(url, "ws:", true)) {
                String strSubstring = url.substring(3);
                kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                url = kotlin.jvm.internal.t.r("http:", strSubstring);
            } else if (p9.q.I(url, "wss:", true)) {
                String strSubstring2 = url.substring(4);
                kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
                url = kotlin.jvm.internal.t.r("https:", strSubstring2);
            }
            return r(v.f26216k.d(url));
        }

        public a(@NotNull b0 request) {
            Map<Class<?>, Object> mapZ;
            kotlin.jvm.internal.t.i(request, "request");
            this.f25957e = new LinkedHashMap();
            this.f25953a = request.k();
            this.f25954b = request.h();
            this.f25956d = request.a();
            if (!request.c().isEmpty()) {
                mapZ = r0.z(request.c());
            } else {
                mapZ = new LinkedHashMap<>();
            }
            this.f25957e = mapZ;
            this.f25955c = request.e().f();
        }
    }
}
