package bo.app;

import com.braze.BrazeUser;
import com.braze.support.ValidationUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class qk extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f3714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3715b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qk(BrazeUser brazeUser, String str, z8.d dVar) {
        super(2, dVar);
        this.f3714a = brazeUser;
        this.f3715b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new qk(this.f3714a, this.f3715b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new qk(this.f3714a, this.f3715b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f3714a.userCache;
        String key = this.f3715b;
        synchronized (uh0Var) {
            kotlin.jvm.internal.t.i(key, "key");
            uh0Var.a(ValidationUtils.ensureBrazeFieldLength(key), JSONObject.NULL);
        }
        return v8.k0.f35197a;
    }
}
