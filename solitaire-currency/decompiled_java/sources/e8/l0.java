package e8;

import androidx.webkit.ProxyConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: URLProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f25262c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final l0 f25263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final l0 f25264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final l0 f25265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final l0 f25266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final l0 f25267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Map<String, l0> f25268i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25270b;

    /* JADX INFO: compiled from: URLProtocol.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final l0 a(@NotNull String name) {
            kotlin.jvm.internal.t.i(name, "name");
            String strC = g8.y.c(name);
            l0 l0Var = l0.f25262c.b().get(strC);
            return l0Var == null ? new l0(strC, 0) : l0Var;
        }

        @NotNull
        public final Map<String, l0> b() {
            return l0.f25268i;
        }

        @NotNull
        public final l0 c() {
            return l0.f25263d;
        }
    }

    static {
        l0 l0Var = new l0(ProxyConfig.MATCH_HTTP, 80);
        f25263d = l0Var;
        l0 l0Var2 = new l0("https", 443);
        f25264e = l0Var2;
        l0 l0Var3 = new l0("ws", 80);
        f25265f = l0Var3;
        l0 l0Var4 = new l0("wss", 443);
        f25266g = l0Var4;
        l0 l0Var5 = new l0("socks", 1080);
        f25267h = l0Var5;
        List listN = kotlin.collections.v.n(l0Var, l0Var2, l0Var3, l0Var4, l0Var5);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(kotlin.collections.w.v(listN, 10)), 16));
        for (Object obj : listN) {
            linkedHashMap.put(((l0) obj).f25269a, obj);
        }
        f25268i = linkedHashMap;
    }

    public l0(@NotNull String name, int i10) {
        kotlin.jvm.internal.t.i(name, "name");
        this.f25269a = name;
        this.f25270b = i10;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= name.length()) {
                z10 = true;
                break;
            } else if (!g8.i.a(name.charAt(i11))) {
                break;
            } else {
                i11++;
            }
        }
        if (!z10) {
            throw new IllegalArgumentException("All characters should be lower case".toString());
        }
    }

    public final int c() {
        return this.f25270b;
    }

    @NotNull
    public final String d() {
        return this.f25269a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return kotlin.jvm.internal.t.d(this.f25269a, l0Var.f25269a) && this.f25270b == l0Var.f25270b;
    }

    public int hashCode() {
        return (this.f25269a.hashCode() * 31) + this.f25270b;
    }

    @NotNull
    public String toString() {
        return "URLProtocol(name=" + this.f25269a + ", defaultPort=" + this.f25270b + ')';
    }
}
