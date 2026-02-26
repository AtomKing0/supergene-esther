package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import com.google.common.util.concurrent.m;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TopicsManagerFutures.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TopicsManagerFutures {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TopicsManagerFutures.kt */
    static final class Api33Ext4JavaImpl extends TopicsManagerFutures {

        @NotNull
        private final TopicsManager mTopicsManager;

        public Api33Ext4JavaImpl(@NotNull TopicsManager mTopicsManager) {
            t.i(mTopicsManager, "mTopicsManager");
            this.mTopicsManager = mTopicsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
        @DoNotInline
        @NotNull
        public m<GetTopicsResponse> getTopicsAsync(@NotNull GetTopicsRequest request) {
            t.i(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.c()), null, null, new TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1(this, request, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: TopicsManagerFutures.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final TopicsManagerFutures from(@NotNull Context context) {
            t.i(context, "context");
            TopicsManager topicsManagerObtain = TopicsManager.Companion.obtain(context);
            if (topicsManagerObtain != null) {
                return new Api33Ext4JavaImpl(topicsManagerObtain);
            }
            return null;
        }
    }

    @Nullable
    public static final TopicsManagerFutures from(@NotNull Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    @NotNull
    public abstract m<GetTopicsResponse> getTopicsAsync(@NotNull GetTopicsRequest getTopicsRequest);
}
