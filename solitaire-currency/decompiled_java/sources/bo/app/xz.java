package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class xz extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4312a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz(int i10) {
        super(0);
        this.f4312a = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Google Play Services is unavailable. Connection result: " + this.f4312a;
    }
}
