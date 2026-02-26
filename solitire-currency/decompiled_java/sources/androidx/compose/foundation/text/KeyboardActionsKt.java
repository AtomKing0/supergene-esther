package androidx.compose.foundation.text;

import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: KeyboardActions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyboardActionsKt {
    @NotNull
    public static final KeyboardActions KeyboardActions(@NotNull l<? super KeyboardActionScope, k0> onAny) {
        t.i(onAny, "onAny");
        return new KeyboardActions(onAny, onAny, onAny, onAny, onAny, onAny);
    }
}
