package com.unity3d.ads.adplayer;

import android.content.Context;
import android.content.Intent;
import com.unity3d.ads.adplayer.DisplayMessage;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.core.data.datasource.VolumeSettingsChange;
import com.unity3d.ads.core.data.model.SessionChange;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import h9.p;
import java.util.Map;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import s9.e0;
import s9.h;
import s9.i;
import s9.j;
import s9.x;
import v8.k0;
import v8.s;
import v8.u;

/* JADX INFO: compiled from: AndroidFullscreenWebViewAdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidFullscreenWebViewAdPlayer implements AdPlayer, FullscreenAdPlayer {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final x<DisplayMessage> displayMessages = e0.b(0, 0, null, 7, null);

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final OpenMeasurementRepository openMeasurementRepository;

    @NotNull
    private final String opportunityId;

    @NotNull
    private final SessionRepository sessionRepository;

    @NotNull
    private final WebViewAdPlayer webViewAdPlayer;

    @NotNull
    private final AndroidWebViewContainer webViewContainer;

    /* JADX INFO: compiled from: AndroidFullscreenWebViewAdPlayer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final x<DisplayMessage> getDisplayMessages() {
            return AndroidFullscreenWebViewAdPlayer.displayMessages;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidFullscreenWebViewAdPlayer.kt */
    @f(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {98, 103, 107, 109}, m = "destroy")
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
            return AndroidFullscreenWebViewAdPlayer.this.destroy(this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidFullscreenWebViewAdPlayer.kt */
    @f(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {114, 115, 116, 117, 118, 120}, m = "invokeSuspend")
    static final class C31381 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ DisplayMessage $displayMessage;
        int label;
        final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31381(DisplayMessage displayMessage, AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, z8.d<? super C31381> dVar) {
            super(2, dVar);
            this.$displayMessage = displayMessage;
            this.this$0 = androidFullscreenWebViewAdPlayer;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C31381(this.$displayMessage, this.this$0, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            switch (this.label) {
                case 0:
                    u.b(obj);
                    DisplayMessage displayMessage = this.$displayMessage;
                    if (displayMessage instanceof DisplayMessage.DisplayReady) {
                        WebViewAdPlayer webViewAdPlayer = this.this$0.webViewAdPlayer;
                        Map<String, Object> showOptions = ((DisplayMessage.DisplayReady) this.$displayMessage).getShowOptions();
                        this.label = 1;
                        if (webViewAdPlayer.requestShow(showOptions, this) == objE) {
                            return objE;
                        }
                    } else if (displayMessage instanceof DisplayMessage.WebViewInstanceRequest) {
                        x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                        DisplayMessage.WebViewInstanceResponse webViewInstanceResponse = new DisplayMessage.WebViewInstanceResponse(this.$displayMessage.getOpportunityId(), this.this$0.getWebViewContainer().getWebView());
                        this.label = 2;
                        if (displayMessages.emit(webViewInstanceResponse, this) == objE) {
                            return objE;
                        }
                    } else if (displayMessage instanceof DisplayMessage.VisibilityChanged) {
                        WebViewAdPlayer webViewAdPlayer2 = this.this$0.webViewAdPlayer;
                        boolean zIsVisible = ((DisplayMessage.VisibilityChanged) this.$displayMessage).isVisible();
                        this.label = 3;
                        if (webViewAdPlayer2.sendVisibilityChange(zIsVisible, this) == objE) {
                            return objE;
                        }
                    } else if (displayMessage instanceof DisplayMessage.FocusChanged) {
                        WebViewAdPlayer webViewAdPlayer3 = this.this$0.webViewAdPlayer;
                        boolean zIsFocused = ((DisplayMessage.FocusChanged) this.$displayMessage).isFocused();
                        this.label = 4;
                        if (webViewAdPlayer3.sendFocusChange(zIsFocused, this) == objE) {
                            return objE;
                        }
                    } else if (displayMessage instanceof DisplayMessage.DisplayDestroyed) {
                        WebViewAdPlayer webViewAdPlayer4 = this.this$0.webViewAdPlayer;
                        this.label = 5;
                        if (webViewAdPlayer4.sendActivityDestroyed(this) == objE) {
                            return objE;
                        }
                    } else if (displayMessage instanceof DisplayMessage.DisplayError) {
                        AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer = this.this$0;
                        this.label = 6;
                        if (androidFullscreenWebViewAdPlayer.destroy(this) == objE) {
                            return objE;
                        }
                    }
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    u.b(obj);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C31381) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidFullscreenWebViewAdPlayer.kt */
    /* synthetic */ class AnonymousClass2 extends kotlin.jvm.internal.a implements p<DisplayMessage, z8.d<? super k0>, Object> {
        AnonymousClass2(Object obj) {
            super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "displayEventsRouter", "displayEventsRouter(Lcom/unity3d/ads/adplayer/DisplayMessage;)Lkotlinx/coroutines/Job;", 12);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull DisplayMessage displayMessage, @NotNull z8.d<? super k0> dVar) {
            return AndroidFullscreenWebViewAdPlayer.show$displayEventsRouter((AndroidFullscreenWebViewAdPlayer) this.receiver, displayMessage, dVar);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$3, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidFullscreenWebViewAdPlayer.kt */
    /* synthetic */ class AnonymousClass3 extends q implements p<VolumeSettingsChange, z8.d<? super k0>, Object> {
        AnonymousClass3(Object obj) {
            super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "handleVolumeSettingsChange", "handleVolumeSettingsChange(Lcom/unity3d/ads/core/data/datasource/VolumeSettingsChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull VolumeSettingsChange volumeSettingsChange, @NotNull z8.d<? super k0> dVar) {
            return ((AndroidFullscreenWebViewAdPlayer) this.receiver).handleVolumeSettingsChange(volumeSettingsChange, dVar);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$5, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidFullscreenWebViewAdPlayer.kt */
    @f(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$5", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {72}, m = "invokeSuspend")
    static final class AnonymousClass5 extends l implements p<ShowEvent, z8.d<? super k0>, Object> {
        int label;

        AnonymousClass5(z8.d<? super AnonymousClass5> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return AndroidFullscreenWebViewAdPlayer.this.new AnonymousClass5(dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ShowEvent showEvent, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass5) create(showEvent, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer = AndroidFullscreenWebViewAdPlayer.this;
                this.label = 1;
                if (androidFullscreenWebViewAdPlayer.destroy(this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$6, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidFullscreenWebViewAdPlayer.kt */
    /* synthetic */ class AnonymousClass6 extends q implements p<SessionChange, z8.d<? super k0>, Object> {
        AnonymousClass6(Object obj) {
            super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "handleSessionChange", "handleSessionChange(Lcom/unity3d/ads/core/data/model/SessionChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull SessionChange sessionChange, @NotNull z8.d<? super k0> dVar) {
            return ((AndroidFullscreenWebViewAdPlayer) this.receiver).handleSessionChange(sessionChange, dVar);
        }
    }

    public AndroidFullscreenWebViewAdPlayer(@NotNull WebViewAdPlayer webViewAdPlayer, @NotNull String opportunityId, @NotNull AndroidWebViewContainer webViewContainer, @NotNull DeviceInfoRepository deviceInfoRepository, @NotNull SessionRepository sessionRepository, @NotNull OpenMeasurementRepository openMeasurementRepository) {
        t.i(webViewAdPlayer, "webViewAdPlayer");
        t.i(opportunityId, "opportunityId");
        t.i(webViewContainer, "webViewContainer");
        t.i(deviceInfoRepository, "deviceInfoRepository");
        t.i(sessionRepository, "sessionRepository");
        t.i(openMeasurementRepository, "openMeasurementRepository");
        this.webViewAdPlayer = webViewAdPlayer;
        this.opportunityId = opportunityId;
        this.webViewContainer = webViewContainer;
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.openMeasurementRepository = openMeasurementRepository;
    }

    private final b2 displayEventsRouter(DisplayMessage displayMessage) {
        return kotlinx.coroutines.k.d(getScope(), null, null, new C31381(displayMessage, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleSessionChange(SessionChange sessionChange, z8.d<? super k0> dVar) {
        if (sessionChange instanceof SessionChange.UserConsentChange) {
            WebViewAdPlayer webViewAdPlayer = this.webViewAdPlayer;
            byte[] byteArray = ((SessionChange.UserConsentChange) sessionChange).getValue().toByteArray();
            t.h(byteArray, "change.value.toByteArray()");
            Object objSendUserConsentChange = webViewAdPlayer.sendUserConsentChange(byteArray, dVar);
            return objSendUserConsentChange == a9.d.e() ? objSendUserConsentChange : k0.f35197a;
        }
        if (!(sessionChange instanceof SessionChange.PrivacyFsmChange)) {
            return k0.f35197a;
        }
        WebViewAdPlayer webViewAdPlayer2 = this.webViewAdPlayer;
        byte[] byteArray2 = ((SessionChange.PrivacyFsmChange) sessionChange).getValue().toByteArray();
        t.h(byteArray2, "change.value.toByteArray()");
        Object objSendPrivacyFsmChange = webViewAdPlayer2.sendPrivacyFsmChange(byteArray2, dVar);
        return objSendPrivacyFsmChange == a9.d.e() ? objSendPrivacyFsmChange : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleVolumeSettingsChange(VolumeSettingsChange volumeSettingsChange, z8.d<? super k0> dVar) {
        if (volumeSettingsChange instanceof VolumeSettingsChange.MuteChange) {
            Object objSendMuteChange = this.webViewAdPlayer.sendMuteChange(((VolumeSettingsChange.MuteChange) volumeSettingsChange).isMuted(), dVar);
            return objSendMuteChange == a9.d.e() ? objSendMuteChange : k0.f35197a;
        }
        if (!(volumeSettingsChange instanceof VolumeSettingsChange.VolumeChange)) {
            return k0.f35197a;
        }
        Object objSendVolumeChange = this.webViewAdPlayer.sendVolumeChange(((VolumeSettingsChange.VolumeChange) volumeSettingsChange).getVolume(), dVar);
        return objSendVolumeChange == a9.d.e() ? objSendVolumeChange : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object show$displayEventsRouter(AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, DisplayMessage displayMessage, z8.d dVar) {
        androidFullscreenWebViewAdPlayer.displayEventsRouter(displayMessage);
        return k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.adplayer.AdPlayer
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object destroy(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1 r0 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1 r0 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L52
            if (r2 == r6) goto L4a
            if (r2 == r5) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            v8.u.b(r9)
            goto La0
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r2
            v8.u.b(r9)
            goto L94
        L42:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r2
            v8.u.b(r9)
            goto L85
        L4a:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r2
            v8.u.b(r9)
            goto L6a
        L52:
            v8.u.b(r9)
            s9.x<com.unity3d.ads.adplayer.DisplayMessage> r9 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.displayMessages
            com.unity3d.ads.adplayer.DisplayMessage$DisplayFinishRequest r2 = new com.unity3d.ads.adplayer.DisplayMessage$DisplayFinishRequest
            java.lang.String r7 = r8.opportunityId
            r2.<init>(r7)
            r0.L$0 = r8
            r0.label = r6
            java.lang.Object r9 = r9.emit(r2, r0)
            if (r9 != r1) goto L69
            return r1
        L69:
            r2 = r8
        L6a:
            com.unity3d.ads.core.data.repository.OpenMeasurementRepository r9 = r2.openMeasurementRepository
            java.lang.String r6 = r2.opportunityId
            com.google.protobuf.ByteString r6 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toISO8859ByteString(r6)
            boolean r9 = r9.hasSessionFinished(r6)
            if (r9 == 0) goto L85
            r0.L$0 = r2
            r0.label = r5
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r9 = kotlinx.coroutines.y0.a(r5, r0)
            if (r9 != r1) goto L85
            return r1
        L85:
            com.unity3d.ads.adplayer.AndroidWebViewContainer r9 = r2.getWebViewContainer()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r9 = r9.destroy(r0)
            if (r9 != r1) goto L94
            return r1
        L94:
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r9 = com.unity3d.ads.adplayer.AdPlayer.DefaultImpls.destroy(r2, r0)
            if (r9 != r1) goto La0
            return r1
        La0:
            v8.k0 r9 = v8.k0.f35197a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.destroy(z8.d):java.lang.Object");
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void dispatchShowCompleted() {
        this.webViewAdPlayer.dispatchShowCompleted();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public h<LoadEvent> getOnLoadEvent() {
        return this.webViewAdPlayer.getOnLoadEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public h<ShowEvent> getOnShowEvent() {
        return this.webViewAdPlayer.getOnShowEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public o0 getScope() {
        return this.webViewAdPlayer.getScope();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public h<s<byte[], Integer>> getUpdateCampaignState() {
        return this.webViewAdPlayer.getUpdateCampaignState();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object onAllowedPiiChange(@NotNull byte[] bArr, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.onAllowedPiiChange(bArr, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object onBroadcastEvent(@NotNull String str, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.onBroadcastEvent(str, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object requestShow(@Nullable Map<String, ? extends Object> map, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.requestShow(map, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendActivityDestroyed(@NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.sendActivityDestroyed(dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendFocusChange(boolean z10, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.sendFocusChange(z10, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendMuteChange(boolean z10, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.sendMuteChange(z10, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendPrivacyFsmChange(@NotNull byte[] bArr, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.sendPrivacyFsmChange(bArr, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendUserConsentChange(@NotNull byte[] bArr, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.sendUserConsentChange(bArr, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendVisibilityChange(boolean z10, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.sendVisibilityChange(z10, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @Nullable
    public Object sendVolumeChange(double d10, @NotNull z8.d<? super k0> dVar) {
        return this.webViewAdPlayer.sendVolumeChange(d10, dVar);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void show(@NotNull ShowOptions showOptions) {
        t.i(showOptions, "showOptions");
        if (!(showOptions instanceof AndroidShowOptions)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        AndroidShowOptions androidShowOptions = (AndroidShowOptions) showOptions;
        Context context = androidShowOptions.getContext();
        Intent intent = new Intent(context, (Class<?>) FullScreenWebViewDisplay.class);
        intent.putExtra("opportunityId", this.opportunityId);
        Map<String, Object> unityAdsShowOptions = androidShowOptions.getUnityAdsShowOptions();
        if (unityAdsShowOptions != null) {
            intent.putExtra("showOptions", new JSONObject(unityAdsShowOptions).toString());
        }
        intent.addFlags(268500992);
        intent.putExtra("orientation", context.getResources().getConfiguration().orientation);
        final x<DisplayMessage> xVar = displayMessages;
        j.D(j.G(new h<DisplayMessage>() { // from class: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
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

                public AnonymousClass2(i iVar, AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = androidFullscreenWebViewAdPlayer;
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
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1 r0 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1 r0 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r7)
                        goto L52
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        v8.u.b(r7)
                        s9.i r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.adplayer.DisplayMessage r2 = (com.unity3d.ads.adplayer.DisplayMessage) r2
                        java.lang.String r2 = r2.getOpportunityId()
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r4 = r5.this$0
                        java.lang.String r4 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.access$getOpportunityId$p(r4)
                        boolean r2 = kotlin.jvm.internal.t.d(r2, r4)
                        if (r2 == 0) goto L52
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L52
                        return r1
                    L52:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super DisplayMessage> iVar, @NotNull z8.d dVar) {
                Object objCollect = xVar.collect(new AnonymousClass2(iVar, this), dVar);
                return objCollect == a9.d.e() ? objCollect : k0.f35197a;
            }
        }, new AnonymousClass2(this)), getScope());
        j.D(j.G(this.deviceInfoRepository.getVolumeSettingsChange(), new AnonymousClass3(this)), getScope());
        final h<ShowEvent> onShowEvent = this.webViewAdPlayer.getOnShowEvent();
        j.D(j.G(new h<ShowEvent>() { // from class: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2", f = "AndroidFullscreenWebViewAdPlayer.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
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
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1 r0 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1 r0 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1
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
                        com.unity3d.ads.core.data.model.ShowEvent r2 = (com.unity3d.ads.core.data.model.ShowEvent) r2
                        boolean r4 = r2 instanceof com.unity3d.ads.core.data.model.ShowEvent.Completed
                        if (r4 != 0) goto L44
                        boolean r2 = r2 instanceof com.unity3d.ads.core.data.model.ShowEvent.Error
                        if (r2 == 0) goto L42
                        goto L44
                    L42:
                        r2 = 0
                        goto L45
                    L44:
                        r2 = r3
                    L45:
                        if (r2 == 0) goto L50
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L50
                        return r1
                    L50:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super ShowEvent> iVar, @NotNull z8.d dVar) {
                Object objCollect = onShowEvent.collect(new AnonymousClass2(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : k0.f35197a;
            }
        }, new AnonymousClass5(null)), getScope());
        j.D(j.G(this.sessionRepository.getOnChange(), new AnonymousClass6(this)), getScope());
        context.startActivity(intent);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    @NotNull
    public AndroidWebViewContainer getWebViewContainer() {
        return this.webViewContainer;
    }
}
