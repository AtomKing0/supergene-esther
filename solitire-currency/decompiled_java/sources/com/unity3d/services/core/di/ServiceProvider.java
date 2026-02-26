package com.unity3d.services.core.di;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import com.unity3d.ads.adplayer.AdPlayerScope;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.unity3d.ads.adplayer.GetAdAssetLoader;
import com.unity3d.ads.adplayer.GetAdAssetLoaderKt;
import com.unity3d.ads.adplayer.GetWebViewAssetLoaderKt;
import com.unity3d.ads.adplayer.GetWebViewCacheAssetLoader;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.data.datasource.AnalyticsDataSource;
import com.unity3d.ads.core.data.datasource.AndroidAnalyticsDataSource;
import com.unity3d.ads.core.data.datasource.AndroidDeveloperConsentDataSource;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLegacyUserConsentDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLifecycleDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLocalCacheDataSource;
import com.unity3d.ads.core.data.datasource.AndroidMediationDataSource;
import com.unity3d.ads.core.data.datasource.AndroidPrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStoreDataSource;
import com.unity3d.ads.core.data.datasource.AndroidTcfDataSource;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.datasource.DeveloperConsentDataSource;
import com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.FetchGLInfoDataMigration;
import com.unity3d.ads.core.data.datasource.LegacyUserConsentDataSource;
import com.unity3d.ads.core.data.datasource.LifecycleDataSource;
import com.unity3d.ads.core.data.datasource.MediationDataSource;
import com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StoreDataSource;
import com.unity3d.ads.core.data.datasource.TcfDataSource;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource;
import com.unity3d.ads.core.data.manager.AndroidOmidManager;
import com.unity3d.ads.core.data.manager.AndroidSDKPropertiesManager;
import com.unity3d.ads.core.data.manager.AndroidStorageManager;
import com.unity3d.ads.core.data.manager.OmidManager;
import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.manager.StorageManager;
import com.unity3d.ads.core.data.manager.TransactionEventManager;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.AndroidAdRepository;
import com.unity3d.ads.core.data.repository.AndroidCacheRepository;
import com.unity3d.ads.core.data.repository.AndroidCampaignRepository;
import com.unity3d.ads.core.data.repository.AndroidDeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository;
import com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.AndroidLegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.AndroidMediationRepository;
import com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.AndroidSessionRepository;
import com.unity3d.ads.core.data.repository.AndroidTcfRepository;
import com.unity3d.ads.core.data.repository.AndroidTransactionEventRepository;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.data.repository.TcfRepository;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.AndroidBoldExperimentHandler;
import com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken;
import com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.AndroidGenerateByteStringId;
import com.unity3d.ads.core.domain.AndroidGetInitializationData;
import com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload;
import com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase;
import com.unity3d.ads.core.domain.AndroidHandleOpenUrl;
import com.unity3d.ads.core.domain.AndroidLoad;
import com.unity3d.ads.core.domain.AndroidRefresh;
import com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent;
import com.unity3d.ads.core.domain.AndroidSendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.AndroidShow;
import com.unity3d.ads.core.domain.AwaitInitialization;
import com.unity3d.ads.core.domain.BoldExperimentHandler;
import com.unity3d.ads.core.domain.BuildHeaderBiddingToken;
import com.unity3d.ads.core.domain.CacheFile;
import com.unity3d.ads.core.domain.ClearCache;
import com.unity3d.ads.core.domain.CommonAwaitInitialization;
import com.unity3d.ads.core.domain.CommonCacheFile;
import com.unity3d.ads.core.domain.CommonClearCache;
import com.unity3d.ads.core.domain.CommonGetAdObject;
import com.unity3d.ads.core.domain.CommonGetAdPlayer;
import com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken;
import com.unity3d.ads.core.domain.CommonGetInitializationState;
import com.unity3d.ads.core.domain.CommonGetIsFileCache;
import com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken;
import com.unity3d.ads.core.domain.CommonSetInitializationState;
import com.unity3d.ads.core.domain.ExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.GetAdDataRefreshRequest;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.GetAdPlayer;
import com.unity3d.ads.core.domain.GetAdPlayerConfigRequest;
import com.unity3d.ads.core.domain.GetAdRequest;
import com.unity3d.ads.core.domain.GetAdRequestPolicy;
import com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerConfigRequest;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerContext;
import com.unity3d.ads.core.domain.GetAndroidAdRequest;
import com.unity3d.ads.core.domain.GetAndroidClientInfo;
import com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest;
import com.unity3d.ads.core.domain.GetAndroidInitializationRequest;
import com.unity3d.ads.core.domain.GetAndroidLimitedSessionToken;
import com.unity3d.ads.core.domain.GetAndroidOpenGLRendererInfo;
import com.unity3d.ads.core.domain.GetAndroidSharedDataTimestamps;
import com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetByteStringId;
import com.unity3d.ads.core.domain.GetCachedAsset;
import com.unity3d.ads.core.domain.GetClientInfo;
import com.unity3d.ads.core.domain.GetCommonWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.GetHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetInitRequestPolicy;
import com.unity3d.ads.core.domain.GetInitializationCompletedRequest;
import com.unity3d.ads.core.domain.GetInitializationData;
import com.unity3d.ads.core.domain.GetInitializationRequest;
import com.unity3d.ads.core.domain.GetInitializationRequestPayload;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.GetIsFileCache;
import com.unity3d.ads.core.domain.GetLatestWebViewConfiguration;
import com.unity3d.ads.core.domain.GetLimitedSessionToken;
import com.unity3d.ads.core.domain.GetOpenGLRendererInfo;
import com.unity3d.ads.core.domain.GetOperativeEventRequestPolicy;
import com.unity3d.ads.core.domain.GetOtherRequestPolicy;
import com.unity3d.ads.core.domain.GetPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.GetUniversalRequestSharedData;
import com.unity3d.ads.core.domain.GetWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.HandleAndroidGatewayInitializationResponse;
import com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse;
import com.unity3d.ads.core.domain.HandleGatewayAdResponse;
import com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse;
import com.unity3d.ads.core.domain.HandleGatewayInitializationResponse;
import com.unity3d.ads.core.domain.HandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.HandleOpenUrl;
import com.unity3d.ads.core.domain.InitializeAndroidBoldSDK;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.Load;
import com.unity3d.ads.core.domain.Refresh;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SendPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.SetInitializationState;
import com.unity3d.ads.core.domain.Show;
import com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest;
import com.unity3d.ads.core.domain.TriggerInitializationCompletedRequest;
import com.unity3d.ads.core.domain.TriggerInitializeListener;
import com.unity3d.ads.core.domain.attribution.AndroidAttribution;
import com.unity3d.ads.core.domain.events.DiagnosticEventObserver;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.core.domain.events.GetAndroidTransactionData;
import com.unity3d.ads.core.domain.events.GetCommonTransactionRequest;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventBatchRequest;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.domain.events.GetOperativeEventRequest;
import com.unity3d.ads.core.domain.events.GetTransactionData;
import com.unity3d.ads.core.domain.events.GetTransactionRequest;
import com.unity3d.ads.core.domain.events.HandleGatewayAndroidEventResponse;
import com.unity3d.ads.core.domain.events.HandleGatewayEventResponse;
import com.unity3d.ads.core.domain.events.OperativeEventObserver;
import com.unity3d.ads.core.domain.events.TransactionEventObserver;
import com.unity3d.ads.core.domain.events.UniversalRequestEventSender;
import com.unity3d.ads.core.domain.om.AndroidOmFinishSession;
import com.unity3d.ads.core.domain.om.AndroidOmImpressionOccurred;
import com.unity3d.ads.core.domain.om.AndroidOmInteraction;
import com.unity3d.ads.core.domain.om.AndroidOmStartSession;
import com.unity3d.ads.core.domain.om.CommonGetOmData;
import com.unity3d.ads.core.domain.om.CommonIsOMActivated;
import com.unity3d.ads.core.domain.om.GetOmData;
import com.unity3d.ads.core.domain.om.InitializeOMAndroidSDK;
import com.unity3d.ads.core.domain.om.InitializeOMSDK;
import com.unity3d.ads.core.domain.om.IsOMActivated;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.ads.core.domain.om.OmImpressionOccurred;
import com.unity3d.ads.core.domain.privacy.DeveloperConsentFlattenerRulesUseCase;
import com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase;
import com.unity3d.ads.core.domain.privacy.LegacyUserConsentFlattenerRulesUseCase;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.DiagnosticEventRequestWorkModifier;
import com.unity3d.ads.core.utils.CommonCoroutineTimer;
import com.unity3d.ads.core.utils.CoroutineTimer;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.services.SDKErrorHandler;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeContentObserver;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.store.StoreMonitor;
import com.unity3d.services.store.StoreWebViewEventSender;
import com.unity3d.services.store.core.GatewayStoreExceptionHandler;
import com.unity3d.services.store.core.StoreEventListenerFactory;
import com.unity3d.services.store.core.StoreExceptionHandler;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import h9.a;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.n;

