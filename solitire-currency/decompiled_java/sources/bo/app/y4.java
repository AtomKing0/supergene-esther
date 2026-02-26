package bo.app;

import com.braze.events.IEventSubscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class y4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f4320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IEventSubscriber f4321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4322c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(Class cls, IEventSubscriber iEventSubscriber, boolean z10) {
        super(0);
        this.f4320a = cls;
        this.f4321b = iEventSubscriber;
        this.f4322c = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Did remove the background " + this.f4320a + ' ' + this.f4321b + "? " + this.f4322c;
    }
}
