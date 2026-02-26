package l8;

import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PipelineContext.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class e<TSubject, TContext> implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final TContext f30955a;

    public e(@NotNull TContext context) {
        t.i(context, "context");
        this.f30955a = context;
    }

    @Nullable
    public abstract Object b(@NotNull TSubject tsubject, @NotNull z8.d<? super TSubject> dVar);

    @NotNull
    public final TContext c() {
        return this.f30955a;
    }

    @Nullable
    public abstract Object d(@NotNull z8.d<? super TSubject> dVar);

    @Nullable
    public abstract Object e(@NotNull TSubject tsubject, @NotNull z8.d<? super TSubject> dVar);
}
