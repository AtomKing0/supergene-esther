package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusRequesterModifier;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ComposedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposedModifierKt$materialize$result$1 extends v implements p<Modifier, Modifier.Element, Modifier> {
    final /* synthetic */ Composer $this_materialize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposedModifierKt$materialize$result$1(Composer composer) {
        super(2);
        this.$this_materialize = composer;
    }

    @Override // h9.p
    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Modifier mo4invoke(@NotNull Modifier acc, @NotNull Modifier.Element element) {
        Modifier modifierThen;
        t.i(acc, "acc");
        t.i(element, "element");
        if (element instanceof ComposedModifier) {
            modifierThen = ComposedModifierKt.materialize(this.$this_materialize, (Modifier) ((q) t0.f(((ComposedModifier) element).getFactory(), 3)).invoke(Modifier.Companion, this.$this_materialize, 0));
        } else {
            Modifier modifierThen2 = element instanceof FocusEventModifier ? element.then((Modifier) ((q) t0.f(ComposedModifierKt.WrapFocusEventModifier, 3)).invoke(element, this.$this_materialize, 0)) : element;
            modifierThen = element instanceof FocusRequesterModifier ? modifierThen2.then((Modifier) ((q) t0.f(ComposedModifierKt.WrapFocusRequesterModifier, 3)).invoke(element, this.$this_materialize, 0)) : modifierThen2;
        }
        return acc.then(modifierThen);
    }
}
