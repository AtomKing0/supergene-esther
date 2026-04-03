package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class w10 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h00 f4162c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w10(String str, h00 h00Var, z8.d dVar) {
        super(2, dVar);
        this.f4161b = str;
        this.f4162c = h00Var;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        w10 w10Var = new w10(this.f4161b, this.f4162c, dVar);
        w10Var.f4160a = obj;
        return w10Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((w10) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this.f4160a, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) v10.f4066a, 6, (Object) null);
        z9 z9Var = ba.f2429g;
        String triggerId = this.f4161b;
        z9Var.getClass();
        kotlin.jvm.internal.t.i(triggerId, "triggerId");
        e00 e00VarA = z9Var.a(new g9(triggerId));
        if (e00VarA != null) {
            ((tf) this.f4162c).a(e00VarA);
        }
        return v8.k0.f35197a;
    }
}
