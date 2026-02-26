package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeView$snapshotObserver$1 extends kotlin.jvm.internal.v implements h9.l<h9.a<? extends v8.k0>, v8.k0> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidComposeView$snapshotObserver$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m3160invoke$lambda0(h9.a tmp0) {
        kotlin.jvm.internal.t.i(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(h9.a<? extends v8.k0> aVar) {
        invoke2((h9.a<v8.k0>) aVar);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final h9.a<v8.k0> command) {
        kotlin.jvm.internal.t.i(command, "command");
        Handler handler = this.this$0.getHandler();
        if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
            command.invoke();
            return;
        }
        Handler handler2 = this.this$0.getHandler();
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: androidx.compose.ui.platform.h
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidComposeView$snapshotObserver$1.m3160invoke$lambda0(command);
                }
            });
        }
    }
}
