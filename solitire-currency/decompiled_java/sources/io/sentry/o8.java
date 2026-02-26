package io.sentry;

import io.sentry.util.r;
import java.io.IOException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpanId.java */
/* JADX INFO: loaded from: classes5.dex */
public final class o8 implements h2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o8 f28034b = new o8("00000000-0000-0000-0000-000000000000".replace("-", "").substring(0, 16));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.r<String> f28035a;

    /* JADX INFO: compiled from: SpanId.java */
    public static final class a implements x1<o8> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o8 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            return new o8(l3Var.e0());
        }
    }

    public o8(@NotNull final String str) {
        Objects.requireNonNull(str, "value is required");
        this.f28035a = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.m8
            @Override // io.sentry.util.r.a
            public final Object a() {
                return o8.b(str);
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o8.class != obj.getClass()) {
            return false;
        }
        return this.f28035a.a().equals(((o8) obj).f28035a.a());
    }

    public int hashCode() {
        return this.f28035a.a().hashCode();
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.g(this.f28035a.a());
    }

    public String toString() {
        return this.f28035a.a();
    }

    public o8() {
        this.f28035a = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.n8
            @Override // io.sentry.util.r.a
            public final Object a() {
                return c8.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String b(String str) {
        return str;
    }
}
