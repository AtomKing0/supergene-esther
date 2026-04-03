package androidx.privacysandbox.ads.adservices.java.adselection;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.m;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AdSelectionManagerFutures.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AdSelectionManagerFutures {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AdSelectionManagerFutures.kt */
    static final class Api33Ext4JavaImpl extends AdSelectionManagerFutures {

        @Nullable
        private final AdSelectionManager mAdSelectionManager;

        public Api33Ext4JavaImpl(@Nullable AdSelectionManager adSelectionManager) {
            this.mAdSelectionManager = adSelectionManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        @NotNull
        public m<k0> reportImpressionAsync(@NotNull ReportImpressionRequest reportImpressionRequest) {
            t.i(reportImpressionRequest, "reportImpressionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this, reportImpressionRequest, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        @NotNull
        public m<AdSelectionOutcome> selectAdsAsync(@NotNull AdSelectionConfig adSelectionConfig) {
            t.i(adSelectionConfig, "adSelectionConfig");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$1(this, adSelectionConfig, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: AdSelectionManagerFutures.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final AdSelectionManagerFutures from(@NotNull Context context) {
            t.i(context, "context");
            AdSelectionManager adSelectionManagerObtain = AdSelectionManager.Companion.obtain(context);
            if (adSelectionManagerObtain != null) {
                return new Api33Ext4JavaImpl(adSelectionManagerObtain);
            }
            return null;
        }
    }

    @Nullable
    public static final AdSelectionManagerFutures from(@NotNull Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @NotNull
    public abstract m<k0> reportImpressionAsync(@NotNull ReportImpressionRequest reportImpressionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @NotNull
    public abstract m<AdSelectionOutcome> selectAdsAsync(@NotNull AdSelectionConfig adSelectionConfig);
}
