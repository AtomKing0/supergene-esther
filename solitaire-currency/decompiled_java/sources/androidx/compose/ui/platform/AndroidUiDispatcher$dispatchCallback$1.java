package androidx.compose.ui.platform;

import android.view.Choreographer;

/* JADX INFO: compiled from: AndroidUiDispatcher.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidUiDispatcher$dispatchCallback$1 implements Choreographer.FrameCallback, Runnable {
    final /* synthetic */ AndroidUiDispatcher this$0;

    AndroidUiDispatcher$dispatchCallback$1(AndroidUiDispatcher androidUiDispatcher) {
        this.this$0 = androidUiDispatcher;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        this.this$0.handler.removeCallbacks(this);
        this.this$0.performTrampolineDispatch();
        this.this$0.performFrameDispatch(j10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.performTrampolineDispatch();
        Object obj = this.this$0.lock;
        AndroidUiDispatcher androidUiDispatcher = this.this$0;
        synchronized (obj) {
            if (androidUiDispatcher.toRunOnFrame.isEmpty()) {
                androidUiDispatcher.getChoreographer().removeFrameCallback(this);
                androidUiDispatcher.scheduledFrameDispatch = false;
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }
}
