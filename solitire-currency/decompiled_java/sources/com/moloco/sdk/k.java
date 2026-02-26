package com.moloco.sdk;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.util.List;

/* JADX INFO: compiled from: MetricsRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends GeneratedMessageLite<k, a> implements MessageLiteOrBuilder {
    public static final int COUNTS_FIELD_NUMBER = 1;
    private static final k DEFAULT_INSTANCE;
    public static final int DURATIONS_FIELD_NUMBER = 2;
    private static volatile Parser<k> PARSER;
    private Internal.ProtobufList<b> counts_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<c> durations_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: compiled from: MetricsRequest.java */
    public static final class a extends GeneratedMessageLite.Builder<k, a> implements MessageLiteOrBuilder {
        /* synthetic */ a(j jVar) {
            this();
        }

        public a b(Iterable<? extends b> iterable) {
            copyOnWrite();
            ((k) this.instance).d(iterable);
            return this;
        }

        public a c(Iterable<? extends c> iterable) {
            copyOnWrite();
            ((k) this.instance).e(iterable);
            return this;
        }

        private a() {
            super(k.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: MetricsRequest.java */
    public static final class b extends GeneratedMessageLite<b, a> implements MessageLiteOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 2;
        private static final b DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<b> PARSER = null;
        public static final int TAGS_FIELD_NUMBER = 3;
        private int count_;
        private String name_ = "";
        private Internal.ProtobufList<String> tags_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: MetricsRequest.java */
        public static final class a extends GeneratedMessageLite.Builder<b, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(j jVar) {
                this();
            }

            public a b(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).e(iterable);
                return this;
            }

            public a c(int i10) {
                copyOnWrite();
                ((b) this.instance).h(i10);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((b) this.instance).setName(str);
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

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Iterable<String> iterable) {
            f();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.tags_);
        }

        private void f() {
            Internal.ProtobufList<String> protobufList = this.tags_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.tags_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static a g() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i10) {
            this.count_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
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
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u000b\u0003Ț", new Object[]{"name_", "count_", "tags_"});
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
        public static final int ELAPSED_TIME_MILLIS_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<c> PARSER = null;
        public static final int TAGS_FIELD_NUMBER = 3;
        private long elapsedTimeMillis_;
        private String name_ = "";
        private Internal.ProtobufList<String> tags_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: MetricsRequest.java */
        public static final class a extends GeneratedMessageLite.Builder<c, a> implements MessageLiteOrBuilder {
            /* synthetic */ a(j jVar) {
                this();
            }

            public a b(Iterable<String> iterable) {
                copyOnWrite();
                ((c) this.instance).e(iterable);
                return this;
            }

            public a c(long j10) {
                copyOnWrite();
                ((c) this.instance).h(j10);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((c) this.instance).setName(str);
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

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Iterable<String> iterable) {
            f();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.tags_);
        }

        private void f() {
            Internal.ProtobufList<String> protobufList = this.tags_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.tags_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static a g() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(long j10) {
            this.elapsedTimeMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
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
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0003\u0003Ț", new Object[]{"name_", "elapsedTimeMillis_", "tags_"});
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
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        GeneratedMessageLite.registerDefaultInstance(k.class, kVar);
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Iterable<? extends b> iterable) {
        f();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.counts_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Iterable<? extends c> iterable) {
        g();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.durations_);
    }

    private void f() {
        Internal.ProtobufList<b> protobufList = this.counts_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.counts_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void g() {
        Internal.ProtobufList<c> protobufList = this.durations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.durations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static a h() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        j jVar = null;
        switch (j.f18841a[methodToInvoke.ordinal()]) {
            case 1:
                return new k();
            case 2:
                return new a(jVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"counts_", b.class, "durations_", c.class});
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
