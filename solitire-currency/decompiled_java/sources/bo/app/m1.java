package bo.app;

import android.app.Activity;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f3382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f3383b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(Activity activity, Braze braze) {
        super(0);
        this.f3382a = activity;
        this.f3383b = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        if (this.f3382a == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3383b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) l1.f3294a, 6, (Object) null);
        } else {
            tf tfVar = ((ci0) this.f3383b.getUdm$android_sdk_base_release()).f2570v;
            Activity activity = this.f3382a;
            tfVar.getClass();
            kotlin.jvm.internal.t.i(activity, "activity");
            if (tfVar.f3927i.f3236a.getBoolean("appboy_sdk_disabled", false)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) tfVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) le.f3329a, 6, (Object) null);
            } else if (tfVar.f3939u == null || kotlin.jvm.internal.t.d(activity.getClass(), tfVar.f3939u)) {
                tfVar.f3926h.a();
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) tfVar, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new me(activity), 6, (Object) null);
                ci ciVar = tfVar.f3921c;
                ReentrantLock reentrantLock = ciVar.f2544h;
                reentrantLock.lock();
                try {
                    ciVar.c();
                    w40 w40Var = ciVar.f2548l;
                    if (w40Var != null) {
                        w40Var.f4423c = Double.valueOf(DateTimeUtils.nowInSecondsPrecise());
                        ciVar.f2538b.a(w40Var);
                        b2.a.a(ciVar.f2547k, null, 1, null);
                        ciVar.f2547k = kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new ai(ciVar, null), 3, null);
                        ciVar.b();
                        ((vw) ciVar.f2539c).b(hc0.class, hc0.f2972a);
                        BrazeLogger.brazelog$default(brazeLogger, (Object) ciVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new bi(w40Var), 7, (Object) null);
                        v8.k0 k0Var = v8.k0.f35197a;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        return v8.k0.f35197a;
    }
}
