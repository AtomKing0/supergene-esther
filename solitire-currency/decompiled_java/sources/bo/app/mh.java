package bo.app;

import android.content.BroadcastReceiver;
import com.braze.support.BrazeLogger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class mh extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ci f3425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver.PendingResult f3426c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mh(ci ciVar, BroadcastReceiver.PendingResult pendingResult, z8.d dVar) {
        super(2, dVar);
        this.f3425b = ciVar;
        this.f3426c = pendingResult;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        mh mhVar = new mh(this.f3425b, this.f3426c, dVar);
        mhVar.f3424a = obj;
        return mhVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((mh) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.f3424a;
        ci ciVar = this.f3425b;
        ReentrantLock reentrantLock = ciVar.f2544h;
        reentrantLock.lock();
        try {
            try {
                ciVar.f();
            } catch (Exception e10) {
                try {
                    ((vw) ciVar.f2539c).b(Throwable.class, e10);
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) lh.f3335a, 4, (Object) null);
                }
            }
            v8.k0 k0Var = v8.k0.f35197a;
            reentrantLock.unlock();
            this.f3426c.finish();
            return k0Var;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
