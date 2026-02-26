package io.sentry.config;

import io.sentry.SentryLevel;
import io.sentry.w0;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClasspathPropertiesLoader.java */
/* JADX INFO: loaded from: classes5.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ClassLoader f27735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final w0 f27736c;

    public b(@NotNull String str, @Nullable ClassLoader classLoader, @NotNull w0 w0Var) {
        this.f27734a = str;
        this.f27735b = io.sentry.util.b.a(classLoader);
        this.f27736c = w0Var;
    }

    @Nullable
    public Properties a() {
        try {
            InputStream resourceAsStream = this.f27735b.getResourceAsStream(this.f27734a);
            if (resourceAsStream == null) {
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return null;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    resourceAsStream.close();
                    return properties;
                } finally {
                }
            } finally {
            }
        } catch (IOException e10) {
            this.f27736c.a(SentryLevel.ERROR, e10, "Failed to load Sentry configuration from classpath resource: %s", this.f27734a);
            return null;
        }
    }

    public b(@NotNull w0 w0Var) {
        this("sentry.properties", b.class.getClassLoader(), w0Var);
    }
}
