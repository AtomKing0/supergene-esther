package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidRenderEffect.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidRenderEffect_androidKt {
    @NotNull
    public static final RenderEffect asComposeRenderEffect(@NotNull android.graphics.RenderEffect renderEffect) {
        kotlin.jvm.internal.t.i(renderEffect, "<this>");
        return new AndroidRenderEffect(renderEffect);
    }
}
