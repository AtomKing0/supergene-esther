package com.moloco.sdk.publisher;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.internal.StabilityInferred;
import com.ironsource.ad;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.acm.e;
import com.moloco.sdk.acm.g;
import com.moloco.sdk.i;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.android_context.b;
import com.moloco.sdk.internal.configs.a;
import com.moloco.sdk.internal.publisher.e0;
import com.moloco.sdk.internal.publisher.f0;
import com.moloco.sdk.internal.scheduling.c;
import com.moloco.sdk.internal.services.bidtoken.i;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import com.moloco.sdk.service_locator.a;
import h9.p;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.l;
import v8.n;
import v8.q;
import v8.s;
import v8.u;
import v8.y;
import z8.d;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class Moloco {

    @Nullable
    private static b2 initJob;

    @Nullable
    private static MolocoInitParams initParams;

    @NotNull
    public static final Moloco INSTANCE = new Moloco();

    @NotNull
    private static final l initializationHandler$delegate = n.a(Moloco$initializationHandler$2.INSTANCE);

    @NotNull
    private static final l bidTokenHandler$delegate = n.a(Moloco$bidTokenHandler$2.INSTANCE);

    @NotNull
    private static final l adCreator$delegate = n.a(Moloco$adCreator$2.INSTANCE);

    @NotNull
    private static final o0 scope = p0.a(c.a().getMain());
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createBanner$1, reason: invalid class name */
    @f(c = "com.moloco.sdk.publisher.Moloco$createBanner$1", f = "Moloco.kt", l = {191}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ p<Banner, MolocoAdError.AdCreateError, k0> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String str, String str2, p<? super Banner, ? super MolocoAdError.AdCreateError, k0> pVar, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$adUnitId, this.$watermarkString, this.$callback, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            s sVarA;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.internal.publisher.c adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.f(str, str2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            t tVar = (t) obj;
            if (tVar instanceof t.b) {
                sVarA = y.a(((t.b) tVar).a(), null);
            } else {
                if (!(tVar instanceof t.a)) {
                    throw new q();
                }
                sVarA = y.a(null, ((t.a) tVar).a());
            }
            Banner banner = (Banner) sVarA.a();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) sVarA.b();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append("Banner for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(banner == null);
            MolocoLogger.info$default(molocoLogger, "Moloco", sb.toString(), null, false, 12, null);
            this.$callback.mo4invoke(banner, adCreateError);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createBannerTablet$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "com.moloco.sdk.publisher.Moloco$createBannerTablet$1", f = "Moloco.kt", l = {220}, m = "invokeSuspend")
    public static final class C31241 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ p<Banner, MolocoAdError.AdCreateError, k0> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C31241(String str, String str2, p<? super Banner, ? super MolocoAdError.AdCreateError, k0> pVar, d<? super C31241> dVar) {
            super(2, dVar);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C31241(this.$adUnitId, this.$watermarkString, this.$callback, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            s sVarA;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.internal.publisher.c adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.i(str, str2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            t tVar = (t) obj;
            if (tVar instanceof t.b) {
                sVarA = y.a(((t.b) tVar).a(), null);
            } else {
                if (!(tVar instanceof t.a)) {
                    throw new q();
                }
                sVarA = y.a(null, ((t.a) tVar).a());
            }
            Banner banner = (Banner) sVarA.a();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) sVarA.b();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append("Banner for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(banner == null);
            MolocoLogger.info$default(molocoLogger, "Moloco", sb.toString(), null, false, 12, null);
            this.$callback.mo4invoke(banner, adCreateError);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C31241) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createInterstitial$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "com.moloco.sdk.publisher.Moloco$createInterstitial$1", f = "Moloco.kt", l = {306}, m = "invokeSuspend")
    public static final class C31251 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ p<InterstitialAd, MolocoAdError.AdCreateError, k0> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C31251(String str, String str2, p<? super InterstitialAd, ? super MolocoAdError.AdCreateError, k0> pVar, d<? super C31251> dVar) {
            super(2, dVar);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C31251(this.$adUnitId, this.$watermarkString, this.$callback, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            s sVarA;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.internal.publisher.c adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.j(str, str2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            t tVar = (t) obj;
            if (tVar instanceof t.b) {
                sVarA = y.a(((t.b) tVar).a(), null);
            } else {
                if (!(tVar instanceof t.a)) {
                    throw new q();
                }
                sVarA = y.a(null, ((t.a) tVar).a());
            }
            InterstitialAd interstitialAd = (InterstitialAd) sVarA.a();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) sVarA.b();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append("Interstitial for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(interstitialAd == null);
            MolocoLogger.info$default(molocoLogger, "Moloco", sb.toString(), null, false, 12, null);
            this.$callback.mo4invoke(interstitialAd, adCreateError);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C31251) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createMREC$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "com.moloco.sdk.publisher.Moloco$createMREC$1", f = "Moloco.kt", l = {249}, m = "invokeSuspend")
    public static final class C31261 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ p<Banner, MolocoAdError.AdCreateError, k0> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C31261(String str, String str2, p<? super Banner, ? super MolocoAdError.AdCreateError, k0> pVar, d<? super C31261> dVar) {
            super(2, dVar);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C31261(this.$adUnitId, this.$watermarkString, this.$callback, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            s sVarA;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.internal.publisher.c adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.l(str, str2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            t tVar = (t) obj;
            if (tVar instanceof t.b) {
                sVarA = y.a(((t.b) tVar).a(), null);
            } else {
                if (!(tVar instanceof t.a)) {
                    throw new q();
                }
                sVarA = y.a(null, ((t.a) tVar).a());
            }
            Banner banner = (Banner) sVarA.a();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) sVarA.b();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append("MREC for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(banner == null);
            MolocoLogger.info$default(molocoLogger, "Moloco", sb.toString(), null, false, 12, null);
            this.$callback.mo4invoke(banner, adCreateError);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C31261) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createNativeAd$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "com.moloco.sdk.publisher.Moloco$createNativeAd$1", f = "Moloco.kt", l = {279}, m = "invokeSuspend")
    public static final class C31271 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ p<NativeAd, MolocoAdError.AdCreateError, k0> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C31271(String str, String str2, p<? super NativeAd, ? super MolocoAdError.AdCreateError, k0> pVar, d<? super C31271> dVar) {
            super(2, dVar);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C31271(this.$adUnitId, this.$watermarkString, this.$callback, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            s sVarA;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.internal.publisher.c adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.m(str, str2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            t tVar = (t) obj;
            if (tVar instanceof t.b) {
                sVarA = y.a(((t.b) tVar).a(), null);
            } else {
                if (!(tVar instanceof t.a)) {
                    throw new q();
                }
                sVarA = y.a(null, ((t.a) tVar).a());
            }
            NativeAd nativeAd = (NativeAd) sVarA.a();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) sVarA.b();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append("Native Ad for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(nativeAd == null);
            MolocoLogger.info$default(molocoLogger, "Moloco", sb.toString(), null, false, 12, null);
            this.$callback.mo4invoke(nativeAd, adCreateError);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C31271) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createRewardedInterstitial$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "com.moloco.sdk.publisher.Moloco$createRewardedInterstitial$1", f = "Moloco.kt", l = {334}, m = "invokeSuspend")
    public static final class C31281 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ p<RewardedInterstitialAd, MolocoAdError.AdCreateError, k0> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C31281(String str, String str2, p<? super RewardedInterstitialAd, ? super MolocoAdError.AdCreateError, k0> pVar, d<? super C31281> dVar) {
            super(2, dVar);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C31281(this.$adUnitId, this.$watermarkString, this.$callback, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            s sVarA;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.internal.publisher.c adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.n(str, str2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            t tVar = (t) obj;
            if (tVar instanceof t.b) {
                sVarA = y.a(((t.b) tVar).a(), null);
            } else {
                if (!(tVar instanceof t.a)) {
                    throw new q();
                }
                sVarA = y.a(null, ((t.a) tVar).a());
            }
            RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) sVarA.a();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) sVarA.b();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append("Rewarded for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(rewardedInterstitialAd == null);
            MolocoLogger.info$default(molocoLogger, "Moloco", sb.toString(), null, false, 12, null);
            this.$callback.mo4invoke(rewardedInterstitialAd, adCreateError);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C31281) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$getBidToken$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "com.moloco.sdk.publisher.Moloco$getBidToken$1", f = "Moloco.kt", l = {156}, m = "invokeSuspend")
    public static final class C31291 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ MolocoBidTokenListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C31291(MolocoBidTokenListener molocoBidTokenListener, d<? super C31291> dVar) {
            super(2, dVar);
            this.$listener = molocoBidTokenListener;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C31291(this.$listener, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Handling bid token request", null, false, 12, null);
                i bidTokenHandler = Moloco.INSTANCE.getBidTokenHandler();
                MolocoBidTokenListener molocoBidTokenListener = this.$listener;
                this.label = 1;
                if (bidTokenHandler.a(molocoBidTokenListener, this) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C31291) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$initialize$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "com.moloco.sdk.publisher.Moloco$initialize$1", f = "Moloco.kt", l = {109, 111, 125}, m = "invokeSuspend")
    public static final class C31301 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ MolocoInitParams $initParam;
        final /* synthetic */ MolocoInitializationListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C31301(MolocoInitParams molocoInitParams, MolocoInitializationListener molocoInitializationListener, d<? super C31301> dVar) {
            super(2, dVar);
            this.$initParam = molocoInitParams;
            this.$listener = molocoInitializationListener;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C31301(this.$initParam, this.$listener, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e2  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 238
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.publisher.Moloco.C31301.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C31301) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    private Moloco() {
    }

    public static final void createBanner(@NotNull String adUnitId, @Nullable String str, @NotNull p<? super Banner, ? super MolocoAdError.AdCreateError, k0> callback) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner async for adUnitId: " + adUnitId, null, false, 12, null);
        k.d(scope, null, null, new AnonymousClass1(adUnitId, str, callback, null), 3, null);
    }

    public static /* synthetic */ void createBanner$default(String str, String str2, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        createBanner(str, str2, pVar);
    }

    public static final void createBannerTablet(@NotNull String adUnitId, @Nullable String str, @NotNull p<? super Banner, ? super MolocoAdError.AdCreateError, k0> callback) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner tablet async for adUnitId: " + adUnitId, null, false, 12, null);
        k.d(scope, null, null, new C31241(adUnitId, str, callback, null), 3, null);
    }

    public static /* synthetic */ void createBannerTablet$default(String str, String str2, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        createBannerTablet(str, str2, pVar);
    }

    public static final void createInterstitial(@NotNull String adUnitId, @Nullable String str, @NotNull p<? super InterstitialAd, ? super MolocoAdError.AdCreateError, k0> callback) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating interstitial ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        k.d(scope, null, null, new C31251(adUnitId, str, callback, null), 3, null);
    }

    public static /* synthetic */ void createInterstitial$default(String str, String str2, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        createInterstitial(str, str2, pVar);
    }

    public static final void createMREC(@NotNull String adUnitId, @Nullable String str, @NotNull p<? super Banner, ? super MolocoAdError.AdCreateError, k0> callback) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner MREC async for adUnitId: " + adUnitId, null, false, 12, null);
        k.d(scope, null, null, new C31261(adUnitId, str, callback, null), 3, null);
    }

    public static /* synthetic */ void createMREC$default(String str, String str2, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        createMREC(str, str2, pVar);
    }

    public static final void createNativeAd(@NotNull String adUnitId, @Nullable String str, @NotNull p<? super NativeAd, ? super MolocoAdError.AdCreateError, k0> callback) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating native ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        k.d(scope, null, null, new C31271(adUnitId, str, callback, null), 3, null);
    }

    public static /* synthetic */ void createNativeAd$default(String str, String str2, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        createNativeAd(str, str2, pVar);
    }

    public static final void createRewardedInterstitial(@NotNull String adUnitId, @Nullable String str, @NotNull p<? super RewardedInterstitialAd, ? super MolocoAdError.AdCreateError, k0> callback) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating rewarded ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        k.d(scope, null, null, new C31281(adUnitId, str, callback, null), 3, null);
    }

    public static /* synthetic */ void createRewardedInterstitial$default(String str, String str2, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        createRewardedInterstitial(str, str2, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.moloco.sdk.internal.publisher.c getAdCreator() {
        return (com.moloco.sdk.internal.publisher.c) adCreator$delegate.getValue();
    }

    @Nullable
    public static final String getBidRequestEndpoint() {
        String strB;
        com.moloco.sdk.i iVarK = INSTANCE.getInitializationHandler().k();
        if (iVarK == null || (strB = iVarK.b()) == null) {
            return null;
        }
        if (p9.q.K(strB, "http://", false, 2, null) || p9.q.K(strB, "https://", false, 2, null)) {
            return strB;
        }
        return "https://" + strB;
    }

    public static final void getBidToken(@NotNull Context context, @NotNull MolocoBidTokenListener listener) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(listener, "listener");
        b.a(context);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Fetching bid token", null, false, 12, null);
        k.d(com.moloco.sdk.internal.scheduling.d.f18390a.a(), null, null, new C31291(listener, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i getBidTokenHandler() {
        return (i) bidTokenHandler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e0 getInitializationHandler() {
        return (e0) initializationHandler$delegate.getValue();
    }

    public static final void initialize(@NotNull MolocoInitParams initParam) {
        kotlin.jvm.internal.t.i(initParam, "initParam");
        initialize$default(initParam, null, 2, null);
    }

    public static /* synthetic */ void initialize$default(MolocoInitParams molocoInitParams, MolocoInitializationListener molocoInitializationListener, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            molocoInitializationListener = null;
        }
        initialize(molocoInitParams, molocoInitializationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeAndroidClientMetrics(MolocoInitParams molocoInitParams) {
        String name;
        if (!getInitializationHandler().i()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "Moloco", "ACM cannot be initialized as Moloco SDK cannot be initialized", null, false, 12, null);
            return;
        }
        a aVarA = com.moloco.sdk.internal.configs.b.a();
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        String appKey = molocoInitParams.getAppKey();
        String strB = aVarA.b();
        Context appContext = molocoInitParams.getAppContext();
        long jA = aVarA.a();
        s[] sVarArr = new s[7];
        sVarArr[0] = y.a("AppKey", molocoInitParams.getAppKey());
        a.e eVar = a.e.f18889a;
        sVarArr[1] = y.a("AppBundle", eVar.b().invoke().a());
        sVarArr[2] = y.a("AppVersion", eVar.b().invoke().b());
        sVarArr[3] = y.a("SdkVersion", BuildConfig.SDK_VERSION_NAME);
        sVarArr[4] = y.a("OS", eVar.f().invoke().i());
        sVarArr[5] = y.a(ad.f11278z, eVar.f().invoke().j());
        MediationInfo mediationInfo$moloco_sdk_release = getMediationInfo$moloco_sdk_release();
        if (mediationInfo$moloco_sdk_release == null || (name = mediationInfo$moloco_sdk_release.getName()) == null) {
            name = "";
        }
        sVarArr[6] = y.a("Mediator", name);
        com.moloco.sdk.acm.a.r(aVar, new e(appKey, strB, appContext, jA, r0.j(sVarArr)), null, 2, null);
    }

    public static final boolean isInitialized() {
        return INSTANCE.getInitializationHandler().j().getValue() == Initialization.SUCCESS;
    }

    private final void logMolocoInfo(MolocoInitParams molocoInitParams) {
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, "Moloco", "=====================================", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "Moloco SDK initializing", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "SDK Version: 3.9.0", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "Mediation: " + molocoInitParams.getMediationInfo().getName(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "isInitialized: " + isInitialized(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "=====================================", null, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processInitConfigs(com.moloco.sdk.i iVar) {
        if (iVar.j()) {
            i.e eVarE = iVar.e();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, "Moloco", "Init response has eventCollectionConfig", false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "eventCollectionConfig:", false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "eventCollectionEnabled: " + eVarE.e(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "mrefCollectionEnabled: " + eVarE.f(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "appFgUrl: " + eVarE.c(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "appBgUrl: " + eVarE.b(), false, 4, null);
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b bVarB = a.k.f18946a.b();
            boolean zE = eVarE.e();
            boolean zF = eVarE.f();
            String appForegroundTrackingUrl = eVarE.c();
            kotlin.jvm.internal.t.h(appForegroundTrackingUrl, "appForegroundTrackingUrl");
            String appBackgroundTrackingUrl = eVarE.b();
            kotlin.jvm.internal.t.h(appBackgroundTrackingUrl, "appBackgroundTrackingUrl");
            bVarB.a(zE, zF, appForegroundTrackingUrl, appBackgroundTrackingUrl);
            if (eVarE.e()) {
                a.b.f18871a.b().a();
            }
        } else {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, "Moloco", "Init response does not have eventCollectionConfig", false, 4, null);
        }
        a.c.f18881a.a().a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateAndroidClientMetricsOnInitSuccess(d<? super k0> dVar) {
        Object objX = com.moloco.sdk.acm.a.f17293a.x(new g(((com.moloco.sdk.internal.configs.a) a.c.f18881a.a().b(com.moloco.sdk.internal.configs.a.class, com.moloco.sdk.internal.configs.b.a())).b(), kotlin.coroutines.jvm.internal.b.e(r0.a())), dVar);
        return objX == a9.d.e() ? objX : k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.VisibleForTesting(otherwise = 5)
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearState$moloco_sdk_release(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.moloco.sdk.publisher.Moloco$clearState$1
            if (r0 == 0) goto L13
            r0 = r13
            com.moloco.sdk.publisher.Moloco$clearState$1 r0 = (com.moloco.sdk.publisher.Moloco$clearState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.moloco.sdk.publisher.Moloco$clearState$1 r0 = new com.moloco.sdk.publisher.Moloco$clearState$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            v8.u.b(r13)
            goto L6f
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L35:
            java.lang.Object r2 = r0.L$0
            com.moloco.sdk.publisher.Moloco r2 = (com.moloco.sdk.publisher.Moloco) r2
            v8.u.b(r13)
            goto L5e
        L3d:
            v8.u.b(r13)
            com.moloco.sdk.internal.MolocoLogger r6 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r7 = "Moloco"
            java.lang.String r8 = "clearState() unit testing function called"
            r9 = 0
            r10 = 4
            r11 = 0
            com.moloco.sdk.internal.MolocoLogger.debug$default(r6, r7, r8, r9, r10, r11)
            com.moloco.sdk.publisher.Moloco.initParams = r5
            kotlinx.coroutines.b2 r13 = com.moloco.sdk.publisher.Moloco.initJob
            if (r13 == 0) goto L5d
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = kotlinx.coroutines.f2.g(r13, r0)
            if (r13 != r1) goto L5d
            return r1
        L5d:
            r2 = r12
        L5e:
            com.moloco.sdk.publisher.Moloco.initJob = r5
            com.moloco.sdk.internal.publisher.e0 r13 = r2.getInitializationHandler()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r13 = r13.h(r0)
            if (r13 != r1) goto L6f
            return r1
        L6f:
            v8.k0 r13 = v8.k0.f35197a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.publisher.Moloco.clearState$moloco_sdk_release(z8.d):java.lang.Object");
    }

    @Nullable
    public final String getAppKey$moloco_sdk_release() {
        MolocoInitParams molocoInitParams = initParams;
        if (molocoInitParams != null) {
            return molocoInitParams.getAppKey();
        }
        return null;
    }

    @Nullable
    public final b2 getInitJob() {
        return initJob;
    }

    @Nullable
    public final MolocoInitParams getInitParams() {
        return initParams;
    }

    @Nullable
    public final MediationInfo getMediationInfo$moloco_sdk_release() {
        MolocoInitParams molocoInitParams = initParams;
        if (molocoInitParams != null) {
            return molocoInitParams.getMediationInfo();
        }
        return null;
    }

    public final void setInitJob(@Nullable b2 b2Var) {
        initJob = b2Var;
    }

    public final void setInitParams(@Nullable MolocoInitParams molocoInitParams) {
        initParams = molocoInitParams;
    }

    public static final synchronized void initialize(@NotNull MolocoInitParams initParam, @Nullable MolocoInitializationListener molocoInitializationListener) {
        kotlin.jvm.internal.t.i(initParam, "initParam");
        INSTANCE.logMolocoInfo(initParam);
        if (isInitialized()) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Already initialized. Returning and notifying listener", null, false, 12, null);
            if (molocoInitializationListener != null) {
                f0.a(molocoInitializationListener, e0.f17939f.a());
            }
            return;
        }
        b2 b2Var = initJob;
        if (b2Var != null && b2Var.isActive()) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Job active. Returning", null, false, 12, null);
        } else {
            if (initParam.getAppKey().length() == 0) {
                throw new IllegalArgumentException("Moloco SDK initialized with empty appKey");
            }
            initParams = initParam;
            b.a(initParam.getAppContext());
            initJob = k.d(p0.a(c.a().getIo()), null, null, new C31301(initParam, molocoInitializationListener, null), 3, null);
        }
    }

    public static /* synthetic */ void getBidRequestEndpoint$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getInitJob$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getInitParams$annotations() {
    }

    public static /* synthetic */ void isInitialized$annotations() {
    }
}
