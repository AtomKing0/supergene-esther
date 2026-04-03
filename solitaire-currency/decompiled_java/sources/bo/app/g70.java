package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class g70 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2877b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g70(int i10, int i11) {
        super(0);
        this.f2876a = i10;
        this.f2877b = i11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Stored push registration ID version code " + this.f2876a + " does not match live version code " + this.f2877b + ". Not returning saved registration ID.";
    }
}
