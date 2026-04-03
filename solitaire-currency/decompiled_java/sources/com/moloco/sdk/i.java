package com.moloco.sdk;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.util.List;

/* JADX INFO: compiled from: Init.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends GeneratedMessageLite<i, c> implements MessageLiteOrBuilder {
    public static final int AD_SERVER_URL_FIELD_NUMBER = 6;
    public static final int AD_UNITS_FIELD_NUMBER = 4;
    public static final int APP_ID_FIELD_NUMBER = 1;
    public static final int BID_TOKEN_CONFIG_FIELD_NUMBER = 12;
    public static final int CONFIGS_FIELD_NUMBER = 16;
    public static final int COUNTRY_ISO2_CODE_FIELD_NUMBER = 7;
    public static final int COUNTRY_ISO3_CODE_FIELD_NUMBER = 3;
    public static final int CRASH_REPORTING_CONFIG_FIELD_NUMBER = 15;
    private static final i DEFAULT_INSTANCE;
    public static final int EVENT_COLLECTION_CONFIG_FIELD_NUMBER = 11;
    public static final int EXPERIMENTAL_FEATURE_FLAGS_FIELD_NUMBER = 13;
    public static final int GEO_FIELD_NUMBER = 10;
    public static final int OPERATIONAL_METRICS_CONFIG_FIELD_NUMBER = 14;
    private static volatile Parser<i> PARSER = null;
    public static final int PLATFORM_ID_FIELD_NUMBER = 8;
    public static final int PUBLISHER_ID_FIELD_NUMBER = 2;
    public static final int RESOLVED_REGION_FIELD_NUMBER = 5;
    public static final int VERIFY_BANNER_VISIBLE_FIELD_NUMBER = 9;
    private b bidTokenConfig_;
    private com.moloco.sdk.g configs_;
    private d crashReportingConfig_;
    private e eventCollectionConfig_;
    private g geo_;
    private h operationalMetricsConfig_;
    private int resolvedRegion_;
    private boolean verifyBannerVisible_;
    private String appId_ = "";
    private String publisherId_ = "";
    private String countryIso3Code_ = "";
    private Internal.ProtobufList<a> adUnits_ = GeneratedMessageLite.emptyProtobufList();
    private String adServerUrl_ = "";
    private String countryIso2Code_ = "";
    private String platformId_ = "";
    private Internal.ProtobufList<f> experimentalFeatureFlags_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: compiled from: Init.java */
    public static final class a extends GeneratedMessageLite<a, C0298a> implements MessageLiteOrBuilder {
        public static final int AD_FREQUENCY_FIELD_NUMBER = 3;
        public static final int BID_FLOOR_FIELD_NUMBER = 4;
        private static final a DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 5;
        public static final int NATIVE_FIELD_NUMBER = 6;
        private static volatile Parser<a> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 2;
        private int adFrequency_;
        private float bidFloor_;
        private String id_ = "";
        private String name_ = "";
        private b native_;
        private int type_;

        /* JADX INFO: renamed from: com.moloco.sdk.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Init.java */
        public static final class C0298a extends GeneratedMessageLite.Builder<a, C0298a> implements MessageLiteOrBuilder {
            /* synthetic */ C0298a(com.moloco.sdk.h hVar) {
                this();
            }

            private C0298a() {
                super(a.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: Init.java */
        public static final class b extends GeneratedMessageLite<b, C0299a> implements MessageLiteOrBuilder {
            private static final b DEFAULT_INSTANCE;
            private static volatile Parser<b> PARSER = null;
            public static final int TYPE_FIELD_NUMBER = 1;
            private int type_;

            /* JADX INFO: renamed from: com.moloco.sdk.i$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Init.java */
            public static final class C0299a extends GeneratedMessageLite.Builder<b, C0299a> implements MessageLiteOrBuilder {
                /* synthetic */ C0299a(com.moloco.sdk.h hVar) {
                    this();
                }

                private C0299a() {
                    super(b.DEFAULT_INSTANCE);
                }
            }

            static {
                b bVar = new b();
                DEFAULT_INSTANCE = bVar;
                GeneratedMessageLite.registerDefaultInstance(b.class, bVar);
            }

            private b() {
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                com.moloco.sdk.h hVar = null;
                switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new b();
                    case 2:
                        return new C0299a(hVar);
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"type_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<b> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (b.class) {
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
        }

        static {
            a aVar = new a();
            DEFAULT_INSTANCE = aVar;
            GeneratedMessageLite.registerDefaultInstance(a.class, aVar);
        }

        private a() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.h hVar = null;
            switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
                case 1:
                    return new a();
                case 2:
                    return new C0298a(hVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u0004\u0004\u0001\u0005Ȉ\u0006\t", new Object[]{"id_", "type_", "adFrequency_", "bidFloor_", "name_", "native_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<a> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (a.class) {
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
    }

    /* JADX INFO: compiled from: Init.java */
    public static final class b extends GeneratedMessageLite<b, a> implements MessageLiteOrBuilder {
        public static final int BID_TOKEN_URL_FIELD_NUMBER = 2;
        private static final b DEFAULT_INSTANCE;
        private static volatile Parser<b> PARSER;
        private String bidTokenUrl_ = "";

        /* JADX INFO: compiled from: Init.java */
        public static final class a extends GeneratedMessageLite.Builder<b, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.h hVar) {
                this();
            }

            private a() {
                super(b.DEFAULT_INSTANCE);
            }
        }

        static {
            b bVar = new b();
            DEFAULT_INSTANCE = bVar;
            GeneratedMessageLite.registerDefaultInstance(b.class, bVar);
        }

        private b() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.h hVar = null;
            switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new a(hVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"bidTokenUrl_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<b> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (b.class) {
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
    }

    /* JADX INFO: compiled from: Init.java */
    public static final class c extends GeneratedMessageLite.Builder<i, c> implements MessageLiteOrBuilder {
        /* synthetic */ c(com.moloco.sdk.h hVar) {
            this();
        }

        private c() {
            super(i.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: Init.java */
    public static final class d extends GeneratedMessageLite<d, a> implements MessageLiteOrBuilder {
        private static final d DEFAULT_INSTANCE;
        public static final int ENABLED_FIELD_NUMBER = 1;
        private static volatile Parser<d> PARSER = null;
        public static final int URL_FIELD_NUMBER = 2;
        private boolean enabled_;
        private String url_ = "";

        /* JADX INFO: compiled from: Init.java */
        public static final class a extends GeneratedMessageLite.Builder<d, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.h hVar) {
                this();
            }

            private a() {
                super(d.DEFAULT_INSTANCE);
            }
        }

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            GeneratedMessageLite.registerDefaultInstance(d.class, dVar);
        }

        private d() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.h hVar = null;
            switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(hVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"enabled_", "url_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<d> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (d.class) {
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
    }

    /* JADX INFO: compiled from: Init.java */
    public static final class e extends GeneratedMessageLite<e, a> implements MessageLiteOrBuilder {
        public static final int APP_BACKGROUND_TRACKING_URL_FIELD_NUMBER = 3;
        public static final int APP_FOREGROUND_TRACKING_URL_FIELD_NUMBER = 4;
        private static final e DEFAULT_INSTANCE;
        public static final int EVENT_COLLECTION_ENABLED_FIELD_NUMBER = 1;
        public static final int MREF_COLLECTION_ENABLED_FIELD_NUMBER = 2;
        private static volatile Parser<e> PARSER;
        private String appBackgroundTrackingUrl_ = "";
        private String appForegroundTrackingUrl_ = "";
        private boolean eventCollectionEnabled_;
        private boolean mrefCollectionEnabled_;

        /* JADX INFO: compiled from: Init.java */
        public static final class a extends GeneratedMessageLite.Builder<e, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.h hVar) {
                this();
            }

            private a() {
                super(e.DEFAULT_INSTANCE);
            }
        }

        static {
            e eVar = new e();
            DEFAULT_INSTANCE = eVar;
            GeneratedMessageLite.registerDefaultInstance(e.class, eVar);
        }

        private e() {
        }

        public static e d() {
            return DEFAULT_INSTANCE;
        }

        public String b() {
            return this.appBackgroundTrackingUrl_;
        }

        public String c() {
            return this.appForegroundTrackingUrl_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.h hVar = null;
            switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
                case 1:
                    return new e();
                case 2:
                    return new a(hVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003Ȉ\u0004Ȉ", new Object[]{"eventCollectionEnabled_", "mrefCollectionEnabled_", "appBackgroundTrackingUrl_", "appForegroundTrackingUrl_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<e> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (e.class) {
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

        public boolean e() {
            return this.eventCollectionEnabled_;
        }

        public boolean f() {
            return this.mrefCollectionEnabled_;
        }
    }

    /* JADX INFO: compiled from: Init.java */
    public static final class f extends GeneratedMessageLite<f, a> implements MessageLiteOrBuilder {
        private static final f DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<f> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private String name_ = "";
        private String value_ = "";

        /* JADX INFO: compiled from: Init.java */
        public static final class a extends GeneratedMessageLite.Builder<f, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.h hVar) {
                this();
            }

            private a() {
                super(f.DEFAULT_INSTANCE);
            }
        }

        static {
            f fVar = new f();
            DEFAULT_INSTANCE = fVar;
            GeneratedMessageLite.registerDefaultInstance(f.class, fVar);
        }

        private f() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.h hVar = null;
            switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return new a(hVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<f> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (f.class) {
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

        public String getName() {
            return this.name_;
        }

        public String getValue() {
            return this.value_;
        }
    }

    /* JADX INFO: compiled from: Init.java */
    public static final class g extends GeneratedMessageLite<g, a> implements MessageLiteOrBuilder {
        public static final int CITY_FIELD_NUMBER = 6;
        public static final int COUNTRY_ISO2_CODE_FIELD_NUMBER = 2;
        public static final int COUNTRY_ISO3_CODE_FIELD_NUMBER = 1;
        private static final g DEFAULT_INSTANCE;
        public static final int LATITUDE_FIELD_NUMBER = 3;
        public static final int LONGITUDE_FIELD_NUMBER = 4;
        private static volatile Parser<g> PARSER = null;
        public static final int REGION_FIELD_NUMBER = 7;
        public static final int ZIP_CODE_FIELD_NUMBER = 5;
        private float latitude_;
        private float longitude_;
        private String countryIso3Code_ = "";
        private String countryIso2Code_ = "";
        private String zipCode_ = "";
        private String city_ = "";
        private String region_ = "";

        /* JADX INFO: compiled from: Init.java */
        public static final class a extends GeneratedMessageLite.Builder<g, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.h hVar) {
                this();
            }

            private a() {
                super(g.DEFAULT_INSTANCE);
            }
        }

        static {
            g gVar = new g();
            DEFAULT_INSTANCE = gVar;
            GeneratedMessageLite.registerDefaultInstance(g.class, gVar);
        }

        private g() {
        }

        public String b() {
            return this.countryIso2Code_;
        }

        public String c() {
            return this.countryIso3Code_;
        }

        public float d() {
            return this.latitude_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.h hVar = null;
            switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return new a(hVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0001\u0004\u0001\u0005Ȉ\u0006Ȉ\u0007Ȉ", new Object[]{"countryIso3Code_", "countryIso2Code_", "latitude_", "longitude_", "zipCode_", "city_", "region_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<g> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (g.class) {
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

        public float e() {
            return this.longitude_;
        }

        public String f() {
            return this.zipCode_;
        }

        public String getCity() {
            return this.city_;
        }
    }

    /* JADX INFO: compiled from: Init.java */
    public static final class h extends GeneratedMessageLite<h, a> implements MessageLiteOrBuilder {
        private static final h DEFAULT_INSTANCE;
        public static final int ENABLED_FIELD_NUMBER = 1;
        private static volatile Parser<h> PARSER = null;
        public static final int POLLING_INTERVAL_SECONDS_FIELD_NUMBER = 3;
        public static final int URL_FIELD_NUMBER = 2;
        private boolean enabled_;
        private int pollingIntervalSeconds_;
        private String url_ = "";

        /* JADX INFO: compiled from: Init.java */
        public static final class a extends GeneratedMessageLite.Builder<h, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.h hVar) {
                this();
            }

            private a() {
                super(h.DEFAULT_INSTANCE);
            }
        }

        static {
            h hVar = new h();
            DEFAULT_INSTANCE = hVar;
            GeneratedMessageLite.registerDefaultInstance(h.class, hVar);
        }

        private h() {
        }

        public static h b() {
            return DEFAULT_INSTANCE;
        }

        public int c() {
            return this.pollingIntervalSeconds_;
        }

        public String d() {
            return this.url_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.h hVar = null;
            switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return new a(hVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003\u0004", new Object[]{"enabled_", "url_", "pollingIntervalSeconds_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<h> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (h.class) {
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
    }

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        GeneratedMessageLite.registerDefaultInstance(i.class, iVar);
    }

    private i() {
    }

    public static i l(byte[] bArr) throws InvalidProtocolBufferException {
        return (i) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public String b() {
        return this.adServerUrl_;
    }

    public com.moloco.sdk.g c() {
        com.moloco.sdk.g gVar = this.configs_;
        return gVar == null ? com.moloco.sdk.g.c() : gVar;
    }

    public String d() {
        return this.countryIso2Code_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.moloco.sdk.h hVar = null;
        switch (com.moloco.sdk.h.f17520a[methodToInvoke.ordinal()]) {
            case 1:
                return new i();
            case 2:
                return new c(hVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0000\u0001\u0010\u0010\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u001b\u0005\f\u0006Ȉ\u0007Ȉ\bȈ\t\u0007\n\t\u000b\t\f\t\r\u001b\u000e\t\u000f\t\u0010\t", new Object[]{"appId_", "publisherId_", "countryIso3Code_", "adUnits_", a.class, "resolvedRegion_", "adServerUrl_", "countryIso2Code_", "platformId_", "verifyBannerVisible_", "geo_", "eventCollectionConfig_", "bidTokenConfig_", "experimentalFeatureFlags_", f.class, "operationalMetricsConfig_", "crashReportingConfig_", "configs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<i> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (i.class) {
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

    public e e() {
        e eVar = this.eventCollectionConfig_;
        return eVar == null ? e.d() : eVar;
    }

    public List<f> f() {
        return this.experimentalFeatureFlags_;
    }

    public h g() {
        h hVar = this.operationalMetricsConfig_;
        return hVar == null ? h.b() : hVar;
    }

    public boolean h() {
        return this.verifyBannerVisible_;
    }

    public boolean i() {
        return this.configs_ != null;
    }

    public boolean j() {
        return this.eventCollectionConfig_ != null;
    }

    public boolean k() {
        return this.operationalMetricsConfig_ != null;
    }
}
