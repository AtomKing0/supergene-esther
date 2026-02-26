package ua;

import java.io.IOException;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.q0;

/* JADX INFO: compiled from: FileSystem.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f34779a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final j f34780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final q0 f34781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final j f34782d;

    /* JADX INFO: compiled from: FileSystem.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    static {
        j tVar;
        try {
            Class.forName("java.nio.file.Files");
            tVar = new j0();
        } catch (ClassNotFoundException unused) {
            tVar = new t();
        }
        f34780b = tVar;
        q0.a aVar = q0.f34806b;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.t.h(property, "getProperty(\"java.io.tmpdir\")");
        f34781c = q0.a.e(aVar, property, false, 1, null);
        ClassLoader classLoader = va.c.class.getClassLoader();
        kotlin.jvm.internal.t.h(classLoader, "ResourceFileSystem::class.java.classLoader");
        f34782d = new va.c(classLoader, false);
    }

    @NotNull
    public final x0 a(@NotNull q0 file) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        return b(file, false);
    }

    @NotNull
    public abstract x0 b(@NotNull q0 q0Var, boolean z10) throws IOException;

    public abstract void c(@NotNull q0 q0Var, @NotNull q0 q0Var2) throws IOException;

    public final void d(@NotNull q0 dir) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        e(dir, false);
    }

    public final void e(@NotNull q0 dir, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        va.h.a(this, dir, z10);
    }

    public final void f(@NotNull q0 dir) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        g(dir, false);
    }

    public abstract void g(@NotNull q0 q0Var, boolean z10) throws IOException;

    public final void h(@NotNull q0 path) throws IOException {
        kotlin.jvm.internal.t.i(path, "path");
        i(path, false);
    }

    public abstract void i(@NotNull q0 q0Var, boolean z10) throws IOException;

    public final boolean j(@NotNull q0 path) throws IOException {
        kotlin.jvm.internal.t.i(path, "path");
        return va.h.b(this, path);
    }

    @NotNull
    public abstract List<q0> k(@NotNull q0 q0Var) throws IOException;

    @NotNull
    public final i l(@NotNull q0 path) throws IOException {
        kotlin.jvm.internal.t.i(path, "path");
        return va.h.c(this, path);
    }

    @Nullable
    public abstract i m(@NotNull q0 q0Var) throws IOException;

    @NotNull
    public abstract h n(@NotNull q0 q0Var) throws IOException;

    @NotNull
    public final x0 o(@NotNull q0 file) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        return p(file, false);
    }

    @NotNull
    public abstract x0 p(@NotNull q0 q0Var, boolean z10) throws IOException;

    @NotNull
    public abstract z0 q(@NotNull q0 q0Var) throws IOException;
}
