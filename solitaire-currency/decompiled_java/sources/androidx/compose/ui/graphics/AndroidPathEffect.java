package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPathEffect.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPathEffect implements PathEffect {

    @NotNull
    private final android.graphics.PathEffect nativePathEffect;

    public AndroidPathEffect(@NotNull android.graphics.PathEffect nativePathEffect) {
        kotlin.jvm.internal.t.i(nativePathEffect, "nativePathEffect");
        this.nativePathEffect = nativePathEffect;
    }

    @NotNull
    public final android.graphics.PathEffect getNativePathEffect() {
        return this.nativePathEffect;
    }
}
