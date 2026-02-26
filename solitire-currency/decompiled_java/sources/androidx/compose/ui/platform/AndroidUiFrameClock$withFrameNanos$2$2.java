package androidx.compose.ui.platform;

import android.view.Choreographer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidUiFrameClock.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidUiFrameClock$withFrameNanos$2$2 extends kotlin.jvm.internal.v implements h9.l<Throwable, v8.k0> {
    final /* synthetic */ Choreographer.FrameCallback $callback;
    final /* synthetic */ AndroidUiFrameClock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidUiFrameClock$withFrameNanos$2$2(AndroidUiFrameClock androidUiFrameClock, Choreographer.FrameCallback frameCallback) {
        super(1);
        this.this$0 = androidUiFrameClock;
        this.$callback = frameCallback;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        invoke2(th);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        this.this$0.getChoreographer().removeFrameCallback(this.$callback);
    }
}
