package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import h9.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: AnimatedVisibility.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1", f = "AnimatedVisibility.kt", l = {748}, m = "invokeSuspend")
final class AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1 extends l implements p<o0, d<? super k0>, Object> {
    final /* synthetic */ Transition<EnterExitState> $childTransition;
    final /* synthetic */ MutableState<Boolean> $isAnimationVisible;
    int label;

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedVisibility.kt */
    static final class AnonymousClass1 extends v implements h9.a<Boolean> {
        final /* synthetic */ Transition<EnterExitState> $childTransition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Transition<EnterExitState> transition) {
            super(0);
            this.$childTransition = transition;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            EnterExitState currentState = this.$childTransition.getCurrentState();
            EnterExitState enterExitState = EnterExitState.Visible;
            return Boolean.valueOf(currentState == enterExitState || this.$childTransition.getTargetState() == enterExitState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1(Transition<EnterExitState> transition, MutableState<Boolean> mutableState, d<? super AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1> dVar) {
        super(2, dVar);
        this.$childTransition = transition;
        this.$isAnimationVisible = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1(this.$childTransition, this.$isAnimationVisible, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            h hVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new AnonymousClass1(this.$childTransition));
            final MutableState<Boolean> mutableState = this.$isAnimationVisible;
            i<Boolean> iVar = new i<Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1.2
                @Override // s9.i
                public /* bridge */ /* synthetic */ Object emit(Boolean bool, d dVar) {
                    return emit(bool.booleanValue(), (d<? super k0>) dVar);
                }

                @Nullable
                public final Object emit(boolean z10, @NotNull d<? super k0> dVar) {
                    mutableState.setValue(b.a(z10));
                    return k0.f35197a;
                }
            };
            this.label = 1;
            if (hVarSnapshotFlow.collect(iVar, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
        return ((AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
