package androidx.compose.ui.graphics;

import android.graphics.BlendModeColorFilter;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidColorFilter.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class BlendModeColorFilterHelper {

    @NotNull
    public static final BlendModeColorFilterHelper INSTANCE = new BlendModeColorFilterHelper();

    private BlendModeColorFilterHelper() {
    }

    @DoNotInline
    @NotNull
    /* JADX INFO: renamed from: BlendModeColorFilter-xETnrds, reason: not valid java name */
    public final BlendModeColorFilter m1550BlendModeColorFilterxETnrds(long j10, int i10) {
        return new BlendModeColorFilter(ColorKt.m1653toArgb8_81llA(j10), AndroidBlendMode_androidKt.m1459toAndroidBlendModes9anfk8(i10));
    }
}
