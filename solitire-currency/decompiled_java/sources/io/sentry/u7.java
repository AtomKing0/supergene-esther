package io.sentry;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryTraceHeader.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryId f28335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final o8 f28336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Boolean f28337c;

    public u7(@NotNull SentryId sentryId, @NotNull o8 o8Var, @Nullable Boolean bool) {
        this.f28335a = sentryId;
        this.f28336b = o8Var;
        this.f28337c = bool;
    }

    @NotNull
    public o8 a() {
        return this.f28336b;
    }

    @NotNull
    public SentryId b() {
        return this.f28335a;
    }

    @Nullable
    public Boolean c() {
        return this.f28337c;
    }

    public u7(@NotNull String str) throws io.sentry.exception.b {
        String[] strArrSplit = str.split("-", -1);
        if (strArrSplit.length >= 2) {
            if (strArrSplit.length == 3) {
                this.f28337c = Boolean.valueOf("1".equals(strArrSplit[2]));
            } else {
                this.f28337c = null;
            }
            try {
                this.f28335a = new SentryId(strArrSplit[0]);
                this.f28336b = new o8(strArrSplit[1]);
                return;
            } catch (Throwable th) {
                throw new io.sentry.exception.b(str, th);
            }
        }
        throw new io.sentry.exception.b(str);
    }
}
