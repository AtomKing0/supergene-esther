package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class qw extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3734b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qw(Class cls, Object obj) {
        super(0);
        this.f3733a = cls;
        this.f3734b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not publishing event class: " + this.f3733a.getName() + " and message: " + this.f3734b + " because events are not allowed to send yet. Adding to replay cache.";
    }
}
