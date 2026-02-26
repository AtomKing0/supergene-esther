package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Font.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceFont implements Font {
    private final int loadingStrategy;
    private final int resId;
    private final int style;

    @NotNull
    private final FontWeight weight;

    public /* synthetic */ ResourceFont(int i10, FontWeight fontWeight, int i11, int i12, k kVar) {
        this(i10, fontWeight, i11, i12);
    }

    /* JADX INFO: renamed from: copy-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ ResourceFont m3442copyRetOiIg$default(ResourceFont resourceFont, int i10, FontWeight fontWeight, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = resourceFont.resId;
        }
        if ((i12 & 2) != 0) {
            fontWeight = resourceFont.getWeight();
        }
        if ((i12 & 4) != 0) {
            i11 = resourceFont.mo3361getStyle_LCdwA();
        }
        return resourceFont.m3445copyRetOiIg(i10, fontWeight, i11);
    }

    /* JADX INFO: renamed from: copy-YpTlLL0$default, reason: not valid java name */
    public static /* synthetic */ ResourceFont m3443copyYpTlLL0$default(ResourceFont resourceFont, int i10, FontWeight fontWeight, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = resourceFont.resId;
        }
        if ((i13 & 2) != 0) {
            fontWeight = resourceFont.getWeight();
        }
        if ((i13 & 4) != 0) {
            i11 = resourceFont.mo3361getStyle_LCdwA();
        }
        if ((i13 & 8) != 0) {
            i12 = resourceFont.mo3362getLoadingStrategyPKNRLFQ();
        }
        return resourceFont.m3446copyYpTlLL0(i10, fontWeight, i11, i12);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-RetOiIg, reason: not valid java name */
    public final ResourceFont m3445copyRetOiIg(int i10, @NotNull FontWeight weight, int i11) {
        t.i(weight, "weight");
        return m3446copyYpTlLL0(i10, weight, i11, mo3362getLoadingStrategyPKNRLFQ());
    }

    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: copy-YpTlLL0, reason: not valid java name */
    public final ResourceFont m3446copyYpTlLL0(int i10, @NotNull FontWeight weight, int i11, int i12) {
        t.i(weight, "weight");
        return new ResourceFont(i10, weight, i11, i12, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceFont)) {
            return false;
        }
        ResourceFont resourceFont = (ResourceFont) obj;
        return this.resId == resourceFont.resId && t.d(getWeight(), resourceFont.getWeight()) && FontStyle.m3413equalsimpl0(mo3361getStyle_LCdwA(), resourceFont.mo3361getStyle_LCdwA()) && FontLoadingStrategy.m3400equalsimpl0(mo3362getLoadingStrategyPKNRLFQ(), resourceFont.mo3362getLoadingStrategyPKNRLFQ());
    }

    @Override // androidx.compose.ui.text.font.Font
    @ExperimentalTextApi
    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ */
    public int mo3362getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    public final int getResId() {
        return this.resId;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int mo3361getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.Font
    @NotNull
    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((this.resId * 31) + getWeight().hashCode()) * 31) + FontStyle.m3414hashCodeimpl(mo3361getStyle_LCdwA())) * 31) + FontLoadingStrategy.m3401hashCodeimpl(mo3362getLoadingStrategyPKNRLFQ());
    }

    @NotNull
    public String toString() {
        return "ResourceFont(resId=" + this.resId + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m3415toStringimpl(mo3361getStyle_LCdwA())) + ", loadingStrategy=" + ((Object) FontLoadingStrategy.m3402toStringimpl(mo3362getLoadingStrategyPKNRLFQ())) + ')';
    }

    private ResourceFont(int i10, FontWeight fontWeight, int i11, int i12) {
        this.resId = i10;
        this.weight = fontWeight;
        this.style = i11;
        this.loadingStrategy = i12;
    }

    public /* synthetic */ ResourceFont(int i10, FontWeight fontWeight, int i11, int i12, int i13, k kVar) {
        this(i10, (i13 & 2) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i13 & 4) != 0 ? FontStyle.Companion.m3418getNormal_LCdwA() : i11, (i13 & 8) != 0 ? FontLoadingStrategy.Companion.m3404getAsyncPKNRLFQ() : i12, null);
    }

    @ExperimentalTextApi
    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ$annotations, reason: not valid java name */
    public static /* synthetic */ void m3444getLoadingStrategyPKNRLFQ$annotations() {
    }
}
