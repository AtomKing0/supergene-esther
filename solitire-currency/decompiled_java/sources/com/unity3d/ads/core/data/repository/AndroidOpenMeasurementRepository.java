package com.unity3d.ads.core.data.repository;

import android.content.Context;
import android.webkit.WebView;
import com.google.protobuf.ByteString;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSession;
import com.iab.omid.library.unity3d.adsession.AdSessionConfiguration;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.CreativeType;
import com.iab.omid.library.unity3d.adsession.ImpressionType;
import com.iab.omid.library.unity3d.adsession.Owner;
import com.iab.omid.library.unity3d.adsession.Partner;
import com.unity3d.ads.core.data.manager.OmidManager;
import com.unity3d.ads.core.data.model.OMData;
import com.unity3d.ads.core.data.model.OMResult;
import com.unity3d.ads.core.data.model.OmidOptions;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import h9.p;
import java.util.Map;
import java.util.Set;
import kotlin.collections.a1;
import kotlin.collections.r0;
import kotlin.collections.z0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.y;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: AndroidOpenMeasurementRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidOpenMeasurementRepository implements OpenMeasurementRepository {

    @NotNull
    private final y<Boolean> _isOMActive;

    @NotNull
    private final y<Map<String, AdSession>> activeSessions;

    @NotNull
    private final y<Set<String>> finishedSessions;

    @NotNull
    private final k0 mainDispatcher;

    @NotNull
    private final OmidManager omidManager;
    private final Partner partner;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$activateOM$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidOpenMeasurementRepository.kt */
    @f(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$activateOM$2", f = "AndroidOpenMeasurementRepository.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super OMResult>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AndroidOpenMeasurementRepository.this.new AnonymousClass2(this.$context, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (AndroidOpenMeasurementRepository.this.isOMActive()) {
                return new OMResult.Failure("om_already_active", null, 2, null);
            }
            try {
                AndroidOpenMeasurementRepository.this.omidManager.activate(this.$context);
                AndroidOpenMeasurementRepository androidOpenMeasurementRepository = AndroidOpenMeasurementRepository.this;
                androidOpenMeasurementRepository.setOMActive(androidOpenMeasurementRepository.omidManager.isActive());
                return AndroidOpenMeasurementRepository.this.isOMActive() ? OMResult.Success.INSTANCE : new OMResult.Failure("om_activate_failure_time", null, 2, null);
            } catch (Throwable th) {
                return new OMResult.Failure("uncaught_exception", String.valueOf(th.getMessage()));
            }
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super OMResult> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$finishSession$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidOpenMeasurementRepository.kt */
    @f(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$finishSession$2", f = "AndroidOpenMeasurementRepository.kt", l = {}, m = "invokeSuspend")
    static final class C31722 extends l implements p<o0, d<? super OMResult>, Object> {
        final /* synthetic */ ByteString $opportunityId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31722(ByteString byteString, d<? super C31722> dVar) {
            super(2, dVar);
            this.$opportunityId = byteString;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AndroidOpenMeasurementRepository.this.new C31722(this.$opportunityId, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (!AndroidOpenMeasurementRepository.this.isOMActive()) {
                return new OMResult.Failure("om_not_active", null, 2, null);
            }
            AdSession session = AndroidOpenMeasurementRepository.this.getSession(this.$opportunityId);
            if (session == null) {
                return new OMResult.Failure("om_session_not_found", null, 2, null);
            }
            session.finish();
            AndroidOpenMeasurementRepository.this.sessionFinished(this.$opportunityId);
            return OMResult.Success.INSTANCE;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super OMResult> dVar) {
            return ((C31722) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$impressionOccurred$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidOpenMeasurementRepository.kt */
    @f(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$impressionOccurred$2", f = "AndroidOpenMeasurementRepository.kt", l = {}, m = "invokeSuspend")
    static final class C31732 extends l implements p<o0, d<? super OMResult>, Object> {
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ boolean $signalLoaded;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31732(ByteString byteString, boolean z10, d<? super C31732> dVar) {
            super(2, dVar);
            this.$opportunityId = byteString;
            this.$signalLoaded = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AndroidOpenMeasurementRepository.this.new C31732(this.$opportunityId, this.$signalLoaded, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            AdSession session = AndroidOpenMeasurementRepository.this.getSession(this.$opportunityId);
            if (session == null) {
                return new OMResult.Failure("om_session_not_found", null, 2, null);
            }
            AdEvents adEventsCreateAdEvents = AndroidOpenMeasurementRepository.this.omidManager.createAdEvents(session);
            if (this.$signalLoaded) {
                adEventsCreateAdEvents.loaded();
            }
            adEventsCreateAdEvents.impressionOccurred();
            return OMResult.Success.INSTANCE;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super OMResult> dVar) {
            return ((C31732) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$startSession$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidOpenMeasurementRepository.kt */
    @f(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$startSession$2", f = "AndroidOpenMeasurementRepository.kt", l = {}, m = "invokeSuspend")
    static final class C31742 extends l implements p<o0, d<? super OMResult>, Object> {
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ OmidOptions $options;
        final /* synthetic */ WebView $webView;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$startSession$2$WhenMappings */
        /* JADX INFO: compiled from: AndroidOpenMeasurementRepository.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CreativeType.values().length];
                try {
                    iArr[CreativeType.HTML_DISPLAY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CreativeType.VIDEO.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31742(ByteString byteString, OmidOptions omidOptions, WebView webView, d<? super C31742> dVar) {
            super(2, dVar);
            this.$opportunityId = byteString;
            this.$options = omidOptions;
            this.$webView = webView;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AndroidOpenMeasurementRepository.this.new C31742(this.$opportunityId, this.$options, this.$webView, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            AdSessionContext adSessionContextCreateHtmlAdSessionContext;
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            try {
                if (!AndroidOpenMeasurementRepository.this.isOMActive()) {
                    return new OMResult.Failure("om_not_active", null, 2, null);
                }
                if (((Map) AndroidOpenMeasurementRepository.this.activeSessions.getValue()).containsKey(ProtobufExtensionsKt.toISO8859String(this.$opportunityId))) {
                    return new OMResult.Failure("om_session_already_exists", null, 2, null);
                }
                CreativeType creativeType = this.$options.getCreativeType();
                if (creativeType == null) {
                    return new OMResult.Failure("om_creative_type_null", null, 2, null);
                }
                OmidManager omidManager = AndroidOpenMeasurementRepository.this.omidManager;
                ImpressionType impressionType = this.$options.getImpressionType();
                if (impressionType == null) {
                    impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
                }
                ImpressionType impressionType2 = impressionType;
                Owner impressionOwner = this.$options.getImpressionOwner();
                if (impressionOwner == null) {
                    impressionOwner = Owner.JAVASCRIPT;
                }
                Owner owner = impressionOwner;
                Owner videoEventsOwner = this.$options.getVideoEventsOwner();
                if (videoEventsOwner == null) {
                    videoEventsOwner = Owner.JAVASCRIPT;
                }
                AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = omidManager.createAdSessionConfiguration(creativeType, impressionType2, owner, videoEventsOwner, this.$options.getIsolateVerificationScripts());
                int i10 = WhenMappings.$EnumSwitchMapping$0[creativeType.ordinal()];
                if (i10 == 1) {
                    adSessionContextCreateHtmlAdSessionContext = AndroidOpenMeasurementRepository.this.omidManager.createHtmlAdSessionContext(AndroidOpenMeasurementRepository.this.partner, this.$webView, null, this.$options.getCustomReferenceData());
                } else {
                    if (i10 != 2) {
                        return new OMResult.Failure("om_creative_type_invalid", null, 2, null);
                    }
                    adSessionContextCreateHtmlAdSessionContext = AndroidOpenMeasurementRepository.this.omidManager.createJavaScriptAdSessionContext(AndroidOpenMeasurementRepository.this.partner, this.$webView, null, this.$options.getCustomReferenceData());
                }
                AdSession adSessionCreateAdSession = AndroidOpenMeasurementRepository.this.omidManager.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, adSessionContextCreateHtmlAdSessionContext);
                adSessionCreateAdSession.registerAdView(this.$webView);
                adSessionCreateAdSession.start();
                AndroidOpenMeasurementRepository.this.addSession(this.$opportunityId, adSessionCreateAdSession);
                return OMResult.Success.INSTANCE;
            } catch (Throwable th) {
                return new OMResult.Failure("uncaught_exception", String.valueOf(th.getMessage()));
            }
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super OMResult> dVar) {
            return ((C31742) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public AndroidOpenMeasurementRepository(@NotNull k0 mainDispatcher, @NotNull OmidManager omidManager) {
        t.i(mainDispatcher, "mainDispatcher");
        t.i(omidManager, "omidManager");
        this.mainDispatcher = mainDispatcher;
        this.omidManager = omidManager;
        this.partner = Partner.createPartner(UnityAdsConstants.OpenMeasurement.OM_PARTNER_NAME, "4.12.3");
        this.activeSessions = s9.o0.a(r0.g());
        this.finishedSessions = s9.o0.a(z0.e());
        this._isOMActive = s9.o0.a(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addSession(ByteString byteString, AdSession adSession) {
        Map<String, AdSession> value;
        y<Map<String, AdSession>> yVar = this.activeSessions;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, r0.o(value, v8.y.a(ProtobufExtensionsKt.toISO8859String(byteString), adSession))));
    }

    private final OMData buildOmData() {
        return new OMData(this.omidManager.getVersion(), UnityAdsConstants.OpenMeasurement.OM_PARTNER_NAME, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdSession getSession(ByteString byteString) {
        return this.activeSessions.getValue().get(ProtobufExtensionsKt.toISO8859String(byteString));
    }

    private final void removeSession(ByteString byteString) {
        Map<String, AdSession> value;
        y<Map<String, AdSession>> yVar = this.activeSessions;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, r0.k(value, ProtobufExtensionsKt.toISO8859String(byteString))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sessionFinished(ByteString byteString) {
        Set<String> value;
        y<Set<String>> yVar = this.finishedSessions;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, a1.k(value, ProtobufExtensionsKt.toISO8859String(byteString))));
        removeSession(byteString);
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    @Nullable
    public Object activateOM(@NotNull Context context, @NotNull d<? super OMResult> dVar) {
        return i.g(this.mainDispatcher, new AnonymousClass2(context, null), dVar);
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    @Nullable
    public Object finishSession(@NotNull ByteString byteString, @NotNull d<? super OMResult> dVar) {
        return i.g(this.mainDispatcher, new C31722(byteString, null), dVar);
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    @NotNull
    public OMData getOmData() {
        return buildOmData();
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public boolean hasSessionFinished(@NotNull ByteString opportunityId) {
        t.i(opportunityId, "opportunityId");
        return this.finishedSessions.getValue().contains(ProtobufExtensionsKt.toISO8859String(opportunityId));
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    @Nullable
    public Object impressionOccurred(@NotNull ByteString byteString, boolean z10, @NotNull d<? super OMResult> dVar) {
        return i.g(this.mainDispatcher, new C31732(byteString, z10, null), dVar);
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public boolean isOMActive() {
        return this._isOMActive.getValue().booleanValue();
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    public void setOMActive(boolean z10) {
        Boolean value;
        y<Boolean> yVar = this._isOMActive;
        do {
            value = yVar.getValue();
            value.booleanValue();
        } while (!yVar.d(value, Boolean.valueOf(z10)));
    }

    @Override // com.unity3d.ads.core.data.repository.OpenMeasurementRepository
    @Nullable
    public Object startSession(@NotNull ByteString byteString, @Nullable WebView webView, @NotNull OmidOptions omidOptions, @NotNull d<? super OMResult> dVar) {
        return i.g(this.mainDispatcher, new C31742(byteString, omidOptions, webView, null), dVar);
    }
}
