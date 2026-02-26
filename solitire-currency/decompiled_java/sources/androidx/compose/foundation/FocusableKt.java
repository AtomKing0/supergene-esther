package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Focusable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusableKt {

    @NotNull
    private static final InspectableModifier focusGroupInspectorInfo;

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: Focusable.kt */
    static final class AnonymousClass1 extends v implements h9.l<FocusProperties, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(FocusProperties focusProperties) {
            invoke2(focusProperties);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull FocusProperties focusProperties) {
            t.i(focusProperties, "$this$focusProperties");
            focusProperties.setCanFocus(false);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2, reason: invalid class name */
    /* JADX INFO: compiled from: Focusable.kt */
    static final class AnonymousClass2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;

        /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Focusable.kt */
        static final class AnonymousClass1 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
            final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
            final /* synthetic */ MutableInteractionSource $interactionSource;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource) {
                super(1);
                this.$focusedInteraction = mutableState;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // h9.l
            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                t.i(DisposableEffect, "$this$DisposableEffect");
                final MutableState<FocusInteraction.Focus> mutableState = this.$focusedInteraction;
                final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        FocusInteraction.Focus focus = (FocusInteraction.Focus) mutableState.getValue();
                        if (focus != null) {
                            FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(focus);
                            MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                            if (mutableInteractionSource2 != null) {
                                mutableInteractionSource2.tryEmit(unfocus);
                            }
                            mutableState.setValue(null);
                        }
                    }
                };
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Focusable.kt */
        static final class C00292 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
            final /* synthetic */ boolean $enabled;
            final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ o0 $scope;

            /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: Focusable.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.FocusableKt$focusable$2$2$1", f = "Focusable.kt", l = {105}, m = "invokeSuspend")
            static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
                final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, z8.d<? super AnonymousClass1> dVar) {
                    super(2, dVar);
                    this.$focusedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    MutableState<FocusInteraction.Focus> mutableState;
                    MutableState<FocusInteraction.Focus> mutableState2;
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        FocusInteraction.Focus value = this.$focusedInteraction.getValue();
                        if (value != null) {
                            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                            mutableState = this.$focusedInteraction;
                            FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                            if (mutableInteractionSource != null) {
                                this.L$0 = mutableState;
                                this.label = 1;
                                if (mutableInteractionSource.emit(unfocus, this) == objE) {
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
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00292(boolean z10, o0 o0Var, MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource) {
                super(1);
                this.$enabled = z10;
                this.$scope = o0Var;
                this.$focusedInteraction = mutableState;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // h9.l
            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                t.i(DisposableEffect, "$this$DisposableEffect");
                if (!this.$enabled) {
                    kotlinx.coroutines.k.d(this.$scope, null, null, new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, null), 3, null);
                }
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Focusable.kt */
        static final class AnonymousClass3 extends v implements h9.l<SemanticsPropertyReceiver, k0> {
            final /* synthetic */ FocusRequester $focusRequester;
            final /* synthetic */ MutableState<Boolean> $isFocused$delegate;

            /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: Focusable.kt */
            static final class AnonymousClass1 extends v implements h9.a<Boolean> {
                final /* synthetic */ FocusRequester $focusRequester;
                final /* synthetic */ MutableState<Boolean> $isFocused$delegate;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(FocusRequester focusRequester, MutableState<Boolean> mutableState) {
                    super(0);
                    this.$focusRequester = focusRequester;
                    this.$isFocused$delegate = mutableState;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // h9.a
                @NotNull
                public final Boolean invoke() {
                    this.$focusRequester.requestFocus();
                    return Boolean.valueOf(AnonymousClass2.m208invoke$lambda5(this.$isFocused$delegate));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(MutableState<Boolean> mutableState, FocusRequester focusRequester) {
                super(1);
                this.$isFocused$delegate = mutableState;
                this.$focusRequester = focusRequester;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                t.i(semantics, "$this$semantics");
                SemanticsPropertiesKt.setFocused(semantics, AnonymousClass2.m208invoke$lambda5(this.$isFocused$delegate));
                SemanticsPropertiesKt.requestFocus$default(semantics, null, new AnonymousClass1(this.$focusRequester, this.$isFocused$delegate), 1, null);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: Focusable.kt */
        static final class AnonymousClass4 extends v implements h9.l<PinnableParent, k0> {
            final /* synthetic */ MutableState<PinnableParent> $pinnableParent$delegate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(MutableState<PinnableParent> mutableState) {
                super(1);
                this.$pinnableParent$delegate = mutableState;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(PinnableParent pinnableParent) {
                invoke2(pinnableParent);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable PinnableParent pinnableParent) {
                AnonymousClass2.m207invoke$lambda3(this.$pinnableParent$delegate, pinnableParent);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: Focusable.kt */
        static final class AnonymousClass5 extends v implements h9.l<FocusState, k0> {
            final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
            final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ MutableState<Boolean> $isFocused$delegate;
            final /* synthetic */ MutableState<PinnableParent> $pinnableParent$delegate;
            final /* synthetic */ o0 $scope;

            /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: Focusable.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$1", f = "Focusable.kt", l = {144}, m = "invokeSuspend")
            static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
                final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                final /* synthetic */ MutableState<PinnableParent> $pinnableParent$delegate;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(BringIntoViewRequester bringIntoViewRequester, MutableState<PinnableParent> mutableState, z8.d<? super AnonymousClass1> dVar) {
                    super(2, dVar);
                    this.$bringIntoViewRequester = bringIntoViewRequester;
                    this.$pinnableParent$delegate = mutableState;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new AnonymousClass1(this.$bringIntoViewRequester, this.$pinnableParent$delegate, dVar);
                }

                /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
                @Override // kotlin.coroutines.jvm.internal.a
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        java.lang.Object r0 = a9.b.e()
                        int r1 = r5.label
                        r2 = 1
                        if (r1 == 0) goto L1d
                        if (r1 != r2) goto L15
                        java.lang.Object r0 = r5.L$0
                        androidx.compose.foundation.lazy.layout.PinnableParent$PinnedItemsHandle r0 = (androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle) r0
                        v8.u.b(r6)     // Catch: java.lang.Throwable -> L13
                        goto L3d
                    L13:
                        r6 = move-exception
                        goto L4c
                    L15:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r0)
                        throw r6
                    L1d:
                        v8.u.b(r6)
                        r6 = 0
                        androidx.compose.runtime.MutableState<androidx.compose.foundation.lazy.layout.PinnableParent> r1 = r5.$pinnableParent$delegate     // Catch: java.lang.Throwable -> L48
                        androidx.compose.foundation.lazy.layout.PinnableParent r1 = androidx.compose.foundation.FocusableKt.AnonymousClass2.m202access$invoke$lambda2(r1)     // Catch: java.lang.Throwable -> L48
                        if (r1 == 0) goto L2e
                        androidx.compose.foundation.lazy.layout.PinnableParent$PinnedItemsHandle r1 = r1.pinItems()     // Catch: java.lang.Throwable -> L48
                        goto L2f
                    L2e:
                        r1 = r6
                    L2f:
                        androidx.compose.foundation.relocation.BringIntoViewRequester r3 = r5.$bringIntoViewRequester     // Catch: java.lang.Throwable -> L45
                        r5.L$0 = r1     // Catch: java.lang.Throwable -> L45
                        r5.label = r2     // Catch: java.lang.Throwable -> L45
                        java.lang.Object r6 = androidx.compose.foundation.relocation.a.a(r3, r6, r5, r2, r6)     // Catch: java.lang.Throwable -> L45
                        if (r6 != r0) goto L3c
                        return r0
                    L3c:
                        r0 = r1
                    L3d:
                        if (r0 == 0) goto L42
                        r0.unpin()
                    L42:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    L45:
                        r6 = move-exception
                        r0 = r1
                        goto L4c
                    L48:
                        r0 = move-exception
                        r4 = r0
                        r0 = r6
                        r6 = r4
                    L4c:
                        if (r0 == 0) goto L51
                        r0.unpin()
                    L51:
                        throw r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableKt.AnonymousClass2.AnonymousClass5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Focusable.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$2", f = "Focusable.kt", l = {152, 156}, m = "invokeSuspend")
            static final class C00302 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
                final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00302(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, z8.d<? super C00302> dVar) {
                    super(2, dVar);
                    this.$focusedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C00302(this.$focusedInteraction, this.$interactionSource, dVar);
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
                @Override // kotlin.coroutines.jvm.internal.a
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
                    /*
                        r6 = this;
                        java.lang.Object r0 = a9.b.e()
                        int r1 = r6.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L26
                        if (r1 == r3) goto L1e
                        if (r1 != r2) goto L16
                        java.lang.Object r0 = r6.L$0
                        androidx.compose.foundation.interaction.FocusInteraction$Focus r0 = (androidx.compose.foundation.interaction.FocusInteraction.Focus) r0
                        v8.u.b(r7)
                        goto L64
                    L16:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r0)
                        throw r7
                    L1e:
                        java.lang.Object r1 = r6.L$0
                        androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
                        v8.u.b(r7)
                        goto L4a
                    L26:
                        v8.u.b(r7)
                        androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r7 = r6.$focusedInteraction
                        java.lang.Object r7 = r7.getValue()
                        androidx.compose.foundation.interaction.FocusInteraction$Focus r7 = (androidx.compose.foundation.interaction.FocusInteraction.Focus) r7
                        if (r7 == 0) goto L4f
                        androidx.compose.foundation.interaction.MutableInteractionSource r1 = r6.$interactionSource
                        androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r4 = r6.$focusedInteraction
                        androidx.compose.foundation.interaction.FocusInteraction$Unfocus r5 = new androidx.compose.foundation.interaction.FocusInteraction$Unfocus
                        r5.<init>(r7)
                        if (r1 == 0) goto L4b
                        r6.L$0 = r4
                        r6.label = r3
                        java.lang.Object r7 = r1.emit(r5, r6)
                        if (r7 != r0) goto L49
                        return r0
                    L49:
                        r1 = r4
                    L4a:
                        r4 = r1
                    L4b:
                        r7 = 0
                        r4.setValue(r7)
                    L4f:
                        androidx.compose.foundation.interaction.FocusInteraction$Focus r7 = new androidx.compose.foundation.interaction.FocusInteraction$Focus
                        r7.<init>()
                        androidx.compose.foundation.interaction.MutableInteractionSource r1 = r6.$interactionSource
                        if (r1 == 0) goto L65
                        r6.L$0 = r7
                        r6.label = r2
                        java.lang.Object r1 = r1.emit(r7, r6)
                        if (r1 != r0) goto L63
                        return r0
                    L63:
                        r0 = r7
                    L64:
                        r7 = r0
                    L65:
                        androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r0 = r6.$focusedInteraction
                        r0.setValue(r7)
                        v8.k0 r7 = v8.k0.f35197a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableKt.AnonymousClass2.AnonymousClass5.C00302.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((C00302) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$3, reason: invalid class name */
            /* JADX INFO: compiled from: Focusable.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$3", f = "Focusable.kt", l = {163}, m = "invokeSuspend")
            static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
                final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, z8.d<? super AnonymousClass3> dVar) {
                    super(2, dVar);
                    this.$focusedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new AnonymousClass3(this.$focusedInteraction, this.$interactionSource, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    MutableState<FocusInteraction.Focus> mutableState;
                    MutableState<FocusInteraction.Focus> mutableState2;
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        FocusInteraction.Focus value = this.$focusedInteraction.getValue();
                        if (value != null) {
                            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                            mutableState = this.$focusedInteraction;
                            FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                            if (mutableInteractionSource != null) {
                                this.L$0 = mutableState;
                                this.label = 1;
                                if (mutableInteractionSource.emit(unfocus, this) == objE) {
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
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(o0 o0Var, MutableState<Boolean> mutableState, BringIntoViewRequester bringIntoViewRequester, MutableState<PinnableParent> mutableState2, MutableState<FocusInteraction.Focus> mutableState3, MutableInteractionSource mutableInteractionSource) {
                super(1);
                this.$scope = o0Var;
                this.$isFocused$delegate = mutableState;
                this.$bringIntoViewRequester = bringIntoViewRequester;
                this.$pinnableParent$delegate = mutableState2;
                this.$focusedInteraction = mutableState3;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(FocusState focusState) {
                invoke2(focusState);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FocusState it) {
                t.i(it, "it");
                AnonymousClass2.m209invoke$lambda6(this.$isFocused$delegate, it.isFocused());
                if (!AnonymousClass2.m208invoke$lambda5(this.$isFocused$delegate)) {
                    kotlinx.coroutines.k.d(this.$scope, null, null, new AnonymousClass3(this.$focusedInteraction, this.$interactionSource, null), 3, null);
                } else {
                    kotlinx.coroutines.k.d(this.$scope, null, q0.UNDISPATCHED, new AnonymousClass1(this.$bringIntoViewRequester, this.$pinnableParent$delegate, null), 1, null);
                    kotlinx.coroutines.k.d(this.$scope, null, null, new C00302(this.$focusedInteraction, this.$interactionSource, null), 3, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableInteractionSource mutableInteractionSource, boolean z10) {
            super(3);
            this.$interactionSource = mutableInteractionSource;
            this.$enabled = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
        public static final PinnableParent m206invoke$lambda2(MutableState<PinnableParent> mutableState) {
            return mutableState.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-3, reason: not valid java name */
        public static final void m207invoke$lambda3(MutableState<PinnableParent> mutableState, PinnableParent pinnableParent) {
            mutableState.setValue(pinnableParent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-5, reason: not valid java name */
        public static final boolean m208invoke$lambda5(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-6, reason: not valid java name */
        public static final void m209invoke$lambda6(MutableState<Boolean> mutableState, boolean z10) {
            mutableState.setValue(Boolean.valueOf(z10));
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            Modifier modifierFocusTarget;
            Modifier modifier;
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1871352361);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(z8.h.f37608a, composer));
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
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            MutableState mutableState3 = (MutableState) objRememberedValue4;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new FocusRequester();
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            FocusRequester focusRequester = (FocusRequester) objRememberedValue5;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = BringIntoViewRequesterKt.BringIntoViewRequester();
                composer.updateRememberedValue(objRememberedValue6);
            }
            composer.endReplaceableGroup();
            BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) objRememberedValue6;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            EffectsKt.DisposableEffect(mutableInteractionSource, new AnonymousClass1(mutableState, mutableInteractionSource), composer, 0);
            EffectsKt.DisposableEffect(Boolean.valueOf(this.$enabled), new C00292(this.$enabled, coroutineScope, mutableState, this.$interactionSource), composer, 0);
            if (this.$enabled) {
                if (m208invoke$lambda5(mutableState3)) {
                    composer.startReplaceableGroup(-492369756);
                    Object objRememberedValue7 = composer.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new FocusedBoundsModifier();
                        composer.updateRememberedValue(objRememberedValue7);
                    }
                    composer.endReplaceableGroup();
                    modifier = (Modifier) objRememberedValue7;
                } else {
                    modifier = Modifier.Companion;
                }
                modifierFocusTarget = FocusModifierKt.focusTarget(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(BringIntoViewRequesterKt.bringIntoViewRequester(FocusableKt.onPinnableParentAvailable(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new AnonymousClass3(mutableState3, focusRequester), 1, null), new AnonymousClass4(mutableState2)), bringIntoViewRequester), focusRequester).then(modifier), new AnonymousClass5(coroutineScope, mutableState3, bringIntoViewRequester, mutableState2, mutableState, this.$interactionSource)));
            } else {
                modifierFocusTarget = Modifier.Companion;
            }
            composer.endReplaceableGroup();
            return modifierFocusTarget;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusableInNonTouchMode$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Focusable.kt */
    static final class C08242 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;

        /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusableInNonTouchMode$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Focusable.kt */
        static final class AnonymousClass1 extends v implements h9.l<FocusProperties, k0> {
            final /* synthetic */ InputModeManager $inputModeManager;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(InputModeManager inputModeManager) {
                super(1);
                this.$inputModeManager = inputModeManager;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(FocusProperties focusProperties) {
                invoke2(focusProperties);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FocusProperties focusProperties) {
                t.i(focusProperties, "$this$focusProperties");
                focusProperties.setCanFocus(!InputMode.m2153equalsimpl0(this.$inputModeManager.mo2159getInputModeaOaMEAU(), InputMode.Companion.m2158getTouchaOaMEAU()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08242(boolean z10, MutableInteractionSource mutableInteractionSource) {
            super(3);
            this.$enabled = z10;
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
            composer.startReplaceableGroup(-618949501);
            Modifier modifierFocusable = FocusableKt.focusable(FocusPropertiesKt.focusProperties(Modifier.Companion, new AnonymousClass1((InputModeManager) composer.consume(CompositionLocalsKt.getLocalInputModeManager()))), this.$enabled, this.$interactionSource);
            composer.endReplaceableGroup();
            return modifierFocusable;
        }
    }

    static {
        focusGroupInspectorInfo = new InspectableModifier(InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusableKt$special$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo());
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier focusGroup(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return FocusModifierKt.focusTarget(FocusPropertiesKt.focusProperties(modifier.then(focusGroupInspectorInfo), AnonymousClass1.INSTANCE));
    }

    @NotNull
    public static final Modifier focusable(@NotNull Modifier modifier, boolean z10, @Nullable MutableInteractionSource mutableInteractionSource) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusableKt$focusable$$inlined$debugInspectorInfo$1(z10, mutableInteractionSource) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(mutableInteractionSource, z10));
    }

    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z10, MutableInteractionSource mutableInteractionSource, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z10, mutableInteractionSource);
    }

    @NotNull
    public static final Modifier focusableInNonTouchMode(@NotNull Modifier modifier, boolean z10, @Nullable MutableInteractionSource mutableInteractionSource) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusableKt$focusableInNonTouchMode$$inlined$debugInspectorInfo$1(z10, mutableInteractionSource) : InspectableValueKt.getNoInspectorInfo(), new C08242(z10, mutableInteractionSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Stable
    @ExperimentalFoundationApi
    public static final Modifier onPinnableParentAvailable(Modifier modifier, h9.l<? super PinnableParent, k0> lVar) {
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusableKt$onPinnableParentAvailable$$inlined$debugInspectorInfo$1(lVar) : InspectableValueKt.getNoInspectorInfo(), Modifier.Companion.then(new PinnableParentConsumer(lVar)));
    }
}
