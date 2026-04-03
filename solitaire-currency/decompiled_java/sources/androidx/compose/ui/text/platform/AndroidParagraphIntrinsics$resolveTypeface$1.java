package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidParagraphIntrinsics.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidParagraphIntrinsics$resolveTypeface$1 extends v implements r<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> {
    final /* synthetic */ AndroidParagraphIntrinsics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidParagraphIntrinsics$resolveTypeface$1(AndroidParagraphIntrinsics androidParagraphIntrinsics) {
        super(4);
        this.this$0 = androidParagraphIntrinsics;
    }

    @Override // h9.r
    public /* bridge */ /* synthetic */ Typeface invoke(FontFamily fontFamily, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis) {
        return m3518invokeDPcqOEQ(fontFamily, fontWeight, fontStyle.m3416unboximpl(), fontSynthesis.m3427unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-DPcqOEQ, reason: not valid java name */
    public final Typeface m3518invokeDPcqOEQ(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i10, int i11) {
        t.i(fontWeight, "fontWeight");
        TypefaceDirtyTracker typefaceDirtyTracker = new TypefaceDirtyTracker(this.this$0.getFontFamilyResolver().mo3392resolveDPcqOEQ(fontFamily, fontWeight, i10, i11));
        this.this$0.resolvedTypefaces.add(typefaceDirtyTracker);
        return typefaceDirtyTracker.getTypeface();
    }
}
