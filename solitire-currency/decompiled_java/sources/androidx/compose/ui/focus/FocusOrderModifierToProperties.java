package androidx.compose.ui.focus;

import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FocusOrderModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusOrderModifierToProperties implements l<FocusProperties, k0> {

    @NotNull
    private final FocusOrderModifier modifier;

    public FocusOrderModifierToProperties(@NotNull FocusOrderModifier modifier) {
        t.i(modifier, "modifier");
        this.modifier = modifier;
    }

    @NotNull
    public final FocusOrderModifier getModifier() {
        return this.modifier;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(FocusProperties focusProperties) {
        invoke2(focusProperties);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@NotNull FocusProperties focusProperties) {
        t.i(focusProperties, "focusProperties");
        this.modifier.populateFocusOrder(new FocusOrder(focusProperties));
    }
}
