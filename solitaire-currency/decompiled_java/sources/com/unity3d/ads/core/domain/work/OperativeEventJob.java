package com.unity3d.ads.core.domain.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.services.core.di.ServiceProvider;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.p;
import z8.d;

/* JADX INFO: compiled from: OperativeEventJob.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OperativeEventJob extends UniversalRequestJob {

    @NotNull
    private final l getOperativeRequestPolicy$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperativeEventJob(@NotNull Context context, @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        t.i(context, "context");
        t.i(workerParams, "workerParams");
        this.getOperativeRequestPolicy$delegate = n.b(p.f35203c, new OperativeEventJob$special$$inlined$inject$default$1(this, ServiceProvider.NAMED_OPERATIVE_REQ));
    }

    private final GetRequestPolicy getGetOperativeRequestPolicy() {
        return (GetRequestPolicy) this.getOperativeRequestPolicy$delegate.getValue();
    }

    @Override // com.unity3d.ads.core.domain.work.UniversalRequestJob, androidx.work.CoroutineWorker
    @Nullable
    public Object doWork(@NotNull d<? super ListenableWorker.Result> dVar) {
        setRequestPolicy(getGetOperativeRequestPolicy().invoke());
        return super.doWork(dVar);
    }
}
