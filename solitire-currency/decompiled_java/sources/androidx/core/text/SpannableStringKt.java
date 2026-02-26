package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpannableString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannableStringKt {
    public static final void clearSpans(@NotNull Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@NotNull Spannable spannable, int i10, int i11, @NotNull Object obj) {
        spannable.setSpan(obj, i10, i11, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(@NotNull Spannable spannable, @NotNull n9.i iVar, @NotNull Object obj) {
        spannable.setSpan(obj, iVar.getStart().intValue(), iVar.getEndInclusive().intValue(), 17);
    }
}