/* JADX INFO: compiled from: ServiceProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ServiceProvider implements IServiceProvider {

    @NotNull
    public static final String CDN_CREATIVES_HOST = "cdn-creatives-cf-prd.acquire.unity3dusercontent.com";
    public static final int CDN_CREATIVES_PORT = 443;

    @NotNull
    public static final String DATA_STORE_GATEWAY_CACHE = "gateway_cache.pb";

    @NotNull
    public static final String DATA_STORE_GL_INFO = "glinfo.pb";

    @NotNull
    public static final String DATA_STORE_IAP_TRANSACTION = "iap_transaction.pb";

    @NotNull
    public static final String DATA_STORE_NATIVE_CONFIG = "native_configuration.pb";

    @NotNull
    public static final String DATA_STORE_PRIVACY = "privacy.pb";

    @NotNull
    public static final String DATA_STORE_PRIVACY_FSM = "privacy_fsm.pb";

    @NotNull
    public static final String DATA_STORE_UNIVERSAL_REQUEST = "universal_request.pb";

    @NotNull
    public static final String DATA_STORE_WEBVIEW_CONFIG = "webview_config.pb";

    @NotNull
    public static final String DEFAULT_DISPATCHER = "default_dispatcher";

    @NotNull
    public static final String DEV_CONSENT_PRIVACY_RULES = "dev_consent_privacy_rules";

    @NotNull
    public static final String GATEWAY_HOST = "gateway.unityads.unity3d.com";
    public static final int GATEWAY_PORT = 443;
    public static final long HTTP_CACHE_DISK_SIZE = 5242880;
    public static final long HTTP_CLIENT_FETCH_TIMEOUT = 500;

    @NotNull
    public static final ServiceProvider INSTANCE;

    @NotNull
    public static final String IO_DISPATCHER = "io_dispatcher";

    @NotNull
    public static final String LEGACY_PRIVACY_RULES = "legacy_privacy_rules";

    @NotNull
    public static final String MAIN_DISPATCHER = "main_dispatcher";

    @NotNull
    public static final String NAMED_AD_REQ = "ad_req";

    @NotNull
    public static final String NAMED_GET_TOKEN_SCOPE = "get_token_scope";

    @NotNull
    public static final String NAMED_INIT_REQ = "init_req";

    @NotNull
    public static final String NAMED_INIT_SCOPE = "init_scope";

    @NotNull
    public static final String NAMED_LOAD_SCOPE = "load_scope";

    @NotNull
    public static final String NAMED_LOCAL = "local";

    @NotNull
    public static final String NAMED_OMID_SCOPE = "omid_scope";

    @NotNull
    public static final String NAMED_OPERATIVE_REQ = "op_event_req";

    @NotNull
    public static final String NAMED_OTHER_REQ = "other_req";

    @NotNull
    public static final String NAMED_PUBLIC_JOB = "public_job";

    @NotNull
    public static final String NAMED_REMOTE = "remote";

    @NotNull
    public static final String NAMED_SDK = "sdk";

    @NotNull
    public static final String NAMED_SHOW_SCOPE = "show_scope";

    @NotNull
    public static final String NAMED_TRANSACTION_SCOPE = "transaction_scope";

    @NotNull
    public static final String PREF_GL_INFO = "glinfo";

    @NotNull
    private static final IServicesRegistry serviceRegistry;

    /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServiceProvider.kt */
    static final class AnonymousClass1 extends v implements l<ServicesRegistry, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class C04961 extends v implements a<Context> {
            public static final C04961 INSTANCE = new C04961();

            C04961() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            public final Context invoke() {
                return ClientProperties.getApplicationContext();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$10, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass10 extends v implements a<o0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass10(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // h9.a
            @NotNull
            public final o0 invoke() {
                return this.$moduleInstance.transactionCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (l0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, kotlin.jvm.internal.o0.b(l0.class))), (b2) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, kotlin.jvm.internal.o0.b(b2.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$100, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass100 extends v implements a<GetUniversalRequestSharedData> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass100(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetUniversalRequestSharedData invoke() {
                return new GetAndroidUniversalRequestSharedData((GetSharedDataTimestamps) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetSharedDataTimestamps.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (GetLimitedSessionToken) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetLimitedSessionToken.class))), (DeveloperConsentRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeveloperConsentRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$101, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass101 extends v implements a<GetCachedAsset> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass101(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetCachedAsset invoke() {
                return new GetCachedAsset((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CacheRepository.class))), (Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$102, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass102 extends v implements a<GetWebViewBridgeUseCase> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass102(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetWebViewBridgeUseCase invoke() {
                return new GetCommonWebViewBridgeUseCase((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$103, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass103 extends v implements a<GetRequestPolicy> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass103(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetRequestPolicy invoke() {
                return new GetInitRequestPolicy((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$104, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass104 extends v implements a<GetLatestWebViewConfiguration> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass104(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetLatestWebViewConfiguration invoke() {
                return new GetLatestWebViewConfiguration((WebviewConfigurationDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(WebviewConfigurationDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$105, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass105 extends v implements a<GetRequestPolicy> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass105(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetRequestPolicy invoke() {
                return new GetOperativeEventRequestPolicy((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$106, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass106 extends v implements a<GetRequestPolicy> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass106(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetRequestPolicy invoke() {
                return new GetOtherRequestPolicy((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$107, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass107 extends v implements a<GetPrivacyUpdateRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass107(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetPrivacyUpdateRequest invoke() {
                return new GetPrivacyUpdateRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$108, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass108 extends v implements a<HandleGatewayInitializationResponse> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass108(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final HandleGatewayInitializationResponse invoke() {
                return new HandleAndroidGatewayInitializationResponse((TransactionEventManager) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TransactionEventManager.class))), (TriggerInitializationCompletedRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TriggerInitializationCompletedRequest.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (o0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_SCOPE, kotlin.jvm.internal.o0.b(o0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$109, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass109 extends v implements a<HandleGatewayUniversalResponse> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass109(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final HandleGatewayUniversalResponse invoke() {
                return new HandleAndroidGatewayUniversalResponse((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$11, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass11 extends v implements a<o0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass11(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // h9.a
            @NotNull
            public final o0 invoke() {
                return this.$moduleInstance.getTokenCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (l0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, kotlin.jvm.internal.o0.b(l0.class))), (b2) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, kotlin.jvm.internal.o0.b(b2.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$110, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass110 extends v implements a<InitializeBoldSDK> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass110(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeBoldSDK invoke() {
                return new InitializeAndroidBoldSDK((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (InitializeOMSDK) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeOMSDK.class))), (GetInitializationRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class))), (ClearCache) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ClearCache.class))), (HandleGatewayInitializationResponse) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleGatewayInitializationResponse.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GatewayClient.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (EventObservers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(EventObservers.class))), (TriggerInitializeListener) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TriggerInitializeListener.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (DiagnosticEventRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DiagnosticEventRepository.class))), (StorageManager) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(StorageManager.class))), (ConfigurationReader) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ConfigurationReader.class))), (SDKPropertiesManager) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SDKPropertiesManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$111, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass111 extends v implements a<LegacyShowUseCase> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass111(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final LegacyShowUseCase invoke() {
                return new LegacyShowUseCase((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (Show) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Show.class))), (AdRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (GetOperativeEventApi) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetOperativeEventApi.class))), (GetInitializationState) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationState.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$112, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass112 extends v implements a<SendPrivacyUpdateRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass112(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final SendPrivacyUpdateRequest invoke() {
                return new SendPrivacyUpdateRequest((GetPrivacyUpdateRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetPrivacyUpdateRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GatewayClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$113, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass113 extends v implements a<TriggerInitializationCompletedRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass113(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TriggerInitializationCompletedRequest invoke() {
                return new TriggerAndroidInitializationCompletedRequest((GetInitializationCompletedRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationCompletedRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GatewayClient.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$114, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass114 extends v implements a<TriggerInitializeListener> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass114(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TriggerInitializeListener invoke() {
                return new TriggerInitializeListener((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$115, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass115 extends v implements a<DiagnosticEventObserver> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass115(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DiagnosticEventObserver invoke() {
                return new DiagnosticEventObserver((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))), (GetDiagnosticEventBatchRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetDiagnosticEventBatchRequest.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (DiagnosticEventRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DiagnosticEventRepository.class))), (UniversalRequestDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(UniversalRequestDataSource.class))), (BackgroundWorker) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(BackgroundWorker.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$116, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass116 extends v implements a<EventObservers> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass116(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final EventObservers invoke() {
                return new EventObservers((OperativeEventObserver) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OperativeEventObserver.class))), (DiagnosticEventObserver) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DiagnosticEventObserver.class))), (TransactionEventObserver) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TransactionEventObserver.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$117, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass117 extends v implements a<GetTransactionData> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass117(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetTransactionData invoke() {
                return new GetAndroidTransactionData((GetByteStringId) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetByteStringId.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$118, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass118 extends v implements a<GetTransactionRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass118(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetTransactionRequest invoke() {
                return new GetCommonTransactionRequest((DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$119, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass119 extends v implements a<GetDiagnosticEventBatchRequest> {
            public static final AnonymousClass119 INSTANCE = new AnonymousClass119();

            AnonymousClass119() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetDiagnosticEventBatchRequest invoke() {
                return new GetDiagnosticEventBatchRequest();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$12, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass12 extends v implements a<o0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass12(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // h9.a
            @NotNull
            public final o0 invoke() {
                return this.$moduleInstance.omidCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (l0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, kotlin.jvm.internal.o0.b(l0.class))), (b2) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, kotlin.jvm.internal.o0.b(b2.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$120, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass120 extends v implements a<GetDiagnosticEventRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass120(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetDiagnosticEventRequest invoke() {
                return new GetDiagnosticEventRequest((GetSharedDataTimestamps) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetSharedDataTimestamps.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$121, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass121 extends v implements a<GetOperativeEventApi> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass121(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetOperativeEventApi invoke() {
                return new GetOperativeEventApi((OperativeEventRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OperativeEventRepository.class))), (GetOperativeEventRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetOperativeEventRequest.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$122, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass122 extends v implements a<GetOperativeEventRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass122(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetOperativeEventRequest invoke() {
                return new GetOperativeEventRequest((GetByteStringId) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetByteStringId.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CampaignRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$123, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass123 extends v implements a<HandleGatewayEventResponse> {
            public static final AnonymousClass123 INSTANCE = new AnonymousClass123();

            AnonymousClass123() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final HandleGatewayEventResponse invoke() {
                return new HandleGatewayAndroidEventResponse();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$124, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass124 extends v implements a<OperativeEventObserver> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass124(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final OperativeEventObserver invoke() {
                return new OperativeEventObserver((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (OperativeEventRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OperativeEventRepository.class))), (UniversalRequestDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(UniversalRequestDataSource.class))), (BackgroundWorker) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(BackgroundWorker.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$125, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass125 extends v implements a<TransactionEventObserver> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass125(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TransactionEventObserver invoke() {
                return new TransactionEventObserver((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (TransactionEventRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TransactionEventRepository.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GatewayClient.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, kotlin.jvm.internal.o0.b(ByteStringDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$126, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass126 extends v implements a<UniversalRequestEventSender> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass126(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final UniversalRequestEventSender invoke() {
                return new UniversalRequestEventSender((GatewayClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GatewayClient.class))), (HandleGatewayEventResponse) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleGatewayEventResponse.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$127, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass127 extends v implements a<OmFinishSession> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass127(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final OmFinishSession invoke() {
                return new AndroidOmFinishSession((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OpenMeasurementRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$128, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass128 extends v implements a<OmImpressionOccurred> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass128(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final OmImpressionOccurred invoke() {
                return new AndroidOmImpressionOccurred((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OpenMeasurementRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$129, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass129 extends v implements a<AndroidOmInteraction> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass129(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AndroidOmInteraction invoke() {
                return new AndroidOmStartSession((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OpenMeasurementRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$13, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass13 extends v implements a<b2> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass13(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // h9.a
            @NotNull
            public final b2 invoke() {
                return this.$moduleInstance.publicApiJob((DiagnosticEventRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DiagnosticEventRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$130, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass130 extends v implements a<GetOmData> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass130(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetOmData invoke() {
                return new CommonGetOmData((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OpenMeasurementRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$131, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass131 extends v implements a<IsOMActivated> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass131(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final IsOMActivated invoke() {
                return new CommonIsOMActivated((OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OpenMeasurementRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$132, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass132 extends v implements a<InitializeOMSDK> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass132(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeOMSDK invoke() {
                return new InitializeOMAndroidSDK((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OpenMeasurementRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$133, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass133 extends v implements a<FlattenerRulesUseCase> {
            public static final AnonymousClass133 INSTANCE = new AnonymousClass133();

            AnonymousClass133() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final FlattenerRulesUseCase invoke() {
                return new DeveloperConsentFlattenerRulesUseCase();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$134, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass134 extends v implements a<FlattenerRulesUseCase> {
            public static final AnonymousClass134 INSTANCE = new AnonymousClass134();

            AnonymousClass134() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final FlattenerRulesUseCase invoke() {
                return new LegacyUserConsentFlattenerRulesUseCase();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$135, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass135 extends v implements a<BackgroundWorker> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass135(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final BackgroundWorker invoke() {
                return new BackgroundWorker((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$136, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass136 extends v implements a<DiagnosticEventRequestWorkModifier> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass136(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DiagnosticEventRequestWorkModifier invoke() {
                return new DiagnosticEventRequestWorkModifier((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (LifecycleDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(LifecycleDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$137, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass137 extends v implements a<GatewayClient> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass137(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GatewayClient invoke() {
                return new CommonGatewayClient((HttpClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HttpClient.class))), (HandleGatewayUniversalResponse) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleGatewayUniversalResponse.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$138, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass138 extends v implements a<l0> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass138(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            @Override // h9.a
            @NotNull
            public final l0 invoke() {
                return new SDKErrorHandler((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (AlternativeFlowReader) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AlternativeFlowReader.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (SDKMetricsSender) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SDKMetricsSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$139, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass139 extends v implements a<TokenStorage> {
            public static final AnonymousClass139 INSTANCE = new AnonymousClass139();

            AnonymousClass139() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TokenStorage invoke() {
                return new InMemoryTokenStorage();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$14, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass14 extends v implements a<DataStore<ByteStringStoreOuterClass.ByteStringStore>> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass14(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.gatewayDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$140, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass140 extends v implements a<VolumeChange> {
            public static final AnonymousClass140 INSTANCE = new AnonymousClass140();

            AnonymousClass140() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final VolumeChange invoke() {
                return new VolumeChangeContentObserver();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$141, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass141 extends v implements a<ConfigFileFromLocalStorage> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass141(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ConfigFileFromLocalStorage invoke() {
                return new ConfigFileFromLocalStorage((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$142, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass142 extends v implements a<InitializeSDK> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass142(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeSDK invoke() {
                return new InitializeSDK((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ConfigFileFromLocalStorage.class))), (InitializeStateReset) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateReset.class))), (InitializeStateError) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateError.class))), (InitializeStateConfig) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateConfig.class))), (InitializeStateCreate) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateCreate.class))), (InitializeStateLoadCache) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateLoadCache.class))), (InitializeStateLoadWeb) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateLoadWeb.class))), (InitializeStateComplete) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateComplete.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$143, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass143 extends v implements a<InitializeStateComplete> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass143(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateComplete invoke() {
                return new InitializeStateComplete((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$144, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass144 extends v implements a<InitializeStateConfig> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass144(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateConfig invoke() {
                return new InitializeStateConfig((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (InitializeStateConfigWithLoader) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateConfigWithLoader.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$145, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass145 extends v implements a<InitializeStateConfigWithLoader> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass145(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateConfigWithLoader invoke() {
                return new InitializeStateConfigWithLoader((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (InitializeStateNetworkError) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateNetworkError.class))), (TokenStorage) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TokenStorage.class))), (SDKMetricsSender) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SDKMetricsSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$146, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass146 extends v implements a<InitializeStateCreate> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass146(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateCreate invoke() {
                return new InitializeStateCreate((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$147, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass147 extends v implements a<InitializeStateError> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass147(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateError invoke() {
                return new InitializeStateError((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$148, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass148 extends v implements a<InitializeStateLoadCache> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass148(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateLoadCache invoke() {
                return new InitializeStateLoadCache((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$149, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass149 extends v implements a<InitializeStateLoadWeb> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass149(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateLoadWeb invoke() {
                return new InitializeStateLoadWeb((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (InitializeStateNetworkError) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateNetworkError.class))), (HttpClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HttpClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$15, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass15 extends v implements a<DataStore<ByteStringStoreOuterClass.ByteStringStore>> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass15(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.privacyDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$150, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass150 extends v implements a<InitializeStateReset> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass150(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateReset invoke() {
                return new InitializeStateReset((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$151, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass151 extends v implements a<StoreMonitor> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass151(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final StoreMonitor invoke() {
                return new StoreMonitor((StoreExceptionHandler) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreExceptionHandler.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$152, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass152 extends v implements a<StoreWebViewEventSender> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass152(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final StoreWebViewEventSender invoke() {
                return new StoreWebViewEventSender((IEventSender) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(IEventSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$153, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass153 extends v implements a<StoreExceptionHandler> {
            public static final AnonymousClass153 INSTANCE = new AnonymousClass153();

            AnonymousClass153() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final StoreExceptionHandler invoke() {
                return new GatewayStoreExceptionHandler();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$154, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass154 extends v implements a<StoreEventListenerFactory> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass154(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final StoreEventListenerFactory invoke() {
                return new StoreEventListenerFactory((StoreWebViewEventSender) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreWebViewEventSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$155, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass155 extends v implements a<ConfigurationReader> {
            public static final AnonymousClass155 INSTANCE = new AnonymousClass155();

            AnonymousClass155() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ConfigurationReader invoke() {
                return new ConfigurationReader();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$156, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass156 extends v implements a<AndroidAttribution> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass156(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AndroidAttribution invoke() {
                return new AndroidAttribution((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$157, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass157 extends v implements a<AdPlayerScope> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass157(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AdPlayerScope invoke() {
                return new AdPlayerScope((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$158, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass158 extends v implements a<AndroidWebViewClient> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass158(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AndroidWebViewClient invoke() {
                return new AndroidWebViewClient((GetWebViewCacheAssetLoader) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetWebViewCacheAssetLoader.class))), (GetAdAssetLoader) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdAssetLoader.class))), (GetCachedAsset) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetCachedAsset.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$159, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass159 extends v implements a<AndroidGetWebViewContainerUseCase> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass159(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AndroidGetWebViewContainerUseCase invoke() {
                return new AndroidGetWebViewContainerUseCase((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (AndroidWebViewClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AndroidWebViewClient.class))), (SendWebViewClientErrorDiagnostics) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendWebViewClientErrorDiagnostics.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$16, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass16 extends v implements a<ByteStringDataSource> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass16(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.privacyDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, kotlin.jvm.internal.o0.b(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$160, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass160 extends v implements a<Load> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass160(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final Load invoke() {
                return new AndroidLoad((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (GetAdRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdRequest.class))), (GetAdPlayerConfigRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdPlayerConfigRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class))), (HandleGatewayAdResponse) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleGatewayAdResponse.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GatewayClient.class))), (AdRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$161, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass161 extends v implements a<AwaitInitialization> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass161(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AwaitInitialization invoke() {
                return new CommonAwaitInitialization((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$162, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass162 extends v implements a<GetAsyncHeaderBiddingToken> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass162(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetAsyncHeaderBiddingToken invoke() {
                return new CommonInitAwaitingGetHeaderBiddingToken((GetHeaderBiddingToken) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetHeaderBiddingToken.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (GetInitializationState) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationState.class))), (AwaitInitialization) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AwaitInitialization.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$163, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass163 extends v implements a<GetAdPlayer> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass163(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetAdPlayer invoke() {
                return new CommonGetAdPlayer((DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (ExecuteAdViewerRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ExecuteAdViewerRequest.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (o0) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdPlayerScope.class))), (OpenMeasurementRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OpenMeasurementRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$164, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass164 extends v implements a<HandleGatewayAdResponse> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass164(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final HandleGatewayAdResponse invoke() {
                return new HandleGatewayAndroidAdResponse((AdRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdRepository.class))), (AndroidGetWebViewContainerUseCase) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AndroidGetWebViewContainerUseCase.class))), (GetWebViewBridgeUseCase) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetWebViewBridgeUseCase.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (HandleInvocationsFromAdViewer) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleInvocationsFromAdViewer.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CampaignRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (GetOperativeEventApi) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetOperativeEventApi.class))), (GetLatestWebViewConfiguration) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetLatestWebViewConfiguration.class))), (AdPlayerScope) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdPlayerScope.class))), (GetAdPlayer) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdPlayer.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$165, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass165 extends v implements a<HandleInvocationsFromAdViewer> {
            public static final AnonymousClass165 INSTANCE = new AnonymousClass165();

            AnonymousClass165() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final HandleInvocationsFromAdViewer invoke() {
                return new HandleInvocationsFromAdViewer();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$166, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass166 extends v implements a<LegacyLoadUseCase> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass166(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final LegacyLoadUseCase invoke() {
                return new LegacyLoadUseCase((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (Load) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Load.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (GetInitializationState) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationState.class))), (AwaitInitialization) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AwaitInitialization.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (AdRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$167, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass167 extends v implements a<InitializeStateNetworkError> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass167(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final InitializeStateNetworkError invoke() {
                return new InitializeStateNetworkError((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$168, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass168 extends v implements a<GetAdAssetLoader> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass168(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetAdAssetLoader invoke() {
                return GetAdAssetLoaderKt.provideGetAdCacheAssetLoader((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$169, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass169 extends v implements a<GetWebViewCacheAssetLoader> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass169(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetWebViewCacheAssetLoader invoke() {
                return GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$17, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass17 extends v implements a<DataStore<ByteStringStoreOuterClass.ByteStringStore>> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass17(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.privacyFsmDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$170, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass170 extends v implements a<CoroutineTimer> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass170(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final CoroutineTimer invoke() {
                return new CommonCoroutineTimer((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$171, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass171 extends v implements a<IEventSender> {
            public static final AnonymousClass171 INSTANCE = new AnonymousClass171();

            AnonymousClass171() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final IEventSender invoke() {
                return SharedInstances.INSTANCE.getWebViewEventSender();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$18, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass18 extends v implements a<ByteStringDataSource> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass18(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.privacyFsmDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, kotlin.jvm.internal.o0.b(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$19, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass19 extends v implements a<DataStore<ByteStringStoreOuterClass.ByteStringStore>> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass19(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.nativeConfigurationDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass2 extends v implements a<kotlinx.coroutines.k0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // h9.a
            @NotNull
            public final kotlinx.coroutines.k0 invoke() {
                return this.$moduleInstance.mainDispatcher();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$20, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass20 extends v implements a<ByteStringDataSource> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass20(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.nativeConfigurationDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, kotlin.jvm.internal.o0.b(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$21, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass21 extends v implements a<DataStore<ByteStringStoreOuterClass.ByteStringStore>> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass21(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.glInfoDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (DataMigration) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.PREF_GL_INFO, kotlin.jvm.internal.o0.b(DataMigration.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$22, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass22 extends v implements a<ByteStringDataSource> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass22(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.glInfoDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, kotlin.jvm.internal.o0.b(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$23, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass23 extends v implements a<DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore>> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass23(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> invoke() {
                return this.$moduleInstance.universalRequestDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$24, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass24 extends v implements a<DataStore<ByteStringStoreOuterClass.ByteStringStore>> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass24(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return this.$moduleInstance.iapTransactionDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$25, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass25 extends v implements a<ByteStringDataSource> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass25(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.iapTransactionDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, kotlin.jvm.internal.o0.b(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$26, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass26 extends v implements a<DataStore<WebviewConfigurationStore.WebViewConfigurationStore>> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass26(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataStore<WebviewConfigurationStore.WebViewConfigurationStore> invoke() {
                return this.$moduleInstance.webViewConfigurationDataStore((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$27, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass27 extends v implements a<AsyncTokenStorage> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass27(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AsyncTokenStorage invoke() {
                return this.$moduleInstance.asyncTokenStorage((TokenStorage) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TokenStorage.class))), (SDKMetricsSender) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SDKMetricsSender.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$28, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass28 extends v implements a<VolumeChangeMonitor> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass28(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final VolumeChangeMonitor invoke() {
                return this.$moduleInstance.volumeChangeMonitor((VolumeChange) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(VolumeChange.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$29, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass29 extends v implements a<JsonStorage> {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass29(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final JsonStorage invoke() {
                return this.$moduleInstance.publicJsonStorage();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass3 extends v implements a<kotlinx.coroutines.k0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // h9.a
            @NotNull
            public final kotlinx.coroutines.k0 invoke() {
                return this.$moduleInstance.defaultDispatcher();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$30, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass30 extends v implements a<JsonStorage> {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass30(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final JsonStorage invoke() {
                return this.$moduleInstance.privateJsonStorage();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$31, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass31 extends v implements a<NativeConfigurationOuterClass.NativeConfiguration> {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass31(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final NativeConfigurationOuterClass.NativeConfiguration invoke() {
                return this.$moduleInstance.defaultNativeConfiguration();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$32, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass32 extends v implements a<ByteStringDataSource> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass32(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ByteStringDataSource invoke() {
                return this.$moduleInstance.gatewayCacheDataStore((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, kotlin.jvm.internal.o0.b(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$33, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass33 extends v implements a<MeasurementsService> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass33(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final MeasurementsService invoke() {
                return this.$moduleInstance.measurementService((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$34, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass34 extends v implements a<TopicsService> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass34(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TopicsService invoke() {
                return this.$moduleInstance.topicsService((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$35, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass35 extends v implements a<HttpClient> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass35(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final HttpClient invoke() {
                return this.$moduleInstance.provideHttpClient((ConfigFileFromLocalStorage) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ConfigFileFromLocalStorage.class))), (AlternativeFlowReader) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AlternativeFlowReader.class))), (ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))), (Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$36, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass36 extends v implements a<AlternativeFlowReader> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass36(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AlternativeFlowReader invoke() {
                return new AlternativeFlowReader((ConfigurationReader) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ConfigurationReader.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$37, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass37 extends v implements a<TcfDataSource> {
            public static final AnonymousClass37 INSTANCE = new AnonymousClass37();

            AnonymousClass37() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TcfDataSource invoke() {
                return new AndroidTcfDataSource();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$38, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass38 extends v implements a<TcfRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass38(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TcfRepository invoke() {
                return new AndroidTcfRepository((TcfDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TcfDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$39, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass39 extends v implements a<GameServerIdReader> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass39(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GameServerIdReader invoke() {
                return new GameServerIdReader((JsonStorage) this.$this_registry.resolveService(new ServiceKey("PUBLIC", kotlin.jvm.internal.o0.b(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass4 extends v implements a<kotlinx.coroutines.k0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            @Override // h9.a
            @NotNull
            public final kotlinx.coroutines.k0 invoke() {
                return this.$moduleInstance.ioDispatcher();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$40, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass40 extends v implements a<StoreDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass40(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final StoreDataSource invoke() {
                return new AndroidStoreDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$41, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass41 extends v implements a<AnalyticsDataSource> {
            public static final AnonymousClass41 INSTANCE = new AnonymousClass41();

            AnonymousClass41() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AnalyticsDataSource invoke() {
                return new AndroidAnalyticsDataSource();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$42, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass42 extends v implements a<DeveloperConsentDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass42(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DeveloperConsentDataSource invoke() {
                return new AndroidDeveloperConsentDataSource((FlattenerRulesUseCase) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEV_CONSENT_PRIVACY_RULES, kotlin.jvm.internal.o0.b(FlattenerRulesUseCase.class))), (JsonStorage) this.$this_registry.resolveService(new ServiceKey("PUBLIC", kotlin.jvm.internal.o0.b(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$43, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass43 extends v implements a<DynamicDeviceInfoDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass43(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DynamicDeviceInfoDataSource invoke() {
                return new AndroidDynamicDeviceInfoDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (LifecycleDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(LifecycleDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$44, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass44 extends v implements a<LegacyUserConsentDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass44(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final LegacyUserConsentDataSource invoke() {
                return new AndroidLegacyUserConsentDataSource((FlattenerRulesUseCase) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.LEGACY_PRIVACY_RULES, kotlin.jvm.internal.o0.b(FlattenerRulesUseCase.class))), (JsonStorage) this.$this_registry.resolveService(new ServiceKey("PRIVATE", kotlin.jvm.internal.o0.b(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$45, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass45 extends v implements a<LifecycleDataSource> {
            public static final AnonymousClass45 INSTANCE = new AnonymousClass45();

            AnonymousClass45() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final LifecycleDataSource invoke() {
                return new AndroidLifecycleDataSource();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$46, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass46 extends v implements a<CacheDataSource> {
            public static final AnonymousClass46 INSTANCE = new AnonymousClass46();

            AnonymousClass46() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final CacheDataSource invoke() {
                return new AndroidLocalCacheDataSource();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$47, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass47 extends v implements a<MediationDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass47(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final MediationDataSource invoke() {
                return new AndroidMediationDataSource((JsonStorage) this.$this_registry.resolveService(new ServiceKey("PUBLIC", kotlin.jvm.internal.o0.b(JsonStorage.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$48, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass48 extends v implements a<PrivacyDeviceInfoDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass48(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final PrivacyDeviceInfoDataSource invoke() {
                return new AndroidPrivacyDeviceInfoDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$49, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass49 extends v implements a<CacheDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass49(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final CacheDataSource invoke() {
                return new AndroidRemoteCacheDataSource((HttpClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HttpClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass5 extends v implements a<ISDKDispatchers> {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ISDKDispatchers invoke() {
                return this.$moduleInstance.sdkDispatchers();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$50, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass50 extends v implements a<StaticDeviceInfoDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass50(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final StaticDeviceInfoDataSource invoke() {
                return new AndroidStaticDeviceInfoDataSource((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, kotlin.jvm.internal.o0.b(ByteStringDataSource.class))), (AnalyticsDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AnalyticsDataSource.class))), (StoreDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$51, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass51 extends v implements a<DataMigration<ByteStringStoreOuterClass.ByteStringStore>> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass51(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                return new FetchGLInfoDataMigration((GetOpenGLRendererInfo) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetOpenGLRendererInfo.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$52, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass52 extends v implements a<UniversalRequestDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass52(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final UniversalRequestDataSource invoke() {
                return new UniversalRequestDataSource((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST, kotlin.jvm.internal.o0.b(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$53, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass53 extends v implements a<WebviewConfigurationDataSource> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass53(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final WebviewConfigurationDataSource invoke() {
                return new WebviewConfigurationDataSource((DataStore) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_WEBVIEW_CONFIG, kotlin.jvm.internal.o0.b(DataStore.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$54, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass54 extends v implements a<OmidManager> {
            public static final AnonymousClass54 INSTANCE = new AnonymousClass54();

            AnonymousClass54() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final OmidManager invoke() {
                return new AndroidOmidManager();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$55, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass55 extends v implements a<SDKPropertiesManager> {
            public static final AnonymousClass55 INSTANCE = new AnonymousClass55();

            AnonymousClass55() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final SDKPropertiesManager invoke() {
                return new AndroidSDKPropertiesManager();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$56, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass56 extends v implements a<StorageManager> {
            public static final AnonymousClass56 INSTANCE = new AnonymousClass56();

            AnonymousClass56() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final StorageManager invoke() {
                return new AndroidStorageManager();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$57, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass57 extends v implements a<TransactionEventManager> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass57(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TransactionEventManager invoke() {
                return new TransactionEventManager((o0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_TRANSACTION_SCOPE, kotlin.jvm.internal.o0.b(o0.class))), (StoreMonitor) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreMonitor.class))), (GetTransactionData) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetTransactionData.class))), (GetTransactionRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetTransactionRequest.class))), (TransactionEventRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TransactionEventRepository.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, kotlin.jvm.internal.o0.b(ByteStringDataSource.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$58, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass58 extends v implements a<AdRepository> {
            public static final AnonymousClass58 INSTANCE = new AnonymousClass58();

            AnonymousClass58() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final AdRepository invoke() {
                return new AndroidAdRepository();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$59, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass59 extends v implements a<CacheRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass59(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final CacheRepository invoke() {
                return new AndroidCacheRepository((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (CacheDataSource) this.$this_registry.resolveService(new ServiceKey("local", kotlin.jvm.internal.o0.b(CacheDataSource.class))), (CacheDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_REMOTE, kotlin.jvm.internal.o0.b(CacheDataSource.class))), (Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass6 extends v implements a<SDKMetricsSender> {
            final /* synthetic */ UnityAdsModule $moduleInstance;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(UnityAdsModule unityAdsModule) {
                super(0);
                this.$moduleInstance = unityAdsModule;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final SDKMetricsSender invoke() {
                return this.$moduleInstance.sdkMetrics();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$60, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass60 extends v implements a<CampaignRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass60(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final CampaignRepository invoke() {
                return new AndroidCampaignRepository((GetSharedDataTimestamps) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetSharedDataTimestamps.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$61, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass61 extends v implements a<DeveloperConsentRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass61(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DeveloperConsentRepository invoke() {
                return new AndroidDeveloperConsentRepository((DeveloperConsentDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeveloperConsentDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$62, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass62 extends v implements a<DeviceInfoRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass62(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DeviceInfoRepository invoke() {
                return new AndroidDeviceInfoRepository((StaticDeviceInfoDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(StaticDeviceInfoDataSource.class))), (DynamicDeviceInfoDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DynamicDeviceInfoDataSource.class))), (PrivacyDeviceInfoDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(PrivacyDeviceInfoDataSource.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$63, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass63 extends v implements a<DiagnosticEventRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass63(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final DiagnosticEventRepository invoke() {
                return new AndroidDiagnosticEventRepository((CoroutineTimer) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CoroutineTimer.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$64, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass64 extends v implements a<LegacyUserConsentRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass64(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final LegacyUserConsentRepository invoke() {
                return new AndroidLegacyUserConsentRepository((LegacyUserConsentDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(LegacyUserConsentDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$65, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass65 extends v implements a<MediationRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass65(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final MediationRepository invoke() {
                return new AndroidMediationRepository((MediationDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(MediationDataSource.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$66, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass66 extends v implements a<OpenMeasurementRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass66(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final OpenMeasurementRepository invoke() {
                return new AndroidOpenMeasurementRepository((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (OmidManager) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OmidManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$67, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass67 extends v implements a<SessionRepository> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass67(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final SessionRepository invoke() {
                return new AndroidSessionRepository((ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, kotlin.jvm.internal.o0.b(ByteStringDataSource.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, kotlin.jvm.internal.o0.b(ByteStringDataSource.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, kotlin.jvm.internal.o0.b(ByteStringDataSource.class))), (ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, kotlin.jvm.internal.o0.b(ByteStringDataSource.class))), (NativeConfigurationOuterClass.NativeConfiguration) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(NativeConfigurationOuterClass.NativeConfiguration.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$68, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass68 extends v implements a<TransactionEventRepository> {
            public static final AnonymousClass68 INSTANCE = new AnonymousClass68();

            AnonymousClass68() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final TransactionEventRepository invoke() {
                return new AndroidTransactionEventRepository();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$69, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass69 extends v implements a<OperativeEventRepository> {
            public static final AnonymousClass69 INSTANCE = new AnonymousClass69();

            AnonymousClass69() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final OperativeEventRepository invoke() {
                return new OperativeEventRepository();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass7 extends v implements a<o0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // h9.a
            @NotNull
            public final o0 invoke() {
                return this.$moduleInstance.initCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (l0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, kotlin.jvm.internal.o0.b(l0.class))), (b2) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, kotlin.jvm.internal.o0.b(b2.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$70, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass70 extends v implements a<BoldExperimentHandler> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass70(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final BoldExperimentHandler invoke() {
                return new AndroidBoldExperimentHandler((ByteStringDataSource) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, kotlin.jvm.internal.o0.b(ByteStringDataSource.class))), (kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$71, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass71 extends v implements a<ExecuteAdViewerRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass71(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ExecuteAdViewerRequest invoke() {
                return new AndroidExecuteAdViewerRequest((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (HttpClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(HttpClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$72, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass72 extends v implements a<GetByteStringId> {
            public static final AnonymousClass72 INSTANCE = new AnonymousClass72();

            AnonymousClass72() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetByteStringId invoke() {
                return new AndroidGenerateByteStringId();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$73, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass73 extends v implements a<HandleOpenUrl> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass73(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final HandleOpenUrl invoke() {
                return new AndroidHandleOpenUrl((Context) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$74, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass74 extends v implements a<Refresh> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass74(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final Refresh invoke() {
                return new AndroidRefresh((kotlinx.coroutines.k0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class))), (GetAdDataRefreshRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdDataRefreshRequest.class))), (GetRequestPolicy) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class))), (GatewayClient) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GatewayClient.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$75, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass75 extends v implements a<SendDiagnosticEvent> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass75(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final SendDiagnosticEvent invoke() {
                return new AndroidSendDiagnosticEvent((DiagnosticEventRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DiagnosticEventRepository.class))), (GetDiagnosticEventRequest) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetDiagnosticEventRequest.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$76, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass76 extends v implements a<SendWebViewClientErrorDiagnostics> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass76(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final SendWebViewClientErrorDiagnostics invoke() {
                return new AndroidSendWebViewClientErrorDiagnostics((SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$77, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass77 extends v implements a<Show> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass77(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final Show invoke() {
                return new AndroidShow((AdRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdRepository.class))), (GameServerIdReader) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GameServerIdReader.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$78, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass78 extends v implements a<CacheFile> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass78(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final CacheFile invoke() {
                return new CommonCacheFile((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CacheRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$79, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass79 extends v implements a<ClearCache> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass79(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final ClearCache invoke() {
                return new CommonClearCache((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CacheRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$8, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass8 extends v implements a<o0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass8(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // h9.a
            @NotNull
            public final o0 invoke() {
                return this.$moduleInstance.loadCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (l0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, kotlin.jvm.internal.o0.b(l0.class))), (b2) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, kotlin.jvm.internal.o0.b(b2.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$80, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass80 extends v implements a<GetAdObject> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass80(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetAdObject invoke() {
                return new CommonGetAdObject((AdRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$81, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass81 extends v implements a<GetHeaderBiddingToken> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass81(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetHeaderBiddingToken invoke() {
                return new CommonGetHeaderBiddingToken((BuildHeaderBiddingToken) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(BuildHeaderBiddingToken.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$82, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass82 extends v implements a<BuildHeaderBiddingToken> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass82(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final BuildHeaderBiddingToken invoke() {
                return new AndroidBuildHeaderBiddingToken((GetByteStringId) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetByteStringId.class))), (GetClientInfo) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetClientInfo.class))), (GetSharedDataTimestamps) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetSharedDataTimestamps.class))), (GetLimitedSessionToken) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetLimitedSessionToken.class))), (GetInitializationData) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationData.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CampaignRepository.class))), (TcfRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TcfRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$83, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass83 extends v implements a<GetInitializationData> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass83(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetInitializationData invoke() {
                return new AndroidGetInitializationData((GetInitializationRequestPayload) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationRequestPayload.class))), (GetUniversalRequestSharedData) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestSharedData.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$84, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass84 extends v implements a<GetInitializationRequestPayload> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass84(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetInitializationRequestPayload invoke() {
                return new AndroidGetInitializationRequestPayload((GetClientInfo) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetClientInfo.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (LegacyUserConsentRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(LegacyUserConsentRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$85, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass85 extends v implements a<GetInitializationState> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass85(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetInitializationState invoke() {
                return new CommonGetInitializationState((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$86, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass86 extends v implements a<GetIsFileCache> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass86(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetIsFileCache invoke() {
                return new CommonGetIsFileCache((CacheRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CacheRepository.class))), (SendDiagnosticEvent) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$87, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass87 extends v implements a<SetInitializationState> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass87(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final SetInitializationState invoke() {
                return new CommonSetInitializationState((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$88, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass88 extends v implements a<GetRequestPolicy> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass88(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetRequestPolicy invoke() {
                return new GetAdRequestPolicy((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$89, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass89 extends v implements a<GetAdDataRefreshRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass89(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetAdDataRefreshRequest invoke() {
                return new GetAndroidAdDataRefreshRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CampaignRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$9, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass9 extends v implements a<o0> {
            final /* synthetic */ UnityAdsModule $moduleInstance;
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass9(UnityAdsModule unityAdsModule, ServicesRegistry servicesRegistry) {
                super(0);
                this.$moduleInstance = unityAdsModule;
                this.$this_registry = servicesRegistry;
            }

            @Override // h9.a
            @NotNull
            public final o0 invoke() {
                return this.$moduleInstance.showCoroutineScope((ISDKDispatchers) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class))), (l0) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, kotlin.jvm.internal.o0.b(l0.class))), (b2) this.$this_registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, kotlin.jvm.internal.o0.b(b2.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$90, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass90 extends v implements a<GetAdPlayerConfigRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass90(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetAdPlayerConfigRequest invoke() {
                return new GetAndroidAdPlayerConfigRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$91, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass91 extends v implements a<GetAndroidAdPlayerContext> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass91(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetAndroidAdPlayerContext invoke() {
                return new GetAndroidAdPlayerContext((DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$92, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass92 extends v implements a<GetAdRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass92(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetAdRequest invoke() {
                return new GetAndroidAdRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (CampaignRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(CampaignRepository.class))), (WebviewConfigurationDataSource) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(WebviewConfigurationDataSource.class))), (TcfRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(TcfRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$93, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass93 extends v implements a<GetClientInfo> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass93(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetClientInfo invoke() {
                return new GetAndroidClientInfo((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (MediationRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(MediationRepository.class))), (OmidManager) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(OmidManager.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$94, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass94 extends v implements a<GetInitializationCompletedRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass94(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetInitializationCompletedRequest invoke() {
                return new GetAndroidInitializationCompletedRequest((GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))), (DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$95, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass95 extends v implements a<GetInitializationRequest> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass95(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetInitializationRequest invoke() {
                return new GetAndroidInitializationRequest((GetInitializationRequestPayload) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationRequestPayload.class))), (GetUniversalRequestForPayLoad) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$96, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass96 extends v implements a<GetLimitedSessionToken> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass96(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetLimitedSessionToken invoke() {
                return new GetAndroidLimitedSessionToken((DeviceInfoRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class))), (SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))), (MediationRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(MediationRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$97, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass97 extends v implements a<GetOpenGLRendererInfo> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass97(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetOpenGLRendererInfo invoke() {
                return new GetAndroidOpenGLRendererInfo((SessionRepository) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class))));
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$98, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass98 extends v implements a<GetSharedDataTimestamps> {
            public static final AnonymousClass98 INSTANCE = new AnonymousClass98();

            AnonymousClass98() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetSharedDataTimestamps invoke() {
                return new GetAndroidSharedDataTimestamps();
            }
        }

        /* JADX INFO: renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$99, reason: invalid class name */
        /* JADX INFO: compiled from: ServiceProvider.kt */
        static final class AnonymousClass99 extends v implements a<GetUniversalRequestForPayLoad> {
            final /* synthetic */ ServicesRegistry $this_registry;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass99(ServicesRegistry servicesRegistry) {
                super(0);
                this.$this_registry = servicesRegistry;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final GetUniversalRequestForPayLoad invoke() {
                return new GetAndroidUniversalRequestForPayLoad((GetUniversalRequestSharedData) this.$this_registry.resolveService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestSharedData.class))));
            }
        }

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(ServicesRegistry servicesRegistry) {
            invoke2(servicesRegistry);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ServicesRegistry registry) {
            t.i(registry, "$this$registry");
            UnityAdsModule unityAdsModule = new UnityAdsModule();
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(Context.class)), n.a(C04961.INSTANCE));
            registry.updateService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class)), n.a(new AnonymousClass2(unityAdsModule)));
            registry.updateService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class)), n.a(new AnonymousClass3(unityAdsModule)));
            registry.updateService(new ServiceKey(ServiceProvider.IO_DISPATCHER, kotlin.jvm.internal.o0.b(kotlinx.coroutines.k0.class)), n.a(new AnonymousClass4(unityAdsModule)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class)), n.a(new AnonymousClass5(unityAdsModule)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(SDKMetricsSender.class)), n.a(new AnonymousClass6(unityAdsModule)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_INIT_SCOPE, kotlin.jvm.internal.o0.b(o0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass7(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_LOAD_SCOPE, kotlin.jvm.internal.o0.b(o0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass8(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_SHOW_SCOPE, kotlin.jvm.internal.o0.b(o0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass9(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_TRANSACTION_SCOPE, kotlin.jvm.internal.o0.b(o0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass10(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_GET_TOKEN_SCOPE, kotlin.jvm.internal.o0.b(o0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass11(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_OMID_SCOPE, kotlin.jvm.internal.o0.b(o0.class)), ServiceFactoryKt.factoryOf(new AnonymousClass12(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, kotlin.jvm.internal.o0.b(b2.class)), ServiceFactoryKt.factoryOf(new AnonymousClass13(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, kotlin.jvm.internal.o0.b(DataStore.class)), n.a(new AnonymousClass14(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, kotlin.jvm.internal.o0.b(DataStore.class)), n.a(new AnonymousClass15(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, kotlin.jvm.internal.o0.b(ByteStringDataSource.class)), n.a(new AnonymousClass16(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, kotlin.jvm.internal.o0.b(DataStore.class)), n.a(new AnonymousClass17(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, kotlin.jvm.internal.o0.b(ByteStringDataSource.class)), n.a(new AnonymousClass18(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, kotlin.jvm.internal.o0.b(DataStore.class)), n.a(new AnonymousClass19(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, kotlin.jvm.internal.o0.b(ByteStringDataSource.class)), n.a(new AnonymousClass20(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, kotlin.jvm.internal.o0.b(DataStore.class)), n.a(new AnonymousClass21(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, kotlin.jvm.internal.o0.b(ByteStringDataSource.class)), n.a(new AnonymousClass22(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST, kotlin.jvm.internal.o0.b(DataStore.class)), n.a(new AnonymousClass23(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, kotlin.jvm.internal.o0.b(DataStore.class)), n.a(new AnonymousClass24(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, kotlin.jvm.internal.o0.b(ByteStringDataSource.class)), n.a(new AnonymousClass25(unityAdsModule, registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_WEBVIEW_CONFIG, kotlin.jvm.internal.o0.b(DataStore.class)), n.a(new AnonymousClass26(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AsyncTokenStorage.class)), n.a(new AnonymousClass27(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(VolumeChangeMonitor.class)), n.a(new AnonymousClass28(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("PUBLIC", kotlin.jvm.internal.o0.b(JsonStorage.class)), n.a(new AnonymousClass29(unityAdsModule)));
            registry.updateService(new ServiceKey("PRIVATE", kotlin.jvm.internal.o0.b(JsonStorage.class)), n.a(new AnonymousClass30(unityAdsModule)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(NativeConfigurationOuterClass.NativeConfiguration.class)), n.a(new AnonymousClass31(unityAdsModule)));
            registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, kotlin.jvm.internal.o0.b(ByteStringDataSource.class)), n.a(new AnonymousClass32(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(MeasurementsService.class)), n.a(new AnonymousClass33(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TopicsService.class)), n.a(new AnonymousClass34(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(HttpClient.class)), n.a(new AnonymousClass35(unityAdsModule, registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AlternativeFlowReader.class)), n.a(new AnonymousClass36(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TcfDataSource.class)), n.a(AnonymousClass37.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TcfRepository.class)), n.a(new AnonymousClass38(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GameServerIdReader.class)), n.a(new AnonymousClass39(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreDataSource.class)), n.a(new AnonymousClass40(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AnalyticsDataSource.class)), n.a(AnonymousClass41.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeveloperConsentDataSource.class)), n.a(new AnonymousClass42(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(DynamicDeviceInfoDataSource.class)), n.a(new AnonymousClass43(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(LegacyUserConsentDataSource.class)), n.a(new AnonymousClass44(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(LifecycleDataSource.class)), n.a(AnonymousClass45.INSTANCE));
            registry.updateService(new ServiceKey("local", kotlin.jvm.internal.o0.b(CacheDataSource.class)), n.a(AnonymousClass46.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(MediationDataSource.class)), n.a(new AnonymousClass47(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(PrivacyDeviceInfoDataSource.class)), n.a(new AnonymousClass48(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_REMOTE, kotlin.jvm.internal.o0.b(CacheDataSource.class)), n.a(new AnonymousClass49(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(StaticDeviceInfoDataSource.class)), n.a(new AnonymousClass50(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.PREF_GL_INFO, kotlin.jvm.internal.o0.b(DataMigration.class)), n.a(new AnonymousClass51(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(UniversalRequestDataSource.class)), n.a(new AnonymousClass52(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(WebviewConfigurationDataSource.class)), n.a(new AnonymousClass53(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(OmidManager.class)), n.a(AnonymousClass54.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(SDKPropertiesManager.class)), n.a(AnonymousClass55.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(StorageManager.class)), n.a(AnonymousClass56.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TransactionEventManager.class)), n.a(new AnonymousClass57(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdRepository.class)), n.a(AnonymousClass58.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(CacheRepository.class)), n.a(new AnonymousClass59(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(CampaignRepository.class)), n.a(new AnonymousClass60(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeveloperConsentRepository.class)), n.a(new AnonymousClass61(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(DeviceInfoRepository.class)), n.a(new AnonymousClass62(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(DiagnosticEventRepository.class)), n.a(new AnonymousClass63(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(LegacyUserConsentRepository.class)), n.a(new AnonymousClass64(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(MediationRepository.class)), n.a(new AnonymousClass65(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(OpenMeasurementRepository.class)), n.a(new AnonymousClass66(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(SessionRepository.class)), n.a(new AnonymousClass67(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TransactionEventRepository.class)), n.a(AnonymousClass68.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(OperativeEventRepository.class)), n.a(AnonymousClass69.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(BoldExperimentHandler.class)), n.a(new AnonymousClass70(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(ExecuteAdViewerRequest.class)), n.a(new AnonymousClass71(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetByteStringId.class)), n.a(AnonymousClass72.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleOpenUrl.class)), n.a(new AnonymousClass73(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(Refresh.class)), n.a(new AnonymousClass74(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendDiagnosticEvent.class)), n.a(new AnonymousClass75(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendWebViewClientErrorDiagnostics.class)), n.a(new AnonymousClass76(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(Show.class)), n.a(new AnonymousClass77(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(CacheFile.class)), n.a(new AnonymousClass78(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(ClearCache.class)), n.a(new AnonymousClass79(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdObject.class)), n.a(new AnonymousClass80(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new AnonymousClass81(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(BuildHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new AnonymousClass82(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationData.class)), n.a(new AnonymousClass83(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationRequestPayload.class)), n.a(new AnonymousClass84(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationState.class)), n.a(new AnonymousClass85(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetIsFileCache.class)), n.a(new AnonymousClass86(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(SetInitializationState.class)), n.a(new AnonymousClass87(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class)), n.a(new AnonymousClass88(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdDataRefreshRequest.class)), n.a(new AnonymousClass89(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdPlayerConfigRequest.class)), n.a(new AnonymousClass90(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAndroidAdPlayerContext.class)), n.a(new AnonymousClass91(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdRequest.class)), n.a(new AnonymousClass92(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetClientInfo.class)), n.a(new AnonymousClass93(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationCompletedRequest.class)), n.a(new AnonymousClass94(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetInitializationRequest.class)), n.a(new AnonymousClass95(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetLimitedSessionToken.class)), n.a(new AnonymousClass96(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetOpenGLRendererInfo.class)), n.a(new AnonymousClass97(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetSharedDataTimestamps.class)), n.a(AnonymousClass98.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestForPayLoad.class)), n.a(new AnonymousClass99(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetUniversalRequestSharedData.class)), n.a(new AnonymousClass100(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetCachedAsset.class)), n.a(new AnonymousClass101(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetWebViewBridgeUseCase.class)), n.a(new AnonymousClass102(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class)), n.a(new AnonymousClass103(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetLatestWebViewConfiguration.class)), n.a(new AnonymousClass104(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_OPERATIVE_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class)), n.a(new AnonymousClass105(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, kotlin.jvm.internal.o0.b(GetRequestPolicy.class)), n.a(new AnonymousClass106(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetPrivacyUpdateRequest.class)), n.a(new AnonymousClass107(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleGatewayInitializationResponse.class)), n.a(new AnonymousClass108(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleGatewayUniversalResponse.class)), n.a(new AnonymousClass109(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeBoldSDK.class)), n.a(new AnonymousClass110(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(LegacyShowUseCase.class)), ServiceFactoryKt.factoryOf(new AnonymousClass111(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(SendPrivacyUpdateRequest.class)), n.a(new AnonymousClass112(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TriggerInitializationCompletedRequest.class)), n.a(new AnonymousClass113(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TriggerInitializeListener.class)), n.a(new AnonymousClass114(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(DiagnosticEventObserver.class)), n.a(new AnonymousClass115(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(EventObservers.class)), n.a(new AnonymousClass116(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetTransactionData.class)), n.a(new AnonymousClass117(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetTransactionRequest.class)), n.a(new AnonymousClass118(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetDiagnosticEventBatchRequest.class)), n.a(AnonymousClass119.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetDiagnosticEventRequest.class)), n.a(new AnonymousClass120(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetOperativeEventApi.class)), n.a(new AnonymousClass121(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetOperativeEventRequest.class)), n.a(new AnonymousClass122(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleGatewayEventResponse.class)), n.a(AnonymousClass123.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(OperativeEventObserver.class)), n.a(new AnonymousClass124(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TransactionEventObserver.class)), n.a(new AnonymousClass125(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(UniversalRequestEventSender.class)), n.a(new AnonymousClass126(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(OmFinishSession.class)), n.a(new AnonymousClass127(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(OmImpressionOccurred.class)), n.a(new AnonymousClass128(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AndroidOmInteraction.class)), n.a(new AnonymousClass129(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetOmData.class)), n.a(new AnonymousClass130(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(IsOMActivated.class)), n.a(new AnonymousClass131(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeOMSDK.class)), n.a(new AnonymousClass132(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.DEV_CONSENT_PRIVACY_RULES, kotlin.jvm.internal.o0.b(FlattenerRulesUseCase.class)), n.a(AnonymousClass133.INSTANCE));
            registry.updateService(new ServiceKey(ServiceProvider.LEGACY_PRIVACY_RULES, kotlin.jvm.internal.o0.b(FlattenerRulesUseCase.class)), n.a(AnonymousClass134.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(BackgroundWorker.class)), n.a(new AnonymousClass135(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(DiagnosticEventRequestWorkModifier.class)), n.a(new AnonymousClass136(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GatewayClient.class)), n.a(new AnonymousClass137(registry)));
            registry.updateService(new ServiceKey(ServiceProvider.NAMED_SDK, kotlin.jvm.internal.o0.b(l0.class)), n.a(new AnonymousClass138(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(TokenStorage.class)), n.a(AnonymousClass139.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(VolumeChange.class)), n.a(AnonymousClass140.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(ConfigFileFromLocalStorage.class)), n.a(new AnonymousClass141(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeSDK.class)), n.a(new AnonymousClass142(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateComplete.class)), n.a(new AnonymousClass143(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateConfig.class)), n.a(new AnonymousClass144(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateConfigWithLoader.class)), n.a(new AnonymousClass145(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateCreate.class)), n.a(new AnonymousClass146(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateError.class)), n.a(new AnonymousClass147(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateLoadCache.class)), n.a(new AnonymousClass148(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateLoadWeb.class)), n.a(new AnonymousClass149(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateReset.class)), n.a(new AnonymousClass150(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreMonitor.class)), n.a(new AnonymousClass151(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreWebViewEventSender.class)), n.a(new AnonymousClass152(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreExceptionHandler.class)), n.a(AnonymousClass153.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(StoreEventListenerFactory.class)), n.a(new AnonymousClass154(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(ConfigurationReader.class)), n.a(AnonymousClass155.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AndroidAttribution.class)), n.a(new AnonymousClass156(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AdPlayerScope.class)), ServiceFactoryKt.factoryOf(new AnonymousClass157(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AndroidWebViewClient.class)), ServiceFactoryKt.factoryOf(new AnonymousClass158(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AndroidGetWebViewContainerUseCase.class)), ServiceFactoryKt.factoryOf(new AnonymousClass159(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(Load.class)), ServiceFactoryKt.factoryOf(new AnonymousClass160(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(AwaitInitialization.class)), ServiceFactoryKt.factoryOf(new AnonymousClass161(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAsyncHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new AnonymousClass162(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdPlayer.class)), ServiceFactoryKt.factoryOf(new AnonymousClass163(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleGatewayAdResponse.class)), ServiceFactoryKt.factoryOf(new AnonymousClass164(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(HandleInvocationsFromAdViewer.class)), ServiceFactoryKt.factoryOf(AnonymousClass165.INSTANCE));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(LegacyLoadUseCase.class)), ServiceFactoryKt.factoryOf(new AnonymousClass166(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(InitializeStateNetworkError.class)), ServiceFactoryKt.factoryOf(new AnonymousClass167(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetAdAssetLoader.class)), n.a(new AnonymousClass168(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(GetWebViewCacheAssetLoader.class)), n.a(new AnonymousClass169(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(CoroutineTimer.class)), ServiceFactoryKt.factoryOf(new AnonymousClass170(registry)));
            registry.updateService(new ServiceKey("", kotlin.jvm.internal.o0.b(IEventSender.class)), n.a(AnonymousClass171.INSTANCE));
        }
    }

    static {
        ServiceProvider serviceProvider = new ServiceProvider();
        INSTANCE = serviceProvider;
        serviceRegistry = serviceProvider.initialize();
    }

    private ServiceProvider() {
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    @NotNull
    public IServicesRegistry getRegistry() {
        return serviceRegistry;
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    @NotNull
    public IServicesRegistry initialize() {
        return ServicesRegistryKt.registry(AnonymousClass1.INSTANCE);
    }
}
