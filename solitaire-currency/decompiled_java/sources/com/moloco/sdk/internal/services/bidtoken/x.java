package com.moloco.sdk.internal.services.bidtoken;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class x {
    @VisibleForTesting
    public static final boolean a(@NotNull com.moloco.sdk.internal.bidtoken.a aVar, long j10) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        long millis = TimeUnit.SECONDS.toMillis(aVar.a());
        long millis2 = TimeUnit.MINUTES.toMillis(2L);
        boolean z10 = j10 >= millis - millis2;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "ServerBidTokenCache", "[sbt] currentTimeInMillis: " + j10 + ", expirationTimeMillis: " + millis + ", expiredThresholdMillis: " + millis2 + ", expired: " + z10, false, 4, null);
        return z10;
    }

    @VisibleForTesting
    public static final boolean b(@NotNull com.moloco.sdk.internal.bidtoken.a aVar, long j10) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        long millis = TimeUnit.SECONDS.toMillis(aVar.a());
        long millis2 = TimeUnit.MINUTES.toMillis(15L);
        boolean z10 = !a(aVar, j10) && millis - j10 <= millis2;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "ServerBidTokenCache", "[sbt] currentTimeInMillis: " + j10 + ", expiryTimeMillis: " + millis + ", nearExpiryThresholdMillis: " + millis2 + ", expiring: " + z10, false, 4, null);
        return z10;
    }
}
