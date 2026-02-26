package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewLayerContainer.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewLayerContainer extends DrawChildContainer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewLayerContainer(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
    }

    @Override // androidx.compose.ui.platform.DrawChildContainer, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
    }

    protected final void dispatchGetDisplayList() {
    }
}
