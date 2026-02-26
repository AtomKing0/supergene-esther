package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextLayoutResult;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoreText.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextController$onRemembered$1$2 extends v implements a<TextLayoutResult> {
    final /* synthetic */ TextController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextController$onRemembered$1$2(TextController textController) {
        super(0);
        this.this$0 = textController;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @Nullable
    public final TextLayoutResult invoke() {
        return this.this$0.getState().getLayoutResult();
    }
}
