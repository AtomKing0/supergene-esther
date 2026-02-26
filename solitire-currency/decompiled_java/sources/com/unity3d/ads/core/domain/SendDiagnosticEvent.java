package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.AdObject;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SendDiagnosticEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface SendDiagnosticEvent {

    @NotNull
    public static final String AD_LOAD_TYPE = "type";

    @NotNull
    public static final String APP_ACTIVE = "app_active";

    @NotNull
    public static final String AWAITED_INIT = "awaited_init";

    @NotNull
    public static final String BILLING_SERVICE_UNAVAILABLE = "billing_service_unavailable";

    @NotNull
    public static final String BRIDGE_SEND_EVENT_FAILED = "bridge_send_event_failed";

    @NotNull
    public static final String CACHE_SOURCE = "cache_source";

    @NotNull
    public static final String COMPLETE_STATE = "complete_state";

    @NotNull
    public static final String COROUTINE_NAME = "coroutine_name";

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    public static final String DEBUG = "debug";

    @NotNull
    public static final String HB = "hb";

    @NotNull
    public static final String HB_FAILURE = "native_gateway_token_failure_time";

    @NotNull
    public static final String HB_STARTED = "native_gateway_token_started";

    @NotNull
    public static final String HB_SUCCESS = "native_gateway_token_success_time";

    @NotNull
    public static final String INIT_CLEAR_CACHE = "native_initialize_clear_cache_time";

    @NotNull
    public static final String INIT_COMPLETED_FAILURE = "native_initialize_completed_task_failure_time";

    @NotNull
    public static final String INIT_COMPLETED_STARTED = "native_initialization_completed_started";

    @NotNull
    public static final String INIT_COMPLETED_SUCCESS = "native_initialize_completed_task_success_time";

    @NotNull
    public static final String INIT_FAILURE = "native_initialize_task_failure_time";

    @NotNull
    public static final String INIT_MISSED_NATIVE_PARSING = "native_initialize_missed_native_parsing";

    @NotNull
    public static final String INIT_STARTED = "native_initialization_started";

    @NotNull
    public static final String INIT_SUCCESS = "native_initialize_task_success_time";

    @NotNull
    public static final String LOAD_CACHE_FAILURE = "native_load_cache_failure_time";

    @NotNull
    public static final String LOAD_CACHE_SUCCESS = "native_load_cache_success_time";

    @NotNull
    public static final String LOAD_FAILURE = "native_load_failure_time";

    @NotNull
    public static final String LOAD_STARTED = "native_load_started";

    @NotNull
    public static final String LOAD_STARTED_AD_VIEWER = "native_load_started_ad_viewer";

    @NotNull
    public static final String LOAD_SUCCESS = "native_load_success_time";

    @NotNull
    public static final String NETWORK_CLIENT = "network_client";

    @NotNull
    public static final String NETWORK_FAILURE = "native_network_failure_time";

    @NotNull
    public static final String NETWORK_PARSE = "native_network_parse_failure";

    @NotNull
    public static final String NETWORK_SUCCESS = "native_network_success_time";

    @NotNull
    public static final String OM_ACTIVATE_FAILURE = "om_activate_failure_time";

    @NotNull
    public static final String OM_ACTIVATE_STARTED = "om_activate_started";

    @NotNull
    public static final String OM_ACTIVATE_SUCCESS = "om_activate_success_time";

    @NotNull
    public static final String OM_IMPRESSION_OCCURRED_FAILURE = "om_impression_occurred_failure";

    @NotNull
    public static final String OM_IMPRESSION_OCCURRED_SUCCESS = "om_impression_occurred_success";

    @NotNull
    public static final String OM_SESSION_FINISH_FAILURE = "om_session_finish_failure";

    @NotNull
    public static final String OM_SESSION_FINISH_SUCCESS = "om_session_finish_success";

    @NotNull
    public static final String OM_SESSION_START_FAILURE = "om_session_start_failure";

    @NotNull
    public static final String OM_SESSION_START_SUCCESS = "om_session_start_success";

    @NotNull
    public static final String OPERATION = "operation";

    @NotNull
    public static final String PROTOCOL = "protocol";

    @NotNull
    public static final String REASON = "reason";

    @NotNull
    public static final String REASON_AD_MARKUP_PARSE = "invalid_admarkup";

    @NotNull
    public static final String REASON_AD_OBJECT_NOT_FOUND = "ad_object_not_found";

    @NotNull
    public static final String REASON_AD_PLAYER_SCOPE = "ad_player_scope_not_active";

    @NotNull
    public static final String REASON_AD_VIEWER = "adviewer";

    @NotNull
    public static final String REASON_ALREADY_SHOWING = "already_showing";

    @NotNull
    public static final String REASON_CODE = "reason_code";

    @NotNull
    public static final String REASON_DEBUG = "reason_debug";

    @NotNull
    public static final String REASON_GATEWAY = "gateway";

    @NotNull
    public static final String REASON_INVALID_ENTRY_POINT = "invalid_url";

    @NotNull
    public static final String REASON_LISTENER_NULL = "listener_null";

    @NotNull
    public static final String REASON_NETWORK = "network";

    @NotNull
    public static final String REASON_NOT_INITIALIZED = "not_initialized";

    @NotNull
    public static final String REASON_NO_FILL = "no_fill";

    @NotNull
    public static final String REASON_NO_NETWORK = "no_network";

    @NotNull
    public static final String REASON_NO_WEBVIEW_ENTRY_POINT = "no_webview_entry_point";

    @NotNull
    public static final String REASON_OM_ALREADY_ACTIVE = "om_already_active";

    @NotNull
    public static final String REASON_OM_CREATIVE_TYPE_INVALID = "om_creative_type_invalid";

    @NotNull
    public static final String REASON_OM_CREATIVE_TYPE_NULL = "om_creative_type_null";

    @NotNull
    public static final String REASON_OM_NOT_ACTIVE = "om_not_active";

    @NotNull
    public static final String REASON_OM_SESSION_ALREADY_EXISTS = "om_session_already_exists";

    @NotNull
    public static final String REASON_OM_SESSION_NOT_FOUND = "om_session_not_found";

    @NotNull
    public static final String REASON_OPPORTUNITY_ID = "no_opportunity_id";

    @NotNull
    public static final String REASON_OPPORTUNITY_USED = "opportunity_id_used";

    @NotNull
    public static final String REASON_PLACEMENT_NULL = "placement_null";

    @NotNull
    public static final String REASON_PLACEMENT_VALIDATION = "placement_validation";

    @NotNull
    public static final String REASON_PROTOBUF_PARSING = "protobuf_parsing";

    @NotNull
    public static final String REASON_TIMEOUT = "timeout";

    @NotNull
    public static final String REASON_UNCAUGHT_EXCEPTION = "uncaught_exception";

    @NotNull
    public static final String REASON_UNKNOWN = "unknown";

    @NotNull
    public static final String RETRIES = "retries";

    @NotNull
    public static final String SAME_SESSION = "same_session";

    @NotNull
    public static final String SHOW_CANCEL_TIMEOUT = "native_show_cancel_timeout";

    @NotNull
    public static final String SHOW_CLICKED = "native_show_clicked";

    @NotNull
    public static final String SHOW_FAILURE = "native_show_failure_time";

    @NotNull
    public static final String SHOW_HAS_STARTED = "show_has_started";

    @NotNull
    public static final String SHOW_IS_FILE_CACHED_FAILURE = "native_show_is_file_cached_failure_time";

    @NotNull
    public static final String SHOW_IS_FILE_CACHED_SUCCESS = "native_show_is_file_cached_success_time";

    @NotNull
    public static final String SHOW_LEFT_APPLICATION = "native_show_left_app";

    @NotNull
    public static final String SHOW_STARTED = "native_show_started";

    @NotNull
    public static final String SHOW_STARTED_AD_VIEWER = "native_show_started_ad_viewer";

    @NotNull
    public static final String SHOW_SUCCESS = "native_show_success_time";

    @NotNull
    public static final String SHOW_WV_STARTED = "native_show_wv_started";

    @NotNull
    public static final String SIZE_KB = "size_kb";

    @NotNull
    public static final String STATE = "state";

    @NotNull
    public static final String SYNC = "sync";

    @NotNull
    public static final String SYSTEM_CRONET_FAILURE = "native_cronet_failure_time";

    @NotNull
    public static final String SYSTEM_CRONET_SUCCESS = "native_cronet_success_time";

    @NotNull
    public static final String UNKNOWN = "unknown";

    @NotNull
    public static final String URL = "url";

    @NotNull
    public static final String WEBVIEW_ERROR = "webview_error";

    @NotNull
    public static final String WEBVIEW_ERROR_CODE = "webview_error_code";

    @NotNull
    public static final String WEBVIEW_URL = "webview_url";

    /* JADX INFO: compiled from: SendDiagnosticEvent.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String AD_LOAD_TYPE = "type";

        @NotNull
        public static final String APP_ACTIVE = "app_active";

        @NotNull
        public static final String AWAITED_INIT = "awaited_init";

        @NotNull
        public static final String BILLING_SERVICE_UNAVAILABLE = "billing_service_unavailable";

        @NotNull
        public static final String BRIDGE_SEND_EVENT_FAILED = "bridge_send_event_failed";

        @NotNull
        public static final String CACHE_SOURCE = "cache_source";

        @NotNull
        public static final String COMPLETE_STATE = "complete_state";

        @NotNull
        public static final String COROUTINE_NAME = "coroutine_name";

        @NotNull
        public static final String DEBUG = "debug";

        @NotNull
        public static final String HB = "hb";

        @NotNull
        public static final String HB_FAILURE = "native_gateway_token_failure_time";

        @NotNull
        public static final String HB_STARTED = "native_gateway_token_started";

        @NotNull
        public static final String HB_SUCCESS = "native_gateway_token_success_time";

        @NotNull
        public static final String INIT_CLEAR_CACHE = "native_initialize_clear_cache_time";

        @NotNull
        public static final String INIT_COMPLETED_FAILURE = "native_initialize_completed_task_failure_time";

        @NotNull
        public static final String INIT_COMPLETED_STARTED = "native_initialization_completed_started";

        @NotNull
        public static final String INIT_COMPLETED_SUCCESS = "native_initialize_completed_task_success_time";

        @NotNull
        public static final String INIT_FAILURE = "native_initialize_task_failure_time";

        @NotNull
        public static final String INIT_MISSED_NATIVE_PARSING = "native_initialize_missed_native_parsing";

        @NotNull
        public static final String INIT_STARTED = "native_initialization_started";

        @NotNull
        public static final String INIT_SUCCESS = "native_initialize_task_success_time";

        @NotNull
        public static final String LOAD_CACHE_FAILURE = "native_load_cache_failure_time";

        @NotNull
        public static final String LOAD_CACHE_SUCCESS = "native_load_cache_success_time";

        @NotNull
        public static final String LOAD_FAILURE = "native_load_failure_time";

        @NotNull
        public static final String LOAD_STARTED = "native_load_started";

        @NotNull
        public static final String LOAD_STARTED_AD_VIEWER = "native_load_started_ad_viewer";

        @NotNull
        public static final String LOAD_SUCCESS = "native_load_success_time";

        @NotNull
        public static final String NETWORK_CLIENT = "network_client";

        @NotNull
        public static final String NETWORK_FAILURE = "native_network_failure_time";

        @NotNull
        public static final String NETWORK_PARSE = "native_network_parse_failure";

        @NotNull
        public static final String NETWORK_SUCCESS = "native_network_success_time";

        @NotNull
        public static final String OM_ACTIVATE_FAILURE = "om_activate_failure_time";

        @NotNull
        public static final String OM_ACTIVATE_STARTED = "om_activate_started";

        @NotNull
        public static final String OM_ACTIVATE_SUCCESS = "om_activate_success_time";

        @NotNull
        public static final String OM_IMPRESSION_OCCURRED_FAILURE = "om_impression_occurred_failure";

        @NotNull
        public static final String OM_IMPRESSION_OCCURRED_SUCCESS = "om_impression_occurred_success";

        @NotNull
        public static final String OM_SESSION_FINISH_FAILURE = "om_session_finish_failure";

        @NotNull
        public static final String OM_SESSION_FINISH_SUCCESS = "om_session_finish_success";

        @NotNull
        public static final String OM_SESSION_START_FAILURE = "om_session_start_failure";

        @NotNull
        public static final String OM_SESSION_START_SUCCESS = "om_session_start_success";

        @NotNull
        public static final String OPERATION = "operation";

        @NotNull
        public static final String PROTOCOL = "protocol";

        @NotNull
        public static final String REASON = "reason";

        @NotNull
        public static final String REASON_AD_MARKUP_PARSE = "invalid_admarkup";

        @NotNull
        public static final String REASON_AD_OBJECT_NOT_FOUND = "ad_object_not_found";

        @NotNull
        public static final String REASON_AD_PLAYER_SCOPE = "ad_player_scope_not_active";

        @NotNull
        public static final String REASON_AD_VIEWER = "adviewer";

        @NotNull
        public static final String REASON_ALREADY_SHOWING = "already_showing";

        @NotNull
        public static final String REASON_CODE = "reason_code";

        @NotNull
        public static final String REASON_DEBUG = "reason_debug";

        @NotNull
        public static final String REASON_GATEWAY = "gateway";

        @NotNull
        public static final String REASON_INVALID_ENTRY_POINT = "invalid_url";

        @NotNull
        public static final String REASON_LISTENER_NULL = "listener_null";

        @NotNull
        public static final String REASON_NETWORK = "network";

        @NotNull
        public static final String REASON_NOT_INITIALIZED = "not_initialized";

        @NotNull
        public static final String REASON_NO_FILL = "no_fill";

        @NotNull
        public static final String REASON_NO_NETWORK = "no_network";

        @NotNull
        public static final String REASON_NO_WEBVIEW_ENTRY_POINT = "no_webview_entry_point";

        @NotNull
        public static final String REASON_OM_ALREADY_ACTIVE = "om_already_active";

        @NotNull
        public static final String REASON_OM_CREATIVE_TYPE_INVALID = "om_creative_type_invalid";

        @NotNull
        public static final String REASON_OM_CREATIVE_TYPE_NULL = "om_creative_type_null";

        @NotNull
        public static final String REASON_OM_NOT_ACTIVE = "om_not_active";

        @NotNull
        public static final String REASON_OM_SESSION_ALREADY_EXISTS = "om_session_already_exists";

        @NotNull
        public static final String REASON_OM_SESSION_NOT_FOUND = "om_session_not_found";

        @NotNull
        public static final String REASON_OPPORTUNITY_ID = "no_opportunity_id";

        @NotNull
        public static final String REASON_OPPORTUNITY_USED = "opportunity_id_used";

        @NotNull
        public static final String REASON_PLACEMENT_NULL = "placement_null";

        @NotNull
        public static final String REASON_PLACEMENT_VALIDATION = "placement_validation";

        @NotNull
        public static final String REASON_PROTOBUF_PARSING = "protobuf_parsing";

        @NotNull
        public static final String REASON_TIMEOUT = "timeout";

        @NotNull
        public static final String REASON_UNCAUGHT_EXCEPTION = "uncaught_exception";

        @NotNull
        public static final String REASON_UNKNOWN = "unknown";

        @NotNull
        public static final String RETRIES = "retries";

        @NotNull
        public static final String SAME_SESSION = "same_session";

        @NotNull
        public static final String SHOW_CANCEL_TIMEOUT = "native_show_cancel_timeout";

        @NotNull
        public static final String SHOW_CLICKED = "native_show_clicked";

        @NotNull
        public static final String SHOW_FAILURE = "native_show_failure_time";

        @NotNull
        public static final String SHOW_HAS_STARTED = "show_has_started";

        @NotNull
        public static final String SHOW_IS_FILE_CACHED_FAILURE = "native_show_is_file_cached_failure_time";

        @NotNull
        public static final String SHOW_IS_FILE_CACHED_SUCCESS = "native_show_is_file_cached_success_time";

        @NotNull
        public static final String SHOW_LEFT_APPLICATION = "native_show_left_app";

        @NotNull
        public static final String SHOW_STARTED = "native_show_started";

        @NotNull
        public static final String SHOW_STARTED_AD_VIEWER = "native_show_started_ad_viewer";

        @NotNull
        public static final String SHOW_SUCCESS = "native_show_success_time";

        @NotNull
        public static final String SHOW_WV_STARTED = "native_show_wv_started";

        @NotNull
        public static final String SIZE_KB = "size_kb";

        @NotNull
        public static final String STATE = "state";

        @NotNull
        public static final String SYNC = "sync";

        @NotNull
        public static final String SYSTEM_CRONET_FAILURE = "native_cronet_failure_time";

        @NotNull
        public static final String SYSTEM_CRONET_SUCCESS = "native_cronet_success_time";

        @NotNull
        public static final String UNKNOWN = "unknown";

        @NotNull
        public static final String URL = "url";

        @NotNull
        public static final String WEBVIEW_ERROR = "webview_error";

        @NotNull
        public static final String WEBVIEW_ERROR_CODE = "webview_error_code";

        @NotNull
        public static final String WEBVIEW_URL = "webview_url";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: SendDiagnosticEvent.kt */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void invoke$default(SendDiagnosticEvent sendDiagnosticEvent, String str, Double d10, Map map, Map map2, AdObject adObject, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            sendDiagnosticEvent.invoke(str, (i10 & 2) != 0 ? null : d10, (i10 & 4) != 0 ? null : map, (i10 & 8) != 0 ? null : map2, (i10 & 16) != 0 ? null : adObject);
        }
    }

    void invoke(@NotNull String str, @Nullable Double d10, @Nullable Map<String, String> map, @Nullable Map<String, Integer> map2, @Nullable AdObject adObject);
}
