package androidx.compose.ui;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierLocal;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ComposedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposedModifierKt$WrapFocusEventModifier$1 extends v implements q<FocusEventModifier, Composer, Integer, FocusEventModifierLocal> {
    public static final ComposedModifierKt$WrapFocusEventModifier$1 INSTANCE = new ComposedModifierKt$WrapFocusEventModifier$1();

    /* JADX INFO: renamed from: androidx.compose.ui.ComposedModifierKt$WrapFocusEventModifier$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComposedModifier.kt */
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

    ComposedModifierKt$WrapFocusEventModifier$1() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ FocusEventModifierLocal invoke(FocusEventModifier focusEventModifier, Composer composer, Integer num) {
        return invoke(focusEventModifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final FocusEventModifierLocal invoke(@NotNull FocusEventModifier mod, @Nullable Composer composer, int i10) {
        t.i(mod, "mod");
        composer.startReplaceableGroup(-1790596922);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(mod);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new FocusEventModifierLocal(new ComposedModifierKt$WrapFocusEventModifier$1$modifier$1$1(mod));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        FocusEventModifierLocal focusEventModifierLocal = (FocusEventModifierLocal) objRememberedValue;
        EffectsKt.SideEffect(new AnonymousClass1(focusEventModifierLocal), composer, 0);
        composer.endReplaceableGroup();
        return focusEventModifierLocal;
    }
}
