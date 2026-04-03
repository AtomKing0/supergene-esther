package androidx.core.transition;

import android.transition.Transition;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt {

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class AnonymousClass1 extends v implements l<Transition, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Transition transition) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Transition transition) {
            invoke2(transition);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class AnonymousClass2 extends v implements l<Transition, k0> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Transition transition) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Transition transition) {
            invoke2(transition);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$3, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class AnonymousClass3 extends v implements l<Transition, k0> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Transition transition) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Transition transition) {
            invoke2(transition);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$4, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class AnonymousClass4 extends v implements l<Transition, k0> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Transition transition) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Transition transition) {
            invoke2(transition);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$5, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class AnonymousClass5 extends v implements l<Transition, k0> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Transition transition) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Transition transition) {
            invoke2(transition);
            return k0.f35197a;
        }
    }

    @NotNull
    public static final Transition.TransitionListener addListener(@NotNull Transition transition, @NotNull l<? super Transition, k0> lVar, @NotNull l<? super Transition, k0> lVar2, @NotNull l<? super Transition, k0> lVar3, @NotNull l<? super Transition, k0> lVar4, @NotNull l<? super Transition, k0> lVar5) {
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar3, lVar2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            lVar2 = AnonymousClass2.INSTANCE;
        }
        l lVar6 = lVar2;
        if ((i10 & 4) != 0) {
            lVar3 = AnonymousClass3.INSTANCE;
        }
        l lVar7 = lVar3;
        if ((i10 & 8) != 0) {
            lVar4 = AnonymousClass4.INSTANCE;
        }
        if ((i10 & 16) != 0) {
            lVar5 = AnonymousClass5.INSTANCE;
        }
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar7, lVar6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @NotNull
    public static final Transition.TransitionListener doOnCancel(@NotNull Transition transition, @NotNull final l<? super Transition, k0> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @NotNull
    public static final Transition.TransitionListener doOnEnd(@NotNull Transition transition, @NotNull final l<? super Transition, k0> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @NotNull
    public static final Transition.TransitionListener doOnPause(@NotNull Transition transition, @NotNull final l<? super Transition, k0> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @NotNull
    public static final Transition.TransitionListener doOnResume(@NotNull Transition transition, @NotNull final l<? super Transition, k0> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @NotNull
    public static final Transition.TransitionListener doOnStart(@NotNull Transition transition, @NotNull final l<? super Transition, k0> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
