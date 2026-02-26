package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ModifierLocal.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class ProvidableModifierLocal<T> extends ModifierLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableModifierLocal(@NotNull h9.a<? extends T> defaultFactory) {
        super(defaultFactory, null);
        t.i(defaultFactory, "defaultFactory");
    }
}
