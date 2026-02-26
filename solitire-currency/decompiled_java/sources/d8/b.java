package d8;

import h9.l;
import io.ktor.util.internal.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.g1;
import org.jetbrains.annotations.NotNull;
import v8.f;
import v8.k0;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final i8.a<d8.a<?>, io.ktor.util.internal.a> f24530a = new i8.a<>();

    /* JADX INFO: compiled from: Events.kt */
    private static final class a extends c implements g1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final l<?, k0> f24531d;

        @Override // kotlinx.coroutines.g1
        public void dispose() {
            i();
        }

        @NotNull
        public final l<?, k0> k() {
            return this.f24531d;
        }
    }

    public final <T> void a(@NotNull d8.a<T> definition, T t10) {
        k0 k0Var;
        t.i(definition, "definition");
        io.ktor.util.internal.a aVarA = this.f24530a.a(definition);
        Throwable th = null;
        if (aVarA != null) {
            Object objE = aVarA.e();
            t.g(objE, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
            Throwable th2 = null;
            for (c cVarF = (c) objE; !t.d(cVarF, aVarA); cVarF = cVarF.f()) {
                if (cVarF instanceof a) {
                    try {
                        l<?, k0> lVarK = ((a) cVarF).k();
                        t.g(lVarK, "null cannot be cast to non-null type kotlin.Function1<T of io.ktor.events.Events.raise$lambda$2, kotlin.Unit>{ io.ktor.events.EventsKt.EventHandler<T of io.ktor.events.Events.raise$lambda$2> }");
                        ((l) t0.f(lVarK, 1)).invoke(t10);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            f.a(th2, th3);
                            k0Var = k0.f35197a;
                        } else {
                            k0Var = null;
                        }
                        if (k0Var == null) {
                            th2 = th3;
                        }
                    }
                }
            }
            th = th2;
        }
        if (th != null) {
            throw th;
        }
    }
}
