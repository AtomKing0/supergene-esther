package a8;

import e8.k;
import e8.u;
import e8.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final v f361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final j8.b f362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final k f363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final u f364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Object f365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final z8.g f366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final j8.b f367g;

    public g(@NotNull v statusCode, @NotNull j8.b requestTime, @NotNull k headers, @NotNull u version, @NotNull Object body, @NotNull z8.g callContext) {
        t.i(statusCode, "statusCode");
        t.i(requestTime, "requestTime");
        t.i(headers, "headers");
        t.i(version, "version");
        t.i(body, "body");
        t.i(callContext, "callContext");
        this.f361a = statusCode;
        this.f362b = requestTime;
        this.f363c = headers;
        this.f364d = version;
        this.f365e = body;
        this.f366f = callContext;
        this.f367g = j8.a.b(null, 1, null);
    }

    @NotNull
    public final Object a() {
        return this.f365e;
    }

    @NotNull
    public final z8.g b() {
        return this.f366f;
    }

    @NotNull
    public final k c() {
        return this.f363c;
    }

    @NotNull
    public final j8.b d() {
        return this.f362b;
    }

    @NotNull
    public final j8.b e() {
        return this.f367g;
    }

    @NotNull
    public final v f() {
        return this.f361a;
    }

    @NotNull
    public final u g() {
        return this.f364d;
    }

    @NotNull
    public String toString() {
        return "HttpResponseData=(statusCode=" + this.f361a + ')';
    }
}
