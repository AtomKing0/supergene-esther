package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StaticLayoutFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
final class StaticLayoutFactory28 {

    @NotNull
    public static final StaticLayoutFactory28 INSTANCE = new StaticLayoutFactory28();

    private StaticLayoutFactory28() {
    }

    @DoNotInline
    public final void setUseLineSpacingFromFallbacks(@NotNull StaticLayout.Builder builder, boolean z10) {
        t.i(builder, "builder");
        builder.setUseLineSpacingFromFallbacks(z10);
    }
}
