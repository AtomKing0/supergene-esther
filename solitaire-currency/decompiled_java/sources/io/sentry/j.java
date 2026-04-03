package io.sentry;

import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompositePerformanceCollector.java */
/* JADX INFO: loaded from: classes5.dex */
public interface j {
    void a(@NotNull n1 n1Var);

    void b(@NotNull n1 n1Var);

    @Nullable
    List<r3> c(@NotNull String str);

    @ApiStatus.Internal
    void close();

    @Nullable
    List<r3> d(@NotNull p1 p1Var);

    void e(@NotNull p1 p1Var);

    void f(@NotNull String str);
}
