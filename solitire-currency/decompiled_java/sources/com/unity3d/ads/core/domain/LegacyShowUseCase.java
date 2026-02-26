package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.adplayer.model.ShowStatus;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.extensions.ShowStatusExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import gatewayprotocol.v1.OperativeEventErrorDataKt;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import h9.p;
import h9.q;
import h9.t;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import q9.j;
import s9.i;
import s9.y;
import v8.u;

/* JADX INFO: compiled from: LegacyShowUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LegacyShowUseCase {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String KEY_OBJECT_ID = "objectId";

    @NotNull
    public static final String MESSAGE_AD_PLAYER_UNAVAILABLE = "Ad player is unavailable.";

    @NotNull
    public static final String MESSAGE_ALREADY_SHOWING = "Can't show a new ad unit when ad unit is already open";

    @NotNull
    public static final String MESSAGE_NO_AD_OBJECT = "No ad object found for opportunity id: ";

    @NotNull
    public static final String MESSAGE_OPPORTUNITY_ID = "No valid opportunity id provided";

    @NotNull
    public static final String MESSAGE_OPT_TIMEOUT = "timeout";

    @NotNull
    public static final String MESSAGE_TIMEOUT = "[UnityAds] Timeout while trying to show ";

    @NotNull
    public static final String MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
    private static volatile boolean isFullscreenAdShowing;

    @Nullable
    private AdObject adObject;

    @NotNull
    private final AdRepository adRepository;

    @NotNull
    private final k0 dispatcher;

    @NotNull
    private final GetInitializationState getInitializationState;

    @NotNull
    private final GetOperativeEventApi getOperativeEventApi;

    @NotNull
    private final y<Boolean> hasStarted;

    @Nullable
    private String placement;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final SessionRepository sessionRepository;

    @NotNull
    private final Show show;

    @NotNull
    private final y<Boolean> timeoutCancellationRequested;

    @Nullable
    private UnityAdsShowOptions unityAdsShowOptions;

    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$getTmpAdObject$1, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", l = {291}, m = "getTmpAdObject")
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
            return LegacyShowUseCase.this.getTmpAdObject(this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", l = {80, 85, 90, 96, 101, 104, 109, 116, 121, 152}, m = "invoke")
    static final class C31831 extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C31831(z8.d<? super C31831> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LegacyShowUseCase.this.invoke(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2", f = "LegacyShowUseCase.kt", l = {135, 141, 142}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<h9.a<? extends v8.k0>, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ boolean $isBanner;
        final /* synthetic */ String $placement;
        final /* synthetic */ t<String, UnityAds.UnityAdsShowError, String, Integer, String, z8.d<? super v8.k0>, Object> $reportShowError;
        final /* synthetic */ boolean $useTimeout;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(boolean z10, AdObject adObject, boolean z11, t<? super String, ? super UnityAds.UnityAdsShowError, ? super String, ? super Integer, ? super String, ? super z8.d<? super v8.k0>, ? extends Object> tVar, String str, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$isBanner = z10;
            this.$adObject = adObject;
            this.$useTimeout = z11;
            this.$reportShowError = tVar;
            this.$placement = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = LegacyShowUseCase.this.new AnonymousClass2(this.$isBanner, this.$adObject, this.$useTimeout, this.$reportShowError, this.$placement, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull h9.a<v8.k0> aVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((AnonymousClass2) create(aVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00b3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
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
                if (r1 == 0) goto L32
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r0 = r10.L$0
                h9.a r0 = (h9.a) r0
                v8.u.b(r11)
                goto Lb5
            L1a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L22:
                java.lang.Object r1 = r10.L$0
                h9.a r1 = (h9.a) r1
                v8.u.b(r11)
                goto L8d
            L2a:
                java.lang.Object r1 = r10.L$0
                h9.a r1 = (h9.a) r1
                v8.u.b(r11)
                goto L76
            L32:
                v8.u.b(r11)
                java.lang.Object r11 = r10.L$0
                r1 = r11
                h9.a r1 = (h9.a) r1
                com.unity3d.ads.core.domain.LegacyShowUseCase r11 = com.unity3d.ads.core.domain.LegacyShowUseCase.this
                s9.y r11 = com.unity3d.ads.core.domain.LegacyShowUseCase.access$getHasStarted$p(r11)
                java.lang.Object r11 = r11.getValue()
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 != 0) goto Lbb
                com.unity3d.ads.core.domain.LegacyShowUseCase r11 = com.unity3d.ads.core.domain.LegacyShowUseCase.this
                s9.y r11 = com.unity3d.ads.core.domain.LegacyShowUseCase.access$getTimeoutCancellationRequested$p(r11)
                java.lang.Object r11 = r11.getValue()
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 != 0) goto Lbb
                boolean r11 = r10.$isBanner
                if (r11 == 0) goto L63
                goto Lbb
            L63:
                com.unity3d.ads.core.domain.LegacyShowUseCase r11 = com.unity3d.ads.core.domain.LegacyShowUseCase.this
                gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventErrorType r5 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_TIMEOUT
                com.unity3d.ads.core.data.model.AdObject r6 = r10.$adObject
                r10.L$0 = r1
                r10.label = r4
                java.lang.String r4 = "timeout"
                java.lang.Object r11 = com.unity3d.ads.core.domain.LegacyShowUseCase.access$sendOperativeError(r11, r5, r4, r6, r10)
                if (r11 != r0) goto L76
                return r0
            L76:
                boolean r11 = r10.$useTimeout
                if (r11 == 0) goto Lb8
                com.unity3d.ads.core.domain.LegacyShowUseCase r11 = com.unity3d.ads.core.domain.LegacyShowUseCase.this
                com.unity3d.ads.core.domain.Show r11 = com.unity3d.ads.core.domain.LegacyShowUseCase.access$getShow$p(r11)
                com.unity3d.ads.core.data.model.AdObject r4 = r10.$adObject
                r10.L$0 = r1
                r10.label = r3
                java.lang.Object r11 = r11.terminate(r4, r10)
                if (r11 != r0) goto L8d
                return r0
            L8d:
                h9.t<java.lang.String, com.unity3d.ads.UnityAds$UnityAdsShowError, java.lang.String, java.lang.Integer, java.lang.String, z8.d<? super v8.k0>, java.lang.Object> r3 = r10.$reportShowError
                java.lang.String r4 = "timeout"
                com.unity3d.ads.UnityAds$UnityAdsShowError r5 = com.unity3d.ads.UnityAds.UnityAdsShowError.TIMEOUT
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r6 = "[UnityAds] Timeout while trying to show "
                r11.append(r6)
                java.lang.String r6 = r10.$placement
                r11.append(r6)
                java.lang.String r6 = r11.toString()
                r7 = 0
                r8 = 0
                r10.L$0 = r1
                r10.label = r2
                r9 = r10
                java.lang.Object r11 = r3.invoke(r4, r5, r6, r7, r8, r9)
                if (r11 != r0) goto Lb4
                return r0
            Lb4:
                r0 = r1
            Lb5:
                r0.invoke()
            Lb8:
                v8.k0 r11 = v8.k0.f35197a
                return r11
            Lbb:
                v8.k0 r11 = v8.k0.f35197a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(h9.a<? extends v8.k0> aVar, z8.d<? super v8.k0> dVar) {
            return invoke2((h9.a<v8.k0>) aVar, dVar);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3", f = "LegacyShowUseCase.kt", l = {147}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements q<i<? super ShowEvent>, Throwable, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ boolean $isBanner;
        final /* synthetic */ t<String, UnityAds.UnityAdsShowError, String, Integer, String, z8.d<? super v8.k0>, Object> $reportShowError;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(t<? super String, ? super UnityAds.UnityAdsShowError, ? super String, ? super Integer, ? super String, ? super z8.d<? super v8.k0>, ? extends Object> tVar, boolean z10, z8.d<? super AnonymousClass3> dVar) {
            super(3, dVar);
            this.$reportShowError = tVar;
            this.$isBanner = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Throwable th = (Throwable) this.L$0;
                t<String, UnityAds.UnityAdsShowError, String, Integer, String, z8.d<? super v8.k0>, Object> tVar = this.$reportShowError;
                UnityAds.UnityAdsShowError unityAdsShowError = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                this.label = 1;
                if (tVar.invoke("uncaught_exception", unityAdsShowError, message, null, null, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            if (!this.$isBanner) {
                LegacyShowUseCase.isFullscreenAdShowing = false;
            }
            return v8.k0.f35197a;
        }

        @Override // h9.q
        @Nullable
        public final Object invoke(@NotNull i<? super ShowEvent> iVar, @NotNull Throwable th, @Nullable z8.d<? super v8.k0> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$reportShowError, this.$isBanner, dVar);
            anonymousClass3.L$0 = th;
            return anonymousClass3.invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$2", f = "LegacyShowUseCase.kt", l = {}, m = "invokeSuspend")
    static final class C31842 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31842(Listeners listeners, String str, z8.d<? super C31842> dVar) {
            super(2, dVar);
            this.$listeners = listeners;
            this.$placement = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C31842(this.$listeners, this.$placement, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.$listeners.onClick(this.$placement);
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C31842) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$2", f = "LegacyShowUseCase.kt", l = {}, m = "invokeSuspend")
    static final class C31852 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;
        final /* synthetic */ ShowStatus $status;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31852(Listeners listeners, String str, ShowStatus showStatus, z8.d<? super C31852> dVar) {
            super(2, dVar);
            this.$listeners = listeners;
            this.$placement = str;
            this.$status = showStatus;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C31852(this.$listeners, this.$placement, this.$status, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.$listeners.onComplete(this.$placement, ShowStatusExtensionsKt.toUnityAdsShowCompletionState(this.$status));
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C31852) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1", f = "LegacyShowUseCase.kt", l = {272}, m = "invokeSuspend")
    static final class C31861 extends l implements t<String, UnityAds.UnityAdsShowError, String, Integer, String, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;
        final /* synthetic */ j $startTime;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ Object L$3;
        /* synthetic */ Object L$4;
        int label;
        final /* synthetic */ LegacyShowUseCase this$0;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: LegacyShowUseCase.kt */
        @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1$1", f = "LegacyShowUseCase.kt", l = {}, m = "invokeSuspend")
        static final class C04901 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
            final /* synthetic */ Listeners $listeners;
            final /* synthetic */ String $message;
            final /* synthetic */ String $placement;
            final /* synthetic */ UnityAds.UnityAdsShowError $reason;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C04901(Listeners listeners, String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2, z8.d<? super C04901> dVar) {
                super(2, dVar);
                this.$listeners = listeners;
                this.$placement = str;
                this.$reason = unityAdsShowError;
                this.$message = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C04901(this.$listeners, this.$placement, this.$reason, this.$message, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                this.$listeners.onError(this.$placement, this.$reason, this.$message);
                return v8.k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
                return ((C04901) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31861(String str, LegacyShowUseCase legacyShowUseCase, j jVar, Listeners listeners, z8.d<? super C31861> dVar) {
            super(6, dVar);
            this.$placement = str;
            this.this$0 = legacyShowUseCase;
            this.$startTime = jVar;
            this.$listeners = listeners;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                String str = (String) this.L$0;
                UnityAds.UnityAdsShowError unityAdsShowError = (UnityAds.UnityAdsShowError) this.L$1;
                String str2 = (String) this.L$2;
                Integer num = (Integer) this.L$3;
                String str3 = (String) this.L$4;
                DeviceLog.debug("Unity Ads Show Failed for placement " + this.$placement);
                SendDiagnosticEvent.DefaultImpls.invoke$default(this.this$0.sendDiagnosticEvent, "native_show_failure_time", kotlin.coroutines.jvm.internal.b.b(TimeExtensionsKt.elapsedMillis(this.$startTime)), this.this$0.getTags(str, num, str3), null, this.this$0.adObject, 8, null);
                k0 k0Var = this.this$0.dispatcher;
                C04901 c04901 = new C04901(this.$listeners, this.$placement, unityAdsShowError, str2, null);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 1;
                if (kotlinx.coroutines.i.g(k0Var, c04901, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return v8.k0.f35197a;
        }

        @Override // h9.t
        @Nullable
        public final Object invoke(@NotNull String str, @NotNull UnityAds.UnityAdsShowError unityAdsShowError, @NotNull String str2, @Nullable Integer num, @Nullable String str3, @Nullable z8.d<? super v8.k0> dVar) {
            C31861 c31861 = new C31861(this.$placement, this.this$0, this.$startTime, this.$listeners, dVar);
            c31861.L$0 = str;
            c31861.L$1 = unityAdsShowError;
            c31861.L$2 = str2;
            c31861.L$3 = num;
            c31861.L$4 = str3;
            return c31861.invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", l = {245}, m = "showStart")
    static final class C31871 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31871(z8.d<? super C31871> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LegacyShowUseCase.this.showStart(this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$2", f = "LegacyShowUseCase.kt", l = {}, m = "invokeSuspend")
    static final class C31882 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31882(Listeners listeners, String str, z8.d<? super C31882> dVar) {
            super(2, dVar);
            this.$listeners = listeners;
            this.$placement = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C31882(this.$listeners, this.$placement, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.$listeners.onStart(this.$placement);
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C31882) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public LegacyShowUseCase(@NotNull k0 dispatcher, @NotNull Show show, @NotNull AdRepository adRepository, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull GetOperativeEventApi getOperativeEventApi, @NotNull GetInitializationState getInitializationState, @NotNull SessionRepository sessionRepository) {
        kotlin.jvm.internal.t.i(dispatcher, "dispatcher");
        kotlin.jvm.internal.t.i(show, "show");
        kotlin.jvm.internal.t.i(adRepository, "adRepository");
        kotlin.jvm.internal.t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        kotlin.jvm.internal.t.i(getOperativeEventApi, "getOperativeEventApi");
        kotlin.jvm.internal.t.i(getInitializationState, "getInitializationState");
        kotlin.jvm.internal.t.i(sessionRepository, "sessionRepository");
        this.dispatcher = dispatcher;
        this.show = show;
        this.adRepository = adRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getOperativeEventApi = getOperativeEventApi;
        this.getInitializationState = getInitializationState;
        this.sessionRepository = sessionRepository;
        Boolean bool = Boolean.FALSE;
        this.hasStarted = s9.o0.a(bool);
        this.timeoutCancellationRequested = s9.o0.a(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bannerLeftApplication(j jVar, String str, Listeners listeners) {
        DeviceLog.debug("Unity Ads Show Left Application for placement " + str);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_left_app", Double.valueOf(TimeExtensionsKt.elapsedMillis(jVar)), null, null, this.adObject, 12, null);
        listeners.onLeftApplication(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTimeout(j jVar) {
        this.timeoutCancellationRequested.setValue(Boolean.TRUE);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_cancel_timeout", Double.valueOf(TimeExtensionsKt.elapsedMillis(jVar)), null, null, this.adObject, 12, null);
    }

    private final String getOpportunityId(UnityAdsShowOptions unityAdsShowOptions) {
        Object objOpt;
        JSONObject data = unityAdsShowOptions.getData();
        try {
            return UUID.fromString((data == null || (objOpt = data.opt("objectId")) == null) ? null : objOpt.toString()).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> getTags(String str, Integer num, String str2) {
        Map<String, String> mapL = r0.l(v8.y.a("operation", OperationType.SHOW.toString()), v8.y.a("reason", str), v8.y.a("show_has_started", String.valueOf(this.hasStarted.getValue().booleanValue())));
        if (num != null) {
            mapL.put("reason_code", String.valueOf(num.intValue()));
        }
        if (str2 != null) {
            mapL.put("reason_debug", str2);
        }
        return mapL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getTmpAdObject(z8.d<? super com.unity3d.ads.core.data.model.AdObject> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.unity3d.ads.core.domain.LegacyShowUseCase$getTmpAdObject$1 r0 = (com.unity3d.ads.core.domain.LegacyShowUseCase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.LegacyShowUseCase$getTmpAdObject$1 r0 = new com.unity3d.ads.core.domain.LegacyShowUseCase$getTmpAdObject$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r0 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r0
            v8.u.b(r14)
            goto L5d
        L2d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L35:
            v8.u.b(r14)
            com.unity3d.ads.UnityAdsShowOptions r14 = r13.unityAdsShowOptions
            if (r14 == 0) goto L41
            java.lang.String r14 = r13.getOpportunityId(r14)
            goto L42
        L41:
            r14 = 0
        L42:
            java.util.UUID r14 = java.util.UUID.fromString(r14)
            java.lang.String r2 = "fromString(opportunityId)"
            kotlin.jvm.internal.t.h(r14, r2)
            com.google.protobuf.ByteString r14 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toByteString(r14)
            com.unity3d.ads.core.data.repository.AdRepository r2 = r13.adRepository
            r0.L$0 = r13
            r0.label = r3
            java.lang.Object r14 = r2.getAd(r14, r0)
            if (r14 != r1) goto L5c
            return r1
        L5c:
            r0 = r13
        L5d:
            com.unity3d.ads.core.data.model.AdObject r14 = (com.unity3d.ads.core.data.model.AdObject) r14
            if (r14 == 0) goto L62
            return r14
        L62:
            com.unity3d.ads.UnityAdsShowOptions r14 = r0.unityAdsShowOptions
            if (r14 != 0) goto L6b
            com.unity3d.ads.UnityAdsShowOptions r14 = new com.unity3d.ads.UnityAdsShowOptions
            r14.<init>()
        L6b:
            com.unity3d.ads.core.data.model.AdObject r12 = new com.unity3d.ads.core.data.model.AdObject
            java.lang.String r14 = r0.getOpportunityId(r14)
            if (r14 == 0) goto L79
            com.google.protobuf.ByteString r14 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toISO8859ByteString(r14)
            if (r14 != 0) goto L7b
        L79:
            com.google.protobuf.ByteString r14 = com.google.protobuf.ByteString.EMPTY
        L7b:
            r2 = r14
            java.lang.String r14 = "getOpportunityId(showOpt…ing() ?: ByteString.EMPTY"
            kotlin.jvm.internal.t.h(r2, r14)
            java.lang.String r14 = r0.placement
            if (r14 != 0) goto L87
            java.lang.String r14 = ""
        L87:
            r3 = r14
            com.google.protobuf.ByteString r4 = com.google.protobuf.ByteString.EMPTY
            java.lang.String r14 = "EMPTY"
            kotlin.jvm.internal.t.h(r4, r14)
            r5 = 0
            r6 = 0
            com.unity3d.ads.UnityAdsLoadOptions r7 = new com.unity3d.ads.UnityAdsLoadOptions
            r7.<init>()
            r14 = 0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.b.a(r14)
            gatewayprotocol.v1.DiagnosticEventRequestOuterClass$DiagnosticAdType r9 = gatewayprotocol.v1.DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_UNSPECIFIED
            r10 = 16
            r11 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.getTmpAdObject(z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendOperativeError(OperativeEventRequestOuterClass.OperativeEventErrorType operativeEventErrorType, String str, AdObject adObject, z8.d<? super v8.k0> dVar) {
        OperativeEventErrorDataKt.Dsl.Companion companion = OperativeEventErrorDataKt.Dsl.Companion;
        OperativeEventRequestOuterClass.OperativeEventErrorData.Builder builderNewBuilder = OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder();
        kotlin.jvm.internal.t.h(builderNewBuilder, "newBuilder()");
        OperativeEventErrorDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setErrorType(operativeEventErrorType);
        dsl_create.setMessage(str);
        OperativeEventRequestOuterClass.OperativeEventErrorData operativeEventErrorData_build = dsl_create._build();
        GetOperativeEventApi getOperativeEventApi = this.getOperativeEventApi;
        OperativeEventRequestOuterClass.OperativeEventType operativeEventType = OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_SHOW_ERROR;
        ByteString byteString = operativeEventErrorData_build.toByteString();
        kotlin.jvm.internal.t.h(byteString, "errorData.toByteString()");
        Object objInvoke = getOperativeEventApi.invoke(operativeEventType, adObject, byteString, dVar);
        return objInvoke == a9.d.e() ? objInvoke : v8.k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showClicked(j jVar, String str, Listeners listeners, z8.d<? super v8.k0> dVar) {
        DeviceLog.debug("Unity Ads Show Clicked for placement " + str);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_clicked", kotlin.coroutines.jvm.internal.b.b(TimeExtensionsKt.elapsedMillis(jVar)), null, null, this.adObject, 12, null);
        Object objG = kotlinx.coroutines.i.g(this.dispatcher, new C31842(listeners, str, null), dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showCompleted(j jVar, String str, ShowStatus showStatus, Listeners listeners, z8.d<? super v8.k0> dVar) {
        DeviceLog.debug("Unity Ads Show Completed for placement " + str);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_success_time", kotlin.coroutines.jvm.internal.b.b(TimeExtensionsKt.elapsedMillis(jVar)), null, null, this.adObject, 12, null);
        Object objG = kotlinx.coroutines.i.g(this.dispatcher, new C31852(listeners, str, showStatus, null), dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }

    private final t<String, UnityAds.UnityAdsShowError, String, Integer, String, z8.d<? super v8.k0>, Object> showError(j jVar, String str, Listeners listeners) {
        return new C31861(str, this, jVar, listeners, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object showStart(z8.d<? super v8.k0> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase.C31871
            if (r0 == 0) goto L13
            r0 = r10
            com.unity3d.ads.core.domain.LegacyShowUseCase$showStart$1 r0 = (com.unity3d.ads.core.domain.LegacyShowUseCase.C31871) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.LegacyShowUseCase$showStart$1 r0 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showStart$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.SendDiagnosticEvent r0 = (com.unity3d.ads.core.domain.SendDiagnosticEvent) r0
            v8.u.b(r10)
            goto L51
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L39:
            v8.u.b(r10)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r10 = r9.sendDiagnosticEvent
            r0.L$0 = r10
            java.lang.String r2 = "native_show_started"
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r0 = r9.getTmpAdObject(r0)
            if (r0 != r1) goto L4d
            return r1
        L4d:
            r1 = r2
            r8 = r0
            r0 = r10
            r10 = r8
        L51:
            r4 = 0
            r3 = 0
            r2 = 0
            r5 = r10
            com.unity3d.ads.core.data.model.AdObject r5 = (com.unity3d.ads.core.data.model.AdObject) r5
            r6 = 14
            r7 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r0, r1, r2, r3, r4, r5, r6, r7)
            v8.k0 r10 = v8.k0.f35197a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.showStart(z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showStarted(j jVar, String str, Listeners listeners, z8.d<? super v8.k0> dVar) {
        DeviceLog.debug("Unity Ads Show WV Start for placement " + str);
        this.hasStarted.setValue(kotlin.coroutines.jvm.internal.b.a(true));
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_wv_started", kotlin.coroutines.jvm.internal.b.b(TimeExtensionsKt.elapsedMillis(jVar)), null, null, this.adObject, 12, null);
        Object objG = kotlinx.coroutines.i.g(this.dispatcher, new C31882(listeners, str, null), dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull android.content.Context r29, @org.jetbrains.annotations.Nullable java.lang.String r30, @org.jetbrains.annotations.Nullable com.unity3d.ads.UnityAdsShowOptions r31, @org.jetbrains.annotations.NotNull com.unity3d.ads.core.data.model.Listeners r32, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r33) {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.invoke(android.content.Context, java.lang.String, com.unity3d.ads.UnityAdsShowOptions, com.unity3d.ads.core.data.model.Listeners, z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyShowUseCase.kt */
    static final class AnonymousClass4<T> implements i {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ Listeners $listeners;
        final /* synthetic */ String $placement;
        final /* synthetic */ t<String, UnityAds.UnityAdsShowError, String, Integer, String, z8.d<? super v8.k0>, Object> $reportShowError;
        final /* synthetic */ long $startTime;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(long j10, String str, Listeners listeners, AdObject adObject, t<? super String, ? super UnityAds.UnityAdsShowError, ? super String, ? super Integer, ? super String, ? super z8.d<? super v8.k0>, ? extends Object> tVar) {
            this.$startTime = j10;
            this.$placement = str;
            this.$listeners = listeners;
            this.$adObject = adObject;
            this.$reportShowError = tVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x00fe A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(@org.jetbrains.annotations.NotNull com.unity3d.ads.core.data.model.ShowEvent r9, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r10) {
            /*
                Method dump skipped, instruction units count: 296
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.AnonymousClass4.emit(com.unity3d.ads.core.data.model.ShowEvent, z8.d):java.lang.Object");
        }

        @Override // s9.i
        public /* bridge */ /* synthetic */ Object emit(Object obj, z8.d dVar) {
            return emit((ShowEvent) obj, (z8.d<? super v8.k0>) dVar);
        }
    }
}
