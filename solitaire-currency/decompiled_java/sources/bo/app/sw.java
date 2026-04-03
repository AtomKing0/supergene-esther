package bo.app;

import com.braze.events.IEventSubscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class sw extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IEventSubscriber f3879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3880b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sw(IEventSubscriber iEventSubscriber, Object obj, z8.d dVar) {
        super(2, dVar);
        this.f3879a = iEventSubscriber;
        this.f3880b = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new sw(this.f3879a, this.f3880b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new sw(this.f3879a, this.f3880b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        this.f3879a.trigger(this.f3880b);
        return v8.k0.f35197a;
    }
}
