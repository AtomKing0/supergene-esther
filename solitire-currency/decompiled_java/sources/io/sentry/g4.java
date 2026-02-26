package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import java.util.Collection;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ScopeObserverAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g4 implements d1 {
    @Override // io.sentry.d1
    public void a(@NotNull Map<String, String> map) {
    }

    @Override // io.sentry.d1
    public void d(@NotNull Collection<Breadcrumb> collection) {
    }

    @Override // io.sentry.d1
    public void e(@NotNull Collection<String> collection) {
    }

    @Override // io.sentry.d1
    public void g(@NotNull Contexts contexts) {
    }

    @Override // io.sentry.d1
    public void h(@Nullable Request request) {
    }

    @Override // io.sentry.d1
    public void i(@NotNull Map<String, Object> map) {
    }

    @Override // io.sentry.d1
    public void j(@NotNull SentryId sentryId) {
    }

    @Override // io.sentry.d1
    public void removeExtra(@NotNull String str) {
    }

    @Override // io.sentry.d1
    public void removeTag(@NotNull String str) {
    }

    @Override // io.sentry.d1
    public void setLevel(@Nullable SentryLevel sentryLevel) {
    }

    @Override // io.sentry.d1
    public void setTransaction(@Nullable String str) {
    }

    @Override // io.sentry.d1
    public void setExtra(@NotNull String str, @NotNull String str2) {
    }

    @Override // io.sentry.d1
    public void setTag(@NotNull String str, @NotNull String str2) {
    }
}
