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
public final class Sdk$SDKMetric extends GeneratedMessageLite<Sdk$SDKMetric, a> implements e {
    public static final int CONNECTIONTYPEDETAIL_FIELD_NUMBER = 9;
    public static final int CONNECTIONTYPE_FIELD_NUMBER = 8;
    public static final int CREATIVEID_FIELD_NUMBER = 11;
    private static final Sdk$SDKMetric DEFAULT_INSTANCE;
    public static final int EVENTID_FIELD_NUMBER = 12;
    public static final int ISHBPLACEMENT_FIELD_NUMBER = 14;
    public static final int MAKE_FIELD_NUMBER = 4;
    public static final int META_FIELD_NUMBER = 3;
    public static final int MODEL_FIELD_NUMBER = 5;
    public static final int OSVERSION_FIELD_NUMBER = 7;
    public static final int OS_FIELD_NUMBER = 6;
    private static volatile Parser<Sdk$SDKMetric> PARSER = null;
    public static final int PLACEMENTREFERENCEID_FIELD_NUMBER = 10;
    public static final int SESSIONID_FIELD_NUMBER = 13;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private long isHbPlacement_;
    private int type_;
    private long value_;
    private String meta_ = "";
    private String make_ = "";
    private String model_ = "";
    private String os_ = "";
    private String osVersion_ = "";
    private String connectionType_ = "";
    private String connectionTypeDetail_ = "";
    private String placementReferenceId_ = "";
    private String creativeId_ = "";
    private String eventId_ = "";
    private String sessionId_ = "";

    public static final class a extends GeneratedMessageLite.Builder<Sdk$SDKMetric, a> implements e {
        /* synthetic */ a(com.vungle.ads.internal.protos.a aVar) {
            this();
        }

        public a clearConnectionType() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearConnectionType();
            return this;
        }

