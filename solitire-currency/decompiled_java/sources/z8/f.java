package z8;

import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Continuation.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f {
    @NotNull
    public static final <R, T> d<k0> a(@NotNull p<? super R, ? super d<? super T>, ? extends Object> pVar, R r10, @NotNull d<? super T> completion) {
        t.i(pVar, "<this>");
        t.i(completion, "completion");
        return new i(a9.c.c(a9.c.a(pVar, r10, completion)), a9.d.e());
    }

    public static final <R, T> void b(@NotNull p<? super R, ? super d<? super T>, ? extends Object> pVar, R r10, @NotNull d<? super T> completion) {
        t.i(pVar, "<this>");
        t.i(completion, "completion");
        d dVarC = a9.c.c(a9.c.a(pVar, r10, completion));
        t.a aVar = v8.t.f35208b;
        dVarC.resumeWith(v8.t.b(k0.f35197a));
    }
}
