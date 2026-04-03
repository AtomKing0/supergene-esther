package androidx.compose.ui.focus;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FocusRequesterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusRequesterModifierKt {

    @NotNull
    private static final ProvidableModifierLocal<FocusRequesterModifierLocal> ModifierLocalFocusRequester = ModifierLocalKt.modifierLocalOf(FocusRequesterModifierKt$ModifierLocalFocusRequester$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusRequesterModifierKt$focusRequester$2, reason: invalid class name */
    /* JADX INFO: compiled from: FocusRequesterModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ FocusRequester $focusRequester;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FocusRequester focusRequester) {
            super(3);
            this.$focusRequester = focusRequester;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-307396750);
            FocusRequester focusRequester = this.$focusRequester;
            int i11 = MutableVector.$stable;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(focusRequester);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new FocusRequesterModifierLocal(focusRequester);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) objRememberedValue;
            composer.endReplaceableGroup();
            return focusRequesterModifierLocal;
        }
    }

    @NotNull
    public static final Modifier focusRequester(@NotNull Modifier modifier, @NotNull FocusRequester focusRequester) {
        t.i(modifier, "<this>");
        t.i(focusRequester, "focusRequester");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusRequesterModifierKt$focusRequester$$inlined$debugInspectorInfo$1(focusRequester) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(focusRequester));
    }

    @NotNull
    public static final ProvidableModifierLocal<FocusRequesterModifierLocal> getModifierLocalFocusRequester() {
        return ModifierLocalFocusRequester;
    }
}
