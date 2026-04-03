package androidx.compose.runtime;

import android.view.Choreographer;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ActualAndroid.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class DefaultChoreographerFrameClock$withFrameNanos$2$1 extends v implements l<Throwable, k0> {
    final /* synthetic */ Choreographer.FrameCallback $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultChoreographerFrameClock$withFrameNanos$2$1(Choreographer.FrameCallback frameCallback) {
        super(1);
        this.$callback = frameCallback;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        DefaultChoreographerFrameClock.choreographer.removeFrameCallback(this.$callback);
    }
}
