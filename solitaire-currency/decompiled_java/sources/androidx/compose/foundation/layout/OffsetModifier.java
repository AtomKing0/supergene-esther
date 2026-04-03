package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes.dex */
final class OffsetModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean rtlAware;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f757x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f758y;

    public /* synthetic */ OffsetModifier(float f10, float f11, boolean z10, h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(f10, f11, z10, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetModifier offsetModifier = obj instanceof OffsetModifier ? (OffsetModifier) obj : null;
        if (offsetModifier == null) {
            return false;
        }
        return Dp.m3678equalsimpl0(this.f757x, offsetModifier.f757x) && Dp.m3678equalsimpl0(this.f758y, offsetModifier.f758y) && this.rtlAware == offsetModifier.rtlAware;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final float m389getXD9Ej5fM() {
        return this.f757x;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final float m390getYD9Ej5fM() {
        return this.f758y;
    }

    public int hashCode() {
        return (((Dp.m3679hashCodeimpl(this.f757x) * 31) + Dp.m3679hashCodeimpl(this.f758y)) * 31) + androidx.compose.foundation.e.a(this.rtlAware);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.a(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.b(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
        return MeasureScope.CC.p(measure, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new OffsetModifier$measure$1(this, placeableMo2987measureBRTryo0, measure), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.c(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.d(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "OffsetModifier(x=" + ((Object) Dp.m3684toStringimpl(this.f757x)) + ", y=" + ((Object) Dp.m3684toStringimpl(this.f758y)) + ", rtlAware=" + this.rtlAware + ')';
    }

    private OffsetModifier(float f10, float f11, boolean z10, h9.l<? super InspectorInfo, k0> lVar) {
        super(lVar);
        this.f757x = f10;
        this.f758y = f11;
        this.rtlAware = z10;
    }
}
