package io.sentry.config;

import io.sentry.SentryLevel;
import io.sentry.w0;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FilesystemPropertiesLoader.java */
/* JADX INFO: loaded from: classes5.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f27739b;

    public e(@NotNull String str, @NotNull w0 w0Var) {
        this.f27738a = str;
        this.f27739b = w0Var;
    }

    @Nullable
    public Properties a() {
        try {
            File file = new File(this.f27738a);
            if (!file.isFile() || !file.canRead()) {
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                return properties;
            } finally {
            }
        } catch (IOException e10) {
            this.f27739b.a(SentryLevel.ERROR, e10, "Failed to load Sentry configuration from file: %s", this.f27738a);
            return null;
        }
    }
}
