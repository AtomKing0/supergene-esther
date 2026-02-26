package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextIndent.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextIndent {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TextIndent None = new TextIndent(0, 0, 3, null);
    private final long firstLine;
    private final long restLine;

    public /* synthetic */ TextIndent(long j10, long j11, k kVar) {
        this(j10, j11);
    }

    /* JADX INFO: renamed from: copy-NB67dxo$default, reason: not valid java name */
    public static /* synthetic */ TextIndent m3612copyNB67dxo$default(TextIndent textIndent, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = textIndent.firstLine;
        }
        if ((i10 & 2) != 0) {
            j11 = textIndent.restLine;
        }
        return textIndent.m3613copyNB67dxo(j10, j11);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-NB67dxo, reason: not valid java name */
    public final TextIndent m3613copyNB67dxo(long j10, long j11) {
        return new TextIndent(j10, j11, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        return TextUnit.m3851equalsimpl0(this.firstLine, textIndent.firstLine) && TextUnit.m3851equalsimpl0(this.restLine, textIndent.restLine);
    }

    /* JADX INFO: renamed from: getFirstLine-XSAIIZE, reason: not valid java name */
    public final long m3614getFirstLineXSAIIZE() {
        return this.firstLine;
    }

    /* JADX INFO: renamed from: getRestLine-XSAIIZE, reason: not valid java name */
    public final long m3615getRestLineXSAIIZE() {
        return this.restLine;
    }

    public int hashCode() {
        return (TextUnit.m3855hashCodeimpl(this.firstLine) * 31) + TextUnit.m3855hashCodeimpl(this.restLine);
    }

    @NotNull
    public String toString() {
        return "TextIndent(firstLine=" + ((Object) TextUnit.m3861toStringimpl(this.firstLine)) + ", restLine=" + ((Object) TextUnit.m3861toStringimpl(this.restLine)) + ')';
    }

    private TextIndent(long j10, long j11) {
        this.firstLine = j10;
        this.restLine = j11;
    }

    public /* synthetic */ TextIndent(long j10, long j11, int i10, k kVar) {
        this((i10 & 1) != 0 ? TextUnitKt.getSp(0) : j10, (i10 & 2) != 0 ? TextUnitKt.getSp(0) : j11, null);
    }

    /* JADX INFO: compiled from: TextIndent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final TextIndent getNone() {
            return TextIndent.None;
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }
    }
}
