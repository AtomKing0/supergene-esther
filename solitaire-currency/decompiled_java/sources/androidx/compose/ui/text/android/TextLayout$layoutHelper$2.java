package androidx.compose.ui.text.android;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextLayout.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextLayout$layoutHelper$2 extends v implements h9.a<LayoutHelper> {
    final /* synthetic */ TextLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextLayout$layoutHelper$2(TextLayout textLayout) {
        super(0);
        this.this$0 = textLayout;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final LayoutHelper invoke() {
        return new LayoutHelper(this.this$0.getLayout());
    }
}
