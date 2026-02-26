package androidx.compose.ui.platform;

import android.view.RenderNode;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RenderNodeApi23.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
final class RenderNodeVerificationHelper28 {

    @NotNull
    public static final RenderNodeVerificationHelper28 INSTANCE = new RenderNodeVerificationHelper28();

    private RenderNodeVerificationHelper28() {
    }

    @DoNotInline
    public final int getAmbientShadowColor(@NotNull RenderNode renderNode) {
        kotlin.jvm.internal.t.i(renderNode, "renderNode");
        return renderNode.getAmbientShadowColor();
    }

    @DoNotInline
    public final int getSpotShadowColor(@NotNull RenderNode renderNode) {
        kotlin.jvm.internal.t.i(renderNode, "renderNode");
        return renderNode.getSpotShadowColor();
    }

    @DoNotInline
    public final void setAmbientShadowColor(@NotNull RenderNode renderNode, int i10) {
        kotlin.jvm.internal.t.i(renderNode, "renderNode");
        renderNode.setAmbientShadowColor(i10);
    }

    @DoNotInline
    public final void setSpotShadowColor(@NotNull RenderNode renderNode, int i10) {
        kotlin.jvm.internal.t.i(renderNode, "renderNode");
        renderNode.setSpotShadowColor(i10);
    }
}
