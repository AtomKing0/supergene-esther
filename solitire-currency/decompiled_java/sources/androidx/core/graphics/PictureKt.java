package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Picture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture picture, int i10, int i11, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        Canvas canvasBeginRecording = picture.beginRecording(i10, i11);
        try {
            lVar.invoke(canvasBeginRecording);
            return picture;
        } finally {
            kotlin.jvm.internal.r.b(1);
            picture.endRecording();
            kotlin.jvm.internal.r.a(1);
        }
    }
}
