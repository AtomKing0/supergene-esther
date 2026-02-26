package androidx.compose.ui.text.android;

import android.text.TextPaint;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutIntrinsics$minIntrinsicWidth$2 extends v implements h9.a<Float> {
    final /* synthetic */ CharSequence $charSequence;
    final /* synthetic */ TextPaint $textPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutIntrinsics$minIntrinsicWidth$2(CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.$charSequence = charSequence;
        this.$textPaint = textPaint;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Float invoke() {
        return Float.valueOf(LayoutIntrinsicsKt.minIntrinsicWidth(this.$charSequence, this.$textPaint));
    }
}
