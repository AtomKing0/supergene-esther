package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
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
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Velocity;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.g;
import v8.k0;
import v8.s;
import v8.u;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt", f = "Draggable.kt", l = {315, 324, 333, 335}, m = "awaitDownAndSlop")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableKt.awaitDownAndSlop(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$1", f = "Draggable.kt", l = {}, m = "invokeSuspend")
    public static final class C08411 extends l implements q<o0, Offset, z8.d<? super k0>, Object> {
        int label;

        C08411(z8.d<? super C08411> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(o0 o0Var, Offset offset, z8.d<? super k0> dVar) {
            return m272invoked4ec7I(o0Var, offset.m1377unboximpl(), dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m272invoked4ec7I(@NotNull o0 o0Var, long j10, @Nullable z8.d<? super k0> dVar) {
            return new C08411(dVar).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$2, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$2", f = "Draggable.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends l implements q<o0, Float, z8.d<? super k0>, Object> {
        int label;

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(o0 o0Var, Float f10, z8.d<? super k0> dVar) {
            return invoke(o0Var, f10.floatValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k0.f35197a;
        }

        @Nullable
        public final Object invoke(@NotNull o0 o0Var, float f10, @Nullable z8.d<? super k0> dVar) {
            return new AnonymousClass2(dVar).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$3, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, PointerAwareDraggableState> {
        final /* synthetic */ DraggableState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(DraggableState draggableState) {
            super(2);
            this.$state = draggableState;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ PointerAwareDraggableState mo4invoke(Composer composer, Integer num) {
            return invoke(composer, num.intValue());
        }

        @Composable
        @NotNull
        public final PointerAwareDraggableState invoke(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(830271906);
            DraggableState draggableState = this.$state;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(draggableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new IgnorePointerDraggableState(draggableState);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            IgnorePointerDraggableState ignorePointerDraggableState = (IgnorePointerDraggableState) objRememberedValue;
            composer.endReplaceableGroup();
            return ignorePointerDraggableState;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$4, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    static final class AnonymousClass4 extends v implements h9.l<PointerInputChange, Boolean> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull PointerInputChange it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$5, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    static final class AnonymousClass5 extends v implements h9.a<Boolean> {
        final /* synthetic */ boolean $startDragImmediately;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(0);
            this.$startDragImmediately = z10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(this.$startDragImmediately);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$6, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$6", f = "Draggable.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass6 extends l implements q<o0, Offset, z8.d<? super k0>, Object> {
        int label;

        AnonymousClass6(z8.d<? super AnonymousClass6> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(o0 o0Var, Offset offset, z8.d<? super k0> dVar) {
            return m273invoked4ec7I(o0Var, offset.m1377unboximpl(), dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m273invoked4ec7I(@NotNull o0 o0Var, long j10, @Nullable z8.d<? super k0> dVar) {
            return new AnonymousClass6(dVar).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$7, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$7", f = "Draggable.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass7 extends l implements q<o0, Float, z8.d<? super k0>, Object> {
        int label;

        AnonymousClass7(z8.d<? super AnonymousClass7> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(o0 o0Var, Float f10, z8.d<? super k0> dVar) {
            return invoke(o0Var, f10.floatValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k0.f35197a;
        }

        @Nullable
        public final Object invoke(@NotNull o0 o0Var, float f10, @Nullable z8.d<? super k0> dVar) {
            return new AnonymousClass7(dVar).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    static final class AnonymousClass9 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ h9.l<PointerInputChange, Boolean> $canDrag;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ q<o0, Offset, z8.d<? super k0>, Object> $onDragStarted;
        final /* synthetic */ q<o0, Float, z8.d<? super k0>, Object> $onDragStopped;
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ boolean $reverseDirection;
        final /* synthetic */ h9.a<Boolean> $startDragImmediately;
        final /* synthetic */ p<Composer, Integer, PointerAwareDraggableState> $stateFactory;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$1, reason: invalid class name */
        /* JADX INFO: compiled from: Draggable.kt */
        static final class AnonymousClass1 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
            final /* synthetic */ MutableState<DragInteraction.Start> $draggedInteraction;
            final /* synthetic */ MutableInteractionSource $interactionSource;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MutableState<DragInteraction.Start> mutableState, MutableInteractionSource mutableInteractionSource) {
                super(1);
                this.$draggedInteraction = mutableState;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // h9.l
            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                t.i(DisposableEffect, "$this$DisposableEffect");
                final MutableState<DragInteraction.Start> mutableState = this.$draggedInteraction;
                final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$9$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        DragInteraction.Start start = (DragInteraction.Start) mutableState.getValue();
                        if (start != null) {
                            MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                            if (mutableInteractionSource2 != null) {
                                mutableInteractionSource2.tryEmit(new DragInteraction.Cancel(start));
                            }
                            mutableState.setValue(null);
                        }
                    }
                };
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$2, reason: invalid class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$2", f = "Draggable.kt", l = {237, 239, 241, 251, 253, 257}, m = "invokeSuspend")
        static final class AnonymousClass2 extends l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ r9.d<DragEvent> $channel;
            final /* synthetic */ State<DragLogic> $dragLogic$delegate;
            final /* synthetic */ PointerAwareDraggableState $state;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Draggable.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$2$2", f = "Draggable.kt", l = {246}, m = "invokeSuspend")
            static final class C00412 extends l implements p<PointerAwareDragScope, z8.d<? super k0>, Object> {
                final /* synthetic */ r9.d<DragEvent> $channel;
                final /* synthetic */ n0<DragEvent> $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00412(n0<DragEvent> n0Var, r9.d<DragEvent> dVar, z8.d<? super C00412> dVar2) {
                    super(2, dVar2);
                    this.$event = n0Var;
                    this.$channel = dVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    C00412 c00412 = new C00412(this.$event, this.$channel, dVar);
                    c00412.L$0 = obj;
                    return c00412;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull PointerAwareDragScope pointerAwareDragScope, @Nullable z8.d<? super k0> dVar) {
                    return ((C00412) create(pointerAwareDragScope, dVar)).invokeSuspend(k0.f35197a);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005e -> B:23:0x0064). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.a
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
                    /*
                        r8 = this;
                        java.lang.Object r0 = a9.b.e()
                        int r1 = r8.label
                        r2 = 1
                        if (r1 == 0) goto L23
                        if (r1 != r2) goto L1b
                        java.lang.Object r1 = r8.L$1
                        kotlin.jvm.internal.n0 r1 = (kotlin.jvm.internal.n0) r1
                        java.lang.Object r3 = r8.L$0
                        androidx.compose.foundation.gestures.PointerAwareDragScope r3 = (androidx.compose.foundation.gestures.PointerAwareDragScope) r3
                        v8.u.b(r9)
                        r4 = r3
                        r3 = r1
                        r1 = r0
                        r0 = r8
                        goto L64
                    L1b:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L23:
                        v8.u.b(r9)
                        java.lang.Object r9 = r8.L$0
                        androidx.compose.foundation.gestures.PointerAwareDragScope r9 = (androidx.compose.foundation.gestures.PointerAwareDragScope) r9
                        r3 = r9
                        r9 = r8
                    L2c:
                        kotlin.jvm.internal.n0<androidx.compose.foundation.gestures.DragEvent> r1 = r9.$event
                        T r1 = r1.f29834a
                        boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                        if (r4 != 0) goto L6a
                        boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                        if (r4 != 0) goto L6a
                        boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                        if (r4 == 0) goto L3f
                        androidx.compose.foundation.gestures.DragEvent$DragDelta r1 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r1
                        goto L40
                    L3f:
                        r1 = 0
                    L40:
                        if (r1 == 0) goto L4d
                        float r4 = r1.getDelta()
                        long r5 = r1.m243getPointerPositionF1C5BW0()
                        r3.mo276dragByUv8p0NA(r4, r5)
                    L4d:
                        kotlin.jvm.internal.n0<androidx.compose.foundation.gestures.DragEvent> r1 = r9.$event
                        r9.d<androidx.compose.foundation.gestures.DragEvent> r4 = r9.$channel
                        r9.L$0 = r3
                        r9.L$1 = r1
                        r9.label = r2
                        java.lang.Object r4 = r4.s(r9)
                        if (r4 != r0) goto L5e
                        return r0
                    L5e:
                        r7 = r0
                        r0 = r9
                        r9 = r4
                        r4 = r3
                        r3 = r1
                        r1 = r7
                    L64:
                        r3.f29834a = r9
                        r9 = r0
                        r0 = r1
                        r3 = r4
                        goto L2c
                    L6a:
                        v8.k0 r9 = v8.k0.f35197a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.AnonymousClass9.AnonymousClass2.C00412.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(r9.d<DragEvent> dVar, PointerAwareDraggableState pointerAwareDraggableState, State<DragLogic> state, z8.d<? super AnonymousClass2> dVar2) {
                super(2, dVar2);
                this.$channel = dVar;
                this.$state = pointerAwareDraggableState;
                this.$dragLogic$delegate = state;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$channel, this.$state, this.$dragLogic$delegate, dVar);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00c5 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00d4 A[Catch: CancellationException -> 0x0100, TryCatch #0 {CancellationException -> 0x0100, blocks: (B:38:0x00c8, B:40:0x00d4, B:45:0x00ea, B:47:0x00ee), top: B:61:0x00c8 }] */
            /* JADX WARN: Removed duplicated region for block: B:45:0x00ea A[Catch: CancellationException -> 0x0100, TryCatch #0 {CancellationException -> 0x0100, blocks: (B:38:0x00c8, B:40:0x00d4, B:45:0x00ea, B:47:0x00ee), top: B:61:0x00c8 }] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0117 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0118  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x011c  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0120  */
            /* JADX WARN: Type inference failed for: r10v11, types: [T] */
            /* JADX WARN: Type inference failed for: r10v14 */
            /* JADX WARN: Type inference failed for: r10v16, types: [androidx.compose.foundation.gestures.DragLogic] */
            /* JADX WARN: Type inference failed for: r10v18, types: [java.lang.Object, kotlinx.coroutines.o0] */
            /* JADX WARN: Type inference failed for: r10v2, types: [androidx.compose.foundation.gestures.DragLogic] */
            /* JADX WARN: Type inference failed for: r10v20 */
            /* JADX WARN: Type inference failed for: r10v25 */
            /* JADX WARN: Type inference failed for: r10v26 */
            /* JADX WARN: Type inference failed for: r10v27 */
            /* JADX WARN: Type inference failed for: r10v29 */
            /* JADX WARN: Type inference failed for: r10v30 */
            /* JADX WARN: Type inference failed for: r10v4 */
            /* JADX WARN: Type inference failed for: r10v6 */
            /* JADX WARN: Type inference failed for: r10v7 */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1 */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v17 */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, kotlinx.coroutines.o0] */
            /* JADX WARN: Type inference failed for: r1v31 */
            /* JADX WARN: Type inference failed for: r1v34 */
            /* JADX WARN: Type inference failed for: r1v41 */
            /* JADX WARN: Type inference failed for: r1v42 */
            /* JADX WARN: Type inference failed for: r1v43 */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r3v18 */
            /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, kotlinx.coroutines.o0] */
            /* JADX WARN: Type inference failed for: r3v5 */
            /* JADX WARN: Type inference failed for: r4v10 */
            /* JADX WARN: Type inference failed for: r4v11 */
            /* JADX WARN: Type inference failed for: r4v12 */
            /* JADX WARN: Type inference failed for: r4v2, types: [androidx.compose.foundation.gestures.DragLogic] */
            /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlinx.coroutines.o0] */
            /* JADX WARN: Type inference failed for: r4v7 */
            /* JADX WARN: Type inference failed for: r8v2 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00fc -> B:22:0x0067). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0118 -> B:22:0x0067). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011c -> B:22:0x0067). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
                /*
                    Method dump skipped, instruction units count: 310
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.AnonymousClass9.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3, reason: invalid class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3", f = "Draggable.kt", l = {263}, m = "invokeSuspend")
        static final class AnonymousClass3 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
            final /* synthetic */ State<h9.l<PointerInputChange, Boolean>> $canDragState;
            final /* synthetic */ r9.d<DragEvent> $channel;
            final /* synthetic */ boolean $enabled;
            final /* synthetic */ Orientation $orientation;
            final /* synthetic */ boolean $reverseDirection;
            final /* synthetic */ State<h9.a<Boolean>> $startImmediatelyState;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: Draggable.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1", f = "Draggable.kt", l = {265}, m = "invokeSuspend")
            static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
                final /* synthetic */ PointerInputScope $$this$pointerInput;
                final /* synthetic */ State<h9.l<PointerInputChange, Boolean>> $canDragState;
                final /* synthetic */ r9.d<DragEvent> $channel;
                final /* synthetic */ Orientation $orientation;
                final /* synthetic */ boolean $reverseDirection;
                final /* synthetic */ State<h9.a<Boolean>> $startImmediatelyState;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Draggable.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1", f = "Draggable.kt", l = {268, 276}, m = "invokeSuspend")
                static final class C00421 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
                    final /* synthetic */ o0 $$this$coroutineScope;
                    final /* synthetic */ State<h9.l<PointerInputChange, Boolean>> $canDragState;
                    final /* synthetic */ r9.d<DragEvent> $channel;
                    final /* synthetic */ Orientation $orientation;
                    final /* synthetic */ boolean $reverseDirection;
                    final /* synthetic */ State<h9.a<Boolean>> $startImmediatelyState;
                    int I$0;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    boolean Z$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C00421(o0 o0Var, State<? extends h9.l<? super PointerInputChange, Boolean>> state, State<? extends h9.a<Boolean>> state2, Orientation orientation, r9.d<DragEvent> dVar, boolean z10, z8.d<? super C00421> dVar2) {
                        super(2, dVar2);
                        this.$$this$coroutineScope = o0Var;
                        this.$canDragState = state;
                        this.$startImmediatelyState = state2;
                        this.$orientation = orientation;
                        this.$channel = dVar;
                        this.$reverseDirection = z10;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        C00421 c00421 = new C00421(this.$$this$coroutineScope, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, dVar);
                        c00421.L$0 = obj;
                        return c00421;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                        return ((C00421) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                    }

                    /* JADX WARN: Can't wrap try/catch for region: R(8:25|(1:27)(1:28)|81|29|30|79|31|(1:33)(8:34|78|35|(0)(0)|43|59|17|(2:71|72)(0))) */
                    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fc, code lost:
                    
                        r0 = th;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fe, code lost:
                    
                        r0 = e;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
                    
                        r14 = r2;
                        r11 = r7;
                        r2 = r15;
                        r9 = r10;
                        r10 = r17;
                        r8 = r18;
                        r13 = r19;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:50:0x010b, code lost:
                    
                        r0 = th;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:51:0x010c, code lost:
                    
                        r17 = r11;
                        r18 = r12;
                        r20 = r14;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:52:0x0112, code lost:
                    
                        r11 = r7;
                        r10 = r17;
                        r8 = r18;
                        r12 = r20;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:53:0x011a, code lost:
                    
                        r0 = e;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:54:0x011b, code lost:
                    
                        r20 = r14;
                        r14 = r2;
                        r11 = r7;
                        r2 = r15;
                        r9 = r10;
                        r10 = r11;
                        r8 = r12;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:55:0x012e, code lost:
                    
                        r12 = r20;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
                    /* JADX WARN: Removed duplicated region for block: B:37:0x00df  */
                    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x0136  */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x013f A[Catch: all -> 0x0140, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0140, blocks: (B:56:0x0130, B:60:0x013f), top: B:73:0x0130 }] */
                    /* JADX WARN: Removed duplicated region for block: B:63:0x0143  */
                    /* JADX WARN: Removed duplicated region for block: B:67:0x0156  */
                    /* JADX WARN: Removed duplicated region for block: B:70:0x015c  */
                    /* JADX WARN: Removed duplicated region for block: B:71:0x0162  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c9 -> B:78:0x00d7). Please report as a decompilation issue!!! */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0136 -> B:59:0x013b). Please report as a decompilation issue!!! */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x015c -> B:17:0x0062). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.a
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) throws java.lang.Throwable {
                        /*
                            Method dump skipped, instruction units count: 357
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.AnonymousClass9.AnonymousClass3.AnonymousClass1.C00421.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(PointerInputScope pointerInputScope, State<? extends h9.l<? super PointerInputChange, Boolean>> state, State<? extends h9.a<Boolean>> state2, Orientation orientation, r9.d<DragEvent> dVar, boolean z10, z8.d<? super AnonymousClass1> dVar2) {
                    super(2, dVar2);
                    this.$$this$pointerInput = pointerInputScope;
                    this.$canDragState = state;
                    this.$startImmediatelyState = state2;
                    this.$orientation = orientation;
                    this.$channel = dVar;
                    this.$reverseDirection = z10;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, dVar);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
                @Override // kotlin.coroutines.jvm.internal.a
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
                    /*
                        r13 = this;
                        java.lang.Object r0 = a9.b.e()
                        int r1 = r13.label
                        r2 = 1
                        if (r1 == 0) goto L1d
                        if (r1 != r2) goto L15
                        java.lang.Object r0 = r13.L$0
                        kotlinx.coroutines.o0 r0 = (kotlinx.coroutines.o0) r0
                        v8.u.b(r14)     // Catch: java.util.concurrent.CancellationException -> L13
                        goto L4d
                    L13:
                        r14 = move-exception
                        goto L47
                    L15:
                        java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r14.<init>(r0)
                        throw r14
                    L1d:
                        v8.u.b(r14)
                        java.lang.Object r14 = r13.L$0
                        kotlinx.coroutines.o0 r14 = (kotlinx.coroutines.o0) r14
                        androidx.compose.ui.input.pointer.PointerInputScope r1 = r13.$$this$pointerInput     // Catch: java.util.concurrent.CancellationException -> L43
                        androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1 r11 = new androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1     // Catch: java.util.concurrent.CancellationException -> L43
                        androidx.compose.runtime.State<h9.l<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean>> r5 = r13.$canDragState     // Catch: java.util.concurrent.CancellationException -> L43
                        androidx.compose.runtime.State<h9.a<java.lang.Boolean>> r6 = r13.$startImmediatelyState     // Catch: java.util.concurrent.CancellationException -> L43
                        androidx.compose.foundation.gestures.Orientation r7 = r13.$orientation     // Catch: java.util.concurrent.CancellationException -> L43
                        r9.d<androidx.compose.foundation.gestures.DragEvent> r8 = r13.$channel     // Catch: java.util.concurrent.CancellationException -> L43
                        boolean r9 = r13.$reverseDirection     // Catch: java.util.concurrent.CancellationException -> L43
                        r10 = 0
                        r3 = r11
                        r4 = r14
                        r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L43
                        r13.L$0 = r14     // Catch: java.util.concurrent.CancellationException -> L43
                        r13.label = r2     // Catch: java.util.concurrent.CancellationException -> L43
                        java.lang.Object r14 = r1.awaitPointerEventScope(r11, r13)     // Catch: java.util.concurrent.CancellationException -> L43
                        if (r14 != r0) goto L4d
                        return r0
                    L43:
                        r0 = move-exception
                        r12 = r0
                        r0 = r14
                        r14 = r12
                    L47:
                        boolean r0 = kotlinx.coroutines.p0.h(r0)
                        if (r0 == 0) goto L50
                    L4d:
                        v8.k0 r14 = v8.k0.f35197a
                        return r14
                    L50:
                        throw r14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.AnonymousClass9.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(boolean z10, State<? extends h9.l<? super PointerInputChange, Boolean>> state, State<? extends h9.a<Boolean>> state2, Orientation orientation, r9.d<DragEvent> dVar, boolean z11, z8.d<? super AnonymousClass3> dVar2) {
                super(2, dVar2);
                this.$enabled = z10;
                this.$canDragState = state;
                this.$startImmediatelyState = state2;
                this.$orientation = orientation;
                this.$channel = dVar;
                this.$reverseDirection = z11;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$enabled, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, dVar);
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
                    if (!this.$enabled) {
                        return k0.f35197a;
                    }
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(pointerInputScope, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, null);
                    this.label = 1;
                    if (p0.f(anonymousClass1, this) == objE) {
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
        AnonymousClass9(p<? super Composer, ? super Integer, ? extends PointerAwareDraggableState> pVar, MutableInteractionSource mutableInteractionSource, h9.a<Boolean> aVar, h9.l<? super PointerInputChange, Boolean> lVar, q<? super o0, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, q<? super o0, ? super Float, ? super z8.d<? super k0>, ? extends Object> qVar2, Orientation orientation, boolean z10, boolean z11) {
            super(3);
            this.$stateFactory = pVar;
            this.$interactionSource = mutableInteractionSource;
            this.$startDragImmediately = aVar;
            this.$canDrag = lVar;
            this.$onDragStarted = qVar;
            this.$onDragStopped = qVar2;
            this.$orientation = orientation;
            this.$enabled = z10;
            this.$reverseDirection = z11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
        public static final DragLogic m275invoke$lambda2(State<DragLogic> state) {
            return state.getValue();
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-1487259950);
            PointerAwareDraggableState pointerAwareDraggableStateMo4invoke = this.$stateFactory.mo4invoke(composer, 0);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            EffectsKt.DisposableEffect(mutableInteractionSource, new AnonymousClass1(mutableState, mutableInteractionSource), composer, 0);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = g.b(Integer.MAX_VALUE, null, null, 6, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            r9.d dVar = (r9.d) objRememberedValue2;
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$startDragImmediately, composer, 0);
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$canDrag, composer, 0);
            EffectsKt.LaunchedEffect(pointerAwareDraggableStateMo4invoke, new AnonymousClass2(dVar, pointerAwareDraggableStateMo4invoke, SnapshotStateKt.rememberUpdatedState(new DragLogic(this.$onDragStarted, this.$onDragStopped, mutableState, this.$interactionSource), composer, 0), null), composer, 0);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, new Object[]{this.$orientation, Boolean.valueOf(this.$enabled), Boolean.valueOf(this.$reverseDirection)}, (p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object>) new AnonymousClass3(this.$enabled, stateRememberUpdatedState2, stateRememberUpdatedState, this.$orientation, dVar, this.$reverseDirection, null));
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }
    }

    @NotNull
    public static final DraggableState DraggableState(@NotNull h9.l<? super Float, k0> onDelta) {
        t.i(onDelta, "onDelta");
        return new DefaultDraggableState(onDelta);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, androidx.compose.runtime.State<? extends h9.l<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean>> r10, androidx.compose.runtime.State<? extends h9.a<java.lang.Boolean>> r11, androidx.compose.ui.input.pointer.util.VelocityTracker r12, androidx.compose.foundation.gestures.Orientation r13, z8.d<? super v8.s<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r14) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.Orientation, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitDrag(AwaitPointerEventScope awaitPointerEventScope, s<PointerInputChange, Float> sVar, VelocityTracker velocityTracker, r9.u<? super DragEvent> uVar, boolean z10, Orientation orientation, z8.d<? super Boolean> dVar) {
        float fFloatValue = sVar.d().floatValue();
        PointerInputChange pointerInputChangeC = sVar.c();
        long jM1371minusMKHz9U = Offset.m1371minusMKHz9U(pointerInputChangeC.m2873getPositionF1C5BW0(), Offset.m1374timestuRUvjQ(toOffset(fFloatValue, orientation), Math.signum(m270toFloat3MmeM6k(pointerInputChangeC.m2873getPositionF1C5BW0(), orientation))));
        uVar.f(new DragEvent.DragStarted(jM1371minusMKHz9U, null));
        if (z10) {
            fFloatValue *= -1;
        }
        uVar.f(new DragEvent.DragDelta(fFloatValue, jM1371minusMKHz9U, null));
        DraggableKt$awaitDrag$dragTick$1 draggableKt$awaitDrag$dragTick$1 = new DraggableKt$awaitDrag$dragTick$1(velocityTracker, orientation, uVar, z10);
        return orientation == Orientation.Vertical ? DragGestureDetectorKt.m262verticalDragjO51t88(awaitPointerEventScope, pointerInputChangeC.m2872getIdJ3iCeTQ(), draggableKt$awaitDrag$dragTick$1, dVar) : DragGestureDetectorKt.m259horizontalDragjO51t88(awaitPointerEventScope, pointerInputChangeC.m2872getIdJ3iCeTQ(), draggableKt$awaitDrag$dragTick$1, dVar);
    }

    @NotNull
    public static final Modifier draggable(@NotNull Modifier modifier, @NotNull DraggableState state, @NotNull Orientation orientation, boolean z10, @Nullable MutableInteractionSource mutableInteractionSource, boolean z11, @NotNull q<? super o0, ? super Offset, ? super z8.d<? super k0>, ? extends Object> onDragStarted, @NotNull q<? super o0, ? super Float, ? super z8.d<? super k0>, ? extends Object> onDragStopped, boolean z12) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        t.i(orientation, "orientation");
        t.i(onDragStarted, "onDragStarted");
        t.i(onDragStopped, "onDragStopped");
        return draggable(modifier, new AnonymousClass3(state), AnonymousClass4.INSTANCE, orientation, z10, mutableInteractionSource, new AnonymousClass5(z11), onDragStarted, onDragStopped, z12);
    }

    @Composable
    @NotNull
    public static final DraggableState rememberDraggableState(@NotNull h9.l<? super Float, k0> onDelta, @Nullable Composer composer, int i10) {
        t.i(onDelta, "onDelta");
        composer.startReplaceableGroup(-183245213);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onDelta, composer, i10 & 14);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = DraggableState(new DraggableKt$rememberDraggableState$1$1(stateRememberUpdatedState));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DraggableState draggableState = (DraggableState) objRememberedValue;
        composer.endReplaceableGroup();
        return draggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-3MmeM6k, reason: not valid java name */
    public static final float m270toFloat3MmeM6k(long j10, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m1368getYimpl(j10) : Offset.m1367getXimpl(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-sF-c-tU, reason: not valid java name */
    public static final float m271toFloatsFctU(long j10, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m3899getYimpl(j10) : Velocity.m3898getXimpl(j10);
    }

    private static final long toOffset(float f10, Orientation orientation) {
        return orientation == Orientation.Vertical ? OffsetKt.Offset(0.0f, f10) : OffsetKt.Offset(f10, 0.0f);
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @NotNull
    public static final Modifier draggable(@NotNull Modifier modifier, @NotNull p<? super Composer, ? super Integer, ? extends PointerAwareDraggableState> stateFactory, @NotNull h9.l<? super PointerInputChange, Boolean> canDrag, @NotNull Orientation orientation, boolean z10, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull h9.a<Boolean> startDragImmediately, @NotNull q<? super o0, ? super Offset, ? super z8.d<? super k0>, ? extends Object> onDragStarted, @NotNull q<? super o0, ? super Float, ? super z8.d<? super k0>, ? extends Object> onDragStopped, boolean z11) {
        t.i(modifier, "<this>");
        t.i(stateFactory, "stateFactory");
        t.i(canDrag, "canDrag");
        t.i(orientation, "orientation");
        t.i(startDragImmediately, "startDragImmediately");
        t.i(onDragStarted, "onDragStarted");
        t.i(onDragStopped, "onDragStopped");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new DraggableKt$draggable$$inlined$debugInspectorInfo$1(canDrag, orientation, z10, z11, mutableInteractionSource, startDragImmediately, onDragStarted, onDragStopped, stateFactory) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass9(stateFactory, mutableInteractionSource, startDragImmediately, canDrag, onDragStarted, onDragStopped, orientation, z10, z11));
    }
}
