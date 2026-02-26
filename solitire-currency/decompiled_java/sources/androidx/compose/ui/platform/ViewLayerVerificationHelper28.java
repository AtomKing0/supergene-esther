package androidx.compose.ui.platform;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewLayer.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
final class ViewLayerVerificationHelper28 {

    @NotNull
    public static final ViewLayerVerificationHelper28 INSTANCE = new ViewLayerVerificationHelper28();

    private ViewLayerVerificationHelper28() {
    }

    @DoNotInline
    public final void setOutlineAmbientShadowColor(@NotNull View view, int i10) {
        kotlin.jvm.internal.t.i(view, "view");
        view.setOutlineAmbientShadowColor(i10);
    }

    @DoNotInline
    public final void setOutlineSpotShadowColor(@NotNull View view, int i10) {
        kotlin.jvm.internal.t.i(view, "view");
        view.setOutlineSpotShadowColor(i10);
    }
}
