package z8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface e extends g.b {

    @NotNull
    public static final b R7 = b.f37606a;

    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class a {
        @Nullable
        public static <E extends g.b> E a(@NotNull e eVar, @NotNull g.c<E> key) {
            t.i(key, "key");
            if (!(key instanceof z8.b)) {
                if (e.R7 != key) {
                    return null;
                }
                t.g(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            z8.b bVar = (z8.b) key;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e10 = (E) bVar.b(eVar);
            if (e10 instanceof g.b) {
                return e10;
            }
            return null;
        }

        @NotNull
        public static g b(@NotNull e eVar, @NotNull g.c<?> key) {
            t.i(key, "key");
            if (!(key instanceof z8.b)) {
                return e.R7 == key ? h.f37608a : eVar;
            }
            z8.b bVar = (z8.b) key;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.f37608a;
        }
    }

    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class b implements g.c<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f37606a = new b();

        private b() {
        }
    }

    @NotNull
    <T> d<T> interceptContinuation(@NotNull d<? super T> dVar);

    void releaseInterceptedContinuation(@NotNull d<?> dVar);
}
