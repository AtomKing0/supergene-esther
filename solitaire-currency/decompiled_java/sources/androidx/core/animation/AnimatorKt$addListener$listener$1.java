package androidx.core.animation;

import android.animation.Animator;
import h9.l;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ l<Animator, k0> $onCancel;
    final /* synthetic */ l<Animator, k0> $onEnd;
    final /* synthetic */ l<Animator, k0> $onRepeat;
    final /* synthetic */ l<Animator, k0> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addListener$listener$1(l<? super Animator, k0> lVar, l<? super Animator, k0> lVar2, l<? super Animator, k0> lVar3, l<? super Animator, k0> lVar4) {
        this.$onRepeat = lVar;
        this.$onEnd = lVar2;
        this.$onCancel = lVar3;
        this.$onStart = lVar4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animator) {
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animator) {
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator animator) {
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animator) {
        this.$onStart.invoke(animator);
    }
}
