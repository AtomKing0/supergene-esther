package ga;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Call.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface e extends Cloneable {

    /* JADX INFO: compiled from: Call.kt */
    public interface a {
        @NotNull
        e b(@NotNull b0 b0Var);
    }

    @NotNull
    b0 a();

    void cancel();

    @NotNull
    d0 execute() throws IOException;

    boolean isCanceled();

    void n(@NotNull f fVar);
}
