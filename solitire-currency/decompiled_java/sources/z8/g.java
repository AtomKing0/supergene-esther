package z8;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.e;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface g {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public static final class a {

        /* JADX INFO: renamed from: z8.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        static final class C0766a extends v implements p<g, b, g> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0766a f37607g = new C0766a();

            C0766a() {
                super(2);
            }

            @Override // h9.p
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g mo4invoke(@NotNull g acc, @NotNull b element) {
                z8.c cVar;
                t.i(acc, "acc");
                t.i(element, "element");
                g gVarMinusKey = acc.minusKey(element.getKey());
                h hVar = h.f37608a;
                if (gVarMinusKey == hVar) {
                    return element;
                }
                e.b bVar = e.R7;
                e eVar = (e) gVarMinusKey.get(bVar);
                if (eVar == null) {
                    cVar = new z8.c(gVarMinusKey, element);
                } else {
                    g gVarMinusKey2 = gVarMinusKey.minusKey(bVar);
                    if (gVarMinusKey2 == hVar) {
                        return new z8.c(element, eVar);
                    }
                    cVar = new z8.c(new z8.c(gVarMinusKey2, element), eVar);
                }
                return cVar;
            }
        }

        @NotNull
        public static g a(@NotNull g gVar, @NotNull g context) {
            t.i(context, "context");
            return context == h.f37608a ? gVar : (g) context.fold(gVar, C0766a.f37607g);
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface b extends g {

        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class a {
            public static <R> R a(@NotNull b bVar, R r10, @NotNull p<? super R, ? super b, ? extends R> operation) {
                t.i(operation, "operation");
                return operation.mo4invoke(r10, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            public static <E extends b> E b(@NotNull b bVar, @NotNull c<E> key) {
                t.i(key, "key");
                if (!t.d(bVar.getKey(), key)) {
                    return null;
                }
                t.g(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            @NotNull
            public static g c(@NotNull b bVar, @NotNull c<?> key) {
                t.i(key, "key");
                return t.d(bVar.getKey(), key) ? h.f37608a : bVar;
            }

            @NotNull
            public static g d(@NotNull b bVar, @NotNull g context) {
                t.i(context, "context");
                return a.a(bVar, context);
            }
        }

        @Override // z8.g
        <R> R fold(R r10, @NotNull p<? super R, ? super b, ? extends R> pVar);

        @Override // z8.g
        @Nullable
        <E extends b> E get(@NotNull c<E> cVar);

        @NotNull
        c<?> getKey();

        @Override // z8.g
        @NotNull
        g minusKey(@NotNull c<?> cVar);
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface c<E extends b> {
    }

    <R> R fold(R r10, @NotNull p<? super R, ? super b, ? extends R> pVar);

    @Nullable
    <E extends b> E get(@NotNull c<E> cVar);

    @NotNull
    g minusKey(@NotNull c<?> cVar);

    @NotNull
    g plus(@NotNull g gVar);
}
