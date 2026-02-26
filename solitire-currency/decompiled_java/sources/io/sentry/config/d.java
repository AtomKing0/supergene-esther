package io.sentry.config;

import io.sentry.util.d0;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EnvironmentVariablePropertiesProvider.java */
/* JADX INFO: loaded from: classes5.dex */
final class d implements g {
    d() {
    }

    @NotNull
    private String h(@NotNull String str) {
        return "SENTRY_" + str.replace(".", "_").replace("-", "_").toUpperCase(Locale.ROOT);
    }

    @Override // io.sentry.config.g
    @NotNull
    public Map<String, String> a(@NotNull String str) {
        String strH;
        String str2 = h(str) + "_";
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(str2) && (strH = d0.h(entry.getValue(), "\"")) != null) {
                concurrentHashMap.put(key.substring(str2.length()).toLowerCase(Locale.ROOT), strH);
            }
        }
        return concurrentHashMap;
    }

    @Override // io.sentry.config.g
    public /* synthetic */ Long b(String str) {
        return f.e(this, str);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ Double c(String str) {
        return f.b(this, str);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ String d(String str, String str2) {
        return f.f(this, str, str2);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ List e(String str) {
        return f.c(this, str);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ Boolean f(String str) {
        return f.a(this, str);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ List g(String str) {
        return f.d(this, str);
    }

    @Override // io.sentry.config.g
    @Nullable
    public String getProperty(@NotNull String str) {
        return d0.h(System.getenv(h(str)), "\"");
    }
}
