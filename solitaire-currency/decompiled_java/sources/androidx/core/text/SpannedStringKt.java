package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpannedString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i10, int i11) {
        kotlin.jvm.internal.t.o(4, "T");
        return (T[]) spanned.getSpans(i10, i11, Object.class);
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = spanned.length();
        }
        kotlin.jvm.internal.t.o(4, "T");
        return spanned.getSpans(i10, i11, Object.class);
    }

    @NotNull
    public static final Spanned toSpanned(@NotNull CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
