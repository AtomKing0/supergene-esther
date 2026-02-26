package io.sentry.config;

import io.sentry.util.d0;
import io.sentry.util.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractPropertiesProvider.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Properties f27733b;

    protected a(@NotNull String str, @NotNull Properties properties) {
        this.f27732a = (String) w.c(str, "prefix is required");
        this.f27733b = (Properties) w.c(properties, "properties are required");
    }

    @Override // io.sentry.config.g
    @NotNull
    public Map<String, String> a(@NotNull String str) {
        String str2 = this.f27732a + str + ".";
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f27733b.entrySet()) {
            if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                String str3 = (String) entry.getKey();
                if (str3.startsWith(str2)) {
                    map.put(str3.substring(str2.length()), d0.h((String) entry.getValue(), "\""));
                }
            }
        }
        return map;
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
        return d0.h(this.f27733b.getProperty(this.f27732a + str), "\"");
    }

    protected a(@NotNull Properties properties) {
        this("", properties);
    }
}
