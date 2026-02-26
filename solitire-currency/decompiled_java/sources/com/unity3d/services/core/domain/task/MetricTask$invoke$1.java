package com.unity3d.services.core.domain.task;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: MetricTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.MetricTask", f = "MetricTask.kt", l = {24}, m = "invoke-gIAlu-s$suspendImpl")
final class MetricTask$invoke$1 extends d {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetricTask<P, R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MetricTask$invoke$1(MetricTask<? super P, R> metricTask, z8.d<? super MetricTask$invoke$1> dVar) {
        super(dVar);
        this.this$0 = metricTask;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4017invokegIAlus$suspendImpl = MetricTask.m4017invokegIAlus$suspendImpl(this.this$0, null, this);
        return objM4017invokegIAlus$suspendImpl == a9.d.e() ? objM4017invokegIAlus$suspendImpl : t.a(objM4017invokegIAlus$suspendImpl);
    }
}
