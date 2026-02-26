package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ki extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3254b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ki(String str, int i10) {
        super(0);
        this.f3253a = str;
        this.f3254b = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to increment custom attribute " + this.f3253a + " by " + this.f3254b + '.';
    }
}
