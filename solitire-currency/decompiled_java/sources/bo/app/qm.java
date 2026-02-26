package bo.app;

import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class qm extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kn f3718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f3719c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qm(kn knVar, List list, z8.d dVar) {
        super(2, dVar);
        this.f3718b = knVar;
        this.f3719c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        qm qmVar = new qm(this.f3718b, this.f3719c, dVar);
        qmVar.f3717a = obj;
        return qmVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((qm) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.f3717a;
        SharedPreferences.Editor editorEdit = this.f3718b.f3272i.edit();
        for (String str : this.f3719c) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) o0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new pm(str), 7, (Object) null);
            editorEdit.remove(str);
        }
        editorEdit.apply();
        return v8.k0.f35197a;
    }
}
