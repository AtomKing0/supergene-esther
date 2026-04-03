package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.a;
import s9.e0;
import s9.x;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: InteractionSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class MutableInteractionSourceImpl implements MutableInteractionSource {

    @NotNull
    private final x<Interaction> interactions = e0.b(0, 16, a.DROP_OLDEST, 1, null);

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    @Nullable
    public Object emit(@NotNull Interaction interaction, @NotNull d<? super k0> dVar) {
        Object objEmit = getInteractions().emit(interaction, dVar);
        return objEmit == a9.d.e() ? objEmit : k0.f35197a;
    }

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public boolean tryEmit(@NotNull Interaction interaction) {
        t.i(interaction, "interaction");
        return getInteractions().a(interaction);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    @NotNull
    public x<Interaction> getInteractions() {
        return this.interactions;
    }
}
