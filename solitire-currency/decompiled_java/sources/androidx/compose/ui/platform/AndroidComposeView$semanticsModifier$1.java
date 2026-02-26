package androidx.compose.ui.platform;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeView$semanticsModifier$1 extends kotlin.jvm.internal.v implements h9.l<SemanticsPropertyReceiver, v8.k0> {
    public static final AndroidComposeView$semanticsModifier$1 INSTANCE = new AndroidComposeView$semanticsModifier$1();

    AndroidComposeView$semanticsModifier$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver $receiver) {
        kotlin.jvm.internal.t.i($receiver, "$this$$receiver");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return v8.k0.f35197a;
    }
}
