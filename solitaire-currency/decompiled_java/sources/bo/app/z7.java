package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class z7 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4405a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z7(String str) {
        super(0);
        this.f4405a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Couldn't find application icon for package: " + this.f4405a;
    }
}
