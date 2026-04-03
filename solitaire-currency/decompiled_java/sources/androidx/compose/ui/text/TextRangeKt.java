package androidx.compose.ui.text;

import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextRange.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextRangeKt {
    public static final long TextRange(int i10, int i11) {
        return TextRange.m3324constructorimpl(packWithCheck(i10, i11));
    }

    /* JADX INFO: renamed from: constrain-8ffj60Q, reason: not valid java name */
    public static final long m3341constrain8ffj60Q(long j10, int i10, int i11) {
        int iN = o.n(TextRange.m3335getStartimpl(j10), i10, i11);
        int iN2 = o.n(TextRange.m3330getEndimpl(j10), i10, i11);
        return (iN == TextRange.m3335getStartimpl(j10) && iN2 == TextRange.m3330getEndimpl(j10)) ? j10 : TextRange(iN, iN2);
    }

    private static final long packWithCheck(int i10, int i11) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i10 + ']').toString());
        }
        if (i11 >= 0) {
            return (((long) i11) & 4294967295L) | (((long) i10) << 32);
        }
        throw new IllegalArgumentException(("end cannot negative. [end: " + i11 + ']').toString());
    }

    @NotNull
    /* JADX INFO: renamed from: substring-FDrldGo, reason: not valid java name */
    public static final String m3342substringFDrldGo(@NotNull CharSequence substring, long j10) {
        t.i(substring, "$this$substring");
        return substring.subSequence(TextRange.m3333getMinimpl(j10), TextRange.m3332getMaximpl(j10)).toString();
    }

    public static final long TextRange(int i10) {
        return TextRange(i10, i10);
    }
}
