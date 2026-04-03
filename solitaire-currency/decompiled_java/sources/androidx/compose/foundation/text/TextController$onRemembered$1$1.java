package androidx.compose.foundation.text;

import androidx.compose.ui.layout.LayoutCoordinates;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoreText.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextController$onRemembered$1$1 extends v implements a<LayoutCoordinates> {
    final /* synthetic */ TextController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextController$onRemembered$1$1(TextController textController) {
        super(0);
        this.this$0 = textController;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @Nullable
    public final LayoutCoordinates invoke() {
        return this.this$0.getState().getLayoutCoordinates();
    }
}
