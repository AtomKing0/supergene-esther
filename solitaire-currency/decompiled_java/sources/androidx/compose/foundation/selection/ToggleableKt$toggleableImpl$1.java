package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Clickable_androidKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.b;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.state.ToggleableState;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Toggleable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ToggleableKt$toggleableImpl$1 extends v implements q<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ Role $role;
    final /* synthetic */ ToggleableState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleableImpl$1(a<k0> aVar, boolean z10, MutableInteractionSource mutableInteractionSource, Indication indication, Role role, ToggleableState toggleableState) {
        super(3);
        this.$onClick = aVar;
        this.$enabled = z10;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$role = role;
        this.$state = toggleableState;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
        t.i(composed, "$this$composed");
        composer.startReplaceableGroup(2121285826);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier modifierSemantics = SemanticsModifierKt.semantics(companion2, true, new ToggleableKt$toggleableImpl$1$semantics$1(this.$role, this.$state, this.$enabled, this.$onClick));
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer, 0);
        composer.startReplaceableGroup(-2134919160);
        if (this.$enabled) {
            ClickableKt.PressedInteractionSourceDisposableEffect(this.$interactionSource, mutableState, composer, 48);
        }
        composer.endReplaceableGroup();
        a<Boolean> aVarIsComposeRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer(composer, 0);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) objRememberedValue2;
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, this.$interactionSource, Boolean.valueOf(this.$enabled), new ToggleableKt$toggleableImpl$1$gestures$1(this.$enabled, this.$interactionSource, mutableState, SnapshotStateKt.rememberUpdatedState(new ToggleableKt$toggleableImpl$1$delayPressInteraction$1(mutableState2, aVarIsComposeRootInScrollableContainer), composer, 0), stateRememberUpdatedState, null));
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new ModifierLocalConsumer() { // from class: androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$1$1
                @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
                public /* synthetic */ boolean all(l lVar) {
                    return b.a(this, lVar);
                }

                @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
                public /* synthetic */ boolean any(l lVar) {
                    return b.b(this, lVar);
                }

                @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
                public /* synthetic */ Object foldIn(Object obj, p pVar) {
                    return b.c(this, obj, pVar);
                }

                @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
                public /* synthetic */ Object foldOut(Object obj, p pVar) {
                    return b.d(this, obj, pVar);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
                public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
                    t.i(scope, "scope");
                    mutableState2.setValue(scope.getCurrent(ScrollableKt.getModifierLocalScrollableContainer()));
                }

                @Override // androidx.compose.ui.Modifier
                public /* synthetic */ Modifier then(Modifier modifier) {
                    return androidx.compose.ui.a.a(this, modifier);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        Modifier modifierThen = FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(composed.then((Modifier) objRememberedValue3).then(modifierSemantics), this.$interactionSource, this.$indication), this.$interactionSource, this.$enabled), this.$enabled, this.$interactionSource).then(modifierPointerInput);
        composer.endReplaceableGroup();
        return modifierThen;
    }
}
