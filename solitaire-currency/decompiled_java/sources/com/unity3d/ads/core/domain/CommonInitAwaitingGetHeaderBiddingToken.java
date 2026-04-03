package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.core.misc.Utilities;
import h9.p;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q9.k;
import v8.k0;
import v8.y;

/* JADX INFO: compiled from: CommonInitAwaitingGetHeaderBiddingToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonInitAwaitingGetHeaderBiddingToken implements GetAsyncHeaderBiddingToken {

    @NotNull
    private final AwaitInitialization awaitInitialization;
    private boolean didAwaitInit;

    @NotNull
    private final GetHeaderBiddingToken getHeaderBiddingToken;

    @NotNull
    private final GetInitializationState getInitializationState;

    @Nullable
    private IUnityAdsTokenListener listener;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final SessionRepository sessionRepository;

    @Nullable
    private InitializationState startState;
    private final long startTime;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonInitAwaitingGetHeaderBiddingToken.kt */
    @f(c = "com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken", f = "CommonInitAwaitingGetHeaderBiddingToken.kt", l = {81}, m = "fetchToken")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
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
            return CommonInitAwaitingGetHeaderBiddingToken.this.fetchToken(this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonInitAwaitingGetHeaderBiddingToken.kt */
    @f(c = "com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken", f = "CommonInitAwaitingGetHeaderBiddingToken.kt", l = {56, 73}, m = "invoke")
    static final class C31801 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C31801(z8.d<? super C31801> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonInitAwaitingGetHeaderBiddingToken.this.invoke(null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: CommonInitAwaitingGetHeaderBiddingToken.kt */
    @f(c = "com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2", f = "CommonInitAwaitingGetHeaderBiddingToken.kt", l = {59, 63, 67}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super k0>, Object> {
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2$WhenMappings */
        /* JADX INFO: compiled from: CommonInitAwaitingGetHeaderBiddingToken.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[InitializationState.values().length];
                try {
                    iArr[InitializationState.INITIALIZED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[InitializationState.FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[InitializationState.NOT_INITIALIZED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[InitializationState.INITIALIZING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return CommonInitAwaitingGetHeaderBiddingToken.this.new AnonymousClass2(dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r10.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L22
                if (r1 == r4) goto L11
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
            L11:
                v8.u.b(r11)
                goto L86
            L16:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1e:
                v8.u.b(r11)
                goto L5a
            L22:
                v8.u.b(r11)
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.this
                com.unity3d.ads.core.domain.GetInitializationState r11 = r11.getGetInitializationState()
                com.unity3d.ads.core.data.model.InitializationState r11 = r11.invoke()
                int[] r1 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.AnonymousClass2.WhenMappings.$EnumSwitchMapping$0
                int r11 = r11.ordinal()
                r11 = r1[r11]
                if (r11 == r4) goto L7b
                if (r11 == r3) goto L7b
                if (r11 == r2) goto L41
                r1 = 4
                if (r11 == r1) goto L41
                goto L86
            L41:
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.this
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.access$setDidAwaitInit$p(r11, r4)
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.this
                com.unity3d.ads.core.domain.AwaitInitialization r4 = r11.getAwaitInitialization()
                r5 = 0
                r8 = 1
                r9 = 0
                r10.label = r3
                r7 = r10
                java.lang.Object r11 = com.unity3d.ads.core.domain.AwaitInitialization.DefaultImpls.invoke$default(r4, r5, r7, r8, r9)
                if (r11 != r0) goto L5a
                return r0
            L5a:
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.this
                com.unity3d.ads.core.data.repository.SessionRepository r11 = r11.getSessionRepository()
                boolean r11 = r11.getShouldInitialize()
                if (r11 != 0) goto L70
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.this
                java.lang.String r0 = "gateway"
                java.lang.String r1 = "!sessionRepository.shouldInitialize"
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.access$tokenFailure(r11, r0, r1)
                goto L86
            L70:
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.this
                r10.label = r2
                java.lang.Object r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.access$fetchToken(r11, r10)
                if (r11 != r0) goto L86
                return r0
            L7b:
                com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.this
                r10.label = r4
                java.lang.Object r11 = com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.access$fetchToken(r11, r10)
                if (r11 != r0) goto L86
                return r0
            L86:
                v8.k0 r11 = v8.k0.f35197a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public CommonInitAwaitingGetHeaderBiddingToken(@NotNull GetHeaderBiddingToken getHeaderBiddingToken, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull GetInitializationState getInitializationState, @NotNull AwaitInitialization awaitInitialization, @NotNull SessionRepository sessionRepository) {
        t.i(getHeaderBiddingToken, "getHeaderBiddingToken");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(getInitializationState, "getInitializationState");
        t.i(awaitInitialization, "awaitInitialization");
        t.i(sessionRepository, "sessionRepository");
        this.getHeaderBiddingToken = getHeaderBiddingToken;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getInitializationState = getInitializationState;
        this.awaitInitialization = awaitInitialization;
        this.sessionRepository = sessionRepository;
        this.startTime = k.f33196a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchToken(z8.d<? super v8.k0> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1 r0 = (com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1 r0 = new com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r0 = (com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken) r0
            v8.u.b(r6)     // Catch: java.lang.Exception -> L2e
            goto L49
        L2e:
            r6 = move-exception
            goto L51
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            v8.u.b(r6)
            com.unity3d.ads.core.domain.GetHeaderBiddingToken r6 = r5.getHeaderBiddingToken     // Catch: java.lang.Exception -> L4f
            r0.L$0 = r5     // Catch: java.lang.Exception -> L4f
            r0.label = r3     // Catch: java.lang.Exception -> L4f
            java.lang.Object r6 = r6.invoke(r0)     // Catch: java.lang.Exception -> L4f
            if (r6 != r1) goto L48
            return r1
        L48:
            r0 = r5
        L49:
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L2e
            r1 = r4
            r4 = r6
            r6 = r1
            goto L57
        L4f:
            r6 = move-exception
            r0 = r5
        L51:
            java.lang.String r6 = com.unity3d.ads.core.extensions.ExceptionExtensionsKt.retrieveUnityCrashValue(r6)
            java.lang.String r1 = "uncaught_exception"
        L57:
            if (r4 != 0) goto L5d
            r0.tokenFailure(r1, r6)
            goto L60
        L5d:
            r0.tokenSuccess(r4)
        L60:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.fetchToken(z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tokenFailure(String str, String str2) {
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        Double dValueOf = Double.valueOf(TimeExtensionsKt.elapsedMillis(k.a.c(this.startTime)));
        Map mapC = q0.c();
        mapC.put("sync", "false");
        mapC.put("state", String.valueOf(this.startState));
        mapC.put("complete_state", this.getInitializationState.invoke().toString());
        mapC.put("awaited_init", String.valueOf(this.didAwaitInit));
        if (str != null) {
        }
        if (str2 != null) {
            mapC.put("reason_debug", str2);
        }
        k0 k0Var = k0.f35197a;
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_gateway_token_failure_time", dValueOf, q0.b(mapC), null, null, 24, null);
        Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.ads.core.domain.a
            @Override // java.lang.Runnable
            public final void run() {
                CommonInitAwaitingGetHeaderBiddingToken.tokenFailure$lambda$4(this.f23819a);
            }
        });
    }

    static /* synthetic */ void tokenFailure$default(CommonInitAwaitingGetHeaderBiddingToken commonInitAwaitingGetHeaderBiddingToken, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        commonInitAwaitingGetHeaderBiddingToken.tokenFailure(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tokenFailure$lambda$4(CommonInitAwaitingGetHeaderBiddingToken this$0) {
        t.i(this$0, "this$0");
        IUnityAdsTokenListener iUnityAdsTokenListener = this$0.listener;
        if (iUnityAdsTokenListener != null) {
            iUnityAdsTokenListener.onUnityAdsTokenReady(null);
        }
    }

    private final void tokenStart() {
        this.startState = this.getInitializationState.invoke();
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_gateway_token_started", null, r0.j(y.a("sync", "false"), y.a("state", String.valueOf(this.startState))), null, null, 26, null);
    }

    private final void tokenSuccess(final String str) {
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_gateway_token_success_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(k.a.c(this.startTime))), r0.j(y.a("sync", "false"), y.a("state", String.valueOf(this.startState)), y.a("complete_state", this.getInitializationState.invoke().toString()), y.a("awaited_init", String.valueOf(this.didAwaitInit))), null, null, 24, null);
        Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.ads.core.domain.b
            @Override // java.lang.Runnable
            public final void run() {
                CommonInitAwaitingGetHeaderBiddingToken.tokenSuccess$lambda$0(this.f23820a, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tokenSuccess$lambda$0(CommonInitAwaitingGetHeaderBiddingToken this$0, String token) {
        t.i(this$0, "this$0");
        t.i(token, "$token");
        IUnityAdsTokenListener iUnityAdsTokenListener = this$0.listener;
        if (iUnityAdsTokenListener != null) {
            iUnityAdsTokenListener.onUnityAdsTokenReady(token);
        }
    }

    @NotNull
    public final AwaitInitialization getAwaitInitialization() {
        return this.awaitInitialization;
    }

    @NotNull
    public final GetHeaderBiddingToken getGetHeaderBiddingToken() {
        return this.getHeaderBiddingToken;
    }

    @NotNull
    public final GetInitializationState getGetInitializationState() {
        return this.getInitializationState;
    }

    @Nullable
    public final IUnityAdsTokenListener getListener() {
        return this.listener;
    }

    @NotNull
    public final SendDiagnosticEvent getSendDiagnosticEvent() {
        return this.sendDiagnosticEvent;
    }

    @NotNull
    public final SessionRepository getSessionRepository() {
        return this.sessionRepository;
    }

    /* JADX INFO: renamed from: getStartTime-z9LOYto, reason: not valid java name */
    public final long m3995getStartTimez9LOYto() {
        return this.startTime;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.Nullable com.unity3d.ads.IUnityAdsTokenListener r7, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.C31801
            if (r0 == 0) goto L13
            r0 = r8
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1 r0 = (com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.C31801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1 r0 = new com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3d
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            v8.u.b(r8)
            goto L8e
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$0
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken r7 = (com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken) r7
            v8.u.b(r8)     // Catch: kotlinx.coroutines.d3 -> L83
            goto L8e
        L3d:
            v8.u.b(r8)
            r6.listener = r7
            r6.tokenStart()
            if (r7 != 0) goto L51
            java.lang.String r7 = "listener_null"
            java.lang.String r8 = "IUnityAdsTokenListener is null"
            r6.tokenFailure(r7, r8)
            v8.k0 r7 = v8.k0.f35197a
            return r7
        L51:
            com.unity3d.ads.core.data.repository.SessionRepository r7 = r6.sessionRepository
            boolean r7 = r7.getShouldInitialize()
            if (r7 != 0) goto L63
            java.lang.String r7 = "gateway"
            java.lang.String r8 = "!sessionRepository.shouldInitialize"
            r6.tokenFailure(r7, r8)
            v8.k0 r7 = v8.k0.f35197a
            return r7
        L63:
            com.unity3d.ads.core.data.repository.SessionRepository r7 = r6.sessionRepository
            gatewayprotocol.v1.NativeConfigurationOuterClass$NativeConfiguration r7 = r7.getNativeConfiguration()
            gatewayprotocol.v1.NativeConfigurationOuterClass$AdOperationsConfiguration r7 = r7.getAdOperations()
            int r7 = r7.getGetTokenTimeoutMs()
            long r7 = (long) r7
            com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2 r2 = new com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2     // Catch: kotlinx.coroutines.d3 -> L82
            r2.<init>(r3)     // Catch: kotlinx.coroutines.d3 -> L82
            r0.L$0 = r6     // Catch: kotlinx.coroutines.d3 -> L82
            r0.label = r5     // Catch: kotlinx.coroutines.d3 -> L82
            java.lang.Object r7 = kotlinx.coroutines.f3.c(r7, r2, r0)     // Catch: kotlinx.coroutines.d3 -> L82
            if (r7 != r1) goto L8e
            return r1
        L82:
            r7 = r6
        L83:
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r7 = r7.fetchToken(r0)
            if (r7 != r1) goto L8e
            return r1
        L8e:
            v8.k0 r7 = v8.k0.f35197a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken.invoke(com.unity3d.ads.IUnityAdsTokenListener, z8.d):java.lang.Object");
    }

    public final void setListener(@Nullable IUnityAdsTokenListener iUnityAdsTokenListener) {
        this.listener = iUnityAdsTokenListener;
    }
}
