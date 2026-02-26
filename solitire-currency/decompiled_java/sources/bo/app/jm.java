package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class jm extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3167a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jm(String str) {
        super(0);
        this.f3167a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Card not present in storage for id: " + this.f3167a;
    }
}
