package androidx.compose.ui.focus;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FocusChangedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusChangedModifierKt {

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusChangedModifierKt$onFocusChanged$2, reason: invalid class name */
    /* JADX INFO: compiled from: FocusChangedModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ l<FocusState, k0> $onFocusChanged;

        /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusChangedModifierKt$onFocusChanged$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FocusChangedModifier.kt */
        static final class AnonymousClass1 extends v implements l<FocusState, k0> {
            final /* synthetic */ MutableState<FocusState> $focusState;
            final /* synthetic */ l<FocusState, k0> $onFocusChanged;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(MutableState<FocusState> mutableState, l<? super FocusState, k0> lVar) {
                super(1);
                this.$focusState = mutableState;
                this.$onFocusChanged = lVar;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(FocusState focusState) {
                invoke2(focusState);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FocusState it) {
                t.i(it, "it");
                if (t.d(this.$focusState.getValue(), it)) {
                    return;
                }
                this.$focusState.setValue(it);
                this.$onFocusChanged.invoke(it);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(l<? super FocusState, k0> lVar) {
            super(3);
            this.$onFocusChanged = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-1741761824);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierOnFocusEvent = FocusEventModifierKt.onFocusEvent(Modifier.Companion, new AnonymousClass1((MutableState) objRememberedValue, this.$onFocusChanged));
            composer.endReplaceableGroup();
            return modifierOnFocusEvent;
        }
    }

    @NotNull
    public static final Modifier onFocusChanged(@NotNull Modifier modifier, @NotNull l<? super FocusState, k0> onFocusChanged) {
        t.i(modifier, "<this>");
        t.i(onFocusChanged, "onFocusChanged");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusChangedModifierKt$onFocusChanged$$inlined$debugInspectorInfo$1(onFocusChanged) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(onFocusChanged));
    }
}
