package o2;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.common.collect.i1;
import io.sentry.protocol.SentryStackFrame;
import java.util.Map;
import k2.w1;
import o2.h;
import z3.k;
import z3.t;

/* JADX INFO: compiled from: DefaultDrmSessionManagerProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f31906a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private w1.f f31907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private y f31908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private k.a f31909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f31910e;

    @RequiresApi(18)
    private y b(w1.f fVar) {
        k.a aVarB = this.f31909d;
        if (aVarB == null) {
            aVarB = new t.b().b(this.f31910e);
        }
        Uri uri = fVar.f29551c;
        l0 l0Var = new l0(uri == null ? null : uri.toString(), fVar.f29556h, aVarB);
        i1<Map.Entry<String, String>> it = fVar.f29553e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            l0Var.e(next.getKey(), next.getValue());
        }
        h hVarA = new h.b().e(fVar.f29549a, k0.f31902d).b(fVar.f29554f).c(fVar.f29555g).d(g5.e.k(fVar.f29558j)).a(l0Var);
        hVarA.E(0, fVar.c());
        return hVarA;
    }

    @Override // o2.b0
    public y a(w1 w1Var) {
        y yVar;
        a4.a.e(w1Var.f29517b);
        w1.f fVar = w1Var.f29517b.f29582c;
        if (fVar == null || a4.o0.f214a < 18) {
            return y.f31949a;
        }
        synchronized (this.f31906a) {
            if (!a4.o0.c(fVar, this.f31907b)) {
                this.f31907b = fVar;
                this.f31908c = b(fVar);
            }
            yVar = (y) a4.a.e(this.f31908c);
        }
        return yVar;
    }
}
