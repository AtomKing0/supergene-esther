package androidx.compose.animation.core;

import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.runtime.Stable;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationSpecKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, V extends AnimationVector> V convert(TwoWayConverter<T, V> twoWayConverter, T t10) {
        if (t10 == null) {
            return null;
        }
        return twoWayConverter.getConvertToVector().invoke(t10);
    }

    @Stable
    public static final /* synthetic */ InfiniteRepeatableSpec infiniteRepeatable(DurationBasedAnimationSpec animation, RepeatMode repeatMode) {
        t.i(animation, "animation");
        t.i(repeatMode, "repeatMode");
        return new InfiniteRepeatableSpec(animation, repeatMode, StartOffset.m124constructorimpl$default(0, 0, 2, null), (k) null);
    }

    public static /* synthetic */ InfiniteRepeatableSpec infiniteRepeatable$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        return infiniteRepeatable(durationBasedAnimationSpec, repeatMode);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: infiniteRepeatable-9IiC70o, reason: not valid java name */
    public static final <T> InfiniteRepeatableSpec<T> m102infiniteRepeatable9IiC70o(@NotNull DurationBasedAnimationSpec<T> animation, @NotNull RepeatMode repeatMode, long j10) {
        t.i(animation, "animation");
        t.i(repeatMode, "repeatMode");
        return new InfiniteRepeatableSpec<>(animation, repeatMode, j10, (k) null);
    }

    /* JADX INFO: renamed from: infiniteRepeatable-9IiC70o$default, reason: not valid java name */
    public static /* synthetic */ InfiniteRepeatableSpec m103infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i10 & 4) != 0) {
            j10 = StartOffset.m124constructorimpl$default(0, 0, 2, null);
        }
        return m102infiniteRepeatable9IiC70o(durationBasedAnimationSpec, repeatMode, j10);
    }

    @Stable
    @NotNull
    public static final <T> KeyframesSpec<T> keyframes(@NotNull l<? super KeyframesSpec.KeyframesSpecConfig<T>, k0> init) {
        t.i(init, "init");
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        init.invoke(keyframesSpecConfig);
        return new KeyframesSpec<>(keyframesSpecConfig);
    }

    @Stable
    public static final /* synthetic */ RepeatableSpec repeatable(int i10, DurationBasedAnimationSpec animation, RepeatMode repeatMode) {
        t.i(animation, "animation");
        t.i(repeatMode, "repeatMode");
        return new RepeatableSpec(i10, animation, repeatMode, StartOffset.m124constructorimpl$default(0, 0, 2, null), (k) null);
    }

    public static /* synthetic */ RepeatableSpec repeatable$default(int i10, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        return repeatable(i10, durationBasedAnimationSpec, repeatMode);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: repeatable-91I0pcU, reason: not valid java name */
    public static final <T> RepeatableSpec<T> m104repeatable91I0pcU(int i10, @NotNull DurationBasedAnimationSpec<T> animation, @NotNull RepeatMode repeatMode, long j10) {
        t.i(animation, "animation");
        t.i(repeatMode, "repeatMode");
        return new RepeatableSpec<>(i10, animation, repeatMode, j10, (k) null);
    }

    /* JADX INFO: renamed from: repeatable-91I0pcU$default, reason: not valid java name */
    public static /* synthetic */ RepeatableSpec m105repeatable91I0pcU$default(int i10, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i11 & 8) != 0) {
            j10 = StartOffset.m124constructorimpl$default(0, 0, 2, null);
        }
        return m104repeatable91I0pcU(i10, durationBasedAnimationSpec, repeatMode, j10);
    }

    @Stable
    @NotNull
    public static final <T> SnapSpec<T> snap(int i10) {
        return new SnapSpec<>(i10);
    }

    public static /* synthetic */ SnapSpec snap$default(int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return snap(i10);
    }

    @Stable
    @NotNull
    public static final <T> SpringSpec<T> spring(float f10, float f11, @Nullable T t10) {
        return new SpringSpec<>(f10, f11, t10);
    }

    public static /* synthetic */ SpringSpec spring$default(float f10, float f11, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1500.0f;
        }
        if ((i10 & 4) != 0) {
            obj = null;
        }
        return spring(f10, f11, obj);
    }

    @Stable
    @NotNull
    public static final <T> TweenSpec<T> tween(int i10, int i11, @NotNull Easing easing) {
        t.i(easing, "easing");
        return new TweenSpec<>(i10, i11, easing);
    }

    public static /* synthetic */ TweenSpec tween$default(int i10, int i11, Easing easing, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = AnimationConstants.DefaultDurationMillis;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            easing = EasingKt.getFastOutSlowInEasing();
        }
        return tween(i10, i11, easing);
    }
}
