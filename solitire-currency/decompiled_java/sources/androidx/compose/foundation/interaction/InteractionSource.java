package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;
import s9.h;

/* JADX INFO: compiled from: InteractionSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface InteractionSource {
    @NotNull
    h<Interaction> getInteractions();
}
