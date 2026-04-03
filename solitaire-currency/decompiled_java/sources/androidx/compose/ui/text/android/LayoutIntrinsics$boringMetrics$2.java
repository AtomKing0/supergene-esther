package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.TextPaint;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LayoutIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutIntrinsics$boringMetrics$2 extends v implements h9.a<BoringLayout.Metrics> {
    final /* synthetic */ CharSequence $charSequence;
    final /* synthetic */ int $textDirectionHeuristic;
    final /* synthetic */ TextPaint $textPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutIntrinsics$boringMetrics$2(int i10, CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.$textDirectionHeuristic = i10;
        this.$charSequence = charSequence;
        this.$textPaint = textPaint;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @Nullable
    public final BoringLayout.Metrics invoke() {
        return BoringLayoutFactory.INSTANCE.measure(this.$charSequence, this.$textPaint, TextLayoutKt.getTextDirectionHeuristic(this.$textDirectionHeuristic));
    }
}
