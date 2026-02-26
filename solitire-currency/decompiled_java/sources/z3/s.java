package z3;

import a4.o0;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.datasource.RawResourceDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import z3.k;
import z3.t;

/* JADX INFO: compiled from: DefaultDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f37519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<m0> f37520b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f37521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private k f37522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private k f37523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private k f37524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private k f37525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private k f37526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private k f37527i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private k f37528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private k f37529k;

    /* JADX INFO: compiled from: DefaultDataSource.java */
    public static final class a implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f37530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k.a f37531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private m0 f37532c;

        public a(Context context) {
            this(context, new t.b());
        }

        @Override // z3.k.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createDataSource() {
            s sVar = new s(this.f37530a, this.f37531b.createDataSource());
            m0 m0Var = this.f37532c;
            if (m0Var != null) {
                sVar.b(m0Var);
            }
            return sVar;
        }

        public a(Context context, k.a aVar) {
            this.f37530a = context.getApplicationContext();
            this.f37531b = aVar;
        }
    }

    public s(Context context, k kVar) {
        this.f37519a = context.getApplicationContext();
        this.f37521c = (k) a4.a.e(kVar);
    }

    private void c(k kVar) {
        for (int i10 = 0; i10 < this.f37520b.size(); i10++) {
            kVar.b(this.f37520b.get(i10));
        }
    }

    private k d() {
        if (this.f37523e == null) {
            c cVar = new c(this.f37519a);
            this.f37523e = cVar;
            c(cVar);
        }
        return this.f37523e;
    }

    private k e() {
        if (this.f37524f == null) {
            g gVar = new g(this.f37519a);
            this.f37524f = gVar;
            c(gVar);
        }
        return this.f37524f;
    }

    private k f() {
        if (this.f37527i == null) {
            i iVar = new i();
            this.f37527i = iVar;
            c(iVar);
        }
        return this.f37527i;
    }

    private k g() {
        if (this.f37522d == null) {
            x xVar = new x();
            this.f37522d = xVar;
            c(xVar);
        }
        return this.f37522d;
    }

    private k h() {
        if (this.f37528j == null) {
            h0 h0Var = new h0(this.f37519a);
            this.f37528j = h0Var;
            c(h0Var);
        }
        return this.f37528j;
    }

    private k i() {
        if (this.f37525g == null) {
            try {
                k kVar = (k) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f37525g = kVar;
                c(kVar);
            } catch (ClassNotFoundException unused) {
                a4.t.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e10) {
                throw new RuntimeException("Error instantiating RTMP extension", e10);
            }
            if (this.f37525g == null) {
                this.f37525g = this.f37521c;
            }
        }
        return this.f37525g;
    }

    private k j() {
        if (this.f37526h == null) {
            n0 n0Var = new n0();
            this.f37526h = n0Var;
            c(n0Var);
        }
        return this.f37526h;
    }

    private void k(@Nullable k kVar, m0 m0Var) {
        if (kVar != null) {
            kVar.b(m0Var);
        }
    }

    @Override // z3.k
    public long a(o oVar) throws IOException {
        a4.a.g(this.f37529k == null);
        String scheme = oVar.f37463a.getScheme();
        if (o0.q0(oVar.f37463a)) {
            String path = oVar.f37463a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f37529k = g();
            } else {
                this.f37529k = d();
            }
        } else if ("asset".equals(scheme)) {
            this.f37529k = d();
        } else if ("content".equals(scheme)) {
            this.f37529k = e();
        } else if ("rtmp".equals(scheme)) {
            this.f37529k = i();
        } else if ("udp".equals(scheme)) {
            this.f37529k = j();
        } else if ("data".equals(scheme)) {
            this.f37529k = f();
        } else if (RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
            this.f37529k = h();
        } else {
            this.f37529k = this.f37521c;
        }
        return this.f37529k.a(oVar);
    }

    @Override // z3.k
    public void b(m0 m0Var) {
        a4.a.e(m0Var);
        this.f37521c.b(m0Var);
        this.f37520b.add(m0Var);
        k(this.f37522d, m0Var);
        k(this.f37523e, m0Var);
        k(this.f37524f, m0Var);
        k(this.f37525g, m0Var);
        k(this.f37526h, m0Var);
        k(this.f37527i, m0Var);
        k(this.f37528j, m0Var);
    }

    @Override // z3.k
    public void close() throws IOException {
        k kVar = this.f37529k;
        if (kVar != null) {
            try {
                kVar.close();
            } finally {
                this.f37529k = null;
            }
        }
    }

    @Override // z3.k
    public Map<String, List<String>> getResponseHeaders() {
        k kVar = this.f37529k;
        return kVar == null ? Collections.emptyMap() : kVar.getResponseHeaders();
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        k kVar = this.f37529k;
        if (kVar == null) {
            return null;
        }
        return kVar.getUri();
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return ((k) a4.a.e(this.f37529k)).read(bArr, i10, i11);
    }
}
