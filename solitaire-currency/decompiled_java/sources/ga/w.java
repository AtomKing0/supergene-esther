package ga;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface w {

    /* JADX INFO: compiled from: Interceptor.kt */
    public interface a {
        @NotNull
        b0 a();

        @NotNull
        d0 b(@NotNull b0 b0Var) throws IOException;

        @NotNull
        e call();
    }

    @NotNull
    d0 intercept(@NotNull a aVar) throws IOException;
}
