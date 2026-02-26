package bo.app;

import com.braze.support.BrazeLogger;
import java.io.BufferedReader;
import r9.r;

/* JADX INFO: loaded from: classes2.dex */
public final class qt extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BufferedReader f3728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r f3729d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qt(BufferedReader bufferedReader, r rVar, z8.d dVar) {
        super(2, dVar);
        this.f3728c = bufferedReader;
        this.f3729d = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        qt qtVar = new qt(this.f3728c, this.f3729d, dVar);
        qtVar.f3727b = obj;
        return qtVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((qt) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, kotlinx.coroutines.o0] */
    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = a9.d.e();
        ?? r22 = this.f3726a;
        try {
            if (r22 == 0) {
                v8.u.b(obj);
                kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.f3727b;
                String line = this.f3728c.readLine();
                if (line == null) {
                    return v8.k0.f35197a;
                }
                r rVar = this.f3729d;
                this.f3727b = o0Var;
                this.f3726a = 1;
                if (rVar.p(line, this) == objE) {
                    return objE;
                }
            } else {
                if (r22 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
        } catch (Exception e10) {
            if (kotlinx.coroutines.p0.h(r22)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, fu.f2842b, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) ot.f3580a, 8, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, fu.f2842b, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new pt(e10), 14, (Object) null);
            }
        }
        return v8.k0.f35197a;
    }
}
