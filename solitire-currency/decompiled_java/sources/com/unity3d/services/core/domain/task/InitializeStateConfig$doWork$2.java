package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.NetworkIOException;
import h9.p;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: InitializeStateConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2", f = "InitializeStateConfig.kt", l = {32}, m = "invokeSuspend")
final class InitializeStateConfig$doWork$2 extends l implements p<o0, d<? super t<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateConfig.Params $params;
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateConfig this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfig$doWork$2(InitializeStateConfig.Params params, InitializeStateConfig initializeStateConfig, d<? super InitializeStateConfig$doWork$2> dVar) {
        super(2, dVar);
        this.$params = params;
        this.this$0 = initializeStateConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new InitializeStateConfig$doWork$2(this.$params, this.this$0, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objB;
        Configuration configuration;
        Object objMo4000invokegIAlus;
        Object objE = a9.d.e();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                u.b(obj);
                InitializeStateConfig.Params params = this.$params;
                InitializeStateConfig initializeStateConfig = this.this$0;
                t.a aVar = t.f35208b;
                DeviceLog.info("Unity Ads init: load configuration from " + SdkProperties.getConfigUrl());
                Configuration configuration2 = new Configuration(SdkProperties.getConfigUrl(), params.getConfig().getExperimentsReader());
                try {
                    InitializeStateConfigWithLoader initializeStateConfigWithLoader = initializeStateConfig.initializeStateConfigWithLoader;
                    InitializeStateConfigWithLoader.Params params2 = new InitializeStateConfigWithLoader.Params(configuration2);
                    this.L$0 = configuration2;
                    this.label = 1;
                    objMo4000invokegIAlus = initializeStateConfigWithLoader.mo4000invokegIAlus((BaseParams) params2, (d<? super t<? extends Configuration>>) this);
                    if (objMo4000invokegIAlus == objE) {
                        return objE;
                    }
                    configuration = configuration2;
                } catch (NetworkIOException e10) {
                    e = e10;
                    configuration = configuration2;
                    throw new InitializationException(ErrorState.NetworkConfigRequest, e, configuration);
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                configuration = (Configuration) this.L$0;
                try {
                    u.b(obj);
                    objMo4000invokegIAlus = ((t) obj).j();
                } catch (NetworkIOException e11) {
                    e = e11;
                    throw new InitializationException(ErrorState.NetworkConfigRequest, e, configuration);
                }
            }
            u.b(objMo4000invokegIAlus);
            objB = t.b((Configuration) objMo4000invokegIAlus);
        } catch (CancellationException e12) {
            throw e12;
        } catch (Throwable th) {
            t.a aVar2 = t.f35208b;
            objB = t.b(u.a(th));
        }
        if (t.h(objB)) {
            objB = t.b(objB);
        } else {
            Throwable thE = t.e(objB);
            if (thE != null) {
                objB = t.b(u.a(thE));
            }
        }
        return t.a(objB);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super t<? extends Configuration>> dVar) {
        return ((InitializeStateConfig$doWork$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
