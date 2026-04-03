package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class vg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4116a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vg0(String str) {
        super(0);
        this.f4116a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Retaining triggered action "), this.f4116a, " in re-eligibility list.");
    }
}
