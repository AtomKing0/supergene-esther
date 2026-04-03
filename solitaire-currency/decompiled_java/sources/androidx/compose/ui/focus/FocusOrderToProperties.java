package androidx.compose.ui.focus;

import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FocusOrderModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusOrderToProperties implements l<FocusProperties, k0> {

    @NotNull
    private final l<FocusOrder, k0> focusOrderReceiver;

    /* JADX WARN: Multi-variable type inference failed */
    public FocusOrderToProperties(@NotNull l<? super FocusOrder, k0> focusOrderReceiver) {
        t.i(focusOrderReceiver, "focusOrderReceiver");
        this.focusOrderReceiver = focusOrderReceiver;
    }

    @NotNull
    public final l<FocusOrder, k0> getFocusOrderReceiver() {
        return this.focusOrderReceiver;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(FocusProperties focusProperties) {
        invoke2(focusProperties);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@NotNull FocusProperties focusProperties) {
        t.i(focusProperties, "focusProperties");
        this.focusOrderReceiver.invoke(new FocusOrder(focusProperties));
    }
}
