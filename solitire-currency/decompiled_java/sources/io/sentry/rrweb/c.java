package io.sentry.rrweb;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RRWebEventType.java */
/* JADX INFO: loaded from: classes5.dex */
public enum c implements h2 {
    DomContentLoaded,
    Load,
    FullSnapshot,
    IncrementalSnapshot,
    Meta,
    Custom,
    Plugin;

    /* JADX INFO: compiled from: RRWebEventType.java */
    public static final class a implements x1<c> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            return c.values()[l3Var.nextInt()];
        }
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.a(ordinal());
    }
}
