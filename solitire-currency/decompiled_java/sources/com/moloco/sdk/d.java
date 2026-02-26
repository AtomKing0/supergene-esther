package com.moloco.sdk;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* JADX INFO: compiled from: BidToken.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends GeneratedMessageLite<d, a> implements MessageLiteOrBuilder {
    private static final d DEFAULT_INSTANCE;
    public static final int ES_FIELD_NUMBER = 1;
    private static volatile Parser<d> PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    private ByteString es_;
    private ByteString payload_;

    /* JADX INFO: compiled from: BidToken.java */
    public static final class a extends GeneratedMessageLite.Builder<d, a> implements MessageLiteOrBuilder {
        /* synthetic */ a(com.moloco.sdk.a aVar) {
            this();
        }

        public a b(ByteString byteString) {
            copyOnWrite();
            ((d) this.instance).e(byteString);
            return this;
        }

        public a c(ByteString byteString) {
            copyOnWrite();
            ((d) this.instance).f(byteString);
            return this;
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
        ByteString byteString = ByteString.EMPTY;
        this.es_ = byteString;
        this.payload_ = byteString;
    }

    public static a d() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteString byteString) {
        byteString.getClass();
        this.es_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ByteString byteString) {
        byteString.getClass();
        this.payload_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.moloco.sdk.a aVar = null;
        switch (com.moloco.sdk.a.f17292a[methodToInvoke.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0002\n", new Object[]{"es_", "payload_"});
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
