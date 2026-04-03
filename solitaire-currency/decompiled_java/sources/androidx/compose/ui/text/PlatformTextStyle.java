package androidx.compose.ui.text;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTextStyle.android.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class PlatformTextStyle {

    @Nullable
    private final PlatformParagraphStyle paragraphStyle;

    @Nullable
    private final PlatformSpanStyle spanStyle;

    public PlatformTextStyle(@Nullable PlatformSpanStyle platformSpanStyle, @Nullable PlatformParagraphStyle platformParagraphStyle) {
        this.spanStyle = platformSpanStyle;
        this.paragraphStyle = platformParagraphStyle;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformTextStyle)) {
            return false;
        }
        PlatformTextStyle platformTextStyle = (PlatformTextStyle) obj;
        return t.d(this.paragraphStyle, platformTextStyle.paragraphStyle) && t.d(this.spanStyle, platformTextStyle.spanStyle);
    }

    @Nullable
    public final PlatformParagraphStyle getParagraphStyle() {
        return this.paragraphStyle;
    }

    @Nullable
    public final PlatformSpanStyle getSpanStyle() {
        return this.spanStyle;
    }

    public int hashCode() {
        PlatformSpanStyle platformSpanStyle = this.spanStyle;
        int iHashCode = (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.paragraphStyle;
        return iHashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlatformTextStyle(spanStyle=" + this.spanStyle + ", paragraphSyle=" + this.paragraphStyle + ')';
    }

    public /* synthetic */ PlatformTextStyle(boolean z10, int i10, k kVar) {
        this((i10 & 1) != 0 ? true : z10);
    }

    public PlatformTextStyle(boolean z10) {
        this(null, new PlatformParagraphStyle(z10));
    }
}
