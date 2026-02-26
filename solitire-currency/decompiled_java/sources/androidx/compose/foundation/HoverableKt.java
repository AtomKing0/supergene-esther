package androidx.compose.foundation;

import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Hoverable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HoverableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableKt$hoverable$2, reason: invalid class name */
    /* JADX INFO: compiled from: Hoverable.kt */
    static final class AnonymousClass2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;

        /* JADX INFO: renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Hoverable.kt */
        static final class AnonymousClass1 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
            final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
            final /* synthetic */ MutableInteractionSource $interactionSource;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource) {
                super(1);
                this.$hoverInteraction$delegate = mutableState;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // h9.l
            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                t.i(DisposableEffect, "$this$DisposableEffect");
                final MutableState<HoverInteraction.Enter> mutableState = this.$hoverInteraction$delegate;
                final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.HoverableKt$hoverable$2$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        HoverableKt.AnonymousClass2.invoke$tryEmitExit(mutableState, mutableInteractionSource);
                    }
                };
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Hoverable.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.HoverableKt$hoverable$2$2", f = "Hoverable.kt", l = {88}, m = "invokeSuspend")
        static final class C00312 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ boolean $enabled;
            final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
            final /* synthetic */ MutableInteractionSource $interactionSource;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00312(boolean z10, MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource, z8.d<? super C00312> dVar) {
                super(2, dVar);
                this.$enabled = z10;
                this.$hoverInteraction$delegate = mutableState;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C00312(this.$enabled, this.$hoverInteraction$delegate, this.$interactionSource, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    if (!this.$enabled) {
                        MutableState<HoverInteraction.Enter> mutableState = this.$hoverInteraction$delegate;
                        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                        this.label = 1;
                        if (AnonymousClass2.invoke$emitExit(mutableState, mutableInteractionSource, this) == objE) {
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

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C00312) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Hoverable.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.HoverableKt$hoverable$2$3", f = "Hoverable.kt", l = {102}, m = "invokeSuspend")
        static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.l implements h9.p<PointerInputScope, z8.d<? super k0>, Object> {
            final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ o0 $scope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: Hoverable.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.HoverableKt$hoverable$2$3$1", f = "Hoverable.kt", l = {104}, m = "invokeSuspend")
            static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.k implements h9.p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
                final /* synthetic */ z8.g $currentContext;
                final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ o0 $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Hoverable.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.HoverableKt$hoverable$2$3$1$1", f = "Hoverable.kt", l = {106}, m = "invokeSuspend")
                static final class C00321 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
                    final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00321(MutableInteractionSource mutableInteractionSource, MutableState<HoverInteraction.Enter> mutableState, z8.d<? super C00321> dVar) {
                        super(2, dVar);
                        this.$interactionSource = mutableInteractionSource;
                        this.$hoverInteraction$delegate = mutableState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        return new C00321(this.$interactionSource, this.$hoverInteraction$delegate, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object objE = a9.d.e();
                        int i10 = this.label;
                        if (i10 == 0) {
                            u.b(obj);
                            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                            MutableState<HoverInteraction.Enter> mutableState = this.$hoverInteraction$delegate;
                            this.label = 1;
                            if (AnonymousClass2.invoke$emitEnter(mutableInteractionSource, mutableState, this) == objE) {
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
                    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                        return ((C00321) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3$1$2, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Hoverable.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.HoverableKt$hoverable$2$3$1$2", f = "Hoverable.kt", l = {107}, m = "invokeSuspend")
                static final class C00332 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
                    final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00332(MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource, z8.d<? super C00332> dVar) {
                        super(2, dVar);
                        this.$hoverInteraction$delegate = mutableState;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        return new C00332(this.$hoverInteraction$delegate, this.$interactionSource, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object objE = a9.d.e();
                        int i10 = this.label;
                        if (i10 == 0) {
                            u.b(obj);
                            MutableState<HoverInteraction.Enter> mutableState = this.$hoverInteraction$delegate;
                            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                            this.label = 1;
                            if (AnonymousClass2.invoke$emitExit(mutableState, mutableInteractionSource, this) == objE) {
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
                    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                        return ((C00332) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(z8.g gVar, o0 o0Var, MutableInteractionSource mutableInteractionSource, MutableState<HoverInteraction.Enter> mutableState, z8.d<? super AnonymousClass1> dVar) {
                    super(2, dVar);
                    this.$currentContext = gVar;
                    this.$scope = o0Var;
                    this.$interactionSource = mutableInteractionSource;
                    this.$hoverInteraction$delegate = mutableState;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentContext, this.$scope, this.$interactionSource, this.$hoverInteraction$delegate, dVar);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003b -> B:15:0x0040). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.a
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
                    /*
                        r14 = this;
                        java.lang.Object r0 = a9.b.e()
                        int r1 = r14.label
                        r2 = 1
                        r3 = 0
                        if (r1 == 0) goto L1f
                        if (r1 != r2) goto L17
                        java.lang.Object r1 = r14.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        v8.u.b(r15)
                        r4 = r1
                        r1 = r0
                        r0 = r14
                        goto L40
                    L17:
                        java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r15.<init>(r0)
                        throw r15
                    L1f:
                        v8.u.b(r15)
                        java.lang.Object r15 = r14.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r15 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r15
                        r1 = r15
                        r15 = r14
                    L28:
                        z8.g r4 = r15.$currentContext
                        boolean r4 = kotlinx.coroutines.f2.m(r4)
                        if (r4 == 0) goto L85
                        r15.L$0 = r1
                        r15.label = r2
                        java.lang.Object r4 = androidx.compose.ui.input.pointer.b.t(r1, r3, r15, r2, r3)
                        if (r4 != r0) goto L3b
                        return r0
                    L3b:
                        r13 = r0
                        r0 = r15
                        r15 = r4
                        r4 = r1
                        r1 = r13
                    L40:
                        androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
                        int r15 = r15.m2820getType7fucELk()
                        androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                        int r6 = r5.m2831getEnter7fucELk()
                        boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.m2827equalsimpl0(r15, r6)
                        if (r6 == 0) goto L65
                        kotlinx.coroutines.o0 r7 = r0.$scope
                        r8 = 0
                        r9 = 0
                        androidx.compose.foundation.HoverableKt$hoverable$2$3$1$1 r10 = new androidx.compose.foundation.HoverableKt$hoverable$2$3$1$1
                        androidx.compose.foundation.interaction.MutableInteractionSource r15 = r0.$interactionSource
                        androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction$Enter> r5 = r0.$hoverInteraction$delegate
                        r10.<init>(r15, r5, r3)
                        r11 = 3
                        r12 = 0
                        kotlinx.coroutines.i.d(r7, r8, r9, r10, r11, r12)
                        goto L81
                    L65:
                        int r5 = r5.m2832getExit7fucELk()
                        boolean r15 = androidx.compose.ui.input.pointer.PointerEventType.m2827equalsimpl0(r15, r5)
                        if (r15 == 0) goto L81
                        kotlinx.coroutines.o0 r5 = r0.$scope
                        r6 = 0
                        r7 = 0
                        androidx.compose.foundation.HoverableKt$hoverable$2$3$1$2 r8 = new androidx.compose.foundation.HoverableKt$hoverable$2$3$1$2
                        androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction$Enter> r15 = r0.$hoverInteraction$delegate
                        androidx.compose.foundation.interaction.MutableInteractionSource r9 = r0.$interactionSource
                        r8.<init>(r15, r9, r3)
                        r9 = 3
                        r10 = 0
                        kotlinx.coroutines.i.d(r5, r6, r7, r8, r9, r10)
                    L81:
                        r15 = r0
                        r0 = r1
                        r1 = r4
                        goto L28
                    L85:
                        v8.k0 r15 = v8.k0.f35197a
                        return r15
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt.AnonymousClass2.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(o0 o0Var, MutableInteractionSource mutableInteractionSource, MutableState<HoverInteraction.Enter> mutableState, z8.d<? super AnonymousClass3> dVar) {
                super(2, dVar);
                this.$scope = o0Var;
                this.$interactionSource = mutableInteractionSource;
                this.$hoverInteraction$delegate = mutableState;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$scope, this.$interactionSource, this.$hoverInteraction$delegate, dVar);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass3) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(getContext(), this.$scope, this.$interactionSource, this.$hoverInteraction$delegate, null);
                    this.label = 1;
                    if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == objE) {
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
        AnonymousClass2(MutableInteractionSource mutableInteractionSource, boolean z10) {
            super(3);
            this.$interactionSource = mutableInteractionSource;
            this.$enabled = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object invoke$emitEnter(androidx.compose.foundation.interaction.MutableInteractionSource r4, androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction.Enter> r5, z8.d<? super v8.k0> r6) {
            /*
                boolean r0 = r6 instanceof androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1
                if (r0 == 0) goto L13
                r0 = r6
                androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1 r0 = (androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1 r0 = new androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r4 = r0.L$1
                androidx.compose.foundation.interaction.HoverInteraction$Enter r4 = (androidx.compose.foundation.interaction.HoverInteraction.Enter) r4
                java.lang.Object r5 = r0.L$0
                androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
                v8.u.b(r6)
                goto L55
            L31:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L39:
                v8.u.b(r6)
                androidx.compose.foundation.interaction.HoverInteraction$Enter r6 = m210invoke$lambda1(r5)
                if (r6 != 0) goto L58
                androidx.compose.foundation.interaction.HoverInteraction$Enter r6 = new androidx.compose.foundation.interaction.HoverInteraction$Enter
                r6.<init>()
                r0.L$0 = r5
                r0.L$1 = r6
                r0.label = r3
                java.lang.Object r4 = r4.emit(r6, r0)
                if (r4 != r1) goto L54
                return r1
            L54:
                r4 = r6
            L55:
                m211invoke$lambda2(r5, r4)
            L58:
                v8.k0 r4 = v8.k0.f35197a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt.AnonymousClass2.invoke$emitEnter(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.MutableState, z8.d):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object invoke$emitExit(androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction.Enter> r4, androidx.compose.foundation.interaction.MutableInteractionSource r5, z8.d<? super v8.k0> r6) {
            /*
                boolean r0 = r6 instanceof androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1
                if (r0 == 0) goto L13
                r0 = r6
                androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1 r0 = (androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1 r0 = new androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r4 = r0.L$0
                androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
                v8.u.b(r6)
                goto L4e
            L2d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L35:
                v8.u.b(r6)
                androidx.compose.foundation.interaction.HoverInteraction$Enter r6 = m210invoke$lambda1(r4)
                if (r6 == 0) goto L52
                androidx.compose.foundation.interaction.HoverInteraction$Exit r2 = new androidx.compose.foundation.interaction.HoverInteraction$Exit
                r2.<init>(r6)
                r0.L$0 = r4
                r0.label = r3
                java.lang.Object r5 = r5.emit(r2, r0)
                if (r5 != r1) goto L4e
                return r1
            L4e:
                r5 = 0
                m211invoke$lambda2(r4, r5)
            L52:
                v8.k0 r4 = v8.k0.f35197a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt.AnonymousClass2.invoke$emitExit(androidx.compose.runtime.MutableState, androidx.compose.foundation.interaction.MutableInteractionSource, z8.d):java.lang.Object");
        }

        /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
        private static final HoverInteraction.Enter m210invoke$lambda1(MutableState<HoverInteraction.Enter> mutableState) {
            return mutableState.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$tryEmitExit(MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource) {
            HoverInteraction.Enter enterM210invoke$lambda1 = m210invoke$lambda1(mutableState);
            if (enterM210invoke$lambda1 != null) {
                mutableInteractionSource.tryEmit(new HoverInteraction.Exit(enterM210invoke$lambda1));
                mutableState.setValue(null);
            }
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            Modifier modifierPointerInput;
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1294013553);
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
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            EffectsKt.DisposableEffect(mutableInteractionSource, new AnonymousClass1(mutableState, mutableInteractionSource), composer, 0);
            EffectsKt.LaunchedEffect(Boolean.valueOf(this.$enabled), new C00312(this.$enabled, mutableState, this.$interactionSource, null), composer, 0);
            if (this.$enabled) {
                Modifier.Companion companion2 = Modifier.Companion;
                MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
                modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, mutableInteractionSource2, new AnonymousClass3(coroutineScope, mutableInteractionSource2, mutableState, null));
            } else {
                modifierPointerInput = Modifier.Companion;
            }
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }
    }

    @NotNull
    public static final Modifier hoverable(@NotNull Modifier modifier, @NotNull MutableInteractionSource interactionSource, boolean z10) {
        t.i(modifier, "<this>");
        t.i(interactionSource, "interactionSource");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new HoverableKt$hoverable$$inlined$debugInspectorInfo$1(interactionSource, z10) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(interactionSource, z10));
    }

    public static /* synthetic */ Modifier hoverable$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return hoverable(modifier, mutableInteractionSource, z10);
    }
}
