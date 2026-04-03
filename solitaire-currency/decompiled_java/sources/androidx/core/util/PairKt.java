package androidx.core.util;

import android.annotation.SuppressLint;
import org.jetbrains.annotations.NotNull;
import v8.s;

/* JADX INFO: compiled from: Pair.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@NotNull Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@NotNull Pair<F, S> pair) {
        return pair.second;
    }

    @NotNull
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@NotNull s<? extends F, ? extends S> sVar) {
        return new android.util.Pair<>(sVar.c(), sVar.d());
    }

    @NotNull
    public static final <F, S> Pair<F, S> toAndroidXPair(@NotNull s<? extends F, ? extends S> sVar) {
        return new Pair<>(sVar.c(), sVar.d());
    }

    @NotNull
    public static final <F, S> s<F, S> toKotlinPair(@NotNull Pair<F, S> pair) {
        return new s<>(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@NotNull android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@NotNull android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    @NotNull
    public static final <F, S> s<F, S> toKotlinPair(@NotNull android.util.Pair<F, S> pair) {
        return new s<>(pair.first, pair.second);
    }
}
