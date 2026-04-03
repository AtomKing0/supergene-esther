package va;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.collections.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.q0;

/* JADX INFO: compiled from: -FileSystem.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {
    public static final void a(@NotNull ua.j jVar, @NotNull q0 dir, boolean z10) throws IOException {
        t.i(jVar, "<this>");
        t.i(dir, "dir");
        k kVar = new k();
        for (q0 q0VarH = dir; q0VarH != null && !jVar.j(q0VarH); q0VarH = q0VarH.h()) {
            kVar.addFirst(q0VarH);
        }
        if (z10 && kVar.isEmpty()) {
            throw new IOException(dir + " already exist.");
        }
        Iterator<E> it = kVar.iterator();
        while (it.hasNext()) {
            jVar.f((q0) it.next());
        }
    }

    public static final boolean b(@NotNull ua.j jVar, @NotNull q0 path) throws IOException {
        t.i(jVar, "<this>");
        t.i(path, "path");
        return jVar.m(path) != null;
    }

    @NotNull
    public static final ua.i c(@NotNull ua.j jVar, @NotNull q0 path) throws IOException {
        t.i(jVar, "<this>");
        t.i(path, "path");
        ua.i iVarM = jVar.m(path);
        if (iVarM != null) {
            return iVarM;
        }
        throw new FileNotFoundException("no such file: " + path);
    }
}
