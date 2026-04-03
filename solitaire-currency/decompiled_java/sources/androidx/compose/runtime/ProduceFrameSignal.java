package androidx.compose.runtime;

import kotlin.coroutines.jvm.internal.h;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ProduceFrameSignal {

    @Nullable
    private Object pendingFrameContinuation;

    @Nullable
    public final Object awaitFrameRequest(@NotNull Object obj, @NotNull z8.d<? super k0> dVar) throws Throwable {
        p pVar;
        synchronized (obj) {
            if (this.pendingFrameContinuation == RecomposerKt.ProduceAnotherFrame) {
                this.pendingFrameContinuation = RecomposerKt.FramePending;
                return k0.f35197a;
            }
            k0 k0Var = k0.f35197a;
            p pVar2 = new p(a9.c.c(dVar), 1);
            pVar2.C();
            synchronized (obj) {
                if (this.pendingFrameContinuation == RecomposerKt.ProduceAnotherFrame) {
                    this.pendingFrameContinuation = RecomposerKt.FramePending;
                    pVar = pVar2;
                } else {
                    this.pendingFrameContinuation = pVar2;
                    pVar = null;
                }
            }
            if (pVar != null) {
                t.a aVar = t.f35208b;
                pVar.resumeWith(t.b(k0.f35197a));
            }
            Object objZ = pVar2.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        }
    }

    @Nullable
    public final z8.d<k0> requestFrameLocked() {
        Object obj = this.pendingFrameContinuation;
        if (obj instanceof z8.d) {
            this.pendingFrameContinuation = RecomposerKt.FramePending;
            return (z8.d) obj;
        }
        if (!(kotlin.jvm.internal.t.d(obj, RecomposerKt.ProduceAnotherFrame) ? true : kotlin.jvm.internal.t.d(obj, RecomposerKt.FramePending))) {
            if (obj != null) {
                throw new IllegalStateException(("invalid pendingFrameContinuation " + obj).toString());
            }
            this.pendingFrameContinuation = RecomposerKt.ProduceAnotherFrame;
        }
        return null;
    }

    public final void takeFrameRequestLocked() {
        if (!(this.pendingFrameContinuation == RecomposerKt.FramePending)) {
            throw new IllegalStateException("frame not pending".toString());
        }
        this.pendingFrameContinuation = null;
    }
}
