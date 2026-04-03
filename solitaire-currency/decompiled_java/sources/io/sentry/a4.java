package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplayController.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public interface a4 extends b1 {
    void a(@Nullable Boolean bool);

    void pause();

    void resume();

    void start();

    void stop();
}
