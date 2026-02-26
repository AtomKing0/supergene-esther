package com.moloco.sdk;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* JADX INFO: compiled from: BidToken.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends GeneratedMessageLite<e, C0296e> implements MessageLiteOrBuilder {
    public static final int ACCESSIBILITY_INFO_FIELD_NUMBER = 11;
    public static final int AD_INFO_FIELD_NUMBER = 8;
    public static final int AUDIO_INFO_FIELD_NUMBER = 10;
    public static final int BATTERY_INFO_FIELD_NUMBER = 9;
    private static final e DEFAULT_INSTANCE;
    public static final int DEVICE_FIELD_NUMBER = 3;
    public static final int DIR_INFO_FIELD_NUMBER = 6;
    public static final int IDFV_FIELD_NUMBER = 1;
    public static final int INFO_FIELD_NUMBER = 4;
    public static final int MEMORY_INFO_FIELD_NUMBER = 5;
    public static final int NETWORK_INFO_FIELD_NUMBER = 7;
    private static volatile Parser<e> PARSER = null;
    public static final int PRIVACY_FIELD_NUMBER = 2;
    private a accessibilityInfo_;
    private b adInfo_;
    private c audioInfo_;
    private d batteryInfo_;
    private int bitField0_;
    private f device_;
    private g dirInfo_;
    private String idfv_ = "";
    private l info_;
    private i memoryInfo_;
    private j networkInfo_;
    private k privacy_;

    /* JADX INFO: compiled from: BidToken.java */
    public static final class a extends GeneratedMessageLite<a, C0294a> implements MessageLiteOrBuilder {
        public static final int ACCESSIBILITY_CAPTIONING_ENABLED_FIELD_NUMBER = 1;
        public static final int ACCESSIBILITY_LARGE_POINTER_ICON_FIELD_NUMBER = 2;
        private static final a DEFAULT_INSTANCE;
        public static final int FONT_SCALE_FIELD_NUMBER = 4;
        private static volatile Parser<a> PARSER = null;
        public static final int REDUCE_BRIGHT_COLORS_ACTIVATED_FIELD_NUMBER = 3;
        private boolean accessibilityCaptioningEnabled_;
        private boolean accessibilityLargePointerIcon_;
        private int bitField0_;
        private float fontScale_;
        private boolean reduceBrightColorsActivated_;

        /* JADX INFO: renamed from: com.moloco.sdk.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BidToken.java */
        public static final class C0294a extends GeneratedMessageLite.Builder<a, C0294a> implements MessageLiteOrBuilder {
            /* synthetic */ C0294a(com.moloco.sdk.a aVar) {
                this();
            }

            public C0294a b(boolean z10) {
                copyOnWrite();
                ((a) this.instance).g(z10);
                return this;
            }

            public C0294a c(boolean z10) {
                copyOnWrite();
                ((a) this.instance).h(z10);
                return this;
            }

            public C0294a d(float f10) {
                copyOnWrite();
                ((a) this.instance).i(f10);
                return this;
            }

            public C0294a e(boolean z10) {
                copyOnWrite();
                ((a) this.instance).j(z10);
                return this;
            }

            private C0294a() {
                super(a.DEFAULT_INSTANCE);
            }
        }

        static {
            a aVar = new a();
            DEFAULT_INSTANCE = aVar;
            GeneratedMessageLite.registerDefaultInstance(a.class, aVar);
        }

        private a() {
        }

        public static C0294a f() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(boolean z10) {
            this.bitField0_ |= 1;
            this.accessibilityCaptioningEnabled_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(boolean z10) {
            this.bitField0_ |= 2;
            this.accessibilityLargePointerIcon_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(float f10) {
            this.bitField0_ |= 8;
            this.fontScale_ = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(boolean z10) {
            this.bitField0_ |= 4;
            this.reduceBrightColorsActivated_ = z10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new a();
                case 2:
                    return new C0294a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ခ\u0003", new Object[]{"bitField0_", "accessibilityCaptioningEnabled_", "accessibilityLargePointerIcon_", "reduceBrightColorsActivated_", "fontScale_"});
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

    /* JADX INFO: compiled from: BidToken.java */
    public static final class b extends GeneratedMessageLite<b, a> implements MessageLiteOrBuilder {
        private static final b DEFAULT_INSTANCE;
        public static final int DNT_FIELD_NUMBER = 2;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile Parser<b> PARSER;
        private int bitField0_;
        private boolean dnt_;
        private String id_ = "";

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<b, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(boolean z10) {
                copyOnWrite();
                ((b) this.instance).e(z10);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((b) this.instance).setId(str);
                return this;
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

        public static a d() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(boolean z10) {
            this.bitField0_ |= 2;
            this.dnt_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.id_ = str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ဇ\u0001", new Object[]{"bitField0_", "id_", "dnt_"});
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

    /* JADX INFO: compiled from: BidToken.java */
    public static final class c extends GeneratedMessageLite<c, a> implements MessageLiteOrBuilder {
        private static final c DEFAULT_INSTANCE;
        public static final int MUTE_SWITCH_FIELD_NUMBER = 1;
        private static volatile Parser<c> PARSER = null;
        public static final int VOL_FIELD_NUMBER = 2;
        private int bitField0_;
        private int muteSwitch_;
        private int vol_;

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<c, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(b bVar) {
                copyOnWrite();
                ((c) this.instance).e(bVar);
                return this;
            }

            public a c(int i10) {
                copyOnWrite();
                ((c) this.instance).f(i10);
                return this;
            }

            private a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: BidToken.java */
        public enum b implements Internal.EnumLite {
            SILENT(0),
            VIBRATE(1),
            NORMAL(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap<b> f17492f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f17494a;

            /* JADX INFO: compiled from: BidToken.java */
            class a implements Internal.EnumLiteMap<b> {
                a() {
                }

                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public b findValueByNumber(int i10) {
                    return b.c(i10);
                }
            }

            b(int i10) {
                this.f17494a = i10;
            }

            public static b c(int i10) {
                if (i10 == 0) {
                    return SILENT;
                }
                if (i10 == 1) {
                    return VIBRATE;
                }
                if (i10 != 2) {
                    return null;
                }
                return NORMAL;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f17494a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            GeneratedMessageLite.registerDefaultInstance(c.class, cVar);
        }

        private c() {
        }

        public static a d() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(b bVar) {
            this.muteSwitch_ = bVar.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i10) {
            this.bitField0_ |= 2;
            this.vol_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001", new Object[]{"bitField0_", "muteSwitch_", "vol_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<c> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (c.class) {
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

    /* JADX INFO: compiled from: BidToken.java */
    public static final class d extends GeneratedMessageLite<d, b> implements MessageLiteOrBuilder {
        public static final int BATTERY_STATUS_FIELD_NUMBER = 2;
        private static final d DEFAULT_INSTANCE;
        public static final int LOW_POW_MODE_FIELD_NUMBER = 3;
        public static final int MAX_BATTERY_LEVEL_FIELD_NUMBER = 1;
        private static volatile Parser<d> PARSER;
        private int batteryStatus_;
        private int bitField0_;
        private boolean lowPowMode_;
        private int maxBatteryLevel_;

        /* JADX INFO: compiled from: BidToken.java */
        public enum a implements Internal.EnumLite {
            UNKNOWN(0),
            CHARGING(1),
            DISCHARGING(2),
            NOT_CHARGING(3),
            FULL(4),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final Internal.EnumLiteMap<a> f17501h = new C0295a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f17503a;

            /* JADX INFO: renamed from: com.moloco.sdk.e$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: BidToken.java */
            class C0295a implements Internal.EnumLiteMap<a> {
                C0295a() {
                }

                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a findValueByNumber(int i10) {
                    return a.c(i10);
                }
            }

            a(int i10) {
                this.f17503a = i10;
            }

            public static a c(int i10) {
                if (i10 == 0) {
                    return UNKNOWN;
                }
                if (i10 == 1) {
                    return CHARGING;
                }
                if (i10 == 2) {
                    return DISCHARGING;
                }
                if (i10 == 3) {
                    return NOT_CHARGING;
                }
                if (i10 != 4) {
                    return null;
                }
                return FULL;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f17503a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: compiled from: BidToken.java */
        public static final class b extends GeneratedMessageLite.Builder<d, b> implements MessageLiteOrBuilder {
            /* synthetic */ b(com.moloco.sdk.a aVar) {
                this();
            }

            public b b(a aVar) {
                copyOnWrite();
                ((d) this.instance).f(aVar);
                return this;
            }

            public b c(boolean z10) {
                copyOnWrite();
                ((d) this.instance).g(z10);
                return this;
            }

            public b d(int i10) {
                copyOnWrite();
                ((d) this.instance).h(i10);
                return this;
            }

            private b() {
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

        public static b e() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(a aVar) {
            this.batteryStatus_ = aVar.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(boolean z10) {
            this.bitField0_ |= 4;
            this.lowPowMode_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i10) {
            this.bitField0_ |= 1;
            this.maxBatteryLevel_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new b(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဌ\u0001\u0003ဇ\u0002", new Object[]{"bitField0_", "maxBatteryLevel_", "batteryStatus_", "lowPowMode_"});
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

    /* JADX INFO: renamed from: com.moloco.sdk.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BidToken.java */
    public static final class C0296e extends GeneratedMessageLite.Builder<e, C0296e> implements MessageLiteOrBuilder {
        /* synthetic */ C0296e(com.moloco.sdk.a aVar) {
            this();
        }

        public C0296e b(a aVar) {
            copyOnWrite();
            ((e) this.instance).m(aVar);
            return this;
        }

        public C0296e c(b bVar) {
            copyOnWrite();
            ((e) this.instance).n(bVar);
            return this;
        }

        public C0296e d(c cVar) {
            copyOnWrite();
            ((e) this.instance).o(cVar);
            return this;
        }

        public C0296e e(d dVar) {
            copyOnWrite();
            ((e) this.instance).p(dVar);
            return this;
        }

        public C0296e f(f fVar) {
            copyOnWrite();
            ((e) this.instance).q(fVar);
            return this;
        }

        public C0296e g(g gVar) {
            copyOnWrite();
            ((e) this.instance).r(gVar);
            return this;
        }

        public C0296e h(l lVar) {
            copyOnWrite();
            ((e) this.instance).s(lVar);
            return this;
        }

        public C0296e i(i iVar) {
            copyOnWrite();
            ((e) this.instance).t(iVar);
            return this;
        }

        public C0296e j(j jVar) {
            copyOnWrite();
            ((e) this.instance).u(jVar);
            return this;
        }

        public C0296e k(k kVar) {
            copyOnWrite();
            ((e) this.instance).v(kVar);
            return this;
        }

        private C0296e() {
            super(e.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: BidToken.java */
    public static final class f extends GeneratedMessageLite<f, a> implements MessageLiteOrBuilder {
        public static final int BRAND_FIELD_NUMBER = 23;
        public static final int CARRIER_FIELD_NUMBER = 6;
        public static final int DBT_FIELD_NUMBER = 15;
        private static final f DEFAULT_INSTANCE;
        public static final int DEVICETYPE_FIELD_NUMBER = 7;
        public static final int GEO_FIELD_NUMBER = 9;
        public static final int HARDWARE_FIELD_NUMBER = 22;
        public static final int HAS_GY_FIELD_NUMBER = 17;
        public static final int HWV_FIELD_NUMBER = 5;
        public static final int H_FIELD_NUMBER = 11;
        public static final int JS_FIELD_NUMBER = 8;
        public static final int KB_LOC_FIELD_NUMBER = 18;
        public static final int LANGUAGE_FIELD_NUMBER = 1;
        public static final int LOCALE_FIELD_NUMBER = 19;
        public static final int MAKE_FIELD_NUMBER = 3;
        public static final int MODEL_FIELD_NUMBER = 4;
        public static final int ORTN_FIELD_NUMBER = 16;
        public static final int OSV_FIELD_NUMBER = 2;
        public static final int OS_FIELD_NUMBER = 14;
        private static volatile Parser<f> PARSER = null;
        public static final int PPI_FIELD_NUMBER = 12;
        public static final int PXRATIO_FIELD_NUMBER = 13;
        public static final int W_FIELD_NUMBER = 10;
        public static final int XDPI_FIELD_NUMBER = 20;
        public static final int YDPI_FIELD_NUMBER = 21;
        private int bitField0_;
        private long dbt_;
        private int devicetype_;
        private h geo_;
        private int h_;
        private boolean hasGy_;
        private int js_;
        private int ortn_;
        private int ppi_;
        private double pxratio_;
        private int w_;
        private float xdpi_;
        private float ydpi_;
        private String language_ = "";
        private String osv_ = "";
        private String make_ = "";
        private String model_ = "";
        private String hwv_ = "";
        private String carrier_ = "";
        private String os_ = "";
        private String kbLoc_ = "";
        private String locale_ = "";
        private String hardware_ = "";
        private String brand_ = "";

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<f, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(String str) {
                copyOnWrite();
                ((f) this.instance).z(str);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((f) this.instance).A(str);
                return this;
            }

            public a d(long j10) {
                copyOnWrite();
                ((f) this.instance).B(j10);
                return this;
            }

            public a e(int i10) {
                copyOnWrite();
                ((f) this.instance).C(i10);
                return this;
            }

            public a f(h hVar) {
                copyOnWrite();
                ((f) this.instance).D(hVar);
                return this;
            }

            public a g(int i10) {
                copyOnWrite();
                ((f) this.instance).E(i10);
                return this;
            }

            public a h(String str) {
                copyOnWrite();
                ((f) this.instance).F(str);
                return this;
            }

            public a i(boolean z10) {
                copyOnWrite();
                ((f) this.instance).G(z10);
                return this;
            }

            public a j(String str) {
                copyOnWrite();
                ((f) this.instance).H(str);
                return this;
            }

            public a k(int i10) {
                copyOnWrite();
                ((f) this.instance).I(i10);
                return this;
            }

            public a l(String str) {
                copyOnWrite();
                ((f) this.instance).J(str);
                return this;
            }

            public a m(String str) {
                copyOnWrite();
                ((f) this.instance).setLanguage(str);
                return this;
            }

            public a o(String str) {
                copyOnWrite();
                ((f) this.instance).K(str);
                return this;
            }

            public a p(String str) {
                copyOnWrite();
                ((f) this.instance).setMake(str);
                return this;
            }

            public a q(String str) {
                copyOnWrite();
                ((f) this.instance).setModel(str);
                return this;
            }

            public a r(b bVar) {
                copyOnWrite();
                ((f) this.instance).L(bVar);
                return this;
            }

            public a s(String str) {
                copyOnWrite();
                ((f) this.instance).setOs(str);
                return this;
            }

            public a t(String str) {
                copyOnWrite();
                ((f) this.instance).setOsv(str);
                return this;
            }

            public a u(int i10) {
                copyOnWrite();
                ((f) this.instance).M(i10);
                return this;
            }

            public a v(double d10) {
                copyOnWrite();
                ((f) this.instance).N(d10);
                return this;
            }

            public a w(int i10) {
                copyOnWrite();
                ((f) this.instance).O(i10);
                return this;
            }

            public a x(float f10) {
                copyOnWrite();
                ((f) this.instance).P(f10);
                return this;
            }

            public a y(float f10) {
                copyOnWrite();
                ((f) this.instance).Q(f10);
                return this;
            }

            private a() {
                super(f.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: BidToken.java */
        public enum b implements Internal.EnumLite {
            UNKNOWN(0),
            PORTRAIT(1),
            LANDSCAPE(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap<b> f17508f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f17510a;

            /* JADX INFO: compiled from: BidToken.java */
            class a implements Internal.EnumLiteMap<b> {
                a() {
                }

                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public b findValueByNumber(int i10) {
                    return b.c(i10);
                }
            }

            b(int i10) {
                this.f17510a = i10;
            }

            public static b c(int i10) {
                if (i10 == 0) {
                    return UNKNOWN;
                }
                if (i10 == 1) {
                    return PORTRAIT;
                }
                if (i10 != 2) {
                    return null;
                }
                return LANDSCAPE;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f17510a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            f fVar = new f();
            DEFAULT_INSTANCE = fVar;
            GeneratedMessageLite.registerDefaultInstance(f.class, fVar);
        }

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.carrier_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B(long j10) {
            this.bitField0_ |= 16384;
            this.dbt_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(int i10) {
            this.bitField0_ |= 64;
            this.devicetype_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D(h hVar) {
            hVar.getClass();
            this.geo_ = hVar;
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E(int i10) {
            this.bitField0_ |= 1024;
            this.h_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F(String str) {
            str.getClass();
            this.bitField0_ |= 2097152;
            this.hardware_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G(boolean z10) {
            this.bitField0_ |= 65536;
            this.hasGy_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.hwv_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I(int i10) {
            this.bitField0_ |= 128;
            this.js_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J(String str) {
            str.getClass();
            this.bitField0_ |= 131072;
            this.kbLoc_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K(String str) {
            str.getClass();
            this.bitField0_ |= 262144;
            this.locale_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L(b bVar) {
            this.ortn_ = bVar.getNumber();
            this.bitField0_ |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M(int i10) {
            this.bitField0_ |= 2048;
            this.ppi_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N(double d10) {
            this.bitField0_ |= 4096;
            this.pxratio_ = d10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O(int i10) {
            this.bitField0_ |= 512;
            this.w_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void P(float f10) {
            this.bitField0_ |= 524288;
            this.xdpi_ = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q(float f10) {
            this.bitField0_ |= 1048576;
            this.ydpi_ = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLanguage(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.language_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMake(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.make_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModel(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.model_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOs(String str) {
            str.getClass();
            this.bitField0_ |= 8192;
            this.os_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOsv(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.osv_ = str;
        }

        public static a y() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(String str) {
            str.getClass();
            this.bitField0_ |= 4194304;
            this.brand_ = str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0017\u0000\u0001\u0001\u0017\u0017\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006ለ\u0005\u0007ဋ\u0006\bဋ\u0007\tဉ\b\nဋ\t\u000bဋ\n\fဋ\u000b\rက\f\u000eለ\r\u000fဃ\u000e\u0010ဌ\u000f\u0011ဇ\u0010\u0012ለ\u0011\u0013ለ\u0012\u0014ခ\u0013\u0015ခ\u0014\u0016ለ\u0015\u0017ለ\u0016", new Object[]{"bitField0_", "language_", "osv_", "make_", "model_", "hwv_", "carrier_", "devicetype_", "js_", "geo_", "w_", "h_", "ppi_", "pxratio_", "os_", "dbt_", "ortn_", "hasGy_", "kbLoc_", "locale_", "xdpi_", "ydpi_", "hardware_", "brand_"});
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
    }

    /* JADX INFO: compiled from: BidToken.java */
    public static final class g extends GeneratedMessageLite<g, a> implements MessageLiteOrBuilder {
        private static final g DEFAULT_INSTANCE;
        public static final int DSIZE_BYTES_FIELD_NUMBER = 1;
        private static volatile Parser<g> PARSER;
        private int bitField0_;
        private long dsizeBytes_;

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<g, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(long j10) {
                copyOnWrite();
                ((g) this.instance).d(j10);
                return this;
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

        public static a c() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(long j10) {
            this.bitField0_ |= 1;
            this.dsizeBytes_ = j10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဃ\u0000", new Object[]{"bitField0_", "dsizeBytes_"});
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
    }

    /* JADX INFO: compiled from: BidToken.java */
    public static final class h extends GeneratedMessageLite<h, a> implements MessageLiteOrBuilder {
        private static final h DEFAULT_INSTANCE;
        private static volatile Parser<h> PARSER = null;
        public static final int UTCOFFSET_FIELD_NUMBER = 1;
        private int bitField0_;
        private int utcoffset_;

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<h, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(int i10) {
                copyOnWrite();
                ((h) this.instance).d(i10);
                return this;
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

        public static a c() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i10) {
            this.bitField0_ |= 1;
            this.utcoffset_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"bitField0_", "utcoffset_"});
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

    /* JADX INFO: compiled from: BidToken.java */
    public static final class i extends GeneratedMessageLite<i, a> implements MessageLiteOrBuilder {
        private static final i DEFAULT_INSTANCE;
        public static final int LOW_MEM_FIELD_NUMBER = 1;
        public static final int LOW_MEM_THRESHOLD_BYTES_FIELD_NUMBER = 2;
        private static volatile Parser<i> PARSER = null;
        public static final int TOTAL_MEM_BYTES_FIELD_NUMBER = 3;
        private int bitField0_;
        private long lowMemThresholdBytes_;
        private boolean lowMem_;
        private long totalMemBytes_;

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<i, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(boolean z10) {
                copyOnWrite();
                ((i) this.instance).f(z10);
                return this;
            }

            public a c(long j10) {
                copyOnWrite();
                ((i) this.instance).g(j10);
                return this;
            }

            public a d(long j10) {
                copyOnWrite();
                ((i) this.instance).h(j10);
                return this;
            }

            private a() {
                super(i.DEFAULT_INSTANCE);
            }
        }

        static {
            i iVar = new i();
            DEFAULT_INSTANCE = iVar;
            GeneratedMessageLite.registerDefaultInstance(i.class, iVar);
        }

        private i() {
        }

        public static a e() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(boolean z10) {
            this.bitField0_ |= 1;
            this.lowMem_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(long j10) {
            this.bitField0_ |= 2;
            this.lowMemThresholdBytes_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(long j10) {
            this.bitField0_ |= 4;
            this.totalMemBytes_ = j10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new i();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဃ\u0001\u0003ဃ\u0002", new Object[]{"bitField0_", "lowMem_", "lowMemThresholdBytes_", "totalMemBytes_"});
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
    }

    /* JADX INFO: compiled from: BidToken.java */
    public static final class j extends GeneratedMessageLite<j, a> implements MessageLiteOrBuilder {
        private static final j DEFAULT_INSTANCE;
        public static final int MCC_FIELD_NUMBER = 3;
        public static final int MNC_FIELD_NUMBER = 4;
        private static volatile Parser<j> PARSER = null;
        public static final int RESTRICTED_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int bitField0_;
        private int mcc_;
        private int mnc_;
        private boolean restricted_;
        private int type_;

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<j, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(int i10) {
                copyOnWrite();
                ((j) this.instance).g(i10);
                return this;
            }

            public a c(int i10) {
                copyOnWrite();
                ((j) this.instance).h(i10);
                return this;
            }

            public a d(boolean z10) {
                copyOnWrite();
                ((j) this.instance).i(z10);
                return this;
            }

            public a e(b bVar) {
                copyOnWrite();
                ((j) this.instance).j(bVar);
                return this;
            }

            private a() {
                super(j.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: BidToken.java */
        public enum b implements Internal.EnumLite {
            UNKNOWN(0),
            WIFI(1),
            CELLULAR(2),
            NO_NETWORK(3),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private static final Internal.EnumLiteMap<b> f17516g = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f17518a;

            /* JADX INFO: compiled from: BidToken.java */
            class a implements Internal.EnumLiteMap<b> {
                a() {
                }

                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public b findValueByNumber(int i10) {
                    return b.c(i10);
                }
            }

            b(int i10) {
                this.f17518a = i10;
            }

            public static b c(int i10) {
                if (i10 == 0) {
                    return UNKNOWN;
                }
                if (i10 == 1) {
                    return WIFI;
                }
                if (i10 == 2) {
                    return CELLULAR;
                }
                if (i10 != 3) {
                    return null;
                }
                return NO_NETWORK;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f17518a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            j jVar = new j();
            DEFAULT_INSTANCE = jVar;
            GeneratedMessageLite.registerDefaultInstance(j.class, jVar);
        }

        private j() {
        }

        public static a f() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i10) {
            this.bitField0_ |= 4;
            this.mcc_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i10) {
            this.bitField0_ |= 8;
            this.mnc_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(boolean z10) {
            this.bitField0_ |= 2;
            this.restricted_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b bVar) {
            this.type_ = bVar.getNumber();
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဋ\u0002\u0004ဋ\u0003", new Object[]{"bitField0_", "type_", "restricted_", "mcc_", "mnc_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<j> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (j.class) {
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

    /* JADX INFO: compiled from: BidToken.java */
    public static final class k extends GeneratedMessageLite<k, a> implements MessageLiteOrBuilder {
        public static final int CCPA_FIELD_NUMBER = 1;
        public static final int COPPA_FIELD_NUMBER = 3;
        private static final k DEFAULT_INSTANCE;
        public static final int GDPR_FIELD_NUMBER = 2;
        private static volatile Parser<k> PARSER = null;
        public static final int TCF_CONSENT_STRING_FIELD_NUMBER = 5;
        public static final int US_PRIVACY_FIELD_NUMBER = 4;
        private int bitField0_;
        private boolean ccpa_;
        private boolean coppa_;
        private boolean gdpr_;
        private String usPrivacy_ = "";
        private String tcfConsentString_ = "";

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<k, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(boolean z10) {
                copyOnWrite();
                ((k) this.instance).h(z10);
                return this;
            }

            public a c(boolean z10) {
                copyOnWrite();
                ((k) this.instance).i(z10);
                return this;
            }

            public a d(boolean z10) {
                copyOnWrite();
                ((k) this.instance).j(z10);
                return this;
            }

            public a e(String str) {
                copyOnWrite();
                ((k) this.instance).k(str);
                return this;
            }

            public a f(String str) {
                copyOnWrite();
                ((k) this.instance).l(str);
                return this;
            }

            private a() {
                super(k.DEFAULT_INSTANCE);
            }
        }

        static {
            k kVar = new k();
            DEFAULT_INSTANCE = kVar;
            GeneratedMessageLite.registerDefaultInstance(k.class, kVar);
        }

        private k() {
        }

        public static a g() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(boolean z10) {
            this.bitField0_ |= 1;
            this.ccpa_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(boolean z10) {
            this.bitField0_ |= 4;
            this.coppa_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(boolean z10) {
            this.bitField0_ |= 2;
            this.gdpr_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.tcfConsentString_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.usPrivacy_ = str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new k();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ለ\u0003\u0005ለ\u0004", new Object[]{"bitField0_", "ccpa_", "gdpr_", "coppa_", "usPrivacy_", "tcfConsentString_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<k> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (k.class) {
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

    /* JADX INFO: compiled from: BidToken.java */
    public static final class l extends GeneratedMessageLite<l, a> implements MessageLiteOrBuilder {
        private static final l DEFAULT_INSTANCE;
        public static final int INITIALIZED_FIELD_NUMBER = 1;
        private static volatile Parser<l> PARSER;
        private int bitField0_;
        private boolean initialized_;

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<l, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
                this();
            }

            public a b(boolean z10) {
                copyOnWrite();
                ((l) this.instance).d(z10);
                return this;
            }

            private a() {
                super(l.DEFAULT_INSTANCE);
            }
        }

        static {
            l lVar = new l();
            DEFAULT_INSTANCE = lVar;
            GeneratedMessageLite.registerDefaultInstance(l.class, lVar);
        }

        private l() {
        }

        public static a c() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(boolean z10) {
            this.bitField0_ |= 1;
            this.initialized_ = z10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            com.moloco.sdk.a aVar = null;
            switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
                case 1:
                    return new l();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"bitField0_", "initialized_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<l> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (l.class) {
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
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        GeneratedMessageLite.registerDefaultInstance(e.class, eVar);
    }

    private e() {
    }

    public static C0296e l() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(a aVar) {
        aVar.getClass();
        this.accessibilityInfo_ = aVar;
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(b bVar) {
        bVar.getClass();
        this.adInfo_ = bVar;
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(c cVar) {
        cVar.getClass();
        this.audioInfo_ = cVar;
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(d dVar) {
        dVar.getClass();
        this.batteryInfo_ = dVar;
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(f fVar) {
        fVar.getClass();
        this.device_ = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(g gVar) {
        gVar.getClass();
        this.dirInfo_ = gVar;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(l lVar) {
        lVar.getClass();
        this.info_ = lVar;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(i iVar) {
        iVar.getClass();
        this.memoryInfo_ = iVar;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(j jVar) {
        jVar.getClass();
        this.networkInfo_ = jVar;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(k kVar) {
        kVar.getClass();
        this.privacy_ = kVar;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.moloco.sdk.a aVar = null;
        switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new C0296e(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ለ\u0000\u0002\t\u0003\t\u0004ဉ\u0001\u0005ဉ\u0002\u0006ဉ\u0003\u0007ဉ\u0004\bဉ\u0005\tဉ\u0006\nဉ\u0007\u000bဉ\b", new Object[]{"bitField0_", "idfv_", "privacy_", "device_", "info_", "memoryInfo_", "dirInfo_", "networkInfo_", "adInfo_", "batteryInfo_", "audioInfo_", "accessibilityInfo_"});
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
}
