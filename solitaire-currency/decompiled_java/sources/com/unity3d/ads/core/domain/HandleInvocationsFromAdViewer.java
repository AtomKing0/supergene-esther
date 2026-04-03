package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.adplayer.ExposedFunctionLocation;
import com.unity3d.ads.adplayer.Invocation;
import com.unity3d.ads.core.data.model.AdData;
import com.unity3d.ads.core.data.model.AdDataRefreshToken;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.ImpressionConfig;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import h9.p;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.c0;
import s9.h;
import s9.i;
import s9.j;
import v8.k0;
import v8.u;
import v8.y;

/* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HandleInvocationsFromAdViewer implements IServiceComponent {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String KEY_AD_DATA = "adData";

    @NotNull
    public static final String KEY_AD_DATA_REFRESH_TOKEN = "adDataRefreshToken";

    @NotNull
    public static final String KEY_DOWNLOAD_PRIORITY = "priority";

    @NotNull
    public static final String KEY_DOWNLOAD_URL = "url";

    @NotNull
    public static final String KEY_IMPRESSION_CONFIG = "impressionConfig";

    @NotNull
    public static final String KEY_LOAD_OPTIONS = "loadOptions";

    @NotNull
    public static final String KEY_NATIVE_CONTEXT = "nativeContext";

    @NotNull
    public static final String KEY_OMID = "openMeasurement";

    @NotNull
    public static final String KEY_OMJS_SERVICE = "serviceFilePath";

    @NotNull
    public static final String KEY_OMJS_SESSION = "sessionFilePath";

    @NotNull
    public static final String KEY_OM_PARTNER = "partnerName";

    @NotNull
    public static final String KEY_OM_PARTNER_VERSION = "partnerVersion";

    @NotNull
    public static final String KEY_OM_VERSION = "version";

    @NotNull
    public static final String KEY_PACKAGE_NAME = "packageName";

    @NotNull
    public static final String KEY_PRIVACY_UPDATE_CONTENT = "content";

    @NotNull
    public static final String KEY_PRIVACY_UPDATE_VERSION = "version";

    @NotNull
    public static final String KEY_TRACKING_TOKEN = "trackingToken";

    /* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2", f = "HandleInvocationsFromAdViewer.kt", l = {143}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<i<? super Invocation>, z8.d<? super k0>, Object> {
        final /* synthetic */ h9.l<z8.d<? super k0>, Object> $onSubscription;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(h9.l<? super z8.d<? super k0>, ? extends Object> lVar, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$onSubscription = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass2(this.$onSubscription, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                h9.l<z8.d<? super k0>, Object> lVar = this.$onSubscription;
                this.label = 1;
                if (lVar.invoke(this) == objE) {
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

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull i<? super Invocation> iVar, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(iVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$3", f = "HandleInvocationsFromAdViewer.kt", l = {147}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<Invocation, z8.d<? super k0>, Object> {
        final /* synthetic */ Map<String, h9.a<ExposedFunction>> $definition;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
        @f(c = "com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$3$1", f = "HandleInvocationsFromAdViewer.kt", l = {147}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements h9.l<z8.d<? super Object>, Object> {
            final /* synthetic */ ExposedFunction $exposedFunction;
            final /* synthetic */ Invocation $it;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ExposedFunction exposedFunction, Invocation invocation, z8.d<? super AnonymousClass1> dVar) {
                super(1, dVar);
                this.$exposedFunction = exposedFunction;
                this.$it = invocation;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
                return new AnonymousClass1(this.$exposedFunction, this.$it, dVar);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ Object invoke(z8.d<? super Object> dVar) {
                return invoke2((z8.d<Object>) dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    ExposedFunction exposedFunction = this.$exposedFunction;
                    Object[] parameters = this.$it.getParameters();
                    this.label = 1;
                    obj = exposedFunction.mo4invoke(parameters, this);
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

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@Nullable z8.d<Object> dVar) {
                return ((AnonymousClass1) create(dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Map<String, ? extends h9.a<? extends ExposedFunction>> map, z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$definition = map;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$definition, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull Invocation invocation, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass3) create(invocation, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            ExposedFunction exposedFunctionInvoke;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Invocation invocation = (Invocation) this.L$0;
                h9.a<ExposedFunction> aVar = this.$definition.get(invocation.getLocation());
                if (aVar == null || (exposedFunctionInvoke = aVar.invoke()) == null) {
                    return k0.f35197a;
                }
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(exposedFunctionInvoke, invocation, null);
                this.label = 1;
                if (invocation.handle(anonymousClass1, this) == objE) {
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

    @Override // com.unity3d.services.core.di.IServiceComponent
    @NotNull
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Nullable
    public final Object invoke(@NotNull c0<Invocation> c0Var, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull AdObject adObject, @NotNull h9.l<? super z8.d<? super k0>, ? extends Object> lVar, @NotNull z8.d<? super h<Invocation>> dVar) {
        return j.G(j.I(c0Var, new AnonymousClass2(lVar, null)), new AnonymousClass3(r0.j(y.a(ExposedFunctionLocation.GET_AD_CONTEXT, new HandleInvocationsFromAdViewer$invoke$definition$1(this, AdData.m3975constructorimpl(str), ImpressionConfig.m3989constructorimpl(str3), AdDataRefreshToken.m3982constructorimpl(str2), adObject)), y.a(ExposedFunctionLocation.GET_CONNECTION_TYPE, new HandleInvocationsFromAdViewer$invoke$definition$2(this)), y.a(ExposedFunctionLocation.GET_DEVICE_VOLUME, new HandleInvocationsFromAdViewer$invoke$definition$3(this)), y.a(ExposedFunctionLocation.GET_DEVICE_MAX_VOLUME, new HandleInvocationsFromAdViewer$invoke$definition$4(this)), y.a(ExposedFunctionLocation.GET_SCREEN_HEIGHT, new HandleInvocationsFromAdViewer$invoke$definition$5(this)), y.a(ExposedFunctionLocation.GET_SCREEN_WIDTH, new HandleInvocationsFromAdViewer$invoke$definition$6(this)), y.a(ExposedFunctionLocation.OPEN_URL, new HandleInvocationsFromAdViewer$invoke$definition$7(this)), y.a(ExposedFunctionLocation.SEND_OPERATIVE_EVENT, new HandleInvocationsFromAdViewer$invoke$definition$8(this, adObject)), y.a(ExposedFunctionLocation.STORAGE_WRITE, HandleInvocationsFromAdViewer$invoke$definition$9.INSTANCE), y.a(ExposedFunctionLocation.STORAGE_READ, HandleInvocationsFromAdViewer$invoke$definition$10.INSTANCE), y.a(ExposedFunctionLocation.STORAGE_DELETE, HandleInvocationsFromAdViewer$invoke$definition$11.INSTANCE), y.a(ExposedFunctionLocation.STORAGE_CLEAR, HandleInvocationsFromAdViewer$invoke$definition$12.INSTANCE), y.a(ExposedFunctionLocation.STORAGE_GET_KEYS, HandleInvocationsFromAdViewer$invoke$definition$13.INSTANCE), y.a(ExposedFunctionLocation.STORAGE_GET, HandleInvocationsFromAdViewer$invoke$definition$14.INSTANCE), y.a(ExposedFunctionLocation.STORAGE_SET, HandleInvocationsFromAdViewer$invoke$definition$15.INSTANCE), y.a(ExposedFunctionLocation.GET_PRIVACY_FSM, new HandleInvocationsFromAdViewer$invoke$definition$16(this)), y.a(ExposedFunctionLocation.SET_PRIVACY_FSM, new HandleInvocationsFromAdViewer$invoke$definition$17(this)), y.a(ExposedFunctionLocation.GET_PRIVACY, new HandleInvocationsFromAdViewer$invoke$definition$18(this)), y.a(ExposedFunctionLocation.SET_PRIVACY, new HandleInvocationsFromAdViewer$invoke$definition$19(this)), y.a(ExposedFunctionLocation.GET_ALLOWED_PII, new HandleInvocationsFromAdViewer$invoke$definition$20(this)), y.a(ExposedFunctionLocation.SET_ALLOWED_PII, new HandleInvocationsFromAdViewer$invoke$definition$21(this)), y.a(ExposedFunctionLocation.GET_SESSION_TOKEN, new HandleInvocationsFromAdViewer$invoke$definition$22(this)), y.a(ExposedFunctionLocation.MARK_CAMPAIGN_STATE_SHOWN, new HandleInvocationsFromAdViewer$invoke$definition$23(this, adObject)), y.a(ExposedFunctionLocation.REFRESH_AD_DATA, new HandleInvocationsFromAdViewer$invoke$definition$24(this, adObject)), y.a(ExposedFunctionLocation.UPDATE_TRACKING_TOKEN, new HandleInvocationsFromAdViewer$invoke$definition$25(adObject)), y.a(ExposedFunctionLocation.SEND_PRIVACY_UPDATE_REQUEST, new HandleInvocationsFromAdViewer$invoke$definition$26(this)), y.a(ExposedFunctionLocation.SEND_DIAGNOSTIC_EVENT, new HandleInvocationsFromAdViewer$invoke$definition$27(this, adObject)), y.a(ExposedFunctionLocation.INCREMENT_BANNER_IMPRESSION_COUNT, new HandleInvocationsFromAdViewer$invoke$definition$28(this)), y.a(ExposedFunctionLocation.DOWNLOAD, new HandleInvocationsFromAdViewer$invoke$definition$29(this, adObject)), y.a(ExposedFunctionLocation.IS_FILE_CACHED, new HandleInvocationsFromAdViewer$invoke$definition$30(this)), y.a(ExposedFunctionLocation.OM_START_SESSION, new HandleInvocationsFromAdViewer$invoke$definition$31(this, adObject)), y.a(ExposedFunctionLocation.OM_FINISH_SESSION, new HandleInvocationsFromAdViewer$invoke$definition$32(this, adObject)), y.a(ExposedFunctionLocation.OM_IMPRESSION, new HandleInvocationsFromAdViewer$invoke$definition$33(this, adObject)), y.a(ExposedFunctionLocation.OM_GET_DATA, new HandleInvocationsFromAdViewer$invoke$definition$34(this)), y.a(ExposedFunctionLocation.IS_ATTRIBUTION_AVAILABLE, new HandleInvocationsFromAdViewer$invoke$definition$35(this)), y.a(ExposedFunctionLocation.ATTRIBUTION_REGISTER_VIEW, new HandleInvocationsFromAdViewer$invoke$definition$36(this, adObject)), y.a(ExposedFunctionLocation.ATTRIBUTION_REGISTER_CLICK, new HandleInvocationsFromAdViewer$invoke$definition$37(this, adObject))), null));
    }
}
