package androidx.compose.ui.focus;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BeyondBoundsLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    @Nullable
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m1299searchBeyondBoundsOMvw8(@NotNull FocusModifier searchBeyondBounds, int i10, @NotNull l<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int iM2973getBeforehoxUOeE;
        t.i(searchBeyondBounds, "$this$searchBeyondBounds");
        t.i(block, "block");
        BeyondBoundsLayout beyondBoundsLayoutParent = searchBeyondBounds.getBeyondBoundsLayoutParent();
        if (beyondBoundsLayoutParent == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s())) {
            iM2973getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m2971getAbovehoxUOeE();
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
            iM2973getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m2974getBelowhoxUOeE();
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s())) {
            iM2973getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m2975getLefthoxUOeE();
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
            iM2973getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m2976getRighthoxUOeE();
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1312getNextdhqQ8s())) {
            iM2973getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m2972getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m1303equalsimpl0(i10, companion.m1314getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            iM2973getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m2973getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo507layouto7g1Pn8(iM2973getBeforehoxUOeE, block);
    }
}
