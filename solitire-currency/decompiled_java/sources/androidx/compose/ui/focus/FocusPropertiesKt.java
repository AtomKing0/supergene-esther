package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FocusProperties.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusPropertiesKt {

    @NotNull
    private static final ProvidableModifierLocal<FocusPropertiesModifier> ModifierLocalFocusProperties = ModifierLocalKt.modifierLocalOf(FocusPropertiesKt$ModifierLocalFocusProperties$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusPropertiesKt$refreshFocusProperties$1, reason: invalid class name */
    /* JADX INFO: compiled from: FocusProperties.kt */
    static final class AnonymousClass1 extends v implements h9.a<k0> {
        final /* synthetic */ FocusModifier $this_refreshFocusProperties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FocusModifier focusModifier) {
            super(0);
            this.$this_refreshFocusProperties = focusModifier;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FocusPropertiesModifier focusPropertiesModifier = this.$this_refreshFocusProperties.getFocusPropertiesModifier();
            if (focusPropertiesModifier != null) {
                focusPropertiesModifier.calculateProperties(this.$this_refreshFocusProperties.getFocusProperties());
            }
        }
    }

    public static final void clear(@NotNull FocusProperties focusProperties) {
        t.i(focusProperties, "<this>");
        focusProperties.setCanFocus(true);
        FocusRequester.Companion companion = FocusRequester.Companion;
        focusProperties.setNext(companion.getDefault());
        focusProperties.setPrevious(companion.getDefault());
        focusProperties.setUp(companion.getDefault());
        focusProperties.setDown(companion.getDefault());
        focusProperties.setLeft(companion.getDefault());
        focusProperties.setRight(companion.getDefault());
        focusProperties.setStart(companion.getDefault());
        focusProperties.setEnd(companion.getDefault());
    }

    @NotNull
    public static final Modifier focusProperties(@NotNull Modifier modifier, @NotNull l<? super FocusProperties, k0> scope) {
        t.i(modifier, "<this>");
        t.i(scope, "scope");
        return modifier.then(new FocusPropertiesModifier(scope, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusPropertiesKt$focusProperties$$inlined$debugInspectorInfo$1(scope) : InspectableValueKt.getNoInspectorInfo()));
    }

    @NotNull
    public static final ProvidableModifierLocal<FocusPropertiesModifier> getModifierLocalFocusProperties() {
        return ModifierLocalFocusProperties;
    }

    public static final void refreshFocusProperties(@NotNull FocusModifier focusModifier) {
        OwnerSnapshotObserver snapshotObserver;
        t.i(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (layoutNodeWrapper == null) {
            return;
        }
        clear(focusModifier.getFocusProperties());
        Owner owner$ui_release = layoutNodeWrapper.getLayoutNode$ui_release().getOwner$ui_release();
        if (owner$ui_release != null && (snapshotObserver = owner$ui_release.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(focusModifier, FocusModifier.Companion.getRefreshFocusProperties(), new AnonymousClass1(focusModifier));
        }
        setUpdatedProperties(focusModifier, focusModifier.getFocusProperties());
    }

    public static final void setUpdatedProperties(@NotNull FocusModifier focusModifier, @NotNull FocusProperties properties) {
        t.i(focusModifier, "<this>");
        t.i(properties, "properties");
        if (properties.getCanFocus()) {
            FocusTransactionsKt.activateNode(focusModifier);
        } else {
            FocusTransactionsKt.deactivateNode(focusModifier);
        }
    }
}
