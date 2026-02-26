package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BoringLayoutFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BoringLayoutFactory {

    @NotNull
    public static final BoringLayoutFactory INSTANCE = new BoringLayoutFactory();

    private BoringLayoutFactory() {
    }

    @NotNull
    public final BoringLayout create(@NotNull CharSequence text, @NotNull TextPaint paint, int i10, @NotNull BoringLayout.Metrics metrics, @NotNull Layout.Alignment alignment, boolean z10, @Nullable TextUtils.TruncateAt truncateAt, int i11) {
        t.i(text, "text");
        t.i(paint, "paint");
        t.i(metrics, "metrics");
        t.i(alignment, "alignment");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i11 >= 0) {
            return truncateAt == null ? new BoringLayout(text, paint, i10, alignment, 1.0f, 0.0f, metrics, z10) : new BoringLayout(text, paint, i10, alignment, 1.0f, 0.0f, metrics, z10, truncateAt, i11);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Nullable
    public final BoringLayout.Metrics measure(@NotNull CharSequence text, @Nullable TextPaint textPaint, @NotNull TextDirectionHeuristic textDir) {
        t.i(text, "text");
        t.i(textDir, "textDir");
        if (textDir.isRtl(text, 0, text.length())) {
            return null;
        }
        return BoringLayout.isBoring(text, textPaint, null);
    }
}
