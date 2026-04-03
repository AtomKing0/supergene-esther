package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import androidx.annotation.VisibleForTesting;
import androidx.work.Data;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;
import v8.y;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    @VisibleForTesting(otherwise = 2)
    @Nullable
    public static final Data a(@NotNull String str) throws Throwable {
        t.i(str, "<this>");
        try {
            s[] sVarArr = {y.a("url", str)};
            Data.Builder builder = new Data.Builder();
            s sVar = sVarArr[0];
            builder.put((String) sVar.c(), sVar.d());
            Data dataBuild = builder.build();
            t.h(dataBuild, "dataBuilder.build()");
            return dataBuild;
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "PersistentHttpRequest", e10.getMessage() + ". Url: " + str, null, false, 12, null);
            return null;
        }
    }
}
