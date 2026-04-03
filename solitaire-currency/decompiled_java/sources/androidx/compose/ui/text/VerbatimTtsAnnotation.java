package androidx.compose.ui.text;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TtsAnnotation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VerbatimTtsAnnotation extends TtsAnnotation {

    @NotNull
    private final String verbatim;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerbatimTtsAnnotation(@NotNull String verbatim) {
        super(null);
        t.i(verbatim, "verbatim");
        this.verbatim = verbatim;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VerbatimTtsAnnotation) && t.d(this.verbatim, ((VerbatimTtsAnnotation) obj).verbatim);
    }

    @NotNull
    public final String getVerbatim() {
        return this.verbatim;
    }

    public int hashCode() {
        return this.verbatim.hashCode();
    }

    @NotNull
    public String toString() {
        return "VerbatimTtsAnnotation(verbatim=" + this.verbatim + ')';
    }
}
