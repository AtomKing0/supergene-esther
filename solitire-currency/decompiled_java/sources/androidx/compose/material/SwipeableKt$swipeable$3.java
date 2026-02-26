package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.ironsource.mediationsdk.logger.IronSourceError;
import h9.p;
import h9.q;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
final class SwipeableKt$swipeable$3 extends v implements q<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Map<Float, T> $anchors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ ResistanceConfig $resistance;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ SwipeableState<T> $state;
    final /* synthetic */ p<T, T, ThresholdConfig> $thresholds;
    final /* synthetic */ float $velocityThreshold;

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableKt$swipeable$3$3, reason: invalid class name */
    /* JADX INFO: compiled from: Swipeable.kt */
    @f(c = "androidx.compose.material.SwipeableKt$swipeable$3$3", f = "Swipeable.kt", l = {607}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ Map<Float, T> $anchors;
        final /* synthetic */ Density $density;
        final /* synthetic */ ResistanceConfig $resistance;
        final /* synthetic */ SwipeableState<T> $state;
        final /* synthetic */ p<T, T, ThresholdConfig> $thresholds;
        final /* synthetic */ float $velocityThreshold;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SwipeableKt$swipeable$3$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: Swipeable.kt */
        static final class AnonymousClass1 extends v implements p<Float, Float, Float> {
            final /* synthetic */ Map<Float, T> $anchors;
            final /* synthetic */ Density $density;
            final /* synthetic */ p<T, T, ThresholdConfig> $thresholds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Map<Float, ? extends T> map, p<? super T, ? super T, ? extends ThresholdConfig> pVar, Density density) {
                super(2);
                this.$anchors = map;
                this.$thresholds = pVar;
                this.$density = density;
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Float mo4invoke(Float f10, Float f11) {
                return invoke(f10.floatValue(), f11.floatValue());
            }

            @NotNull
            public final Float invoke(float f10, float f11) {
                return Float.valueOf(this.$thresholds.mo4invoke(r0.h(this.$anchors, Float.valueOf(f10)), r0.h(this.$anchors, Float.valueOf(f11))).computeThreshold(this.$density, f10, f11));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(SwipeableState<T> swipeableState, Map<Float, ? extends T> map, ResistanceConfig resistanceConfig, Density density, p<? super T, ? super T, ? extends ThresholdConfig> pVar, float f10, d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$state = swipeableState;
            this.$anchors = map;
            this.$resistance = resistanceConfig;
            this.$density = density;
            this.$thresholds = pVar;
            this.$velocityThreshold = f10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass3(this.$state, this.$anchors, this.$resistance, this.$density, this.$thresholds, this.$velocityThreshold, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Map anchors$material_release = this.$state.getAnchors$material_release();
                this.$state.setAnchors$material_release(this.$anchors);
                this.$state.setResistance$material_release(this.$resistance);
                this.$state.setThresholds$material_release(new AnonymousClass1(this.$anchors, this.$thresholds, this.$density));
                this.$state.setVelocityThreshold$material_release(this.$density.mo296toPx0680j_4(this.$velocityThreshold));
                SwipeableState<T> swipeableState = this.$state;
                Object obj2 = this.$anchors;
                this.label = 1;
                if (swipeableState.processNewAnchors$material_release(anchors$material_release, obj2, this) == objE) {
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
            return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableKt$swipeable$3$4, reason: invalid class name */
    /* JADX INFO: compiled from: Swipeable.kt */
    @f(c = "androidx.compose.material.SwipeableKt$swipeable$3$4", f = "Swipeable.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass4 extends l implements q<o0, Float, d<? super k0>, Object> {
        final /* synthetic */ SwipeableState<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SwipeableKt$swipeable$3$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: Swipeable.kt */
        @f(c = "androidx.compose.material.SwipeableKt$swipeable$3$4$1", f = "Swipeable.kt", l = {IronSourceError.ERROR_BN_UNSUPPORTED_SIZE}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ SwipeableState<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SwipeableState<T> swipeableState, float f10, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$state = swipeableState;
                this.$velocity = f10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new AnonymousClass1(this.$state, this.$velocity, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    SwipeableState<T> swipeableState = this.$state;
                    float f10 = this.$velocity;
                    this.label = 1;
                    if (swipeableState.performFling(f10, this) == objE) {
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
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(SwipeableState<T> swipeableState, d<? super AnonymousClass4> dVar) {
            super(3, dVar);
            this.$state = swipeableState;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(o0 o0Var, Float f10, d<? super k0> dVar) {
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
            k.d((o0) this.L$0, null, null, new AnonymousClass1(this.$state, this.F$0, null), 3, null);
            return k0.f35197a;
        }

        @Nullable
        public final Object invoke(@NotNull o0 o0Var, float f10, @Nullable d<? super k0> dVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$state, dVar);
            anonymousClass4.L$0 = o0Var;
            anonymousClass4.F$0 = f10;
            return anonymousClass4.invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SwipeableKt$swipeable$3(Map<Float, ? extends T> map, SwipeableState<T> swipeableState, Orientation orientation, boolean z10, MutableInteractionSource mutableInteractionSource, boolean z11, ResistanceConfig resistanceConfig, p<? super T, ? super T, ? extends ThresholdConfig> pVar, float f10) {
        super(3);
        this.$anchors = map;
        this.$state = swipeableState;
        this.$orientation = orientation;
        this.$enabled = z10;
        this.$interactionSource = mutableInteractionSource;
        this.$reverseDirection = z11;
        this.$resistance = resistanceConfig;
        this.$thresholds = pVar;
        this.$velocityThreshold = f10;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
        t.i(composed, "$this$composed");
        composer.startReplaceableGroup(43594985);
        if (!(!this.$anchors.isEmpty())) {
            throw new IllegalArgumentException("You must have at least one anchor.".toString());
        }
        if (!(d0.c0(this.$anchors.values()).size() == this.$anchors.size())) {
            throw new IllegalArgumentException("You cannot have two anchors mapped to the same state.".toString());
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        this.$state.ensureInit$material_release(this.$anchors);
        Map<Float, T> map = this.$anchors;
        SwipeableState<T> swipeableState = this.$state;
        EffectsKt.LaunchedEffect(map, swipeableState, new AnonymousClass3(swipeableState, map, this.$resistance, density, this.$thresholds, this.$velocityThreshold, null), composer, 8);
        Modifier modifierDraggable = DraggableKt.draggable(Modifier.Companion, this.$state.getDraggableState$material_release(), this.$orientation, (32 & 4) != 0 ? true : this.$enabled, (32 & 8) != 0 ? null : this.$interactionSource, (32 & 16) != 0 ? false : this.$state.isAnimationRunning(), (32 & 32) != 0 ? new DraggableKt.C08411(null) : null, (32 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : new AnonymousClass4(this.$state, null), (32 & 128) != 0 ? false : this.$reverseDirection);
        composer.endReplaceableGroup();
        return modifierDraggable;
    }
}
