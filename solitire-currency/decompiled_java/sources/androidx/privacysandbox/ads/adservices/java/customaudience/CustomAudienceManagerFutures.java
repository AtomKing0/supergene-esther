package androidx.privacysandbox.ads.adservices.java.customaudience;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.m;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: CustomAudienceManagerFutures.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CustomAudienceManagerFutures {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CustomAudienceManagerFutures.kt */
    static final class Api33Ext4JavaImpl extends CustomAudienceManagerFutures {

        @Nullable
        private final CustomAudienceManager mCustomAudienceManager;

        public Api33Ext4JavaImpl(@Nullable CustomAudienceManager customAudienceManager) {
            this.mCustomAudienceManager = customAudienceManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        @NotNull
        public m<k0> joinCustomAudienceAsync(@NotNull JoinCustomAudienceRequest request) {
            t.i(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(this, request, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        @NotNull
        public m<k0> leaveCustomAudienceAsync(@NotNull LeaveCustomAudienceRequest request) {
            t.i(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this, request, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: CustomAudienceManagerFutures.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final CustomAudienceManagerFutures from(@NotNull Context context) {
            t.i(context, "context");
            CustomAudienceManager customAudienceManagerObtain = CustomAudienceManager.Companion.obtain(context);
            if (customAudienceManagerObtain != null) {
                return new Api33Ext4JavaImpl(customAudienceManagerObtain);
            }
            return null;
        }
    }

    @Nullable
    public static final CustomAudienceManagerFutures from(@NotNull Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @NotNull
    public abstract m<k0> joinCustomAudienceAsync(@NotNull JoinCustomAudienceRequest joinCustomAudienceRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @NotNull
    public abstract m<k0> leaveCustomAudienceAsync(@NotNull LeaveCustomAudienceRequest leaveCustomAudienceRequest);
}
