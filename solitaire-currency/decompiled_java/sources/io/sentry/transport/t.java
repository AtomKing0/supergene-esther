package io.sentry.transport;

import io.sentry.l0;
import io.sentry.p5;
import java.util.Collections;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NoOpEnvelopeCache.java */
/* JADX INFO: loaded from: classes5.dex */
public final class t implements io.sentry.cache.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final t f28296a = new t();

    public static t a() {
        return f28296a;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<p5> iterator() {
        return Collections.emptyIterator();
    }

    @Override // io.sentry.cache.g
    public void c(@NotNull p5 p5Var) {
    }

    @Override // io.sentry.cache.g
    public void L(@NotNull p5 p5Var, @NotNull l0 l0Var) {
    }
}
