package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wi0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4213a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wi0(String str) {
        super(0);
        this.f4213a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Cannot find local asset file at path: " + this.f4213a;
    }
}
