package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import h9.l;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;
import z8.h;

/* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldPressGestureFilterKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
    static final class AnonymousClass1 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ l<Offset, k0> $onTap;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
        static final class C00631 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00631(MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource) {
                super(1);
                this.$pressedInteraction = mutableState;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // h9.l
            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                t.i(DisposableEffect, "$this$DisposableEffect");
                final MutableState<PressInteraction.Press> mutableState = this.$pressedInteraction;
                final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        PressInteraction.Press press = (PressInteraction.Press) mutableState.getValue();
                        if (press != null) {
                            PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                            MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                            if (mutableInteractionSource2 != null) {
                                mutableInteractionSource2.tryEmit(cancel);
                            }
                            mutableState.setValue(null);
                        }
                    }
                };
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
        @f(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2", f = "TextFieldPressGestureFilter.kt", l = {55}, m = "invokeSuspend")
        static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ State<l<Offset, k0>> $onTapState;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
            final /* synthetic */ o0 $scope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
            @f(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1", f = "TextFieldPressGestureFilter.kt", l = {68}, m = "invokeSuspend")
            static final class C00641 extends kotlin.coroutines.jvm.internal.l implements q<PressGestureScope, Offset, d<? super k0>, Object> {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                final /* synthetic */ o0 $scope;
                /* synthetic */ long J$0;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
                @f(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1", f = "TextFieldPressGestureFilter.kt", l = {61, 65}, m = "invokeSuspend")
                static final class C00651 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    final /* synthetic */ long $it;
                    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00651(MutableState<PressInteraction.Press> mutableState, long j10, MutableInteractionSource mutableInteractionSource, d<? super C00651> dVar) {
                        super(2, dVar);
                        this.$pressedInteraction = mutableState;
                        this.$it = j10;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                        return new C00651(this.$pressedInteraction, this.$it, this.$interactionSource, dVar);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
                    @Override // kotlin.coroutines.jvm.internal.a
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
                        /*
                            r7 = this;
                            java.lang.Object r0 = a9.b.e()
                            int r1 = r7.label
                            r2 = 0
                            r3 = 2
                            r4 = 1
                            if (r1 == 0) goto L27
                            if (r1 == r4) goto L1f
                            if (r1 != r3) goto L17
                            java.lang.Object r0 = r7.L$0
                            androidx.compose.foundation.interaction.PressInteraction$Press r0 = (androidx.compose.foundation.interaction.PressInteraction.Press) r0
                            v8.u.b(r8)
                            goto L66
                        L17:
                            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r8.<init>(r0)
                            throw r8
                        L1f:
                            java.lang.Object r1 = r7.L$0
                            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
                            v8.u.b(r8)
                            goto L4b
                        L27:
                            v8.u.b(r8)
                            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r8 = r7.$pressedInteraction
                            java.lang.Object r8 = r8.getValue()
                            androidx.compose.foundation.interaction.PressInteraction$Press r8 = (androidx.compose.foundation.interaction.PressInteraction.Press) r8
                            if (r8 == 0) goto L4f
                            androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.$interactionSource
                            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r5 = r7.$pressedInteraction
                            androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                            r6.<init>(r8)
                            if (r1 == 0) goto L4c
                            r7.L$0 = r5
                            r7.label = r4
                            java.lang.Object r8 = r1.emit(r6, r7)
                            if (r8 != r0) goto L4a
                            return r0
                        L4a:
                            r1 = r5
                        L4b:
                            r5 = r1
                        L4c:
                            r5.setValue(r2)
                        L4f:
                            androidx.compose.foundation.interaction.PressInteraction$Press r8 = new androidx.compose.foundation.interaction.PressInteraction$Press
                            long r4 = r7.$it
                            r8.<init>(r4, r2)
                            androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.$interactionSource
                            if (r1 == 0) goto L67
                            r7.L$0 = r8
                            r7.label = r3
                            java.lang.Object r1 = r1.emit(r8, r7)
                            if (r1 != r0) goto L65
                            return r0
                        L65:
                            r0 = r8
                        L66:
                            r8 = r0
                        L67:
                            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r0 = r7.$pressedInteraction
                            r0.setValue(r8)
                            v8.k0 r8 = v8.k0.f35197a
                            return r8
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldPressGestureFilterKt.AnonymousClass1.AnonymousClass2.C00641.C00651.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                        return ((C00651) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$2, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
                @f(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$2", f = "TextFieldPressGestureFilter.kt", l = {77}, m = "invokeSuspend")
                static final class C00662 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                    final /* synthetic */ boolean $success;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00662(MutableState<PressInteraction.Press> mutableState, boolean z10, MutableInteractionSource mutableInteractionSource, d<? super C00662> dVar) {
                        super(2, dVar);
                        this.$pressedInteraction = mutableState;
                        this.$success = z10;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                        return new C00662(this.$pressedInteraction, this.$success, this.$interactionSource, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        MutableState<PressInteraction.Press> mutableState;
                        MutableState<PressInteraction.Press> mutableState2;
                        Object objE = a9.d.e();
                        int i10 = this.label;
                        if (i10 == 0) {
                            u.b(obj);
                            PressInteraction.Press value = this.$pressedInteraction.getValue();
                            if (value != null) {
                                boolean z10 = this.$success;
                                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                mutableState = this.$pressedInteraction;
                                Interaction release = z10 ? new PressInteraction.Release(value) : new PressInteraction.Cancel(value);
                                if (mutableInteractionSource != null) {
                                    this.L$0 = mutableState;
                                    this.label = 1;
                                    if (mutableInteractionSource.emit(release, this) == objE) {
                                        return objE;
                                    }
                                    mutableState2 = mutableState;
                                }
                                mutableState.setValue(null);
                            }
                            return k0.f35197a;
                        }
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutableState2 = (MutableState) this.L$0;
                        u.b(obj);
                        mutableState = mutableState2;
                        mutableState.setValue(null);
                        return k0.f35197a;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                        return ((C00662) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00641(o0 o0Var, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, d<? super C00641> dVar) {
                    super(3, dVar);
                    this.$scope = o0Var;
                    this.$pressedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // h9.q
                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, d<? super k0> dVar) {
                    return m730invoked4ec7I(pressGestureScope, offset.m1377unboximpl(), dVar);
                }

                @Nullable
                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final Object m730invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j10, @Nullable d<? super k0> dVar) {
                    C00641 c00641 = new C00641(this.$scope, this.$pressedInteraction, this.$interactionSource, dVar);
                    c00641.L$0 = pressGestureScope;
                    c00641.J$0 = j10;
                    return c00641.invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                        k.d(this.$scope, null, null, new C00651(this.$pressedInteraction, this.J$0, this.$interactionSource, null), 3, null);
                        this.label = 1;
                        obj = pressGestureScope.tryAwaitRelease(this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                    }
                    k.d(this.$scope, null, null, new C00662(this.$pressedInteraction, ((Boolean) obj).booleanValue(), this.$interactionSource, null), 3, null);
                    return k0.f35197a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
            static final class C00672 extends v implements l<Offset, k0> {
                final /* synthetic */ State<l<Offset, k0>> $onTapState;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00672(State<? extends l<? super Offset, k0>> state) {
                    super(1);
                    this.$onTapState = state;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
                    m731invokek4lQ0M(offset.m1377unboximpl());
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m731invokek4lQ0M(long j10) {
                    this.$onTapState.getValue().invoke(Offset.m1356boximpl(j10));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(o0 o0Var, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, State<? extends l<? super Offset, k0>> state, d<? super AnonymousClass2> dVar) {
                super(2, dVar);
                this.$scope = o0Var;
                this.$pressedInteraction = mutableState;
                this.$interactionSource = mutableInteractionSource;
                this.$onTapState = state;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$scope, this.$pressedInteraction, this.$interactionSource, this.$onTapState, dVar);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
                return ((AnonymousClass2) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    C00641 c00641 = new C00641(this.$scope, this.$pressedInteraction, this.$interactionSource, null);
                    C00672 c00672 = new C00672(this.$onTapState);
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapAndPress(pointerInputScope, c00641, c00672, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(l<? super Offset, k0> lVar, MutableInteractionSource mutableInteractionSource) {
            super(3);
            this.$onTap = lVar;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-102778667);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue2;
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onTap, composer, 0);
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            EffectsKt.DisposableEffect(mutableInteractionSource, new C00631(mutableState, mutableInteractionSource), composer, 0);
            Modifier.Companion companion2 = Modifier.Companion;
            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, mutableInteractionSource2, new AnonymousClass2(coroutineScope, mutableState, mutableInteractionSource2, stateRememberUpdatedState, null));
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }
    }

    @NotNull
    public static final Modifier tapPressTextFieldModifier(@NotNull Modifier modifier, @Nullable MutableInteractionSource mutableInteractionSource, boolean z10, @NotNull l<? super Offset, k0> onTap) {
        t.i(modifier, "<this>");
        t.i(onTap, "onTap");
        return z10 ? ComposedModifierKt.composed$default(modifier, null, new AnonymousClass1(onTap, mutableInteractionSource), 1, null) : modifier;
    }

    public static /* synthetic */ Modifier tapPressTextFieldModifier$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return tapPressTextFieldModifier(modifier, mutableInteractionSource, z10, lVar);
    }
}
