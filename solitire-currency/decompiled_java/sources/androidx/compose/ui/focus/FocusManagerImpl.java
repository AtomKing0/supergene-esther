package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: FocusManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusManagerImpl implements FocusManager {

    @NotNull
    private final FocusModifier focusModifier;
    public LayoutDirection layoutDirection;

    @NotNull
    private final Modifier modifier;

    /* JADX INFO: compiled from: FocusManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 4;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusManagerImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: wrapAroundFocus-3ESFkO8, reason: not valid java name */
    private final boolean m1318wrapAroundFocus3ESFkO8(int i10) {
        if (this.focusModifier.getFocusState().getHasFocus() && !this.focusModifier.getFocusState().isFocused()) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (FocusDirection.m1303equalsimpl0(i10, companion.m1312getNextdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1314getPreviousdhqQ8s())) {
                clearFocus(false);
                if (this.focusModifier.getFocusState().isFocused()) {
                    return mo1317moveFocus3ESFkO8(i10);
                }
                return false;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean z10) {
        FocusStateImpl focusStateImpl;
        FocusStateImpl focusState = this.focusModifier.getFocusState();
        if (FocusTransactionsKt.clearFocus(this.focusModifier, z10)) {
            FocusModifier focusModifier = this.focusModifier;
            switch (WhenMappings.$EnumSwitchMapping$0[focusState.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    focusStateImpl = FocusStateImpl.Active;
                    break;
                case 4:
                case 5:
                    focusStateImpl = FocusStateImpl.Deactivated;
                    break;
                case 6:
                    focusStateImpl = FocusStateImpl.Inactive;
                    break;
                default:
                    throw new q();
            }
            focusModifier.setFocusState(focusStateImpl);
        }
    }

    public final void fetchUpdatedFocusProperties() {
        FocusManagerKt.updateProperties(this.focusModifier);
    }

    @Nullable
    public final FocusModifier getActiveFocusModifier$ui_release() {
        return FocusManagerKt.findActiveItem(this.focusModifier);
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        t.A("layoutDirection");
        return null;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* JADX INFO: renamed from: moveFocus-3ESFkO8 */
    public boolean mo1317moveFocus3ESFkO8(int i10) {
        FocusModifier focusModifierFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.focusModifier);
        if (focusModifierFindActiveFocusNode == null) {
            return false;
        }
        FocusRequester focusRequesterM1319customFocusSearchOMvw8 = FocusOrderModifierKt.m1319customFocusSearchOMvw8(focusModifierFindActiveFocusNode, i10, getLayoutDirection());
        if (t.d(focusRequesterM1319customFocusSearchOMvw8, FocusRequester.Companion.getDefault())) {
            return FocusTraversalKt.m1320focusSearchsMXa3k8(this.focusModifier, i10, getLayoutDirection(), new FocusManagerImpl$moveFocus$1(focusModifierFindActiveFocusNode)) || m1318wrapAroundFocus3ESFkO8(i10);
        }
        focusRequesterM1319customFocusSearchOMvw8.requestFocus();
        return true;
    }

    public final void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.focusModifier, true);
    }

    public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    public final void takeFocus() {
        if (this.focusModifier.getFocusState() == FocusStateImpl.Inactive) {
            this.focusModifier.setFocusState(FocusStateImpl.Active);
        }
    }

    public FocusManagerImpl(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "focusModifier");
        this.focusModifier = focusModifier;
        this.modifier = FocusModifierKt.focusTarget(Modifier.Companion, focusModifier);
    }

    public /* synthetic */ FocusManagerImpl(FocusModifier focusModifier, int i10, k kVar) {
        this((i10 & 1) != 0 ? new FocusModifier(FocusStateImpl.Inactive, null, 2, null) : focusModifier);
    }
}
