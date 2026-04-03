package ua;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.v8;
import io.sentry.protocol.TransactionInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ForwardingFileSystem.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class k extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final j f34783e;

    public k(@NotNull j delegate) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        this.f34783e = delegate;
    }

    @Override // ua.j
    @NotNull
    public x0 b(@NotNull q0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        return this.f34783e.b(r(file, "appendingSink", v8.h.f15781b), z10);
    }

    @Override // ua.j
    public void c(@NotNull q0 source, @NotNull q0 target) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        kotlin.jvm.internal.t.i(target, "target");
        this.f34783e.c(r(source, "atomicMove", TransactionInfo.JsonKeys.SOURCE), r(target, "atomicMove", TypedValues.AttributesType.S_TARGET));
    }

    @Override // ua.j
    public void g(@NotNull q0 dir, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        this.f34783e.g(r(dir, "createDirectory", "dir"), z10);
    }

    @Override // ua.j
    public void i(@NotNull q0 path, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(path, "path");
        this.f34783e.i(r(path, "delete", "path"), z10);
    }

    @Override // ua.j
    @NotNull
    public List<q0> k(@NotNull q0 dir) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        List<q0> listK = this.f34783e.k(r(dir, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(s((q0) it.next(), "list"));
        }
        kotlin.collections.z.z(arrayList);
        return arrayList;
    }

    @Override // ua.j
    @Nullable
    public i m(@NotNull q0 path) throws IOException {
        kotlin.jvm.internal.t.i(path, "path");
        i iVarM = this.f34783e.m(r(path, "metadataOrNull", "path"));
        if (iVarM == null) {
            return null;
        }
        return iVarM.e() == null ? iVarM : iVarM.a((251 & 1) != 0 ? iVarM.f34771a : false, (251 & 2) != 0 ? iVarM.f34772b : false, (251 & 4) != 0 ? iVarM.f34773c : s(iVarM.e(), "metadataOrNull"), (251 & 8) != 0 ? iVarM.f34774d : null, (251 & 16) != 0 ? iVarM.f34775e : null, (251 & 32) != 0 ? iVarM.f34776f : null, (251 & 64) != 0 ? iVarM.f34777g : null, (251 & 128) != 0 ? iVarM.f34778h : null);
    }

    @Override // ua.j
    @NotNull
    public h n(@NotNull q0 file) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        return this.f34783e.n(r(file, "openReadOnly", v8.h.f15781b));
    }

    @Override // ua.j
    @NotNull
    public x0 p(@NotNull q0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        return this.f34783e.p(r(file, "sink", v8.h.f15781b), z10);
    }

    @Override // ua.j
    @NotNull
    public z0 q(@NotNull q0 file) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        return this.f34783e.q(r(file, TransactionInfo.JsonKeys.SOURCE, v8.h.f15781b));
    }

    @NotNull
    public q0 r(@NotNull q0 path, @NotNull String functionName, @NotNull String parameterName) {
        kotlin.jvm.internal.t.i(path, "path");
        kotlin.jvm.internal.t.i(functionName, "functionName");
        kotlin.jvm.internal.t.i(parameterName, "parameterName");
        return path;
    }

    @NotNull
    public q0 s(@NotNull q0 path, @NotNull String functionName) {
        kotlin.jvm.internal.t.i(path, "path");
        kotlin.jvm.internal.t.i(functionName, "functionName");
        return path;
    }

    @NotNull
    public String toString() {
        return kotlin.jvm.internal.o0.b(getClass()).getSimpleName() + '(' + this.f34783e + ')';
    }
}
