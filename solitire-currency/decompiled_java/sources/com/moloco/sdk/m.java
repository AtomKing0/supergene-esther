package com.moloco.sdk;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* JADX INFO: compiled from: MetricsRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends GeneratedMessageLite<m, a> implements MessageLiteOrBuilder {
    private static final m DEFAULT_INSTANCE;
    private static volatile Parser<m> PARSER;

    /* JADX INFO: compiled from: MetricsRequest.java */
    public static final class a extends GeneratedMessageLite.Builder<m, a> implements MessageLiteOrBuilder {
        /* synthetic */ a(j jVar) {
            this();
        }

        private a() {
            super(m.DEFAULT_INSTANCE);
        }
    }

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        GeneratedMessageLite.registerDefaultInstance(m.class, mVar);
    }

    private m() {
    }

    public static a b() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        j jVar = null;
        switch (j.f18841a[methodToInvoke.ordinal()]) {
            case 1:
                return new m();
            case 2:
                return new a(jVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<m> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (m.class) {
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
