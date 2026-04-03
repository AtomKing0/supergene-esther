package androidx.compose.ui.platform;

import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;
import z8.g;

/* JADX INFO: compiled from: AndroidUiFrameClock.android.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AndroidUiFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;

    @NotNull
    private final Choreographer choreographer;

    public AndroidUiFrameClock(@NotNull Choreographer choreographer) {
        kotlin.jvm.internal.t.i(choreographer, "choreographer");
        this.choreographer = choreographer;
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r10, pVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, cVar);
    }

    @NotNull
    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g.b
    public /* synthetic */ g.c getKey() {
        return androidx.compose.runtime.c.a(this);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g.b, z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> cVar) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, cVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g
    @NotNull
    public z8.g plus(@NotNull z8.g gVar) {
        return MonotonicFrameClock.DefaultImpls.plus(this, gVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    @Nullable
    public <R> Object withFrameNanos(@NotNull final h9.l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar) throws Throwable {
        g.b bVar = dVar.getContext().get(z8.e.R7);
        AndroidUiDispatcher androidUiDispatcher = bVar instanceof AndroidUiDispatcher ? (AndroidUiDispatcher) bVar : null;
        final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                Object objB;
                z8.d dVar2 = pVar;
                h9.l<Long, R> lVar2 = lVar;
                try {
                    t.a aVar = v8.t.f35208b;
                    objB = v8.t.b(lVar2.invoke(Long.valueOf(j10)));
                } catch (Throwable th) {
                    t.a aVar2 = v8.t.f35208b;
                    objB = v8.t.b(v8.u.a(th));
                }
                dVar2.resumeWith(objB);
            }
        };
        if (androidUiDispatcher == null || !kotlin.jvm.internal.t.d(androidUiDispatcher.getChoreographer(), getChoreographer())) {
            getChoreographer().postFrameCallback(frameCallback);
            pVar.m(new AndroidUiFrameClock$withFrameNanos$2$2(this, frameCallback));
        } else {
            androidUiDispatcher.postFrameCallback$ui_release(frameCallback);
            pVar.m(new AndroidUiFrameClock$withFrameNanos$2$1(androidUiDispatcher, frameCallback));
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }
}