        public a clearConnectionTypeDetail() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearConnectionTypeDetail();
            return this;
        }

        public a clearCreativeId() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearCreativeId();
            return this;
        }

        public a clearEventId() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearEventId();
            return this;
        }

        public a clearIsHbPlacement() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearIsHbPlacement();
            return this;
        }

        public a clearMake() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearMake();
            return this;
        }

        public a clearMeta() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearMeta();
            return this;
        }

        public a clearModel() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearModel();
            return this;
        }

        public a clearOs() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearOs();
            return this;
        }

        public a clearOsVersion() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearOsVersion();
            return this;
        }

        public a clearPlacementReferenceId() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearPlacementReferenceId();
            return this;
        }

        public a clearSessionId() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearSessionId();
            return this;
        }

        public a clearType() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearType();
            return this;
        }

        public a clearValue() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearValue();
            return this;
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getConnectionType() {
            return ((Sdk$SDKMetric) this.instance).getConnectionType();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getConnectionTypeBytes() {
            return ((Sdk$SDKMetric) this.instance).getConnectionTypeBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getConnectionTypeDetail() {
            return ((Sdk$SDKMetric) this.instance).getConnectionTypeDetail();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getConnectionTypeDetailBytes() {
            return ((Sdk$SDKMetric) this.instance).getConnectionTypeDetailBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getCreativeId() {
            return ((Sdk$SDKMetric) this.instance).getCreativeId();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getCreativeIdBytes() {
            return ((Sdk$SDKMetric) this.instance).getCreativeIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getEventId() {
            return ((Sdk$SDKMetric) this.instance).getEventId();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getEventIdBytes() {
            return ((Sdk$SDKMetric) this.instance).getEventIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public long getIsHbPlacement() {
            return ((Sdk$SDKMetric) this.instance).getIsHbPlacement();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getMake() {
            return ((Sdk$SDKMetric) this.instance).getMake();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getMakeBytes() {
            return ((Sdk$SDKMetric) this.instance).getMakeBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getMeta() {
            return ((Sdk$SDKMetric) this.instance).getMeta();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getMetaBytes() {
            return ((Sdk$SDKMetric) this.instance).getMetaBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getModel() {
            return ((Sdk$SDKMetric) this.instance).getModel();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getModelBytes() {
            return ((Sdk$SDKMetric) this.instance).getModelBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getOs() {
            return ((Sdk$SDKMetric) this.instance).getOs();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getOsBytes() {
            return ((Sdk$SDKMetric) this.instance).getOsBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getOsVersion() {
            return ((Sdk$SDKMetric) this.instance).getOsVersion();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getOsVersionBytes() {
            return ((Sdk$SDKMetric) this.instance).getOsVersionBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getPlacementReferenceId() {
            return ((Sdk$SDKMetric) this.instance).getPlacementReferenceId();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getPlacementReferenceIdBytes() {
            return ((Sdk$SDKMetric) this.instance).getPlacementReferenceIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getSessionId() {
            return ((Sdk$SDKMetric) this.instance).getSessionId();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getSessionIdBytes() {
            return ((Sdk$SDKMetric) this.instance).getSessionIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public b getType() {
            return ((Sdk$SDKMetric) this.instance).getType();
        }

        @Override // com.vungle.ads.internal.protos.e
        public int getTypeValue() {
            return ((Sdk$SDKMetric) this.instance).getTypeValue();
        }

        @Override // com.vungle.ads.internal.protos.e
        public long getValue() {
            return ((Sdk$SDKMetric) this.instance).getValue();
        }

        public a setConnectionType(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setConnectionType(str);
            return this;
        }

        public a setConnectionTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setConnectionTypeBytes(byteString);
            return this;
        }

        public a setConnectionTypeDetail(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setConnectionTypeDetail(str);
            return this;
        }

        public a setConnectionTypeDetailBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setConnectionTypeDetailBytes(byteString);
            return this;
        }

        public a setCreativeId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setCreativeId(str);
            return this;
        }

        public a setCreativeIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setCreativeIdBytes(byteString);
            return this;
        }

        public a setEventId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setEventId(str);
            return this;
        }

        public a setEventIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setEventIdBytes(byteString);
            return this;
        }

        public a setIsHbPlacement(long j10) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setIsHbPlacement(j10);
            return this;
        }

        public a setMake(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setMake(str);
            return this;
        }

        public a setMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setMakeBytes(byteString);
            return this;
        }

        public a setMeta(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setMeta(str);
            return this;
        }

        public a setMetaBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setMetaBytes(byteString);
            return this;
        }

        public a setModel(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setModel(str);
            return this;
        }

        public a setModelBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setModelBytes(byteString);
            return this;
        }

        public a setOs(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setOs(str);
            return this;
        }

        public a setOsBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setOsBytes(byteString);
            return this;
        }

        public a setOsVersion(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setOsVersion(str);
            return this;
        }

        public a setOsVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setOsVersionBytes(byteString);
            return this;
        }

        public a setPlacementReferenceId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setPlacementReferenceId(str);
            return this;
        }

        public a setPlacementReferenceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setPlacementReferenceIdBytes(byteString);
            return this;
        }

        public a setSessionId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setSessionId(str);
            return this;
        }

        public a setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public a setType(b bVar) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setType(bVar);
            return this;
        }

        public a setTypeValue(int i10) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setTypeValue(i10);
            return this;
        }

        public a setValue(long j10) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setValue(j10);
            return this;
        }

        private a() {
            super(Sdk$SDKMetric.DEFAULT_INSTANCE);
        }
    }

    public enum b implements Internal.EnumLite {
        UNKNOWN_METRIC_TYPE(0),
        AD_REQUEST_TO_RESPONSE_DURATION_MS(1),
        AD_RESPONSE_TO_SHOW_DURATION_MS(2),
        AD_SHOW_TO_DISPLAY_DURATION_MS(3),
        AD_DISPLAY_TO_CLICK_DURATION_MS(4),
        IOS_STORE_KIT_LOAD_TIME_MS(5),
        INIT_REQUEST_TO_RESPONSE_DURATION_MS(6),
        ASSET_DOWNLOAD_DURATION_MS(7),
        LOCAL_ASSETS_USED(8),
        REMOTE_ASSETS_USED(9),
        TEMPLATE_DOWNLOAD_DURATION_MS(10),
        AD_REQUEST_TO_CALLBACK_DURATION_MS(11),
        AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS(12),
        ASSET_FILE_SIZE(13),
        USER_AGENT_LOAD_DURATION_MS(14),
        TEMPLATE_ZIP_SIZE(15),
        CACHED_ASSETS_USED(16),
        LOAD_AD_API(17),
        TPAT_FIRED(18),
        TPAT_SUCCESS(19),
        WIN_NOTIF_FIRED(20),
        WIN_NOTIF_SUCCESS(21),
        AD_EXPIRED_BEFORE_PLAY(22),
        PLAY_AD_API(23),
        AD_LOAD_FAIL(24),
        VIEW_NOT_VISIBLE_ON_PLAY(25),
        MRAID_DOWNLOAD_JS_RETRY_SUCCESS(26),
        OMSDK_DOWNLOAD_JS_RETRY_SUCCESS(27),
        PRIVACY_URL_OPENED(28),
        NOTIFICATION_REDIRECT(29),
        AD_PLAY_RESET_ON_DEINIT(30),
        TEMPLATE_HTML_SIZE(31),
        CONFIG_LOADED_FROM_INIT(32),
        CONFIG_LOADED_FROM_AD_LOAD(33),
        CONFIG_LOADED_FROM_ADM_LOAD(34),
        AD_SHOW_TO_PRESENT_DURATION_MS(35),
        AD_SHOW_TO_FAIL_DURATION_MS(36),
        AD_PRESENT_TO_DISPLAY_DURATION_MS(37),
        SKOVERLAY_PRESENTED_FOR_AD(2000),
        SAFARI_PRESENTED_FOR_AD(2001),
        STORE_KIT_PRESENTED_FOR_AD(2002),
        STORE_KIT_NOT_READY(2003),
        LAUNCH_STORE_KIT_REQUEST(2004),
        LAUNCH_SKOVERLAY_REQUEST(2005),
        LAUNCH_SAFARI_REQUEST(2006),
        IDFV_RESTRICTED(2007),
        NOTIFICATION_WAIT_FOR_CONNECTIVITY(2008),
        IDFV_VALUE_CHANGED(2009),
        HARDWARE_ACCELERATE_DISABLED(3001),
        BANNER_AUTO_REDIRECT(3002),
        UNRECOGNIZED(-1);

        public static final int AD_DISPLAY_TO_CLICK_DURATION_MS_VALUE = 4;

        @Deprecated
        public static final int AD_EXPIRED_BEFORE_PLAY_VALUE = 22;
        public static final int AD_LOAD_FAIL_VALUE = 24;
        public static final int AD_PLAY_RESET_ON_DEINIT_VALUE = 30;
        public static final int AD_PRESENT_TO_DISPLAY_DURATION_MS_VALUE = 37;
        public static final int AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS_VALUE = 12;
        public static final int AD_REQUEST_TO_CALLBACK_DURATION_MS_VALUE = 11;
        public static final int AD_REQUEST_TO_RESPONSE_DURATION_MS_VALUE = 1;
        public static final int AD_RESPONSE_TO_SHOW_DURATION_MS_VALUE = 2;
        public static final int AD_SHOW_TO_DISPLAY_DURATION_MS_VALUE = 3;
        public static final int AD_SHOW_TO_FAIL_DURATION_MS_VALUE = 36;
        public static final int AD_SHOW_TO_PRESENT_DURATION_MS_VALUE = 35;
        public static final int ASSET_DOWNLOAD_DURATION_MS_VALUE = 7;
        public static final int ASSET_FILE_SIZE_VALUE = 13;
        public static final int BANNER_AUTO_REDIRECT_VALUE = 3002;
        public static final int CACHED_ASSETS_USED_VALUE = 16;
        public static final int CONFIG_LOADED_FROM_ADM_LOAD_VALUE = 34;
        public static final int CONFIG_LOADED_FROM_AD_LOAD_VALUE = 33;
        public static final int CONFIG_LOADED_FROM_INIT_VALUE = 32;
        public static final int HARDWARE_ACCELERATE_DISABLED_VALUE = 3001;
        public static final int IDFV_RESTRICTED_VALUE = 2007;
        public static final int IDFV_VALUE_CHANGED_VALUE = 2009;
        public static final int INIT_REQUEST_TO_RESPONSE_DURATION_MS_VALUE = 6;
        public static final int IOS_STORE_KIT_LOAD_TIME_MS_VALUE = 5;
        public static final int LAUNCH_SAFARI_REQUEST_VALUE = 2006;
        public static final int LAUNCH_SKOVERLAY_REQUEST_VALUE = 2005;
        public static final int LAUNCH_STORE_KIT_REQUEST_VALUE = 2004;
        public static final int LOAD_AD_API_VALUE = 17;
        public static final int LOCAL_ASSETS_USED_VALUE = 8;
        public static final int MRAID_DOWNLOAD_JS_RETRY_SUCCESS_VALUE = 26;
        public static final int NOTIFICATION_REDIRECT_VALUE = 29;
        public static final int NOTIFICATION_WAIT_FOR_CONNECTIVITY_VALUE = 2008;
        public static final int OMSDK_DOWNLOAD_JS_RETRY_SUCCESS_VALUE = 27;
        public static final int PLAY_AD_API_VALUE = 23;
        public static final int PRIVACY_URL_OPENED_VALUE = 28;
        public static final int REMOTE_ASSETS_USED_VALUE = 9;
        public static final int SAFARI_PRESENTED_FOR_AD_VALUE = 2001;
        public static final int SKOVERLAY_PRESENTED_FOR_AD_VALUE = 2000;
        public static final int STORE_KIT_NOT_READY_VALUE = 2003;
        public static final int STORE_KIT_PRESENTED_FOR_AD_VALUE = 2002;
        public static final int TEMPLATE_DOWNLOAD_DURATION_MS_VALUE = 10;
        public static final int TEMPLATE_HTML_SIZE_VALUE = 31;
        public static final int TEMPLATE_ZIP_SIZE_VALUE = 15;
        public static final int TPAT_FIRED_VALUE = 18;
        public static final int TPAT_SUCCESS_VALUE = 19;
        public static final int UNKNOWN_METRIC_TYPE_VALUE = 0;
        public static final int USER_AGENT_LOAD_DURATION_MS_VALUE = 14;
        public static final int VIEW_NOT_VISIBLE_ON_PLAY_VALUE = 25;
        public static final int WIN_NOTIF_FIRED_VALUE = 20;
        public static final int WIN_NOTIF_SUCCESS_VALUE = 21;
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

        /* JADX INFO: renamed from: com.vungle.ads.internal.protos.Sdk$SDKMetric$b$b, reason: collision with other inner class name */
        private static final class C0528b implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new C0528b();

            private C0528b() {
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
            if (i10 == 3001) {
                return HARDWARE_ACCELERATE_DISABLED;
            }
            if (i10 == 3002) {
                return BANNER_AUTO_REDIRECT;
            }
            switch (i10) {
                case 0:
                    return UNKNOWN_METRIC_TYPE;
                case 1:
                    return AD_REQUEST_TO_RESPONSE_DURATION_MS;
                case 2:
                    return AD_RESPONSE_TO_SHOW_DURATION_MS;
                case 3:
                    return AD_SHOW_TO_DISPLAY_DURATION_MS;
                case 4:
                    return AD_DISPLAY_TO_CLICK_DURATION_MS;
                case 5:
                    return IOS_STORE_KIT_LOAD_TIME_MS;
                case 6:
                    return INIT_REQUEST_TO_RESPONSE_DURATION_MS;
                case 7:
                    return ASSET_DOWNLOAD_DURATION_MS;
                case 8:
                    return LOCAL_ASSETS_USED;
                case 9:
                    return REMOTE_ASSETS_USED;
                case 10:
                    return TEMPLATE_DOWNLOAD_DURATION_MS;
                case 11:
                    return AD_REQUEST_TO_CALLBACK_DURATION_MS;
                case 12:
                    return AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS;
                case 13:
                    return ASSET_FILE_SIZE;
                case 14:
                    return USER_AGENT_LOAD_DURATION_MS;
                case 15:
                    return TEMPLATE_ZIP_SIZE;
                case 16:
                    return CACHED_ASSETS_USED;
                case 17:
                    return LOAD_AD_API;
                case 18:
                    return TPAT_FIRED;
                case 19:
                    return TPAT_SUCCESS;
                case 20:
                    return WIN_NOTIF_FIRED;
                case 21:
                    return WIN_NOTIF_SUCCESS;
                case 22:
                    return AD_EXPIRED_BEFORE_PLAY;
                case 23:
                    return PLAY_AD_API;
                case 24:
                    return AD_LOAD_FAIL;
                case 25:
                    return VIEW_NOT_VISIBLE_ON_PLAY;
                case 26:
                    return MRAID_DOWNLOAD_JS_RETRY_SUCCESS;
                case 27:
                    return OMSDK_DOWNLOAD_JS_RETRY_SUCCESS;
                case 28:
                    return PRIVACY_URL_OPENED;
                case 29:
                    return NOTIFICATION_REDIRECT;
                case 30:
                    return AD_PLAY_RESET_ON_DEINIT;
                case 31:
                    return TEMPLATE_HTML_SIZE;
                case 32:
                    return CONFIG_LOADED_FROM_INIT;
                case 33:
                    return CONFIG_LOADED_FROM_AD_LOAD;
                case 34:
                    return CONFIG_LOADED_FROM_ADM_LOAD;
                case 35:
                    return AD_SHOW_TO_PRESENT_DURATION_MS;
                case 36:
                    return AD_SHOW_TO_FAIL_DURATION_MS;
                case 37:
                    return AD_PRESENT_TO_DISPLAY_DURATION_MS;
                default:
                    switch (i10) {
                        case 2000:
                            return SKOVERLAY_PRESENTED_FOR_AD;
                        case 2001:
                            return SAFARI_PRESENTED_FOR_AD;
                        case 2002:
                            return STORE_KIT_PRESENTED_FOR_AD;
                        case 2003:
                            return STORE_KIT_NOT_READY;
                        case 2004:
                            return LAUNCH_STORE_KIT_REQUEST;
                        case 2005:
                            return LAUNCH_SKOVERLAY_REQUEST;
                        case 2006:
                            return LAUNCH_SAFARI_REQUEST;
                        case 2007:
                            return IDFV_RESTRICTED;
                        case 2008:
                            return NOTIFICATION_WAIT_FOR_CONNECTIVITY;
                        case 2009:
                            return IDFV_VALUE_CHANGED;
                        default:
                            return null;
                    }
            }
        }

        public static Internal.EnumLiteMap<b> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return C0528b.INSTANCE;
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
        Sdk$SDKMetric sdk$SDKMetric = new Sdk$SDKMetric();
        DEFAULT_INSTANCE = sdk$SDKMetric;
        GeneratedMessageLite.registerDefaultInstance(Sdk$SDKMetric.class, sdk$SDKMetric);
    }

    private Sdk$SDKMetric() {
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
    public void clearMeta() {
        this.meta_ = getDefaultInstance().getMeta();
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
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = 0L;
    }

    public static Sdk$SDKMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Sdk$SDKMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKMetric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Sdk$SDKMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setMeta(String str) {
        str.getClass();
        this.meta_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetaBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.meta_ = byteString.toStringUtf8();
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
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(b bVar) {
        this.type_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i10) {
        this.type_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(long j10) {
        this.value_ = j10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.vungle.ads.internal.protos.a aVar = null;
        switch (com.vungle.ads.internal.protos.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$SDKMetric();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0000\u0001\u000e\u000e\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\rȈ\u000e\u0002", new Object[]{"type_", "value_", "meta_", "make_", "model_", "os_", "osVersion_", "connectionType_", "connectionTypeDetail_", "placementReferenceId_", "creativeId_", "eventId_", "sessionId_", "isHbPlacement_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Sdk$SDKMetric> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (Sdk$SDKMetric.class) {
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

    @Override // com.vungle.ads.internal.protos.e
    public String getConnectionType() {
        return this.connectionType_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getConnectionTypeBytes() {
        return ByteString.copyFromUtf8(this.connectionType_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getConnectionTypeDetail() {
        return this.connectionTypeDetail_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getConnectionTypeDetailBytes() {
        return ByteString.copyFromUtf8(this.connectionTypeDetail_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getCreativeId() {
        return this.creativeId_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getCreativeIdBytes() {
        return ByteString.copyFromUtf8(this.creativeId_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getEventId() {
        return this.eventId_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getEventIdBytes() {
        return ByteString.copyFromUtf8(this.eventId_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public long getIsHbPlacement() {
        return this.isHbPlacement_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getMake() {
        return this.make_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getMakeBytes() {
        return ByteString.copyFromUtf8(this.make_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getMeta() {
        return this.meta_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getMetaBytes() {
        return ByteString.copyFromUtf8(this.meta_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getModel() {
        return this.model_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getModelBytes() {
        return ByteString.copyFromUtf8(this.model_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getOs() {
        return this.os_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getOsBytes() {
        return ByteString.copyFromUtf8(this.os_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getOsVersion() {
        return this.osVersion_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getOsVersionBytes() {
        return ByteString.copyFromUtf8(this.osVersion_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getPlacementReferenceId() {
        return this.placementReferenceId_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getPlacementReferenceIdBytes() {
        return ByteString.copyFromUtf8(this.placementReferenceId_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public b getType() {
        b bVarForNumber = b.forNumber(this.type_);
        return bVarForNumber == null ? b.UNRECOGNIZED : bVarForNumber;
    }

    @Override // com.vungle.ads.internal.protos.e
    public int getTypeValue() {
        return this.type_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public long getValue() {
        return this.value_;
    }

    public static a newBuilder(Sdk$SDKMetric sdk$SDKMetric) {
        return DEFAULT_INSTANCE.createBuilder(sdk$SDKMetric);
    }

    public static Sdk$SDKMetric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Sdk$SDKMetric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$SDKMetric parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKMetric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Sdk$SDKMetric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
