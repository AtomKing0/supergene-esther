package com.vungle.ads.internal.protos;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: compiled from: Sdk.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c extends MessageLiteOrBuilder {
    Sdk$SDKError getErrors(int i10);

    int getErrorsCount();

    List<Sdk$SDKError> getErrorsList();
}
