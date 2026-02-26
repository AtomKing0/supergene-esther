package androidx.compose.ui.text;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTextStyle.android.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class PlatformParagraphStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final PlatformParagraphStyle Default = new PlatformParagraphStyle();
    private final boolean includeFontPadding;

    /* JADX INFO: compiled from: AndroidTextStyle.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final PlatformParagraphStyle getDefault() {
            return PlatformParagraphStyle.Default;
        }
    }

    public PlatformParagraphStyle(boolean z10) {
        this.includeFontPadding = z10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlatformParagraphStyle) && this.includeFontPadding == ((PlatformParagraphStyle) obj).includeFontPadding;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public int hashCode() {
        return e.a(this.includeFontPadding);
    }

    @NotNull
    public final PlatformParagraphStyle merge(@Nullable PlatformParagraphStyle platformParagraphStyle) {
        return platformParagraphStyle == null ? this : platformParagraphStyle;
    }

    @NotNull
    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ')';
    }

    public /* synthetic */ PlatformParagraphStyle(boolean z10, int i10, k kVar) {
        this((i10 & 1) != 0 ? true : z10);
    }

    public PlatformParagraphStyle() {
        this(true);
    }

    public static /* synthetic */ void getIncludeFontPadding$annotations() {
    }
}
