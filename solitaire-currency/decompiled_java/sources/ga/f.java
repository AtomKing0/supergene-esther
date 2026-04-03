package ga;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Callback.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface f {
    void onFailure(@NotNull e eVar, @NotNull IOException iOException);

    void onResponse(@NotNull e eVar, @NotNull d0 d0Var) throws IOException;
}
