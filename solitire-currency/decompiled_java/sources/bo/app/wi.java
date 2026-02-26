package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wi extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4212b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wi(String str, Object obj) {
        super(0);
        this.f4211a = str;
        this.f4212b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Could not build NestedCustomAttributeEvent for key " + this.f4211a + " and " + this.f4212b;
    }
}
