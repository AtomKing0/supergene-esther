package io.sentry;

import java.time.Instant;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SentryInstantDate.java */
/* JADX INFO: loaded from: classes5.dex */
public final class y6 extends n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Instant f28513a;

    public y6() {
        this(Instant.now());
    }

    @Override // io.sentry.n5
    public long g() {
        return n.n(this.f28513a.getEpochSecond()) + ((long) this.f28513a.getNano());
    }

    public y6(@NotNull Instant instant) {
        this.f28513a = instant;
    }
}
