package io.sentry.internal.modules;

import io.sentry.SentryLevel;
import io.sentry.w0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResourcesModulesLoader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class f extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final ClassLoader f27936e;

    public f(@NotNull w0 w0Var) {
        this(w0Var, f.class.getClassLoader());
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream resourceAsStream = this.f27936e.getResourceAsStream("sentry-external-modules.txt");
            try {
                if (resourceAsStream != null) {
                    Map<String, String> mapC = c(resourceAsStream);
                    resourceAsStream.close();
                    return mapC;
                }
                this.f27932a.c(SentryLevel.INFO, "%s file was not found.", "sentry-external-modules.txt");
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return treeMap;
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            this.f27932a.b(SentryLevel.INFO, "Access to resources failed.", e10);
            return treeMap;
        } catch (SecurityException e11) {
            this.f27932a.b(SentryLevel.INFO, "Access to resources denied.", e11);
            return treeMap;
        }
    }

    f(@NotNull w0 w0Var, @Nullable ClassLoader classLoader) {
        super(w0Var);
        this.f27936e = io.sentry.util.b.a(classLoader);
    }
}
