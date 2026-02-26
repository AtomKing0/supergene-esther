package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VisualTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransformedText {

    @NotNull
    private final OffsetMapping offsetMapping;

    @NotNull
    private final AnnotatedString text;

    public TransformedText(@NotNull AnnotatedString text, @NotNull OffsetMapping offsetMapping) {
        t.i(text, "text");
        t.i(offsetMapping, "offsetMapping");
        this.text = text;
        this.offsetMapping = offsetMapping;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransformedText)) {
            return false;
        }
        TransformedText transformedText = (TransformedText) obj;
        return t.d(this.text, transformedText.text) && t.d(this.offsetMapping, transformedText.offsetMapping);
    }

    @NotNull
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    @NotNull
    public final AnnotatedString getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
    }

    @NotNull
    public String toString() {
        return "TransformedText(text=" + ((Object) this.text) + ", offsetMapping=" + this.offsetMapping + ')';
    }
}
