package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class zk extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4450b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zk(String str, Object obj) {
        super(0);
        this.f4449a = str;
        this.f4450b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Using runtime override value for key: '" + this.f4449a + "' and value: '" + this.f4450b + '\'';
    }
}
