package com.unity3d.services;

import android.content.Context;
import com.ironsource.mediationsdk.metadata.a;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SetInitializationState;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.task.EmptyParams;
import com.unity3d.services.core.domain.task.InitializeSDK;
import h9.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.l;
import v8.n;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: UnityAdsSDK.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnityAdsSDK implements IServiceComponent {

    @NotNull
    public static final UnityAdsSDK INSTANCE;

    @NotNull
    private static final l alternativeFlowReader$delegate;

    @NotNull
    private static final l context$delegate;

    @NotNull
    private static final l getAdObject$delegate;

    @NotNull
    private static final l getInitializationState$delegate;

    @NotNull
    private static final l initializeBoldSDK$delegate;

    @NotNull
    private static final l initializeSDK$delegate;

    @NotNull
    private static final l omFinishSession$delegate;

    @NotNull
    private static final l sendDiagnosticEvent$delegate;

    @NotNull
    private static final l setInitializationState$delegate;

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$fetchToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: UnityAdsSDK.kt */
    @f(c = "com.unity3d.services.UnityAdsSDK", f = "UnityAdsSDK.kt", l = {143}, m = "fetchToken")
    static final class AnonymousClass1 extends d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return UnityAdsSDK.this.fetchToken(null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$finishOMIDSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsSDK.kt */
    @f(c = "com.unity3d.services.UnityAdsSDK$finishOMIDSession$1", f = "UnityAdsSDK.kt", l = {170, 171}, m = "invokeSuspend")
    static final class C32771 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ o0 $omidScope;
        final /* synthetic */ String $opportunityId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32771(String str, o0 o0Var, z8.d<? super C32771> dVar) {
            super(2, dVar);
            this.$opportunityId = str;
            this.$omidScope = o0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C32771(this.$opportunityId, this.$omidScope, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                v8.u.b(r5)
                goto L4f
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                v8.u.b(r5)
                goto L3c
            L1e:
                v8.u.b(r5)
                com.unity3d.services.UnityAdsSDK r5 = com.unity3d.services.UnityAdsSDK.INSTANCE
                com.unity3d.ads.core.configuration.AlternativeFlowReader r1 = com.unity3d.services.UnityAdsSDK.access$getAlternativeFlowReader(r5)
                boolean r1 = r1.invoke()
                if (r1 == 0) goto L4f
                com.unity3d.ads.core.domain.GetAdObject r5 = com.unity3d.services.UnityAdsSDK.access$getGetAdObject(r5)
                java.lang.String r1 = r4.$opportunityId
                r4.label = r3
                java.lang.Object r5 = r5.invoke(r1, r4)
                if (r5 != r0) goto L3c
                return r0
            L3c:
                com.unity3d.ads.core.data.model.AdObject r5 = (com.unity3d.ads.core.data.model.AdObject) r5
                if (r5 == 0) goto L4f
                com.unity3d.services.UnityAdsSDK r1 = com.unity3d.services.UnityAdsSDK.INSTANCE
                com.unity3d.ads.core.domain.om.OmFinishSession r1 = com.unity3d.services.UnityAdsSDK.access$getOmFinishSession(r1)
                r4.label = r2
                java.lang.Object r5 = r1.invoke(r5, r4)
                if (r5 != r0) goto L4f
                return r0
            L4f:
                kotlinx.coroutines.o0 r5 = r4.$omidScope
                r0 = 0
                kotlinx.coroutines.p0.e(r5, r0, r3, r0)
                v8.k0 r5 = v8.k0.f35197a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.UnityAdsSDK.C32771.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C32771) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$getToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsSDK.kt */
    @f(c = "com.unity3d.services.UnityAdsSDK$getToken$1", f = "UnityAdsSDK.kt", l = {115}, m = "invokeSuspend")
    static final class C32781 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super String>, Object> {
        int label;

        C32781(z8.d<? super C32781> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C32781(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                UnityAdsSDK unityAdsSDK = UnityAdsSDK.INSTANCE;
                this.label = 1;
                obj = unityAdsSDK.fetchToken(a.f13688g, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super String> dVar) {
            return ((C32781) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$getToken$2, reason: invalid class name */
    /* JADX INFO: compiled from: UnityAdsSDK.kt */
    @f(c = "com.unity3d.services.UnityAdsSDK$getToken$2", f = "UnityAdsSDK.kt", l = {122}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ l<GetAsyncHeaderBiddingToken> $getAsyncHeaderBiddingToken$delegate;
        final /* synthetic */ o0 $getTokenScope;
        final /* synthetic */ IUnityAdsTokenListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(IUnityAdsTokenListener iUnityAdsTokenListener, o0 o0Var, l<? extends GetAsyncHeaderBiddingToken> lVar, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$listener = iUnityAdsTokenListener;
            this.$getTokenScope = o0Var;
            this.$getAsyncHeaderBiddingToken$delegate = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass2(this.$listener, this.$getTokenScope, this.$getAsyncHeaderBiddingToken$delegate, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                GetAsyncHeaderBiddingToken token$lambda$0 = UnityAdsSDK.getToken$lambda$0(this.$getAsyncHeaderBiddingToken$delegate);
                IUnityAdsTokenListener iUnityAdsTokenListener = this.$listener;
                this.label = 1;
                if (token$lambda$0.invoke(iUnityAdsTokenListener, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            p0.e(this.$getTokenScope, null, 1, null);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$initialize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsSDK.kt */
    @f(c = "com.unity3d.services.UnityAdsSDK$initialize$1", f = "UnityAdsSDK.kt", l = {75, 77}, m = "invokeSuspend")
    static final class C32791 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ o0 $initScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32791(o0 o0Var, z8.d<? super C32791> dVar) {
            super(2, dVar);
            this.$initScope = o0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C32791(this.$initScope, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                UnityAdsSDK unityAdsSDK = UnityAdsSDK.INSTANCE;
                if (unityAdsSDK.getAlternativeFlowReader().invoke()) {
                    InitializeBoldSDK initializeBoldSDK = unityAdsSDK.getInitializeBoldSDK();
                    this.label = 1;
                    if (initializeBoldSDK.invoke(this) == objE) {
                        return objE;
                    }
                } else {
                    InitializeSDK initializeSDK = unityAdsSDK.getInitializeSDK();
                    EmptyParams emptyParams = EmptyParams.INSTANCE;
                    this.label = 2;
                    if (initializeSDK.mo4000invokegIAlus(emptyParams, this) == objE) {
                        return objE;
                    }
                }
            } else if (i10 == 1) {
                u.b(obj);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                ((t) obj).j();
            }
            p0.e(this.$initScope, null, 1, null);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C32791) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsSDK.kt */
    @f(c = "com.unity3d.services.UnityAdsSDK$load$1", f = "UnityAdsSDK.kt", l = {94}, m = "invokeSuspend")
    static final class C32801 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ UnityBannerSize $bannerSize;
        final /* synthetic */ IUnityAdsLoadListener $listener;
        final /* synthetic */ UnityAdsLoadOptions $loadOptions;
        final /* synthetic */ o0 $loadScope;
        final /* synthetic */ String $placementId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32801(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, o0 o0Var, z8.d<? super C32801> dVar) {
            super(2, dVar);
            this.$placementId = str;
            this.$loadOptions = unityAdsLoadOptions;
            this.$listener = iUnityAdsLoadListener;
            this.$bannerSize = unityBannerSize;
            this.$loadScope = o0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C32801(this.$placementId, this.$loadOptions, this.$listener, this.$bannerSize, this.$loadScope, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                UnityAdsSDK unityAdsSDK = UnityAdsSDK.INSTANCE;
                LegacyLoadUseCase legacyLoadUseCase = (LegacyLoadUseCase) unityAdsSDK.getServiceProvider().getRegistry().getService("", kotlin.jvm.internal.o0.b(LegacyLoadUseCase.class));
                Context context = unityAdsSDK.getContext();
                String str = this.$placementId;
                UnityAdsLoadOptions unityAdsLoadOptions = this.$loadOptions;
                IUnityAdsLoadListener iUnityAdsLoadListener = this.$listener;
                UnityBannerSize unityBannerSize = this.$bannerSize;
                this.label = 1;
                if (legacyLoadUseCase.invoke(context, str, unityAdsLoadOptions, iUnityAdsLoadListener, unityBannerSize, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            p0.e(this.$loadScope, null, 1, null);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C32801) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$show$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnityAdsSDK.kt */
    @f(c = "com.unity3d.services.UnityAdsSDK$show$1", f = "UnityAdsSDK.kt", l = {104}, m = "invokeSuspend")
    static final class C32811 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ Listeners $listener;
        final /* synthetic */ String $placementId;
        final /* synthetic */ LegacyShowUseCase $showBoldSDK;
        final /* synthetic */ UnityAdsShowOptions $showOptions;
        final /* synthetic */ o0 $showScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C32811(LegacyShowUseCase legacyShowUseCase, String str, UnityAdsShowOptions unityAdsShowOptions, Listeners listeners, o0 o0Var, z8.d<? super C32811> dVar) {
            super(2, dVar);
            this.$showBoldSDK = legacyShowUseCase;
            this.$placementId = str;
            this.$showOptions = unityAdsShowOptions;
            this.$listener = listeners;
            this.$showScope = o0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C32811(this.$showBoldSDK, this.$placementId, this.$showOptions, this.$listener, this.$showScope, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                LegacyShowUseCase legacyShowUseCase = this.$showBoldSDK;
                Context context = UnityAdsSDK.INSTANCE.getContext();
                String str = this.$placementId;
                UnityAdsShowOptions unityAdsShowOptions = this.$showOptions;
                Listeners listeners = this.$listener;
                this.label = 1;
                if (legacyShowUseCase.invoke(context, str, unityAdsShowOptions, listeners, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            p0.e(this.$showScope, null, 1, null);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C32811) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    static {
        UnityAdsSDK unityAdsSDK = new UnityAdsSDK();
        INSTANCE = unityAdsSDK;
        v8.p pVar = v8.p.f35203c;
        initializeSDK$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$1(unityAdsSDK, ""));
        alternativeFlowReader$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$2(unityAdsSDK, ""));
        initializeBoldSDK$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$3(unityAdsSDK, ""));
        getInitializationState$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$4(unityAdsSDK, ""));
        sendDiagnosticEvent$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$5(unityAdsSDK, ""));
        omFinishSession$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$6(unityAdsSDK, ""));
        getAdObject$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$7(unityAdsSDK, ""));
        setInitializationState$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$8(unityAdsSDK, ""));
        context$delegate = n.b(pVar, new UnityAdsSDK$special$$inlined$inject$default$9(unityAdsSDK, ""));
    }

    private UnityAdsSDK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchToken(java.lang.String r22, z8.d<? super java.lang.String> r23) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.UnityAdsSDK.fetchToken(java.lang.String, z8.d):java.lang.Object");
    }

    private static final GetHeaderBiddingToken fetchToken$lambda$1(l<? extends GetHeaderBiddingToken> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlternativeFlowReader getAlternativeFlowReader() {
        return (AlternativeFlowReader) alternativeFlowReader$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        return (Context) context$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetAdObject getGetAdObject() {
        return (GetAdObject) getAdObject$delegate.getValue();
    }

    private final GetInitializationState getGetInitializationState() {
        return (GetInitializationState) getInitializationState$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InitializeBoldSDK getInitializeBoldSDK() {
        return (InitializeBoldSDK) initializeBoldSDK$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InitializeSDK getInitializeSDK() {
        return (InitializeSDK) initializeSDK$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OmFinishSession getOmFinishSession() {
        return (OmFinishSession) omFinishSession$delegate.getValue();
    }

    private final SendDiagnosticEvent getSendDiagnosticEvent() {
        return (SendDiagnosticEvent) sendDiagnosticEvent$delegate.getValue();
    }

    private final SetInitializationState getSetInitializationState() {
        return (SetInitializationState) setInitializationState$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetAsyncHeaderBiddingToken getToken$lambda$0(l<? extends GetAsyncHeaderBiddingToken> lVar) {
        return lVar.getValue();
    }

    public static /* synthetic */ b2 load$default(UnityAdsSDK unityAdsSDK, String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            unityBannerSize = null;
        }
        return unityAdsSDK.load(str, unityAdsLoadOptions, iUnityAdsLoadListener, unityBannerSize);
    }

    public final void finishOMIDSession(@NotNull String opportunityId) {
        kotlin.jvm.internal.t.i(opportunityId, "opportunityId");
        o0 o0Var = (o0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_OMID_SCOPE, kotlin.jvm.internal.o0.b(o0.class));
        k.d(o0Var, null, null, new C32771(opportunityId, o0Var, null), 3, null);
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    @NotNull
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Nullable
    public final String getToken() {
        return (String) j.b(null, new C32781(null), 1, null);
    }

    public final void initialize() {
        getSetInitializationState().invoke(InitializationState.INITIALIZING);
        o0 o0Var = (o0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_INIT_SCOPE, kotlin.jvm.internal.o0.b(o0.class));
        k.d(o0Var, null, null, new C32791(o0Var, null), 3, null);
    }

    public final boolean isAlternativeFlowEnabled() {
        return getAlternativeFlowReader().invoke();
    }

    @NotNull
    public final b2 load(@Nullable String str, @NotNull UnityAdsLoadOptions loadOptions, @Nullable IUnityAdsLoadListener iUnityAdsLoadListener, @Nullable UnityBannerSize unityBannerSize) {
        kotlin.jvm.internal.t.i(loadOptions, "loadOptions");
        o0 o0Var = (o0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_LOAD_SCOPE, kotlin.jvm.internal.o0.b(o0.class));
        return k.d(o0Var, null, null, new C32801(str, loadOptions, iUnityAdsLoadListener, unityBannerSize, o0Var, null), 3, null);
    }

    @NotNull
    public final b2 show(@Nullable String str, @Nullable UnityAdsShowOptions unityAdsShowOptions, @NotNull Listeners listener) {
        kotlin.jvm.internal.t.i(listener, "listener");
        o0 o0Var = (o0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_SHOW_SCOPE, kotlin.jvm.internal.o0.b(o0.class));
        return k.d(o0Var, null, null, new C32811((LegacyShowUseCase) getServiceProvider().getRegistry().getService("", kotlin.jvm.internal.o0.b(LegacyShowUseCase.class)), str, unityAdsShowOptions, listener, o0Var, null), 3, null);
    }

    public final void getToken(@Nullable IUnityAdsTokenListener iUnityAdsTokenListener) {
        l lVarB = n.b(v8.p.f35203c, new UnityAdsSDK$getToken$$inlined$inject$default$1(this, ""));
        o0 o0Var = (o0) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_GET_TOKEN_SCOPE, kotlin.jvm.internal.o0.b(o0.class));
        k.d(o0Var, null, null, new AnonymousClass2(iUnityAdsTokenListener, o0Var, lVarB, null), 3, null);
    }
}
