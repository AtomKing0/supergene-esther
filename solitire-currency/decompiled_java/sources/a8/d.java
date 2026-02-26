package a8;

import e8.k;
import e8.p0;
import e8.t;
import java.util.Map;
import java.util.Set;
import kotlin.collections.z0;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p0 f347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final t f348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final k f349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final f8.b f350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final b2 f351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final g8.b f352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Set<v7.e<?>> f353g;

    public d(@NotNull p0 url, @NotNull t method, @NotNull k headers, @NotNull f8.b body, @NotNull b2 executionContext, @NotNull g8.b attributes) {
        Set<v7.e<?>> setKeySet;
        kotlin.jvm.internal.t.i(url, "url");
        kotlin.jvm.internal.t.i(method, "method");
        kotlin.jvm.internal.t.i(headers, "headers");
        kotlin.jvm.internal.t.i(body, "body");
        kotlin.jvm.internal.t.i(executionContext, "executionContext");
        kotlin.jvm.internal.t.i(attributes, "attributes");
        this.f347a = url;
        this.f348b = method;
        this.f349c = headers;
        this.f350d = body;
        this.f351e = executionContext;
        this.f352f = attributes;
        Map map = (Map) attributes.d(v7.f.a());
        this.f353g = (map == null || (setKeySet = map.keySet()) == null) ? z0.e() : setKeySet;
    }

    @NotNull
    public final g8.b a() {
        return this.f352f;
    }

    @NotNull
    public final f8.b b() {
        return this.f350d;
    }

    @Nullable
    public final <T> T c(@NotNull v7.e<T> key) {
        kotlin.jvm.internal.t.i(key, "key");
        Map map = (Map) this.f352f.d(v7.f.a());
        if (map != null) {
            return (T) map.get(key);
        }
        return null;
    }

    @NotNull
    public final b2 d() {
        return this.f351e;
    }

    @NotNull
    public final k e() {
        return this.f349c;
    }

    @NotNull
    public final t f() {
        return this.f348b;
    }

    @NotNull
    public final Set<v7.e<?>> g() {
        return this.f353g;
    }

    @NotNull
    public final p0 h() {
        return this.f347a;
    }

    @NotNull
    public String toString() {
        return "HttpRequestData(url=" + this.f347a + ", method=" + this.f348b + ')';
    }
}
