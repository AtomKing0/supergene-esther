package androidx.compose.ui.platform;

import android.view.RenderNode;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RenderNodeApi23.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
final class RenderNodeVerificationHelper24 {

    @NotNull
    public static final RenderNodeVerificationHelper24 INSTANCE = new RenderNodeVerificationHelper24();

    private RenderNodeVerificationHelper24() {
    }

    @DoNotInline
    public final void discardDisplayList(@NotNull RenderNode renderNode) {
        kotlin.jvm.internal.t.i(renderNode, "renderNode");
        renderNode.discardDisplayList();
    }
}
