package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: InitializeStateLoadCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache", f = "InitializeStateLoadCache.kt", l = {32}, m = "doWork-gIAlu-s")
final class InitializeStateLoadCache$doWork$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateLoadCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadCache$doWork$1(InitializeStateLoadCache initializeStateLoadCache, z8.d<? super InitializeStateLoadCache$doWork$1> dVar) {
        super(dVar);
        this.this$0 = initializeStateLoadCache;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4012doWorkgIAlus = this.this$0.m4012doWorkgIAlus((InitializeStateLoadCache.Params) null, (z8.d<? super t<InitializeStateLoadCache.LoadCacheResult>>) this);
        return objM4012doWorkgIAlus == a9.d.e() ? objM4012doWorkgIAlus : t.a(objM4012doWorkgIAlus);
    }
}
