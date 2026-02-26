package com.vungle.ads.internal.bidding;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.model.f;
import com.vungle.ads.internal.network.i;
import com.vungle.ads.internal.util.c;
import com.vungle.ads.internal.util.n;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.o;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BidTokenEncoder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    @NotNull
    public static final c Companion = new c(null);
    public static final int TOKEN_VERSION = 6;

    @NotNull
    private final Context context;
    private long enterBackgroundTime;

    @NotNull
    private final kotlinx.serialization.json.a json;
    private int ordinalView;

    /* JADX INFO: renamed from: com.vungle.ads.internal.bidding.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BidTokenEncoder.kt */
    public static final class C0501a extends c.C0535c {
        C0501a() {
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onPause() {
            super.onPause();
            a.this.onPause$vungle_ads_release();
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onResume() {
            super.onResume();
            a.this.onResume$vungle_ads_release();
        }
    }

    /* JADX INFO: compiled from: BidTokenEncoder.kt */
    public static final class b {

        @NotNull
        private final String bidToken;

        @NotNull
        private final String errorMessage;

        public b(@NotNull String bidToken, @NotNull String errorMessage) {
            t.i(bidToken, "bidToken");
            t.i(errorMessage, "errorMessage");
            this.bidToken = bidToken;
            this.errorMessage = errorMessage;
        }

        public static /* synthetic */ b copy$default(b bVar, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = bVar.bidToken;
            }
            if ((i10 & 2) != 0) {
                str2 = bVar.errorMessage;
            }
            return bVar.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.bidToken;
        }

        @NotNull
        public final String component2() {
            return this.errorMessage;
        }

        @NotNull
        public final b copy(@NotNull String bidToken, @NotNull String errorMessage) {
            t.i(bidToken, "bidToken");
            t.i(errorMessage, "errorMessage");
            return new b(bidToken, errorMessage);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return t.d(this.bidToken, bVar.bidToken) && t.d(this.errorMessage, bVar.errorMessage);
        }

        @NotNull
        public final String getBidToken() {
            return this.bidToken;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return (this.bidToken.hashCode() * 31) + this.errorMessage.hashCode();
        }

        @NotNull
        public String toString() {
            return "BiddingTokenInfo(bidToken=" + this.bidToken + ", errorMessage=" + this.errorMessage + ')';
        }
    }

    /* JADX INFO: compiled from: BidTokenEncoder.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class d extends v implements h9.a<i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.i, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final i invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(i.class);
        }
    }

    /* JADX INFO: compiled from: BidTokenEncoder.kt */
    static final class e extends v implements l<kotlinx.serialization.json.c, k0> {
        public static final e INSTANCE = new e();

        e() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }

    public a(@NotNull Context context) {
        t.i(context, "context");
        this.context = context;
        this.json = m.b(null, e.INSTANCE, 1, null);
        com.vungle.ads.internal.util.c.Companion.addLifecycleListener(new C0501a());
    }

    /* JADX INFO: renamed from: constructV6Token$lambda-0, reason: not valid java name */
    private static final i m4035constructV6Token$lambda0(v8.l<i> lVar) {
        return lVar.getValue();
    }

    private final b generateBidToken() {
        try {
            String strConstructV6Token$vungle_ads_release = constructV6Token$vungle_ads_release();
            p.a aVar = p.Companion;
            aVar.d("BidTokenEncoder", "BidToken: " + strConstructV6Token$vungle_ads_release);
            try {
                String str = "6:" + n.INSTANCE.convertForSending(strConstructV6Token$vungle_ads_release);
                aVar.d("BidTokenEncoder", "After conversion: " + str);
                return new b(str, "");
            } catch (Exception e10) {
                String str2 = "Fail to gzip token data. " + e10.getLocalizedMessage();
                o.INSTANCE.logError$vungle_ads_release(116, str2, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
                return new b("", str2);
            }
        } catch (Exception e11) {
            String str3 = "Failed to encode TokenParameters. " + e11.getLocalizedMessage();
            o.INSTANCE.logError$vungle_ads_release(119, str3, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            return new b("", str3);
        }
    }

    @VisibleForTesting
    @NotNull
    public final String constructV6Token$vungle_ads_release() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        f fVarRequestBody = m4035constructV6Token$lambda0(v8.n.b(v8.p.f35201a, new d(this.context))).requestBody(!r1.signalsDisabled(), com.vungle.ads.internal.k.INSTANCE.fpdEnabled());
        com.vungle.ads.internal.model.l lVar = new com.vungle.ads.internal.model.l(fVarRequestBody.getDevice(), fVarRequestBody.getUser(), fVarRequestBody.getExt(), new com.vungle.ads.internal.model.k(i.Companion.getHeaderUa()), this.ordinalView);
        kotlinx.serialization.json.a aVar = this.json;
        KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.j(com.vungle.ads.internal.model.l.class));
        t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return aVar.c(kSerializerB, lVar);
    }

    @NotNull
    public final b encode() {
        this.ordinalView++;
        return generateBidToken();
    }

    public final long getEnterBackgroundTime$vungle_ads_release() {
        return this.enterBackgroundTime;
    }

    public final int getOrdinalView$vungle_ads_release() {
        return this.ordinalView;
    }

    @VisibleForTesting(otherwise = 2)
    public final void onPause$vungle_ads_release() {
        this.enterBackgroundTime = System.currentTimeMillis();
    }

    @VisibleForTesting(otherwise = 2)
    public final void onResume$vungle_ads_release() {
        if (this.enterBackgroundTime == 0) {
            p.Companion.d("BidTokenEncoder", "BidTokenEncoder#onResume skipped");
            return;
        }
        if (System.currentTimeMillis() > this.enterBackgroundTime + com.vungle.ads.internal.k.INSTANCE.getSessionTimeout()) {
            this.ordinalView = 0;
            this.enterBackgroundTime = 0L;
        }
    }

    public final void setEnterBackgroundTime$vungle_ads_release(long j10) {
        this.enterBackgroundTime = j10;
    }

    public final void setOrdinalView$vungle_ads_release(int i10) {
        this.ordinalView = i10;
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getEnterBackgroundTime$vungle_ads_release$annotations() {
    }

    private static /* synthetic */ void getJson$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getOrdinalView$vungle_ads_release$annotations() {
    }
}
