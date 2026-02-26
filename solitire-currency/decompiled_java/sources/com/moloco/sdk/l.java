package com.moloco.sdk;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* JADX INFO: compiled from: MetricsRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends GeneratedMessageLite<l, a> implements MessageLiteOrBuilder {
    public static final int CLIENT_ERROR_FIELD_NUMBER = 2;
    private static final l DEFAULT_INSTANCE;
    private static volatile Parser<l> PARSER = null;
    public static final int SERVER_ERROR_FIELD_NUMBER = 1;
    private int errorTypeCase_ = 0;
    private Object errorType_;

    /* JADX INFO: compiled from: MetricsRequest.java */
    public static final class a extends GeneratedMessageLite.Builder<l, a> implements MessageLiteOrBuilder {
        /* synthetic */ a(j jVar) {
            this();
        }

        public a b(b bVar) {
            copyOnWrite();
            ((l) this.instance).e(bVar);
            return this;
        }

        public a c(c cVar) {
            copyOnWrite();
            ((l) this.instance).f(cVar);
            return this;
        }

        private a() {
            super(l.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: MetricsRequest.java */
    public static final class b extends GeneratedMessageLite<b, a> implements MessageLiteOrBuilder {
        public static final int CLIENT_FAILURE_TYPE_FIELD_NUMBER = 1;
        private static final b DEFAULT_INSTANCE;
        private static volatile Parser<b> PARSER;
        private int bitField0_;
        private int clientFailureType_;

        /* JADX INFO: compiled from: MetricsRequest.java */
        public static final class a extends GeneratedMessageLite.Builder<b, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(j jVar) {
                this();
            }

            public a b(EnumC0333b enumC0333b) {
                copyOnWrite();
                ((b) this.instance).d(enumC0333b);
                return this;
            }

            private a() {
                super(b.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.l$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MetricsRequest.java */
        public enum EnumC0333b implements Internal.EnumLite {
            UNKNOWN(0),
            HTTP_SSL_ERROR(1),
            HTTP_UKNOWN_HOST(2),
            HTTP_REQUEST_TIMEOUT(3),
            HTTP_SOCKET(4),
            ANDROID_WORK_MANAGER_ISSUE(5),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private static final Internal.EnumLiteMap<EnumC0333b> f18849i = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f18851a;

            /* JADX INFO: renamed from: com.moloco.sdk.l$b$b$a */
            /* JADX INFO: compiled from: MetricsRequest.java */
            class a implements Internal.EnumLiteMap<EnumC0333b> {
                a() {
                }

                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public EnumC0333b findValueByNumber(int i10) {
                    return EnumC0333b.c(i10);
                }
            }

            EnumC0333b(int i10) {
                this.f18851a = i10;
            }

            public static EnumC0333b c(int i10) {
                if (i10 == 0) {
                    return UNKNOWN;
                }
                if (i10 == 1) {
                    return HTTP_SSL_ERROR;
                }
                if (i10 == 2) {
                    return HTTP_UKNOWN_HOST;
                }
                if (i10 == 3) {
                    return HTTP_REQUEST_TIMEOUT;
                }
                if (i10 == 4) {
                    return HTTP_SOCKET;
                }
                if (i10 != 5) {
                    return null;
                }
                return ANDROID_WORK_MANAGER_ISSUE;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f18851a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            b bVar = new b();
            DEFAULT_INSTANCE = bVar;
            GeneratedMessageLite.registerDefaultInstance(b.class, bVar);
        }

        private b() {
        }

        public static a c() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(EnumC0333b enumC0333b) {
            this.clientFailureType_ = enumC0333b.getNumber();
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            j jVar = null;
            switch (j.f18841a[methodToInvoke.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new a(jVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"bitField0_", "clientFailureType_"});
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

    /* JADX INFO: compiled from: MetricsRequest.java */
    public static final class c extends GeneratedMessageLite<c, a> implements MessageLiteOrBuilder {
        private static final c DEFAULT_INSTANCE;
        private static volatile Parser<c> PARSER = null;
        public static final int SERVER_HTTP_STATUS_FIELD_NUMBER = 1;
        private int bitField0_;
        private int serverHttpStatus_;

        /* JADX INFO: compiled from: MetricsRequest.java */
        public static final class a extends GeneratedMessageLite.Builder<c, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(j jVar) {
                this();
            }

            public a b(int i10) {
                copyOnWrite();
                ((c) this.instance).d(i10);
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
        public void d(int i10) {
            this.bitField0_ |= 1;
            this.serverHttpStatus_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            j jVar = null;
            switch (j.f18841a[methodToInvoke.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(jVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဋ\u0000", new Object[]{"bitField0_", "serverHttpStatus_"});
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
    public void e(b bVar) {
        bVar.getClass();
        this.errorType_ = bVar;
        this.errorTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(c cVar) {
        cVar.getClass();
        this.errorType_ = cVar;
        this.errorTypeCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        j jVar = null;
        switch (j.f18841a[methodToInvoke.ordinal()]) {
            case 1:
                return new l();
            case 2:
                return new a(jVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"errorType_", "errorTypeCase_", c.class, b.class});
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
