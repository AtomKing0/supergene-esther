package ma;

import ga.b0;
import ga.c0;
import ga.d0;
import ga.e0;
import ga.w;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;
import ua.k0;

/* JADX INFO: compiled from: CallServerInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f31476a;

    public b(boolean z10) {
        this.f31476a = z10;
    }

    @Override // ga.w
    @NotNull
    public d0 intercept(@NotNull w.a chain) throws IOException {
        boolean z10;
        d0.a aVarP;
        t.i(chain, "chain");
        g gVar = (g) chain;
        la.c cVarG = gVar.g();
        t.f(cVarG);
        b0 b0VarI = gVar.i();
        c0 c0VarA = b0VarI.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVarG.t(b0VarI);
        if (!f.b(b0VarI.h()) || c0VarA == null) {
            cVarG.n();
            z10 = true;
            aVarP = null;
        } else {
            if (q.x("100-continue", b0VarI.d("Expect"), true)) {
                cVarG.f();
                aVarP = cVarG.p(true);
                cVarG.r();
                z10 = false;
            } else {
                z10 = true;
                aVarP = null;
            }
            if (aVarP != null) {
                cVarG.n();
                if (!cVarG.h().v()) {
                    cVarG.m();
                }
            } else if (c0VarA.isDuplex()) {
                cVarG.f();
                c0VarA.writeTo(k0.c(cVarG.c(b0VarI, true)));
            } else {
                ua.d dVarC = k0.c(cVarG.c(b0VarI, false));
                c0VarA.writeTo(dVarC);
                dVarC.close();
            }
        }
        if (c0VarA == null || !c0VarA.isDuplex()) {
            cVarG.e();
        }
        if (aVarP == null) {
            aVarP = cVarG.p(false);
            t.f(aVarP);
            if (z10) {
                cVarG.r();
                z10 = false;
            }
        }
        d0 d0VarC = aVarP.s(b0VarI).j(cVarG.h().r()).t(jCurrentTimeMillis).r(System.currentTimeMillis()).c();
        int iQ = d0VarC.q();
        if (iQ == 100) {
            d0.a aVarP2 = cVarG.p(false);
            t.f(aVarP2);
            if (z10) {
                cVarG.r();
            }
            d0VarC = aVarP2.s(b0VarI).j(cVarG.h().r()).t(jCurrentTimeMillis).r(System.currentTimeMillis()).c();
            iQ = d0VarC.q();
        }
        cVarG.q(d0VarC);
        d0 d0VarC2 = (this.f31476a && iQ == 101) ? d0VarC.W().b(ha.d.f26510c).c() : d0VarC.W().b(cVarG.o(d0VarC)).c();
        if (q.x("close", d0VarC2.I0().d("Connection"), true) || q.x("close", d0.J(d0VarC2, "Connection", null, 2, null), true)) {
            cVarG.m();
        }
        if (iQ == 204 || iQ == 205) {
            e0 e0VarA = d0VarC2.a();
            if ((e0VarA == null ? -1L : e0VarA.contentLength()) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(iQ);
                sb.append(" had non-zero Content-Length: ");
                e0 e0VarA2 = d0VarC2.a();
                sb.append(e0VarA2 != null ? Long.valueOf(e0VarA2.contentLength()) : null);
                throw new ProtocolException(sb.toString());
            }
        }
        return d0VarC2;
    }
}
