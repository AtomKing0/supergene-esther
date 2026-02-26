package androidx.compose.ui.platform;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1 extends kotlin.jvm.internal.v implements h9.l<ScrollObservationScope, v8.k0> {
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        super(1);
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(ScrollObservationScope scrollObservationScope) {
        invoke2(scrollObservationScope);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ScrollObservationScope it) {
        kotlin.jvm.internal.t.i(it, "it");
        this.this$0.sendScrollEventIfNeeded(it);
    }
}
