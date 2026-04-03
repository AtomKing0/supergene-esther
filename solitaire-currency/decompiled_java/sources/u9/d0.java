package u9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes5.dex */
public class d0<T> extends kotlinx.coroutines.a<T> implements kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final z8.d<T> f34650d;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(@NotNull z8.g gVar, @NotNull z8.d<? super T> dVar) {
        super(gVar, true, true);
        this.f34650d = dVar;
    }

    @Override // kotlinx.coroutines.j2
    protected void C(@Nullable Object obj) {
        k.c(a9.c.c(this.f34650d), kotlinx.coroutines.g0.a(obj, this.f34650d), null, 2, null);
    }

    @Override // kotlinx.coroutines.a
    protected void Q0(@Nullable Object obj) {
        z8.d<T> dVar = this.f34650d;
        dVar.resumeWith(kotlinx.coroutines.g0.a(obj, dVar));
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @Nullable
    public final kotlin.coroutines.jvm.internal.e getCallerFrame() {
        z8.d<T> dVar = this.f34650d;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlinx.coroutines.j2
    protected final boolean l0() {
        return true;
    }
}
