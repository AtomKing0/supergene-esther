package androidx.compose.ui.text.font;

import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFontResolveInterceptor.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontResolveInterceptor implements PlatformResolveInterceptor {
    private final int fontWeightAdjustment;

    public AndroidFontResolveInterceptor(int i10) {
        this.fontWeightAdjustment = i10;
    }

    private final int component1() {
        return this.fontWeightAdjustment;
    }

    public static /* synthetic */ AndroidFontResolveInterceptor copy$default(AndroidFontResolveInterceptor androidFontResolveInterceptor, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = androidFontResolveInterceptor.fontWeightAdjustment;
        }
        return androidFontResolveInterceptor.copy(i10);
    }

    @NotNull
    public final AndroidFontResolveInterceptor copy(int i10) {
        return new AndroidFontResolveInterceptor(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidFontResolveInterceptor) && this.fontWeightAdjustment == ((AndroidFontResolveInterceptor) obj).fontWeightAdjustment;
    }

    public int hashCode() {
        return this.fontWeightAdjustment;
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public /* synthetic */ FontFamily interceptFontFamily(FontFamily fontFamily) {
        return d.a(this, fontFamily);
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    /* JADX INFO: renamed from: interceptFontStyle-T2F_aPo, reason: not valid java name */
    public /* synthetic */ int mo3371interceptFontStyleT2F_aPo(int i10) {
        return d.b(this, i10);
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    /* JADX INFO: renamed from: interceptFontSynthesis-Mscr08Y, reason: not valid java name */
    public /* synthetic */ int mo3372interceptFontSynthesisMscr08Y(int i10) {
        return d.c(this, i10);
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    @NotNull
    public FontWeight interceptFontWeight(@NotNull FontWeight fontWeight) {
        t.i(fontWeight, "fontWeight");
        int i10 = this.fontWeightAdjustment;
        return (i10 == 0 || i10 == Integer.MAX_VALUE) ? fontWeight : new FontWeight(o.n(fontWeight.getWeight() + this.fontWeightAdjustment, 1, 1000));
    }

    @NotNull
    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.fontWeightAdjustment + ')';
    }
}
