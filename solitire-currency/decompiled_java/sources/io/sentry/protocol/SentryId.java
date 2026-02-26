package io.sentry.protocol;

import io.sentry.c8;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.util.d0;
import io.sentry.util.m0;
import io.sentry.util.r;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryId implements h2 {
    public static final SentryId EMPTY_ID = new SentryId("00000000-0000-0000-0000-000000000000".replace("-", ""));

    @NotNull
    private final r<String> lazyStringValue;

    public static final class Deserializer implements x1<SentryId> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SentryId deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            return new SentryId(l3Var.e0());
        }
    }

    public SentryId() {
        this((UUID) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$new$0(UUID uuid) {
        return lambda$new$1(m0.c(uuid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    /* JADX INFO: renamed from: normalize, reason: merged with bridge method [inline-methods] */
    public String lambda$new$1(@NotNull String str) {
        return d0.g(str).replace("-", "");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SentryId.class != obj.getClass()) {
            return false;
        }
        return this.lazyStringValue.a().equals(((SentryId) obj).lazyStringValue.a());
    }

    public int hashCode() {
        return this.lazyStringValue.a().hashCode();
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.g(toString());
    }

    public String toString() {
        return this.lazyStringValue.a();
    }

    public SentryId(@Nullable final UUID uuid) {
        if (uuid != null) {
            this.lazyStringValue = new r<>(new r.a() { // from class: io.sentry.protocol.c
                @Override // io.sentry.util.r.a
                public final Object a() {
                    return this.f28079a.lambda$new$0(uuid);
                }
            });
        } else {
            this.lazyStringValue = new r<>(new r.a() { // from class: io.sentry.protocol.d
                @Override // io.sentry.util.r.a
                public final Object a() {
                    return c8.a();
                }
            });
        }
    }

    public SentryId(@NotNull String str) {
        final String strG = d0.g(str);
        if (strG.length() != 32 && strG.length() != 36) {
            throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: " + str);
        }
        if (strG.length() == 36) {
            this.lazyStringValue = new r<>(new r.a() { // from class: io.sentry.protocol.a
                @Override // io.sentry.util.r.a
                public final Object a() {
                    return this.f28076a.lambda$new$1(strG);
                }
            });
        } else {
            this.lazyStringValue = new r<>(new r.a() { // from class: io.sentry.protocol.b
                @Override // io.sentry.util.r.a
                public final Object a() {
                    return SentryId.lambda$new$2(strG);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$2(String str) {
        return str;
    }
}
