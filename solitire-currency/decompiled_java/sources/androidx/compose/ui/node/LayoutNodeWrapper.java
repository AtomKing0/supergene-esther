package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.EntityList;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.z0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: LayoutNodeWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutNodeWrapper extends Placeable implements Measurable, LayoutCoordinates, OwnerScope, l<Canvas, k0> {

    @NotNull
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";

    @NotNull
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private boolean _isAttached;

    @Nullable
    private MeasureResult _measureResult;

    @Nullable
    private MutableRect _rectCache;

    @NotNull
    private final LayoutNodeEntity<?, ?>[] entities;

    @NotNull
    private final h9.a<k0> invalidateParentLayer;
    private boolean isClipping;
    private boolean isShallowPlacing;
    private float lastLayerAlpha;
    private boolean lastLayerDrawingWasSkipped;

    @Nullable
    private OwnedLayer layer;

    @Nullable
    private l<? super GraphicsLayerScope, k0> layerBlock;

    @NotNull
    private Density layerDensity;

    @NotNull
    private LayoutDirection layerLayoutDirection;

    @NotNull
    private final LayoutNode layoutNode;

    @Nullable
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;

    @Nullable
    private LayoutNodeWrapper wrappedBy;
    private float zIndex;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final l<LayoutNodeWrapper, k0> onCommitAffectingLayerParams = LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1.INSTANCE;

    @NotNull
    private static final l<LayoutNodeWrapper, k0> onCommitAffectingLayer = LayoutNodeWrapper$Companion$onCommitAffectingLayer$1.INSTANCE;

    @NotNull
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();

    @NotNull
    private static final HitTestSource<PointerInputEntity, PointerInputFilter, PointerInputModifier> PointerInputSource = new HitTestSource<PointerInputEntity, PointerInputFilter, PointerInputModifier>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        /* JADX INFO: renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo3133childHitTestYqVAtuI(@NotNull LayoutNode layoutNode, long j10, @NotNull HitTestResult<PointerInputFilter> hitTestResult, boolean z10, boolean z11) {
            t.i(layoutNode, "layoutNode");
            t.i(hitTestResult, "hitTestResult");
            layoutNode.m3100hitTestM_7yMNQ$ui_release(j10, hitTestResult, z10, z11);
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        /* JADX INFO: renamed from: entityType-EEbPh1w, reason: not valid java name */
        public int mo3134entityTypeEEbPh1w() {
            return EntityList.Companion.m3084getPointerInputEntityTypeEEbPh1w();
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public boolean shouldHitTestChildren(@NotNull LayoutNode parentLayoutNode) {
            t.i(parentLayoutNode, "parentLayoutNode");
            return true;
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        @NotNull
        public PointerInputFilter contentFrom(@NotNull PointerInputEntity entity) {
            t.i(entity, "entity");
            return entity.getModifier().getPointerInputFilter();
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(@NotNull PointerInputEntity entity) {
            t.i(entity, "entity");
            return entity.getModifier().getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
        }
    };

    @NotNull
    private static final HitTestSource<SemanticsEntity, SemanticsEntity, SemanticsModifier> SemanticsSource = new HitTestSource<SemanticsEntity, SemanticsEntity, SemanticsModifier>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        public void mo3133childHitTestYqVAtuI(@NotNull LayoutNode layoutNode, long j10, @NotNull HitTestResult<SemanticsEntity> hitTestResult, boolean z10, boolean z11) {
            t.i(layoutNode, "layoutNode");
            t.i(hitTestResult, "hitTestResult");
            layoutNode.m3101hitTestSemanticsM_7yMNQ$ui_release(j10, hitTestResult, z10, z11);
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        @NotNull
        public SemanticsEntity contentFrom(@NotNull SemanticsEntity entity) {
            t.i(entity, "entity");
            return entity;
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        /* JADX INFO: renamed from: entityType-EEbPh1w */
        public int mo3134entityTypeEEbPh1w() {
            return EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w();
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(@NotNull SemanticsEntity entity) {
            t.i(entity, "entity");
            return false;
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public boolean shouldHitTestChildren(@NotNull LayoutNode parentLayoutNode) {
            SemanticsConfiguration semanticsConfigurationCollapsedSemanticsConfiguration;
            t.i(parentLayoutNode, "parentLayoutNode");
            SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(parentLayoutNode);
            boolean z10 = false;
            if (outerSemantics != null && (semanticsConfigurationCollapsedSemanticsConfiguration = outerSemantics.collapsedSemanticsConfiguration()) != null && semanticsConfigurationCollapsedSemanticsConfiguration.isClearingSemantics()) {
                z10 = true;
            }
            return !z10;
        }
    };

    /* JADX INFO: compiled from: LayoutNodeWrapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final HitTestSource<PointerInputEntity, PointerInputFilter, PointerInputModifier> getPointerInputSource() {
            return LayoutNodeWrapper.PointerInputSource;
        }

        @NotNull
        public final HitTestSource<SemanticsEntity, SemanticsEntity, SemanticsModifier> getSemanticsSource() {
            return LayoutNodeWrapper.SemanticsSource;
        }
    }

    /* JADX INFO: compiled from: LayoutNodeWrapper.kt */
    public interface HitTestSource<T extends LayoutNodeEntity<T, M>, C, M extends Modifier> {
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        void mo3133childHitTestYqVAtuI(@NotNull LayoutNode layoutNode, long j10, @NotNull HitTestResult<C> hitTestResult, boolean z10, boolean z11);

        C contentFrom(@NotNull T t10);

        /* JADX INFO: renamed from: entityType-EEbPh1w */
        int mo3134entityTypeEEbPh1w();

        boolean interceptOutOfBoundsChildEvents(@NotNull T t10);

        boolean shouldHitTestChildren(@NotNull LayoutNode layoutNode);
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.LayoutNodeWrapper$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: LayoutNodeWrapper.kt */
    static final class AnonymousClass1 extends v implements h9.a<k0> {
        final /* synthetic */ Canvas $canvas;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Canvas canvas) {
            super(0);
            this.$canvas = canvas;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LayoutNodeWrapper.this.drawContainedDrawModifiers(this.$canvas);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.LayoutNodeWrapper$updateLayerParameters$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LayoutNodeWrapper.kt */
    static final class C10001 extends v implements h9.a<k0> {
        final /* synthetic */ l<GraphicsLayerScope, k0> $layerBlock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10001(l<? super GraphicsLayerScope, k0> lVar) {
            super(0);
            this.$layerBlock = lVar;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$layerBlock.invoke(LayoutNodeWrapper.graphicsLayerScope);
        }
    }

    public LayoutNodeWrapper(@NotNull LayoutNode layoutNode) {
        t.i(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.Companion.m3801getZeronOccac();
        this.entities = EntityList.m3069constructorimpl$default(null, 1, null);
        this.invalidateParentLayer = new LayoutNodeWrapper$invalidateParentLayer$1(this);
    }

    private final void ancestorToLocal(LayoutNodeWrapper layoutNodeWrapper, MutableRect mutableRect, boolean z10) {
        if (layoutNodeWrapper == this) {
            return;
        }
        LayoutNodeWrapper layoutNodeWrapper2 = this.wrappedBy;
        if (layoutNodeWrapper2 != null) {
            layoutNodeWrapper2.ancestorToLocal(layoutNodeWrapper, mutableRect, z10);
        }
        fromParentRect(mutableRect, z10);
    }

    /* JADX INFO: renamed from: ancestorToLocal-R5De75A, reason: not valid java name */
    private final long m3117ancestorToLocalR5De75A(LayoutNodeWrapper layoutNodeWrapper, long j10) {
        if (layoutNodeWrapper == this) {
            return j10;
        }
        LayoutNodeWrapper layoutNodeWrapper2 = this.wrappedBy;
        return (layoutNodeWrapper2 == null || t.d(layoutNodeWrapper, layoutNodeWrapper2)) ? m3124fromParentPositionMKHz9U(j10) : m3124fromParentPositionMKHz9U(layoutNodeWrapper2.m3117ancestorToLocalR5De75A(layoutNodeWrapper, j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        DrawEntity drawEntity = (DrawEntity) EntityList.m3077head0OSVbXo(this.entities, EntityList.Companion.m3081getDrawEntityTypeEEbPh1w());
        if (drawEntity == null) {
            performDraw(canvas);
        } else {
            drawEntity.draw(canvas);
        }
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z10) {
        float fM3791getXimpl = IntOffset.m3791getXimpl(this.position);
        mutableRect.setLeft(mutableRect.getLeft() - fM3791getXimpl);
        mutableRect.setRight(mutableRect.getRight() - fM3791getXimpl);
        float fM3792getYimpl = IntOffset.m3792getYimpl(this.position);
        mutableRect.setTop(mutableRect.getTop() - fM3792getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() - fM3792getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z10) {
                mutableRect.intersect(0.0f, 0.0f, IntSize.m3833getWidthimpl(mo2989getSizeYbymL2g()), IntSize.m3832getHeightimpl(mo2989getSizeYbymL2g()));
                mutableRect.isEmpty();
            }
        }
    }

    private final boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hit-1hIXUjU, reason: not valid java name */
    public final <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void m3118hit1hIXUjU(T t10, HitTestSource<T, C, M> hitTestSource, long j10, HitTestResult<C> hitTestResult, boolean z10, boolean z11) {
        if (t10 == null) {
            mo3095hitTestChildYqVAtuI(hitTestSource, j10, hitTestResult, z10, z11);
        } else {
            hitTestResult.hit(hitTestSource.contentFrom(t10), z11, new LayoutNodeWrapper$hit$1(this, t10, hitTestSource, j10, hitTestResult, z10, z11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void m3119hitNearJHbHoSQ(T t10, HitTestSource<T, C, M> hitTestSource, long j10, HitTestResult<C> hitTestResult, boolean z10, boolean z11, float f10) {
        if (t10 == null) {
            mo3095hitTestChildYqVAtuI(hitTestSource, j10, hitTestResult, z10, z11);
        } else {
            hitTestResult.hitInMinimumTouchTarget(hitTestSource.contentFrom(t10), f10, z11, new LayoutNodeWrapper$hitNear$1(this, t10, hitTestSource, j10, hitTestResult, z10, z11, f10));
        }
    }

    /* JADX INFO: renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m3120offsetFromEdgeMKHz9U(long j10) {
        float fM1367getXimpl = Offset.m1367getXimpl(j10);
        float fMax = Math.max(0.0f, fM1367getXimpl < 0.0f ? -fM1367getXimpl : fM1367getXimpl - getMeasuredWidth());
        float fM1368getYimpl = Offset.m1368getYimpl(j10);
        return OffsetKt.Offset(fMax, Math.max(0.0f, fM1368getYimpl < 0.0f ? -fM1368getYimpl : fM1368getYimpl - getMeasuredHeight()));
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(LayoutNodeWrapper layoutNodeWrapper, Rect rect, d dVar) {
        LayoutNodeWrapper layoutNodeWrapper2 = layoutNodeWrapper.wrappedBy;
        if (layoutNodeWrapper2 == null) {
            return k0.f35197a;
        }
        Object objPropagateRelocationRequest = layoutNodeWrapper2.propagateRelocationRequest(rect.m1404translatek4lQ0M(layoutNodeWrapper2.localBoundingBoxOf(layoutNodeWrapper, false).m1402getTopLeftF1C5BW0()), dVar);
        return objPropagateRelocationRequest == a9.d.e() ? objPropagateRelocationRequest : k0.f35197a;
    }

    public static /* synthetic */ void rectInParent$ui_release$default(LayoutNodeWrapper layoutNodeWrapper, MutableRect mutableRect, boolean z10, boolean z11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        layoutNodeWrapper.rectInParent$ui_release(mutableRect, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void m3121speculativeHitJHbHoSQ(T t10, HitTestSource<T, C, M> hitTestSource, long j10, HitTestResult<C> hitTestResult, boolean z10, boolean z11, float f10) {
        if (t10 == null) {
            mo3095hitTestChildYqVAtuI(hitTestSource, j10, hitTestResult, z10, z11);
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(t10)) {
            hitTestResult.speculativeHit(hitTestSource.contentFrom(t10), f10, z11, new LayoutNodeWrapper$speculativeHit$1(this, t10, hitTestSource, j10, hitTestResult, z10, z11, f10));
        } else {
            m3121speculativeHitJHbHoSQ(t10.getNext(), hitTestSource, j10, hitTestResult, z10, z11, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLayerParameters() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            l<? super GraphicsLayerScope, k0> lVar = this.layerBlock;
            if (lVar == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui_release(this.layoutNode.getDensity());
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new C10001(lVar));
            ownedLayer.mo3146updateLayerPropertiesNHXXZp8(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.mo1740getTransformOriginSzJe1aQ(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getClip(), reusableGraphicsLayerScope.getRenderEffect(), reusableGraphicsLayerScope.mo1738getAmbientShadowColor0d7_KjU(), reusableGraphicsLayerScope.mo1739getSpotShadowColor0d7_KjU(), this.layoutNode.getLayoutDirection(), this.layoutNode.getDensity());
            this.isClipping = reusableGraphicsLayerScope.getClip();
        } else {
            if (!(this.layerBlock == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(this.layoutNode);
        }
    }

    public void attach() {
        this._isAttached = true;
        onLayerBlockUpdated(this.layerBlock);
        for (LayoutNodeEntity<?, ?> next : this.entities) {
            for (; next != null; next = next.getNext()) {
                next.onAttach();
            }
        }
    }

    public abstract int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine);

    /* JADX INFO: renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m3122calculateMinimumTouchTargetPaddingE7KxVPU(long j10) {
        return SizeKt.Size(Math.max(0.0f, (Size.m1436getWidthimpl(j10) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m1433getHeightimpl(j10) - getMeasuredHeight()) / 2.0f));
    }

    public void detach() {
        for (LayoutNodeEntity<?, ?> next : this.entities) {
            for (; next != null; next = next.getNext()) {
                next.onDetach();
            }
        }
        this._isAttached = false;
        onLayerBlockUpdated(this.layerBlock);
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    /* JADX INFO: renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    protected final float m3123distanceInMinimumTouchTargettz77jQw(long j10, long j11) {
        if (getMeasuredWidth() >= Size.m1436getWidthimpl(j11) && getMeasuredHeight() >= Size.m1433getHeightimpl(j11)) {
            return Float.POSITIVE_INFINITY;
        }
        long jM3122calculateMinimumTouchTargetPaddingE7KxVPU = m3122calculateMinimumTouchTargetPaddingE7KxVPU(j11);
        float fM1436getWidthimpl = Size.m1436getWidthimpl(jM3122calculateMinimumTouchTargetPaddingE7KxVPU);
        float fM1433getHeightimpl = Size.m1433getHeightimpl(jM3122calculateMinimumTouchTargetPaddingE7KxVPU);
        long jM3120offsetFromEdgeMKHz9U = m3120offsetFromEdgeMKHz9U(j10);
        if ((fM1436getWidthimpl > 0.0f || fM1433getHeightimpl > 0.0f) && Offset.m1367getXimpl(jM3120offsetFromEdgeMKHz9U) <= fM1436getWidthimpl && Offset.m1368getYimpl(jM3120offsetFromEdgeMKHz9U) <= fM1433getHeightimpl) {
            return Offset.m1366getDistanceSquaredimpl(jM3120offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void draw(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float fM3791getXimpl = IntOffset.m3791getXimpl(this.position);
        float fM3792getYimpl = IntOffset.m3792getYimpl(this.position);
        canvas.translate(fM3791getXimpl, fM3792getYimpl);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-fM3791getXimpl, -fM3792getYimpl);
    }

    protected final void drawBorder(@NotNull Canvas canvas, @NotNull Paint paint) {
        t.i(canvas, "canvas");
        t.i(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m3833getWidthimpl(m3013getMeasuredSizeYbymL2g()) - 0.5f, IntSize.m3832getHeightimpl(m3013getMeasuredSizeYbymL2g()) - 0.5f), paint);
    }

    @NotNull
    public final LayoutNodeWrapper findCommonAncestor$ui_release(@NotNull LayoutNodeWrapper other) {
        t.i(other, "other");
        LayoutNode parent$ui_release = other.layoutNode;
        LayoutNode parent$ui_release2 = this.layoutNode;
        if (parent$ui_release == parent$ui_release2) {
            LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = parent$ui_release2.getOuterLayoutNodeWrapper$ui_release();
            LayoutNodeWrapper layoutNodeWrapper = this;
            while (layoutNodeWrapper != outerLayoutNodeWrapper$ui_release && layoutNodeWrapper != other) {
                layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
                t.f(layoutNodeWrapper);
            }
            return layoutNodeWrapper == other ? other : this;
        }
        while (parent$ui_release.getDepth$ui_release() > parent$ui_release2.getDepth$ui_release()) {
            parent$ui_release = parent$ui_release.getParent$ui_release();
            t.f(parent$ui_release);
        }
        while (parent$ui_release2.getDepth$ui_release() > parent$ui_release.getDepth$ui_release()) {
            parent$ui_release2 = parent$ui_release2.getParent$ui_release();
            t.f(parent$ui_release2);
        }
        while (parent$ui_release != parent$ui_release2) {
            parent$ui_release = parent$ui_release.getParent$ui_release();
            parent$ui_release2 = parent$ui_release2.getParent$ui_release();
            if (parent$ui_release == null || parent$ui_release2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        return parent$ui_release2 == this.layoutNode ? this : parent$ui_release == other.layoutNode ? other : parent$ui_release.getInnerLayoutNodeWrapper$ui_release();
    }

    /* JADX INFO: renamed from: fromParentPosition-MK-Hz9U, reason: not valid java name */
    public long m3124fromParentPositionMKHz9U(long j10) {
        long jM3803minusNvtHpc = IntOffsetKt.m3803minusNvtHpc(j10, this.position);
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo3143mapOffset8S9VItk(jM3803minusNvtHpc, true) : jM3803minusNvtHpc;
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(@NotNull AlignmentLine alignmentLine) {
        int iCalculateAlignmentLine;
        t.i(alignmentLine, "alignmentLine");
        if (getHasMeasureResult() && (iCalculateAlignmentLine = calculateAlignmentLine(alignmentLine)) != Integer.MIN_VALUE) {
            return iCalculateAlignmentLine + (alignmentLine instanceof VerticalAlignmentLine ? IntOffset.m3791getXimpl(m3012getApparentToRealOffsetnOccac()) : IntOffset.m3792getYimpl(m3012getApparentToRealOffsetnOccac()));
        }
        return Integer.MIN_VALUE;
    }

    @NotNull
    /* JADX INFO: renamed from: getEntities-CHwCgZE, reason: not valid java name */
    public final LayoutNodeEntity<?, ?>[] m3125getEntitiesCHwCgZE() {
        return this.entities;
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    @Nullable
    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Nullable
    protected final l<GraphicsLayerScope, k0> getLayerBlock() {
        return this.layerBlock;
    }

    @NotNull
    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    @NotNull
    public final MeasureResult getMeasureResult() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    @NotNull
    public abstract MeasureScope getMeasureScope();

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m3126getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo297toSizeXkaWNTQ(this.layoutNode.getViewConfiguration().mo3104getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    @Nullable
    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            return this.wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    @Nullable
    public Object getParentData() {
        return getParentData((SimpleEntity) EntityList.m3077head0OSVbXo(this.entities, EntityList.Companion.m3083getParentDataEntityTypeEEbPh1w()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    @Nullable
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            return this.layoutNode.getOuterLayoutNodeWrapper$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public final long m3127getPositionnOccac() {
        return this.position;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    @NotNull
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        for (LayoutNodeWrapper wrapped$ui_release = this; wrapped$ui_release != null; wrapped$ui_release = wrapped$ui_release.getWrapped$ui_release()) {
            MeasureResult measureResult = wrapped$ui_release._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            boolean z10 = false;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                z10 = true;
            }
            if (z10) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
        }
        return linkedHashSet == null ? z0.e() : linkedHashSet;
    }

    @NotNull
    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo2989getSizeYbymL2g() {
        return m3013getMeasuredSizeYbymL2g();
    }

    @Nullable
    public LayoutNodeWrapper getWrapped$ui_release() {
        return null;
    }

    @Nullable
    public final LayoutNodeWrapper getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void m3128hitTestYqVAtuI(@NotNull HitTestSource<T, C, M> hitTestSource, long j10, @NotNull HitTestResult<C> hitTestResult, boolean z10, boolean z11) {
        t.i(hitTestSource, "hitTestSource");
        t.i(hitTestResult, "hitTestResult");
        LayoutNodeEntity layoutNodeEntityM3077head0OSVbXo = EntityList.m3077head0OSVbXo(this.entities, hitTestSource.mo3134entityTypeEEbPh1w());
        if (!m3132withinLayerBoundsk4lQ0M(j10)) {
            if (z10) {
                float fM3123distanceInMinimumTouchTargettz77jQw = m3123distanceInMinimumTouchTargettz77jQw(j10, m3126getMinimumTouchTargetSizeNHjbRc());
                if (((Float.isInfinite(fM3123distanceInMinimumTouchTargettz77jQw) || Float.isNaN(fM3123distanceInMinimumTouchTargettz77jQw)) ? false : true) && hitTestResult.isHitInMinimumTouchTargetBetter(fM3123distanceInMinimumTouchTargettz77jQw, false)) {
                    m3119hitNearJHbHoSQ(layoutNodeEntityM3077head0OSVbXo, hitTestSource, j10, hitTestResult, z10, false, fM3123distanceInMinimumTouchTargettz77jQw);
                    return;
                }
                return;
            }
            return;
        }
        if (layoutNodeEntityM3077head0OSVbXo == null) {
            mo3095hitTestChildYqVAtuI(hitTestSource, j10, hitTestResult, z10, z11);
            return;
        }
        if (m3129isPointerInBoundsk4lQ0M(j10)) {
            m3118hit1hIXUjU(layoutNodeEntityM3077head0OSVbXo, hitTestSource, j10, hitTestResult, z10, z11);
            return;
        }
        float fM3123distanceInMinimumTouchTargettz77jQw2 = !z10 ? Float.POSITIVE_INFINITY : m3123distanceInMinimumTouchTargettz77jQw(j10, m3126getMinimumTouchTargetSizeNHjbRc());
        if (((Float.isInfinite(fM3123distanceInMinimumTouchTargettz77jQw2) || Float.isNaN(fM3123distanceInMinimumTouchTargettz77jQw2)) ? false : true) && hitTestResult.isHitInMinimumTouchTargetBetter(fM3123distanceInMinimumTouchTargettz77jQw2, z11)) {
            m3119hitNearJHbHoSQ(layoutNodeEntityM3077head0OSVbXo, hitTestSource, j10, hitTestResult, z10, z11, fM3123distanceInMinimumTouchTargettz77jQw2);
        } else {
            m3121speculativeHitJHbHoSQ(layoutNodeEntityM3077head0OSVbXo, hitTestSource, j10, hitTestResult, z10, z11, fM3123distanceInMinimumTouchTargettz77jQw2);
        }
    }

    /* JADX INFO: renamed from: hitTestChild-YqVAtuI */
    public <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void mo3095hitTestChildYqVAtuI(@NotNull HitTestSource<T, C, M> hitTestSource, long j10, @NotNull HitTestResult<C> hitTestResult, boolean z10, boolean z11) {
        t.i(hitTestSource, "hitTestSource");
        t.i(hitTestResult, "hitTestResult");
        LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            wrapped$ui_release.m3128hitTestYqVAtuI(hitTestSource, wrapped$ui_release.m3124fromParentPositionMKHz9U(j10), hitTestResult, z10, z11);
        }
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper != null) {
            layoutNodeWrapper.invalidateLayer();
        }
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Canvas canvas) {
        invoke2(canvas);
        return k0.f35197a;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached() {
        if (!this._isAttached || this.layoutNode.isAttached()) {
            return this._isAttached;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m3129isPointerInBoundsk4lQ0M(long j10) {
        float fM1367getXimpl = Offset.m1367getXimpl(j10);
        float fM1368getYimpl = Offset.m1368getYimpl(j10);
        return fM1367getXimpl >= 0.0f && fM1368getYimpl >= 0.0f && fM1367getXimpl < ((float) getMeasuredWidth()) && fM1368getYimpl < ((float) getMeasuredHeight());
    }

    public final boolean isShallowPlacing() {
        return this.isShallowPlacing;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper != null) {
            return layoutNodeWrapper.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return this.layer != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    @NotNull
    public Rect localBoundingBoxOf(@NotNull LayoutCoordinates sourceCoordinates, boolean z10) {
        t.i(sourceCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        if (!sourceCoordinates.isAttached()) {
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
        LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) sourceCoordinates;
        LayoutNodeWrapper layoutNodeWrapperFindCommonAncestor$ui_release = findCommonAncestor$ui_release(layoutNodeWrapper);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m3833getWidthimpl(sourceCoordinates.mo2989getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m3832getHeightimpl(sourceCoordinates.mo2989getSizeYbymL2g()));
        while (layoutNodeWrapper != layoutNodeWrapperFindCommonAncestor$ui_release) {
            rectInParent$ui_release$default(layoutNodeWrapper, rectCache, z10, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
            t.f(layoutNodeWrapper);
        }
        ancestorToLocal(layoutNodeWrapperFindCommonAncestor$ui_release, rectCache, z10);
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo2990localPositionOfR5De75A(@NotNull LayoutCoordinates sourceCoordinates, long j10) {
        t.i(sourceCoordinates, "sourceCoordinates");
        LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) sourceCoordinates;
        LayoutNodeWrapper layoutNodeWrapperFindCommonAncestor$ui_release = findCommonAncestor$ui_release(layoutNodeWrapper);
        while (layoutNodeWrapper != layoutNodeWrapperFindCommonAncestor$ui_release) {
            j10 = layoutNodeWrapper.m3131toParentPositionMKHz9U(j10);
            layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
            t.f(layoutNodeWrapper);
        }
        return m3117ancestorToLocalR5De75A(layoutNodeWrapperFindCommonAncestor$ui_release, j10);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo2991localToRootMKHz9U(long j10) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        for (LayoutNodeWrapper layoutNodeWrapper = this; layoutNodeWrapper != null; layoutNodeWrapper = layoutNodeWrapper.wrappedBy) {
            j10 = layoutNodeWrapper.m3131toParentPositionMKHz9U(j10);
        }
        return j10;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo2992localToWindowMKHz9U(long j10) {
        return LayoutNodeKt.requireOwner(this.layoutNode).mo3148calculatePositionInWindowMKHz9U(mo2991localToRootMKHz9U(j10));
    }

    public void onInitialize() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onLayerBlockUpdated(@Nullable l<? super GraphicsLayerScope, k0> lVar) {
        Owner owner$ui_release;
        boolean z10 = (this.layerBlock == lVar && t.d(this.layerDensity, this.layoutNode.getDensity()) && this.layerLayoutDirection == this.layoutNode.getLayoutDirection()) ? false : true;
        this.layerBlock = lVar;
        this.layerDensity = this.layoutNode.getDensity();
        this.layerLayoutDirection = this.layoutNode.getLayoutDirection();
        if (!isAttached() || lVar == null) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                this.layoutNode.setInnerLayerWrapperIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = this.layoutNode.getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(this.layoutNode);
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        if (this.layer != null) {
            if (z10) {
                updateLayerParameters();
                return;
            }
            return;
        }
        OwnedLayer ownedLayerCreateLayer = LayoutNodeKt.requireOwner(this.layoutNode).createLayer(this, this.invalidateParentLayer);
        ownedLayerCreateLayer.mo3145resizeozmzZPI(m3013getMeasuredSizeYbymL2g());
        ownedLayerCreateLayer.mo3144movegyyYBs(this.position);
        this.layer = ownedLayerCreateLayer;
        updateLayerParameters();
        this.layoutNode.setInnerLayerWrapperIsDirty$ui_release(true);
        this.invalidateParentLayer.invoke();
    }

    protected void onMeasureResultChanged(int i10, int i11) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo3145resizeozmzZPI(IntSizeKt.IntSize(i10, i11));
        } else {
            LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
            if (layoutNodeWrapper != null) {
                layoutNodeWrapper.invalidateLayer();
            }
        }
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(this.layoutNode);
        }
        m3015setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i10, i11));
        for (LayoutNodeEntity<?, ?> next = this.entities[EntityList.Companion.m3081getDrawEntityTypeEEbPh1w()]; next != null; next = next.getNext()) {
            ((DrawEntity) next).onMeasureResultChanged();
        }
    }

    public final void onMeasured() {
        LayoutNodeEntity<?, ?>[] layoutNodeEntityArr = this.entities;
        EntityList.Companion companion = EntityList.Companion;
        if (EntityList.m3075has0OSVbXo(layoutNodeEntityArr, companion.m3085getRemeasureEntityTypeEEbPh1w())) {
            Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    for (LayoutNodeEntity<?, ?> next = this.entities[companion.m3085getRemeasureEntityTypeEEbPh1w()]; next != null; next = next.getNext()) {
                        ((OnRemeasuredModifier) ((SimpleEntity) next).getModifier()).mo241onRemeasuredozmzZPI(m3013getMeasuredSizeYbymL2g());
                    }
                    k0 k0Var = k0.f35197a;
                } finally {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } finally {
                snapshotCreateNonObservableSnapshot.dispose();
            }
        }
    }

    public void onModifierChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onPlaced() {
        for (LayoutNodeEntity<?, ?> next = this.entities[EntityList.Companion.m3082getOnPlacedEntityTypeEEbPh1w()]; next != null; next = next.getNext()) {
            ((OnPlacedModifier) ((SimpleEntity) next).getModifier()).onPlaced(this);
        }
    }

    public void performDraw(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            wrapped$ui_release.draw(canvas);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    protected final Placeable m3130performingMeasureK40F9xA(long j10, @NotNull h9.a<? extends Placeable> block) {
        t.i(block, "block");
        m3016setMeasurementConstraintsBRTryo0(j10);
        Placeable placeableInvoke = block.invoke();
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.mo3145resizeozmzZPI(m3013getMeasuredSizeYbymL2g());
        }
        return placeableInvoke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo2988placeAtf8xVGno(long j10, float f10, @Nullable l<? super GraphicsLayerScope, k0> lVar) {
        onLayerBlockUpdated(lVar);
        if (!IntOffset.m3790equalsimpl0(this.position, j10)) {
            this.position = j10;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo3144movegyyYBs(j10);
            } else {
                LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
                if (layoutNodeWrapper != null) {
                    layoutNodeWrapper.invalidateLayer();
                }
            }
            LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
            if (t.d(wrapped$ui_release != null ? wrapped$ui_release.layoutNode : null, this.layoutNode)) {
                LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    parent$ui_release.onAlignmentsChanged$ui_release();
                }
            } else {
                this.layoutNode.onAlignmentsChanged$ui_release();
            }
            Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(this.layoutNode);
            }
        }
        this.zIndex = f10;
    }

    @Nullable
    public Object propagateRelocationRequest(@NotNull Rect rect, @NotNull d<? super k0> dVar) {
        return propagateRelocationRequest$suspendImpl(this, rect, dVar);
    }

    public final void rectInParent$ui_release(@NotNull MutableRect bounds, boolean z10, boolean z11) {
        t.i(bounds, "bounds");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z11) {
                    long jM3126getMinimumTouchTargetSizeNHjbRc = m3126getMinimumTouchTargetSizeNHjbRc();
                    float fM1436getWidthimpl = Size.m1436getWidthimpl(jM3126getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float fM1433getHeightimpl = Size.m1433getHeightimpl(jM3126getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    bounds.intersect(-fM1436getWidthimpl, -fM1433getHeightimpl, IntSize.m3833getWidthimpl(mo2989getSizeYbymL2g()) + fM1436getWidthimpl, IntSize.m3832getHeightimpl(mo2989getSizeYbymL2g()) + fM1433getHeightimpl);
                } else if (z10) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m3833getWidthimpl(mo2989getSizeYbymL2g()), IntSize.m3832getHeightimpl(mo2989getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float fM3791getXimpl = IntOffset.m3791getXimpl(this.position);
        bounds.setLeft(bounds.getLeft() + fM3791getXimpl);
        bounds.setRight(bounds.getRight() + fM3791getXimpl);
        float fM3792getYimpl = IntOffset.m3792getYimpl(this.position);
        bounds.setTop(bounds.getTop() + fM3792getYimpl);
        bounds.setBottom(bounds.getBottom() + fM3792getYimpl);
    }

    public final void setMeasureResult$ui_release(@NotNull MeasureResult value) {
        LayoutNode parent$ui_release;
        t.i(value, "value");
        MeasureResult measureResult = this._measureResult;
        if (value != measureResult) {
            this._measureResult = value;
            if (measureResult == null || value.getWidth() != measureResult.getWidth() || value.getHeight() != measureResult.getHeight()) {
                onMeasureResultChanged(value.getWidth(), value.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!value.getAlignmentLines().isEmpty())) && !t.d(value.getAlignmentLines(), this.oldAlignmentLines)) {
                LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
                if (t.d(wrapped$ui_release != null ? wrapped$ui_release.layoutNode : null, this.layoutNode)) {
                    LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
                    if (parent$ui_release2 != null) {
                        parent$ui_release2.onAlignmentsChanged$ui_release();
                    }
                    if (this.layoutNode.getAlignmentLines$ui_release().getUsedDuringParentMeasurement$ui_release()) {
                        LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
                        if (parent$ui_release3 != null) {
                            LayoutNode.requestRemeasure$ui_release$default(parent$ui_release3, false, 1, null);
                        }
                    } else if (this.layoutNode.getAlignmentLines$ui_release().getUsedDuringParentLayout$ui_release() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
                        LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
                    }
                } else {
                    this.layoutNode.onAlignmentsChanged$ui_release();
                }
                this.layoutNode.getAlignmentLines$ui_release().setDirty$ui_release(true);
                Map linkedHashMap = this.oldAlignmentLines;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                    this.oldAlignmentLines = linkedHashMap;
                }
                linkedHashMap.clear();
                linkedHashMap.putAll(value.getAlignmentLines());
            }
        }
    }

    public final void setShallowPlacing(boolean z10) {
        this.isShallowPlacing = z10;
    }

    public final void setWrappedBy$ui_release(@Nullable LayoutNodeWrapper layoutNodeWrapper) {
        this.wrappedBy = layoutNodeWrapper;
    }

    protected final void setZIndex(float f10) {
        this.zIndex = f10;
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        PointerInputEntity pointerInputEntity = (PointerInputEntity) EntityList.m3077head0OSVbXo(this.entities, EntityList.Companion.m3084getPointerInputEntityTypeEEbPh1w());
        if (pointerInputEntity != null && pointerInputEntity.shouldSharePointerInputWithSiblings()) {
            return true;
        }
        LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
        return wrapped$ui_release != null && wrapped$ui_release.shouldSharePointerInputWithSiblings();
    }

    /* JADX INFO: renamed from: toParentPosition-MK-Hz9U, reason: not valid java name */
    public long m3131toParentPositionMKHz9U(long j10) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j10 = ownedLayer.mo3143mapOffset8S9VItk(j10, false);
        }
        return IntOffsetKt.m3805plusNvtHpc(j10, this.position);
    }

    @NotNull
    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinatesFindRoot = LayoutCoordinatesKt.findRoot(this);
        MutableRect rectCache = getRectCache();
        long jM3122calculateMinimumTouchTargetPaddingE7KxVPU = m3122calculateMinimumTouchTargetPaddingE7KxVPU(m3126getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m1436getWidthimpl(jM3122calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m1433getHeightimpl(jM3122calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m1436getWidthimpl(jM3122calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m1433getHeightimpl(jM3122calculateMinimumTouchTargetPaddingE7KxVPU));
        LayoutNodeWrapper layoutNodeWrapper = this;
        while (layoutNodeWrapper != layoutCoordinatesFindRoot) {
            layoutNodeWrapper.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
            t.f(layoutNodeWrapper);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo2993windowToLocalMKHz9U(long j10) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        LayoutCoordinates layoutCoordinatesFindRoot = LayoutCoordinatesKt.findRoot(this);
        return mo2990localPositionOfR5De75A(layoutCoordinatesFindRoot, Offset.m1371minusMKHz9U(LayoutNodeKt.requireOwner(this.layoutNode).mo3147calculateLocalPositionMKHz9U(j10), LayoutCoordinatesKt.positionInRoot(layoutCoordinatesFindRoot)));
    }

    protected final void withPositionTranslation(@NotNull Canvas canvas, @NotNull l<? super Canvas, k0> block) {
        t.i(canvas, "canvas");
        t.i(block, "block");
        float fM3791getXimpl = IntOffset.m3791getXimpl(m3127getPositionnOccac());
        float fM3792getYimpl = IntOffset.m3792getYimpl(m3127getPositionnOccac());
        canvas.translate(fM3791getXimpl, fM3792getYimpl);
        block.invoke(canvas);
        canvas.translate(-fM3791getXimpl, -fM3792getYimpl);
    }

    /* JADX INFO: renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m3132withinLayerBoundsk4lQ0M(long j10) {
        if (!OffsetKt.m1384isFinitek4lQ0M(j10)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo3142isInLayerk4lQ0M(j10);
    }

    private final Object getParentData(SimpleEntity<ParentDataModifier> simpleEntity) {
        if (simpleEntity != null) {
            return simpleEntity.getModifier().modifyParentData(getMeasureScope(), getParentData((SimpleEntity) simpleEntity.getNext()));
        }
        LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            return wrapped$ui_release.getParentData();
        }
        return null;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        if (!this.layoutNode.isPlaced()) {
            this.lastLayerDrawingWasSkipped = true;
        } else {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new AnonymousClass1(canvas));
            this.lastLayerDrawingWasSkipped = false;
        }
    }
}
