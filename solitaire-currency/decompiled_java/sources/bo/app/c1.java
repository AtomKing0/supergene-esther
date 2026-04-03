package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2480a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(String str) {
        super(0);
        this.f2480a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Rejected user id with byte length longer than 997. Not changing user. Input user id: " + this.f2480a;
    }
}
