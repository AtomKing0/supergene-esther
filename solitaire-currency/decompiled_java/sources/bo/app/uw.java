package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class uw extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f4054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vw f4055b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uw(Class cls, vw vwVar) {
        super(0);
        this.f4054a = cls;
        this.f4055b = vwVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Event was published, but no subscribers were found. Saving event for later publishing to a matching subscriber. Event class: " + this.f4054a + " this " + this.f4055b;
    }
}
