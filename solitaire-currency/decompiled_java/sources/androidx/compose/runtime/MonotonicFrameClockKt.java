package androidx.compose.runtime;

import h9.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: MonotonicFrameClock.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MonotonicFrameClockKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MonotonicFrameClockKt$withFrameMillis$2, reason: invalid class name */
    /* JADX INFO: compiled from: MonotonicFrameClock.kt */
    public static final class AnonymousClass2<R> extends v implements l<Long, R> {
        final /* synthetic */ l<Long, R> $onFrame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(l<? super Long, ? extends R> lVar) {
            super(1);
            this.$onFrame = lVar;
        }

        public final R invoke(long j10) {
            return this.$onFrame.invoke(Long.valueOf(j10 / 1000000));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Long l10) {
            return invoke(l10.longValue());
        }
    }

    @NotNull
    public static final MonotonicFrameClock getMonotonicFrameClock(@NotNull g gVar) {
        t.i(gVar, "<this>");
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) gVar.get(MonotonicFrameClock.Key);
        if (monotonicFrameClock != null) {
            return monotonicFrameClock;
        }
        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.".toString());
    }

    @Nullable
    public static final <R> Object withFrameMillis(@NotNull MonotonicFrameClock monotonicFrameClock, @NotNull l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar) {
        return monotonicFrameClock.withFrameNanos(new AnonymousClass2(lVar), dVar);
    }

    private static final <R> Object withFrameMillis$$forInline(MonotonicFrameClock monotonicFrameClock, l<? super Long, ? extends R> lVar, z8.d<? super R> dVar) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(lVar);
        r.c(0);
        Object objWithFrameNanos = monotonicFrameClock.withFrameNanos(anonymousClass2, dVar);
        r.c(1);
        return objWithFrameNanos;
    }

    @Nullable
    public static final <R> Object withFrameNanos(@NotNull l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar) {
        return getMonotonicFrameClock(dVar.getContext()).withFrameNanos(lVar, dVar);
    }

    @Nullable
    public static final <R> Object withFrameMillis(@NotNull l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar) {
        return getMonotonicFrameClock(dVar.getContext()).withFrameNanos(new AnonymousClass2(lVar), dVar);
    }

    @ExperimentalComposeApi
    public static /* synthetic */ void getMonotonicFrameClock$annotations(g gVar) {
    }
}
