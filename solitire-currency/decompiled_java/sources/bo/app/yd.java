package bo.app;

import com.braze.models.IBrazeLocation;

/* JADX INFO: loaded from: classes2.dex */
public final class yd extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zd f4353a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yd(zd zdVar) {
        super(1);
        this.f4353a = zdVar;
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        IBrazeLocation it = (IBrazeLocation) obj;
        kotlin.jvm.internal.t.i(it, "it");
        this.f4353a.a(it);
        return v8.k0.f35197a;
    }
}
