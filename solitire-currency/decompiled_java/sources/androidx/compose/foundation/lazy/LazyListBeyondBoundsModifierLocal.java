package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import h9.p;
import kotlin.collections.d0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.q;

/* JADX INFO: compiled from: LazyBeyondBoundsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyListBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {

    @NotNull
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;

    @NotNull
    private final LayoutDirection layoutDirection;
    private final boolean reverseLayout;

    @NotNull
    private final LazyListState state;

    /* JADX INFO: compiled from: LazyBeyondBoundsModifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyListBeyondBoundsModifierLocal(@NotNull LazyListState state, @NotNull LazyListBeyondBoundsInfo beyondBoundsInfo, boolean z10, @NotNull LayoutDirection layoutDirection) {
        t.i(state, "state");
        t.i(beyondBoundsInfo, "beyondBoundsInfo");
        t.i(layoutDirection, "layoutDirection");
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
        this.reverseLayout = z10;
        this.layoutDirection = layoutDirection;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /* JADX INFO: renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval m505addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval r6, int r7) {
        /*
            r5 = this;
            int r0 = r6.getStart()
            int r6 = r6.getEnd()
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r2 = r1.m2973getBeforehoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(r7, r2)
            if (r2 == 0) goto L18
        L14:
            int r0 = r0 + (-1)
            goto L8c
        L18:
            int r2 = r1.m2972getAfterhoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(r7, r2)
            if (r2 == 0) goto L26
        L22:
            int r6 = r6 + 1
            goto L8c
        L26:
            int r2 = r1.m2971getAbovehoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(r7, r2)
            if (r2 == 0) goto L35
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L14
            goto L22
        L35:
            int r2 = r1.m2974getBelowhoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(r7, r2)
            if (r2 == 0) goto L44
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L22
            goto L14
        L44:
            int r2 = r1.m2975getLefthoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(r7, r2)
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L69
            androidx.compose.ui.unit.LayoutDirection r7 = r5.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r1[r7]
            if (r7 == r4) goto L64
            if (r7 == r3) goto L5f
            goto L8c
        L5f:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L22
            goto L14
        L64:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L14
            goto L22
        L69:
            int r1 = r1.m2976getRighthoxUOeE()
            boolean r7 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(r7, r1)
            if (r7 == 0) goto L93
            androidx.compose.ui.unit.LayoutDirection r7 = r5.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r1[r7]
            if (r7 == r4) goto L87
            if (r7 == r3) goto L82
            goto L8c
        L82:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L14
            goto L22
        L87:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L22
            goto L14
        L8c:
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r7 = r5.beyondBoundsInfo
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval r6 = r7.addInterval(r0, r6)
            return r6
        L93:
            androidx.compose.foundation.lazy.LazyBeyondBoundsModifierKt.access$unsupportedDirection()
            v8.h r6 = new v8.h
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.m505addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval, int):androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m506hasMoreContentFR3nfPY(LazyListBeyondBoundsInfo.Interval interval, int i10) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.Companion;
        if (BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(i10, companion.m2973getBeforehoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        if (BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(i10, companion.m2972getAfterhoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(i10, companion.m2971getAbovehoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        if (BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(i10, companion.m2974getBelowhoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(i10, companion.m2975getLefthoxUOeE())) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i11 == 1) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
            }
            if (i11 == 2) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
            }
            throw new q();
        }
        if (!BeyondBoundsLayout.LayoutDirection.m2967equalsimpl0(i10, companion.m2976getRighthoxUOeE())) {
            LazyBeyondBoundsModifierKt.unsupportedDirection();
            throw new h();
        }
        int i12 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
        if (i12 == 1) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (i12 == 2) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        throw new q();
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsAfter(LazyListBeyondBoundsInfo.Interval interval, LazyListBeyondBoundsModifierLocal lazyListBeyondBoundsModifierLocal) {
        return interval.getEnd() < lazyListBeyondBoundsModifierLocal.state.getLayoutInfo().getTotalItemsCount() - 1;
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsBefore(LazyListBeyondBoundsInfo.Interval interval) {
        return interval.getStart() > 0;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    /* JADX INFO: renamed from: getValue */
    public BeyondBoundsLayout getValue2() {
        return this;
    }

    @Override // androidx.compose.ui.layout.BeyondBoundsLayout
    @Nullable
    /* JADX INFO: renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T mo507layouto7g1Pn8(final int i10, @NotNull l<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        t.i(block, "block");
        final n0 n0Var = new n0();
        n0Var.f29834a = (T) this.beyondBoundsInfo.addInterval(this.state.getFirstVisibleItemIndex(), ((LazyListItemInfo) d0.t0(this.state.getLayoutInfo().getVisibleItemsInfo())).getIndex());
        T tInvoke = null;
        while (tInvoke == null && m506hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) n0Var.f29834a, i10)) {
            T t10 = (T) m505addNextIntervalFR3nfPY((LazyListBeyondBoundsInfo.Interval) n0Var.f29834a, i10);
            this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) n0Var.f29834a);
            n0Var.f29834a = t10;
            Remeasurement remeasurement$foundation_release = this.state.getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            tInvoke = block.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    return this.this$0.m506hasMoreContentFR3nfPY(n0Var.f29834a, i10);
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) n0Var.f29834a);
        Remeasurement remeasurement$foundation_release2 = this.state.getRemeasurement$foundation_release();
        if (remeasurement$foundation_release2 != null) {
            remeasurement$foundation_release2.forceRemeasure();
        }
        return tInvoke;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
