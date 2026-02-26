package androidx.compose.ui.focus;

import androidx.compose.ui.layout.BeyondBoundsLayout;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneDimensionalFocusSearch.kt */
/* JADX INFO: loaded from: classes.dex */
final class OneDimensionalFocusSearchKt$generateAndSearchChildren$1 extends v implements l<BeyondBoundsLayout.BeyondBoundsScope, Boolean> {
    final /* synthetic */ int $direction;
    final /* synthetic */ FocusModifier $focusedItem;
    final /* synthetic */ l<FocusModifier, Boolean> $onFound;
    final /* synthetic */ FocusModifier $this_generateAndSearchChildren;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    OneDimensionalFocusSearchKt$generateAndSearchChildren$1(FocusModifier focusModifier, FocusModifier focusModifier2, int i10, l<? super FocusModifier, Boolean> lVar) {
        super(1);
        this.$this_generateAndSearchChildren = focusModifier;
        this.$focusedItem = focusModifier2;
        this.$direction = i10;
        this.$onFound = lVar;
    }

    @Override // h9.l
    @Nullable
    public final Boolean invoke(@NotNull BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
        t.i(searchBeyondBounds, "$this$searchBeyondBounds");
        Boolean boolValueOf = Boolean.valueOf(OneDimensionalFocusSearchKt.m1324searchChildren4C6V_qg(this.$this_generateAndSearchChildren, this.$focusedItem, this.$direction, this.$onFound));
        if (boolValueOf.booleanValue() || !searchBeyondBounds.getHasMoreContent()) {
            return boolValueOf;
        }
        return null;
    }
}
