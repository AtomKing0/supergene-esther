package androidx.compose.ui.node;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ModifiedLayoutNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModifiedLayoutNode extends LayoutNodeWrapper {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Paint modifierBoundsPaint;

    @NotNull
    private LayoutModifier modifier;

    @Nullable
    private MutableState<LayoutModifier> modifierState;
    private boolean toBeReusedForSameModifier;

    @NotNull
    private LayoutNodeWrapper wrapped;

    /* JADX INFO: compiled from: ModifiedLayoutNode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Paint getModifierBoundsPaint() {
            return ModifiedLayoutNode.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1488setColor8_81llA(Color.Companion.m1625getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo1492setStylek9PVt8s(PaintingStyle.Companion.m1813getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifiedLayoutNode(@NotNull LayoutNodeWrapper wrapped, @NotNull LayoutModifier modifier) {
        super(wrapped.getLayoutNode$ui_release());
        t.i(wrapped, "wrapped");
        t.i(modifier, "modifier");
        this.wrapped = wrapped;
        this.modifier = modifier;
    }

    private final LayoutModifier modifierFromState() {
        MutableState<LayoutModifier> mutableStateMutableStateOf$default = this.modifierState;
        if (mutableStateMutableStateOf$default == null) {
            mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.modifier, null, 2, null);
        }
        this.modifierState = mutableStateMutableStateOf$default;
        return mutableStateMutableStateOf$default.getValue();
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        t.i(alignmentLine, "alignmentLine");
        if (getMeasureResult().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = getMeasureResult().getAlignmentLines().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        int i10 = getWrapped$ui_release().get(alignmentLine);
        if (i10 == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        setShallowPlacing(true);
        mo2988placeAtf8xVGno(m3127getPositionnOccac(), getZIndex(), getLayerBlock());
        setShallowPlacing(false);
        return i10 + (alignmentLine instanceof HorizontalAlignmentLine ? IntOffset.m3792getYimpl(getWrapped$ui_release().m3127getPositionnOccac()) : IntOffset.m3791getXimpl(getWrapped$ui_release().m3127getPositionnOccac()));
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    @NotNull
    public MeasureScope getMeasureScope() {
        return getWrapped$ui_release().getMeasureScope();
    }

    @NotNull
    public final LayoutModifier getModifier() {
        return this.modifier;
    }

    public final boolean getToBeReusedForSameModifier() {
        return this.toBeReusedForSameModifier;
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    @NotNull
    public LayoutNodeWrapper getWrapped$ui_release() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i10) {
        return modifierFromState().maxIntrinsicHeight(getMeasureScope(), getWrapped$ui_release(), i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i10) {
        return modifierFromState().maxIntrinsicWidth(getMeasureScope(), getWrapped$ui_release(), i10);
    }

    @Override // androidx.compose.ui.layout.Measurable
    @NotNull
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo2987measureBRTryo0(long j10) {
        m3016setMeasurementConstraintsBRTryo0(j10);
        setMeasureResult$ui_release(this.modifier.mo23measure3p2s80s(getMeasureScope(), getWrapped$ui_release(), j10));
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.mo3145resizeozmzZPI(m3013getMeasuredSizeYbymL2g());
        }
        onMeasured();
        return this;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i10) {
        return modifierFromState().minIntrinsicHeight(getMeasureScope(), getWrapped$ui_release(), i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i10) {
        return modifierFromState().minIntrinsicWidth(getMeasureScope(), getWrapped$ui_release(), i10);
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public void onInitialize() {
        super.onInitialize();
        getWrapped$ui_release().setWrappedBy$ui_release(this);
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public void onModifierChanged() {
        super.onModifierChanged();
        MutableState<LayoutModifier> mutableState = this.modifierState;
        if (mutableState == null) {
            return;
        }
        mutableState.setValue(this.modifier);
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public void performDraw(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        getWrapped$ui_release().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode$ui_release()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.LayoutNodeWrapper, androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo2988placeAtf8xVGno(long j10, float f10, @Nullable l<? super GraphicsLayerScope, k0> lVar) {
        super.mo2988placeAtf8xVGno(j10, f10, lVar);
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        boolean z10 = false;
        if (wrappedBy$ui_release != null && wrappedBy$ui_release.isShallowPlacing()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        onPlaced();
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int iM3833getWidthimpl = IntSize.m3833getWidthimpl(m3013getMeasuredSizeYbymL2g());
        LayoutDirection layoutDirection = getMeasureScope().getLayoutDirection();
        int parentWidth = companion.getParentWidth();
        LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
        Placeable.PlacementScope.parentWidth = iM3833getWidthimpl;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        getMeasureResult().placeChildren();
        Placeable.PlacementScope.parentWidth = parentWidth;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
    }

    public final void setModifier(@NotNull LayoutModifier layoutModifier) {
        t.i(layoutModifier, "<set-?>");
        this.modifier = layoutModifier;
    }

    public final void setToBeReusedForSameModifier(boolean z10) {
        this.toBeReusedForSameModifier = z10;
    }

    public void setWrapped(@NotNull LayoutNodeWrapper layoutNodeWrapper) {
        t.i(layoutNodeWrapper, "<set-?>");
        this.wrapped = layoutNodeWrapper;
    }
}
