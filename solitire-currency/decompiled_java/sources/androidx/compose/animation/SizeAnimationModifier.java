package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AnimationModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class SizeAnimationModifier extends LayoutModifierWithPassThroughIntrinsics {

    @Nullable
    private AnimData animData;

    @NotNull
    private final AnimationSpec<IntSize> animSpec;

    @Nullable
    private p<? super IntSize, ? super IntSize, k0> listener;

    @NotNull
    private final o0 scope;

    /* JADX INFO: compiled from: AnimationModifier.kt */
    @StabilityInferred(parameters = 0)
    public static final class AnimData {
        public static final int $stable = 8;

        @NotNull
        private final Animatable<IntSize, AnimationVector2D> anim;
        private long startSize;

        public /* synthetic */ AnimData(Animatable animatable, long j10, k kVar) {
            this(animatable, j10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-O0kMr_c$default, reason: not valid java name */
        public static /* synthetic */ AnimData m84copyO0kMr_c$default(AnimData animData, Animatable animatable, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                animatable = animData.anim;
            }
            if ((i10 & 2) != 0) {
                j10 = animData.startSize;
            }
            return animData.m86copyO0kMr_c(animatable, j10);
        }

        @NotNull
        public final Animatable<IntSize, AnimationVector2D> component1() {
            return this.anim;
        }

        /* JADX INFO: renamed from: component2-YbymL2g, reason: not valid java name */
        public final long m85component2YbymL2g() {
            return this.startSize;
        }

        @NotNull
        /* JADX INFO: renamed from: copy-O0kMr_c, reason: not valid java name */
        public final AnimData m86copyO0kMr_c(@NotNull Animatable<IntSize, AnimationVector2D> anim, long j10) {
            t.i(anim, "anim");
            return new AnimData(anim, j10, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnimData)) {
                return false;
            }
            AnimData animData = (AnimData) obj;
            return t.d(this.anim, animData.anim) && IntSize.m3831equalsimpl0(this.startSize, animData.startSize);
        }

        @NotNull
        public final Animatable<IntSize, AnimationVector2D> getAnim() {
            return this.anim;
        }

        /* JADX INFO: renamed from: getStartSize-YbymL2g, reason: not valid java name */
        public final long m87getStartSizeYbymL2g() {
            return this.startSize;
        }

        public int hashCode() {
            return (this.anim.hashCode() * 31) + IntSize.m3834hashCodeimpl(this.startSize);
        }

        /* JADX INFO: renamed from: setStartSize-ozmzZPI, reason: not valid java name */
        public final void m88setStartSizeozmzZPI(long j10) {
            this.startSize = j10;
        }

        @NotNull
        public String toString() {
            return "AnimData(anim=" + this.anim + ", startSize=" + ((Object) IntSize.m3836toStringimpl(this.startSize)) + ')';
        }

        private AnimData(Animatable<IntSize, AnimationVector2D> animatable, long j10) {
            this.anim = animatable;
            this.startSize = j10;
        }
    }

    public SizeAnimationModifier(@NotNull AnimationSpec<IntSize> animSpec, @NotNull o0 scope) {
        t.i(animSpec, "animSpec");
        t.i(scope, "scope");
        this.animSpec = animSpec;
        this.scope = scope;
    }

    /* JADX INFO: renamed from: animateTo-mzRDjE0, reason: not valid java name */
    public final long m83animateTomzRDjE0(long j10) {
        AnimData animData = this.animData;
        if (animData == null) {
            animData = new AnimData(new Animatable(IntSize.m3825boximpl(j10), VectorConvertersKt.getVectorConverter(IntSize.Companion), IntSize.m3825boximpl(IntSizeKt.IntSize(1, 1))), j10, null);
        } else if (!IntSize.m3831equalsimpl0(j10, animData.getAnim().getTargetValue().m3837unboximpl())) {
            animData.m88setStartSizeozmzZPI(animData.getAnim().getValue().m3837unboximpl());
            kotlinx.coroutines.k.d(this.scope, null, null, new SizeAnimationModifier$animateTo$data$1$1(animData, j10, this, null), 3, null);
        }
        this.animData = animData;
        return animData.getAnim().getValue().m3837unboximpl();
    }

    @Nullable
    public final AnimData getAnimData() {
        return this.animData;
    }

    @NotNull
    public final AnimationSpec<IntSize> getAnimSpec() {
        return this.animSpec;
    }

    @Nullable
    public final p<IntSize, IntSize, k0> getListener() {
        return this.listener;
    }

    @NotNull
    public final o0 getScope() {
        return this.scope;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
        long jM83animateTomzRDjE0 = m83animateTomzRDjE0(IntSizeKt.IntSize(placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight()));
        return MeasureScope.CC.p(measure, IntSize.m3833getWidthimpl(jM83animateTomzRDjE0), IntSize.m3832getHeightimpl(jM83animateTomzRDjE0), null, new SizeAnimationModifier$measure$1(placeableMo2987measureBRTryo0), 4, null);
    }

    public final void setAnimData(@Nullable AnimData animData) {
        this.animData = animData;
    }

    public final void setListener(@Nullable p<? super IntSize, ? super IntSize, k0> pVar) {
        this.listener = pVar;
    }
}
