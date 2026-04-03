package com.unity3d.ads.adplayer;

import android.util.Base64;
import androidx.annotation.CallSuper;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.adplayer.model.OnActivityDestroyedEvent;
import com.unity3d.ads.adplayer.model.OnAllowedPiiChangeEvent;
import com.unity3d.ads.adplayer.model.OnBroadcastEvent;
import com.unity3d.ads.adplayer.model.OnFocusChangeEvent;
import com.unity3d.ads.adplayer.model.OnMuteChangeEvent;
import com.unity3d.ads.adplayer.model.OnPrivacyFsmChangeEvent;
import com.unity3d.ads.adplayer.model.OnUserConsentChangeEvent;
import com.unity3d.ads.adplayer.model.OnVisibilityChangeEvent;
import com.unity3d.ads.adplayer.model.OnVolumeChangeEvent;
import com.unity3d.ads.adplayer.model.WebViewEvent;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.ExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageEventInfo;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import h9.l;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import s9.c0;
import s9.h;
import s9.i;
import s9.i0;
import s9.j;
import s9.x;
import s9.y;
import v8.s;

/* JADX INFO: compiled from: WebViewAdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WebViewAdPlayer implements AdPlayer {

    @NotNull
    private final WebViewBridge bridge;

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final k0 dispatcher;

    @NotNull
    private final ExecuteAdViewerRequest executeAdViewerRequest;

    @NotNull
    private final y<Boolean> isCompletedManually;

    @NotNull
    private final h<String> onBroadcastEvents;

    @NotNull
    private final h<LoadEvent> onLoadEvent;

    @NotNull
    private final h<v8.k0> onRequestEvents;

    @NotNull
    private final h<ShowEvent> onShowEvent;

    @NotNull
    private final o0 scope;

    @NotNull
    private final l0 scopeCancellationHandler;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final SessionRepository sessionRepository;

    @NotNull
    private final l<StorageEventInfo, v8.k0> storageEventCallback;

    @NotNull
    private final h<s<byte[], Integer>> updateCampaignState;

    @NotNull
    private final WebViewContainer webViewContainer;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$1, reason: invalid class name */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    /* synthetic */ class AnonymousClass1 extends q implements p<String, z8.d<? super v8.k0>, Object> {
        AnonymousClass1(Object obj) {
            super(2, obj, x.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull String str, @NotNull z8.d<? super v8.k0> dVar) {
            return ((x) this.receiver).emit(str, dVar);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$2, reason: invalid class name */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    /* synthetic */ class AnonymousClass2 extends q implements p<String, z8.d<? super v8.k0>, Object> {
        AnonymousClass2(Object obj) {
            super(2, obj, WebViewAdPlayer.class, "onBroadcastEvent", "onBroadcastEvent(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull String str, @NotNull z8.d<? super v8.k0> dVar) {
            return ((WebViewAdPlayer) this.receiver).onBroadcastEvent(str, dVar);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$onAllowedPiiChange$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31532 extends v implements h9.a<WebViewEvent> {
        final /* synthetic */ byte[] $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31532(byte[] bArr) {
            super(0);
            this.$value = bArr;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() {
            String strEncodeToString = Base64.encodeToString(this.$value, 2);
            t.h(strEncodeToString, "encodeToString(value, Base64.NO_WRAP)");
            return new OnAllowedPiiChangeEvent(strEncodeToString);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$onBroadcastEvent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31542 extends v implements h9.a<WebViewEvent> {
        final /* synthetic */ String $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31542(String str) {
            super(0);
            this.$event = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() throws JSONException {
            JSONObject jSONObject = new JSONObject(this.$event);
            String eventType = jSONObject.getString("eventType");
            String strOptString = jSONObject.optString("data");
            t.h(eventType, "eventType");
            return new OnBroadcastEvent(eventType, strOptString);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$requestShow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer", f = "WebViewAdPlayer.kt", l = {213, 214, 229}, m = "requestShow")
    static final class C31551 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C31551(z8.d<? super C31551> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebViewAdPlayer.this.requestShow(null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$sendActivityDestroyed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31562 extends v implements h9.a<WebViewEvent> {
        public static final C31562 INSTANCE = new C31562();

        C31562() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() {
            return new OnActivityDestroyedEvent();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$sendEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer", f = "WebViewAdPlayer.kt", l = {241, 255}, m = "sendEvent")
    static final class C31571 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31571(z8.d<? super C31571> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebViewAdPlayer.this.sendEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$sendFocusChange$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31582 extends v implements h9.a<WebViewEvent> {
        final /* synthetic */ boolean $isFocused;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31582(boolean z10) {
            super(0);
            this.$isFocused = z10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() {
            return new OnFocusChangeEvent(this.$isFocused);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$sendMuteChange$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31592 extends v implements h9.a<WebViewEvent> {
        final /* synthetic */ boolean $isMuted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31592(boolean z10) {
            super(0);
            this.$isMuted = z10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() {
            return new OnMuteChangeEvent(this.$isMuted);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$sendPrivacyFsmChange$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31602 extends v implements h9.a<WebViewEvent> {
        final /* synthetic */ byte[] $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31602(byte[] bArr) {
            super(0);
            this.$value = bArr;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() {
            String strEncodeToString = Base64.encodeToString(this.$value, 2);
            t.h(strEncodeToString, "encodeToString(value, Base64.NO_WRAP)");
            return new OnPrivacyFsmChangeEvent(strEncodeToString);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$sendUserConsentChange$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31612 extends v implements h9.a<WebViewEvent> {
        final /* synthetic */ byte[] $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31612(byte[] bArr) {
            super(0);
            this.$value = bArr;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() {
            String strEncodeToString = Base64.encodeToString(this.$value, 2);
            t.h(strEncodeToString, "encodeToString(value, Base64.NO_WRAP)");
            return new OnUserConsentChangeEvent(strEncodeToString);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$sendVisibilityChange$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31622 extends v implements h9.a<WebViewEvent> {
        final /* synthetic */ boolean $isVisible;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31622(boolean z10) {
            super(0);
            this.$isVisible = z10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() {
            return new OnVisibilityChangeEvent(this.$isVisible);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$sendVolumeChange$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewAdPlayer.kt */
    static final class C31632 extends v implements h9.a<WebViewEvent> {
        final /* synthetic */ double $volume;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31632(double d10) {
            super(0);
            this.$volume = d10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final WebViewEvent invoke() {
            return new OnVolumeChangeEvent(this.$volume);
        }
    }

    public WebViewAdPlayer(@NotNull WebViewBridge bridge, @NotNull DeviceInfoRepository deviceInfoRepository, @NotNull SessionRepository sessionRepository, @NotNull ExecuteAdViewerRequest executeAdViewerRequest, @NotNull k0 dispatcher, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull WebViewContainer webViewContainer, @NotNull o0 adPlayerScope) {
        t.i(bridge, "bridge");
        t.i(deviceInfoRepository, "deviceInfoRepository");
        t.i(sessionRepository, "sessionRepository");
        t.i(executeAdViewerRequest, "executeAdViewerRequest");
        t.i(dispatcher, "dispatcher");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(webViewContainer, "webViewContainer");
        t.i(adPlayerScope, "adPlayerScope");
        this.bridge = bridge;
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.executeAdViewerRequest = executeAdViewerRequest;
        this.dispatcher = dispatcher;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.webViewContainer = webViewContainer;
        y<Boolean> yVarA = s9.o0.a(Boolean.FALSE);
        this.isCompletedManually = yVarA;
        WebViewAdPlayer$storageEventCallback$1 webViewAdPlayer$storageEventCallback$1 = new WebViewAdPlayer$storageEventCallback$1(this);
        this.storageEventCallback = webViewAdPlayer$storageEventCallback$1;
        WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1 webViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1 = new WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1(l0.N7, this);
        this.scopeCancellationHandler = webViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1;
        this.scope = p0.i(p0.i(p0.i(adPlayerScope, dispatcher), new n0("WebViewAdPlayer")), webViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1);
        final c0<Invocation> onInvocation = bridge.getOnInvocation();
        final h<Invocation> hVar = new h<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2", f = "WebViewAdPlayer.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull z8.d r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r7)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        v8.u.b(r7)
                        s9.i r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.adplayer.Invocation r2 = (com.unity3d.ads.adplayer.Invocation) r2
                        java.lang.String[] r4 = com.unity3d.ads.adplayer.WebViewAdPlayerKt.access$getSHOW_EVENTS$p()
                        java.lang.String r2 = r2.getLocation()
                        boolean r2 = kotlin.collections.l.H(r4, r2)
                        if (r2 == 0) goto L50
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L50
                        return r1
                    L50:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super Invocation> iVar, @NotNull z8.d dVar) {
                Object objCollect = onInvocation.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        };
        this.onShowEvent = j.A(new h<ShowEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2", f = "WebViewAdPlayer.kt", l = {244, Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                /* JADX WARN: Removed duplicated region for block: B:50:0x00f5 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x00f6  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r10, @org.jetbrains.annotations.NotNull z8.d r11) {
                    /*
                        Method dump skipped, instruction units count: 316
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super ShowEvent> iVar, @NotNull z8.d dVar) {
                Object objCollect = hVar.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        }, yVarA, new WebViewAdPlayer$onShowEvent$3(null));
        final c0<Invocation> onInvocation2 = bridge.getOnInvocation();
        final h<Invocation> hVar2 = new h<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2", f = "WebViewAdPlayer.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull z8.d r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r7)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        v8.u.b(r7)
                        s9.i r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.adplayer.Invocation r2 = (com.unity3d.ads.adplayer.Invocation) r2
                        java.lang.String[] r4 = com.unity3d.ads.adplayer.WebViewAdPlayerKt.access$getLOAD_EVENTS$p()
                        java.lang.String r2 = r2.getLocation()
                        boolean r2 = kotlin.collections.l.H(r4, r2)
                        if (r2 == 0) goto L50
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L50
                        return r1
                    L50:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super Invocation> iVar, @NotNull z8.d dVar) {
                Object objCollect = onInvocation2.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        };
        this.onLoadEvent = j.M(j.J(new h<LoadEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2", f = "WebViewAdPlayer.kt", l = {224, Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r8, @org.jetbrains.annotations.NotNull z8.d r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        r5 = 0
                        if (r2 == 0) goto L41
                        if (r2 == r4) goto L35
                        if (r2 != r3) goto L2d
                        v8.u.b(r9)
                        goto L96
                    L2d:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L35:
                        java.lang.Object r8 = r0.L$1
                        com.unity3d.ads.adplayer.Invocation r8 = (com.unity3d.ads.adplayer.Invocation) r8
                        java.lang.Object r2 = r0.L$0
                        s9.i r2 = (s9.i) r2
                        v8.u.b(r9)
                        goto L55
                    L41:
                        v8.u.b(r9)
                        s9.i r2 = r7.$this_unsafeFlow
                        com.unity3d.ads.adplayer.Invocation r8 = (com.unity3d.ads.adplayer.Invocation) r8
                        r0.L$0 = r2
                        r0.L$1 = r8
                        r0.label = r4
                        java.lang.Object r9 = com.unity3d.ads.adplayer.Invocation.handle$default(r8, r5, r0, r4, r5)
                        if (r9 != r1) goto L55
                        return r1
                    L55:
                        java.lang.String r9 = r8.getLocation()
                        java.lang.String r4 = "com.unity3d.services.ads.api.AdViewer.loadError"
                        boolean r9 = kotlin.jvm.internal.t.d(r9, r4)
                        if (r9 == 0) goto L87
                        java.lang.Object[] r8 = r8.getParameters()
                        java.lang.Object r8 = kotlin.collections.l.N(r8)
                        java.lang.String r9 = "null cannot be cast to non-null type org.json.JSONObject"
                        kotlin.jvm.internal.t.g(r8, r9)
                        org.json.JSONObject r8 = (org.json.JSONObject) r8
                        java.lang.String r9 = "code"
                        int r9 = r8.optInt(r9)
                        java.lang.String r4 = "message"
                        java.lang.String r8 = r8.optString(r4)
                        com.unity3d.ads.adplayer.model.LoadEvent$Error r4 = new com.unity3d.ads.adplayer.model.LoadEvent$Error
                        java.lang.String r6 = "errorMessage"
                        kotlin.jvm.internal.t.h(r8, r6)
                        r4.<init>(r8, r9)
                        goto L89
                    L87:
                        com.unity3d.ads.adplayer.model.LoadEvent$Completed r4 = com.unity3d.ads.adplayer.model.LoadEvent.Completed.INSTANCE
                    L89:
                        r0.L$0 = r5
                        r0.L$1 = r5
                        r0.label = r3
                        java.lang.Object r8 = r2.emit(r4, r0)
                        if (r8 != r1) goto L96
                        return r1
                    L96:
                        v8.k0 r8 = v8.k0.f35197a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super LoadEvent> iVar, @NotNull z8.d dVar) {
                Object objCollect = hVar2.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        }, getScope(), i0.f33702a.c(), 1), 1);
        final c0<Invocation> onInvocation3 = bridge.getOnInvocation();
        final h<Invocation> hVar3 = new h<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2", f = "WebViewAdPlayer.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull z8.d r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r7)
                        goto L4e
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        v8.u.b(r7)
                        s9.i r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.adplayer.Invocation r2 = (com.unity3d.ads.adplayer.Invocation) r2
                        java.lang.String r2 = r2.getLocation()
                        java.lang.String r4 = "com.unity3d.services.ads.api.AdViewer.updateCampaignState"
                        boolean r2 = kotlin.jvm.internal.t.d(r2, r4)
                        if (r2 == 0) goto L4e
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L4e
                        return r1
                    L4e:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super Invocation> iVar, @NotNull z8.d dVar) {
                Object objCollect = onInvocation3.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        };
        this.updateCampaignState = new h<s<? extends byte[], ? extends Integer>>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2", f = "WebViewAdPlayer.kt", l = {224, Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull z8.d r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        r5 = 0
                        if (r2 == 0) goto L41
                        if (r2 == r4) goto L35
                        if (r2 != r3) goto L2d
                        v8.u.b(r8)
                        goto L93
                    L2d:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L35:
                        java.lang.Object r7 = r0.L$1
                        com.unity3d.ads.adplayer.Invocation r7 = (com.unity3d.ads.adplayer.Invocation) r7
                        java.lang.Object r2 = r0.L$0
                        s9.i r2 = (s9.i) r2
                        v8.u.b(r8)
                        goto L55
                    L41:
                        v8.u.b(r8)
                        s9.i r2 = r6.$this_unsafeFlow
                        com.unity3d.ads.adplayer.Invocation r7 = (com.unity3d.ads.adplayer.Invocation) r7
                        r0.L$0 = r2
                        r0.L$1 = r7
                        r0.label = r4
                        java.lang.Object r8 = com.unity3d.ads.adplayer.Invocation.handle$default(r7, r5, r0, r4, r5)
                        if (r8 != r1) goto L55
                        return r1
                    L55:
                        java.lang.Object[] r7 = r7.getParameters()
                        java.lang.Object r7 = kotlin.collections.l.N(r7)
                        java.lang.String r8 = "null cannot be cast to non-null type org.json.JSONObject"
                        kotlin.jvm.internal.t.g(r7, r8)
                        org.json.JSONObject r7 = (org.json.JSONObject) r7
                        java.lang.String r8 = "data"
                        java.lang.String r4 = r7.optString(r8)
                        kotlin.jvm.internal.t.h(r4, r8)
                        java.nio.charset.Charset r8 = p9.d.f32957g
                        byte[] r8 = r4.getBytes(r8)
                        java.lang.String r4 = "this as java.lang.String).getBytes(charset)"
                        kotlin.jvm.internal.t.h(r8, r4)
                        java.lang.String r4 = "dataVersion"
                        int r7 = r7.optInt(r4)
                        java.lang.Integer r7 = kotlin.coroutines.jvm.internal.b.d(r7)
                        v8.s r7 = v8.y.a(r8, r7)
                        r0.L$0 = r5
                        r0.L$1 = r5
                        r0.label = r3
                        java.lang.Object r7 = r2.emit(r7, r0)
                        if (r7 != r1) goto L93
                        return r1
                    L93:
                        v8.k0 r7 = v8.k0.f35197a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super s<? extends byte[], ? extends Integer>> iVar, @NotNull z8.d dVar) {
                Object objCollect = hVar3.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        };
        final c0<Invocation> onInvocation4 = bridge.getOnInvocation();
        final h<Invocation> hVar4 = new h<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2", f = "WebViewAdPlayer.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull z8.d r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r7)
                        goto L4e
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        v8.u.b(r7)
                        s9.i r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.adplayer.Invocation r2 = (com.unity3d.ads.adplayer.Invocation) r2
                        java.lang.String r2 = r2.getLocation()
                        java.lang.String r4 = "com.unity3d.services.ads.api.AdViewer.broadcastEvent"
                        boolean r2 = kotlin.jvm.internal.t.d(r2, r4)
                        if (r2 == 0) goto L4e
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L4e
                        return r1
                    L4e:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super Invocation> iVar, @NotNull z8.d dVar) {
                Object objCollect = onInvocation4.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        };
        h<String> hVar5 = new h<String>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2", f = "WebViewAdPlayer.kt", l = {224, Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull z8.d r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        r5 = 0
                        if (r2 == 0) goto L41
                        if (r2 == r4) goto L35
                        if (r2 != r3) goto L2d
                        v8.u.b(r8)
                        goto L6e
                    L2d:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L35:
                        java.lang.Object r7 = r0.L$1
                        com.unity3d.ads.adplayer.Invocation r7 = (com.unity3d.ads.adplayer.Invocation) r7
                        java.lang.Object r2 = r0.L$0
                        s9.i r2 = (s9.i) r2
                        v8.u.b(r8)
                        goto L55
                    L41:
                        v8.u.b(r8)
                        s9.i r2 = r6.$this_unsafeFlow
                        com.unity3d.ads.adplayer.Invocation r7 = (com.unity3d.ads.adplayer.Invocation) r7
                        r0.L$0 = r2
                        r0.L$1 = r7
                        r0.label = r4
                        java.lang.Object r8 = com.unity3d.ads.adplayer.Invocation.handle$default(r7, r5, r0, r4, r5)
                        if (r8 != r1) goto L55
                        return r1
                    L55:
                        java.lang.Object[] r7 = r7.getParameters()
                        java.lang.Object r7 = kotlin.collections.l.N(r7)
                        java.lang.String r7 = r7.toString()
                        r0.L$0 = r5
                        r0.L$1 = r5
                        r0.label = r3
                        java.lang.Object r7 = r2.emit(r7, r0)
                        if (r7 != r1) goto L6e
                        return r1
                    L6e:
                        v8.k0 r7 = v8.k0.f35197a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super String> iVar, @NotNull z8.d dVar) {
                Object objCollect = hVar4.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        };
        this.onBroadcastEvents = hVar5;
        final c0<Invocation> onInvocation5 = bridge.getOnInvocation();
        final h<Invocation> hVar6 = new h<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2", f = "WebViewAdPlayer.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull z8.d r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r7)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        v8.u.b(r7)
                        s9.i r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.adplayer.Invocation r2 = (com.unity3d.ads.adplayer.Invocation) r2
                        java.lang.String[] r4 = com.unity3d.ads.adplayer.WebViewAdPlayerKt.access$getREQUEST_EVENTS$p()
                        java.lang.String r2 = r2.getLocation()
                        boolean r2 = kotlin.collections.l.H(r4, r2)
                        if (r2 == 0) goto L50
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L50
                        return r1
                    L50:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super Invocation> iVar, @NotNull z8.d dVar) {
                Object objCollect = onInvocation5.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        };
        h<v8.k0> hVar7 = new h<v8.k0>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ WebViewAdPlayer this$0;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2", f = "WebViewAdPlayer.kt", l = {224, 237, 250, 253, Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, WebViewAdPlayer webViewAdPlayer) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = webViewAdPlayer;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:49:0x0111 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
                /* JADX WARN: Removed duplicated region for block: B:53:0x011f A[Catch: Exception -> 0x0078, TryCatch #0 {Exception -> 0x0078, blocks: (B:20:0x005e, B:23:0x0073, B:51:0x0115, B:53:0x011f, B:58:0x0132, B:54:0x0122, B:56:0x0126), top: B:79:0x002b }] */
                /* JADX WARN: Removed duplicated region for block: B:54:0x0122 A[Catch: Exception -> 0x0078, TryCatch #0 {Exception -> 0x0078, blocks: (B:20:0x005e, B:23:0x0073, B:51:0x0115, B:53:0x011f, B:58:0x0132, B:54:0x0122, B:56:0x0126), top: B:79:0x002b }] */
                /* JADX WARN: Removed duplicated region for block: B:60:0x0172 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:74:0x01bf A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
                /* JADX WARN: Type inference failed for: r4v0, types: [int] */
                /* JADX WARN: Type inference failed for: r4v1 */
                /* JADX WARN: Type inference failed for: r4v9 */
                /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object[], java.lang.String[]] */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r17, @org.jetbrains.annotations.NotNull z8.d r18) {
                    /*
                        Method dump skipped, instruction units count: 478
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super v8.k0> iVar, @NotNull z8.d dVar) {
                Object objCollect = hVar6.collect(new AnonymousClass2(iVar, this), dVar);
                return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
            }
        };
        this.onRequestEvents = hVar7;
        Storage.Companion.addStorageEventCallback(webViewAdPlayer$storageEventCallback$1);
        AdPlayer.Companion companion = AdPlayer.Companion;
        j.D(j.G(hVar5, new AnonymousClass1(companion.getBroadcastEventChannel())), getScope());
        j.D(hVar7, getScope());
        j.D(j.G(companion.getBroadcastEventChannel(), new AnonymousClass2(this)), getScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendEvent(h9.a<? extends com.unity3d.ads.adplayer.model.WebViewEvent> r18, z8.d<? super v8.k0> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer.C31571
            if (r2 == 0) goto L17
            r2 = r1
            com.unity3d.ads.adplayer.WebViewAdPlayer$sendEvent$1 r2 = (com.unity3d.ads.adplayer.WebViewAdPlayer.C31571) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.unity3d.ads.adplayer.WebViewAdPlayer$sendEvent$1 r2 = new com.unity3d.ads.adplayer.WebViewAdPlayer$sendEvent$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = a9.b.e()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L45
            if (r4 == r6) goto L39
            if (r4 != r5) goto L31
            v8.u.b(r1)
            goto Lb9
        L31:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L39:
            java.lang.Object r4 = r2.L$1
            h9.a r4 = (h9.a) r4
            java.lang.Object r7 = r2.L$0
            com.unity3d.ads.adplayer.WebViewAdPlayer r7 = (com.unity3d.ads.adplayer.WebViewAdPlayer) r7
            v8.u.b(r1)
            goto L5c
        L45:
            v8.u.b(r1)
            s9.h r1 = r17.getOnLoadEvent()
            r2.L$0 = r0
            r4 = r18
            r2.L$1 = r4
            r2.label = r6
            java.lang.Object r1 = s9.j.K(r1, r2)
            if (r1 != r3) goto L5b
            return r3
        L5b:
            r7 = r0
        L5c:
            com.unity3d.ads.adplayer.model.LoadEvent r1 = (com.unity3d.ads.adplayer.model.LoadEvent) r1
            boolean r8 = r1 instanceof com.unity3d.ads.adplayer.model.LoadEvent.Error
            if (r8 == 0) goto La3
            com.unity3d.ads.core.domain.SendDiagnosticEvent r9 = r7.sendDiagnosticEvent
            java.lang.String r10 = "bridge_send_event_failed"
            r11 = 0
            r2 = 3
            v8.s[] r2 = new v8.s[r2]
            java.lang.String r3 = "reason"
            java.lang.String r4 = "adviewer"
            v8.s r3 = v8.y.a(r3, r4)
            r4 = 0
            r2[r4] = r3
            com.unity3d.ads.adplayer.model.LoadEvent$Error r1 = (com.unity3d.ads.adplayer.model.LoadEvent.Error) r1
            java.lang.String r3 = r1.getMessage()
            java.lang.String r4 = "reason_debug"
            v8.s r3 = v8.y.a(r4, r3)
            r2[r6] = r3
            int r1 = r1.getErrorCode()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "reason_code"
            v8.s r1 = v8.y.a(r3, r1)
            r2[r5] = r1
            java.util.Map r12 = kotlin.collections.o0.j(r2)
            r13 = 0
            r14 = 0
            r15 = 26
            r16 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r9, r10, r11, r12, r13, r14, r15, r16)
            v8.k0 r1 = v8.k0.f35197a
            return r1
        La3:
            java.lang.Object r1 = r4.invoke()
            com.unity3d.ads.adplayer.model.WebViewEvent r1 = (com.unity3d.ads.adplayer.model.WebViewEvent) r1
            com.unity3d.ads.adplayer.WebViewBridge r4 = r7.bridge
            r6 = 0
            r2.L$0 = r6
            r2.L$1 = r6
            r2.label = r5
            java.lang.Object r1 = r4.sendEvent(r1, r2)
            if (r1 != r3) goto Lb9
            return r3
        Lb9:
            v8.k0 r1 = v8.k0.f35197a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer.sendEvent(h9.a, z8.d):java.lang.Object");
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @CallSuper
    @Nullable
    public Object destroy(@NotNull z8.d<? super v8.k0> dVar) {
        return AdPlayer.DefaultImpls.destroy(this, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void dispatchShowCompleted() {
        this.isCompletedManually.setValue(Boolean.TRUE);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public h<LoadEvent> getOnLoadEvent() {
        return this.onLoadEvent;
    }

    @NotNull
    public final h<v8.k0> getOnRequestEvents() {
        return this.onRequestEvents;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public h<ShowEvent> getOnShowEvent() {
        return this.onShowEvent;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public o0 getScope() {
        return this.scope;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public h<s<byte[], Integer>> getUpdateCampaignState() {
        return this.updateCampaignState;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public WebViewContainer getWebViewContainer() {
        return this.webViewContainer;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object onAllowedPiiChange(@NotNull byte[] bArr, @NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(new C31532(bArr), dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object onBroadcastEvent(@NotNull String str, @NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(new C31542(str), dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.adplayer.AdPlayer
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object requestShow(@org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, ? extends java.lang.Object> r13, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r14) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer.requestShow(java.util.Map, z8.d):java.lang.Object");
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendActivityDestroyed(@NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(C31562.INSTANCE, dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendFocusChange(boolean z10, @NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(new C31582(z10), dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendMuteChange(boolean z10, @NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(new C31592(z10), dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendPrivacyFsmChange(@NotNull byte[] bArr, @NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(new C31602(bArr), dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendUserConsentChange(@NotNull byte[] bArr, @NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(new C31612(bArr), dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendVisibilityChange(boolean z10, @NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(new C31622(z10), dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendVolumeChange(double d10, @NotNull z8.d<? super v8.k0> dVar) {
        Object objSendEvent = sendEvent(new C31632(d10), dVar);
        return objSendEvent == a9.d.e() ? objSendEvent : v8.k0.f35197a;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void show(@NotNull ShowOptions showOptions) {
        AdPlayer.DefaultImpls.show(this, showOptions);
    }
}
