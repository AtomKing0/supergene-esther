package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;

/* JADX INFO: compiled from: FontFamily.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ State a(FontFamily.Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
        }
        if ((i12 & 1) != 0) {
            fontFamily = null;
        }
        if ((i12 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i12 & 4) != 0) {
            i10 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        if ((i12 & 8) != 0) {
            i11 = FontSynthesis.Companion.m3428getAllGVVA2EU();
        }
        return resolver.mo3392resolveDPcqOEQ(fontFamily, fontWeight, i10, i11);
    }
}
