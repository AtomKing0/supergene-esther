package la;

import ga.f0;
import ga.r;
import ga.v;
import ga.z;
import java.io.IOException;
import kotlin.jvm.internal.t;
import la.j;
import oa.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExchangeFinder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g f31003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ga.a f31004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final e f31005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final r f31006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private j.b f31007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private j f31008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f31010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private f0 f31012j;

    public d(@NotNull g connectionPool, @NotNull ga.a address, @NotNull e call, @NotNull r eventListener) {
        t.i(connectionPool, "connectionPool");
        t.i(address, "address");
        t.i(call, "call");
        t.i(eventListener, "eventListener");
        this.f31003a = connectionPool;
        this.f31004b = address;
        this.f31005c = call;
        this.f31006d = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final la.f b(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: la.d.b(int, int, int, int, boolean):la.f");
    }

    private final f c(int i10, int i11, int i12, int i13, boolean z10, boolean z11) throws IOException {
        while (true) {
            f fVarB = b(i10, i11, i12, i13, z10);
            if (fVarB.u(z11)) {
                return fVarB;
            }
            fVarB.y();
            if (this.f31012j == null) {
                j.b bVar = this.f31007e;
                if (bVar == null ? true : bVar.b()) {
                    continue;
                } else {
                    j jVar = this.f31008f;
                    if (!(jVar != null ? jVar.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final f0 f() {
        f fVarL;
        if (this.f31009g > 1 || this.f31010h > 1 || this.f31011i > 0 || (fVarL = this.f31005c.l()) == null) {
            return null;
        }
        synchronized (fVarL) {
            if (fVarL.q() != 0) {
                return null;
            }
            if (ha.d.j(fVarL.z().a().l(), d().l())) {
                return fVarL.z();
            }
            return null;
        }
    }

    @NotNull
    public final ma.d a(@NotNull z client, @NotNull ma.g chain) {
        t.i(client, "client");
        t.i(chain, "chain");
        try {
            return c(chain.f(), chain.h(), chain.j(), client.A(), client.G(), !t.d(chain.i().h(), "GET")).w(client, chain);
        } catch (IOException e10) {
            h(e10);
            throw new i(e10);
        } catch (i e11) {
            h(e11.c());
            throw e11;
        }
    }

    @NotNull
    public final ga.a d() {
        return this.f31004b;
    }

    public final boolean e() {
        j jVar;
        boolean z10 = false;
        if (this.f31009g == 0 && this.f31010h == 0 && this.f31011i == 0) {
            return false;
        }
        if (this.f31012j != null) {
            return true;
        }
        f0 f0VarF = f();
        if (f0VarF != null) {
            this.f31012j = f0VarF;
            return true;
        }
        j.b bVar = this.f31007e;
        if (bVar != null && bVar.b()) {
            z10 = true;
        }
        if (z10 || (jVar = this.f31008f) == null) {
            return true;
        }
        return jVar.a();
    }

    public final boolean g(@NotNull v url) {
        t.i(url, "url");
        v vVarL = this.f31004b.l();
        return url.n() == vVarL.n() && t.d(url.i(), vVarL.i());
    }

    public final void h(@NotNull IOException e10) {
        t.i(e10, "e");
        this.f31012j = null;
        if ((e10 instanceof n) && ((n) e10).f32305a == oa.b.REFUSED_STREAM) {
            this.f31009g++;
        } else if (e10 instanceof oa.a) {
            this.f31010h++;
        } else {
            this.f31011i++;
        }
    }
}
