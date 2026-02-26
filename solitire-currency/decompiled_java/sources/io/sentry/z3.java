package io.sentry;

import androidx.media3.extractor.text.ttml.TtmlNode;
import io.sentry.protocol.SentryId;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PropagationContext.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private SentryId f28524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private o8 f28525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private o8 f28526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Boolean f28527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final d f28528e;

    public z3() {
        this(new SentryId(), new o8(), null, null, null);
    }

    @NotNull
    public static z3 a(@NotNull String str, @NotNull String str2, @Nullable Double d10, @Nullable Double d11) {
        return new z3(new SentryId(str), new o8(), new o8(str2), io.sentry.util.k0.h(null, null, d10, d11), null);
    }

    @NotNull
    public static z3 b(@NotNull w0 w0Var, @Nullable String str, @Nullable List<String> list) {
        if (str == null) {
            return new z3();
        }
        try {
            return c(new u7(str), d.g(list, w0Var), null);
        } catch (io.sentry.exception.b e10) {
            w0Var.a(SentryLevel.DEBUG, e10, "Failed to parse Sentry trace header: %s", e10.getMessage());
            return new z3();
        }
    }

    @NotNull
    public static z3 c(@NotNull u7 u7Var, @Nullable d dVar, @Nullable o8 o8Var) {
        if (o8Var == null) {
            o8Var = new o8();
        }
        return new z3(u7Var.b(), o8Var, u7Var.a(), dVar, u7Var.c());
    }

    @NotNull
    public d d() {
        return this.f28528e;
    }

    @Nullable
    public o8 e() {
        return this.f28526c;
    }

    @NotNull
    public Double f() {
        Double dN = this.f28528e.n();
        return Double.valueOf(dN == null ? 0.0d : dN.doubleValue());
    }

    @NotNull
    public o8 g() {
        return this.f28525b;
    }

    @NotNull
    public SentryId h() {
        return this.f28524a;
    }

    @Nullable
    public Boolean i() {
        return this.f28527d;
    }

    @NotNull
    public j8 j() {
        j8 j8Var = new j8(this.f28524a, this.f28525b, "default", null, null);
        j8Var.r(TtmlNode.TEXT_EMPHASIS_AUTO);
        return j8Var;
    }

    @Nullable
    public v8 k() {
        return this.f28528e.R();
    }

    public z3(@NotNull z3 z3Var) {
        this(z3Var.h(), z3Var.g(), z3Var.e(), z3Var.d(), z3Var.i());
    }

    public z3(@NotNull SentryId sentryId, @NotNull o8 o8Var, @Nullable o8 o8Var2, @Nullable d dVar, @Nullable Boolean bool) {
        this.f28524a = sentryId;
        this.f28525b = o8Var;
        this.f28526c = o8Var2;
        this.f28528e = io.sentry.util.k0.h(dVar, bool, null, null);
        this.f28527d = bool;
    }
}
