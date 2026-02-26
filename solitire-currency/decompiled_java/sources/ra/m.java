package ra;

import ga.a0;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface m {
    boolean a(@NotNull SSLSocket sSLSocket);

    @Nullable
    String b(@NotNull SSLSocket sSLSocket);

    void c(@NotNull SSLSocket sSLSocket, @Nullable String str, @NotNull List<? extends a0> list);

    boolean isSupported();
}
