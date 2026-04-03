package io.sentry.cache;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.x1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheUtils.java */
/* JADX INFO: loaded from: classes5.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f27656a = Charset.forName("UTF-8");

    static void a(@NotNull SentryOptions sentryOptions, @NotNull String str, @NotNull String str2) {
        File fileB = b(sentryOptions, str);
        if (fileB == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, cannot delete from scope cache", new Object[0]);
            return;
        }
        File file = new File(fileB, str2);
        sentryOptions.getLogger().c(SentryLevel.DEBUG, "Deleting %s from scope cache", str2);
        if (file.delete()) {
            return;
        }
        sentryOptions.getLogger().c(SentryLevel.INFO, "Failed to delete: %s", file.getAbsolutePath());
    }

    @Nullable
    static File b(@NotNull SentryOptions sentryOptions, @NotNull String str) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        File file = new File(cacheDirPath, str);
        file.mkdirs();
        return file;
    }

    @Nullable
    static <T, R> T c(@NotNull SentryOptions sentryOptions, @NotNull String str, @NotNull String str2, @NotNull Class<T> cls, @Nullable x1<R> x1Var) {
        File fileB = b(sentryOptions, str);
        if (fileB == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, cannot read from scope cache", new Object[0]);
            return null;
        }
        File file = new File(fileB, str2);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), f27656a));
                try {
                    if (x1Var == null) {
                        T t10 = (T) sentryOptions.getSerializer().c(bufferedReader, cls);
                        bufferedReader.close();
                        return t10;
                    }
                    T t11 = (T) sentryOptions.getSerializer().e(bufferedReader, cls, x1Var);
                    bufferedReader.close();
                    return t11;
                } finally {
                }
            } catch (Throwable th) {
                sentryOptions.getLogger().a(SentryLevel.ERROR, th, "Error reading entity from scope cache: %s", str2);
            }
        } else {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "No entry stored for %s", str2);
        }
        return null;
    }

    static <T> void d(@NotNull SentryOptions sentryOptions, @NotNull T t10, @NotNull String str, @NotNull String str2) {
        File fileB = b(sentryOptions, str);
        if (fileB == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileB, str2));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, f27656a));
                try {
                    sentryOptions.getSerializer().a(t10, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            sentryOptions.getLogger().a(SentryLevel.ERROR, th, "Error persisting entity: %s", str2);
        }
    }
}
