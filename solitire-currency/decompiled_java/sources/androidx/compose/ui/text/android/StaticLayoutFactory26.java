package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StaticLayoutFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class StaticLayoutFactory26 {

    @NotNull
    public static final StaticLayoutFactory26 INSTANCE = new StaticLayoutFactory26();

    private StaticLayoutFactory26() {
    }

    @DoNotInline
    public final void setJustificationMode(@NotNull StaticLayout.Builder builder, int i10) {
        t.i(builder, "builder");
        builder.setJustificationMode(i10);
    }
}
