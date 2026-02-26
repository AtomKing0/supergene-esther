package androidx.compose.ui.node;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: InnerPlaceable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InnerPlaceable extends LayoutNodeWrapper implements Density {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Paint innerBoundsPaint;
    private final /* synthetic */ MeasureScope $$delegate_0;

    /* JADX INFO: compiled from: InnerPlaceable.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Paint getInnerBoundsPaint() {
            return InnerPlaceable.innerBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1488setColor8_81llA(Color.Companion.m1632getRed0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo1492setStylek9PVt8s(PaintingStyle.Companion.m1813getStrokeTiuSbCo());
        innerBoundsPaint = Paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerPlaceable(@NotNull LayoutNode layoutNode) {
        super(layoutNode);
        t.i(layoutNode, "layoutNode");
        this.$$delegate_0 = layoutNode.getMeasureScope$ui_release();
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        t.i(alignmentLine, "alignmentLine");
        Integer num = getLayoutNode$ui_release().calculateAlignmentLines$ui_release().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    @NotNull
    public MeasureScope getMeasureScope() {
        return getLayoutNode$ui_release().getMeasureScope$ui_release();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0 A[EDGE_INSN: B:38:0x00a0->B:36:0x00a0 BREAK  A[LOOP:0: B:21:0x0064->B:40:?], SYNTHETIC] */
    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    /* JADX INFO: renamed from: hitTestChild-YqVAtuI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T extends androidx.compose.ui.node.LayoutNodeEntity<T, M>, C, M extends androidx.compose.ui.Modifier> void mo3095hitTestChildYqVAtuI(@org.jetbrains.annotations.NotNull androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource<T, C, M> r20, long r21, @org.jetbrains.annotations.NotNull androidx.compose.ui.node.HitTestResult<C> r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r0 = r19
            r8 = r20
            r9 = r21
            r11 = r23
            java.lang.String r1 = "hitTestSource"
            kotlin.jvm.internal.t.i(r8, r1)
            java.lang.String r1 = "hitTestResult"
            kotlin.jvm.internal.t.i(r11, r1)
            androidx.compose.ui.node.LayoutNode r1 = r19.getLayoutNode$ui_release()
            boolean r1 = r8.shouldHitTestChildren(r1)
            r12 = 1
            r13 = 0
            if (r1 == 0) goto L46
            boolean r1 = r0.m3132withinLayerBoundsk4lQ0M(r9)
            if (r1 == 0) goto L28
            r14 = r25
            r1 = r12
            goto L49
        L28:
            if (r24 == 0) goto L46
            long r1 = r19.m3126getMinimumTouchTargetSizeNHjbRc()
            float r1 = r0.m3123distanceInMinimumTouchTargettz77jQw(r9, r1)
            boolean r2 = java.lang.Float.isInfinite(r1)
            if (r2 != 0) goto L40
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L40
            r1 = r12
            goto L41
        L40:
            r1 = r13
        L41:
            if (r1 == 0) goto L46
            r1 = r12
            r14 = r13
            goto L49
        L46:
            r14 = r25
            r1 = r13
        L49:
            if (r1 == 0) goto La3
            int r15 = androidx.compose.ui.node.HitTestResult.access$getHitDepth$p(r23)
            androidx.compose.ui.node.LayoutNode r1 = r19.getLayoutNode$ui_release()
            androidx.compose.runtime.collection.MutableVector r1 = r1.getZSortedChildren()
            int r2 = r1.getSize()
            if (r2 <= 0) goto La0
            int r2 = r2 - r12
            java.lang.Object[] r16 = r1.getContent()
            r17 = r2
        L64:
            r1 = r16[r17]
            r18 = r1
            androidx.compose.ui.node.LayoutNode r18 = (androidx.compose.ui.node.LayoutNode) r18
            boolean r1 = r18.isPlaced()
            if (r1 == 0) goto L99
            r1 = r20
            r2 = r18
            r3 = r21
            r5 = r23
            r6 = r24
            r7 = r14
            r1.mo3133childHitTestYqVAtuI(r2, r3, r5, r6, r7)
            boolean r1 = r23.hasHit()
            if (r1 != 0) goto L86
        L84:
            r1 = r12
            goto L95
        L86:
            androidx.compose.ui.node.LayoutNodeWrapper r1 = r18.getOuterLayoutNodeWrapper$ui_release()
            boolean r1 = r1.shouldSharePointerInputWithSiblings()
            if (r1 == 0) goto L94
            r23.acceptHits()
            goto L84
        L94:
            r1 = r13
        L95:
            if (r1 != 0) goto L99
            r1 = r12
            goto L9a
        L99:
            r1 = r13
        L9a:
            if (r1 != 0) goto La0
            int r17 = r17 + (-1)
            if (r17 >= 0) goto L64
        La0:
            androidx.compose.ui.node.HitTestResult.access$setHitDepth$p(r11, r15)
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerPlaceable.mo3095hitTestChildYqVAtuI(androidx.compose.ui.node.LayoutNodeWrapper$HitTestSource, long, androidx.compose.ui.node.HitTestResult, boolean, boolean):void");
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i10) {
        return getLayoutNode$ui_release().getIntrinsicsPolicy$ui_release().maxIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i10) {
        return getLayoutNode$ui_release().getIntrinsicsPolicy$ui_release().maxIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.layout.Measurable
    @NotNull
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo2987measureBRTryo0(long j10) {
        m3016setMeasurementConstraintsBRTryo0(j10);
        MutableVector<LayoutNode> mutableVector = getLayoutNode$ui_release().get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                content[i10].setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i10++;
            } while (i10 < size);
        }
        getLayoutNode$ui_release().handleMeasureResult$ui_release(getLayoutNode$ui_release().getMeasurePolicy().mo8measure3p2s80s(getLayoutNode$ui_release().getMeasureScope$ui_release(), getLayoutNode$ui_release().getChildren$ui_release(), j10));
        onMeasured();
        return this;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i10) {
        return getLayoutNode$ui_release().getIntrinsicsPolicy$ui_release().minIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i10) {
        return getLayoutNode$ui_release().getIntrinsicsPolicy$ui_release().minIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public void performDraw(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode$ui_release());
        MutableVector<LayoutNode> zSortedChildren = getLayoutNode$ui_release().getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            LayoutNode[] content = zSortedChildren.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode = content[i10];
                if (layoutNode.isPlaced()) {
                    layoutNode.draw$ui_release(canvas);
                }
                i10++;
            } while (i10 < size);
        }
        if (ownerRequireOwner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
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
        getLayoutNode$ui_release().onNodePlaced$ui_release();
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo289roundToPxR2X_6o(long j10) {
        return this.$$delegate_0.mo289roundToPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo290roundToPx0680j_4(float f10) {
        return this.$$delegate_0.mo290roundToPx0680j_4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo291toDpGaN1DYA(long j10) {
        return this.$$delegate_0.mo291toDpGaN1DYA(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo292toDpu2uoSUM(float f10) {
        return this.$$delegate_0.mo292toDpu2uoSUM(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo294toDpSizekrfVVM(long j10) {
        return this.$$delegate_0.mo294toDpSizekrfVVM(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo295toPxR2X_6o(long j10) {
        return this.$$delegate_0.mo295toPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo296toPx0680j_4(float f10) {
        return this.$$delegate_0.mo296toPx0680j_4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        t.i(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo297toSizeXkaWNTQ(long j10) {
        return this.$$delegate_0.mo297toSizeXkaWNTQ(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo298toSp0xMU5do(float f10) {
        return this.$$delegate_0.mo298toSp0xMU5do(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo299toSpkPz2Gy4(float f10) {
        return this.$$delegate_0.mo299toSpkPz2Gy4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo293toDpu2uoSUM(int i10) {
        return this.$$delegate_0.mo293toDpu2uoSUM(i10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo300toSpkPz2Gy4(int i10) {
        return this.$$delegate_0.mo300toSpkPz2Gy4(i10);
    }
}
