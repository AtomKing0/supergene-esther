package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DeviceFontFamilyNameFont.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DeviceFontFamilyNameFontKt {
    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: Font-KH_DTmE, reason: not valid java name */
    public static final Font m3390FontKH_DTmE(@NotNull String familyName, @NotNull FontWeight weight, int i10) {
        t.i(familyName, "familyName");
        t.i(weight, "weight");
        return new DeviceFontFamilyNameFont(familyName, weight, i10, null);
    }

    /* JADX INFO: renamed from: Font-KH_DTmE$default, reason: not valid java name */
    public static /* synthetic */ Font m3391FontKH_DTmE$default(String str, FontWeight fontWeight, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i11 & 4) != 0) {
            i10 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        return m3390FontKH_DTmE(str, fontWeight, i10);
    }
}
