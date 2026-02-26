package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import h9.l;
import java.util.Comparator;
import kotlin.jvm.internal.t;
import n9.i;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: OneDimensionalFocusSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OneDimensionalFocusSearchKt {

    @NotNull
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";

    @NotNull
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* JADX INFO: compiled from: OneDimensionalFocusSearch.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 2;
            iArr[FocusStateImpl.Active.ordinal()] = 3;
            iArr[FocusStateImpl.Captured.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final boolean backwardFocusSearch(FocusModifier focusModifier, l<? super FocusModifier, Boolean> lVar) {
        FocusStateImpl focusState = focusModifier.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[focusState.ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
                switch (iArr[focusedChild.getFocusState().ordinal()]) {
                    case 1:
                        if (!backwardFocusSearch(focusedChild, lVar) && !lVar.invoke(focusedChild).booleanValue()) {
                            return false;
                        }
                        break;
                    case 2:
                        if (!backwardFocusSearch(focusedChild, lVar) && !m1322generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.Companion.m1314getPreviousdhqQ8s(), lVar)) {
                            return false;
                        }
                        break;
                    case 3:
                    case 4:
                        return m1322generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.Companion.m1314getPreviousdhqQ8s(), lVar);
                    case 5:
                    case 6:
                        throw new IllegalStateException(NoActiveChild.toString());
                    default:
                        throw new q();
                }
                break;
            case 3:
            case 4:
            case 5:
                return pickChildForBackwardSearch(focusModifier, lVar);
            case 6:
                if (!pickChildForBackwardSearch(focusModifier, lVar) && !lVar.invoke(focusModifier).booleanValue()) {
                    return false;
                }
                break;
            default:
                throw new q();
        }
        return true;
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t10, l<? super T, k0> lVar) {
        boolean z10 = false;
        i iVar = new i(0, mutableVector.getSize() - 1);
        int iB = iVar.b();
        int iE = iVar.e();
        if (iB > iE) {
            return;
        }
        while (true) {
            if (z10) {
                lVar.invoke(mutableVector.getContent()[iB]);
            }
            if (t.d(mutableVector.getContent()[iB], t10)) {
                z10 = true;
            }
            if (iB == iE) {
                return;
            } else {
                iB++;
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t10, l<? super T, k0> lVar) {
        boolean z10 = false;
        i iVar = new i(0, mutableVector.getSize() - 1);
        int iB = iVar.b();
        int iE = iVar.e();
        if (iB > iE) {
            return;
        }
        while (true) {
            if (z10) {
                lVar.invoke(mutableVector.getContent()[iE]);
            }
            if (t.d(mutableVector.getContent()[iE], t10)) {
                z10 = true;
            }
            if (iE == iB) {
                return;
            } else {
                iE--;
            }
        }
    }

    private static final boolean forwardFocusSearch(FocusModifier focusModifier, l<? super FocusModifier, Boolean> lVar) {
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    return forwardFocusSearch(focusedChild, lVar) || m1322generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.Companion.m1312getNextdhqQ8s(), lVar);
                }
                throw new IllegalStateException(NoActiveChild.toString());
            case 3:
            case 4:
            case 5:
                return pickChildForForwardSearch(focusModifier, lVar);
            case 6:
                return lVar.invoke(focusModifier).booleanValue();
            default:
                throw new q();
        }
    }

    /* JADX INFO: renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m1322generateAndSearchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i10, l<? super FocusModifier, Boolean> lVar) {
        if (m1324searchChildren4C6V_qg(focusModifier, focusModifier2, i10, lVar)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1299searchBeyondBoundsOMvw8(focusModifier, i10, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1(focusModifier, focusModifier2, i10, lVar));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final boolean isRoot(FocusModifier focusModifier) {
        return focusModifier.getParent() == null;
    }

    /* JADX INFO: renamed from: oneDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m1323oneDimensionalFocusSearchOMvw8(@NotNull FocusModifier oneDimensionalFocusSearch, int i10, @NotNull l<? super FocusModifier, Boolean> onFound) {
        t.i(oneDimensionalFocusSearch, "$this$oneDimensionalFocusSearch");
        t.i(onFound, "onFound");
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1312getNextdhqQ8s())) {
            return forwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1314getPreviousdhqQ8s())) {
            return backwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean pickChildForBackwardSearch(FocusModifier focusModifier, l<? super FocusModifier, Boolean> lVar) {
        sort(focusModifier.getChildren());
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size <= 0) {
            return false;
        }
        int i10 = size - 1;
        FocusModifier[] content = children.getContent();
        do {
            FocusModifier focusModifier2 = content[i10];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2) && backwardFocusSearch(focusModifier2, lVar)) {
                return true;
            }
            i10--;
        } while (i10 >= 0);
        return false;
    }

    private static final boolean pickChildForForwardSearch(FocusModifier focusModifier, l<? super FocusModifier, Boolean> lVar) {
        sort(focusModifier.getChildren());
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size <= 0) {
            return false;
        }
        FocusModifier[] content = children.getContent();
        int i10 = 0;
        do {
            FocusModifier focusModifier2 = content[i10];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2) && forwardFocusSearch(focusModifier2, lVar)) {
                return true;
            }
            i10++;
        } while (i10 < size);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m1324searchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i10, l<? super FocusModifier, Boolean> lVar) {
        if (!(focusModifier.getFocusState() == FocusStateImpl.ActiveParent || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent)) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        }
        sort(focusModifier.getChildren());
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1312getNextdhqQ8s())) {
            MutableVector<FocusModifier> children = focusModifier.getChildren();
            i iVar = new i(0, children.getSize() - 1);
            int iB = iVar.b();
            int iE = iVar.e();
            if (iB <= iE) {
                boolean z10 = false;
                while (true) {
                    if (z10) {
                        FocusModifier focusModifier3 = children.getContent()[iB];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier3) && forwardFocusSearch(focusModifier3, lVar)) {
                            return true;
                        }
                    }
                    if (t.d(children.getContent()[iB], focusModifier2)) {
                        z10 = true;
                    }
                    if (iB == iE) {
                        break;
                    }
                    iB++;
                }
            }
        } else {
            if (!FocusDirection.m1303equalsimpl0(i10, companion.m1314getPreviousdhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            MutableVector<FocusModifier> children2 = focusModifier.getChildren();
            i iVar2 = new i(0, children2.getSize() - 1);
            int iB2 = iVar2.b();
            int iE2 = iVar2.e();
            if (iB2 <= iE2) {
                boolean z11 = false;
                while (true) {
                    if (z11) {
                        FocusModifier focusModifier4 = children2.getContent()[iE2];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier4) && backwardFocusSearch(focusModifier4, lVar)) {
                            return true;
                        }
                    }
                    if (t.d(children2.getContent()[iE2], focusModifier2)) {
                        z11 = true;
                    }
                    if (iE2 == iB2) {
                        break;
                    }
                    iE2--;
                }
            }
        }
        if (FocusDirection.m1303equalsimpl0(i10, FocusDirection.Companion.m1312getNextdhqQ8s()) || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent || isRoot(focusModifier)) {
            return false;
        }
        return lVar.invoke(focusModifier).booleanValue();
    }

    private static final void sort(MutableVector<FocusModifier> mutableVector) {
        mutableVector.sortWith(new Comparator() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$sort$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                LayoutNode layoutNode$ui_release;
                LayoutNode layoutNode$ui_release2;
                LayoutNodeWrapper layoutNodeWrapper = ((FocusModifier) t10).getLayoutNodeWrapper();
                Integer numValueOf = null;
                Integer numValueOf2 = (layoutNodeWrapper == null || (layoutNode$ui_release2 = layoutNodeWrapper.getLayoutNode$ui_release()) == null) ? null : Integer.valueOf(layoutNode$ui_release2.getPlaceOrder$ui_release());
                LayoutNodeWrapper layoutNodeWrapper2 = ((FocusModifier) t11).getLayoutNodeWrapper();
                if (layoutNodeWrapper2 != null && (layoutNode$ui_release = layoutNodeWrapper2.getLayoutNode$ui_release()) != null) {
                    numValueOf = Integer.valueOf(layoutNode$ui_release.getPlaceOrder$ui_release());
                }
                return x8.b.a(numValueOf2, numValueOf);
            }
        });
    }
}
