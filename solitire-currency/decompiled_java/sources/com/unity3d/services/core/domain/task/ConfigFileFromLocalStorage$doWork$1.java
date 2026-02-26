package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: ConfigFileFromLocalStorage.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage", f = "ConfigFileFromLocalStorage.kt", l = {27}, m = "doWork-gIAlu-s")
final class ConfigFileFromLocalStorage$doWork$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConfigFileFromLocalStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigFileFromLocalStorage$doWork$1(ConfigFileFromLocalStorage configFileFromLocalStorage, z8.d<? super ConfigFileFromLocalStorage$doWork$1> dVar) {
        super(dVar);
        this.this$0 = configFileFromLocalStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4002doWorkgIAlus = this.this$0.m4002doWorkgIAlus((ConfigFileFromLocalStorage.Params) null, (z8.d<? super t<? extends Configuration>>) this);
        return objM4002doWorkgIAlus == a9.d.e() ? objM4002doWorkgIAlus : t.a(objM4002doWorkgIAlus);
    }
}
