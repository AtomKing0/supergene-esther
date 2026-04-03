package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: FocusTraversal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusTraversalKt {

    @NotNull
    private static final String invalidFocusDirection = "Invalid FocusDirection";

    /* JADX INFO: compiled from: FocusTraversal.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Rtl.ordinal()] = 1;
            iArr[LayoutDirection.Ltr.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            iArr2[FocusStateImpl.Active.ordinal()] = 1;
            iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr2[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr2[FocusStateImpl.Inactive.ordinal()] = 5;
            iArr2[FocusStateImpl.Deactivated.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @NotNull
    public static final MutableVector<FocusModifier> activatedChildren(@NotNull FocusModifier focusModifier) {
        boolean z10;
        t.i(focusModifier, "<this>");
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        int i10 = 0;
        if (size <= 0) {
            z10 = false;
            break;
        }
        FocusModifier[] content = children.getContent();
        int i11 = 0;
        while (!content[i11].getFocusState().isDeactivated()) {
            i11++;
            if (i11 >= size) {
                z10 = false;
                break;
            }
        }
        z10 = true;
        if (!z10) {
            return focusModifier.getChildren();
        }
        MutableVector<FocusModifier> mutableVector = new MutableVector<>(new FocusModifier[16], 0);
        MutableVector<FocusModifier> children2 = focusModifier.getChildren();
        int size2 = children2.getSize();
        if (size2 > 0) {
            FocusModifier[] content2 = children2.getContent();
            do {
                FocusModifier focusModifier2 = content2[i10];
                if (focusModifier2.getFocusState().isDeactivated()) {
                    mutableVector.addAll(mutableVector.getSize(), activatedChildren(focusModifier2));
                } else {
                    mutableVector.add(focusModifier2);
                }
                i10++;
            } while (i10 < size2);
        }
        return mutableVector;
    }

    @Nullable
    public static final FocusModifier findActiveFocusNode(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return focusModifier;
            case 3:
            case 4:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    return findActiveFocusNode(focusedChild);
                }
                break;
            case 5:
            case 6:
                break;
            default:
                throw new q();
        }
        return null;
    }

    @Nullable
    public static final FocusModifier findActiveParent(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "<this>");
        FocusModifier parent = focusModifier.getParent();
        if (parent == null) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                return findActiveParent(parent);
            case 3:
                return focusModifier;
            default:
                throw new q();
        }
    }

    @Nullable
    public static final KeyInputModifier findLastKeyInputModifier(@NotNull FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        t.i(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        KeyInputModifier keyInputModifierLastOf = null;
        if (layoutNodeWrapper == null || (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode$ui_release()) == null) {
            return null;
        }
        MutableVector<KeyInputModifier> keyInputChildren = focusModifier.getKeyInputChildren();
        int size = keyInputChildren.getSize();
        if (size > 0) {
            KeyInputModifier[] content = keyInputChildren.getContent();
            int i10 = 0;
            do {
                KeyInputModifier keyInputModifier = content[i10];
                if (t.d(keyInputModifier.getLayoutNode(), layoutNode$ui_release)) {
                    keyInputModifierLastOf = lastOf(keyInputModifier, keyInputModifierLastOf);
                }
                i10++;
            } while (i10 < size);
        }
        return keyInputModifierLastOf != null ? keyInputModifierLastOf : focusModifier.getKeyInputModifier();
    }

    @NotNull
    public static final Rect focusRect(@NotNull FocusModifier focusModifier) {
        Rect rectLocalBoundingBoxOf;
        t.i(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        return (layoutNodeWrapper == null || (rectLocalBoundingBoxOf = LayoutCoordinatesKt.findRoot(layoutNodeWrapper).localBoundingBoxOf(layoutNodeWrapper, false)) == null) ? Rect.Companion.getZero() : rectLocalBoundingBoxOf;
    }

    /* JADX INFO: renamed from: focusSearch-sMXa3k8, reason: not valid java name */
    public static final boolean m1320focusSearchsMXa3k8(@NotNull FocusModifier focusSearch, int i10, @NotNull LayoutDirection layoutDirection, @NotNull l<? super FocusModifier, Boolean> onFound) {
        int iM1311getLeftdhqQ8s;
        t.i(focusSearch, "$this$focusSearch");
        t.i(layoutDirection, "layoutDirection");
        t.i(onFound, "onFound");
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1312getNextdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1314getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m1323oneDimensionalFocusSearchOMvw8(focusSearch, i10, onFound);
        }
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m1332twoDimensionalFocusSearchOMvw8(focusSearch, i10, onFound);
        }
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1310getIndhqQ8s())) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i11 == 1) {
                iM1311getLeftdhqQ8s = companion.m1311getLeftdhqQ8s();
            } else {
                if (i11 != 2) {
                    throw new q();
                }
                iM1311getLeftdhqQ8s = companion.m1315getRightdhqQ8s();
            }
            FocusModifier focusModifierFindActiveFocusNode = findActiveFocusNode(focusSearch);
            if (focusModifierFindActiveFocusNode != null) {
                return TwoDimensionalFocusSearchKt.m1332twoDimensionalFocusSearchOMvw8(focusModifierFindActiveFocusNode, iM1311getLeftdhqQ8s, onFound);
            }
        } else {
            if (!FocusDirection.m1303equalsimpl0(i10, companion.m1313getOutdhqQ8s())) {
                throw new IllegalStateException(invalidFocusDirection.toString());
            }
            FocusModifier focusModifierFindActiveFocusNode2 = findActiveFocusNode(focusSearch);
            FocusModifier focusModifierFindActiveParent = focusModifierFindActiveFocusNode2 != null ? findActiveParent(focusModifierFindActiveFocusNode2) : null;
            if (!t.d(focusModifierFindActiveParent, focusSearch) && focusModifierFindActiveParent != null) {
                return onFound.invoke(focusModifierFindActiveParent).booleanValue();
            }
        }
        return false;
    }

    public static final boolean isEligibleForFocusSearch(@NotNull FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        LayoutNode layoutNode$ui_release2;
        t.i(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if ((layoutNodeWrapper == null || (layoutNode$ui_release2 = layoutNodeWrapper.getLayoutNode$ui_release()) == null || !layoutNode$ui_release2.isPlaced()) ? false : true) {
            LayoutNodeWrapper layoutNodeWrapper2 = focusModifier.getLayoutNodeWrapper();
            if ((layoutNodeWrapper2 == null || (layoutNode$ui_release = layoutNodeWrapper2.getLayoutNode$ui_release()) == null || !layoutNode$ui_release.isAttached()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    private static final KeyInputModifier lastOf(KeyInputModifier keyInputModifier, KeyInputModifier keyInputModifier2) {
        if (keyInputModifier2 == null) {
            return keyInputModifier;
        }
        LayoutNode layoutNode = keyInputModifier.getLayoutNode();
        KeyInputModifier parent = keyInputModifier2;
        while (!t.d(parent, keyInputModifier)) {
            parent = parent.getParent();
            if (parent == null || !t.d(parent.getLayoutNode(), layoutNode)) {
                return keyInputModifier;
            }
        }
        return keyInputModifier2;
    }
}
