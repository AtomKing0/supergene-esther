package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.BaseParams;
import com.unity3d.services.core.domain.task.BaseTask;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: BaseTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.BaseTask$DefaultImpls", f = "BaseTask.kt", l = {11}, m = "invoke-gIAlu-s")
final class BaseTask$invoke$1<P extends BaseParams, R> extends d {
    int label;
    /* synthetic */ Object result;

    BaseTask$invoke$1(z8.d<? super BaseTask$invoke$1> dVar) {
        super(dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4001invokegIAlus = BaseTask.DefaultImpls.m4001invokegIAlus(null, null, this);
        return objM4001invokegIAlus == a9.d.e() ? objM4001invokegIAlus : t.a(objM4001invokegIAlus);
    }
}
