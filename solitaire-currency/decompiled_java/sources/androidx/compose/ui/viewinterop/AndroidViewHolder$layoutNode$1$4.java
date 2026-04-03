package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import h9.l;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidViewHolder$layoutNode$1$4 extends v implements l<Owner, k0> {
    final /* synthetic */ AndroidViewHolder $this_run;
    final /* synthetic */ n0<View> $viewRemovedOnDetach;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$4(AndroidViewHolder androidViewHolder, n0<View> n0Var) {
        super(1);
        this.$this_run = androidViewHolder;
        this.$viewRemovedOnDetach = n0Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Owner owner) {
        invoke2(owner);
        return k0.f35197a;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, android.view.View] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Owner owner) {
        t.i(owner, "owner");
        AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
        if (androidComposeView != null) {
            androidComposeView.removeAndroidView(this.$this_run);
        }
        this.$viewRemovedOnDetach.f29834a = this.$this_run.getView();
        this.$this_run.setView$ui_release(null);
    }
}
