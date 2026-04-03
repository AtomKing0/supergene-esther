package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.gatewayclient.GatewayClient;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import h9.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.j;
import s9.y;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: TransactionEventObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TransactionEventObserver {

    @NotNull
    private final k0 defaultDispatcher;

    @NotNull
    private final GatewayClient gatewayClient;

    @NotNull
    private final GetRequestPolicy getRequestPolicy;

    @NotNull
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    @NotNull
    private final ByteStringDataSource iapTransactionStore;

    @NotNull
    private final y<Boolean> isRunning;

    @NotNull
    private final TransactionEventRepository transactionEventRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransactionEventObserver.kt */
    @f(c = "com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2", f = "TransactionEventObserver.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super v8.k0>, Object> {
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TransactionEventObserver.kt */
        @f(c = "com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2$2", f = "TransactionEventObserver.kt", l = {44, 46, 55}, m = "invokeSuspend")
        static final class C04932 extends l implements p<TransactionEventRequestOuterClass.TransactionEventRequest, d<? super v8.k0>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionEventObserver this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C04932(TransactionEventObserver transactionEventObserver, d<? super C04932> dVar) {
                super(2, dVar);
                this.this$0 = transactionEventObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                C04932 c04932 = new C04932(this.this$0, dVar);
                c04932.L$0 = obj;
                return c04932;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequest, @Nullable d<? super v8.k0> dVar) {
                return ((C04932) create(transactionEventRequest, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = a9.b.e()
                    int r1 = r12.label
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L2a
                    if (r1 == r4) goto L26
                    if (r1 == r3) goto L1e
                    if (r1 != r2) goto L16
                    v8.u.b(r13)
                    goto Lac
                L16:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L1e:
                    java.lang.Object r1 = r12.L$0
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest r1 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest) r1
                    v8.u.b(r13)
                    goto L7d
                L26:
                    v8.u.b(r13)
                    goto L58
                L2a:
                    v8.u.b(r13)
                    java.lang.Object r13 = r12.L$0
                    gatewayprotocol.v1.TransactionEventRequestOuterClass$TransactionEventRequest r13 = (gatewayprotocol.v1.TransactionEventRequestOuterClass.TransactionEventRequest) r13
                    gatewayprotocol.v1.UniversalRequestKt r1 = gatewayprotocol.v1.UniversalRequestKt.INSTANCE
                    gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r1 = gatewayprotocol.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r5 = gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
                    java.lang.String r6 = "newBuilder()"
                    kotlin.jvm.internal.t.h(r5, r6)
                    gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl r1 = r1._create(r5)
                    r1.setTransactionEventRequest(r13)
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload r13 = r1._build()
                    com.unity3d.ads.core.domain.events.TransactionEventObserver r1 = r12.this$0
                    com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r1 = com.unity3d.ads.core.domain.events.TransactionEventObserver.access$getGetUniversalRequestForPayLoad$p(r1)
                    r12.label = r4
                    java.lang.Object r13 = r1.invoke(r13, r12)
                    if (r13 != r0) goto L58
                    return r0
                L58:
                    r1 = r13
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest r1 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest) r1
                    com.unity3d.ads.core.domain.events.TransactionEventObserver r13 = r12.this$0
                    com.unity3d.ads.gatewayclient.GatewayClient r4 = com.unity3d.ads.core.domain.events.TransactionEventObserver.access$getGatewayClient$p(r13)
                    r5 = 0
                    com.unity3d.ads.core.domain.events.TransactionEventObserver r13 = r12.this$0
                    com.unity3d.ads.core.domain.GetRequestPolicy r13 = com.unity3d.ads.core.domain.events.TransactionEventObserver.access$getGetRequestPolicy$p(r13)
                    com.unity3d.ads.gatewayclient.RequestPolicy r7 = r13.invoke()
                    com.unity3d.ads.core.data.model.OperationType r8 = com.unity3d.ads.core.data.model.OperationType.TRANSACTION_EVENT
                    r10 = 1
                    r11 = 0
                    r12.L$0 = r1
                    r12.label = r3
                    r6 = r1
                    r9 = r12
                    java.lang.Object r13 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r4, r5, r6, r7, r8, r9, r10, r11)
                    if (r13 != r0) goto L7d
                    return r0
                L7d:
                    gatewayprotocol.v1.UniversalResponseOuterClass$UniversalResponse r13 = (gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse) r13
                    gatewayprotocol.v1.ErrorOuterClass$Error r13 = r13.getError()
                    if (r13 == 0) goto Lac
                    com.unity3d.ads.core.domain.events.TransactionEventObserver r13 = r12.this$0
                    com.unity3d.ads.core.data.datasource.ByteStringDataSource r13 = com.unity3d.ads.core.domain.events.TransactionEventObserver.access$getIapTransactionStore$p(r13)
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$SharedData r1 = r1.getSharedData()
                    gatewayprotocol.v1.TimestampsOuterClass$Timestamps r1 = r1.getTimestamps()
                    com.google.protobuf.Timestamp r1 = r1.getTimestamp()
                    com.google.protobuf.ByteString r1 = r1.toByteString()
                    java.lang.String r3 = "fullRequest.sharedData.t….timestamp.toByteString()"
                    kotlin.jvm.internal.t.h(r1, r3)
                    r3 = 0
                    r12.L$0 = r3
                    r12.label = r2
                    java.lang.Object r13 = r13.set(r1, r12)
                    if (r13 != r0) goto Lac
                    return r0
                Lac:
                    v8.k0 r13 = v8.k0.f35197a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.TransactionEventObserver.AnonymousClass2.C04932.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        AnonymousClass2(d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return TransactionEventObserver.this.new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object value;
            Boolean bool;
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            y yVar = TransactionEventObserver.this.isRunning;
            do {
                value = yVar.getValue();
                bool = (Boolean) value;
                bool.booleanValue();
            } while (!yVar.d(value, b.a(true)));
            if (bool.booleanValue()) {
                return v8.k0.f35197a;
            }
            j.D(j.G(TransactionEventObserver.this.transactionEventRepository.getTransactionEvents(), new C04932(TransactionEventObserver.this, null)), p0.a(TransactionEventObserver.this.defaultDispatcher));
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super v8.k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public TransactionEventObserver(@NotNull GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, @NotNull k0 defaultDispatcher, @NotNull TransactionEventRepository transactionEventRepository, @NotNull GatewayClient gatewayClient, @NotNull GetRequestPolicy getRequestPolicy, @NotNull ByteStringDataSource iapTransactionStore) {
        t.i(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        t.i(defaultDispatcher, "defaultDispatcher");
        t.i(transactionEventRepository, "transactionEventRepository");
        t.i(gatewayClient, "gatewayClient");
        t.i(getRequestPolicy, "getRequestPolicy");
        t.i(iapTransactionStore, "iapTransactionStore");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.defaultDispatcher = defaultDispatcher;
        this.transactionEventRepository = transactionEventRepository;
        this.gatewayClient = gatewayClient;
        this.getRequestPolicy = getRequestPolicy;
        this.iapTransactionStore = iapTransactionStore;
        this.isRunning = s9.o0.a(Boolean.FALSE);
    }

    @Nullable
    public final Object invoke(@NotNull d<? super v8.k0> dVar) {
        Object objG = i.g(this.defaultDispatcher, new AnonymousClass2(null), dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }
}
