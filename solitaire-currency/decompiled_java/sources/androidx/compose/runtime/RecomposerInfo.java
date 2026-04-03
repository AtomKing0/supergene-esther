package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import org.jetbrains.annotations.NotNull;
import s9.h;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RecomposerInfo {
    long getChangeCount();

    boolean getHasPendingWork();

    @NotNull
    h<Recomposer.State> getState();
}
