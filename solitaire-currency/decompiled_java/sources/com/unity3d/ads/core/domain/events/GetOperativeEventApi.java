package com.unity3d.ads.core.domain.events;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: GetOperativeEventApi.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetOperativeEventApi {

    @NotNull
    private final OperativeEventRepository operativeEventRepository;

    @NotNull
    private final GetOperativeEventRequest operativeEventRequest;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetOperativeEventApi.kt */
    @f(c = "com.unity3d.ads.core.domain.events.GetOperativeEventApi", f = "GetOperativeEventApi.kt", l = {20}, m = "invoke")
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetOperativeEventApi.this.invoke(null, null, null, null, null, this);
        }
    }

    public GetOperativeEventApi(@NotNull OperativeEventRepository operativeEventRepository, @NotNull GetOperativeEventRequest operativeEventRequest) {
        t.i(operativeEventRepository, "operativeEventRepository");
        t.i(operativeEventRequest, "operativeEventRequest");
        this.operativeEventRepository = operativeEventRepository;
        this.operativeEventRequest = operativeEventRequest;
    }

    public static /* synthetic */ Object invoke$default(GetOperativeEventApi getOperativeEventApi, OperativeEventRequestOuterClass.OperativeEventType operativeEventType, ByteString byteString, ByteString byteString2, ByteString byteString3, String str, z8.d dVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            str = null;
        }
        return getOperativeEventApi.invoke(operativeEventType, byteString, byteString2, byteString3, str, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventType r9, @org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r10, @org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r11, @org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r14) {
        /*
            r8 = this;
            boolean r0 = r14 instanceof com.unity3d.ads.core.domain.events.GetOperativeEventApi.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1 r0 = (com.unity3d.ads.core.domain.events.GetOperativeEventApi.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1 r0 = new com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1
            r0.<init>(r14)
        L18:
            r7 = r0
            java.lang.Object r14 = r7.result
            java.lang.Object r0 = a9.b.e()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r9 = r7.L$0
            com.unity3d.ads.core.domain.events.GetOperativeEventApi r9 = (com.unity3d.ads.core.domain.events.GetOperativeEventApi) r9
            v8.u.b(r14)
            goto L4c
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            v8.u.b(r14)
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest r1 = r8.operativeEventRequest
            r7.L$0 = r8
            r7.label = r2
            r2 = r9
            r3 = r11
            r4 = r10
            r5 = r12
            r6 = r13
            java.lang.Object r14 = r1.invoke(r2, r3, r4, r5, r6, r7)
            if (r14 != r0) goto L4b
            return r0
        L4b:
            r9 = r8
        L4c:
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventRequest r14 = (gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventRequest) r14
            com.unity3d.ads.core.data.repository.OperativeEventRepository r9 = r9.operativeEventRepository
            r9.addOperativeEvent(r14)
            v8.k0 r9 = v8.k0.f35197a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.GetOperativeEventApi.invoke(gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventType, com.google.protobuf.ByteString, com.google.protobuf.ByteString, com.google.protobuf.ByteString, java.lang.String, z8.d):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull OperativeEventRequestOuterClass.OperativeEventType operativeEventType, @NotNull AdObject adObject, @NotNull ByteString byteString, @NotNull z8.d<? super k0> dVar) {
        Object objInvoke = invoke(operativeEventType, adObject.getOpportunityId(), adObject.getTrackingToken(), byteString, adObject.getPlayerServerId(), dVar);
        return objInvoke == a9.d.e() ? objInvoke : k0.f35197a;
    }
}
