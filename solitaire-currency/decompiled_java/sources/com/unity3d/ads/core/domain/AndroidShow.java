package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.j;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: AndroidShow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidShow implements Show {

    @NotNull
    private final AdRepository adRepository;

    @NotNull
    private final GameServerIdReader gameServerIdReader;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidShow.kt */
    @f(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1", f = "AndroidShow.kt", l = {23, 39}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<i<? super ShowEvent>, z8.d<? super k0>, Object> {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ Context $context;
        final /* synthetic */ UnityAdsShowOptions $showOptions;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AndroidShow this$0;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: AndroidShow.kt */
        @f(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$2", f = "AndroidShow.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass2 extends l implements p<i<? super ShowEvent>, z8.d<? super k0>, Object> {
            final /* synthetic */ AdObject $ad;
            final /* synthetic */ Context $context;
            final /* synthetic */ UnityAdsShowOptions $showOptions;
            int label;
            final /* synthetic */ AndroidShow this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AdObject adObject, AndroidShow androidShow, Context context, UnityAdsShowOptions unityAdsShowOptions, z8.d<? super AnonymousClass2> dVar) {
                super(2, dVar);
                this.$ad = adObject;
                this.this$0 = androidShow;
                this.$context = context;
                this.$showOptions = unityAdsShowOptions;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass2(this.$ad, this.this$0, this.$context, this.$showOptions, dVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) throws org.json.JSONException {
                /*
                    r6 = this;
                    a9.b.e()
                    int r0 = r6.label
                    if (r0 != 0) goto L6f
                    v8.u.b(r7)
                    com.unity3d.ads.core.data.model.AdObject r7 = r6.$ad
                    com.unity3d.ads.core.domain.AndroidShow r0 = r6.this$0
                    com.unity3d.ads.core.configuration.GameServerIdReader r0 = com.unity3d.ads.core.domain.AndroidShow.access$getGameServerIdReader$p(r0)
                    com.unity3d.services.core.misc.JsonStorage r1 = r0.getJsonStorage()
                    java.lang.String r2 = r0.getKey()
                    java.lang.Object r1 = r1.get(r2)
                    java.lang.String r2 = "get(key)"
                    r3 = 0
                    if (r1 == 0) goto L2e
                    kotlin.jvm.internal.t.h(r1, r2)
                    boolean r4 = r1 instanceof java.lang.String
                    if (r4 == 0) goto L2b
                    goto L2c
                L2b:
                    r1 = r3
                L2c:
                    if (r1 != 0) goto L2f
                L2e:
                    r1 = r3
                L2f:
                    com.unity3d.services.core.misc.JsonStorage r4 = r0.getJsonStorage()
                    java.lang.String r5 = r0.getKey()
                    java.lang.Object r4 = r4.get(r5)
                    if (r4 == 0) goto L4b
                    kotlin.jvm.internal.t.h(r4, r2)
                    com.unity3d.services.core.misc.JsonStorage r2 = r0.getJsonStorage()
                    java.lang.String r0 = r0.getKey()
                    r2.delete(r0)
                L4b:
                    java.lang.String r1 = (java.lang.String) r1
                    r7.setPlayerServerId(r1)
                    com.unity3d.ads.core.data.model.AdObject r7 = r6.$ad
                    com.unity3d.ads.adplayer.AdPlayer r7 = r7.getAdPlayer()
                    com.unity3d.ads.adplayer.AndroidShowOptions r0 = new com.unity3d.ads.adplayer.AndroidShowOptions
                    android.content.Context r1 = r6.$context
                    com.unity3d.ads.UnityAdsShowOptions r2 = r6.$showOptions
                    org.json.JSONObject r2 = r2.getData()
                    if (r2 == 0) goto L66
                    java.util.Map r3 = com.unity3d.ads.core.extensions.JSONObjectExtensionsKt.toBuiltInMap(r2)
                L66:
                    r0.<init>(r1, r3)
                    r7.show(r0)
                    v8.k0 r7 = v8.k0.f35197a
                    return r7
                L6f:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidShow.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull i<? super ShowEvent> iVar, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass2) create(iVar, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: AndroidShow.kt */
        @f(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$3", f = "AndroidShow.kt", l = {34}, m = "invokeSuspend")
        static final class AnonymousClass3 extends l implements q<i<? super ShowEvent>, Throwable, z8.d<? super k0>, Object> {
            final /* synthetic */ ByteString $opportunityId;
            int label;
            final /* synthetic */ AndroidShow this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(AndroidShow androidShow, ByteString byteString, z8.d<? super AnonymousClass3> dVar) {
                super(3, dVar);
                this.this$0 = androidShow;
                this.$opportunityId = byteString;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    AdRepository adRepository = this.this$0.adRepository;
                    ByteString byteString = this.$opportunityId;
                    this.label = 1;
                    if (adRepository.removeAd(byteString, this) == objE) {
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

            @Override // h9.q
            @Nullable
            public final Object invoke(@NotNull i<? super ShowEvent> iVar, @Nullable Throwable th, @Nullable z8.d<? super k0> dVar) {
                return new AnonymousClass3(this.this$0, this.$opportunityId, dVar).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: AndroidShow.kt */
        @f(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$4", f = "AndroidShow.kt", l = {36}, m = "invokeSuspend")
        static final class AnonymousClass4 extends l implements q<i<? super ShowEvent>, ShowEvent, z8.d<? super Boolean>, Object> {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass4(z8.d<? super AnonymousClass4> dVar) {
                super(3, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                ShowEvent showEvent;
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    i iVar = (i) this.L$0;
                    ShowEvent showEvent2 = (ShowEvent) this.L$1;
                    this.L$0 = showEvent2;
                    this.label = 1;
                    if (iVar.emit(showEvent2, this) == objE) {
                        return objE;
                    }
                    showEvent = showEvent2;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    showEvent = (ShowEvent) this.L$0;
                    u.b(obj);
                }
                return kotlin.coroutines.jvm.internal.b.a(((showEvent instanceof ShowEvent.Completed) || (showEvent instanceof ShowEvent.Error)) ? false : true);
            }

            @Override // h9.q
            @Nullable
            public final Object invoke(@NotNull i<? super ShowEvent> iVar, @NotNull ShowEvent showEvent, @Nullable z8.d<? super Boolean> dVar) {
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(dVar);
                anonymousClass4.L$0 = iVar;
                anonymousClass4.L$1 = showEvent;
                return anonymousClass4.invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AdObject adObject, AndroidShow androidShow, Context context, UnityAdsShowOptions unityAdsShowOptions, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$adObject = adObject;
            this.this$0 = androidShow;
            this.$context = context;
            this.$showOptions = unityAdsShowOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$adObject, this.this$0, this.$context, this.$showOptions, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object ad;
            final i iVar;
            ByteString byteString;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                i iVar2 = (i) this.L$0;
                if (!(!this.$adObject.getOpportunityId().isEmpty())) {
                    throw new IllegalArgumentException("No opportunityId".toString());
                }
                ByteString opportunityId = this.$adObject.getOpportunityId();
                AdRepository adRepository = this.this$0.adRepository;
                this.L$0 = iVar2;
                this.L$1 = opportunityId;
                this.label = 1;
                ad = adRepository.getAd(opportunityId, this);
                if (ad == objE) {
                    return objE;
                }
                iVar = iVar2;
                byteString = opportunityId;
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    return k0.f35197a;
                }
                byteString = (ByteString) this.L$1;
                i iVar3 = (i) this.L$0;
                u.b(obj);
                iVar = iVar3;
                ad = obj;
            }
            AdObject adObject = (AdObject) ad;
            if (adObject == null) {
                throw new IllegalStateException("No ad associated with opportunityId");
            }
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.this$0.sendDiagnosticEvent, "native_show_started_ad_viewer", null, null, null, this.$adObject, 14, null);
            AdPlayer adPlayer = adObject.getAdPlayer();
            if (adPlayer == null) {
                throw new IllegalStateException("No adPlayer associated with ad");
            }
            h hVarP = j.P(j.F(j.H(adPlayer.getOnShowEvent(), new AnonymousClass2(adObject, this.this$0, this.$context, this.$showOptions, null)), new AnonymousClass3(this.this$0, byteString, null)), new AnonymousClass4(null));
            i iVar4 = new i() { // from class: com.unity3d.ads.core.domain.AndroidShow.invoke.1.5
                @Nullable
                public final Object emit(@NotNull ShowEvent showEvent, @NotNull z8.d<? super k0> dVar) {
                    Object objEmit = iVar.emit(showEvent, dVar);
                    return objEmit == a9.d.e() ? objEmit : k0.f35197a;
                }

                @Override // s9.i
                public /* bridge */ /* synthetic */ Object emit(Object obj2, z8.d dVar) {
                    return emit((ShowEvent) obj2, (z8.d<? super k0>) dVar);
                }
            };
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (hVarP.collect(iVar4, this) == objE) {
                return objE;
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull i<? super ShowEvent> iVar, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(iVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public AndroidShow(@NotNull AdRepository adRepository, @NotNull GameServerIdReader gameServerIdReader, @NotNull SendDiagnosticEvent sendDiagnosticEvent) {
        t.i(adRepository, "adRepository");
        t.i(gameServerIdReader, "gameServerIdReader");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.adRepository = adRepository;
        this.gameServerIdReader = gameServerIdReader;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    @Override // com.unity3d.ads.core.domain.Show
    @NotNull
    public h<ShowEvent> invoke(@NotNull Context context, @NotNull AdObject adObject, @NotNull UnityAdsShowOptions showOptions) {
        t.i(context, "context");
        t.i(adObject, "adObject");
        t.i(showOptions, "showOptions");
        return j.z(new AnonymousClass1(adObject, this, context, showOptions, null));
    }

    @Override // com.unity3d.ads.core.domain.Show
    @Nullable
    public Object terminate(@NotNull AdObject adObject, @NotNull z8.d<? super k0> dVar) {
        AdPlayer adPlayer = adObject.getAdPlayer();
        if (adPlayer == null) {
            return k0.f35197a;
        }
        Object objDestroy = adPlayer.destroy(dVar);
        return objDestroy == a9.d.e() ? objDestroy : k0.f35197a;
    }
}
