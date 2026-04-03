package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.domain.GetByteStringId;
import com.unity3d.ads.core.extensions.TimestampExtensionsKt;
import com.unity3d.ads.core.extensions.TransactionStateExtensionsKt;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge;
import gatewayprotocol.v1.TransactionDataKt;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* JADX INFO: compiled from: GetAndroidTransactionData.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAndroidTransactionData implements GetTransactionData {

    @NotNull
    private final GetByteStringId getByteStringId;

    public GetAndroidTransactionData(@NotNull GetByteStringId getByteStringId) {
        t.i(getByteStringId, "getByteStringId");
        this.getByteStringId = getByteStringId;
    }

    @Override // com.unity3d.ads.core.domain.events.GetTransactionData
    @NotNull
    public TransactionEventRequestOuterClass.TransactionData invoke(@NotNull PurchaseBridge purchaseDetail, @NotNull SkuDetailsBridge productDetail) throws JSONException {
        t.i(purchaseDetail, "purchaseDetail");
        t.i(productDetail, "productDetail");
        TransactionDataKt.Dsl.Companion companion = TransactionDataKt.Dsl.Companion;
        TransactionEventRequestOuterClass.TransactionData.Builder builderNewBuilder = TransactionEventRequestOuterClass.TransactionData.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        TransactionDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setProductId(purchaseDetail.getOriginalJson().get(InAppPurchaseMetaData.KEY_PRODUCT_ID).toString());
        dsl_create.setEventId(this.getByteStringId.invoke());
        Object obj = purchaseDetail.getOriginalJson().get("purchaseTime");
        t.g(obj, "null cannot be cast to non-null type kotlin.Long");
        dsl_create.setTimestamp(TimestampExtensionsKt.fromMillis(((Long) obj).longValue()));
        dsl_create.setTransactionId(purchaseDetail.getOriginalJson().get("orderId").toString());
        String string = productDetail.getOriginalJson().toString();
        t.h(string, "productDetail.originalJson.toString()");
        dsl_create.setProduct(string);
        String string2 = purchaseDetail.getOriginalJson().toString();
        t.h(string2, "purchaseDetail.originalJson.toString()");
        dsl_create.setTransaction(string2);
        Object obj2 = purchaseDetail.getOriginalJson().get("purchaseState");
        t.g(obj2, "null cannot be cast to non-null type kotlin.Int");
        dsl_create.setTransactionState(TransactionStateExtensionsKt.fromPurchaseState(((Integer) obj2).intValue()));
        return dsl_create._build();
    }
}
