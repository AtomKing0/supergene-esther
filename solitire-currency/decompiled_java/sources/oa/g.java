package oa;

import ga.a0;
import ga.b0;
import ga.d0;
import ga.u;
import ga.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.a1;
import ua.x0;
import ua.z0;

/* JADX INFO: compiled from: Http2ExchangeCodec.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements ma.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f32235g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final List<String> f32236h = ha.d.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final List<String> f32237i = ha.d.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final la.f f32238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ma.g f32239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final f f32240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private volatile i f32241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final a0 f32242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f32243f;

    /* JADX INFO: compiled from: Http2ExchangeCodec.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final List<c> a(@NotNull b0 request) {
            t.i(request, "request");
            u uVarE = request.e();
            ArrayList arrayList = new ArrayList(uVarE.size() + 4);
            arrayList.add(new c(c.f32106g, request.h()));
            arrayList.add(new c(c.f32107h, ma.i.f31495a.c(request.k())));
            String strD = request.d("Host");
            if (strD != null) {
                arrayList.add(new c(c.f32109j, strD));
            }
            arrayList.add(new c(c.f32108i, request.k().r()));
            int size = uVarE.size();
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                String strE = uVarE.e(i10);
                Locale US = Locale.US;
                t.h(US, "US");
                String lowerCase = strE.toLowerCase(US);
                t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!g.f32236h.contains(lowerCase) || (t.d(lowerCase, "te") && t.d(uVarE.i(i10), "trailers"))) {
                    arrayList.add(new c(lowerCase, uVarE.i(i10)));
                }
                i10 = i11;
            }
            return arrayList;
        }

        @NotNull
        public final d0.a b(@NotNull u headerBlock, @NotNull a0 protocol) throws IOException {
            t.i(headerBlock, "headerBlock");
            t.i(protocol, "protocol");
            u.a aVar = new u.a();
            int size = headerBlock.size();
            ma.k kVarA = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                String strE = headerBlock.e(i10);
                String strI = headerBlock.i(i10);
                if (t.d(strE, ":status")) {
                    kVarA = ma.k.f31498d.a(t.r("HTTP/1.1 ", strI));
                } else if (!g.f32237i.contains(strE)) {
                    aVar.d(strE, strI);
                }
                i10 = i11;
            }
            if (kVarA != null) {
                return new d0.a().q(protocol).g(kVarA.f31500b).n(kVarA.f31501c).l(aVar.f());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public g(@NotNull z client, @NotNull la.f connection, @NotNull ma.g chain, @NotNull f http2Connection) {
        t.i(client, "client");
        t.i(connection, "connection");
        t.i(chain, "chain");
        t.i(http2Connection, "http2Connection");
        this.f32238a = connection;
        this.f32239b = chain;
        this.f32240c = http2Connection;
        List<a0> listB = client.B();
        a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
        this.f32242e = listB.contains(a0Var) ? a0Var : a0.HTTP_2;
    }

    @Override // ma.d
    public void a() throws IOException {
        i iVar = this.f32241d;
        t.f(iVar);
        iVar.n().close();
    }

    @Override // ma.d
    @NotNull
    public la.f b() {
        return this.f32238a;
    }

    @Override // ma.d
    public long c(@NotNull d0 response) {
        t.i(response, "response");
        if (ma.e.b(response)) {
            return ha.d.v(response);
        }
        return 0L;
    }

    @Override // ma.d
    public void cancel() {
        this.f32243f = true;
        i iVar = this.f32241d;
        if (iVar == null) {
            return;
        }
        iVar.f(b.CANCEL);
    }

    @Override // ma.d
    public void d(@NotNull b0 request) throws IOException {
        t.i(request, "request");
        if (this.f32241d != null) {
            return;
        }
        this.f32241d = this.f32240c.a1(f32235g.a(request), request.a() != null);
        if (this.f32243f) {
            i iVar = this.f32241d;
            t.f(iVar);
            iVar.f(b.CANCEL);
            throw new IOException("Canceled");
        }
        i iVar2 = this.f32241d;
        t.f(iVar2);
        a1 a1VarV = iVar2.v();
        long jH = this.f32239b.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a1VarV.g(jH, timeUnit);
        i iVar3 = this.f32241d;
        t.f(iVar3);
        iVar3.G().g(this.f32239b.j(), timeUnit);
    }

    @Override // ma.d
    @NotNull
    public x0 e(@NotNull b0 request, long j10) {
        t.i(request, "request");
        i iVar = this.f32241d;
        t.f(iVar);
        return iVar.n();
    }

    @Override // ma.d
    @Nullable
    public d0.a f(boolean z10) throws IOException {
        i iVar = this.f32241d;
        t.f(iVar);
        d0.a aVarB = f32235g.b(iVar.E(), this.f32242e);
        if (z10 && aVarB.h() == 100) {
            return null;
        }
        return aVarB;
    }

    @Override // ma.d
    public void g() throws IOException {
        this.f32240c.flush();
    }

    @Override // ma.d
    @NotNull
    public z0 h(@NotNull d0 response) {
        t.i(response, "response");
        i iVar = this.f32241d;
        t.f(iVar);
        return iVar.p();
    }
}
