package androidx.compose.ui.node;

import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DrawEntity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DrawEntity extends LayoutNodeEntity<DrawEntity, DrawModifier> implements OwnerScope {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final l<DrawEntity, k0> onCommitAffectingDrawEntity = DrawEntity$Companion$onCommitAffectingDrawEntity$1.INSTANCE;

    @NotNull
    private final BuildDrawCacheParams buildCacheParams;

    @Nullable
    private DrawCacheModifier cacheDrawModifier;
    private boolean invalidateCache;

    @NotNull
    private final h9.a<k0> updateCache;

    /* JADX INFO: compiled from: DrawEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawEntity(@NotNull final LayoutNodeWrapper layoutNodeWrapper, @NotNull DrawModifier modifier) {
        super(layoutNodeWrapper, modifier);
        t.i(layoutNodeWrapper, "layoutNodeWrapper");
        t.i(modifier, "modifier");
        this.cacheDrawModifier = updateCacheDrawModifier();
        this.buildCacheParams = new BuildDrawCacheParams() { // from class: androidx.compose.ui.node.DrawEntity$buildCacheParams$1

            @NotNull
            private final Density density;

            {
                this.density = this.this$0.getLayoutNode().getDensity();
            }

            @Override // androidx.compose.ui.draw.BuildDrawCacheParams
            @NotNull
            public Density getDensity() {
                return this.density;
            }

            @Override // androidx.compose.ui.draw.BuildDrawCacheParams
            @NotNull
            public LayoutDirection getLayoutDirection() {
                return this.this$0.getLayoutNode().getLayoutDirection();
            }

            @Override // androidx.compose.ui.draw.BuildDrawCacheParams
            /* JADX INFO: renamed from: getSize-NH-jbRc */
            public long mo1289getSizeNHjbRc() {
                return IntSizeKt.m3843toSizeozmzZPI(layoutNodeWrapper.mo2989getSizeYbymL2g());
            }
        };
        this.invalidateCache = true;
        this.updateCache = new DrawEntity$updateCache$1(this);
    }

    private final DrawCacheModifier updateCacheDrawModifier() {
        DrawModifier modifier = getModifier();
        if (modifier instanceof DrawCacheModifier) {
            return (DrawCacheModifier) modifier;
        }
        return null;
    }

    public final void draw(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        long jM3843toSizeozmzZPI = IntSizeKt.m3843toSizeozmzZPI(m3111getSizeYbymL2g());
        if (this.cacheDrawModifier != null && this.invalidateCache) {
            LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingDrawEntity, this.updateCache);
        }
        LayoutNodeDrawScope mDrawScope$ui_release = getLayoutNode().getMDrawScope$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = getLayoutNodeWrapper();
        DrawEntity drawEntity = mDrawScope$ui_release.drawEntity;
        mDrawScope$ui_release.drawEntity = this;
        CanvasDrawScope canvasDrawScope = mDrawScope$ui_release.canvasDrawScope;
        MeasureScope measureScope = layoutNodeWrapper.getMeasureScope();
        LayoutDirection layoutDirection = layoutNodeWrapper.getMeasureScope().getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM1998component4NHjbRc = drawParams.m1998component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(measureScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m2001setSizeuvyYCjk(jM3843toSizeozmzZPI);
        canvas.save();
        getModifier().draw(mDrawScope$ui_release);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m2001setSizeuvyYCjk(jM1998component4NHjbRc);
        mDrawScope$ui_release.drawEntity = drawEntity;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return getLayoutNodeWrapper().isAttached();
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onAttach() {
        this.cacheDrawModifier = updateCacheDrawModifier();
        this.invalidateCache = true;
        super.onAttach();
    }

    public final void onMeasureResultChanged() {
        this.invalidateCache = true;
    }
}
