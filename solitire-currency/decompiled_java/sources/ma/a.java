package ma;

import com.ironsource.nb;
import ga.b0;
import ga.c0;
import ga.d0;
import ga.e0;
import ga.m;
import ga.n;
import ga.w;
import ga.x;
import java.io.IOException;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;
import ua.k0;
import ua.p;

/* JADX INFO: compiled from: BridgeInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final n f31475a;

    public a(@NotNull n cookieJar) {
        t.i(cookieJar, "cookieJar");
        this.f31475a = cookieJar;
    }

    private final String a(List<m> list) {
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                v.u();
            }
            m mVar = (m) obj;
            if (i10 > 0) {
                sb.append("; ");
            }
            sb.append(mVar.i());
            sb.append(nb.T);
            sb.append(mVar.n());
            i10 = i11;
        }
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // ga.w
    @NotNull
    public d0 intercept(@NotNull w.a chain) throws IOException {
        e0 e0VarA;
        t.i(chain, "chain");
        b0 b0VarA = chain.a();
        b0.a aVarI = b0VarA.i();
        c0 c0VarA = b0VarA.a();
        if (c0VarA != null) {
            x xVarContentType = c0VarA.contentType();
            if (xVarContentType != null) {
                aVarI.g(nb.K, xVarContentType.toString());
            }
            long jContentLength = c0VarA.contentLength();
            if (jContentLength != -1) {
                aVarI.g("Content-Length", String.valueOf(jContentLength));
                aVarI.k("Transfer-Encoding");
            } else {
                aVarI.g("Transfer-Encoding", "chunked");
                aVarI.k("Content-Length");
            }
        }
        boolean z10 = false;
        if (b0VarA.d("Host") == null) {
            aVarI.g("Host", ha.d.S(b0VarA.k(), false, 1, null));
        }
        if (b0VarA.d("Connection") == null) {
            aVarI.g("Connection", "Keep-Alive");
        }
        if (b0VarA.d("Accept-Encoding") == null && b0VarA.d("Range") == null) {
            aVarI.g("Accept-Encoding", "gzip");
            z10 = true;
        }
        List<m> listB = this.f31475a.b(b0VarA.k());
        if (!listB.isEmpty()) {
            aVarI.g("Cookie", a(listB));
        }
        if (b0VarA.d("User-Agent") == null) {
            aVarI.g("User-Agent", "okhttp/4.10.0");
        }
        d0 d0VarB = chain.b(aVarI.b());
        e.f(this.f31475a, b0VarA.k(), d0VarB.L());
        d0.a aVarS = d0VarB.W().s(b0VarA);
        if (z10 && q.x("gzip", d0.J(d0VarB, "Content-Encoding", null, 2, null), true) && e.b(d0VarB) && (e0VarA = d0VarB.a()) != null) {
            p pVar = new p(e0VarA.source());
            aVarS.l(d0VarB.L().f().i("Content-Encoding").i("Content-Length").f());
            aVarS.b(new h(d0.J(d0VarB, nb.K, null, 2, null), -1L, k0.d(pVar)));
        }
        return aVarS.c();
    }
}
