package androidx.compose.material;

import androidx.compose.runtime.Composer;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
final class FadeInFadeOutAnimationItem<T> {
    private final T key;

    @NotNull
    private final q<p<? super Composer, ? super Integer, k0>, Composer, Integer, k0> transition;

    /* JADX WARN: Multi-variable type inference failed */
    public FadeInFadeOutAnimationItem(T t10, @NotNull q<? super p<? super Composer, ? super Integer, k0>, ? super Composer, ? super Integer, k0> transition) {
        t.i(transition, "transition");
        this.key = t10;
        this.transition = transition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FadeInFadeOutAnimationItem copy$default(FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem, Object obj, q qVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = fadeInFadeOutAnimationItem.key;
        }
        if ((i10 & 2) != 0) {
            qVar = fadeInFadeOutAnimationItem.transition;
        }
        return fadeInFadeOutAnimationItem.copy(obj, qVar);
    }

    public final T component1() {
        return this.key;
    }

    @NotNull
    public final q<p<? super Composer, ? super Integer, k0>, Composer, Integer, k0> component2() {
        return this.transition;
    }

    @NotNull
    public final FadeInFadeOutAnimationItem<T> copy(T t10, @NotNull q<? super p<? super Composer, ? super Integer, k0>, ? super Composer, ? super Integer, k0> transition) {
        t.i(transition, "transition");
        return new FadeInFadeOutAnimationItem<>(t10, transition);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FadeInFadeOutAnimationItem)) {
            return false;
        }
        FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) obj;
        return t.d(this.key, fadeInFadeOutAnimationItem.key) && t.d(this.transition, fadeInFadeOutAnimationItem.transition);
    }

    public final T getKey() {
        return this.key;
    }

    @NotNull
    public final q<p<? super Composer, ? super Integer, k0>, Composer, Integer, k0> getTransition() {
        return this.transition;
    }

    public int hashCode() {
        T t10 = this.key;
        return ((t10 == null ? 0 : t10.hashCode()) * 31) + this.transition.hashCode();
    }

    @NotNull
    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + ')';
    }
}
