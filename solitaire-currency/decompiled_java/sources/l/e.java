package l;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ContentPainterModifier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends InspectorValueInfo implements LayoutModifier, DrawModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Painter f30162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Alignment f30163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ContentScale f30164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f30165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final ColorFilter f30166e;

    /* JADX INFO: compiled from: ContentPainterModifier.kt */
    static final class a extends v implements l<Placeable.PlacementScope, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Placeable f30167g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Placeable placeable) {
            super(1);
            this.f30167g = placeable;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
            invoke2(placementScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
            Placeable.PlacementScope.placeRelative$default(placementScope, this.f30167g, 0, 0, 0.0f, 4, null);
        }
    }

    /* JADX INFO: compiled from: InspectableValue.kt */
    public static final class b extends v implements l<InspectorInfo, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Painter f30168g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Alignment f30169h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ContentScale f30170i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f30171j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ ColorFilter f30172k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Painter painter, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter) {
            super(1);
            this.f30168g = painter;
            this.f30169h = alignment;
            this.f30170i = contentScale;
            this.f30171j = f10;
            this.f30172k = colorFilter;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
            invoke2(inspectorInfo);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
            t.i(inspectorInfo, "$this$null");
            inspectorInfo.setName("content");
            inspectorInfo.getProperties().set("painter", this.f30168g);
            inspectorInfo.getProperties().set("alignment", this.f30169h);
            inspectorInfo.getProperties().set("contentScale", this.f30170i);
            inspectorInfo.getProperties().set("alpha", Float.valueOf(this.f30171j));
            inspectorInfo.getProperties().set("colorFilter", this.f30172k);
        }
    }

    public e(@NotNull Painter painter, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter) {
        super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new b(painter, alignment, contentScale, f10, colorFilter) : InspectableValueKt.getNoInspectorInfo());
        this.f30162a = painter;
        this.f30163b = alignment;
        this.f30164c = contentScale;
        this.f30165d = f10;
        this.f30166e = colorFilter;
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m4218calculateScaledSizeE7KxVPU(long j10) {
        if (Size.m1438isEmptyimpl(j10)) {
            return Size.Companion.m1445getZeroNHjbRc();
        }
        long jMo2089getIntrinsicSizeNHjbRc = this.f30162a.mo2089getIntrinsicSizeNHjbRc();
        if (jMo2089getIntrinsicSizeNHjbRc == Size.Companion.m1444getUnspecifiedNHjbRc()) {
            return j10;
        }
        float fM1436getWidthimpl = Size.m1436getWidthimpl(jMo2089getIntrinsicSizeNHjbRc);
        if (!((Float.isInfinite(fM1436getWidthimpl) || Float.isNaN(fM1436getWidthimpl)) ? false : true)) {
            fM1436getWidthimpl = Size.m1436getWidthimpl(j10);
        }
        float fM1433getHeightimpl = Size.m1433getHeightimpl(jMo2089getIntrinsicSizeNHjbRc);
        if (!((Float.isInfinite(fM1433getHeightimpl) || Float.isNaN(fM1433getHeightimpl)) ? false : true)) {
            fM1433getHeightimpl = Size.m1433getHeightimpl(j10);
        }
        long jSize = SizeKt.Size(fM1436getWidthimpl, fM1433getHeightimpl);
        return ScaleFactorKt.m3051timesUQTWf7w(jSize, this.f30164c.mo2978computeScaleFactorH7hwNQA(jSize, j10));
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m4219modifyConstraintsZezNO4M(long j10) {
        float fB;
        int iM3642getMinHeightimpl;
        float fA;
        boolean zM3639getHasFixedWidthimpl = Constraints.m3639getHasFixedWidthimpl(j10);
        boolean zM3638getHasFixedHeightimpl = Constraints.m3638getHasFixedHeightimpl(j10);
        if (zM3639getHasFixedWidthimpl && zM3638getHasFixedHeightimpl) {
            return j10;
        }
        boolean z10 = Constraints.m3637getHasBoundedWidthimpl(j10) && Constraints.m3636getHasBoundedHeightimpl(j10);
        long jMo2089getIntrinsicSizeNHjbRc = this.f30162a.mo2089getIntrinsicSizeNHjbRc();
        if (jMo2089getIntrinsicSizeNHjbRc == Size.Companion.m1444getUnspecifiedNHjbRc()) {
            return z10 ? Constraints.m3632copyZbe2FdA$default(j10, Constraints.m3641getMaxWidthimpl(j10), 0, Constraints.m3640getMaxHeightimpl(j10), 0, 10, null) : j10;
        }
        if (z10 && (zM3639getHasFixedWidthimpl || zM3638getHasFixedHeightimpl)) {
            fB = Constraints.m3641getMaxWidthimpl(j10);
            iM3642getMinHeightimpl = Constraints.m3640getMaxHeightimpl(j10);
        } else {
            float fM1436getWidthimpl = Size.m1436getWidthimpl(jMo2089getIntrinsicSizeNHjbRc);
            float fM1433getHeightimpl = Size.m1433getHeightimpl(jMo2089getIntrinsicSizeNHjbRc);
            fB = !Float.isInfinite(fM1436getWidthimpl) && !Float.isNaN(fM1436getWidthimpl) ? j.b(j10, fM1436getWidthimpl) : Constraints.m3643getMinWidthimpl(j10);
            if ((Float.isInfinite(fM1433getHeightimpl) || Float.isNaN(fM1433getHeightimpl)) ? false : true) {
                fA = j.a(j10, fM1433getHeightimpl);
                long jM4218calculateScaledSizeE7KxVPU = m4218calculateScaledSizeE7KxVPU(SizeKt.Size(fB, fA));
                return Constraints.m3632copyZbe2FdA$default(j10, ConstraintsKt.m3655constrainWidthK40F9xA(j10, j9.c.c(Size.m1436getWidthimpl(jM4218calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m3654constrainHeightK40F9xA(j10, j9.c.c(Size.m1433getHeightimpl(jM4218calculateScaledSizeE7KxVPU))), 0, 10, null);
            }
            iM3642getMinHeightimpl = Constraints.m3642getMinHeightimpl(j10);
        }
        fA = iM3642getMinHeightimpl;
        long jM4218calculateScaledSizeE7KxVPU2 = m4218calculateScaledSizeE7KxVPU(SizeKt.Size(fB, fA));
        return Constraints.m3632copyZbe2FdA$default(j10, ConstraintsKt.m3655constrainWidthK40F9xA(j10, j9.c.c(Size.m1436getWidthimpl(jM4218calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m3654constrainHeightK40F9xA(j10, j9.c.c(Size.m1433getHeightimpl(jM4218calculateScaledSizeE7KxVPU2))), 0, 10, null);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        long jM4218calculateScaledSizeE7KxVPU = m4218calculateScaledSizeE7KxVPU(contentDrawScope.mo1996getSizeNHjbRc());
        long jMo1275alignKFBX0sM = this.f30163b.mo1275alignKFBX0sM(j.e(jM4218calculateScaledSizeE7KxVPU), j.e(contentDrawScope.mo1996getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        float fM3783component1impl = IntOffset.m3783component1impl(jMo1275alignKFBX0sM);
        float fM3784component2impl = IntOffset.m3784component2impl(jMo1275alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(fM3783component1impl, fM3784component2impl);
        this.f30162a.m2095drawx_KDEd0(contentDrawScope, jM4218calculateScaledSizeE7KxVPU, this.f30165d, this.f30166e);
        contentDrawScope.getDrawContext().getTransform().translate(-fM3783component1impl, -fM3784component2impl);
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return t.d(this.f30162a, eVar.f30162a) && t.d(this.f30163b, eVar.f30163b) && t.d(this.f30164c, eVar.f30164c) && t.d(Float.valueOf(this.f30165d), Float.valueOf(eVar.f30165d)) && t.d(this.f30166e, eVar.f30166e);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f30162a.hashCode() * 31) + this.f30163b.hashCode()) * 31) + this.f30164c.hashCode()) * 31) + Float.floatToIntBits(this.f30165d)) * 31;
        ColorFilter colorFilter = this.f30166e;
        return iHashCode + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
        if (!(this.f30162a.mo2089getIntrinsicSizeNHjbRc() != Size.Companion.m1444getUnspecifiedNHjbRc())) {
            return intrinsicMeasurable.maxIntrinsicHeight(i10);
        }
        int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m3641getMaxWidthimpl(m4219modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i10, 0, 0, 13, null))));
        return Math.max(j9.c.c(Size.m1433getHeightimpl(m4218calculateScaledSizeE7KxVPU(SizeKt.Size(i10, iMaxIntrinsicHeight)))), iMaxIntrinsicHeight);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
        if (!(this.f30162a.mo2089getIntrinsicSizeNHjbRc() != Size.Companion.m1444getUnspecifiedNHjbRc())) {
            return intrinsicMeasurable.maxIntrinsicWidth(i10);
        }
        int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m3640getMaxHeightimpl(m4219modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i10, 7, null))));
        return Math.max(j9.c.c(Size.m1436getWidthimpl(m4218calculateScaledSizeE7KxVPU(SizeKt.Size(iMaxIntrinsicWidth, i10)))), iMaxIntrinsicWidth);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j10) {
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(m4219modifyConstraintsZezNO4M(j10));
        return MeasureScope.CC.p(measureScope, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new a(placeableMo2987measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
        if (!(this.f30162a.mo2089getIntrinsicSizeNHjbRc() != Size.Companion.m1444getUnspecifiedNHjbRc())) {
            return intrinsicMeasurable.minIntrinsicHeight(i10);
        }
        int iMinIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m3641getMaxWidthimpl(m4219modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i10, 0, 0, 13, null))));
        return Math.max(j9.c.c(Size.m1433getHeightimpl(m4218calculateScaledSizeE7KxVPU(SizeKt.Size(i10, iMinIntrinsicHeight)))), iMinIntrinsicHeight);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
        if (!(this.f30162a.mo2089getIntrinsicSizeNHjbRc() != Size.Companion.m1444getUnspecifiedNHjbRc())) {
            return intrinsicMeasurable.minIntrinsicWidth(i10);
        }
        int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m3640getMaxHeightimpl(m4219modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i10, 7, null))));
        return Math.max(j9.c.c(Size.m1436getWidthimpl(m4218calculateScaledSizeE7KxVPU(SizeKt.Size(iMinIntrinsicWidth, i10)))), iMinIntrinsicWidth);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "ContentPainterModifier(painter=" + this.f30162a + ", alignment=" + this.f30163b + ", contentScale=" + this.f30164c + ", alpha=" + this.f30165d + ", colorFilter=" + this.f30166e + ')';
    }
}
