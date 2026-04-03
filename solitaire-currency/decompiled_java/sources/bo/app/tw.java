package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class tw extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vw f3974b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tw(Class cls, vw vwVar) {
        super(0);
        this.f3973a = cls;
        this.f3974b = vwVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Event was published, but no subscribers were found. But not saving event for publishing later. Event class: " + this.f3973a + ' ' + this.f3974b;
    }
}
