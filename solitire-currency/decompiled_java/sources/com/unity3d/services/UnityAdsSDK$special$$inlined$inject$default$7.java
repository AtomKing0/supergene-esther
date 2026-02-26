package com.unity3d.services;

import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.services.core.di.IServiceComponent;
import h9.a;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IServiceComponent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnityAdsSDK$special$$inlined$inject$default$7 extends v implements a<GetAdObject> {
    final /* synthetic */ String $named;
    final /* synthetic */ IServiceComponent $this_inject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnityAdsSDK$special$$inlined$inject$default$7(IServiceComponent iServiceComponent, String str) {
        super(0);
        this.$this_inject = iServiceComponent;
        this.$named = str;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetAdObject, java.lang.Object] */
    @Override // h9.a
    @NotNull
    public final GetAdObject invoke() {
        IServiceComponent iServiceComponent = this.$this_inject;
        return iServiceComponent.getServiceProvider().getRegistry().getService(this.$named, o0.b(GetAdObject.class));
    }
}
