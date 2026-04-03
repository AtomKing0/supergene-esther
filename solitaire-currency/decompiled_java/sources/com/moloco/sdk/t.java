package com.moloco.sdk;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.util.List;

/* JADX INFO: compiled from: UserIntent.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends GeneratedMessageLite<t, d> implements MessageLiteOrBuilder {
    public static final int ADVERTISING_ID_FIELD_NUMBER = 3;
    public static final int APP_BACKGROUNDING_INTERACTION_FIELD_NUMBER = 103;
    public static final int APP_FIELD_NUMBER = 5;
    public static final int APP_FOREGROUNDING_INTERACTION_FIELD_NUMBER = 102;
    public static final int CLICK_INTERACTION_FIELD_NUMBER = 101;
    public static final int CLIENT_TIMESTAMP_FIELD_NUMBER = 2;
    private static final t DEFAULT_INSTANCE;
    public static final int DEVICE_FIELD_NUMBER = 4;
    public static final int IMP_INTERACTION_FIELD_NUMBER = 100;
    public static final int MREF_FIELD_NUMBER = 1;
    public static final int NETWORK_FIELD_NUMBER = 6;
    private static volatile Parser<t> PARSER = null;
    public static final int SDK_FIELD_NUMBER = 7;
    private a app_;
    private long clientTimestamp_;
    private g device_;
    private Object infoExt_;
    private j network_;
    private i sdk_;
    private int infoExtCase_ = 0;
    private String mref_ = "";
    private String advertisingId_ = "";

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class a extends GeneratedMessageLite<a, C0350a> implements MessageLiteOrBuilder {
        private static final a DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile Parser<a> PARSER = null;
        public static final int VER_FIELD_NUMBER = 2;
        private String id_ = "";
        private String ver_ = "";

        /* JADX INFO: renamed from: com.moloco.sdk.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: UserIntent.java */
        public static final class C0350a extends GeneratedMessageLite.Builder<a, C0350a> implements MessageLiteOrBuilder {
            /* synthetic */ C0350a(s sVar) {
                this();
            }

            public C0350a b(String str) {
                copyOnWrite();
                ((a) this.instance).setId(str);
                return this;
            }

            public C0350a c(String str) {
                copyOnWrite();
                ((a) this.instance).e(str);
                return this;
            }

            private C0350a() {
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

        public static C0350a d() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str) {
            str.getClass();
            this.ver_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String str) {
            str.getClass();
            this.id_ = str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new a();
                case 2:
                    return new C0350a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"id_", "ver_"});
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class b extends GeneratedMessageLite<b, a> implements MessageLiteOrBuilder {
        private static final b DEFAULT_INSTANCE;
        private static volatile Parser<b> PARSER;

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<b, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
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

        public static a b() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class c extends GeneratedMessageLite<c, a> implements MessageLiteOrBuilder {
        public static final int BG_TS_MS_FIELD_NUMBER = 1;
        private static final c DEFAULT_INSTANCE;
        private static volatile Parser<c> PARSER;
        private long bgTsMs_;

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<c, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
                this();
            }

            public a b(long j10) {
                copyOnWrite();
                ((c) this.instance).d(j10);
                return this;
            }

            private a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            GeneratedMessageLite.registerDefaultInstance(c.class, cVar);
        }

        private c() {
        }

        public static a c() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(long j10) {
            this.bgTsMs_ = j10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"bgTsMs_"});
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class d extends GeneratedMessageLite.Builder<t, d> implements MessageLiteOrBuilder {
        /* synthetic */ d(s sVar) {
            this();
        }

        public d b(String str) {
            copyOnWrite();
            ((t) this.instance).n(str);
            return this;
        }

        public d c(a aVar) {
            copyOnWrite();
            ((t) this.instance).o(aVar);
            return this;
        }

        public d d(b bVar) {
            copyOnWrite();
            ((t) this.instance).p(bVar);
            return this;
        }

        public d e(c cVar) {
            copyOnWrite();
            ((t) this.instance).q(cVar);
            return this;
        }

        public d f(f fVar) {
            copyOnWrite();
            ((t) this.instance).r(fVar);
            return this;
        }

        public d g(long j10) {
            copyOnWrite();
            ((t) this.instance).s(j10);
            return this;
        }

        public d h(g gVar) {
            copyOnWrite();
            ((t) this.instance).t(gVar);
            return this;
        }

        public d i(h hVar) {
            copyOnWrite();
            ((t) this.instance).u(hVar);
            return this;
        }

        public d j(String str) {
            copyOnWrite();
            ((t) this.instance).v(str);
            return this;
        }

        public d k(j jVar) {
            copyOnWrite();
            ((t) this.instance).w(jVar);
            return this;
        }

        public d l(i iVar) {
            copyOnWrite();
            ((t) this.instance).x(iVar);
            return this;
        }

        private d() {
            super(t.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class e extends GeneratedMessageLite<e, a> implements MessageLiteOrBuilder {
        private static final e DEFAULT_INSTANCE;
        private static volatile Parser<e> PARSER = null;
        public static final int POS_FIELD_NUMBER = 2;
        public static final int SIZE_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        private k pos_;
        private l size_;
        private int type_;

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<e, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
                this();
            }

            public a b(k kVar) {
                copyOnWrite();
                ((e) this.instance).f(kVar);
                return this;
            }

            public a c(l lVar) {
                copyOnWrite();
                ((e) this.instance).g(lVar);
                return this;
            }

            public a d(b bVar) {
                copyOnWrite();
                ((e) this.instance).h(bVar);
                return this;
            }

            private a() {
                super(e.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: UserIntent.java */
        public enum b implements Internal.EnumLite {
            NONE(0),
            CLOSE(1),
            SKIP(2),
            MUTE(3),
            UNMUTE(4),
            CTA(5),
            REPLAY(6),
            DEC_SKIP(7),
            AD_BADGE(8),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private static final Internal.EnumLiteMap<b> f18964l = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f18966a;

            /* JADX INFO: compiled from: UserIntent.java */
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
                this.f18966a = i10;
            }

            public static b c(int i10) {
                switch (i10) {
                    case 0:
                        return NONE;
                    case 1:
                        return CLOSE;
                    case 2:
                        return SKIP;
                    case 3:
                        return MUTE;
                    case 4:
                        return UNMUTE;
                    case 5:
                        return CTA;
                    case 6:
                        return REPLAY;
                    case 7:
                        return DEC_SKIP;
                    case 8:
                        return AD_BADGE;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f18966a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            e eVar = new e();
            DEFAULT_INSTANCE = eVar;
            GeneratedMessageLite.registerDefaultInstance(e.class, eVar);
        }

        private e() {
        }

        public static a e() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(k kVar) {
            kVar.getClass();
            this.pos_ = kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(l lVar) {
            lVar.getClass();
            this.size_ = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(b bVar) {
            this.type_ = bVar.getNumber();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new e();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\t\u0003\t", new Object[]{"type_", "pos_", "size_"});
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class f extends GeneratedMessageLite<f, a> implements MessageLiteOrBuilder {
        public static final int BUTTONS_FIELD_NUMBER = 5;
        public static final int CLICK_POS_FIELD_NUMBER = 1;
        private static final f DEFAULT_INSTANCE;
        private static volatile Parser<f> PARSER = null;
        public static final int SCREEN_SIZE_FIELD_NUMBER = 2;
        public static final int VIEW_POS_FIELD_NUMBER = 3;
        public static final int VIEW_SIZE_FIELD_NUMBER = 4;
        private Internal.ProtobufList<e> buttons_ = GeneratedMessageLite.emptyProtobufList();
        private k clickPos_;
        private l screenSize_;
        private k viewPos_;
        private l viewSize_;

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<f, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
                this();
            }

            public a b(Iterable<? extends e> iterable) {
                copyOnWrite();
                ((f) this.instance).g(iterable);
                return this;
            }

            public a c(k kVar) {
                copyOnWrite();
                ((f) this.instance).j(kVar);
                return this;
            }

            public a d(l lVar) {
                copyOnWrite();
                ((f) this.instance).k(lVar);
                return this;
            }

            public a e(k kVar) {
                copyOnWrite();
                ((f) this.instance).l(kVar);
                return this;
            }

            public a f(l lVar) {
                copyOnWrite();
                ((f) this.instance).m(lVar);
                return this;
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

        /* JADX INFO: Access modifiers changed from: private */
        public void g(Iterable<? extends e> iterable) {
            h();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.buttons_);
        }

        private void h() {
            Internal.ProtobufList<e> protobufList = this.buttons_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.buttons_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static a i() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(k kVar) {
            kVar.getClass();
            this.clickPos_ = kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(l lVar) {
            lVar.getClass();
            this.screenSize_ = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(k kVar) {
            kVar.getClass();
            this.viewPos_ = kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(l lVar) {
            lVar.getClass();
            this.viewSize_ = lVar;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0002\t\u0003\t\u0004\t\u0005\u001b", new Object[]{"clickPos_", "screenSize_", "viewPos_", "viewSize_", "buttons_", e.class});
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class g extends GeneratedMessageLite<g, a> implements MessageLiteOrBuilder {
        private static final g DEFAULT_INSTANCE;
        public static final int MODEL_FIELD_NUMBER = 3;
        public static final int OS_FIELD_NUMBER = 1;
        public static final int OS_VER_FIELD_NUMBER = 2;
        private static volatile Parser<g> PARSER = null;
        public static final int SCREEN_SCALE_FIELD_NUMBER = 4;
        private int os_;
        private float screenScale_;
        private String osVer_ = "";
        private String model_ = "";

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<g, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
                this();
            }

            public a b(String str) {
                copyOnWrite();
                ((g) this.instance).setModel(str);
                return this;
            }

            public a c(b bVar) {
                copyOnWrite();
                ((g) this.instance).g(bVar);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((g) this.instance).h(str);
                return this;
            }

            public a e(float f10) {
                copyOnWrite();
                ((g) this.instance).i(f10);
                return this;
            }

            private a() {
                super(g.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: UserIntent.java */
        public enum b implements Internal.EnumLite {
            UNKNOWN(0),
            ANDROID(1),
            IOS(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap<b> f18971f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f18973a;

            /* JADX INFO: compiled from: UserIntent.java */
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
                this.f18973a = i10;
            }

            public static b c(int i10) {
                if (i10 == 0) {
                    return UNKNOWN;
                }
                if (i10 == 1) {
                    return ANDROID;
                }
                if (i10 != 2) {
                    return null;
                }
                return IOS;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f18973a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            g gVar = new g();
            DEFAULT_INSTANCE = gVar;
            GeneratedMessageLite.registerDefaultInstance(g.class, gVar);
        }

        private g() {
        }

        public static a f() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(b bVar) {
            this.os_ = bVar.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(String str) {
            str.getClass();
            this.osVer_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(float f10) {
            this.screenScale_ = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModel(String str) {
            str.getClass();
            this.model_ = str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004\u0001", new Object[]{"os_", "osVer_", "model_", "screenScale_"});
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class h extends GeneratedMessageLite<h, a> implements MessageLiteOrBuilder {
        private static final h DEFAULT_INSTANCE;
        private static volatile Parser<h> PARSER;

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<h, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
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

        public static a b() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class i extends GeneratedMessageLite<i, a> implements MessageLiteOrBuilder {
        public static final int ADAPTER_VER_FIELD_NUMBER = 2;
        public static final int CORE_VER_FIELD_NUMBER = 1;
        private static final i DEFAULT_INSTANCE;
        private static volatile Parser<i> PARSER;
        private String coreVer_ = "";
        private String adapterVer_ = "";

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<i, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
                this();
            }

            public a b(String str) {
                copyOnWrite();
                ((i) this.instance).d(str);
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

        public static a c() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            str.getClass();
            this.coreVer_ = str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new i();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"coreVer_", "adapterVer_"});
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class j extends GeneratedMessageLite<j, a> implements MessageLiteOrBuilder {
        public static final int CARRIER_FIELD_NUMBER = 2;
        public static final int CONNECTION_TYPE_FIELD_NUMBER = 1;
        private static final j DEFAULT_INSTANCE;
        private static volatile Parser<j> PARSER;
        private String carrier_ = "";
        private int connectionType_;

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<j, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
                this();
            }

            public a b(String str) {
                copyOnWrite();
                ((j) this.instance).e(str);
                return this;
            }

            public a c(b bVar) {
                copyOnWrite();
                ((j) this.instance).f(bVar);
                return this;
            }

            private a() {
                super(j.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: UserIntent.java */
        public enum b implements Internal.EnumLite {
            UNKNOWN(0),
            WIFI(1),
            CELLULAR(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap<b> f18978f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f18980a;

            /* JADX INFO: compiled from: UserIntent.java */
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
                this.f18980a = i10;
            }

            public static b c(int i10) {
                if (i10 == 0) {
                    return UNKNOWN;
                }
                if (i10 == 1) {
                    return WIFI;
                }
                if (i10 != 2) {
                    return null;
                }
                return CELLULAR;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f18980a;
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

        public static a d() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str) {
            str.getClass();
            this.carrier_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(b bVar) {
            this.connectionType_ = bVar.getNumber();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002Ȉ", new Object[]{"connectionType_", "carrier_"});
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class k extends GeneratedMessageLite<k, a> implements MessageLiteOrBuilder {
        private static final k DEFAULT_INSTANCE;
        private static volatile Parser<k> PARSER = null;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private float x_;
        private float y_;

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<k, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
                this();
            }

            public a b(float f10) {
                copyOnWrite();
                ((k) this.instance).e(f10);
                return this;
            }

            public a c(float f10) {
                copyOnWrite();
                ((k) this.instance).f(f10);
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

        public static a d() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(float f10) {
            this.x_ = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(float f10) {
            this.y_ = f10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new k();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0002\u0001", new Object[]{"x_", "y_"});
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

    /* JADX INFO: compiled from: UserIntent.java */
    public static final class l extends GeneratedMessageLite<l, a> implements MessageLiteOrBuilder {
        private static final l DEFAULT_INSTANCE;
        public static final int H_FIELD_NUMBER = 2;
        private static volatile Parser<l> PARSER = null;
        public static final int W_FIELD_NUMBER = 1;
        private float h_;
        private float w_;

        /* JADX INFO: compiled from: UserIntent.java */
        public static final class a extends GeneratedMessageLite.Builder<l, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(s sVar) {
                this();
            }

            public a b(float f10) {
                copyOnWrite();
                ((l) this.instance).e(f10);
                return this;
            }

            public a c(float f10) {
                copyOnWrite();
                ((l) this.instance).f(f10);
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

        public static a d() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(float f10) {
            this.h_ = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(float f10) {
            this.w_ = f10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            s sVar = null;
            switch (s.f18868a[methodToInvoke.ordinal()]) {
                case 1:
                    return new l();
                case 2:
                    return new a(sVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0002\u0001", new Object[]{"w_", "h_"});
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
        t tVar = new t();
        DEFAULT_INSTANCE = tVar;
        GeneratedMessageLite.registerDefaultInstance(t.class, tVar);
    }

    private t() {
    }

    public static d m() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        str.getClass();
        this.advertisingId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(a aVar) {
        aVar.getClass();
        this.app_ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(b bVar) {
        bVar.getClass();
        this.infoExt_ = bVar;
        this.infoExtCase_ = 103;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(c cVar) {
        cVar.getClass();
        this.infoExt_ = cVar;
        this.infoExtCase_ = 102;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(f fVar) {
        fVar.getClass();
        this.infoExt_ = fVar;
        this.infoExtCase_ = 101;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j10) {
        this.clientTimestamp_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(g gVar) {
        gVar.getClass();
        this.device_ = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(h hVar) {
        hVar.getClass();
        this.infoExt_ = hVar;
        this.infoExtCase_ = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        str.getClass();
        this.mref_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(j jVar) {
        jVar.getClass();
        this.network_ = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(i iVar) {
        iVar.getClass();
        this.sdk_ = iVar;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        s sVar = null;
        switch (s.f18868a[methodToInvoke.ordinal()]) {
            case 1:
                return new t();
            case 2:
                return new d(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001g\u000b\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004\t\u0005\t\u0006\t\u0007\td<\u0000e<\u0000f<\u0000g<\u0000", new Object[]{"infoExt_", "infoExtCase_", "mref_", "clientTimestamp_", "advertisingId_", "device_", "app_", "network_", "sdk_", h.class, f.class, c.class, b.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<t> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (t.class) {
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
