package com.moloco.sdk;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* JADX INFO: compiled from: BidToken.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends GeneratedMessageLite<b, a> implements MessageLiteOrBuilder {
    private static final b DEFAULT_INSTANCE;
    private static volatile Parser<b> PARSER;

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

    public static a b() {
        return DEFAULT_INSTANCE.createBuilder();
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
