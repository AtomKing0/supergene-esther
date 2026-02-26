package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {

    @Nullable
    private LayoutCoordinates coordinates;

    @Nullable
    private LayoutCoordinates focusedChild;

    @NotNull
    private final Modifier modifier;

    @Nullable
    private IntSize oldSize;

    @NotNull
    private final Orientation orientation;
    private final boolean reverseDirection;

    @NotNull
    private final o0 scope;

    @NotNull
    private final ScrollableState scrollableState;

    /* JADX INFO: compiled from: Scrollable.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentInViewModifier(@NotNull o0 scope, @NotNull Orientation orientation, @NotNull ScrollableState scrollableState, boolean z10) {
        t.i(scope, "scope");
        t.i(orientation, "orientation");
        t.i(scrollableState, "scrollableState");
        this.scope = scope;
        this.orientation = orientation;
        this.scrollableState = scrollableState;
        this.reverseDirection = z10;
        this.modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new ContentInViewModifier$modifier$1(this)), this);
    }

    /* JADX INFO: renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m239computeDestinationO0kMr_c(Rect rect, long j10) {
        long jM3843toSizeozmzZPI = IntSizeKt.m3843toSizeozmzZPI(j10);
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i10 == 1) {
            return rect.translate(0.0f, relocationDistance(rect.getTop(), rect.getBottom(), Size.m1433getHeightimpl(jM3843toSizeozmzZPI)));
        }
        if (i10 == 2) {
            return rect.translate(relocationDistance(rect.getLeft(), rect.getRight(), Size.m1436getWidthimpl(jM3843toSizeozmzZPI)), 0.0f);
        }
        throw new q();
    }

    /* JADX INFO: renamed from: onSizeChanged-O0kMr_c, reason: not valid java name */
    private final void m240onSizeChangedO0kMr_c(LayoutCoordinates layoutCoordinates, long j10) {
        LayoutCoordinates layoutCoordinates2;
        Rect rectLocalBoundingBoxOf;
        if (!(this.orientation != Orientation.Horizontal ? IntSize.m3832getHeightimpl(layoutCoordinates.mo2989getSizeYbymL2g()) < IntSize.m3832getHeightimpl(j10) : IntSize.m3833getWidthimpl(layoutCoordinates.mo2989getSizeYbymL2g()) < IntSize.m3833getWidthimpl(j10)) || (layoutCoordinates2 = this.focusedChild) == null || (rectLocalBoundingBoxOf = layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, false)) == null) {
            return;
        }
        Rect rectM1407Recttz77jQw = RectKt.m1407Recttz77jQw(Offset.Companion.m1383getZeroF1C5BW0(), IntSizeKt.m3843toSizeozmzZPI(j10));
        Rect rectM239computeDestinationO0kMr_c = m239computeDestinationO0kMr_c(rectLocalBoundingBoxOf, layoutCoordinates.mo2989getSizeYbymL2g());
        boolean zOverlaps = rectM1407Recttz77jQw.overlaps(rectLocalBoundingBoxOf);
        boolean z10 = !t.d(rectM239computeDestinationO0kMr_c, rectLocalBoundingBoxOf);
        if (zOverlaps && z10) {
            k.d(this.scope, null, null, new ContentInViewModifier$onSizeChanged$1(this, rectLocalBoundingBoxOf, rectM239computeDestinationO0kMr_c, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performBringIntoView(Rect rect, Rect rect2, z8.d<? super k0> dVar) {
        float top;
        float top2;
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i10 == 1) {
            top = rect.getTop();
            top2 = rect2.getTop();
        } else {
            if (i10 != 2) {
                throw new q();
            }
            top = rect.getLeft();
            top2 = rect2.getLeft();
        }
        float f10 = top - top2;
        if (this.reverseDirection) {
            f10 = -f10;
        }
        Object objAnimateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.scrollableState, f10, null, dVar, 2, null);
        return objAnimateScrollBy$default == a9.d.e() ? objAnimateScrollBy$default : k0.f35197a;
    }

    private final float relocationDistance(float f10, float f11, float f12) {
        if ((f10 >= 0.0f && f11 <= f12) || (f10 < 0.0f && f11 > f12)) {
            return 0.0f;
        }
        float f13 = f11 - f12;
        return Math.abs(f10) < Math.abs(f13) ? f10 : f13;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    @Nullable
    public Object bringChildIntoView(@NotNull Rect rect, @NotNull z8.d<? super k0> dVar) {
        Object objPerformBringIntoView = performBringIntoView(rect, calculateRectForParent(rect), dVar);
        return objPerformBringIntoView == a9.d.e() ? objPerformBringIntoView : k0.f35197a;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    @NotNull
    public Rect calculateRectForParent(@NotNull Rect localRect) {
        t.i(localRect, "localRect");
        IntSize intSize = this.oldSize;
        if (intSize != null) {
            return m239computeDestinationO0kMr_c(localRect, intSize.m3837unboximpl());
        }
        throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(@NotNull LayoutCoordinates coordinates) {
        t.i(coordinates, "coordinates");
        this.coordinates = coordinates;
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo241onRemeasuredozmzZPI(long j10) {
        LayoutCoordinates layoutCoordinates = this.coordinates;
        IntSize intSize = this.oldSize;
        if (intSize != null && !IntSize.m3831equalsimpl0(intSize.m3837unboximpl(), j10)) {
            boolean z10 = false;
            if (layoutCoordinates != null && layoutCoordinates.isAttached()) {
                z10 = true;
            }
            if (z10) {
                m240onSizeChangedO0kMr_c(layoutCoordinates, intSize.m3837unboximpl());
            }
        }
        this.oldSize = IntSize.m3825boximpl(j10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
