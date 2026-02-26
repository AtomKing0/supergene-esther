package io.sentry.util;

import io.sentry.w0;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HintUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class m {

    /* JADX INFO: compiled from: HintUtils.java */
    @FunctionalInterface
    public interface a<T> {
        void accept(@NotNull T t10);
    }

    /* JADX INFO: compiled from: HintUtils.java */
    @FunctionalInterface
    public interface b {
        void a(@Nullable Object obj, @NotNull Class<?> cls);
    }

    /* JADX INFO: compiled from: HintUtils.java */
    @FunctionalInterface
    public interface c<T> {
        void accept(@Nullable T t10);
    }

    public static io.sentry.l0 e(Object obj) {
        io.sentry.l0 l0Var = new io.sentry.l0();
        t(l0Var, obj);
        return l0Var;
    }

    @Nullable
    public static io.sentry.hints.h f(@NotNull io.sentry.l0 l0Var) {
        return (io.sentry.hints.h) l0Var.d("sentry:eventDropReason", io.sentry.hints.h.class);
    }

    @Nullable
    public static Object g(@NotNull io.sentry.l0 l0Var) {
        return l0Var.c("sentry:typeCheckHint");
    }

    public static boolean h(@NotNull io.sentry.l0 l0Var, @NotNull Class<?> cls) {
        return cls.isInstance(g(l0Var));
    }

    public static boolean i(@NotNull io.sentry.l0 l0Var) {
        return Boolean.TRUE.equals(l0Var.d("sentry:isFromHybridSdk", Boolean.class));
    }

    public static <T> void n(@NotNull io.sentry.l0 l0Var, @NotNull Class<T> cls, final c<Object> cVar) {
        p(l0Var, cls, new a() { // from class: io.sentry.util.j
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                m.j(obj);
            }
        }, new b() { // from class: io.sentry.util.k
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                cVar.accept(obj);
            }
        });
    }

    public static <T> void o(@NotNull io.sentry.l0 l0Var, @NotNull Class<T> cls, a<T> aVar) {
        p(l0Var, cls, aVar, new b() { // from class: io.sentry.util.i
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                m.l(obj, cls2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void p(@NotNull io.sentry.l0 l0Var, @NotNull Class<T> cls, a<T> aVar, b bVar) {
        Object objG = g(l0Var);
        if (!h(l0Var, cls) || objG == null) {
            bVar.a(objG, cls);
        } else {
            aVar.accept(objG);
        }
    }

    public static <T> void q(@NotNull io.sentry.l0 l0Var, @NotNull Class<T> cls, final w0 w0Var, a<T> aVar) {
        p(l0Var, cls, aVar, new b() { // from class: io.sentry.util.l
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                t.a(cls2, obj, w0Var);
            }
        });
    }

    public static void r(@NotNull io.sentry.l0 l0Var, @NotNull io.sentry.hints.h hVar) {
        l0Var.j("sentry:eventDropReason", hVar);
    }

    public static void s(@NotNull io.sentry.l0 l0Var, @NotNull String str) {
        if (str.startsWith("sentry.javascript") || str.startsWith("sentry.dart") || str.startsWith("sentry.dotnet")) {
            l0Var.j("sentry:isFromHybridSdk", Boolean.TRUE);
        }
    }

    public static void t(@NotNull io.sentry.l0 l0Var, Object obj) {
        l0Var.j("sentry:typeCheckHint", obj);
    }

    public static boolean u(@NotNull io.sentry.l0 l0Var) {
        return !(h(l0Var, io.sentry.hints.e.class) || h(l0Var, io.sentry.hints.c.class)) || h(l0Var, io.sentry.hints.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Object obj, Class cls) {
    }
}
