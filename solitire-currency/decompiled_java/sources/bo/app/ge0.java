package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ge0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2907a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge0(String str) {
        super(0);
        this.f2907a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Failed to store html zip asset for remote path "), this.f2907a, ". Not storing local asset");
    }
}
