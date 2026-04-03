package ua;

import com.unity3d.services.UnityAdsConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.q0;

/* JADX INFO: compiled from: ZipFileSystem.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c1 extends j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f34747i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final q0 f34748j = q0.a.e(q0.f34806b, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, false, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final q0 f34749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final j f34750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Map<q0, va.d> f34751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f34752h;

    /* JADX INFO: compiled from: ZipFileSystem.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public c1(@NotNull q0 zipPath, @NotNull j fileSystem, @NotNull Map<q0, va.d> entries, @Nullable String str) {
        kotlin.jvm.internal.t.i(zipPath, "zipPath");
        kotlin.jvm.internal.t.i(fileSystem, "fileSystem");
        kotlin.jvm.internal.t.i(entries, "entries");
        this.f34749e = zipPath;
        this.f34750f = fileSystem;
        this.f34751g = entries;
        this.f34752h = str;
    }

    private final q0 r(q0 q0Var) {
        return f34748j.k(q0Var, true);
    }

    private final List<q0> s(q0 q0Var, boolean z10) throws IOException {
        va.d dVar = this.f34751g.get(r(q0Var));
        if (dVar != null) {
            return kotlin.collections.d0.P0(dVar.b());
        }
        if (!z10) {
            return null;
        }
        throw new IOException("not a directory: " + q0Var);
    }

    @Override // ua.j
    @NotNull
    public x0 b(@NotNull q0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // ua.j
    public void c(@NotNull q0 source, @NotNull q0 target) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        kotlin.jvm.internal.t.i(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // ua.j
    public void g(@NotNull q0 dir, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // ua.j
    public void i(@NotNull q0 path, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // ua.j
    @NotNull
    public List<q0> k(@NotNull q0 dir) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        List<q0> listS = s(dir, true);
        kotlin.jvm.internal.t.f(listS);
        return listS;
    }

    @Override // ua.j
    @Nullable
    public i m(@NotNull q0 path) throws Throwable {
        e eVarD;
        kotlin.jvm.internal.t.i(path, "path");
        va.d dVar = this.f34751g.get(r(path));
        Throwable th = null;
        if (dVar == null) {
            return null;
        }
        i iVar = new i(!dVar.h(), dVar.h(), null, dVar.h() ? null : Long.valueOf(dVar.g()), null, dVar.e(), null, null, 128, null);
        if (dVar.f() == -1) {
            return iVar;
        }
        h hVarN = this.f34750f.n(this.f34749e);
        try {
            eVarD = k0.d(hVarN.J(dVar.f()));
        } catch (Throwable th2) {
            th = th2;
            eVarD = null;
        }
        if (hVarN != null) {
            try {
                hVarN.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    v8.f.a(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.t.f(eVarD);
        return va.e.h(eVarD, iVar);
    }

    @Override // ua.j
    @NotNull
    public h n(@NotNull q0 file) {
        kotlin.jvm.internal.t.i(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // ua.j
    @NotNull
    public x0 p(@NotNull q0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // ua.j
    @NotNull
    public z0 q(@NotNull q0 file) throws Throwable {
        e eVarD;
        kotlin.jvm.internal.t.i(file, "file");
        va.d dVar = this.f34751g.get(r(file));
        if (dVar == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        h hVarN = this.f34750f.n(this.f34749e);
        Throwable th = null;
        try {
            eVarD = k0.d(hVarN.J(dVar.f()));
        } catch (Throwable th2) {
            eVarD = null;
            th = th2;
        }
        if (hVarN != null) {
            try {
                hVarN.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    v8.f.a(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.t.f(eVarD);
        va.e.k(eVarD);
        return dVar.d() == 0 ? new va.b(eVarD, dVar.g(), true) : new va.b(new q(new va.b(eVarD, dVar.c(), true), new Inflater(true)), dVar.g(), false);
    }
}
