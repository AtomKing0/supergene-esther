package com.vungle.ads.internal.protos;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: compiled from: Sdk.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b extends MessageLiteOrBuilder {
    Sdk$SDKMetric getMetrics(int i10);

    int getMetricsCount();

    List<Sdk$SDKMetric> getMetricsList();
}
