package com.vungle.ads.internal.protos;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class Sdk$SDKError extends GeneratedMessageLite<Sdk$SDKError, a> implements d {
    public static final int AT_FIELD_NUMBER = 1;
    public static final int CONNECTIONTYPEDETAILANDROID_FIELD_NUMBER = 101;
    public static final int CONNECTIONTYPEDETAIL_FIELD_NUMBER = 10;
    public static final int CONNECTIONTYPE_FIELD_NUMBER = 9;
    public static final int CREATIVEID_FIELD_NUMBER = 12;
    private static final Sdk$SDKError DEFAULT_INSTANCE;
    public static final int EVENTID_FIELD_NUMBER = 4;
    public static final int ISHBPLACEMENT_FIELD_NUMBER = 14;
    public static final int MAKE_FIELD_NUMBER = 5;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    public static final int MODEL_FIELD_NUMBER = 6;
    public static final int OSVERSION_FIELD_NUMBER = 8;
    public static final int OS_FIELD_NUMBER = 7;
    private static volatile Parser<Sdk$SDKError> PARSER = null;
    public static final int PLACEMENTREFERENCEID_FIELD_NUMBER = 11;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int SESSIONID_FIELD_NUMBER = 13;
    private long at_;
    private long isHbPlacement_;
    private int reason_;
    private String message_ = "";
    private String eventId_ = "";
    private String make_ = "";
    private String model_ = "";
    private String os_ = "";
    private String osVersion_ = "";
    private String connectionType_ = "";
    private String connectionTypeDetail_ = "";
    private String placementReferenceId_ = "";
    private String creativeId_ = "";
    private String sessionId_ = "";
    private String connectionTypeDetailAndroid_ = "";

    public static final class a extends GeneratedMessageLite.Builder<Sdk$SDKError, a> implements d {
        /* synthetic */ a(com.vungle.ads.internal.protos.a aVar) {
            this();
        }

        public a clearAt() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearAt();
            return this;
        }

        public a clearConnectionType() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearConnectionType();
            return this;
        }

        public a clearConnectionTypeDetail() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearConnectionTypeDetail();
            return this;
        }

        public a clearConnectionTypeDetailAndroid() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearConnectionTypeDetailAndroid();
            return this;
        }

        public a clearCreativeId() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearCreativeId();
            return this;
        }

        public a clearEventId() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearEventId();
            return this;
        }

        public a clearIsHbPlacement() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearIsHbPlacement();
            return this;
        }

        public a clearMake() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearMake();
            return this;
        }

        public a clearMessage() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearMessage();
            return this;
        }

        public a clearModel() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearModel();
            return this;
        }

        public a clearOs() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearOs();
            return this;
        }

        public a clearOsVersion() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearOsVersion();
            return this;
        }

        public a clearPlacementReferenceId() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearPlacementReferenceId();
            return this;
        }

        public a clearReason() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearReason();
            return this;
        }

        public a clearSessionId() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearSessionId();
            return this;
        }

        @Override // com.vungle.ads.internal.protos.d
        public long getAt() {
            return ((Sdk$SDKError) this.instance).getAt();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getConnectionType() {
            return ((Sdk$SDKError) this.instance).getConnectionType();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getConnectionTypeBytes() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getConnectionTypeDetail() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeDetail();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getConnectionTypeDetailAndroid() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeDetailAndroid();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getConnectionTypeDetailAndroidBytes() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeDetailAndroidBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getConnectionTypeDetailBytes() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeDetailBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getCreativeId() {
            return ((Sdk$SDKError) this.instance).getCreativeId();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getCreativeIdBytes() {
            return ((Sdk$SDKError) this.instance).getCreativeIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getEventId() {
            return ((Sdk$SDKError) this.instance).getEventId();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getEventIdBytes() {
            return ((Sdk$SDKError) this.instance).getEventIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public long getIsHbPlacement() {
            return ((Sdk$SDKError) this.instance).getIsHbPlacement();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getMake() {
            return ((Sdk$SDKError) this.instance).getMake();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getMakeBytes() {
            return ((Sdk$SDKError) this.instance).getMakeBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getMessage() {
            return ((Sdk$SDKError) this.instance).getMessage();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getMessageBytes() {
            return ((Sdk$SDKError) this.instance).getMessageBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getModel() {
            return ((Sdk$SDKError) this.instance).getModel();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getModelBytes() {
            return ((Sdk$SDKError) this.instance).getModelBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getOs() {
            return ((Sdk$SDKError) this.instance).getOs();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getOsBytes() {
            return ((Sdk$SDKError) this.instance).getOsBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getOsVersion() {
            return ((Sdk$SDKError) this.instance).getOsVersion();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getOsVersionBytes() {
            return ((Sdk$SDKError) this.instance).getOsVersionBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getPlacementReferenceId() {
            return ((Sdk$SDKError) this.instance).getPlacementReferenceId();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getPlacementReferenceIdBytes() {
            return ((Sdk$SDKError) this.instance).getPlacementReferenceIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public b getReason() {
            return ((Sdk$SDKError) this.instance).getReason();
        }

        @Override // com.vungle.ads.internal.protos.d
        public int getReasonValue() {
            return ((Sdk$SDKError) this.instance).getReasonValue();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getSessionId() {
            return ((Sdk$SDKError) this.instance).getSessionId();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getSessionIdBytes() {
            return ((Sdk$SDKError) this.instance).getSessionIdBytes();
        }

        public a setAt(long j10) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setAt(j10);
            return this;
        }

        public a setConnectionType(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionType(str);
            return this;
        }

        public a setConnectionTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeBytes(byteString);
            return this;
        }

        public a setConnectionTypeDetail(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeDetail(str);
            return this;
        }

        public a setConnectionTypeDetailAndroid(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeDetailAndroid(str);
            return this;
        }

        public a setConnectionTypeDetailAndroidBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeDetailAndroidBytes(byteString);
            return this;
        }

        public a setConnectionTypeDetailBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeDetailBytes(byteString);
            return this;
        }

        public a setCreativeId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setCreativeId(str);
            return this;
        }

        public a setCreativeIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setCreativeIdBytes(byteString);
            return this;
        }

        public a setEventId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setEventId(str);
            return this;
        }

        public a setEventIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setEventIdBytes(byteString);
            return this;
        }

        public a setIsHbPlacement(long j10) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setIsHbPlacement(j10);
            return this;
        }

        public a setMake(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setMake(str);
            return this;
        }

        public a setMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setMakeBytes(byteString);
            return this;
        }

        public a setMessage(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setMessage(str);
            return this;
        }

        public a setMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setMessageBytes(byteString);
            return this;
        }

        public a setModel(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setModel(str);
            return this;
        }

        public a setModelBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setModelBytes(byteString);
            return this;
        }

        public a setOs(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setOs(str);
            return this;
        }

        public a setOsBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setOsBytes(byteString);
            return this;
        }

        public a setOsVersion(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setOsVersion(str);
            return this;
        }

        public a setOsVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setOsVersionBytes(byteString);
            return this;
        }

        public a setPlacementReferenceId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setPlacementReferenceId(str);
            return this;
        }

        public a setPlacementReferenceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setPlacementReferenceIdBytes(byteString);
            return this;
        }

        public a setReason(b bVar) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setReason(bVar);
            return this;
        }

        public a setReasonValue(int i10) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setReasonValue(i10);
            return this;
        }

        public a setSessionId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setSessionId(str);
            return this;
        }

        public a setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private a() {
            super(Sdk$SDKError.DEFAULT_INSTANCE);
        }
    }

    public enum b implements Internal.EnumLite {
        UNKNOWN_ERROR(0),
        INVALID_APP_ID(2),
        CURRENTLY_INITIALIZING(3),
        ALREADY_INITIALIZED(4),
        SDK_NOT_INITIALIZED(6),
        USER_AGENT_ERROR(7),
        API_REQUEST_ERROR(101),
        API_RESPONSE_DATA_ERROR(102),
        API_RESPONSE_DECODE_ERROR(103),
        API_FAILED_STATUS_CODE(104),
        INVALID_TEMPLATE_URL(105),
        INVALID_REQUEST_BUILDER_ERROR(106),
        TEMPLATE_UNZIP_ERROR(109),
        INVALID_CTA_URL(110),
        INVALID_ASSET_URL(111),
        ASSET_REQUEST_ERROR(112),
        ASSET_RESPONSE_DATA_ERROR(113),
        ASSET_WRITE_ERROR(114),
        INVALID_INDEX_URL(115),
        GZIP_ENCODE_ERROR(116),
        ASSET_FAILED_STATUS_CODE(117),
        PROTOBUF_SERIALIZATION_ERROR(118),
        JSON_ENCODE_ERROR(119),
        TPAT_ERROR(121),
        INVALID_ADS_ENDPOINT(122),
        INVALID_RI_ENDPOINT(123),
        INVALID_LOG_ERROR_ENDPOINT(124),
        INVALID_METRICS_ENDPOINT(125),
        ASSET_FAILED_INSUFFICIENT_SPACE(126),
        ASSET_FAILED_MAX_SPACE_EXCEEDED(127),
        INVALID_TPAT_KEY(128),
        EMPTY_TPAT_ERROR(129),
        MRAID_DOWNLOAD_JS_ERROR(130),
        MRAID_JS_WRITE_FAILED(131),
        OMSDK_DOWNLOAD_JS_ERROR(132),
        OMSDK_JS_WRITE_FAILED(133),
        STORE_REGION_CODE_ERROR(134),
        INVALID_CONFIG_RESPONSE(135),
        PRIVACY_URL_ERROR(136),
        TPAT_RETRY_FAILED(137),
        CONFIG_REFRESH_FAILED(138),
        INVALID_EVENT_ID_ERROR(200),
        INVALID_PLACEMENT_ID(201),
        AD_CONSUMED(202),
        AD_IS_LOADING(203),
        AD_ALREADY_LOADED(204),
        AD_IS_PLAYING(205),
        AD_ALREADY_FAILED(206),
        PLACEMENT_AD_TYPE_MISMATCH(207),
        INVALID_BID_PAYLOAD(208),
        INVALID_JSON_BID_PAYLOAD(209),
        AD_NOT_LOADED(210),
        PLACEMENT_SLEEP(212),
        INVALID_ADUNIT_BID_PAYLOAD(213),
        INVALID_GZIP_BID_PAYLOAD(214),
        AD_RESPONSE_EMPTY(215),
        AD_RESPONSE_INVALID_TEMPLATE_TYPE(216),
        AD_RESPONSE_TIMED_OUT(217),
        MRAID_JS_DOES_NOT_EXIST(218),
        MRAID_JS_COPY_FAILED(219),
        AD_RESPONSE_RETRY_AFTER(220),
        AD_LOAD_FAIL_RETRY_AFTER(221),
        INVALID_WATERFALL_PLACEMENT_ID(222),
        STALE_CACHED_RESPONSE(STALE_CACHED_RESPONSE_VALUE),
        AD_NO_FILL(10001),
        AD_LOAD_TOO_FREQUENTLY(10002),
        AD_SERVER_ERROR(AD_SERVER_ERROR_VALUE),
        AD_PUBLISHER_MISMATCH(AD_PUBLISHER_MISMATCH_VALUE),
        AD_INTERNAL_INTEGRATION_ERROR(AD_INTERNAL_INTEGRATION_ERROR_VALUE),
        CONFIG_NOT_FOUND_ERROR(CONFIG_NOT_FOUND_ERROR_VALUE),
        MRAID_ERROR(301),
        INVALID_IFA_STATUS(302),
        AD_EXPIRED(304),
        MRAID_BRIDGE_ERROR(305),
        AD_EXPIRED_ON_PLAY(307),
        AD_WIN_NOTIFICATION_ERROR(308),
        ASSET_FAILED_TO_DELETE(309),
        AD_HTML_FAILED_TO_LOAD(310),
        MRAID_JS_CALL_EMPTY(311),
        DEEPLINK_OPEN_FAILED(312),
        EVALUATE_JAVASCRIPT_FAILED(313),
        LINK_COMMAND_OPEN_FAILED(314),
        JSON_PARAMS_ENCODE_ERROR(315),
        GENERATE_JSON_DATA_ERROR(316),
        AD_CLOSED_TEMPLATE_ERROR(317),
        AD_CLOSED_MISSING_HEARTBEAT(318),
        SILENT_MODE_MONITOR_ERROR(SILENT_MODE_MONITOR_ERROR_VALUE),
        WEBVIEW_ERROR(WEBVIEW_ERROR_VALUE),
        CONCURRENT_PLAYBACK_UNSUPPORTED(400),
        BANNER_VIEW_INVALID_SIZE(500),
        NATIVE_ASSET_ERROR(600),
        WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE(2000),
        WEB_VIEW_FAILED_NAVIGATION(2001),
        STORE_KIT_LOAD_ERROR(2002),
        OMSDK_COPY_ERROR(2003),
        STORE_OVERLAY_LOAD_ERROR(2004),
        REACHABILITY_INITIALIZATION_FAILED(2005),
        UNKNOWN_RADIO_ACCESS_TECHNOLOGY(2006),
        STORE_KIT_PRESENTATION_ERROR(2007),
        STORE_OVERLAY_PRESENTATION_ERROR(2008),
        INVALID_PLAY_PARAMETER(2009),
        OUT_OF_MEMORY(3001),
        UNRECOGNIZED(-1);

        public static final int AD_ALREADY_FAILED_VALUE = 206;
        public static final int AD_ALREADY_LOADED_VALUE = 204;
        public static final int AD_CLOSED_MISSING_HEARTBEAT_VALUE = 318;
        public static final int AD_CLOSED_TEMPLATE_ERROR_VALUE = 317;
        public static final int AD_CONSUMED_VALUE = 202;
        public static final int AD_EXPIRED_ON_PLAY_VALUE = 307;
        public static final int AD_EXPIRED_VALUE = 304;
        public static final int AD_HTML_FAILED_TO_LOAD_VALUE = 310;
        public static final int AD_INTERNAL_INTEGRATION_ERROR_VALUE = 30002;
        public static final int AD_IS_LOADING_VALUE = 203;
        public static final int AD_IS_PLAYING_VALUE = 205;
        public static final int AD_LOAD_FAIL_RETRY_AFTER_VALUE = 221;
        public static final int AD_LOAD_TOO_FREQUENTLY_VALUE = 10002;
        public static final int AD_NOT_LOADED_VALUE = 210;
        public static final int AD_NO_FILL_VALUE = 10001;
        public static final int AD_PUBLISHER_MISMATCH_VALUE = 30001;
        public static final int AD_RESPONSE_EMPTY_VALUE = 215;
        public static final int AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE = 216;
        public static final int AD_RESPONSE_RETRY_AFTER_VALUE = 220;
        public static final int AD_RESPONSE_TIMED_OUT_VALUE = 217;
        public static final int AD_SERVER_ERROR_VALUE = 20001;
        public static final int AD_WIN_NOTIFICATION_ERROR_VALUE = 308;
        public static final int ALREADY_INITIALIZED_VALUE = 4;
        public static final int API_FAILED_STATUS_CODE_VALUE = 104;
        public static final int API_REQUEST_ERROR_VALUE = 101;
        public static final int API_RESPONSE_DATA_ERROR_VALUE = 102;
        public static final int API_RESPONSE_DECODE_ERROR_VALUE = 103;
        public static final int ASSET_FAILED_INSUFFICIENT_SPACE_VALUE = 126;
        public static final int ASSET_FAILED_MAX_SPACE_EXCEEDED_VALUE = 127;
        public static final int ASSET_FAILED_STATUS_CODE_VALUE = 117;
        public static final int ASSET_FAILED_TO_DELETE_VALUE = 309;
        public static final int ASSET_REQUEST_ERROR_VALUE = 112;
        public static final int ASSET_RESPONSE_DATA_ERROR_VALUE = 113;
        public static final int ASSET_WRITE_ERROR_VALUE = 114;
        public static final int BANNER_VIEW_INVALID_SIZE_VALUE = 500;
        public static final int CONCURRENT_PLAYBACK_UNSUPPORTED_VALUE = 400;
        public static final int CONFIG_NOT_FOUND_ERROR_VALUE = 30003;
        public static final int CONFIG_REFRESH_FAILED_VALUE = 138;
        public static final int CURRENTLY_INITIALIZING_VALUE = 3;
        public static final int DEEPLINK_OPEN_FAILED_VALUE = 312;
        public static final int EMPTY_TPAT_ERROR_VALUE = 129;
        public static final int EVALUATE_JAVASCRIPT_FAILED_VALUE = 313;
        public static final int GENERATE_JSON_DATA_ERROR_VALUE = 316;
        public static final int GZIP_ENCODE_ERROR_VALUE = 116;
        public static final int INVALID_ADS_ENDPOINT_VALUE = 122;
        public static final int INVALID_ADUNIT_BID_PAYLOAD_VALUE = 213;
        public static final int INVALID_APP_ID_VALUE = 2;
        public static final int INVALID_ASSET_URL_VALUE = 111;
        public static final int INVALID_BID_PAYLOAD_VALUE = 208;
        public static final int INVALID_CONFIG_RESPONSE_VALUE = 135;
        public static final int INVALID_CTA_URL_VALUE = 110;
        public static final int INVALID_EVENT_ID_ERROR_VALUE = 200;
        public static final int INVALID_GZIP_BID_PAYLOAD_VALUE = 214;
        public static final int INVALID_IFA_STATUS_VALUE = 302;
        public static final int INVALID_INDEX_URL_VALUE = 115;
        public static final int INVALID_JSON_BID_PAYLOAD_VALUE = 209;
        public static final int INVALID_LOG_ERROR_ENDPOINT_VALUE = 124;
        public static final int INVALID_METRICS_ENDPOINT_VALUE = 125;
        public static final int INVALID_PLACEMENT_ID_VALUE = 201;
        public static final int INVALID_PLAY_PARAMETER_VALUE = 2009;
        public static final int INVALID_REQUEST_BUILDER_ERROR_VALUE = 106;
        public static final int INVALID_RI_ENDPOINT_VALUE = 123;
        public static final int INVALID_TEMPLATE_URL_VALUE = 105;
        public static final int INVALID_TPAT_KEY_VALUE = 128;
        public static final int INVALID_WATERFALL_PLACEMENT_ID_VALUE = 222;
        public static final int JSON_ENCODE_ERROR_VALUE = 119;
        public static final int JSON_PARAMS_ENCODE_ERROR_VALUE = 315;
        public static final int LINK_COMMAND_OPEN_FAILED_VALUE = 314;
        public static final int MRAID_BRIDGE_ERROR_VALUE = 305;
        public static final int MRAID_DOWNLOAD_JS_ERROR_VALUE = 130;
        public static final int MRAID_ERROR_VALUE = 301;
        public static final int MRAID_JS_CALL_EMPTY_VALUE = 311;
        public static final int MRAID_JS_COPY_FAILED_VALUE = 219;
        public static final int MRAID_JS_DOES_NOT_EXIST_VALUE = 218;
        public static final int MRAID_JS_WRITE_FAILED_VALUE = 131;
        public static final int NATIVE_ASSET_ERROR_VALUE = 600;
        public static final int OMSDK_COPY_ERROR_VALUE = 2003;
        public static final int OMSDK_DOWNLOAD_JS_ERROR_VALUE = 132;
        public static final int OMSDK_JS_WRITE_FAILED_VALUE = 133;
        public static final int OUT_OF_MEMORY_VALUE = 3001;
        public static final int PLACEMENT_AD_TYPE_MISMATCH_VALUE = 207;
        public static final int PLACEMENT_SLEEP_VALUE = 212;
        public static final int PRIVACY_URL_ERROR_VALUE = 136;
        public static final int PROTOBUF_SERIALIZATION_ERROR_VALUE = 118;
        public static final int REACHABILITY_INITIALIZATION_FAILED_VALUE = 2005;
        public static final int SDK_NOT_INITIALIZED_VALUE = 6;
        public static final int SILENT_MODE_MONITOR_ERROR_VALUE = 319;
        public static final int STALE_CACHED_RESPONSE_VALUE = 223;
        public static final int STORE_KIT_LOAD_ERROR_VALUE = 2002;
        public static final int STORE_KIT_PRESENTATION_ERROR_VALUE = 2007;
        public static final int STORE_OVERLAY_LOAD_ERROR_VALUE = 2004;
        public static final int STORE_OVERLAY_PRESENTATION_ERROR_VALUE = 2008;
        public static final int STORE_REGION_CODE_ERROR_VALUE = 134;
        public static final int TEMPLATE_UNZIP_ERROR_VALUE = 109;
        public static final int TPAT_ERROR_VALUE = 121;
        public static final int TPAT_RETRY_FAILED_VALUE = 137;
        public static final int UNKNOWN_ERROR_VALUE = 0;
        public static final int UNKNOWN_RADIO_ACCESS_TECHNOLOGY_VALUE = 2006;
        public static final int USER_AGENT_ERROR_VALUE = 7;
        public static final int WEBVIEW_ERROR_VALUE = 320;
        public static final int WEB_VIEW_FAILED_NAVIGATION_VALUE = 2001;
        public static final int WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE_VALUE = 2000;
        private static final Internal.EnumLiteMap<b> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap<b> {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            public b findValueByNumber(int i10) {
                return b.forNumber(i10);
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.protos.Sdk$SDKError$b$b, reason: collision with other inner class name */
        private static final class C0527b implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new C0527b();

            private C0527b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i10) {
                return b.forNumber(i10) != null;
            }
        }

        b(int i10) {
            this.value = i10;
        }

        public static b forNumber(int i10) {
            if (i10 != 0) {
                if (i10 == 2) {
                    return INVALID_APP_ID;
                }
                if (i10 == 3) {
                    return CURRENTLY_INITIALIZING;
                }
                if (i10 == 4) {
                    return ALREADY_INITIALIZED;
                }
                if (i10 == 6) {
                    return SDK_NOT_INITIALIZED;
                }
                if (i10 == 7) {
                    return USER_AGENT_ERROR;
                }
                if (i10 == 301) {
                    return MRAID_ERROR;
                }
                if (i10 == 302) {
                    return INVALID_IFA_STATUS;
                }
                if (i10 == 304) {
                    return AD_EXPIRED;
                }
                if (i10 == 305) {
                    return MRAID_BRIDGE_ERROR;
                }
                switch (i10) {
                    case 0:
                        break;
                    case 121:
                        return TPAT_ERROR;
                    case 122:
                        return INVALID_ADS_ENDPOINT;
                    case 123:
                        return INVALID_RI_ENDPOINT;
                    case 124:
                        return INVALID_LOG_ERROR_ENDPOINT;
                    case 125:
                        return INVALID_METRICS_ENDPOINT;
                    case 126:
                        return ASSET_FAILED_INSUFFICIENT_SPACE;
                    case 127:
                        return ASSET_FAILED_MAX_SPACE_EXCEEDED;
                    case 128:
                        return INVALID_TPAT_KEY;
                    case 129:
                        return EMPTY_TPAT_ERROR;
                    case 130:
                        return MRAID_DOWNLOAD_JS_ERROR;
                    case 131:
                        return MRAID_JS_WRITE_FAILED;
                    case 132:
                        return OMSDK_DOWNLOAD_JS_ERROR;
                    case 133:
                        return OMSDK_JS_WRITE_FAILED;
                    case 134:
                        return STORE_REGION_CODE_ERROR;
                    case 135:
                        return INVALID_CONFIG_RESPONSE;
                    case 136:
                        return PRIVACY_URL_ERROR;
                    case 137:
                        return TPAT_RETRY_FAILED;
                    case 138:
                        return CONFIG_REFRESH_FAILED;
                    case 400:
                        return CONCURRENT_PLAYBACK_UNSUPPORTED;
                    case 500:
                        return BANNER_VIEW_INVALID_SIZE;
                    case 600:
                        return NATIVE_ASSET_ERROR;
                    case 2000:
                        return WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE;
                    case 2001:
                        return WEB_VIEW_FAILED_NAVIGATION;
                    case 2002:
                        return STORE_KIT_LOAD_ERROR;
                    case 2003:
                        return OMSDK_COPY_ERROR;
                    case 2004:
                        return STORE_OVERLAY_LOAD_ERROR;
                    case 2005:
                        return REACHABILITY_INITIALIZATION_FAILED;
                    case 2006:
                        return UNKNOWN_RADIO_ACCESS_TECHNOLOGY;
                    case 2007:
                        return STORE_KIT_PRESENTATION_ERROR;
                    case 2008:
                        return STORE_OVERLAY_PRESENTATION_ERROR;
                    case 2009:
                        return INVALID_PLAY_PARAMETER;
                    case 3001:
                        return OUT_OF_MEMORY;
                    case 10001:
                        return AD_NO_FILL;
                    case 10002:
                        return AD_LOAD_TOO_FREQUENTLY;
                    case AD_SERVER_ERROR_VALUE:
                        return AD_SERVER_ERROR;
                    case AD_PUBLISHER_MISMATCH_VALUE:
                        return AD_PUBLISHER_MISMATCH;
                    case AD_INTERNAL_INTEGRATION_ERROR_VALUE:
                        return AD_INTERNAL_INTEGRATION_ERROR;
                    case CONFIG_NOT_FOUND_ERROR_VALUE:
                        return CONFIG_NOT_FOUND_ERROR;
                    default:
                        switch (i10) {
                            case 101:
                                return API_REQUEST_ERROR;
                            case 102:
                                return API_RESPONSE_DATA_ERROR;
                            case 103:
                                return API_RESPONSE_DECODE_ERROR;
                            case 104:
                                return API_FAILED_STATUS_CODE;
                            case 105:
                                return INVALID_TEMPLATE_URL;
                            case 106:
                                return INVALID_REQUEST_BUILDER_ERROR;
                            default:
                                switch (i10) {
                                    case 109:
                                        return TEMPLATE_UNZIP_ERROR;
                                    case 110:
                                        return INVALID_CTA_URL;
                                    case 111:
                                        return INVALID_ASSET_URL;
                                    case 112:
                                        return ASSET_REQUEST_ERROR;
                                    case 113:
                                        return ASSET_RESPONSE_DATA_ERROR;
                                    case 114:
                                        return ASSET_WRITE_ERROR;
                                    case 115:
                                        return INVALID_INDEX_URL;
                                    case 116:
                                        return GZIP_ENCODE_ERROR;
                                    case 117:
                                        return ASSET_FAILED_STATUS_CODE;
                                    case 118:
                                        return PROTOBUF_SERIALIZATION_ERROR;
                                    case 119:
                                        return JSON_ENCODE_ERROR;
                                    default:
                                        switch (i10) {
                                            case 200:
                                                return INVALID_EVENT_ID_ERROR;
                                            case 201:
                                                return INVALID_PLACEMENT_ID;
                                            case 202:
                                                return AD_CONSUMED;
                                            case 203:
                                                return AD_IS_LOADING;
                                            case 204:
                                                return AD_ALREADY_LOADED;
                                            case 205:
                                                return AD_IS_PLAYING;
                                            case 206:
                                                return AD_ALREADY_FAILED;
                                            case 207:
                                                return PLACEMENT_AD_TYPE_MISMATCH;
                                            case 208:
                                                return INVALID_BID_PAYLOAD;
                                            case 209:
                                                return INVALID_JSON_BID_PAYLOAD;
                                            case 210:
                                                return AD_NOT_LOADED;
                                            default:
                                                switch (i10) {
                                                    case 212:
                                                        return PLACEMENT_SLEEP;
                                                    case 213:
                                                        return INVALID_ADUNIT_BID_PAYLOAD;
                                                    case 214:
                                                        return INVALID_GZIP_BID_PAYLOAD;
                                                    case 215:
                                                        return AD_RESPONSE_EMPTY;
                                                    case 216:
                                                        return AD_RESPONSE_INVALID_TEMPLATE_TYPE;
                                                    case 217:
                                                        return AD_RESPONSE_TIMED_OUT;
                                                    case 218:
                                                        return MRAID_JS_DOES_NOT_EXIST;
                                                    case 219:
                                                        return MRAID_JS_COPY_FAILED;
                                                    case 220:
                                                        return AD_RESPONSE_RETRY_AFTER;
                                                    case 221:
                                                        return AD_LOAD_FAIL_RETRY_AFTER;
                                                    case 222:
                                                        return INVALID_WATERFALL_PLACEMENT_ID;
                                                    case STALE_CACHED_RESPONSE_VALUE:
                                                        return STALE_CACHED_RESPONSE;
                                                    default:
                                                        switch (i10) {
                                                            case 307:
                                                                return AD_EXPIRED_ON_PLAY;
                                                            case 308:
                                                                return AD_WIN_NOTIFICATION_ERROR;
                                                            case 309:
                                                                return ASSET_FAILED_TO_DELETE;
                                                            case 310:
                                                                return AD_HTML_FAILED_TO_LOAD;
                                                            case 311:
                                                                return MRAID_JS_CALL_EMPTY;
                                                            case 312:
                                                                return DEEPLINK_OPEN_FAILED;
                                                            case 313:
                                                                return EVALUATE_JAVASCRIPT_FAILED;
                                                            case 314:
                                                                return LINK_COMMAND_OPEN_FAILED;
                                                            case 315:
                                                                return JSON_PARAMS_ENCODE_ERROR;
                                                            case 316:
                                                                return GENERATE_JSON_DATA_ERROR;
                                                            case 317:
                                                                return AD_CLOSED_TEMPLATE_ERROR;
                                                            case 318:
                                                                return AD_CLOSED_MISSING_HEARTBEAT;
                                                            case SILENT_MODE_MONITOR_ERROR_VALUE:
                                                                return SILENT_MODE_MONITOR_ERROR;
                                                            case WEBVIEW_ERROR_VALUE:
                                                                return WEBVIEW_ERROR;
                                                            default:
                                                                return null;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            }
            return UNKNOWN_ERROR;
        }

        public static Internal.EnumLiteMap<b> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return C0527b.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static b valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        Sdk$SDKError sdk$SDKError = new Sdk$SDKError();
        DEFAULT_INSTANCE = sdk$SDKError;
        GeneratedMessageLite.registerDefaultInstance(Sdk$SDKError.class, sdk$SDKError);
    }

    private Sdk$SDKError() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAt() {
        this.at_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionType() {
        this.connectionType_ = getDefaultInstance().getConnectionType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionTypeDetail() {
        this.connectionTypeDetail_ = getDefaultInstance().getConnectionTypeDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionTypeDetailAndroid() {
        this.connectionTypeDetailAndroid_ = getDefaultInstance().getConnectionTypeDetailAndroid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreativeId() {
        this.creativeId_ = getDefaultInstance().getCreativeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventId() {
        this.eventId_ = getDefaultInstance().getEventId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsHbPlacement() {
        this.isHbPlacement_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMake() {
        this.make_ = getDefaultInstance().getMake();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModel() {
        this.model_ = getDefaultInstance().getModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOs() {
        this.os_ = getDefaultInstance().getOs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOsVersion() {
        this.osVersion_ = getDefaultInstance().getOsVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlacementReferenceId() {
        this.placementReferenceId_ = getDefaultInstance().getPlacementReferenceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static Sdk$SDKError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Sdk$SDKError parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKError parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Sdk$SDKError> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAt(long j10) {
        this.at_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionType(String str) {
        str.getClass();
        this.connectionType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.connectionType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeDetail(String str) {
        str.getClass();
        this.connectionTypeDetail_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeDetailAndroid(String str) {
        str.getClass();
        this.connectionTypeDetailAndroid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeDetailAndroidBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.connectionTypeDetailAndroid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeDetailBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.connectionTypeDetail_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreativeId(String str) {
        str.getClass();
        this.creativeId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreativeIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.creativeId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventId(String str) {
        str.getClass();
        this.eventId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.eventId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsHbPlacement(long j10) {
        this.isHbPlacement_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMake(String str) {
        str.getClass();
        this.make_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.make_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.message_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModel(String str) {
        str.getClass();
        this.model_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.model_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOs(String str) {
        str.getClass();
        this.os_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.os_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsVersion(String str) {
        str.getClass();
        this.osVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsVersionBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.osVersion_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlacementReferenceId(String str) {
        str.getClass();
        this.placementReferenceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlacementReferenceIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.placementReferenceId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(b bVar) {
        this.reason_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReasonValue(int i10) {
        this.reason_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.vungle.ads.internal.protos.a aVar = null;
        switch (com.vungle.ads.internal.protos.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$SDKError();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0000\u0001e\u000f\u0000\u0000\u0000\u0001\u0002\u0002\f\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\rȈ\u000e\u0002eȈ", new Object[]{"at_", "reason_", "message_", "eventId_", "make_", "model_", "os_", "osVersion_", "connectionType_", "connectionTypeDetail_", "placementReferenceId_", "creativeId_", "sessionId_", "isHbPlacement_", "connectionTypeDetailAndroid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Sdk$SDKError> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (Sdk$SDKError.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.vungle.ads.internal.protos.d
    public long getAt() {
        return this.at_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getConnectionType() {
        return this.connectionType_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getConnectionTypeBytes() {
        return ByteString.copyFromUtf8(this.connectionType_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getConnectionTypeDetail() {
        return this.connectionTypeDetail_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getConnectionTypeDetailAndroid() {
        return this.connectionTypeDetailAndroid_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getConnectionTypeDetailAndroidBytes() {
        return ByteString.copyFromUtf8(this.connectionTypeDetailAndroid_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getConnectionTypeDetailBytes() {
        return ByteString.copyFromUtf8(this.connectionTypeDetail_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getCreativeId() {
        return this.creativeId_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getCreativeIdBytes() {
        return ByteString.copyFromUtf8(this.creativeId_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getEventId() {
        return this.eventId_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getEventIdBytes() {
        return ByteString.copyFromUtf8(this.eventId_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public long getIsHbPlacement() {
        return this.isHbPlacement_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getMake() {
        return this.make_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getMakeBytes() {
        return ByteString.copyFromUtf8(this.make_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getMessage() {
        return this.message_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getModel() {
        return this.model_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getModelBytes() {
        return ByteString.copyFromUtf8(this.model_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getOs() {
        return this.os_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getOsBytes() {
        return ByteString.copyFromUtf8(this.os_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getOsVersion() {
        return this.osVersion_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getOsVersionBytes() {
        return ByteString.copyFromUtf8(this.osVersion_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getPlacementReferenceId() {
        return this.placementReferenceId_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getPlacementReferenceIdBytes() {
        return ByteString.copyFromUtf8(this.placementReferenceId_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public b getReason() {
        b bVarForNumber = b.forNumber(this.reason_);
        return bVarForNumber == null ? b.UNRECOGNIZED : bVarForNumber;
    }

    @Override // com.vungle.ads.internal.protos.d
    public int getReasonValue() {
        return this.reason_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public static a newBuilder(Sdk$SDKError sdk$SDKError) {
        return DEFAULT_INSTANCE.createBuilder(sdk$SDKError);
    }

    public static Sdk$SDKError parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Sdk$SDKError parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$SDKError parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKError parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Sdk$SDKError parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
