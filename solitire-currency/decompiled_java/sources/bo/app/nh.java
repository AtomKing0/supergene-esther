package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class nh extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ci f3489a;

    public nh(ci ciVar) {
        this.f3489a = ciVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(intent, "intent");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) kh.f3251a, 6, (Object) null);
        kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new mh(this.f3489a, goAsync(), null), 3, null);
    }
}
