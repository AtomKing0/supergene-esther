package com.unity3d.services.core.di;

import android.content.Context;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.HttpClient;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: UnityAdsModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.di.UnityAdsModule$provideHttpClient$1$client$1", f = "UnityAdsModule.kt", l = {271}, m = "invokeSuspend")
final class UnityAdsModule$provideHttpClient$1$client$1 extends l implements p<o0, d<? super HttpClient>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ISDKDispatchers $dispatchers;
    int label;
    final /* synthetic */ UnityAdsModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UnityAdsModule$provideHttpClient$1$client$1(UnityAdsModule unityAdsModule, Context context, ISDKDispatchers iSDKDispatchers, d<? super UnityAdsModule$provideHttpClient$1$client$1> dVar) {
        super(2, dVar);
        this.this$0 = unityAdsModule;
        this.$context = context;
        this.$dispatchers = iSDKDispatchers;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new UnityAdsModule$provideHttpClient$1$client$1(this.this$0, this.$context, this.$dispatchers, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            UnityAdsModule unityAdsModule = this.this$0;
            Context context = this.$context;
            ISDKDispatchers iSDKDispatchers = this.$dispatchers;
            this.label = 1;
            obj = unityAdsModule.buildNetworkClient(context, iSDKDispatchers, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return obj;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super HttpClient> dVar) {
        return ((UnityAdsModule$provideHttpClient$1$client$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
