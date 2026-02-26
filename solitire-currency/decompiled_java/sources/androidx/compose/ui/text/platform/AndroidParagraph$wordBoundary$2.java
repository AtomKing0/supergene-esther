package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.android.selection.WordBoundary;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidParagraph.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidParagraph$wordBoundary$2 extends v implements a<WordBoundary> {
    final /* synthetic */ AndroidParagraph this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidParagraph$wordBoundary$2(AndroidParagraph androidParagraph) {
        super(0);
        this.this$0 = androidParagraph;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final WordBoundary invoke() {
        return new WordBoundary(this.this$0.getTextLocale$ui_text_release(), this.this$0.layout.getText());
    }
}
