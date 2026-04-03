package io.sentry.util;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SentryRandom.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final b f28339a = new b();

    /* JADX INFO: compiled from: SentryRandom.java */
    private static class b extends ThreadLocal<z> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z initialValue() {
            return new z();
        }
    }

    @NotNull
    public static z a() {
        return f28339a.get();
    }
}
