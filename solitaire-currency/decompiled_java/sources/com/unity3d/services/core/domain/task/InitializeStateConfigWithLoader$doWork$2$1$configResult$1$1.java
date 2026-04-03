package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.IConfigurationLoaderListener;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: InitializeStateConfigWithLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1", f = "InitializeStateConfigWithLoader.kt", l = {69}, m = "invokeSuspend")
final class InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 extends l implements p<Integer, d<? super k0>, Object> {
    final /* synthetic */ n0<Configuration> $config;
    final /* synthetic */ n0<IConfigurationLoader> $configurationLoader;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX INFO: renamed from: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: InitializeStateConfigWithLoader.kt */
    @f(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1", f = "InitializeStateConfigWithLoader.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ n0<Configuration> $config;
        final /* synthetic */ n0<IConfigurationLoader> $configurationLoader;
        int label;
        final /* synthetic */ InitializeStateConfigWithLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(n0<IConfigurationLoader> n0Var, n0<Configuration> n0Var2, InitializeStateConfigWithLoader initializeStateConfigWithLoader, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$configurationLoader = n0Var;
            this.$config = n0Var2;
            this.this$0 = initializeStateConfigWithLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$configurationLoader, this.$config, this.this$0, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Exception {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            IConfigurationLoader iConfigurationLoader = this.$configurationLoader.f29834a;
            final n0<Configuration> n0Var = this.$config;
            final InitializeStateConfigWithLoader initializeStateConfigWithLoader = this.this$0;
            iConfigurationLoader.loadConfiguration(new IConfigurationLoaderListener() { // from class: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.doWork.2.1.configResult.1.1.1.1
                @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                public void onError(@NotNull String errorMsg) throws AbortRetryException {
                    t.i(errorMsg, "errorMsg");
                    SDKMetricsSender sDKMetricsSender = initializeStateConfigWithLoader.sdkMetricsSender;
                    Metric metricNewEmergencySwitchOff = TSIMetric.newEmergencySwitchOff();
                    t.h(metricNewEmergencySwitchOff, "newEmergencySwitchOff()");
                    sDKMetricsSender.sendMetric(metricNewEmergencySwitchOff);
                    throw new AbortRetryException(errorMsg);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                public void onSuccess(@NotNull Configuration configuration) {
                    t.i(configuration, "configuration");
                    n0Var.f29834a = configuration;
                    configuration.saveToDisk();
                    initializeStateConfigWithLoader.tokenStorage.setInitToken(n0Var.f29834a.getUnifiedAuctionToken());
                }
            });
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(InitializeStateConfigWithLoader initializeStateConfigWithLoader, n0<IConfigurationLoader> n0Var, n0<Configuration> n0Var2, d<? super InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1> dVar) {
        super(2, dVar);
        this.this$0 = initializeStateConfigWithLoader;
        this.$configurationLoader = n0Var;
        this.$config = n0Var2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 initializeStateConfigWithLoader$doWork$2$1$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(this.this$0, this.$configurationLoader, this.$config, dVar);
        initializeStateConfigWithLoader$doWork$2$1$configResult$1$1.I$0 = ((Number) obj).intValue();
        return initializeStateConfigWithLoader$doWork$2$1$configResult$1$1;
    }

    @Nullable
    public final Object invoke(int i10, @Nullable d<? super k0> dVar) {
        return ((InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1) create(Integer.valueOf(i10), dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            if (this.I$0 > 0) {
                InitializeEventsMetricSender.getInstance().onRetryConfig();
            }
            kotlinx.coroutines.k0 io2 = this.this$0.dispatchers.getIo();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$configurationLoader, this.$config, this.this$0, null);
            this.label = 1;
            if (i.g(io2, anonymousClass1, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(Integer num, d<? super k0> dVar) {
        return invoke(num.intValue(), dVar);
    }
}
