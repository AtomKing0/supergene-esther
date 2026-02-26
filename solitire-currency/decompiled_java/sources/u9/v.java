package u9;

import java.util.List;
import kotlinx.coroutines.n2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainDispatcherFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface v {
    @NotNull
    n2 createDispatcher(@NotNull List<? extends v> list);

    int getLoadPriority();

    @Nullable
    String hintOnError();
}
