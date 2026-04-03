package androidx.compose.ui.text.font;

import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Font.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontKt {
    @Stable
    /* JADX INFO: renamed from: Font-RetOiIg, reason: not valid java name */
    public static final /* synthetic */ Font m3393FontRetOiIg(int i10, FontWeight weight, int i11) {
        t.i(weight, "weight");
        return new ResourceFont(i10, weight, i11, FontLoadingStrategy.Companion.m3405getBlockingPKNRLFQ(), null);
    }

    /* JADX INFO: renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m3394FontRetOiIg$default(int i10, FontWeight fontWeight, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i12 & 4) != 0) {
            i11 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        return m3393FontRetOiIg(i10, fontWeight, i11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: Font-YpTlLL0, reason: not valid java name */
    public static final Font m3395FontYpTlLL0(int i10, @NotNull FontWeight weight, int i11, int i12) {
        t.i(weight, "weight");
        return new ResourceFont(i10, weight, i11, i12, null);
    }

    /* JADX INFO: renamed from: Font-YpTlLL0$default, reason: not valid java name */
    public static /* synthetic */ Font m3396FontYpTlLL0$default(int i10, FontWeight fontWeight, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i13 & 4) != 0) {
            i11 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        if ((i13 & 8) != 0) {
            i12 = FontLoadingStrategy.Companion.m3405getBlockingPKNRLFQ();
        }
        return m3395FontYpTlLL0(i10, fontWeight, i11, i12);
    }

    @Stable
    @NotNull
    public static final FontFamily toFontFamily(@NotNull Font font) {
        t.i(font, "<this>");
        return FontFamilyKt.FontFamily(font);
    }
}
