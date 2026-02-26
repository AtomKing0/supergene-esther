package com.moloco.sdk;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* JADX INFO: compiled from: MetricsRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends GeneratedMessageLite<n, a> implements MessageLiteOrBuilder {
    private static final n DEFAULT_INSTANCE;
    public static final int FAILURE_FIELD_NUMBER = 2;
    public static final int LATENCY_MS_FIELD_NUMBER = 3;
    private static volatile Parser<n> PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int initStatusCase_ = 0;
    private Object initStatus_;
    private long latencyMs_;

    /* JADX INFO: compiled from: MetricsRequest.java */
    public static final class a extends GeneratedMessageLite.Builder<n, a> implements MessageLiteOrBuilder {
        /* synthetic */ a(j jVar) {
            this();
        }

        public a b(l lVar) {
            copyOnWrite();
            ((n) this.instance).f(lVar);
            return this;
        }

        public a c(long j10) {
            copyOnWrite();
            ((n) this.instance).g(j10);
            return this;
        }

        public a d(m mVar) {
            copyOnWrite();
            ((n) this.instance).h(mVar);
            return this;
        }

        private a() {
            super(n.DEFAULT_INSTANCE);
        }
    }

    static {
        n nVar = new n();
        DEFAULT_INSTANCE = nVar;
        GeneratedMessageLite.registerDefaultInstance(n.class, nVar);
    }

    private n() {
    }

    public static a e() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        lVar.getClass();
        this.initStatus_ = lVar;
        this.initStatusCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j10) {
        this.bitField0_ |= 1;
        this.latencyMs_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(m mVar) {
        mVar.getClass();
        this.initStatus_ = mVar;
        this.initStatusCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        j jVar = null;
        switch (j.f18841a[methodToInvoke.ordinal()]) {
            case 1:
                return new n();
            case 2:
                return new a(jVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003ဃ\u0000", new Object[]{"initStatus_", "initStatusCase_", "bitField0_", m.class, l.class, "latencyMs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<n> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (n.class) {
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
