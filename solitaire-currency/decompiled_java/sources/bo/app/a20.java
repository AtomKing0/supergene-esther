package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;

/* JADX INFO: loaded from: classes2.dex */
public final class a20 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InAppMessageBase f2345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h00 f2346c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a20(String str, InAppMessageBase inAppMessageBase, h00 h00Var, z8.d dVar) {
        super(2, dVar);
        this.f2344a = str;
        this.f2345b = inAppMessageBase;
        this.f2346c = h00Var;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new a20(this.f2344a, this.f2345b, this.f2346c, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((a20) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        z9 z9Var = ba.f2429g;
        String triggerId = this.f2344a;
        String messageExtras = this.f2345b.getMessageExtras();
        z9Var.getClass();
        kotlin.jvm.internal.t.i(triggerId, "triggerId");
        e00 e00VarA = z9Var.a(new i9(triggerId, messageExtras));
        if (e00VarA != null) {
            ((tf) this.f2346c).a(e00VarA);
        }
        return v8.k0.f35197a;
    }
}
