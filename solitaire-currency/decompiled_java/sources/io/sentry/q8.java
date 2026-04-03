package io.sentry;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.c3;
import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpanStatus.java */
/* JADX INFO: loaded from: classes5.dex */
public enum q8 implements h2 {
    OK(0, 399),
    CANCELLED(499),
    INTERNAL_ERROR(500),
    UNKNOWN(500),
    UNKNOWN_ERROR(500),
    INVALID_ARGUMENT(400),
    DEADLINE_EXCEEDED(TypedValues.PositionType.TYPE_PERCENT_HEIGHT),
    NOT_FOUND(c3.a.b.f11495d),
    ALREADY_EXISTS(c3.a.b.f11500i),
    PERMISSION_DENIED(403),
    RESOURCE_EXHAUSTED(429),
    FAILED_PRECONDITION(400),
    ABORTED(c3.a.b.f11500i),
    OUT_OF_RANGE(400),
    UNIMPLEMENTED(501),
    UNAVAILABLE(TypedValues.PositionType.TYPE_PERCENT_WIDTH),
    DATA_LOSS(500),
    UNAUTHENTICATED(401);

    private final int maxHttpStatusCode;
    private final int minHttpStatusCode;

    /* JADX INFO: compiled from: SpanStatus.java */
    public static final class a implements x1<q8> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q8 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            return q8.valueOf(l3Var.e0().toUpperCase(Locale.ROOT));
        }
    }

    q8(int i10) {
        this.minHttpStatusCode = i10;
        this.maxHttpStatusCode = i10;
    }

    @Nullable
    public static q8 fromApiNameSafely(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return valueOf(str.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    public static q8 fromHttpStatusCode(int i10) {
        for (q8 q8Var : values()) {
            if (q8Var.matches(i10)) {
                return q8Var;
            }
        }
        return null;
    }

    private boolean matches(int i10) {
        return i10 >= this.minHttpStatusCode && i10 <= this.maxHttpStatusCode;
    }

    @NotNull
    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.g(apiName());
    }

    @NotNull
    public static q8 fromHttpStatusCode(@Nullable Integer num, @NotNull q8 q8Var) {
        q8 q8VarFromHttpStatusCode = num != null ? fromHttpStatusCode(num.intValue()) : q8Var;
        return q8VarFromHttpStatusCode != null ? q8VarFromHttpStatusCode : q8Var;
    }

    q8(int i10, int i11) {
        this.minHttpStatusCode = i10;
        this.maxHttpStatusCode = i11;
    }
}
