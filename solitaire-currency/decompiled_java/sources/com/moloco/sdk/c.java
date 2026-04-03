package com.moloco.sdk;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* JADX INFO: compiled from: BidToken.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends GeneratedMessageLite<c, a> implements MessageLiteOrBuilder {
    public static final int BID_TOKEN_FIELD_NUMBER = 1;
    public static final int CLIENT_TOKEN_CONFIGS_FIELD_NUMBER = 3;
    private static final c DEFAULT_INSTANCE;
    private static volatile Parser<c> PARSER = null;
    public static final int PK_FIELD_NUMBER = 2;
    private b clientTokenConfigs_;
    private String bidToken_ = "";
    private String pk_ = "";

    /* JADX INFO: compiled from: BidToken.java */
    public static final class a extends GeneratedMessageLite.Builder<c, a> implements MessageLiteOrBuilder {
        /* synthetic */ a(com.moloco.sdk.a aVar) {
            this();
        }

        private a() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: BidToken.java */
    public static final class b extends GeneratedMessageLite<b, a> implements MessageLiteOrBuilder {
        private static final b DEFAULT_INSTANCE;
        public static final int ENABLE_DBT_FIELD_NUMBER = 1;
        private static volatile Parser<b> PARSER;
        private boolean enableDbt_;

        /* JADX INFO: compiled from: BidToken.java */
        public static final class a extends GeneratedMessageLite.Builder<b, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(com.moloco.sdk.a aVar) {
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

        public static b b() {
            return DEFAULT_INSTANCE;
        }

        public boolean c() {
            return this.enableDbt_;
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
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"enableDbt_"});
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
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.registerDefaultInstance(c.class, cVar);
    }

    private c() {
    }

    public static c f(byte[] bArr) throws InvalidProtocolBufferException {
        return (c) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public String b() {
        return this.bidToken_;
    }

    public b c() {
        b bVar = this.clientTokenConfigs_;
        return bVar == null ? b.b() : bVar;
    }

    public String d() {
        return this.pk_;
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
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\t", new Object[]{"bidToken_", "pk_", "clientTokenConfigs_"});
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

    public boolean e() {
        return this.clientTokenConfigs_ != null;
    }
}
