package io.sentry;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestDetails.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final URL f27636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, String> f27637b;

    public c4(@NotNull String str, @NotNull Map<String, String> map) {
        io.sentry.util.w.c(str, "url is required");
        io.sentry.util.w.c(map, "headers is required");
        try {
            this.f27636a = URI.create(str).toURL();
            this.f27637b = map;
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", e10);
        }
    }

    @NotNull
    public Map<String, String> a() {
        return this.f27637b;
    }

    @NotNull
    public URL b() {
        return this.f27636a;
    }
}
