package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import h9.a;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Toggleable.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$gestures$1", f = "Toggleable.kt", l = {270}, m = "invokeSuspend")
final class ToggleableKt$toggleableImpl$1$gestures$1 extends l implements p<PointerInputScope, d<? super k0>, Object> {
    final /* synthetic */ State<a<Boolean>> $delayPressInteraction;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<a<k0>> $onClickState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$gestures$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Toggleable.kt */
    @f(c = "androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$gestures$1$1", f = "Toggleable.kt", l = {273}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements q<PressGestureScope, Offset, d<? super k0>, Object> {
        final /* synthetic */ State<a<Boolean>> $delayPressInteraction;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(boolean z10, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends a<Boolean>> state, d<? super AnonymousClass1> dVar) {
            super(3, dVar);
            this.$enabled = z10;
            this.$interactionSource = mutableInteractionSource;
            this.$pressedInteraction = mutableState;
            this.$delayPressInteraction = state;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, d<? super k0> dVar) {
            return m627invoked4ec7I(pressGestureScope, offset.m1377unboximpl(), dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m627invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j10, @Nullable d<? super k0> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, dVar);
            anonymousClass1.L$0 = pressGestureScope;
            anonymousClass1.J$0 = j10;
            return anonymousClass1.invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j10 = this.J$0;
                if (this.$enabled) {
                    MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                    MutableState<PressInteraction.Press> mutableState = this.$pressedInteraction;
                    State<a<Boolean>> state = this.$delayPressInteraction;
                    this.label = 1;
                    if (ClickableKt.m192handlePressInteractionEPk0efs(pressGestureScope, j10, mutableInteractionSource, mutableState, state, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$gestures$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: Toggleable.kt */
    static final class AnonymousClass2 extends v implements h9.l<Offset, k0> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ State<a<k0>> $onClickState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(boolean z10, State<? extends a<k0>> state) {
            super(1);
            this.$enabled = z10;
            this.$onClickState = state;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m628invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m628invokek4lQ0M(long j10) {
            if (this.$enabled) {
                this.$onClickState.getValue().invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ToggleableKt$toggleableImpl$1$gestures$1(boolean z10, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends a<Boolean>> state, State<? extends a<k0>> state2, d<? super ToggleableKt$toggleableImpl$1$gestures$1> dVar) {
        super(2, dVar);
        this.$enabled = z10;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
        this.$delayPressInteraction = state;
        this.$onClickState = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        ToggleableKt$toggleableImpl$1$gestures$1 toggleableKt$toggleableImpl$1$gestures$1 = new ToggleableKt$toggleableImpl$1$gestures$1(this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, this.$onClickState, dVar);
        toggleableKt$toggleableImpl$1$gestures$1.L$0 = obj;
        return toggleableKt$toggleableImpl$1$gestures$1;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
        return ((ToggleableKt$toggleableImpl$1$gestures$1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, null);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$enabled, this.$onClickState);
            this.label = 1;
            if (TapGestureDetectorKt.detectTapAndPress(pointerInputScope, anonymousClass1, anonymousClass2, this) == objE) {
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
}
