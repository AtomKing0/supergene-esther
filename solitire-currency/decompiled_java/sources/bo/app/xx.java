package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class xx extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4306a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx(String str) {
        super(0);
        this.f4306a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Encountered unexpected exception while parsing stored feature flags: " + this.f4306a;
    }
}
