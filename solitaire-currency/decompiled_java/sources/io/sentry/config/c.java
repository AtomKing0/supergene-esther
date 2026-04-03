package io.sentry.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompositePropertiesProvider.java */
/* JADX INFO: loaded from: classes5.dex */
final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<g> f27737a;

    public c(@NotNull List<g> list) {
        this.f27737a = list;
    }

    @Override // io.sentry.config.g
    @NotNull
    public Map<String, String> a(@NotNull String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator<g> it = this.f27737a.iterator();
        while (it.hasNext()) {
            concurrentHashMap.putAll(it.next().a(str));
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
        Iterator<g> it = this.f27737a.iterator();
        while (it.hasNext()) {
            String property = it.next().getProperty(str);
            if (property != null) {
                return property;
            }
        }
        return null;
    }
}
