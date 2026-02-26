package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import v8.k0;

/* JADX INFO: compiled from: DefaultSpecialEffectsController.kt */
/* JADX INFO: loaded from: classes.dex */
final class DefaultSpecialEffectsController$TransitionEffect$onCommit$4 extends kotlin.jvm.internal.v implements h9.a<k0> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Object $mergedTransition;
    final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultSpecialEffectsController$TransitionEffect$onCommit$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup, Object obj) {
        super(0);
        this.this$0 = transitionEffect;
        this.$container = viewGroup;
        this.$mergedTransition = obj;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getTransitionImpl().beginDelayedTransition(this.$container, this.$mergedTransition);
    }
}
