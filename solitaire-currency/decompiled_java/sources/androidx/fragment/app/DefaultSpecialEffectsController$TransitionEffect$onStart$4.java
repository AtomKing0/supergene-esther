package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4;
import androidx.fragment.app.SpecialEffectsController;
import java.util.Iterator;
import kotlin.jvm.internal.n0;
import v8.k0;

/* JADX INFO: compiled from: DefaultSpecialEffectsController.kt */
/* JADX INFO: loaded from: classes.dex */
final class DefaultSpecialEffectsController$TransitionEffect$onStart$4 extends kotlin.jvm.internal.v implements h9.a<k0> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Object $mergedTransition;
    final /* synthetic */ n0<h9.a<k0>> $seekCancelLambda;
    final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultSpecialEffectsController.kt */
    static final class AnonymousClass2 extends kotlin.jvm.internal.v implements h9.a<k0> {
        final /* synthetic */ ViewGroup $container;
        final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup) {
            super(0);
            this.this$0 = transitionEffect;
            this.$container = viewGroup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(DefaultSpecialEffectsController.TransitionEffect this$0, ViewGroup container) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(container, "$container");
            Iterator<T> it = this$0.getTransitionInfos().iterator();
            while (it.hasNext()) {
                SpecialEffectsController.Operation operation = ((DefaultSpecialEffectsController.TransitionInfo) it.next()).getOperation();
                View view = operation.getFragment().getView();
                if (view != null) {
                    operation.getFinalState().applyState(view, container);
                }
            }
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animating to start");
            }
            FragmentTransitionImpl transitionImpl = this.this$0.getTransitionImpl();
            Object controller = this.this$0.getController();
            kotlin.jvm.internal.t.f(controller);
            final DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
            final ViewGroup viewGroup = this.$container;
            transitionImpl.animateToStart(controller, new Runnable() { // from class: androidx.fragment.app.l
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSpecialEffectsController$TransitionEffect$onStart$4.AnonymousClass2.invoke$lambda$1(transitionEffect, viewGroup);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultSpecialEffectsController$TransitionEffect$onStart$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup, Object obj, n0<h9.a<k0>> n0Var) {
        super(0);
        this.this$0 = transitionEffect;
        this.$container = viewGroup;
        this.$mergedTransition = obj;
        this.$seekCancelLambda = n0Var;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
        transitionEffect.setController(transitionEffect.getTransitionImpl().controlDelayedTransition(this.$container, this.$mergedTransition));
        boolean z10 = this.this$0.getController() != null;
        Object obj = this.$mergedTransition;
        ViewGroup viewGroup = this.$container;
        if (!z10) {
            throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
        }
        this.$seekCancelLambda.f29834a = new AnonymousClass2(this.this$0, viewGroup);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Started executing operations from " + this.this$0.getFirstOut() + " to " + this.this$0.getLastIn());
        }
    }
}
