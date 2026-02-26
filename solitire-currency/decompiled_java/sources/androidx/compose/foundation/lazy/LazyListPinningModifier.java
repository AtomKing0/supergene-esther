package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.lazy.layout.PinnableParentKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import h9.l;
import h9.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyListPinningModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyListPinningModifier implements ModifierLocalProvider<PinnableParent>, ModifierLocalConsumer, PinnableParent {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1 EmptyPinnedItemsHandle = new PinnableParent.PinnedItemsHandle() { // from class: androidx.compose.foundation.lazy.LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1
        @Override // androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle
        public void unpin() {
        }
    };

    @NotNull
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;

    @Nullable
    private PinnableParent pinnableGrandParent;

    @NotNull
    private final LazyListState state;

    /* JADX INFO: compiled from: LazyListPinningModifier.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public LazyListPinningModifier(@NotNull LazyListState state, @NotNull LazyListBeyondBoundsInfo beyondBoundsInfo) {
        t.i(state, "state");
        t.i(beyondBoundsInfo, "beyondBoundsInfo");
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
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
    public ProvidableModifierLocal<PinnableParent> getKey() {
        return PinnableParentKt.getModifierLocalPinnableParent();
    }

    @Nullable
    public final PinnableParent getPinnableGrandParent() {
        return this.pinnableGrandParent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    /* JADX INFO: renamed from: getValue */
    public PinnableParent getValue2() {
        return this;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        t.i(scope, "scope");
        this.pinnableGrandParent = (PinnableParent) scope.getCurrent(PinnableParentKt.getModifierLocalPinnableParent());
    }

    @Override // androidx.compose.foundation.lazy.layout.PinnableParent
    @NotNull
    public PinnableParent.PinnedItemsHandle pinItems() {
        PinnableParent.PinnedItemsHandle pinnedItemsHandlePinItems;
        final LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo = this.beyondBoundsInfo;
        if (lazyListBeyondBoundsInfo.hasIntervals()) {
            return new PinnableParent.PinnedItemsHandle(lazyListBeyondBoundsInfo) { // from class: androidx.compose.foundation.lazy.LazyListPinningModifier$pinItems$1$1
                final /* synthetic */ LazyListBeyondBoundsInfo $this_with;

                @NotNull
                private final LazyListBeyondBoundsInfo.Interval interval;

                @Nullable
                private final PinnableParent.PinnedItemsHandle parentPinnedItemsHandle;

                {
                    this.$this_with = lazyListBeyondBoundsInfo;
                    PinnableParent pinnableGrandParent = this.this$0.getPinnableGrandParent();
                    this.parentPinnedItemsHandle = pinnableGrandParent != null ? pinnableGrandParent.pinItems() : null;
                    this.interval = lazyListBeyondBoundsInfo.addInterval(lazyListBeyondBoundsInfo.getStart(), lazyListBeyondBoundsInfo.getEnd());
                }

                @NotNull
                public final LazyListBeyondBoundsInfo.Interval getInterval() {
                    return this.interval;
                }

                @Nullable
                public final PinnableParent.PinnedItemsHandle getParentPinnedItemsHandle() {
                    return this.parentPinnedItemsHandle;
                }

                @Override // androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle
                public void unpin() {
                    this.$this_with.removeInterval(this.interval);
                    PinnableParent.PinnedItemsHandle pinnedItemsHandle = this.parentPinnedItemsHandle;
                    if (pinnedItemsHandle != null) {
                        pinnedItemsHandle.unpin();
                    }
                    Remeasurement remeasurement$foundation_release = this.this$0.state.getRemeasurement$foundation_release();
                    if (remeasurement$foundation_release != null) {
                        remeasurement$foundation_release.forceRemeasure();
                    }
                }
            };
        }
        PinnableParent pinnableParent = this.pinnableGrandParent;
        return (pinnableParent == null || (pinnedItemsHandlePinItems = pinnableParent.pinItems()) == null) ? EmptyPinnedItemsHandle : pinnedItemsHandlePinItems;
    }

    public final void setPinnableGrandParent(@Nullable PinnableParent pinnableParent) {
        this.pinnableGrandParent = pinnableParent;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
