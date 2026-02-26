package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class d00 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2613a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d00(String str) {
        super(0);
        this.f2613a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Could not parse http-date value: " + this.f2613a;
    }
}
