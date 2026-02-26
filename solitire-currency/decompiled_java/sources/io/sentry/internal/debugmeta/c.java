package io.sentry.internal.debugmeta;

import io.sentry.SentryLevel;
import io.sentry.util.d;
import io.sentry.w0;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResourcesDebugMetaLoader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final w0 f27916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ClassLoader f27917b;

    public c(@NotNull w0 w0Var) {
        this(w0Var, c.class.getClassLoader());
    }

    @Override // io.sentry.internal.debugmeta.a
    @Nullable
    public List<Properties> a() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.f27917b.getResources(d.f28341a);
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                try {
                    InputStream inputStreamOpenStream = urlNextElement.openStream();
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStreamOpenStream);
                        arrayList.add(properties);
                        this.f27916a.c(SentryLevel.INFO, "Debug Meta Data Properties loaded from %s", urlNextElement);
                        if (inputStreamOpenStream != null) {
                            inputStreamOpenStream.close();
                        }
                    } catch (Throwable th) {
                        if (inputStreamOpenStream != null) {
                            try {
                                inputStreamOpenStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (RuntimeException e10) {
                    this.f27916a.a(SentryLevel.ERROR, e10, "%s file is malformed.", urlNextElement);
                }
            }
        } catch (IOException e11) {
            this.f27916a.a(SentryLevel.ERROR, e11, "Failed to load %s", d.f28341a);
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        this.f27916a.c(SentryLevel.INFO, "No %s file was found.", d.f28341a);
        return null;
    }

    c(@NotNull w0 w0Var, @Nullable ClassLoader classLoader) {
        this.f27916a = w0Var;
        this.f27917b = io.sentry.util.b.a(classLoader);
    }
}
