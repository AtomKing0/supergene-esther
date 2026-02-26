package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.braze.coroutine.BrazeCoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public final class jo extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zo f3171a;

    public jo(zo zoVar) {
        this.f3171a = zoVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(intent, "intent");
        kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new io(this.f3171a, intent, goAsync(), null), 3, null);
    }
}
