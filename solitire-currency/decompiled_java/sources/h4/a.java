package h4;

import android.graphics.Canvas;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: CanvasCompat.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static int a(@NonNull Canvas canvas, float f10, float f11, float f12, float f13, int i10) {
        return canvas.saveLayerAlpha(f10, f11, f12, f13, i10);
    }
}
