package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextToolbar.kt */
/* JADX INFO: loaded from: classes.dex */
public interface TextToolbar {

    /* JADX INFO: compiled from: TextToolbar.kt */
    public static final class DefaultImpls {
    }

    @NotNull
    TextToolbarStatus getStatus();

    void hide();

    void showMenu(@NotNull Rect rect, @Nullable h9.a<v8.k0> aVar, @Nullable h9.a<v8.k0> aVar2, @Nullable h9.a<v8.k0> aVar3, @Nullable h9.a<v8.k0> aVar4);
}
