package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StaticLayoutFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StaticLayoutFactory {

    @NotNull
    public static final StaticLayoutFactory INSTANCE = new StaticLayoutFactory();

    @NotNull
    private static final StaticLayoutFactoryImpl delegate = new StaticLayoutFactory23();

    private StaticLayoutFactory() {
    }

    @NotNull
    public final StaticLayout create(@NotNull CharSequence text, int i10, int i11, @NotNull TextPaint paint, int i12, @NotNull TextDirectionHeuristic textDir, @NotNull Layout.Alignment alignment, @IntRange(from = 0) int i13, @Nullable TextUtils.TruncateAt truncateAt, @IntRange(from = 0) int i14, @FloatRange(from = 0.0d) float f10, float f11, int i15, boolean z10, boolean z11, int i16, int i17, @Nullable int[] iArr, @Nullable int[] iArr2) {
        t.i(text, "text");
        t.i(paint, "paint");
        t.i(textDir, "textDir");
        t.i(alignment, "alignment");
        return delegate.create(new StaticLayoutParams(text, i10, i11, paint, i12, textDir, alignment, i13, truncateAt, i14, f10, f11, i15, z10, z11, i16, i17, iArr, iArr2));
    }
}
