package ma;

import ga.b0;
import ga.d0;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.x0;
import ua.z0;

/* JADX INFO: compiled from: ExchangeCodec.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface d {
    void a() throws IOException;

    @NotNull
    la.f b();

    long c(@NotNull d0 d0Var) throws IOException;

    void cancel();

    void d(@NotNull b0 b0Var) throws IOException;

    @NotNull
    x0 e(@NotNull b0 b0Var, long j10) throws IOException;

    @Nullable
    d0.a f(boolean z10) throws IOException;

    void g() throws IOException;

    @NotNull
    z0 h(@NotNull d0 d0Var) throws IOException;
}
