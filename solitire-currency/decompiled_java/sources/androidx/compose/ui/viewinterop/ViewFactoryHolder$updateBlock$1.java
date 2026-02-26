package androidx.compose.ui.viewinterop;

import android.view.View;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class ViewFactoryHolder$updateBlock$1 extends v implements h9.a<k0> {
    final /* synthetic */ ViewFactoryHolder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewFactoryHolder$updateBlock$1(ViewFactoryHolder<T> viewFactoryHolder) {
        super(0);
        this.this$0 = viewFactoryHolder;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View typedView$ui_release = this.this$0.getTypedView$ui_release();
        if (typedView$ui_release != null) {
            this.this$0.getUpdateBlock().invoke(typedView$ui_release);
        }
    }
}
