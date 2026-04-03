package androidx.compose.ui.res;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ColorResources.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
final class ColorResourceHelper {

    @NotNull
    public static final ColorResourceHelper INSTANCE = new ColorResourceHelper();

    private ColorResourceHelper() {
    }

    @DoNotInline
    /* JADX INFO: renamed from: getColor-WaAFU9c, reason: not valid java name */
    public final long m3217getColorWaAFU9c(@NotNull Context context, @ColorRes int i10) {
        t.i(context, "context");
        return ColorKt.Color(context.getResources().getColor(i10, context.getTheme()));
    }
}
