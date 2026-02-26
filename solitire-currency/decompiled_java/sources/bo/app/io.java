package bo.app;

import android.content.BroadcastReceiver;
import android.content.Intent;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class io extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zo f3075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Intent f3076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver.PendingResult f3077d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public io(zo zoVar, Intent intent, BroadcastReceiver.PendingResult pendingResult, z8.d dVar) {
        super(2, dVar);
        this.f3075b = zoVar;
        this.f3076c = intent;
        this.f3077d = pendingResult;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        io ioVar = new io(this.f3075b, this.f3076c, this.f3077d, dVar);
        ioVar.f3074a = obj;
        return ioVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((io) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.f3074a;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) go.f2920a, 6, (Object) null);
        try {
            zo zoVar = this.f3075b;
            z40 z40Var = zoVar.f4465j;
            zoVar.f4465j = com.braze.support.c.a(this.f3076c, zoVar.f4464i);
            zo zoVar2 = this.f3075b;
            z40 z40Var2 = zoVar2.f4465j;
            if (z40Var != z40Var2) {
                ((vw) zoVar2.f4457b).b(a50.class, new a50(z40Var, z40Var2));
            }
            this.f3075b.a();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) ho.f2991a, 4, (Object) null);
            zo zoVar3 = this.f3075b;
            try {
                ((vw) zoVar3.f4457b).b(Throwable.class, e10);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) zoVar3, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) oo.f3575a, 4, (Object) null);
            }
        }
        this.f3077d.finish();
        return v8.k0.f35197a;
    }
}
