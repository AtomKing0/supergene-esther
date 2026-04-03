package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpEnvelopeReader.java */
/* JADX INFO: loaded from: classes5.dex */
public final class q2 implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q2 f28093a = new q2();

    private q2() {
    }

    public static q2 b() {
        return f28093a;
    }

    @Override // io.sentry.t0
    @Nullable
    public p5 a(@NotNull InputStream inputStream) throws IOException {
        return null;
    }
}
