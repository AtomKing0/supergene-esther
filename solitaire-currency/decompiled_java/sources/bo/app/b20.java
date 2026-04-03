package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;

/* JADX INFO: loaded from: classes2.dex */
public final class b20 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InAppMessageBase f2412a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b20(InAppMessageBase inAppMessageBase, z8.d dVar) {
        super(2, dVar);
        this.f2412a = inAppMessageBase;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new b20(this.f2412a, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new b20(this.f2412a, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        h00 brazeManager;
        a9.d.e();
        v8.u.b(obj);
        if (this.f2412a.clickLogged.get() && (brazeManager = this.f2412a.getBrazeManager()) != null) {
            e20 triggerEvent = new e20(this.f2412a.getTriggerId());
            kotlin.jvm.internal.t.i(triggerEvent, "triggerEvent");
            ((vw) ((tf) brazeManager).f3922d).b(xe0.class, new xe0(triggerEvent));
        }
        return v8.k0.f35197a;
    }
}
