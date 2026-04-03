package androidx.compose.ui.unit;

import android.content.Context;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidDensity.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidDensity_androidKt {
    @NotNull
    public static final Density Density(@NotNull Context context) {
        t.i(context, "context");
        return DensityKt.Density(context.getResources().getDisplayMetrics().density, context.getResources().getConfiguration().fontScale);
    }
}
