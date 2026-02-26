package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidCanvas.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidCanvas_androidKt {

    @NotNull
    private static final android.graphics.Canvas EmptyCanvas = new android.graphics.Canvas();

    @NotNull
    public static final Canvas ActualCanvas(@NotNull ImageBitmap image) {
        kotlin.jvm.internal.t.i(image, "image");
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.setInternalCanvas(new android.graphics.Canvas(AndroidImageBitmap_androidKt.asAndroidBitmap(image)));
        return androidCanvas;
    }

    @NotNull
    public static final Canvas Canvas(@NotNull android.graphics.Canvas c10) {
        kotlin.jvm.internal.t.i(c10, "c");
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.setInternalCanvas(c10);
        return androidCanvas;
    }

    @NotNull
    public static final android.graphics.Canvas getNativeCanvas(@NotNull Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "<this>");
        return ((AndroidCanvas) canvas).getInternalCanvas();
    }
}
