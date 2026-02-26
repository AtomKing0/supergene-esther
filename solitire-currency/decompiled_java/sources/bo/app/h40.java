package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class h40 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2949a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h40(String str) {
        super(0);
        this.f2949a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Caught exception merging JSON for new key " + this.f2949a;
    }
}
