package com.unity3d.services;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UnityAdsConstants.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnityAdsConstants {

    @NotNull
    public static final UnityAdsConstants INSTANCE = new UnityAdsConstants();

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class AdOperations {
        public static final int GET_TOKEN_TIMEOUT_MS = 5000;

        @NotNull
        public static final AdOperations INSTANCE = new AdOperations();
        public static final int LOAD_TIMEOUT_MS = 30000;
        public static final int SHOW_TIMEOUT_MS = 10000;

        private AdOperations() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class Cache {

        @NotNull
        public static final String CACHE_SCHEME = "unity-ads-cache";

        @NotNull
        public static final Cache INSTANCE = new Cache();

        private Cache() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class ClientInfo {

        @NotNull
        public static final ClientInfo INSTANCE = new ClientInfo();
        public static final int SDK_VERSION = 41203;

        @NotNull
        public static final String SDK_VERSION_NAME = "4.12.3";

        private ClientInfo() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class DefaultUrls {

        @NotNull
        public static final String AD_ASSET_DOMAIN = "unity.ads.asset";

        @NotNull
        public static final String AD_ASSET_PATH = "/";

        @NotNull
        public static final String AD_CACHE_DOMAIN = "unity.ads.cache";

        @NotNull
        public static final String AD_MARKUP_URL = "https://gateway.unityads.unity3d.com/tools/convert_ad_response_to_ad_markup";

        @NotNull
        public static final String AD_PLAYER_QUERY_PARAMS = "?platform=android&";

        @NotNull
        public static final String ASSET_DOMAIN = "cdn-creatives-cf-prd.acquire.unity3dusercontent.com";

        @NotNull
        public static final String CACHE_DIR_NAME = "UnityAdsCache";

        @NotNull
        public static final String GATEWAY_URL = "https://gateway.unityads.unity3d.com/v1";

        @NotNull
        public static final String HTTP_CACHE_DIR_NAME = "UnityAdsHttpCache";

        @NotNull
        public static final DefaultUrls INSTANCE = new DefaultUrls();

        @NotNull
        public static final String WEBVIEW_ASSET_PATH = "/unity-ads-sdk-webview/";

        @NotNull
        public static final String WEBVIEW_DOMAIN = "config.unityads.unity3d.com";

        private DefaultUrls() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class ErrorHandler {
        public static final int ERROR_HANDLER_STACK_TRACE_LINES_MAX = 15;

        @NotNull
        public static final ErrorHandler INSTANCE = new ErrorHandler();

        private ErrorHandler() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class Messages {

        @NotNull
        public static final Messages INSTANCE = new Messages();

        @NotNull
        public static final String MSG_INTERNAL_ERROR = "Internal error";

        @NotNull
        public static final String MSG_UNITY_BASE = "[Unity Ads] ";

        private Messages() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class OpenMeasurement {

        @NotNull
        public static final OpenMeasurement INSTANCE = new OpenMeasurement();

        @NotNull
        public static final String OM_JS_SERVICE_FILENAME = "ad-viewer/omsdk-v1.js";

        @NotNull
        public static final String OM_JS_SESSION_FILENAME = "ad-viewer/omid-session-client-v1.js";

        @NotNull
        public static final String OM_JS_URL_SERVICE = "unity-ads-cache://unity.ads.asset/ad-viewer/omsdk-v1.js";

        @NotNull
        public static final String OM_JS_URL_SESSION = "unity-ads-cache://unity.ads.asset/ad-viewer/omid-session-client-v1.js";

        @NotNull
        public static final String OM_PARTNER_NAME = "Unity3d";

        @NotNull
        public static final String OM_PARTNER_VERSION = "1";
        public static final long OM_SESSION_FINISH_DELAY_MS = 1000;

        private OpenMeasurement() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class Preferences {

        @NotNull
        public static final Preferences INSTANCE = new Preferences();

        @NotNull
        public static final String PREF_KEY_AUID = "auid";

        @NotNull
        public static final String PREF_KEY_IDFI = "unityads-idfi";

        @NotNull
        public static final String PREF_NAME_AUID = "supersonic_shared_preferen";

        @NotNull
        public static final String PREF_NAME_IDFI = "unityads-installinfo";

        private Preferences() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class RequestPolicy {
        public static final int CONNECT_TIMEOUT_MS = 10000;

        @NotNull
        public static final RequestPolicy INSTANCE = new RequestPolicy();
        public static final int OVERALL_TIMEOUT_MS = 10000;
        public static final int READ_TIMEOUT_MS = 10000;
        public static final float RETRY_JITTER_PCT = 0.1f;
        public static final int RETRY_MAX_DURATION = 20000;
        public static final int RETRY_MAX_INTERVAL = 1000;
        public static final float RETRY_SCALING_FACTOR = 2.0f;
        public static final int RETRY_WAIT_BASE = 500;
        public static final boolean SHOULD_STORE_LOCALLY = false;
        public static final int WRITE_TIMEOUT_MS = 10000;

        private RequestPolicy() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class SharedFlow {
        public static final int EXTRA_CAPACITY = 10;

        @NotNull
        public static final SharedFlow INSTANCE = new SharedFlow();
        public static final int REPLAY = 10;

        private SharedFlow() {
        }
    }

    /* JADX INFO: compiled from: UnityAdsConstants.kt */
    public static final class Timeout {
        public static final long GET_TOKEN_TIMEOUT_MS = 5000;
        public static final long INIT_TIMEOUT_MS = 120000;

        @NotNull
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
        }
    }

    private UnityAdsConstants() {
    }
}
