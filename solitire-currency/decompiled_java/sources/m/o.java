package m;

import java.io.Closeable;
import m.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.k0;
import ua.q0;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final q0 f31119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ua.j f31120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f31121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final Closeable f31122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final p.a f31123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f31124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private ua.e f31125g;

    public o(@NotNull q0 q0Var, @NotNull ua.j jVar, @Nullable String str, @Nullable Closeable closeable, @Nullable p.a aVar) {
        super(null);
        this.f31119a = q0Var;
        this.f31120b = jVar;
        this.f31121c = str;
        this.f31122d = closeable;
        this.f31123e = aVar;
    }

    private final void i() {
        if (!(!this.f31124f)) {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // m.p
    @Nullable
    public p.a a() {
        return this.f31123e;
    }

    @Override // m.p
    @NotNull
    public synchronized ua.e c() {
        i();
        ua.e eVar = this.f31125g;
        if (eVar != null) {
            return eVar;
        }
        ua.e eVarD = k0.d(q().q(this.f31119a));
        this.f31125g = eVarD;
        return eVarD;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f31124f = true;
        ua.e eVar = this.f31125g;
        if (eVar != null) {
            a0.j.d(eVar);
        }
        Closeable closeable = this.f31122d;
        if (closeable != null) {
            a0.j.d(closeable);
        }
    }

    @Nullable
    public final String n() {
        return this.f31121c;
    }

    @NotNull
    public ua.j q() {
        return this.f31120b;
    }
}
