package ga;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ConnectionSpec.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final b f26153e = new b(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final i[] f26154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final i[] f26155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final l f26156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final l f26157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final l f26158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final l f26159k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f26160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String[] f26162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String[] f26163d;

    /* JADX INFO: compiled from: ConnectionSpec.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    static {
        i iVar = i.f26124o1;
        i iVar2 = i.f26127p1;
        i iVar3 = i.f26130q1;
        i iVar4 = i.f26082a1;
        i iVar5 = i.f26094e1;
        i iVar6 = i.f26085b1;
        i iVar7 = i.f26097f1;
        i iVar8 = i.f26115l1;
        i iVar9 = i.f26112k1;
        i[] iVarArr = {iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9};
        f26154f = iVarArr;
        i[] iVarArr2 = {iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9, i.L0, i.M0, i.f26108j0, i.f26111k0, i.H, i.L, i.f26113l};
        f26155g = iVarArr2;
        a aVarB = new a(true).b((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        g0 g0Var = g0.TLS_1_3;
        g0 g0Var2 = g0.TLS_1_2;
        f26156h = aVarB.i(g0Var, g0Var2).h(true).a();
        f26157i = new a(true).b((i[]) Arrays.copyOf(iVarArr2, iVarArr2.length)).i(g0Var, g0Var2).h(true).a();
        f26158j = new a(true).b((i[]) Arrays.copyOf(iVarArr2, iVarArr2.length)).i(g0Var, g0Var2, g0.TLS_1_1, g0.TLS_1_0).h(true).a();
        f26159k = new a(false).a();
    }

    public l(boolean z10, boolean z11, @Nullable String[] strArr, @Nullable String[] strArr2) {
        this.f26160a = z10;
        this.f26161b = z11;
        this.f26162c = strArr;
        this.f26163d = strArr2;
    }

    private final l g(SSLSocket sSLSocket, boolean z10) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        if (this.f26162c != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            kotlin.jvm.internal.t.h(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = ha.d.E(enabledCipherSuites, this.f26162c, i.f26083b.c());
        } else {
            cipherSuitesIntersection = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f26163d != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            kotlin.jvm.internal.t.h(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = ha.d.E(enabledProtocols, this.f26163d, x8.b.b());
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        kotlin.jvm.internal.t.h(supportedCipherSuites, "supportedCipherSuites");
        int iX = ha.d.x(supportedCipherSuites, "TLS_FALLBACK_SCSV", i.f26083b.c());
        if (z10 && iX != -1) {
            kotlin.jvm.internal.t.h(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iX];
            kotlin.jvm.internal.t.h(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = ha.d.o(cipherSuitesIntersection, str);
        }
        a aVar = new a(this);
        kotlin.jvm.internal.t.h(cipherSuitesIntersection, "cipherSuitesIntersection");
        a aVarC = aVar.c((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        kotlin.jvm.internal.t.h(tlsVersionsIntersection, "tlsVersionsIntersection");
        return aVarC.j((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).a();
    }

    public final void c(@NotNull SSLSocket sslSocket, boolean z10) {
        kotlin.jvm.internal.t.i(sslSocket, "sslSocket");
        l lVarG = g(sslSocket, z10);
        if (lVarG.i() != null) {
            sslSocket.setEnabledProtocols(lVarG.f26163d);
        }
        if (lVarG.d() != null) {
            sslSocket.setEnabledCipherSuites(lVarG.f26162c);
        }
    }

    @Nullable
    public final List<i> d() {
        String[] strArr = this.f26162c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(i.f26083b.b(str));
        }
        return kotlin.collections.d0.P0(arrayList);
    }

    public final boolean e(@NotNull SSLSocket socket) {
        kotlin.jvm.internal.t.i(socket, "socket");
        if (!this.f26160a) {
            return false;
        }
        String[] strArr = this.f26163d;
        if (strArr != null && !ha.d.u(strArr, socket.getEnabledProtocols(), x8.b.b())) {
            return false;
        }
        String[] strArr2 = this.f26162c;
        return strArr2 == null || ha.d.u(strArr2, socket.getEnabledCipherSuites(), i.f26083b.c());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z10 = this.f26160a;
        l lVar = (l) obj;
        if (z10 != lVar.f26160a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f26162c, lVar.f26162c) && Arrays.equals(this.f26163d, lVar.f26163d) && this.f26161b == lVar.f26161b);
    }

    public final boolean f() {
        return this.f26160a;
    }

    public final boolean h() {
        return this.f26161b;
    }

    public int hashCode() {
        if (!this.f26160a) {
            return 17;
        }
        String[] strArr = this.f26162c;
        int iHashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String[] strArr2 = this.f26163d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f26161b ? 1 : 0);
    }

    @Nullable
    public final List<g0> i() {
        String[] strArr = this.f26163d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(g0.f26071b.a(str));
        }
        return kotlin.collections.d0.P0(arrayList);
    }

    @NotNull
    public String toString() {
        if (!this.f26160a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + ((Object) Objects.toString(d(), "[all enabled]")) + ", tlsVersions=" + ((Object) Objects.toString(i(), "[all enabled]")) + ", supportsTlsExtensions=" + this.f26161b + ')';
    }

    /* JADX INFO: compiled from: ConnectionSpec.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f26164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private String[] f26165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String[] f26166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f26167d;

        public a(boolean z10) {
            this.f26164a = z10;
        }

        @NotNull
        public final l a() {
            return new l(this.f26164a, this.f26167d, this.f26165b, this.f26166c);
        }

        @NotNull
        public final a b(@NotNull i... cipherSuites) {
            kotlin.jvm.internal.t.i(cipherSuites, "cipherSuites");
            if (!d()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (i iVar : cipherSuites) {
                arrayList.add(iVar.c());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            String[] strArr = (String[]) array;
            return c((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @NotNull
        public final a c(@NotNull String... cipherSuites) {
            kotlin.jvm.internal.t.i(cipherSuites, "cipherSuites");
            if (!d()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(cipherSuites.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            e((String[]) cipherSuites.clone());
            return this;
        }

        public final boolean d() {
            return this.f26164a;
        }

        public final void e(@Nullable String[] strArr) {
            this.f26165b = strArr;
        }

        public final void f(boolean z10) {
            this.f26167d = z10;
        }

        public final void g(@Nullable String[] strArr) {
            this.f26166c = strArr;
        }

        @NotNull
        public final a h(boolean z10) {
            if (!d()) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            f(z10);
            return this;
        }

        @NotNull
        public final a i(@NotNull g0... tlsVersions) {
            kotlin.jvm.internal.t.i(tlsVersions, "tlsVersions");
            if (!d()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(tlsVersions.length);
            for (g0 g0Var : tlsVersions) {
                arrayList.add(g0Var.c());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            String[] strArr = (String[]) array;
            return j((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @NotNull
        public final a j(@NotNull String... tlsVersions) {
            kotlin.jvm.internal.t.i(tlsVersions, "tlsVersions");
            if (!d()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(tlsVersions.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            g((String[]) tlsVersions.clone());
            return this;
        }

        public a(@NotNull l connectionSpec) {
            kotlin.jvm.internal.t.i(connectionSpec, "connectionSpec");
            this.f26164a = connectionSpec.f();
            this.f26165b = connectionSpec.f26162c;
            this.f26166c = connectionSpec.f26163d;
            this.f26167d = connectionSpec.h();
        }
    }
}
