package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.Collection;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IScopeObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public interface d1 {
    void a(@NotNull Map<String, String> map);

    void c(@NotNull Breadcrumb breadcrumb);

    void d(@NotNull Collection<Breadcrumb> collection);

    void e(@NotNull Collection<String> collection);

    void f(@Nullable j8 j8Var, @NotNull c1 c1Var);

    void g(@NotNull Contexts contexts);

    void h(@Nullable Request request);

    void i(@NotNull Map<String, Object> map);

    void j(@NotNull SentryId sentryId);

    void removeExtra(@NotNull String str);

    void removeTag(@NotNull String str);

    void setExtra(@NotNull String str, @NotNull String str2);

    void setLevel(@Nullable SentryLevel sentryLevel);

    void setTag(@NotNull String str, @NotNull String str2);

    void setTransaction(@Nullable String str);

    void setUser(@Nullable User user);
}
