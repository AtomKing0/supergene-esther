package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class an extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2395a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(String str) {
        super(0);
        this.f2395a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Can't update card field. Json cannot be parsed from disk or is not present. Id: " + this.f2395a;
    }
}
