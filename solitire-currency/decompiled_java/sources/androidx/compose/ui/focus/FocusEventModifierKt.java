package androidx.compose.ui.focus;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FocusEventModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusEventModifierKt {

    @NotNull
    private static final ProvidableModifierLocal<FocusEventModifierLocal> ModifierLocalFocusEvent = ModifierLocalKt.modifierLocalOf(FocusEventModifierKt$ModifierLocalFocusEvent$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusEventModifierKt$onFocusEvent$2, reason: invalid class name */
    /* JADX INFO: compiled from: FocusEventModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ l<FocusState, k0> $onFocusEvent;

        /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusEventModifierKt$onFocusEvent$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FocusEventModifier.kt */
        static final class AnonymousClass1 extends v implements h9.a<k0> {
            final /* synthetic */ FocusEventModifierLocal $modifier;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(FocusEventModifierLocal focusEventModifierLocal) {
                super(0);
                this.$modifier = focusEventModifierLocal;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$modifier.notifyIfNoFocusModifiers();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(l<? super FocusState, k0> lVar) {
            super(3);
            this.$onFocusEvent = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(607036704);
            l<FocusState, k0> lVar = this.$onFocusEvent;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(lVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new FocusEventModifierLocal(lVar);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            FocusEventModifierLocal focusEventModifierLocal = (FocusEventModifierLocal) objRememberedValue;
            EffectsKt.SideEffect(new AnonymousClass1(focusEventModifierLocal), composer, 0);
            composer.endReplaceableGroup();
            return focusEventModifierLocal;
        }
    }

    @NotNull
    public static final ProvidableModifierLocal<FocusEventModifierLocal> getModifierLocalFocusEvent() {
        return ModifierLocalFocusEvent;
    }

    @NotNull
    public static final Modifier onFocusEvent(@NotNull Modifier modifier, @NotNull l<? super FocusState, k0> onFocusEvent) {
        t.i(modifier, "<this>");
        t.i(onFocusEvent, "onFocusEvent");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusEventModifierKt$onFocusEvent$$inlined$debugInspectorInfo$1(onFocusEvent) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(onFocusEvent));
    }
}
