package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4314b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(String str, String str2) {
        super(0);
        this.f4313a = str;
        this.f4314b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Error while producing output stream or compressing bitmap for key " + this.f4313a + " diskKey " + this.f4314b;
    }
}
