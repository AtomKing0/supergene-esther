package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.TextPaint;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: LayoutIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class LayoutIntrinsics {

    @NotNull
    private final l boringMetrics$delegate;

    @NotNull
    private final l maxIntrinsicWidth$delegate;

    @NotNull
    private final l minIntrinsicWidth$delegate;

    public LayoutIntrinsics(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, int i10) {
        t.i(charSequence, "charSequence");
        t.i(textPaint, "textPaint");
        p pVar = p.f35203c;
        this.boringMetrics$delegate = n.b(pVar, new LayoutIntrinsics$boringMetrics$2(i10, charSequence, textPaint));
        this.minIntrinsicWidth$delegate = n.b(pVar, new LayoutIntrinsics$minIntrinsicWidth$2(charSequence, textPaint));
        this.maxIntrinsicWidth$delegate = n.b(pVar, new LayoutIntrinsics$maxIntrinsicWidth$2(this, charSequence, textPaint));
    }

    @Nullable
    public final BoringLayout.Metrics getBoringMetrics() {
        return (BoringLayout.Metrics) this.boringMetrics$delegate.getValue();
    }

    public final float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth$delegate.getValue()).floatValue();
    }

    public final float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth$delegate.getValue()).floatValue();
    }
}
