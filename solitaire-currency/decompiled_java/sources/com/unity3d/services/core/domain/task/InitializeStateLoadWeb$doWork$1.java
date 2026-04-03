package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: InitializeStateLoadWeb.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb", f = "InitializeStateLoadWeb.kt", l = {39}, m = "doWork-gIAlu-s")
final class InitializeStateLoadWeb$doWork$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$1(InitializeStateLoadWeb initializeStateLoadWeb, z8.d<? super InitializeStateLoadWeb$doWork$1> dVar) {
        super(dVar);
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4013doWorkgIAlus = this.this$0.m4013doWorkgIAlus((InitializeStateLoadWeb.Params) null, (z8.d<? super t<InitializeStateLoadWeb.LoadWebResult>>) this);
        return objM4013doWorkgIAlus == a9.d.e() ? objM4013doWorkgIAlus : t.a(objM4013doWorkgIAlus);
    }
}
