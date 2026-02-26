package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.semantics.Role;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ClickableKt$clickable$4 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ h9.a<k0> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Role $role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$4(h9.a<k0> aVar, boolean z10, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role) {
        super(3);
        this.$onClick = aVar;
        this.$enabled = z10;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$onClickLabel = str;
        this.$role = role;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
        t.i(composed, "$this$composed");
        composer.startReplaceableGroup(92076020);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer, 0);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        composer.startReplaceableGroup(1841981204);
        if (this.$enabled) {
            ClickableKt.PressedInteractionSourceDisposableEffect(this.$interactionSource, mutableState, composer, 48);
        }
        composer.endReplaceableGroup();
        h9.a<Boolean> aVarIsComposeRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer(composer, 0);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) objRememberedValue2;
        State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(new ClickableKt$clickable$4$delayPressInteraction$1(mutableState2, aVarIsComposeRootInScrollableContainer), composer, 0);
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, this.$interactionSource, Boolean.valueOf(this.$enabled), new ClickableKt$clickable$4$gesture$1(this.$enabled, this.$interactionSource, mutableState, stateRememberUpdatedState2, stateRememberUpdatedState, null));
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new ModifierLocalConsumer() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$1$1
                @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
                public /* synthetic */ boolean all(h9.l lVar) {
                    return androidx.compose.ui.b.a(this, lVar);
                }

                @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
                public /* synthetic */ boolean any(h9.l lVar) {
                    return androidx.compose.ui.b.b(this, lVar);
                }

                @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
                public /* synthetic */ Object foldIn(Object obj, h9.p pVar) {
                    return androidx.compose.ui.b.c(this, obj, pVar);
                }

                @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
                public /* synthetic */ Object foldOut(Object obj, h9.p pVar) {
                    return androidx.compose.ui.b.d(this, obj, pVar);
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
        Modifier modifierM190genericClickableWithoutGestureBILeDI = ClickableKt.m190genericClickableWithoutGestureBILeDI(companion2.then((Modifier) objRememberedValue3), modifierPointerInput, this.$interactionSource, this.$indication, this.$enabled, this.$onClickLabel, this.$role, null, null, this.$onClick);
        composer.endReplaceableGroup();
        return modifierM190genericClickableWithoutGestureBILeDI;
    }
}
