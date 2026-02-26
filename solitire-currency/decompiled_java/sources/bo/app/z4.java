package bo.app;

import com.braze.events.IEventSubscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class z4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f4393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IEventSubscriber f4394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4395c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(Class cls, IEventSubscriber iEventSubscriber, boolean z10) {
        super(0);
        this.f4393a = cls;
        this.f4394b = iEventSubscriber;
        this.f4395c = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Did remove the synchronous " + this.f4393a + ' ' + this.f4394b + "? " + this.f4395c;
    }
}
