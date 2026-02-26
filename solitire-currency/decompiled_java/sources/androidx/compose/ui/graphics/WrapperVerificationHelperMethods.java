package androidx.compose.ui.graphics;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPaint.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public final class WrapperVerificationHelperMethods {

    @NotNull
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    private WrapperVerificationHelperMethods() {
    }

    @DoNotInline
    /* JADX INFO: renamed from: setBlendMode-GB0RdKg, reason: not valid java name */
    public final void m1935setBlendModeGB0RdKg(@NotNull android.graphics.Paint paint, int i10) {
        kotlin.jvm.internal.t.i(paint, "paint");
        paint.setBlendMode(AndroidBlendMode_androidKt.m1459toAndroidBlendModes9anfk8(i10));
    }
}
