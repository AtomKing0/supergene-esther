package bo.app;

import androidx.autofill.HintConstants;
import com.braze.BrazeUser;
import com.braze.enums.Gender;

/* JADX INFO: loaded from: classes2.dex */
public final class uj extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeUser f4027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Gender f4028b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uj(BrazeUser brazeUser, Gender gender, z8.d dVar) {
        super(2, dVar);
        this.f4027a = brazeUser;
        this.f4028b = gender;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new uj(this.f4027a, this.f4028b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new uj(this.f4027a, this.f4028b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        uh0 uh0Var = this.f4027a.userCache;
        Gender gender = this.f4028b;
        synchronized (uh0Var) {
            uh0Var.b(HintConstants.AUTOFILL_HINT_GENDER, gender != null ? gender.forJsonPut() : null);
        }
        return v8.k0.f35197a;
    }
}
