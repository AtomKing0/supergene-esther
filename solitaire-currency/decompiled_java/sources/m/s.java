package m;

import java.io.File;
import kotlin.jvm.internal.t;
import m.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.k0;
import ua.q0;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final File f31129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final p.a f31130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f31131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private ua.e f31132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private q0 f31133e;

    public s(@NotNull ua.e eVar, @NotNull File file, @Nullable p.a aVar) {
        super(null);
        this.f31129a = file;
        this.f31130b = aVar;
        this.f31132d = eVar;
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("cacheDirectory must be a directory.".toString());
        }
    }

    private final void i() {
        if (!(!this.f31131c)) {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // m.p
    @Nullable
    public p.a a() {
        return this.f31130b;
    }

    @Override // m.p
    @NotNull
    public synchronized ua.e c() {
        i();
        ua.e eVar = this.f31132d;
        if (eVar != null) {
            return eVar;
        }
        ua.j jVarN = n();
        q0 q0Var = this.f31133e;
        t.f(q0Var);
        ua.e eVarD = k0.d(jVarN.q(q0Var));
        this.f31132d = eVarD;
        return eVarD;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f31131c = true;
        ua.e eVar = this.f31132d;
        if (eVar != null) {
            a0.j.d(eVar);
        }
        q0 q0Var = this.f31133e;
        if (q0Var != null) {
            n().h(q0Var);
        }
    }

    @NotNull
    public ua.j n() {
        return ua.j.f34780b;
    }
}
