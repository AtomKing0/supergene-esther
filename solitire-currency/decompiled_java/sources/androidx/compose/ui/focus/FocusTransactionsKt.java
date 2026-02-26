package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: FocusTransactions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusTransactionsKt {

    /* JADX INFO: compiled from: FocusTransactions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void activateNode(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()];
        if (i10 == 3) {
            focusModifier.setFocusState(FocusStateImpl.Inactive);
        } else {
            if (i10 != 4) {
                return;
            }
            focusModifier.setFocusState(FocusStateImpl.ActiveParent);
        }
    }

    public static final boolean captureFocus(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                focusModifier.setFocusState(FocusStateImpl.Captured);
                return true;
            case 2:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new q();
        }
    }

    private static final boolean clearChildFocus(FocusModifier focusModifier) {
        FocusModifier focusedChild = focusModifier.getFocusedChild();
        if (focusedChild == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (!clearFocus$default(focusedChild, false, 1, null)) {
            return false;
        }
        focusModifier.setFocusedChild(null);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final boolean clearFocus(@NotNull FocusModifier focusModifier, boolean z10) {
        t.i(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                focusModifier.setFocusState(FocusStateImpl.Inactive);
                return true;
            case 2:
                if (!z10) {
                    return z10;
                }
                focusModifier.setFocusState(FocusStateImpl.Inactive);
                return z10;
            case 3:
            case 6:
                return true;
            case 4:
                if (clearChildFocus(focusModifier)) {
                    focusModifier.setFocusState(FocusStateImpl.Deactivated);
                    return true;
                }
                return false;
            case 5:
                if (clearChildFocus(focusModifier)) {
                    focusModifier.setFocusState(FocusStateImpl.Inactive);
                    return true;
                }
                return false;
            default:
                throw new q();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusModifier focusModifier, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return clearFocus(focusModifier, z10);
    }

    public static final void deactivateNode(@NotNull FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        Owner owner$ui_release;
        FocusManager focusManager;
        t.i(focusModifier, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 == 5) {
                focusModifier.setFocusState(FocusStateImpl.DeactivatedParent);
                return;
            } else {
                if (i10 != 6) {
                    return;
                }
                focusModifier.setFocusState(FocusStateImpl.Deactivated);
                return;
            }
        }
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (layoutNodeWrapper != null && (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode$ui_release()) != null && (owner$ui_release = layoutNode$ui_release.getOwner$ui_release()) != null && (focusManager = owner$ui_release.getFocusManager()) != null) {
            focusManager.clearFocus(true);
        }
        focusModifier.setFocusState(FocusStateImpl.Deactivated);
    }

    public static final boolean freeFocus(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                return true;
            case 2:
                focusModifier.setFocusState(FocusStateImpl.Active);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new q();
        }
    }

    private static final void grantFocus(FocusModifier focusModifier) {
        FocusStateImpl focusStateImpl;
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 5:
            case 6:
                focusStateImpl = FocusStateImpl.Active;
                break;
            case 2:
                focusStateImpl = FocusStateImpl.Captured;
                break;
            case 3:
            case 4:
                throw new IllegalStateException("Granting focus to a deactivated node.".toString());
            default:
                throw new q();
        }
        focusModifier.setFocusState(focusStateImpl);
    }

    private static final boolean grantFocusToChild(FocusModifier focusModifier, FocusModifier focusModifier2) {
        focusModifier.setFocusedChild(focusModifier2);
        grantFocus(focusModifier2);
        return true;
    }

    public static final void requestFocus(@NotNull FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        t.i(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (((layoutNodeWrapper == null || (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode$ui_release()) == null) ? null : layoutNode$ui_release.getOwner$ui_release()) == null) {
            focusModifier.setFocusRequestedOnPlaced(true);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                sendOnFocusEvent(focusModifier);
                break;
            case 5:
                if (clearChildFocus(focusModifier)) {
                    grantFocus(focusModifier);
                }
                break;
            case 6:
                FocusModifier parent = focusModifier.getParent();
                if (parent != null) {
                    requestFocusForChild(parent, focusModifier);
                } else if (requestFocusForOwner(focusModifier)) {
                    grantFocus(focusModifier);
                }
                break;
        }
    }

    private static final boolean requestFocusForChild(FocusModifier focusModifier, FocusModifier focusModifier2) {
        if (!focusModifier.getChildren().contains(focusModifier2)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                focusModifier.setFocusState(FocusStateImpl.ActiveParent);
                return grantFocusToChild(focusModifier, focusModifier2);
            case 2:
                return false;
            case 3:
                activateNode(focusModifier);
                boolean zRequestFocusForChild = requestFocusForChild(focusModifier, focusModifier2);
                deactivateNode(focusModifier);
                return zRequestFocusForChild;
            case 4:
                if (focusModifier.getFocusedChild() == null) {
                    return grantFocusToChild(focusModifier, focusModifier2);
                }
                if (clearChildFocus(focusModifier)) {
                    return grantFocusToChild(focusModifier, focusModifier2);
                }
                return false;
            case 5:
                if (clearChildFocus(focusModifier)) {
                    return grantFocusToChild(focusModifier, focusModifier2);
                }
                return false;
            case 6:
                FocusModifier parent = focusModifier.getParent();
                if (parent == null && requestFocusForOwner(focusModifier)) {
                    focusModifier.setFocusState(FocusStateImpl.Active);
                    return requestFocusForChild(focusModifier, focusModifier2);
                }
                if (parent == null || !requestFocusForChild(parent, focusModifier)) {
                    return false;
                }
                return requestFocusForChild(focusModifier, focusModifier2);
            default:
                throw new q();
        }
    }

    private static final boolean requestFocusForOwner(FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        Owner owner$ui_release;
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (layoutNodeWrapper == null || (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode$ui_release()) == null || (owner$ui_release = layoutNode$ui_release.getOwner$ui_release()) == null) {
            throw new IllegalStateException("Owner not initialized.".toString());
        }
        return owner$ui_release.requestFocus();
    }

    public static final void sendOnFocusEvent(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "<this>");
        FocusEventModifierLocal focusEventListener = focusModifier.getFocusEventListener();
        if (focusEventListener != null) {
            focusEventListener.propagateFocusEvent();
        }
    }
}
