package com.unity3d.services.core.di;

import a9.c;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import com.google.android.gms.net.CronetProviderInstaller;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.model.ByteStringSerializer;
import com.unity3d.ads.core.data.model.UniversalRequestStoreSerializer;
import com.unity3d.ads.core.data.model.WebViewConfigurationStoreSerializer;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryAsyncTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.SDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.network.core.CronetClient;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.LegacyHttpClient;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import f9.m;
import ga.z;
import gatewayprotocol.v1.AdOperationsConfigurationKt;
import gatewayprotocol.v1.DiagnosticEventsConfigurationKt;
import gatewayprotocol.v1.NativeConfigurationKt;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.RequestPolicyKt;
import gatewayprotocol.v1.RequestRetryPolicyKt;
import gatewayprotocol.v1.RequestTimeoutPolicyKt;
import h9.a;
import h9.p;
import java.io.File;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.chromium.net.CronetEngine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q9.e;
import q9.k;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: UnityAdsModule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnityAdsModule {

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$glInfoDataStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: UnityAdsModule.kt */
    static final class AnonymousClass1 extends v implements a<File> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final File invoke() {
            return DataStoreFile.dataStoreFile(this.$context, ServiceProvider.DATA_STORE_GL_INFO);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$provideByteStringDataStore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsModule.kt */
    static final class C32821 extends v implements a<File> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $dataStoreFile;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32821(Context context, String str) {
            super(0);
            this.$context = context;
            this.$dataStoreFile = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final File invoke() {
            return DataStoreFile.dataStoreFile(this.$context, this.$dataStoreFile);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$provideHttpClient$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsModule.kt */
    @f(c = "com.unity3d.services.core.di.UnityAdsModule$provideHttpClient$1", f = "UnityAdsModule.kt", l = {270}, m = "invokeSuspend")
    static final class C32831 extends l implements p<o0, d<? super HttpClient>, Object> {
        final /* synthetic */ AlternativeFlowReader $alternativeFlowReader;
        final /* synthetic */ ConfigFileFromLocalStorage $configFileFromLocalStorage;
        final /* synthetic */ Context $context;
        final /* synthetic */ ISDKDispatchers $dispatchers;
        final /* synthetic */ SendDiagnosticEvent $sendDiagnosticEvent;
        long J$0;
        int label;
        final /* synthetic */ UnityAdsModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32831(AlternativeFlowReader alternativeFlowReader, SendDiagnosticEvent sendDiagnosticEvent, ISDKDispatchers iSDKDispatchers, UnityAdsModule unityAdsModule, Context context, ConfigFileFromLocalStorage configFileFromLocalStorage, d<? super C32831> dVar) {
            super(2, dVar);
            this.$alternativeFlowReader = alternativeFlowReader;
            this.$sendDiagnosticEvent = sendDiagnosticEvent;
            this.$dispatchers = iSDKDispatchers;
            this.this$0 = unityAdsModule;
            this.$context = context;
            this.$configFileFromLocalStorage = configFileFromLocalStorage;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C32831(this.$alternativeFlowReader, this.$sendDiagnosticEvent, this.$dispatchers, this.this$0, this.$context, this.$configFileFromLocalStorage, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IExperiments experiments;
            long j10;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                if (!this.$alternativeFlowReader.invoke()) {
                    Configuration configuration = (Configuration) j.b(null, new UnityAdsModule$provideHttpClient$1$config$1(this.$configFileFromLocalStorage, null), 1, null);
                    return (configuration == null || (experiments = configuration.getExperiments()) == null || !experiments.isOkHttpEnabled()) ? false : true ? new OkHttp3Client(this.$dispatchers, new z()) : new LegacyHttpClient(this.$dispatchers);
                }
                long jA = k.f33196a.a();
                UnityAdsModule$provideHttpClient$1$client$1 unityAdsModule$provideHttpClient$1$client$1 = new UnityAdsModule$provideHttpClient$1$client$1(this.this$0, this.$context, this.$dispatchers, null);
                this.J$0 = jA;
                this.label = 1;
                obj = f3.e(500L, unityAdsModule$provideHttpClient$1$client$1, this);
                if (obj == objE) {
                    return objE;
                }
                j10 = jA;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = this.J$0;
                u.b(obj);
            }
            HttpClient httpClient = (HttpClient) obj;
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.$sendDiagnosticEvent, httpClient == null ? "native_cronet_failure_time" : "native_cronet_success_time", b.b(q9.b.F(k.a.f(j10), e.f33186d)), null, null, null, 28, null);
            return httpClient == null ? new OkHttp3Client(this.$dispatchers, new z()) : httpClient;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super HttpClient> dVar) {
            return ((C32831) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$universalRequestDataStore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsModule.kt */
    static final class C32841 extends v implements a<File> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32841(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final File invoke() {
            return DataStoreFile.dataStoreFile(this.$context, ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.di.UnityAdsModule$webViewConfigurationDataStore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsModule.kt */
    static final class C32851 extends v implements a<File> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32851(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final File invoke() {
            return DataStoreFile.dataStoreFile(this.$context, ServiceProvider.DATA_STORE_WEBVIEW_CONFIG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildCronetCachePath(Context context) {
        File filesDir = context.getFilesDir();
        t.h(filesDir, "context.filesDir");
        File fileS = m.s(filesDir, UnityAdsConstants.DefaultUrls.HTTP_CACHE_DIR_NAME);
        if (!fileS.exists()) {
            fileS.mkdirs();
        }
        String absolutePath = fileS.getAbsolutePath();
        t.h(absolutePath, "cacheDir.absolutePath");
        return absolutePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object buildNetworkClient(final Context context, final ISDKDispatchers iSDKDispatchers, d<? super HttpClient> dVar) throws Throwable {
        final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(c.c(dVar), 1);
        pVar.C();
        CronetProviderInstaller.installProvider(context).addOnCompleteListener(new OnCompleteListener() { // from class: com.unity3d.services.core.di.UnityAdsModule$buildNetworkClient$2$1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(@NotNull Task<Void> it) {
                t.i(it, "it");
                if (!it.isSuccessful()) {
                    o<HttpClient> oVar = pVar;
                    t.a aVar = v8.t.f35208b;
                    oVar.resumeWith(v8.t.b(new OkHttp3Client(iSDKDispatchers, new z())));
                    return;
                }
                try {
                    CronetEngine cronetEngine = new CronetEngine.Builder(context).setStoragePath(this.buildCronetCachePath(context)).enableHttpCache(3, 5242880L).enableQuic(true).addQuicHint(ServiceProvider.GATEWAY_HOST, 443, 443).addQuicHint("cdn-creatives-cf-prd.acquire.unity3dusercontent.com", 443, 443).build();
                    o<HttpClient> oVar2 = pVar;
                    t.a aVar2 = v8.t.f35208b;
                    kotlin.jvm.internal.t.h(cronetEngine, "cronetEngine");
                    oVar2.resumeWith(v8.t.b(new CronetClient(cronetEngine, iSDKDispatchers)));
                } catch (Throwable unused) {
                    o<HttpClient> oVar3 = pVar;
                    t.a aVar3 = v8.t.f35208b;
                    oVar3.resumeWith(v8.t.b(new OkHttp3Client(iSDKDispatchers, new z())));
                }
            }
        });
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    private final NativeConfigurationOuterClass.AdOperationsConfiguration getDefaultAdOperations() {
        AdOperationsConfigurationKt.Dsl.Companion companion = AdOperationsConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.AdOperationsConfiguration.Builder builderNewBuilder = NativeConfigurationOuterClass.AdOperationsConfiguration.newBuilder();
        kotlin.jvm.internal.t.h(builderNewBuilder, "newBuilder()");
        AdOperationsConfigurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setLoadTimeoutMs(30000);
        dsl_create.setShowTimeoutMs(10000);
        dsl_create.setGetTokenTimeoutMs(5000);
        return dsl_create._build();
    }

    private final NativeConfigurationOuterClass.RequestPolicy getDefaultRequestPolicy() {
        RequestPolicyKt.Dsl.Companion companion = RequestPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestPolicy.newBuilder();
        kotlin.jvm.internal.t.h(builderNewBuilder, "newBuilder()");
        RequestPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setRetryPolicy(getDefaultRequestRetryPolicy());
        dsl_create.setTimeoutPolicy(getDefaultRequestTimeoutPolicy());
        return dsl_create._build();
    }

    private final NativeConfigurationOuterClass.RequestRetryPolicy getDefaultRequestRetryPolicy() {
        RequestRetryPolicyKt.Dsl.Companion companion = RequestRetryPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestRetryPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestRetryPolicy.newBuilder();
        kotlin.jvm.internal.t.h(builderNewBuilder, "newBuilder()");
        RequestRetryPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setMaxDuration(20000);
        dsl_create.setRetryWaitBase(500);
        dsl_create.setRetryJitterPct(0.1f);
        dsl_create.setShouldStoreLocally(false);
        dsl_create.setRetryMaxInterval(1000);
        dsl_create.setRetryScalingFactor(2.0f);
        return dsl_create._build();
    }

    private final NativeConfigurationOuterClass.RequestTimeoutPolicy getDefaultRequestTimeoutPolicy() {
        RequestTimeoutPolicyKt.Dsl.Companion companion = RequestTimeoutPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestTimeoutPolicy.newBuilder();
        kotlin.jvm.internal.t.h(builderNewBuilder, "newBuilder()");
        RequestTimeoutPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setConnectTimeoutMs(10000);
        dsl_create.setReadTimeoutMs(10000);
        dsl_create.setWriteTimeoutMs(10000);
        dsl_create.setOverallTimeoutMs(10000);
        return dsl_create._build();
    }

    private final ByteStringDataSource provideByteStringDataSource(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        return new AndroidByteStringDataSource(dataStore);
    }

    private final DataStore<ByteStringStoreOuterClass.ByteStringStore> provideByteStringDataStore(Context context, kotlinx.coroutines.k0 k0Var, String str) {
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new ByteStringSerializer(), null, null, p0.a(k0Var.plus(y2.b(null, 1, null))), new C32821(context, str), 4, null);
    }

    private final JsonStorage provideJsonStorage(StorageManager.StorageType storageType) {
        if (!StorageManager.init(ClientProperties.getApplicationContext())) {
            throw new IllegalStateException("StorageManager failed to initialize".toString());
        }
        Storage storage = StorageManager.getStorage(storageType);
        kotlin.jvm.internal.t.h(storage, "getStorage(storageType)");
        return storage;
    }

    @NotNull
    public final Context androidContext() {
        Context applicationContext = ClientProperties.getApplicationContext();
        kotlin.jvm.internal.t.h(applicationContext, "getApplicationContext()");
        return applicationContext;
    }

    @NotNull
    public final AsyncTokenStorage asyncTokenStorage(@NotNull TokenStorage tokenStorage, @NotNull SDKMetricsSender sdkMetricsSender) {
        kotlin.jvm.internal.t.i(tokenStorage, "tokenStorage");
        kotlin.jvm.internal.t.i(sdkMetricsSender, "sdkMetricsSender");
        return new InMemoryAsyncTokenStorage(null, new Handler(Looper.getMainLooper()), sdkMetricsSender, tokenStorage);
    }

    @NotNull
    public final ByteStringDataSource auidDataStore(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        kotlin.jvm.internal.t.i(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    @NotNull
    public final kotlinx.coroutines.k0 defaultDispatcher() {
        return e1.a();
    }

    @NotNull
    public final NativeConfigurationOuterClass.NativeConfiguration defaultNativeConfiguration() {
        NativeConfigurationKt.Dsl.Companion companion = NativeConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.NativeConfiguration.Builder builderNewBuilder = NativeConfigurationOuterClass.NativeConfiguration.newBuilder();
        kotlin.jvm.internal.t.h(builderNewBuilder, "newBuilder()");
        NativeConfigurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setAdOperations(getDefaultAdOperations());
        dsl_create.setInitPolicy(getDefaultRequestPolicy());
        dsl_create.setAdPolicy(getDefaultRequestPolicy());
        dsl_create.setOtherPolicy(getDefaultRequestPolicy());
        dsl_create.setOperativeEventPolicy(getDefaultRequestPolicy());
        DiagnosticEventsConfigurationKt.Dsl.Companion companion2 = DiagnosticEventsConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.DiagnosticEventsConfiguration.Builder builderNewBuilder2 = NativeConfigurationOuterClass.DiagnosticEventsConfiguration.newBuilder();
        kotlin.jvm.internal.t.h(builderNewBuilder2, "newBuilder()");
        DiagnosticEventsConfigurationKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
        dsl_create2.setEnabled(true);
        dsl_create2.setMaxBatchSize(10);
        dsl_create2.setMaxBatchIntervalMs(30000);
        dsl_create2.setTtmEnabled(false);
        dsl_create.setDiagnosticEvents(dsl_create2._build());
        return dsl_create._build();
    }

    @NotNull
    public final ByteStringDataSource gatewayCacheDataStore(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        kotlin.jvm.internal.t.i(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    @NotNull
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> gatewayDataStore(@NotNull Context context, @NotNull kotlinx.coroutines.k0 dispatcher) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_GATEWAY_CACHE);
    }

    @NotNull
    public final o0 getTokenCoroutineScope(@NotNull ISDKDispatchers dispatchers, @NotNull l0 errorHandler, @NotNull b2 parentJob) {
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        kotlin.jvm.internal.t.i(errorHandler, "errorHandler");
        kotlin.jvm.internal.t.i(parentJob, "parentJob");
        return p0.a(parentJob.plus(dispatchers.getDefault()).plus(new n0(ServiceProvider.NAMED_GET_TOKEN_SCOPE)).plus(errorHandler));
    }

    @NotNull
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> glInfoDataStore(@NotNull Context context, @NotNull kotlinx.coroutines.k0 dispatcher, @NotNull DataMigration<ByteStringStoreOuterClass.ByteStringStore> fetchGLInfo) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        kotlin.jvm.internal.t.i(fetchGLInfo, "fetchGLInfo");
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new ByteStringSerializer(), null, kotlin.collections.u.e(fetchGLInfo), p0.a(dispatcher.plus(y2.b(null, 1, null))), new AnonymousClass1(context), 2, null);
    }

    @NotNull
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> iapTransactionDataStore(@NotNull Context context, @NotNull kotlinx.coroutines.k0 dispatcher) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_IAP_TRANSACTION);
    }

    @NotNull
    public final ByteStringDataSource idfiDataStore(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        kotlin.jvm.internal.t.i(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    @NotNull
    public final o0 initCoroutineScope(@NotNull ISDKDispatchers dispatchers, @NotNull l0 errorHandler, @NotNull b2 parentJob) {
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        kotlin.jvm.internal.t.i(errorHandler, "errorHandler");
        kotlin.jvm.internal.t.i(parentJob, "parentJob");
        return p0.a(parentJob.plus(dispatchers.getDefault()).plus(new n0(ServiceProvider.NAMED_INIT_SCOPE)).plus(errorHandler));
    }

    @NotNull
    public final kotlinx.coroutines.k0 ioDispatcher() {
        return e1.b();
    }

    @NotNull
    public final o0 loadCoroutineScope(@NotNull ISDKDispatchers dispatchers, @NotNull l0 errorHandler, @NotNull b2 parentJob) {
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        kotlin.jvm.internal.t.i(errorHandler, "errorHandler");
        kotlin.jvm.internal.t.i(parentJob, "parentJob");
        return p0.a(parentJob.plus(dispatchers.getDefault()).plus(new n0(ServiceProvider.NAMED_LOAD_SCOPE)).plus(errorHandler));
    }

    @NotNull
    public final kotlinx.coroutines.k0 mainDispatcher() {
        return e1.c();
    }

    @NotNull
    public final MeasurementsService measurementService(@NotNull Context context, @NotNull ISDKDispatchers dispatchers) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        return new MeasurementsService(context, dispatchers, SharedInstances.INSTANCE.getWebViewEventSender());
    }

    @NotNull
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> nativeConfigurationDataStore(@NotNull Context context, @NotNull kotlinx.coroutines.k0 dispatcher) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_NATIVE_CONFIG);
    }

    @NotNull
    public final o0 omidCoroutineScope(@NotNull ISDKDispatchers dispatchers, @NotNull l0 errorHandler, @NotNull b2 parentJob) {
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        kotlin.jvm.internal.t.i(errorHandler, "errorHandler");
        kotlin.jvm.internal.t.i(parentJob, "parentJob");
        return p0.a(parentJob.plus(dispatchers.getDefault()).plus(new n0(ServiceProvider.NAMED_OMID_SCOPE)).plus(errorHandler));
    }

    @NotNull
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> privacyDataStore(@NotNull Context context, @NotNull kotlinx.coroutines.k0 dispatcher) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_PRIVACY);
    }

    @NotNull
    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> privacyFsmDataStore(@NotNull Context context, @NotNull kotlinx.coroutines.k0 dispatcher) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        return provideByteStringDataStore(context, dispatcher, ServiceProvider.DATA_STORE_PRIVACY_FSM);
    }

    @NotNull
    public final JsonStorage privateJsonStorage() {
        return provideJsonStorage(StorageManager.StorageType.PRIVATE);
    }

    @NotNull
    public final HttpClient provideHttpClient(@NotNull ConfigFileFromLocalStorage configFileFromLocalStorage, @NotNull AlternativeFlowReader alternativeFlowReader, @NotNull ISDKDispatchers dispatchers, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull Context context) {
        kotlin.jvm.internal.t.i(configFileFromLocalStorage, "configFileFromLocalStorage");
        kotlin.jvm.internal.t.i(alternativeFlowReader, "alternativeFlowReader");
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        kotlin.jvm.internal.t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        kotlin.jvm.internal.t.i(context, "context");
        return (HttpClient) j.b(null, new C32831(alternativeFlowReader, sendDiagnosticEvent, dispatchers, this, context, configFileFromLocalStorage, null), 1, null);
    }

    @NotNull
    public final b2 publicApiJob(@NotNull DiagnosticEventRepository diagnosticEventRepository) {
        kotlin.jvm.internal.t.i(diagnosticEventRepository, "diagnosticEventRepository");
        a0 a0VarB = h2.b(null, 1, null);
        a0VarB.J(new UnityAdsModule$publicApiJob$1$1(diagnosticEventRepository));
        return a0VarB;
    }

    @NotNull
    public final JsonStorage publicJsonStorage() {
        return provideJsonStorage(StorageManager.StorageType.PUBLIC);
    }

    @NotNull
    public final ISDKDispatchers sdkDispatchers() {
        return new SDKDispatchers();
    }

    @NotNull
    public final SDKMetricsSender sdkMetrics() {
        SDKMetricsSender sDKMetrics = SDKMetrics.getInstance();
        kotlin.jvm.internal.t.h(sDKMetrics, "getInstance()");
        return sDKMetrics;
    }

    @NotNull
    public final o0 showCoroutineScope(@NotNull ISDKDispatchers dispatchers, @NotNull l0 errorHandler, @NotNull b2 parentJob) {
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        kotlin.jvm.internal.t.i(errorHandler, "errorHandler");
        kotlin.jvm.internal.t.i(parentJob, "parentJob");
        return p0.a(parentJob.plus(dispatchers.getDefault()).plus(new n0(ServiceProvider.NAMED_SHOW_SCOPE)).plus(errorHandler));
    }

    @NotNull
    public final TopicsService topicsService(@NotNull Context context, @NotNull ISDKDispatchers dispatchers) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        return new TopicsService(context, dispatchers, SharedInstances.INSTANCE.getWebViewEventSender());
    }

    @NotNull
    public final o0 transactionCoroutineScope(@NotNull ISDKDispatchers dispatchers, @NotNull l0 errorHandler, @NotNull b2 parentJob) {
        kotlin.jvm.internal.t.i(dispatchers, "dispatchers");
        kotlin.jvm.internal.t.i(errorHandler, "errorHandler");
        kotlin.jvm.internal.t.i(parentJob, "parentJob");
        return p0.a(parentJob.plus(dispatchers.getDefault()).plus(new n0(ServiceProvider.NAMED_TRANSACTION_SCOPE)).plus(errorHandler));
    }

    @NotNull
    public final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> universalRequestDataStore(@NotNull Context context, @NotNull kotlinx.coroutines.k0 dispatcher) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new UniversalRequestStoreSerializer(), null, null, p0.a(dispatcher.plus(y2.b(null, 1, null))), new C32841(context), 4, null);
    }

    @NotNull
    public final VolumeChangeMonitor volumeChangeMonitor(@NotNull VolumeChange volumeChange) {
        kotlin.jvm.internal.t.i(volumeChange, "volumeChange");
        return new VolumeChangeMonitor(SharedInstances.INSTANCE.getWebViewEventSender(), volumeChange);
    }

    @NotNull
    public final DataStore<WebviewConfigurationStore.WebViewConfigurationStore> webViewConfigurationDataStore(@NotNull Context context, @NotNull kotlinx.coroutines.k0 dispatcher) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new WebViewConfigurationStoreSerializer(), null, null, p0.a(dispatcher.plus(y2.b(null, 1, null))), new C32851(context), 4, null);
    }

    @NotNull
    public final ByteStringDataSource iapTransactionDataStore(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        kotlin.jvm.internal.t.i(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    @NotNull
    public final ByteStringDataSource nativeConfigurationDataStore(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        kotlin.jvm.internal.t.i(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    @NotNull
    public final ByteStringDataSource privacyDataStore(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        kotlin.jvm.internal.t.i(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    @NotNull
    public final ByteStringDataSource privacyFsmDataStore(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        kotlin.jvm.internal.t.i(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }

    @NotNull
    public final ByteStringDataSource glInfoDataStore(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        kotlin.jvm.internal.t.i(dataStore, "dataStore");
        return provideByteStringDataSource(dataStore);
    }
}
