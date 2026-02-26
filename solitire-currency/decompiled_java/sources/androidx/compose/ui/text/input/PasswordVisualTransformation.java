package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: VisualTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PasswordVisualTransformation implements VisualTransformation {
    private final char mask;

    public PasswordVisualTransformation() {
        this((char) 0, 1, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PasswordVisualTransformation) && this.mask == ((PasswordVisualTransformation) obj).mask;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    @NotNull
    public TransformedText filter(@NotNull AnnotatedString text) {
        t.i(text, "text");
        return new TransformedText(new AnnotatedString(q.C(String.valueOf(this.mask), text.getText().length()), null, null, 6, null), OffsetMapping.Companion.getIdentity());
    }

    public final char getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask;
    }

    public PasswordVisualTransformation(char c10) {
        this.mask = c10;
    }

    public /* synthetic */ PasswordVisualTransformation(char c10, int i10, k kVar) {
        this((i10 & 1) != 0 ? (char) 8226 : c10);
    }
}
