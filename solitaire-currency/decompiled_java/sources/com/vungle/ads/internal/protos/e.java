package com.vungle.ads.internal.protos;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;

/* JADX INFO: compiled from: Sdk.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e extends MessageLiteOrBuilder {
    String getConnectionType();

    ByteString getConnectionTypeBytes();

    String getConnectionTypeDetail();

    ByteString getConnectionTypeDetailBytes();

    String getCreativeId();

    ByteString getCreativeIdBytes();

    String getEventId();

    ByteString getEventIdBytes();

    long getIsHbPlacement();

    String getMake();

    ByteString getMakeBytes();

    String getMeta();

    ByteString getMetaBytes();

    String getModel();

    ByteString getModelBytes();

    String getOs();

    ByteString getOsBytes();

    String getOsVersion();

    ByteString getOsVersionBytes();

    String getPlacementReferenceId();

    ByteString getPlacementReferenceIdBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    Sdk$SDKMetric.b getType();

    int getTypeValue();

    long getValue();
}
