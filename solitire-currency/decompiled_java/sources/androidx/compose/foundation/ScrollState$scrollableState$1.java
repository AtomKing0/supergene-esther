package androidx.compose.foundation;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollState$scrollableState$1 extends v implements h9.l<Float, Float> {
    final /* synthetic */ ScrollState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollState$scrollableState$1(ScrollState scrollState) {
        super(1);
        this.this$0 = scrollState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Float invoke(Float f10) {
        return invoke(f10.floatValue());
    }

    @NotNull
    public final Float invoke(float f10) {
        float value = this.this$0.getValue() + f10 + this.this$0.accumulator;
        float fM = n9.o.m(value, 0.0f, this.this$0.getMaxValue());
        boolean z10 = !(value == fM);
        float value2 = fM - this.this$0.getValue();
        int iC = j9.c.c(value2);
        ScrollState scrollState = this.this$0;
        scrollState.setValue(scrollState.getValue() + iC);
        this.this$0.accumulator = value2 - iC;
        if (z10) {
            f10 = value2;
        }
        return Float.valueOf(f10);
    }
}
