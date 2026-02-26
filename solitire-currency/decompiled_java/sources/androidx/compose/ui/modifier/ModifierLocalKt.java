package androidx.compose.ui.modifier;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ModifierLocal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalKt {
    @NotNull
    public static final <T> ProvidableModifierLocal<T> modifierLocalOf(@NotNull h9.a<? extends T> defaultFactory) {
        t.i(defaultFactory, "defaultFactory");
        return new ProvidableModifierLocal<>(defaultFactory);
    }
}
