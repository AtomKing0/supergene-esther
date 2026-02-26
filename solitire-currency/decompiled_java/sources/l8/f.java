package l8;

import h9.q;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PipelineContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    @NotNull
    public static final <TSubject, TContext> e<TSubject, TContext> a(@NotNull TContext context, @NotNull List<? extends q<? super e<TSubject, TContext>, ? super TSubject, ? super z8.d<? super k0>, ? extends Object>> interceptors, @NotNull TSubject subject, @NotNull z8.g coroutineContext, boolean z10) {
        t.i(context, "context");
        t.i(interceptors, "interceptors");
        t.i(subject, "subject");
        t.i(coroutineContext, "coroutineContext");
        return (g.a() || z10) ? new a(context, interceptors, subject, coroutineContext) : new n(subject, context, interceptors);
    }
}
