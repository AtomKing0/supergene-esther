package androidx.compose.ui.focus;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FocusModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class FocusModifier$Companion$RefreshFocusProperties$1 extends v implements l<FocusModifier, k0> {
    public static final FocusModifier$Companion$RefreshFocusProperties$1 INSTANCE = new FocusModifier$Companion$RefreshFocusProperties$1();

    FocusModifier$Companion$RefreshFocusProperties$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(FocusModifier focusModifier) {
        invoke2(focusModifier);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "focusModifier");
        FocusPropertiesKt.refreshFocusProperties(focusModifier);
    }
}
