package com.unity3d.ads.core.domain.work;

import androidx.work.Data;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UniversalRequestWorkerData.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalRequestWorkerData {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String KEY_UNIVERSAL_REQUEST_ID = "universalRequestId";

    @NotNull
    private final String universalRequestId;

    /* JADX INFO: compiled from: UniversalRequestWorkerData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public UniversalRequestWorkerData(@NotNull String universalRequestId) {
        t.i(universalRequestId, "universalRequestId");
        this.universalRequestId = universalRequestId;
    }

    @NotNull
    public final Data invoke() throws Throwable {
        Data dataBuild = new Data.Builder().putString(KEY_UNIVERSAL_REQUEST_ID, this.universalRequestId).build();
        t.h(dataBuild, "Builder()\n            .p…tId)\n            .build()");
        return dataBuild;
    }
}
