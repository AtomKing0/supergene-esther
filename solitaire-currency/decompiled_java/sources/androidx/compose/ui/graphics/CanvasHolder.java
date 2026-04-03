package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidCanvas.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasHolder {

    @NotNull
    private final AndroidCanvas androidCanvas = new AndroidCanvas();

    public final void drawInto(@NotNull android.graphics.Canvas targetCanvas, @NotNull h9.l<? super Canvas, v8.k0> block) {
        kotlin.jvm.internal.t.i(targetCanvas, "targetCanvas");
        kotlin.jvm.internal.t.i(block, "block");
        android.graphics.Canvas internalCanvas = getAndroidCanvas().getInternalCanvas();
        getAndroidCanvas().setInternalCanvas(targetCanvas);
        block.invoke(getAndroidCanvas());
        getAndroidCanvas().setInternalCanvas(internalCanvas);
    }

    @NotNull
    public final AndroidCanvas getAndroidCanvas() {
        return this.androidCanvas;
    }

    public static /* synthetic */ void getAndroidCanvas$annotations() {
    }
}
