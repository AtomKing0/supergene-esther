package androidx.core.transition;

import android.transition.Transition;
import h9.l;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ l<Transition, k0> $onCancel;
    final /* synthetic */ l<Transition, k0> $onEnd;
    final /* synthetic */ l<Transition, k0> $onPause;
    final /* synthetic */ l<Transition, k0> $onResume;
    final /* synthetic */ l<Transition, k0> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionKt$addListener$listener$1(l<? super Transition, k0> lVar, l<? super Transition, k0> lVar2, l<? super Transition, k0> lVar3, l<? super Transition, k0> lVar4, l<? super Transition, k0> lVar5) {
        this.$onEnd = lVar;
        this.$onResume = lVar2;
        this.$onPause = lVar3;
        this.$onCancel = lVar4;
        this.$onStart = lVar5;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(@NotNull Transition transition) {
        this.$onCancel.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(@NotNull Transition transition) {
        this.$onEnd.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(@NotNull Transition transition) {
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(@NotNull Transition transition) {
        this.$onResume.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(@NotNull Transition transition) {
        this.$onStart.invoke(transition);
    }
}
