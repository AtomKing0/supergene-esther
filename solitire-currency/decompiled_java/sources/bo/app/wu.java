package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wu extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4226a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wu(String str) {
        super(0);
        this.f4226a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to create valid enum from string: " + this.f4226a;
    }
}
