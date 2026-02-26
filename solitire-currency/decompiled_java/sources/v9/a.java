package v9;

import a9.c;
import h9.l;
import h9.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.k;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Cancellable.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    private static final void a(d<?> dVar, Throwable th) throws Throwable {
        t.a aVar = t.f35208b;
        dVar.resumeWith(t.b(u.a(th)));
        throw th;
    }

    public static final <R, T> void b(@NotNull p<? super R, ? super d<? super T>, ? extends Object> pVar, R r10, @NotNull d<? super T> dVar, @Nullable l<? super Throwable, k0> lVar) throws Throwable {
        try {
            d dVarC = c.c(c.a(pVar, r10, dVar));
            t.a aVar = t.f35208b;
            k.b(dVarC, t.b(k0.f35197a), lVar);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static final void c(@NotNull d<? super k0> dVar, @NotNull d<?> dVar2) throws Throwable {
        try {
            d dVarC = c.c(dVar);
            t.a aVar = t.f35208b;
            k.c(dVarC, t.b(k0.f35197a), null, 2, null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, d dVar, l lVar, int i10, Object obj2) throws Throwable {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        b(pVar, obj, dVar, lVar);
    }
}
