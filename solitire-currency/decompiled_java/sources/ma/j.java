package ma;

import androidx.compose.animation.core.AnimationConstants;
import com.ironsource.nb;
import ga.b0;
import ga.c0;
import ga.d0;
import ga.f0;
import ga.v;
import ga.w;
import ga.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f31496b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final z f31497a;

    /* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public j(@NotNull z client) {
        t.i(client, "client");
        this.f31497a = client;
    }

    private final b0 a(d0 d0Var, String str) {
        String strJ;
        v vVarQ;
        if (!this.f31497a.s() || (strJ = d0.J(d0Var, "Location", null, 2, null)) == null || (vVarQ = d0Var.I0().k().q(strJ)) == null) {
            return null;
        }
        if (!t.d(vVarQ.r(), d0Var.I0().k().r()) && !this.f31497a.t()) {
            return null;
        }
        b0.a aVarI = d0Var.I0().i();
        if (f.b(str)) {
            int iQ = d0Var.q();
            f fVar = f.f31482a;
            boolean z10 = fVar.d(str) || iQ == 308 || iQ == 307;
            if (!fVar.c(str) || iQ == 308 || iQ == 307) {
                aVarI.i(str, z10 ? d0Var.I0().a() : null);
            } else {
                aVarI.i("GET", null);
            }
            if (!z10) {
                aVarI.k("Transfer-Encoding");
                aVarI.k("Content-Length");
                aVarI.k(nb.K);
            }
        }
        if (!ha.d.j(d0Var.I0().k(), vVarQ)) {
            aVarI.k("Authorization");
        }
        return aVarI.r(vVarQ).b();
    }

    private final b0 b(d0 d0Var, la.c cVar) throws IOException {
        la.f fVarH;
        f0 f0VarZ = (cVar == null || (fVarH = cVar.h()) == null) ? null : fVarH.z();
        int iQ = d0Var.q();
        String strH = d0Var.I0().h();
        if (iQ != 307 && iQ != 308) {
            if (iQ == 401) {
                return this.f31497a.f().a(f0VarZ, d0Var);
            }
            if (iQ == 421) {
                c0 c0VarA = d0Var.I0().a();
                if ((c0VarA != null && c0VarA.isOneShot()) || cVar == null || !cVar.k()) {
                    return null;
                }
                cVar.h().x();
                return d0Var.I0();
            }
            if (iQ == 503) {
                d0 d0VarH0 = d0Var.h0();
                if ((d0VarH0 == null || d0VarH0.q() != 503) && f(d0Var, Integer.MAX_VALUE) == 0) {
                    return d0Var.I0();
                }
                return null;
            }
            if (iQ == 407) {
                t.f(f0VarZ);
                if (f0VarZ.b().type() == Proxy.Type.HTTP) {
                    return this.f31497a.D().a(f0VarZ, d0Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iQ == 408) {
                if (!this.f31497a.G()) {
                    return null;
                }
                c0 c0VarA2 = d0Var.I0().a();
                if (c0VarA2 != null && c0VarA2.isOneShot()) {
                    return null;
                }
                d0 d0VarH02 = d0Var.h0();
                if ((d0VarH02 == null || d0VarH02.q() != 408) && f(d0Var, 0) <= 0) {
                    return d0Var.I0();
                }
                return null;
            }
            switch (iQ) {
                case AnimationConstants.DefaultDurationMillis /* 300 */:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return a(d0Var, strH);
    }

    private final boolean c(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean d(IOException iOException, la.e eVar, b0 b0Var, boolean z10) {
        if (this.f31497a.G()) {
            return !(z10 && e(iOException, b0Var)) && c(iOException, z10) && eVar.x();
        }
        return false;
    }

    private final boolean e(IOException iOException, b0 b0Var) {
        c0 c0VarA = b0Var.a();
        return (c0VarA != null && c0VarA.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int f(d0 d0Var, int i10) {
        String strJ = d0.J(d0Var, "Retry-After", null, 2, null);
        if (strJ == null) {
            return i10;
        }
        if (!new p9.f("\\d+").a(strJ)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strJ);
        t.h(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
    
        r7 = r0;
        r0 = r1.p();
        r6 = b(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if (r6 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004b, code lost:
    
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        if (r0.l() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        r1.z();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        r1.j(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        r0 = r6.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        if (r0.isOneShot() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        r1.j(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        r0 = r7.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        ha.d.m(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        if (r8 > 20) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
    
        throw new java.net.ProtocolException(kotlin.jvm.internal.t.r("Too many follow-up requests: ", java.lang.Integer.valueOf(r8)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        if (r7 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        r0 = r0.W().p(r7.W().b(null).c()).c();
     */
    @Override // ga.w
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ga.d0 intercept(@org.jetbrains.annotations.NotNull ga.w.a r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.j.intercept(ga.w$a):ga.d0");
    }
}
