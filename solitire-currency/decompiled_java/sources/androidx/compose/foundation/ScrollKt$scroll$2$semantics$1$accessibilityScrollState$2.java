package androidx.compose.foundation;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2 extends v implements h9.a<Float> {
    final /* synthetic */ ScrollState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2(ScrollState scrollState) {
        super(0);
        this.$state = scrollState;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Float invoke() {
        return Float.valueOf(this.$state.getMaxValue());
    }
}
