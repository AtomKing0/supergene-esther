package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.s;
import v8.y;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f21739c = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final l f21740b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public j(@NotNull l worker) {
        t.i(worker, "worker");
        this.f21740b = worker;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(@NotNull String url) {
        Data dataA;
        t.i(url, "url");
        if (e.c(url) && (dataA = k.a(url)) != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "PersistentHttpRequest", "Enqueuing request to " + url, null, false, 12, null);
            this.f21740b.a(new OneTimeWorkRequest.Builder(UrlGetRequestWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS).setInputData(dataA).build());
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(@NotNull String url, @NotNull byte[] body, @NotNull e8.c contentType) throws Throwable {
        t.i(url, "url");
        t.i(body, "body");
        t.i(contentType, "contentType");
        if (e.c(url)) {
            try {
                s[] sVarArr = {y.a("url", url), y.a("body", body), y.a("contentType", contentType.toString())};
                Data.Builder builder = new Data.Builder();
                for (int i10 = 0; i10 < 3; i10++) {
                    s sVar = sVarArr[i10];
                    builder.put((String) sVar.c(), sVar.d());
                }
                Data dataBuild = builder.build();
                t.h(dataBuild, "dataBuilder.build()");
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "PersistentHttpRequest", "Enqueuing request to " + url, null, false, 12, null);
                this.f21740b.a(new OneTimeWorkRequest.Builder(UrlPostRequestWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS).setInputData(dataBuild).build());
            } catch (Exception e10) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, "PersistentHttpRequest", "Failed to enqueue persistent request for url: " + url, e10, false, 8, null);
            }
        }
    }
}
