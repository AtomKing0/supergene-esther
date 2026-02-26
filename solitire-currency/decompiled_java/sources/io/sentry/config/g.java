package io.sentry.config;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PropertiesProvider.java */
/* JADX INFO: loaded from: classes5.dex */
public interface g {
    @NotNull
    Map<String, String> a(@NotNull String str);

    @Nullable
    Long b(@NotNull String str);

    @Nullable
    Double c(@NotNull String str);

    @NotNull
    String d(@NotNull String str, @NotNull String str2);

    @NotNull
    List<String> e(@NotNull String str);

    @Nullable
    Boolean f(@NotNull String str);

    @Nullable
    List<String> g(@NotNull String str);

    @Nullable
    String getProperty(@NotNull String str);
}
