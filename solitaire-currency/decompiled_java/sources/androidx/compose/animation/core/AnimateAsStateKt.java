package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: AnimateAsState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimateAsStateKt {

    @NotNull
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);

    @NotNull
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m3671boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, null);

    @NotNull
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m1424boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, null);

    @NotNull
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m1356boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, null);

    @NotNull
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, null);

    @NotNull
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(s.f29839a)), 3, null);

    @NotNull
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);

    @NotNull
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, null);

    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnimateAsState.kt */
    static final class AnonymousClass2 extends v implements h9.a<k0> {
        final /* synthetic */ r9.d<T> $channel;
        final /* synthetic */ T $targetValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(r9.d<T> dVar, T t10) {
            super(0);
            this.$channel = dVar;
            this.$targetValue = t10;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$channel.f(this.$targetValue);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3, reason: invalid class name */
    /* JADX INFO: compiled from: AnimateAsState.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3", f = "AnimateAsState.kt", l = {368}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
        final /* synthetic */ Animatable<T, V> $animatable;
        final /* synthetic */ r9.d<T> $channel;
        final /* synthetic */ State<h9.l<T, k0>> $listener$delegate;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: AnimateAsState.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1", f = "AnimateAsState.kt", l = {377}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
            final /* synthetic */ Animatable<T, V> $animatable;
            final /* synthetic */ State<h9.l<T, k0>> $listener$delegate;
            final /* synthetic */ T $newTarget;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(T t10, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends h9.l<? super T, k0>> state2, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$newTarget = t10;
                this.$animatable = animatable;
                this.$animSpec$delegate = state;
                this.$listener$delegate = state2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass1(this.$newTarget, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    if (!t.d(this.$newTarget, this.$animatable.getTargetValue())) {
                        Animatable<T, V> animatable = this.$animatable;
                        T t10 = this.$newTarget;
                        AnimationSpec animationSpecM101animateValueAsState$lambda4 = AnimateAsStateKt.m101animateValueAsState$lambda4(this.$animSpec$delegate);
                        this.label = 1;
                        if (Animatable.animateTo$default(animatable, t10, animationSpecM101animateValueAsState$lambda4, null, null, this, 12, null) == objE) {
                            return objE;
                        }
                    }
                    return k0.f35197a;
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                h9.l lVarM100animateValueAsState$lambda3 = AnimateAsStateKt.m100animateValueAsState$lambda3(this.$listener$delegate);
                if (lVarM100animateValueAsState$lambda3 != null) {
                    lVarM100animateValueAsState$lambda3.invoke(this.$animatable.getValue());
                }
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
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(r9.d<T> dVar, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends h9.l<? super T, k0>> state2, z8.d<? super AnonymousClass3> dVar2) {
            super(2, dVar2);
            this.$channel = dVar;
            this.$animatable = animatable;
            this.$animSpec$delegate = state;
            this.$listener$delegate = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$channel, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0041 -> B:12:0x0044). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L24
                if (r2 != r3) goto L1c
                java.lang.Object r2 = r0.L$1
                r9.f r2 = (r9.f) r2
                java.lang.Object r4 = r0.L$0
                kotlinx.coroutines.o0 r4 = (kotlinx.coroutines.o0) r4
                v8.u.b(r18)
                r6 = r18
                r5 = r0
                goto L44
            L1c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L24:
                v8.u.b(r18)
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.o0 r2 = (kotlinx.coroutines.o0) r2
                r9.d<T> r4 = r0.$channel
                r9.f r4 = r4.iterator()
                r5 = r0
                r16 = r4
                r4 = r2
                r2 = r16
            L37:
                r5.L$0 = r4
                r5.L$1 = r2
                r5.label = r3
                java.lang.Object r6 = r2.b(r5)
                if (r6 != r1) goto L44
                return r1
            L44:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L78
                java.lang.Object r6 = r2.next()
                r9.d<T> r7 = r5.$channel
                java.lang.Object r7 = r7.h()
                java.lang.Object r7 = r9.h.f(r7)
                if (r7 != 0) goto L5e
                r9 = r6
                goto L5f
            L5e:
                r9 = r7
            L5f:
                r6 = 0
                r14 = 0
                androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1 r15 = new androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1
                androidx.compose.animation.core.Animatable<T, V> r10 = r5.$animatable
                androidx.compose.runtime.State<androidx.compose.animation.core.AnimationSpec<T>> r11 = r5.$animSpec$delegate
                androidx.compose.runtime.State<h9.l<T, v8.k0>> r12 = r5.$listener$delegate
                r13 = 0
                r8 = r15
                r8.<init>(r9, r10, r11, r12, r13)
                r11 = 3
                r12 = 0
                r7 = r4
                r8 = r6
                r9 = r14
                r10 = r15
                kotlinx.coroutines.i.d(r7, r8, r9, r10, r11, r12)
                goto L37
            L78:
                v8.k0 r1 = v8.k0.f35197a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: animateDpAsState-Kz89ssw, reason: not valid java name */
    public static final State<Dp> m95animateDpAsStateKz89ssw(float f10, @Nullable AnimationSpec<Dp> animationSpec, @Nullable h9.l<? super Dp, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(704104481);
        if ((i11 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec<Dp> animationSpec2 = animationSpec;
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        State<Dp> stateAnimateValueAsState = animateValueAsState(Dp.m3671boximpl(f10), VectorConvertersKt.getVectorConverter(Dp.Companion), animationSpec2, null, lVar, composer, (i10 & 14) | ((i10 << 3) & 896) | ((i10 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Composable
    @NotNull
    public static final State<Float> animateFloatAsState(float f10, @Nullable AnimationSpec<Float> animationSpec, float f11, @Nullable h9.l<? super Float, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1091643291);
        if ((i11 & 2) != 0) {
            animationSpec = defaultAnimation;
        }
        if ((i11 & 4) != 0) {
            f11 = 0.01f;
        }
        h9.l<? super Float, k0> lVar2 = (i11 & 8) != 0 ? null : lVar;
        composer.startReplaceableGroup(841393485);
        if (animationSpec == defaultAnimation) {
            Float fValueOf = Float.valueOf(f11);
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(fValueOf);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, Float.valueOf(f11), 3, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            animationSpec = (AnimationSpec) objRememberedValue;
        }
        composer.endReplaceableGroup();
        int i12 = i10 << 3;
        State<Float> stateAnimateValueAsState = animateValueAsState(Float.valueOf(f10), VectorConvertersKt.getVectorConverter(m.f29832a), animationSpec, Float.valueOf(f11), lVar2, composer, (i10 & 14) | (i12 & 7168) | (i12 & 57344), 0);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Composable
    @NotNull
    public static final State<Integer> animateIntAsState(int i10, @Nullable AnimationSpec<Integer> animationSpec, @Nullable h9.l<? super Integer, k0> lVar, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-842612981);
        if ((i12 & 2) != 0) {
            animationSpec = intDefaultSpring;
        }
        AnimationSpec<Integer> animationSpec2 = animationSpec;
        if ((i12 & 4) != 0) {
            lVar = null;
        }
        State<Integer> stateAnimateValueAsState = animateValueAsState(Integer.valueOf(i10), VectorConvertersKt.getVectorConverter(s.f29839a), animationSpec2, null, lVar, composer, (i11 & 14) | ((i11 << 3) & 896) | ((i11 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: animateIntOffsetAsState-8f6pmRE, reason: not valid java name */
    public static final State<IntOffset> m96animateIntOffsetAsState8f6pmRE(long j10, @Nullable AnimationSpec<IntOffset> animationSpec, @Nullable h9.l<? super IntOffset, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1010307371);
        if ((i11 & 2) != 0) {
            animationSpec = intOffsetDefaultSpring;
        }
        AnimationSpec<IntOffset> animationSpec2 = animationSpec;
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        State<IntOffset> stateAnimateValueAsState = animateValueAsState(IntOffset.m3782boximpl(j10), VectorConvertersKt.getVectorConverter(IntOffset.Companion), animationSpec2, null, lVar, composer, (i10 & 14) | ((i10 << 3) & 896) | ((i10 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: animateIntSizeAsState-zTRF_AQ, reason: not valid java name */
    public static final State<IntSize> m97animateIntSizeAsStatezTRF_AQ(long j10, @Nullable AnimationSpec<IntSize> animationSpec, @Nullable h9.l<? super IntSize, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1749239765);
        if ((i11 & 2) != 0) {
            animationSpec = intSizeDefaultSpring;
        }
        AnimationSpec<IntSize> animationSpec2 = animationSpec;
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        State<IntSize> stateAnimateValueAsState = animateValueAsState(IntSize.m3825boximpl(j10), VectorConvertersKt.getVectorConverter(IntSize.Companion), animationSpec2, null, lVar, composer, (i10 & 14) | ((i10 << 3) & 896) | ((i10 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: animateOffsetAsState-N6fFfp4, reason: not valid java name */
    public static final State<Offset> m98animateOffsetAsStateN6fFfp4(long j10, @Nullable AnimationSpec<Offset> animationSpec, @Nullable h9.l<? super Offset, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-456513133);
        if ((i11 & 2) != 0) {
            animationSpec = offsetDefaultSpring;
        }
        AnimationSpec<Offset> animationSpec2 = animationSpec;
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        State<Offset> stateAnimateValueAsState = animateValueAsState(Offset.m1356boximpl(j10), VectorConvertersKt.getVectorConverter(Offset.Companion), animationSpec2, null, lVar, composer, (i10 & 14) | ((i10 << 3) & 896) | ((i10 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Composable
    @NotNull
    public static final State<Rect> animateRectAsState(@NotNull Rect targetValue, @Nullable AnimationSpec<Rect> animationSpec, @Nullable h9.l<? super Rect, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        t.i(targetValue, "targetValue");
        composer.startReplaceableGroup(-782613967);
        if ((i11 & 2) != 0) {
            animationSpec = rectDefaultSpring;
        }
        AnimationSpec<Rect> animationSpec2 = animationSpec;
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        State<Rect> stateAnimateValueAsState = animateValueAsState(targetValue, VectorConvertersKt.getVectorConverter(Rect.Companion), animationSpec2, null, lVar, composer, (i10 & 14) | ((i10 << 3) & 896) | ((i10 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: animateSizeAsState-LjSzlW0, reason: not valid java name */
    public static final State<Size> m99animateSizeAsStateLjSzlW0(long j10, @Nullable AnimationSpec<Size> animationSpec, @Nullable h9.l<? super Size, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(875212471);
        if ((i11 & 2) != 0) {
            animationSpec = sizeDefaultSpring;
        }
        AnimationSpec<Size> animationSpec2 = animationSpec;
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        State<Size> stateAnimateValueAsState = animateValueAsState(Size.m1424boximpl(j10), VectorConvertersKt.getVectorConverter(Size.Companion), animationSpec2, null, lVar, composer, (i10 & 14) | ((i10 << 3) & 896) | ((i10 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r12v1 ??, still in use, count: 1, list:
          (r12v1 ?? I:java.lang.Object) from 0x005d: INVOKE (r23v0 ?? I:androidx.compose.runtime.Composer), (r12v1 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:94)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.runtime.State<T> animateValueAsState(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r12v1 ??, still in use, count: 1, list:
          (r12v1 ?? I:java.lang.Object) from 0x005d: INVOKE (r23v0 ?? I:androidx.compose.runtime.Composer), (r12v1 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:94)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r18v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: animateValueAsState$lambda-3, reason: not valid java name */
    public static final <T> h9.l<T, k0> m100animateValueAsState$lambda3(State<? extends h9.l<? super T, k0>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: animateValueAsState$lambda-4, reason: not valid java name */
    public static final <T> AnimationSpec<T> m101animateValueAsState$lambda4(State<? extends AnimationSpec<T>> state) {
        return state.getValue();
    }
}
