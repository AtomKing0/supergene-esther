package kotlinx.coroutines.android;

import kotlin.jvm.internal.k;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.n2;
import kotlinx.coroutines.o;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;
import z8.g;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class HandlerDispatcher extends n2 implements x0 {
    public /* synthetic */ HandlerDispatcher(k kVar) {
        this();
    }

    @Nullable
    public Object delay(long j10, @NotNull d<? super k0> dVar) {
        return x0.a.a(this, j10, dVar);
    }

    @Override // kotlinx.coroutines.n2
    @NotNull
    public abstract HandlerDispatcher getImmediate();

    @NotNull
    public g1 invokeOnTimeout(long j10, @NotNull Runnable runnable, @NotNull g gVar) {
        return x0.a.b(this, j10, runnable, gVar);
    }

    public abstract /* synthetic */ void scheduleResumeAfterDelay(long j10, @NotNull o<? super k0> oVar);

    private HandlerDispatcher() {
    }
}
