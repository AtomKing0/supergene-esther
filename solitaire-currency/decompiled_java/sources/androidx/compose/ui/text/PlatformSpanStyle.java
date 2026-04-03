package androidx.compose.ui.text;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTextStyle.android.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class PlatformSpanStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final PlatformSpanStyle Default = new PlatformSpanStyle();

    /* JADX INFO: compiled from: AndroidTextStyle.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final PlatformSpanStyle getDefault() {
            return PlatformSpanStyle.Default;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj || (obj instanceof PlatformSpanStyle);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlatformSpanStyle()";
    }

    @NotNull
    public final PlatformSpanStyle merge(@Nullable PlatformSpanStyle platformSpanStyle) {
        return this;
    }
}
