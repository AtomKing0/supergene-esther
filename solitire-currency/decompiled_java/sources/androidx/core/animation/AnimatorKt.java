package androidx.core.animation;

import android.animation.Animator;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt {

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class AnonymousClass1 extends v implements l<Animator, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Animator animator) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Animator animator) {
            invoke2(animator);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$2, reason: invalid class name */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class AnonymousClass2 extends v implements l<Animator, k0> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Animator animator) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Animator animator) {
            invoke2(animator);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$3, reason: invalid class name */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class AnonymousClass3 extends v implements l<Animator, k0> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Animator animator) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Animator animator) {
            invoke2(animator);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$4, reason: invalid class name */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class AnonymousClass4 extends v implements l<Animator, k0> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Animator animator) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Animator animator) {
            invoke2(animator);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addPauseListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Animator.kt */
    static final class C10151 extends v implements l<Animator, k0> {
        public static final C10151 INSTANCE = new C10151();

        C10151() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Animator animator) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Animator animator) {
            invoke2(animator);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addPauseListener$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Animator.kt */
    static final class C10162 extends v implements l<Animator, k0> {
        public static final C10162 INSTANCE = new C10162();

        C10162() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Animator animator) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Animator animator) {
            invoke2(animator);
            return k0.f35197a;
        }
    }

    @NotNull
    public static final Animator.AnimatorListener addListener(@NotNull Animator animator, @NotNull l<? super Animator, k0> lVar, @NotNull l<? super Animator, k0> lVar2, @NotNull l<? super Animator, k0> lVar3, @NotNull l<? super Animator, k0> lVar4) {
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(lVar4, lVar, lVar3, lVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, l lVar, l lVar2, l lVar3, l lVar4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            lVar2 = AnonymousClass2.INSTANCE;
        }
        if ((i10 & 4) != 0) {
            lVar3 = AnonymousClass3.INSTANCE;
        }
        if ((i10 & 8) != 0) {
            lVar4 = AnonymousClass4.INSTANCE;
        }
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(lVar4, lVar, lVar3, lVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @NotNull
    public static final Animator.AnimatorPauseListener addPauseListener(@NotNull Animator animator, @NotNull final l<? super Animator, k0> lVar, @NotNull final l<? super Animator, k0> lVar2) {
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$listener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@NotNull Animator animator2) {
                lVar2.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@NotNull Animator animator2) {
                lVar.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = C10151.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            lVar2 = C10162.INSTANCE;
        }
        return addPauseListener(animator, lVar, lVar2);
    }

    @NotNull
    public static final Animator.AnimatorListener doOnCancel(@NotNull Animator animator, @NotNull final l<? super Animator, k0> lVar) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
                lVar.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnEnd(@NotNull Animator animator, @NotNull final l<? super Animator, k0> lVar) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
                lVar.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorPauseListener doOnPause(@NotNull Animator animator, @NotNull l<? super Animator, k0> lVar) {
        return addPauseListener$default(animator, null, lVar, 1, null);
    }

    @NotNull
    public static final Animator.AnimatorListener doOnRepeat(@NotNull Animator animator, @NotNull final l<? super Animator, k0> lVar) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
                lVar.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorPauseListener doOnResume(@NotNull Animator animator, @NotNull l<? super Animator, k0> lVar) {
        return addPauseListener$default(animator, lVar, null, 2, null);
    }

    @NotNull
    public static final Animator.AnimatorListener doOnStart(@NotNull Animator animator, @NotNull final l<? super Animator, k0> lVar) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
                lVar.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
