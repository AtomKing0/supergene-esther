package androidx.compose.ui.platform;

import android.os.SystemClock;
import android.view.MotionEvent;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeView$resendMotionEventOnLayout$1 extends kotlin.jvm.internal.v implements h9.a<v8.k0> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidComposeView$resendMotionEventOnLayout$1(AndroidComposeView androidComposeView) {
        super(0);
        this.this$0 = androidComposeView;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ v8.k0 invoke() {
        invoke2();
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MotionEvent motionEvent = this.this$0.previousMotionEvent;
        if (motionEvent != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 7 || actionMasked == 9) {
                this.this$0.relayoutTime = SystemClock.uptimeMillis();
                AndroidComposeView androidComposeView = this.this$0;
                androidComposeView.post(androidComposeView.resendMotionEventRunnable);
            }
        }
    }
}
