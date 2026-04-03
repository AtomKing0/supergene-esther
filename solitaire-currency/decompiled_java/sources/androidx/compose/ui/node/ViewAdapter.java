package androidx.compose.ui.node;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewInterop.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ViewAdapter {
    void didInsert(@NotNull View view, @NotNull ViewGroup viewGroup);

    void didUpdate(@NotNull View view, @NotNull ViewGroup viewGroup);

    int getId();

    void willInsert(@NotNull View view, @NotNull ViewGroup viewGroup);
}
