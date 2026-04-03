package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.a;
import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SwipeableKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.material.SwipeableKt$rememberSwipeableState$1, reason: invalid class name */
    /* JADX INFO: compiled from: Swipeable.kt */
    static final class AnonymousClass1<T> extends v implements l<T, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull T it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.material.SwipeableKt$rememberSwipeableState$2, reason: invalid class name */
    /* JADX INFO: compiled from: Swipeable.kt */
    static final class AnonymousClass2<T> extends v implements a<SwipeableState<T>> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ l<T, Boolean> $confirmStateChange;
        final /* synthetic */ T $initialValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(T t10, AnimationSpec<Float> animationSpec, l<? super T, Boolean> lVar) {
            super(0);
            this.$initialValue = t10;
            this.$animationSpec = animationSpec;
            this.$confirmStateChange = lVar;
        }

        @Override // h9.a
        @NotNull
        public final SwipeableState<T> invoke() {
            return new SwipeableState<>(this.$initialValue, this.$animationSpec, this.$confirmStateChange);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Swipeable.kt */
    @f(c = "androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$1", f = "Swipeable.kt", l = {512}, m = "invokeSuspend")
    static final class C09481 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ SwipeableState<T> $swipeableState;
        final /* synthetic */ T $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09481(T t10, SwipeableState<T> swipeableState, d<? super C09481> dVar) {
            super(2, dVar);
            this.$value = t10;
            this.$swipeableState = swipeableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C09481(this.$value, this.$swipeableState, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                if (!t.d(this.$value, this.$swipeableState.getCurrentValue())) {
                    SwipeableState<T> swipeableState = this.$swipeableState;
                    T t10 = this.$value;
                    this.label = 1;
                    if (SwipeableState.animateTo$default(swipeableState, t10, null, this, 2, null) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C09481) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Swipeable.kt */
    static final class C09492 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ MutableState<Boolean> $forceAnimationCheck;
        final /* synthetic */ l<T, k0> $onValueChange;
        final /* synthetic */ SwipeableState<T> $swipeableState;
        final /* synthetic */ T $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09492(T t10, SwipeableState<T> swipeableState, l<? super T, k0> lVar, MutableState<Boolean> mutableState) {
            super(1);
            this.$value = t10;
            this.$swipeableState = swipeableState;
            this.$onValueChange = lVar;
            this.$forceAnimationCheck = mutableState;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            if (!t.d(this.$value, this.$swipeableState.getCurrentValue())) {
                this.$onValueChange.invoke(this.$swipeableState.getCurrentValue());
                this.$forceAnimationCheck.setValue(Boolean.valueOf(!r2.getValue().booleanValue()));
            }
            return new DisposableEffectResult() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r3 < r6.mo4invoke(java.lang.Float.valueOf(r0), java.lang.Float.valueOf(r5)).floatValue()) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (r3 > r6.mo4invoke(java.lang.Float.valueOf(r5), java.lang.Float.valueOf(r0)).floatValue()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float computeTarget(float r3, float r4, java.util.Set<java.lang.Float> r5, h9.p<? super java.lang.Float, ? super java.lang.Float, java.lang.Float> r6, float r7, float r8) {
        /*
            java.util.List r5 = findBounds(r3, r5)
            int r0 = r5.size()
            if (r0 == 0) goto L6c
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L62
            java.lang.Object r0 = r5.get(r1)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Object r5 = r5.get(r2)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 > 0) goto L42
            int r4 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r4 < 0) goto L2b
            return r5
        L2b:
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            java.lang.Float r7 = java.lang.Float.valueOf(r5)
            java.lang.Object r4 = r6.mo4invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L5e
            goto L60
        L42:
            float r4 = -r8
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L48
            return r0
        L48:
            java.lang.Float r4 = java.lang.Float.valueOf(r5)
            java.lang.Float r7 = java.lang.Float.valueOf(r0)
            java.lang.Object r4 = r6.mo4invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L60
        L5e:
            r4 = r5
            goto L6c
        L60:
            r4 = r0
            goto L6c
        L62:
            java.lang.Object r3 = r5.get(r1)
            java.lang.Number r3 = (java.lang.Number) r3
            float r4 = r3.floatValue()
        L6c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt.computeTarget(float, float, java.util.Set, h9.p, float, float):float");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Float> findBounds(float f10, Set<Float> set) {
        Set<Float> set2 = set;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((double) ((Number) next).floatValue()) <= ((double) f10) + 0.001d) {
                arrayList.add(next);
            }
        }
        Float fV0 = d0.v0(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : set2) {
            if (((double) ((Number) obj).floatValue()) >= ((double) f10) - 0.001d) {
                arrayList2.add(obj);
            }
        }
        Float fX0 = d0.x0(arrayList2);
        if (fV0 == null) {
            return kotlin.collections.v.o(fX0);
        }
        if (fX0 != null && !t.c(fV0, fX0)) {
            return kotlin.collections.v.n(fV0, fX0);
        }
        return kotlin.collections.u.e(fV0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t10) {
        T next;
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (t.d(((Map.Entry) next).getValue(), t10)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    @NotNull
    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(@NotNull SwipeableState<T> swipeableState) {
        t.i(swipeableState, "<this>");
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1(swipeableState);
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final <T> SwipeableState<T> rememberSwipeableState(@NotNull T initialValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable l<? super T, Boolean> lVar, @Nullable Composer composer, int i10, int i11) {
        t.i(initialValue, "initialValue");
        composer.startReplaceableGroup(-1237755169);
        if ((i11 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.m1271rememberSaveable(new Object[0], (Saver) SwipeableState.Companion.Saver(animationSpec, lVar), (String) null, (a) new AnonymousClass2(initialValue, animationSpec, lVar), composer, 72, 4);
        composer.endReplaceableGroup();
        return swipeableState;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final <T> SwipeableState<T> rememberSwipeableStateFor(@NotNull T value, @NotNull l<? super T, k0> onValueChange, @Nullable AnimationSpec<Float> animationSpec, @Nullable Composer composer, int i10, int i11) {
        t.i(value, "value");
        t.i(onValueChange, "onValueChange");
        composer.startReplaceableGroup(1156387078);
        if ((i11 & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new SwipeableState(value, animationSpec, SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1.INSTANCE);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SwipeableState<T> swipeableState = (SwipeableState) objRememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue2;
        int i12 = i10 & 8;
        EffectsKt.LaunchedEffect(value, mutableState.getValue(), new C09481(value, swipeableState, null), composer, (i10 & 14) | i12);
        EffectsKt.DisposableEffect(swipeableState.getCurrentValue(), new C09492(value, swipeableState, onValueChange, mutableState), composer, i12);
        composer.endReplaceableGroup();
        return swipeableState;
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: swipeable-pPrIpRY, reason: not valid java name */
    public static final <T> Modifier m1157swipeablepPrIpRY(@NotNull Modifier swipeable, @NotNull SwipeableState<T> state, @NotNull Map<Float, ? extends T> anchors, @NotNull Orientation orientation, boolean z10, boolean z11, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull p<? super T, ? super T, ? extends ThresholdConfig> thresholds, @Nullable ResistanceConfig resistanceConfig, float f10) {
        t.i(swipeable, "$this$swipeable");
        t.i(state, "state");
        t.i(anchors, "anchors");
        t.i(orientation, "orientation");
        t.i(thresholds, "thresholds");
        return ComposedModifierKt.composed(swipeable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1(state, anchors, orientation, z10, z11, mutableInteractionSource, thresholds, resistanceConfig, f10) : InspectableValueKt.getNoInspectorInfo(), new SwipeableKt$swipeable$3(anchors, state, orientation, z10, mutableInteractionSource, z11, resistanceConfig, thresholds, f10));
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState swipeableState) {
    }
}
