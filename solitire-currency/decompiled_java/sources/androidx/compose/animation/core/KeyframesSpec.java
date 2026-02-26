package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import h9.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {

    @NotNull
    private final KeyframesSpecConfig<T> config;

    /* JADX INFO: compiled from: AnimationSpec.kt */
    @StabilityInferred(parameters = 0)
    public static final class KeyframesSpecConfig<T> {
        public static final int $stable = 8;
        private int delayMillis;
        private int durationMillis = AnimationConstants.DefaultDurationMillis;

        @NotNull
        private final Map<Integer, KeyframeEntity<T>> keyframes = new LinkedHashMap();

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final KeyframeEntity<T> at(T t10, int i10) {
            KeyframeEntity<T> keyframeEntity = new KeyframeEntity<>(t10, null, 2, 0 == true ? 1 : 0);
            this.keyframes.put(Integer.valueOf(i10), keyframeEntity);
            return keyframeEntity;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof KeyframesSpecConfig) {
                KeyframesSpecConfig keyframesSpecConfig = (KeyframesSpecConfig) obj;
                if (this.delayMillis == keyframesSpecConfig.delayMillis && this.durationMillis == keyframesSpecConfig.durationMillis && t.d(this.keyframes, keyframesSpecConfig.keyframes)) {
                    return true;
                }
            }
            return false;
        }

        public final int getDelayMillis() {
            return this.delayMillis;
        }

        public final int getDurationMillis() {
            return this.durationMillis;
        }

        @NotNull
        public final Map<Integer, KeyframeEntity<T>> getKeyframes$animation_core_release() {
            return this.keyframes;
        }

        public int hashCode() {
            return (((this.durationMillis * 31) + this.delayMillis) * 31) + this.keyframes.hashCode();
        }

        public final void setDelayMillis(int i10) {
            this.delayMillis = i10;
        }

        public final void setDurationMillis(int i10) {
            this.durationMillis = i10;
        }

        public final void with(@NotNull KeyframeEntity<T> keyframeEntity, @NotNull Easing easing) {
            t.i(keyframeEntity, "<this>");
            t.i(easing, "easing");
            keyframeEntity.setEasing$animation_core_release(easing);
        }
    }

    public KeyframesSpec(@NotNull KeyframesSpecConfig<T> config) {
        t.i(config, "config");
        this.config = config;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KeyframesSpec) && t.d(this.config, ((KeyframesSpec) obj).config);
    }

    @NotNull
    public final KeyframesSpecConfig<T> getConfig() {
        return this.config;
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    /* JADX INFO: compiled from: AnimationSpec.kt */
    @StabilityInferred(parameters = 0)
    public static final class KeyframeEntity<T> {
        public static final int $stable = 8;

        @NotNull
        private Easing easing;
        private final T value;

        public KeyframeEntity(T t10, @NotNull Easing easing) {
            t.i(easing, "easing");
            this.value = t10;
            this.easing = easing;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof KeyframeEntity) {
                KeyframeEntity keyframeEntity = (KeyframeEntity) obj;
                if (t.d(keyframeEntity.value, this.value) && t.d(keyframeEntity.easing, this.easing)) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public final Easing getEasing$animation_core_release() {
            return this.easing;
        }

        public final T getValue$animation_core_release() {
            return this.value;
        }

        public int hashCode() {
            T t10 = this.value;
            return ((t10 != null ? t10.hashCode() : 0) * 31) + this.easing.hashCode();
        }

        public final void setEasing$animation_core_release(@NotNull Easing easing) {
            t.i(easing, "<set-?>");
            this.easing = easing;
        }

        @NotNull
        public final <V extends AnimationVector> s<V, Easing> toPair$animation_core_release(@NotNull l<? super T, ? extends V> convertToVector) {
            t.i(convertToVector, "convertToVector");
            return y.a(convertToVector.invoke(this.value), this.easing);
        }

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i10, k kVar) {
            this(obj, (i10 & 2) != 0 ? EasingKt.getLinearEasing() : easing);
        }
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    @NotNull
    public <V extends AnimationVector> VectorizedKeyframesSpec<V> vectorize(@NotNull TwoWayConverter<T, V> converter) {
        t.i(converter, "converter");
        Map<Integer, KeyframeEntity<T>> keyframes$animation_core_release = this.config.getKeyframes$animation_core_release();
        LinkedHashMap linkedHashMap = new LinkedHashMap(q0.d(keyframes$animation_core_release.size()));
        Iterator<T> it = keyframes$animation_core_release.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((KeyframeEntity) entry.getValue()).toPair$animation_core_release(converter.getConvertToVector()));
        }
        return new VectorizedKeyframesSpec<>(linkedHashMap, this.config.getDurationMillis(), this.config.getDelayMillis());
    }
}
