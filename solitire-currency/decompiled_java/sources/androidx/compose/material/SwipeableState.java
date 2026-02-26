package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.a;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import h9.l;
import h9.p;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.j;
import v8.k0;
import v8.s;
import v8.u;
import v8.y;
import z8.d;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public class SwipeableState<T> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final MutableState<Float> absoluteOffset;

    @NotNull
    private final MutableState anchors$delegate;

    @NotNull
    private final AnimationSpec<Float> animationSpec;

    @NotNull
    private final MutableState<Float> animationTarget;

    @NotNull
    private final l<T, Boolean> confirmStateChange;

    @NotNull
    private final MutableState currentValue$delegate;

    @NotNull
    private final DraggableState draggableState;

    @NotNull
    private final MutableState isAnimationRunning$delegate;

    @NotNull
    private final h<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;

    @NotNull
    private final MutableState<Float> offsetState;

    @NotNull
    private final MutableState<Float> overflowState;

    @NotNull
    private final MutableState resistance$delegate;

    @NotNull
    private final MutableState thresholds$delegate;

    @NotNull
    private final MutableState velocityThreshold$delegate;

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$1, reason: invalid class name */
    /* JADX INFO: compiled from: Swipeable.kt */
    static final class AnonymousClass1 extends v implements l<T, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.l
        @NotNull
        public final Boolean invoke(T t10) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: Swipeable.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final <T> Saver<SwipeableState<T>, T> Saver(@NotNull AnimationSpec<Float> animationSpec, @NotNull l<? super T, Boolean> confirmStateChange) {
            t.i(animationSpec, "animationSpec");
            t.i(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(SwipeableState$Companion$Saver$1.INSTANCE, new SwipeableState$Companion$Saver$2(animationSpec, confirmStateChange));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateInternalToOffset$2, reason: invalid class name */
    /* JADX INFO: compiled from: Swipeable.kt */
    @f(c = "androidx.compose.material.SwipeableState$animateInternalToOffset$2", f = "Swipeable.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<DragScope, d<? super k0>, Object> {
        final /* synthetic */ AnimationSpec<Float> $spec;
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateInternalToOffset$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Swipeable.kt */
        static final class AnonymousClass1 extends v implements l<Animatable<Float, AnimationVector1D>, k0> {
            final /* synthetic */ DragScope $$this$drag;
            final /* synthetic */ kotlin.jvm.internal.k0 $prevValue;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DragScope dragScope, kotlin.jvm.internal.k0 k0Var) {
                super(1);
                this.$$this$drag = dragScope;
                this.$prevValue = k0Var;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Animatable<Float, AnimationVector1D> animatable) {
                invoke2(animatable);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Animatable<Float, AnimationVector1D> animateTo) {
                t.i(animateTo, "$this$animateTo");
                this.$$this$drag.dragBy(animateTo.getValue().floatValue() - this.$prevValue.f29829a);
                this.$prevValue.f29829a = animateTo.getValue().floatValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SwipeableState<T> swipeableState, float f10, AnimationSpec<Float> animationSpec, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.this$0 = swipeableState;
            this.$target = f10;
            this.$spec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$target, this.$spec, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull DragScope dragScope, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(dragScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    u.b(obj);
                    DragScope dragScope = (DragScope) this.L$0;
                    kotlin.jvm.internal.k0 k0Var = new kotlin.jvm.internal.k0();
                    k0Var.f29829a = ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue();
                    ((SwipeableState) this.this$0).animationTarget.setValue(b.c(this.$target));
                    this.this$0.setAnimationRunning(true);
                    Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(k0Var.f29829a, 0.0f, 2, null);
                    Float fC = b.c(this.$target);
                    AnimationSpec<Float> animationSpec = this.$spec;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(dragScope, k0Var);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatableAnimatable$default, fC, animationSpec, null, anonymousClass1, this, 4, null) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                ((SwipeableState) this.this$0).animationTarget.setValue(null);
                this.this$0.setAnimationRunning(false);
                return k0.f35197a;
            } catch (Throwable th) {
                ((SwipeableState) this.this$0).animationTarget.setValue(null);
                this.this$0.setAnimationRunning(false);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Swipeable.kt */
    static final class C09502 implements i<Map<Float, ? extends T>> {
        final /* synthetic */ AnimationSpec<Float> $anim;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        C09502(T t10, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
            this.$targetValue = t10;
            this.this$0 = swipeableState;
            this.$anim = animationSpec;
        }

        @Override // s9.i
        public /* bridge */ /* synthetic */ Object emit(Object obj, d dVar) {
            return emit((Map) obj, (d<? super k0>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r9, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 314
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState.C09502.emit(java.util.Map, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$snapInternalToOffset$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Swipeable.kt */
    @f(c = "androidx.compose.material.SwipeableState$snapInternalToOffset$2", f = "Swipeable.kt", l = {}, m = "invokeSuspend")
    static final class C09522 extends kotlin.coroutines.jvm.internal.l implements p<DragScope, d<? super k0>, Object> {
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09522(float f10, SwipeableState<T> swipeableState, d<? super C09522> dVar) {
            super(2, dVar);
            this.$target = f10;
            this.this$0 = swipeableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09522 c09522 = new C09522(this.$target, this.this$0, dVar);
            c09522.L$0 = obj;
            return c09522;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull DragScope dragScope, @Nullable d<? super k0> dVar) {
            return ((C09522) create(dragScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            ((DragScope) this.L$0).dragBy(this.$target - ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue());
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Swipeable.kt */
    static final class C09532 implements i<Map<Float, ? extends T>> {
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        C09532(T t10, SwipeableState<T> swipeableState) {
            this.$targetValue = t10;
            this.this$0 = swipeableState;
        }

        @Override // s9.i
        public /* bridge */ /* synthetic */ Object emit(Object obj, d dVar) {
            return emit((Map) obj, (d<? super k0>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof androidx.compose.material.SwipeableState$snapTo$2$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                androidx.compose.material.SwipeableState$snapTo$2$emit$1 r0 = (androidx.compose.material.SwipeableState$snapTo$2$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.material.SwipeableState$snapTo$2$emit$1 r0 = new androidx.compose.material.SwipeableState$snapTo$2$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r5 = r0.L$0
                androidx.compose.material.SwipeableState$snapTo$2 r5 = (androidx.compose.material.SwipeableState.C09532) r5
                v8.u.b(r6)
                goto L52
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L35:
                v8.u.b(r6)
                T r6 = r4.$targetValue
                java.lang.Float r5 = androidx.compose.material.SwipeableKt.access$getOffset(r5, r6)
                if (r5 == 0) goto L5c
                androidx.compose.material.SwipeableState<T> r6 = r4.this$0
                float r5 = r5.floatValue()
                r0.L$0 = r4
                r0.label = r3
                java.lang.Object r5 = androidx.compose.material.SwipeableState.access$snapInternalToOffset(r6, r5, r0)
                if (r5 != r1) goto L51
                return r1
            L51:
                r5 = r4
            L52:
                androidx.compose.material.SwipeableState<T> r6 = r5.this$0
                T r5 = r5.$targetValue
                androidx.compose.material.SwipeableState.access$setCurrentValue(r6, r5)
                v8.k0 r5 = v8.k0.f35197a
                return r5
            L5c:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.String r6 = "The target value must have an associated anchor."
                java.lang.String r6 = r6.toString()
                r5.<init>(r6)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState.C09532.emit(java.util.Map, z8.d):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableState(T t10, @NotNull AnimationSpec<Float> animationSpec, @NotNull l<? super T, Boolean> confirmStateChange) {
        t.i(animationSpec, "animationSpec");
        t.i(confirmStateChange, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = confirmStateChange;
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
        this.isAnimationRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        Float fValueOf = Float.valueOf(0.0f);
        this.offsetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.overflowState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.absoluteOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.animationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0.g(), null, 2, null);
        final h hVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new SwipeableState$latestNonEmptyAnchorsFlow$1(this));
        this.latestNonEmptyAnchorsFlow = j.M(new h<Map<Float, ? extends T>>() { // from class: androidx.compose.material.SwipeableState$special$$inlined$filter$1

            /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "androidx.compose.material.SwipeableState$special$$inlined$filter$1$2", f = "Swipeable.kt", l = {224}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull z8.d r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1 r0 = (androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1 r0 = new androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        v8.u.b(r6)
                        s9.i r6 = r4.$this_unsafeFlow
                        r2 = r5
                        java.util.Map r2 = (java.util.Map) r2
                        boolean r2 = r2.isEmpty()
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L49
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        v8.k0 r5 = v8.k0.f35197a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i iVar, @NotNull d dVar) {
                Object objCollect = hVarSnapshotFlow.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : k0.f35197a;
            }
        }, 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SwipeableState$thresholds$2.INSTANCE, null, 2, null);
        this.velocityThreshold$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.resistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new SwipeableState$draggableState$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateInternalToOffset(float f10, AnimationSpec<Float> animationSpec, d<? super k0> dVar) {
        Object objA = a.a(this.draggableState, null, new AnonymousClass2(this, f10, animationSpec, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SwipeableState swipeableState, Object obj, AnimationSpec animationSpec, d dVar, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i10 & 2) != 0) {
            animationSpec = swipeableState.animationSpec;
        }
        return swipeableState.animateTo(obj, animationSpec, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z10) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t10) {
        this.currentValue$delegate.setValue(t10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object snapInternalToOffset(float f10, d<? super k0> dVar) {
        Object objA = a.a(this.draggableState, null, new C09522(f10, this, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    @ExperimentalMaterialApi
    @Nullable
    public final Object animateTo(T t10, @NotNull AnimationSpec<Float> animationSpec, @NotNull d<? super k0> dVar) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new C09502(t10, this, animationSpec), dVar);
        return objCollect == a9.d.e() ? objCollect : k0.f35197a;
    }

    public final void ensureInit$material_release(@NotNull Map<Float, ? extends T> newAnchors) {
        t.i(newAnchors, "newAnchors");
        if (getAnchors$material_release().isEmpty()) {
            Float offset = SwipeableKt.getOffset(newAnchors, getCurrentValue());
            if (offset == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
            }
            this.offsetState.setValue(offset);
            this.absoluteOffset.setValue(offset);
        }
    }

    @NotNull
    public final Map<Float, T> getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    @NotNull
    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    @NotNull
    public final l<T, Boolean> getConfirmStateChange$material_release() {
        return this.confirmStateChange;
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final float getDirection() {
        Float offset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
        if (offset == null) {
            return 0.0f;
        }
        return Math.signum(getOffset().getValue().floatValue() - offset.floatValue());
    }

    @NotNull
    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    public final float getMaxBound$material_release() {
        return this.maxBound;
    }

    public final float getMinBound$material_release() {
        return this.minBound;
    }

    @NotNull
    public final State<Float> getOffset() {
        return this.offsetState;
    }

    @NotNull
    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    @NotNull
    public final SwipeProgress<T> getProgress() {
        Object currentValue;
        Object objH;
        float fFloatValue;
        List listFindBounds = SwipeableKt.findBounds(getOffset().getValue().floatValue(), getAnchors$material_release().keySet());
        int size = listFindBounds.size();
        if (size == 0) {
            T currentValue2 = getCurrentValue();
            currentValue = getCurrentValue();
            objH = currentValue2;
            fFloatValue = 1.0f;
        } else if (size != 1) {
            s sVarA = getDirection() > 0.0f ? y.a(listFindBounds.get(0), listFindBounds.get(1)) : y.a(listFindBounds.get(1), listFindBounds.get(0));
            float fFloatValue2 = ((Number) sVarA.a()).floatValue();
            float fFloatValue3 = ((Number) sVarA.b()).floatValue();
            objH = r0.h(getAnchors$material_release(), Float.valueOf(fFloatValue2));
            currentValue = r0.h(getAnchors$material_release(), Float.valueOf(fFloatValue3));
            fFloatValue = (getOffset().getValue().floatValue() - fFloatValue2) / (fFloatValue3 - fFloatValue2);
        } else {
            Object objH2 = r0.h(getAnchors$material_release(), listFindBounds.get(0));
            currentValue = r0.h(getAnchors$material_release(), listFindBounds.get(0));
            fFloatValue = 1.0f;
            objH = objH2;
        }
        return new SwipeProgress<>(objH, currentValue, fFloatValue);
    }

    @Nullable
    public final ResistanceConfig getResistance$material_release() {
        return (ResistanceConfig) this.resistance$delegate.getValue();
    }

    public final T getTargetValue() {
        float fComputeTarget;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            fComputeTarget = value.floatValue();
        } else {
            float fFloatValue = getOffset().getValue().floatValue();
            Float offset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
            fComputeTarget = SwipeableKt.computeTarget(fFloatValue, offset != null ? offset.floatValue() : getOffset().getValue().floatValue(), getAnchors$material_release().keySet(), getThresholds$material_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t10 = getAnchors$material_release().get(Float.valueOf(fComputeTarget));
        return t10 == null ? getCurrentValue() : t10;
    }

    @NotNull
    public final p<Float, Float, Float> getThresholds$material_release() {
        return (p) this.thresholds$delegate.getValue();
    }

    public final float getVelocityThreshold$material_release() {
        return ((Number) this.velocityThreshold$delegate.getValue()).floatValue();
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final float performDrag(float f10) {
        float fM = o.m(this.absoluteOffset.getValue().floatValue() + f10, this.minBound, this.maxBound) - this.absoluteOffset.getValue().floatValue();
        if (Math.abs(fM) > 0.0f) {
            this.draggableState.dispatchRawDelta(fM);
        }
        return fM;
    }

    @Nullable
    public final Object performFling(final float f10, @NotNull d<? super k0> dVar) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new i<Map<Float, ? extends T>>(this) { // from class: androidx.compose.material.SwipeableState.performFling.2
            final /* synthetic */ SwipeableState<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // s9.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, d dVar2) {
                return emit((Map) obj, (d<? super k0>) dVar2);
            }

            @Nullable
            public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull d<? super k0> dVar2) {
                Float offset = SwipeableKt.getOffset(map, this.this$0.getCurrentValue());
                t.f(offset);
                float fFloatValue = offset.floatValue();
                T t10 = map.get(b.c(SwipeableKt.computeTarget(this.this$0.getOffset().getValue().floatValue(), fFloatValue, map.keySet(), this.this$0.getThresholds$material_release(), f10, this.this$0.getVelocityThreshold$material_release())));
                if (t10 != null && this.this$0.getConfirmStateChange$material_release().invoke(t10).booleanValue()) {
                    Object objAnimateTo$default = SwipeableState.animateTo$default(this.this$0, t10, null, dVar2, 2, null);
                    return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
                }
                SwipeableState<T> swipeableState = this.this$0;
                Object objAnimateInternalToOffset = swipeableState.animateInternalToOffset(fFloatValue, swipeableState.getAnimationSpec$material_release(), dVar2);
                return objAnimateInternalToOffset == a9.d.e() ? objAnimateInternalToOffset : k0.f35197a;
            }
        }, dVar);
        return objCollect == a9.d.e() ? objCollect : k0.f35197a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x021b  */
    /* JADX WARN: Type inference failed for: r10v21, types: [float] */
    /* JADX WARN: Type inference failed for: r10v76, types: [float] */
    /* JADX WARN: Type inference failed for: r10v78, types: [float] */
    /* JADX WARN: Type inference failed for: r10v89 */
    /* JADX WARN: Type inference failed for: r10v90 */
    /* JADX WARN: Type inference failed for: r10v91 */
    /* JADX WARN: Type inference failed for: r10v92 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processNewAnchors$material_release(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r10, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r11, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 643
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState.processNewAnchors$material_release(java.util.Map, java.util.Map, z8.d):java.lang.Object");
    }

    public final void setAnchors$material_release(@NotNull Map<Float, ? extends T> map) {
        t.i(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final void setMaxBound$material_release(float f10) {
        this.maxBound = f10;
    }

    public final void setMinBound$material_release(float f10) {
        this.minBound = f10;
    }

    public final void setResistance$material_release(@Nullable ResistanceConfig resistanceConfig) {
        this.resistance$delegate.setValue(resistanceConfig);
    }

    public final void setThresholds$material_release(@NotNull p<? super Float, ? super Float, Float> pVar) {
        t.i(pVar, "<set-?>");
        this.thresholds$delegate.setValue(pVar);
    }

    public final void setVelocityThreshold$material_release(float f10) {
        this.velocityThreshold$delegate.setValue(Float.valueOf(f10));
    }

    @ExperimentalMaterialApi
    @Nullable
    public final Object snapTo(T t10, @NotNull d<? super k0> dVar) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new C09532(t10, this), dVar);
        return objCollect == a9.d.e() ? objCollect : k0.f35197a;
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getDirection$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getProgress$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getTargetValue$annotations() {
    }

    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec, l lVar, int i10, k kVar) {
        this(obj, (i10 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i10 & 4) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }
}
