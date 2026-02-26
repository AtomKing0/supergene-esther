package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutIntrinsics$maxIntrinsicWidth$2 extends v implements h9.a<Float> {
    final /* synthetic */ CharSequence $charSequence;
    final /* synthetic */ TextPaint $textPaint;
    final /* synthetic */ LayoutIntrinsics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutIntrinsics$maxIntrinsicWidth$2(LayoutIntrinsics layoutIntrinsics, CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.this$0 = layoutIntrinsics;
        this.$charSequence = charSequence;
        this.$textPaint = textPaint;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Float invoke() {
        float desiredWidth;
        BoringLayout.Metrics boringMetrics = this.this$0.getBoringMetrics();
        if (boringMetrics != null) {
            desiredWidth = boringMetrics.width;
        } else {
            CharSequence charSequence = this.$charSequence;
            desiredWidth = Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.$textPaint);
        }
        if (LayoutIntrinsicsKt.shouldIncreaseMaxIntrinsic(desiredWidth, this.$charSequence, this.$textPaint)) {
            desiredWidth += 0.5f;
        }
        return Float.valueOf(desiredWidth);
    }
}
