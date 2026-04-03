package com.vungle.ads.internal.protos;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Sdk$MetricBatch extends GeneratedMessageLite<Sdk$MetricBatch, a> implements b {
    private static final Sdk$MetricBatch DEFAULT_INSTANCE;
    public static final int METRICS_FIELD_NUMBER = 1;
    private static volatile Parser<Sdk$MetricBatch> PARSER;
    private Internal.ProtobufList<Sdk$SDKMetric> metrics_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.Builder<Sdk$MetricBatch, a> implements b {
        /* synthetic */ a(com.vungle.ads.internal.protos.a aVar) {
            this();
        }

        public a addAllMetrics(Iterable<? extends Sdk$SDKMetric> iterable) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addAllMetrics(iterable);
            return this;
        }

        public a addMetrics(Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addMetrics(sdk$SDKMetric);
            return this;
        }

        public a clearMetrics() {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).clearMetrics();
            return this;
        }

        @Override // com.vungle.ads.internal.protos.b
        public Sdk$SDKMetric getMetrics(int i10) {
            return ((Sdk$MetricBatch) this.instance).getMetrics(i10);
        }

        @Override // com.vungle.ads.internal.protos.b
        public int getMetricsCount() {
            return ((Sdk$MetricBatch) this.instance).getMetricsCount();
        }

        @Override // com.vungle.ads.internal.protos.b
        public List<Sdk$SDKMetric> getMetricsList() {
            return Collections.unmodifiableList(((Sdk$MetricBatch) this.instance).getMetricsList());
        }

        public a removeMetrics(int i10) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).removeMetrics(i10);
            return this;
        }

        public a setMetrics(int i10, Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).setMetrics(i10, sdk$SDKMetric);
            return this;
        }

        private a() {
            super(Sdk$MetricBatch.DEFAULT_INSTANCE);
        }

        public a addMetrics(int i10, Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addMetrics(i10, sdk$SDKMetric);
            return this;
        }

        public a setMetrics(int i10, Sdk$SDKMetric.a aVar) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).setMetrics(i10, aVar.build());
            return this;
        }

        public a addMetrics(Sdk$SDKMetric.a aVar) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addMetrics(aVar.build());
            return this;
        }

        public a addMetrics(int i10, Sdk$SDKMetric.a aVar) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addMetrics(i10, aVar.build());
            return this;
        }
    }

    static {
        Sdk$MetricBatch sdk$MetricBatch = new Sdk$MetricBatch();
        DEFAULT_INSTANCE = sdk$MetricBatch;
        GeneratedMessageLite.registerDefaultInstance(Sdk$MetricBatch.class, sdk$MetricBatch);
    }

    private Sdk$MetricBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMetrics(Iterable<? extends Sdk$SDKMetric> iterable) {
        ensureMetricsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.metrics_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.add(sdk$SDKMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetrics() {
        this.metrics_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMetricsIsMutable() {
        Internal.ProtobufList<Sdk$SDKMetric> protobufList = this.metrics_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.metrics_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Sdk$MetricBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Sdk$MetricBatch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$MetricBatch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Sdk$MetricBatch> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMetrics(int i10) {
        ensureMetricsIsMutable();
        this.metrics_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetrics(int i10, Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.set(i10, sdk$SDKMetric);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.vungle.ads.internal.protos.a aVar = null;
        switch (com.vungle.ads.internal.protos.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$MetricBatch();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"metrics_", Sdk$SDKMetric.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Sdk$MetricBatch> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (Sdk$MetricBatch.class) {
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

    @Override // com.vungle.ads.internal.protos.b
    public Sdk$SDKMetric getMetrics(int i10) {
        return this.metrics_.get(i10);
    }

    @Override // com.vungle.ads.internal.protos.b
    public int getMetricsCount() {
        return this.metrics_.size();
    }

    @Override // com.vungle.ads.internal.protos.b
    public List<Sdk$SDKMetric> getMetricsList() {
        return this.metrics_;
    }

    public e getMetricsOrBuilder(int i10) {
        return this.metrics_.get(i10);
    }

    public List<? extends e> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    public static a newBuilder(Sdk$MetricBatch sdk$MetricBatch) {
        return DEFAULT_INSTANCE.createBuilder(sdk$MetricBatch);
    }

    public static Sdk$MetricBatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(int i10, Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.add(i10, sdk$SDKMetric);
    }

    public static Sdk$MetricBatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$MetricBatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$MetricBatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Sdk$MetricBatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
