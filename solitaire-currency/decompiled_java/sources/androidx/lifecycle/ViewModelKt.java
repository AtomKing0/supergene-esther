package androidx.lifecycle;

import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelKt {

    @NotNull
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @NotNull
    public static final o0 getViewModelScope(@NotNull ViewModel viewModel) {
        o0 o0Var = (o0) viewModel.getTag(JOB_KEY);
        return o0Var != null ? o0Var : (o0) viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(y2.b(null, 1, null).plus(e1.c().getImmediate())));
    }
}
