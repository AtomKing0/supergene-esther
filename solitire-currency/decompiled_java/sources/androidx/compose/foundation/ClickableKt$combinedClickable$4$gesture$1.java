package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1", f = "Clickable.kt", l = {318}, m = "invokeSuspend")
final class ClickableKt$combinedClickable$4$gesture$1 extends kotlin.coroutines.jvm.internal.l implements h9.p<PointerInputScope, z8.d<? super k0>, Object> {
    final /* synthetic */ State<h9.a<Boolean>> $delayPressInteraction;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $hasDoubleClick;
    final /* synthetic */ boolean $hasLongClick;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<h9.a<k0>> $onClickState;
    final /* synthetic */ State<h9.a<k0>> $onDoubleClickState;
    final /* synthetic */ State<h9.a<k0>> $onLongClickState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    static final class AnonymousClass1 extends v implements h9.l<Offset, k0> {
        final /* synthetic */ State<h9.a<k0>> $onDoubleClickState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(State<? extends h9.a<k0>> state) {
            super(1);
            this.$onDoubleClickState = state;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m195invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m195invokek4lQ0M(long j10) {
            h9.a<k0> value = this.$onDoubleClickState.getValue();
            if (value != null) {
                value.invoke();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    static final class AnonymousClass2 extends v implements h9.l<Offset, k0> {
        final /* synthetic */ State<h9.a<k0>> $onLongClickState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(State<? extends h9.a<k0>> state) {
            super(1);
            this.$onLongClickState = state;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m196invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m196invokek4lQ0M(long j10) {
            h9.a<k0> value = this.$onLongClickState.getValue();
            if (value != null) {
                value.invoke();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$3", f = "Clickable.kt", l = {331}, m = "invokeSuspend")
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.l implements h9.q<PressGestureScope, Offset, z8.d<? super k0>, Object> {
        final /* synthetic */ State<h9.a<Boolean>> $delayPressInteraction;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(boolean z10, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends h9.a<Boolean>> state, z8.d<? super AnonymousClass3> dVar) {
            super(3, dVar);
            this.$enabled = z10;
            this.$interactionSource = mutableInteractionSource;
            this.$pressedInteraction = mutableState;
            this.$delayPressInteraction = state;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, z8.d<? super k0> dVar) {
            return m197invoked4ec7I(pressGestureScope, offset.m1377unboximpl(), dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m197invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j10, @Nullable z8.d<? super k0> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, dVar);
            anonymousClass3.L$0 = pressGestureScope;
            anonymousClass3.J$0 = j10;
            return anonymousClass3.invokeSuspend(k0.f35197a);
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
                    State<h9.a<Boolean>> state = this.$delayPressInteraction;
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

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    static final class AnonymousClass4 extends v implements h9.l<Offset, k0> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ State<h9.a<k0>> $onClickState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(boolean z10, State<? extends h9.a<k0>> state) {
            super(1);
            this.$enabled = z10;
            this.$onClickState = state;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m198invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m198invokek4lQ0M(long j10) {
            if (this.$enabled) {
                this.$onClickState.getValue().invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ClickableKt$combinedClickable$4$gesture$1(boolean z10, boolean z11, boolean z12, State<? extends h9.a<k0>> state, State<? extends h9.a<k0>> state2, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends h9.a<Boolean>> state3, State<? extends h9.a<k0>> state4, z8.d<? super ClickableKt$combinedClickable$4$gesture$1> dVar) {
        super(2, dVar);
        this.$hasDoubleClick = z10;
        this.$enabled = z11;
        this.$hasLongClick = z12;
        this.$onDoubleClickState = state;
        this.$onLongClickState = state2;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
        this.$delayPressInteraction = state3;
        this.$onClickState = state4;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        ClickableKt$combinedClickable$4$gesture$1 clickableKt$combinedClickable$4$gesture$1 = new ClickableKt$combinedClickable$4$gesture$1(this.$hasDoubleClick, this.$enabled, this.$hasLongClick, this.$onDoubleClickState, this.$onLongClickState, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, this.$onClickState, dVar);
        clickableKt$combinedClickable$4$gesture$1.L$0 = obj;
        return clickableKt$combinedClickable$4$gesture$1;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
        return ((ClickableKt$combinedClickable$4$gesture$1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = (this.$hasDoubleClick && this.$enabled) ? new AnonymousClass1(this.$onDoubleClickState) : null;
            AnonymousClass2 anonymousClass2 = (this.$hasLongClick && this.$enabled) ? new AnonymousClass2(this.$onLongClickState) : null;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, null);
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$enabled, this.$onClickState);
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures(pointerInputScope, anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, this) == objE) {
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
