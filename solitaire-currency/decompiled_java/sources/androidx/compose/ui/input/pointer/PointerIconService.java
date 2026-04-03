package androidx.compose.ui.input.pointer;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerIcon.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PointerIconService {
    @NotNull
    PointerIcon getCurrent();

    void setCurrent(@NotNull PointerIcon pointerIcon);
}
