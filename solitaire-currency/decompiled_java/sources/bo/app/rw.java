package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class rw extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3809b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rw(Class cls, Object obj) {
        super(0);
        this.f3808a = cls;
        this.f3809b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return this.f3808a.getName() + " fired:\n" + this.f3809b;
    }
}
