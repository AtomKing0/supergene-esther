package androidx.privacysandbox.ads.adservices.adid;

import a9.c;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.core.os.OutcomeReceiverKt;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.dash.offline.a;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: AdIdManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AdIdManager {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: AdIdManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        @Nullable
        public final AdIdManager obtain(@NotNull Context context) {
            t.i(context, "context");
            if (AdServicesInfo.INSTANCE.version() >= 4) {
                return new Api33Ext4Impl(context);
            }
            return null;
        }
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    @Nullable
    public static final AdIdManager obtain(@NotNull Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    @Nullable
    public abstract Object getAdId(@NotNull d<? super AdId> dVar);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AdIdManager.kt */
    @RequiresExtension(extension = PlaybackException.CUSTOM_ERROR_CODE_BASE, version = 4)
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    static final class Api33Ext4Impl extends AdIdManager {

        @NotNull
        private final android.adservices.adid.AdIdManager mAdIdManager;

        public Api33Ext4Impl(@NotNull android.adservices.adid.AdIdManager mAdIdManager) {
            t.i(mAdIdManager, "mAdIdManager");
            this.mAdIdManager = mAdIdManager;
        }

        private final AdId convertResponse(android.adservices.adid.AdId adId) {
            String adId2 = adId.getAdId();
            t.h(adId2, "response.adId");
            return new AdId(adId2, adId.isLimitAdTrackingEnabled());
        }

        /* JADX INFO: Access modifiers changed from: private */
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
        public final Object getAdIdAsyncInternal(d<? super android.adservices.adid.AdId> dVar) throws Throwable {
            p pVar = new p(c.c(dVar), 1);
            pVar.C();
            this.mAdIdManager.getAdId(new a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.privacysandbox.ads.adservices.adid.AdIdManager
        @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
        @androidx.annotation.DoNotInline
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object getAdId(@org.jetbrains.annotations.NotNull z8.d<? super androidx.privacysandbox.ads.adservices.adid.AdId> r5) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r5 instanceof androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1
                if (r0 == 0) goto L13
                r0 = r5
                androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1 r0 = (androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1 r0 = new androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1
                r0.<init>(r4, r5)
            L18:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r0 = r0.L$0
                androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl r0 = (androidx.privacysandbox.ads.adservices.adid.AdIdManager.Api33Ext4Impl) r0
                v8.u.b(r5)
                goto L44
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L35:
                v8.u.b(r5)
                r0.L$0 = r4
                r0.label = r3
                java.lang.Object r5 = r4.getAdIdAsyncInternal(r0)
                if (r5 != r1) goto L43
                return r1
            L43:
                r0 = r4
            L44:
                android.adservices.adid.AdId r5 = (android.adservices.adid.AdId) r5
                androidx.privacysandbox.ads.adservices.adid.AdId r5 = r0.convertResponse(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adid.AdIdManager.Api33Ext4Impl.getAdId(z8.d):java.lang.Object");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Api33Ext4Impl(@NotNull Context context) {
            t.i(context, "context");
            Object systemService = context.getSystemService((Class<Object>) android.adservices.adid.AdIdManager.class);
            t.h(systemService, "context.getSystemService…:class.java\n            )");
            this((android.adservices.adid.AdIdManager) systemService);
        }
    }
}
