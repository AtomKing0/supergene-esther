package androidx.privacysandbox.ads.adservices.java.appsetid;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetId;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.m;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AppSetIdManagerFutures.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AppSetIdManagerFutures {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AppSetIdManagerFutures.kt */
    static final class Api33Ext4JavaImpl extends AppSetIdManagerFutures {

        @NotNull
        private final AppSetIdManager mAppSetIdManager;

        public Api33Ext4JavaImpl(@NotNull AppSetIdManager mAppSetIdManager) {
            t.i(mAppSetIdManager, "mAppSetIdManager");
            this.mAppSetIdManager = mAppSetIdManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures
        @DoNotInline
        @NotNull
        public m<AppSetId> getAppSetIdAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: AppSetIdManagerFutures.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final AppSetIdManagerFutures from(@NotNull Context context) {
            t.i(context, "context");
            AppSetIdManager appSetIdManagerObtain = AppSetIdManager.Companion.obtain(context);
            if (appSetIdManagerObtain != null) {
                return new Api33Ext4JavaImpl(appSetIdManagerObtain);
            }
            return null;
        }
    }

    @Nullable
    public static final AppSetIdManagerFutures from(@NotNull Context context) {
        return Companion.from(context);
    }

    @NotNull
    public abstract m<AppSetId> getAppSetIdAsync();
}
