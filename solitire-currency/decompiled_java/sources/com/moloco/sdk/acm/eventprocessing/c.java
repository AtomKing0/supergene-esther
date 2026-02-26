package com.moloco.sdk.acm.eventprocessing;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.ironsource.ad;
import java.util.concurrent.TimeUnit;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.y;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.h f17371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Context f17372b;

    public c(@NotNull com.moloco.sdk.acm.h config, @NotNull Context context) {
        t.i(config, "config");
        t.i(context, "context");
        this.f17371a = config;
        this.f17372b = context;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.b
    public void a() throws Throwable {
        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        Data dataA = d.a(r0.j(y.a("url", this.f17371a.d()), y.a("AppKey", this.f17371a.c().get("AppKey")), y.a("AppBundle", this.f17371a.c().get("AppBundle")), y.a("AppVersion", this.f17371a.c().get("AppVersion")), y.a("OS", this.f17371a.c().get("OS")), y.a(ad.f11278z, this.f17371a.c().get(ad.f11278z)), y.a("SdkVersion", this.f17371a.c().get("SdkVersion")), y.a("Mediator", this.f17371a.c().get("Mediator"))));
        if (dataA == null) {
            return;
        }
        WorkManager.getInstance(this.f17372b).enqueue(new OneTimeWorkRequest.Builder(DBRequestWorker.class).setConstraints(constraintsBuild).setInputData(dataA).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MILLISECONDS).build());
    }
}
