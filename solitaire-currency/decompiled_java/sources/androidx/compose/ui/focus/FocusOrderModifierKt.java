package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: FocusOrderModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusOrderModifierKt {

    /* JADX INFO: compiled from: FocusOrderModifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m1319customFocusSearchOMvw8(@NotNull FocusModifier customFocusSearch, int i10, @NotNull LayoutDirection layoutDirection) {
        FocusRequester end;
        t.i(customFocusSearch, "$this$customFocusSearch");
        t.i(layoutDirection, "layoutDirection");
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1312getNextdhqQ8s())) {
            return customFocusSearch.getFocusProperties().getNext();
        }
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1314getPreviousdhqQ8s())) {
            return customFocusSearch.getFocusProperties().getPrevious();
        }
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s())) {
            return customFocusSearch.getFocusProperties().getUp();
        }
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
            return customFocusSearch.getFocusProperties().getDown();
        }
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s())) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i11 == 1) {
                end = customFocusSearch.getFocusProperties().getStart();
            } else {
                if (i11 != 2) {
                    throw new q();
                }
                end = customFocusSearch.getFocusProperties().getEnd();
            }
            if (t.d(end, FocusRequester.Companion.getDefault())) {
                end = null;
            }
            if (end == null) {
                return customFocusSearch.getFocusProperties().getLeft();
            }
        } else {
            if (!FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
                if (FocusDirection.m1303equalsimpl0(i10, companion.m1310getIndhqQ8s())) {
                    return FocusRequester.Companion.getDefault();
                }
                if (FocusDirection.m1303equalsimpl0(i10, companion.m1313getOutdhqQ8s())) {
                    return FocusRequester.Companion.getDefault();
                }
                throw new IllegalStateException("invalid FocusDirection".toString());
            }
            int i12 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i12 == 1) {
                end = customFocusSearch.getFocusProperties().getEnd();
            } else {
                if (i12 != 2) {
                    throw new q();
                }
                end = customFocusSearch.getFocusProperties().getStart();
            }
            if (t.d(end, FocusRequester.Companion.getDefault())) {
                end = null;
            }
            if (end == null) {
                return customFocusSearch.getFocusProperties().getRight();
            }
        }
        return end;
    }

    @NotNull
    public static final Modifier focusOrder(@NotNull Modifier modifier, @NotNull l<? super FocusOrder, k0> focusOrderReceiver) {
        t.i(modifier, "<this>");
        t.i(focusOrderReceiver, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(modifier, new FocusOrderToProperties(focusOrderReceiver));
    }

    @NotNull
    public static final Modifier focusOrder(@NotNull Modifier modifier, @NotNull FocusRequester focusRequester) {
        t.i(modifier, "<this>");
        t.i(focusRequester, "focusRequester");
        return FocusRequesterModifierKt.focusRequester(modifier, focusRequester);
    }

    @NotNull
    public static final Modifier focusOrder(@NotNull Modifier modifier, @NotNull FocusRequester focusRequester, @NotNull l<? super FocusOrder, k0> focusOrderReceiver) {
        t.i(modifier, "<this>");
        t.i(focusRequester, "focusRequester");
        t.i(focusOrderReceiver, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(FocusRequesterModifierKt.focusRequester(modifier, focusRequester), new FocusOrderToProperties(focusOrderReceiver));
    }
}
