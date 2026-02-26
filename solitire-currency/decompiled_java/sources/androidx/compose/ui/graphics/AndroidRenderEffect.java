package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidRenderEffect.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class AndroidRenderEffect extends RenderEffect {

    @NotNull
    private final android.graphics.RenderEffect androidRenderEffect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidRenderEffect(@NotNull android.graphics.RenderEffect androidRenderEffect) {
        super(null);
        kotlin.jvm.internal.t.i(androidRenderEffect, "androidRenderEffect");
        this.androidRenderEffect = androidRenderEffect;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    @NotNull
    protected android.graphics.RenderEffect createRenderEffect() {
        return this.androidRenderEffect;
    }

    @NotNull
    public final android.graphics.RenderEffect getAndroidRenderEffect() {
        return this.androidRenderEffect;
    }
}
