package io.sentry.clientreport;

import io.sentry.m;
import io.sentry.p5;
import io.sentry.p6;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IClientReportRecorder.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public interface h {
    void a(@NotNull f fVar, @NotNull m mVar);

    void b(@NotNull f fVar, @Nullable p5 p5Var);

    void c(@NotNull f fVar, @NotNull m mVar, long j10);

    void d(@NotNull f fVar, @Nullable p6 p6Var);

    @NotNull
    p5 e(@NotNull p5 p5Var);
}
