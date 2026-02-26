package w7;

import h9.l;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v7.g;
import v8.k0;

/* JADX INFO: compiled from: AndroidEngineConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f35456c = 100000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f35457d = 100000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private l<? super HttpsURLConnection, k0> f35458e = b.f35461g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private l<? super HttpURLConnection, k0> f35459f = a.f35460g;

    /* JADX INFO: compiled from: AndroidEngineConfig.kt */
    static final class a extends v implements l<HttpURLConnection, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f35460g = new a();

        a() {
            super(1);
        }

        public final void a(@NotNull HttpURLConnection httpURLConnection) {
            t.i(httpURLConnection, "$this$null");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(HttpURLConnection httpURLConnection) {
            a(httpURLConnection);
            return k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: AndroidEngineConfig.kt */
    static final class b extends v implements l<HttpsURLConnection, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f35461g = new b();

        b() {
            super(1);
        }

        public final void a(@NotNull HttpsURLConnection it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(HttpsURLConnection httpsURLConnection) {
            a(httpsURLConnection);
            return k0.f35197a;
        }
    }

    public final int b() {
        return this.f35456c;
    }

    @NotNull
    public final l<HttpURLConnection, k0> c() {
        return this.f35459f;
    }

    public final int d() {
        return this.f35457d;
    }

    @NotNull
    public final l<HttpsURLConnection, k0> e() {
        return this.f35458e;
    }
}
