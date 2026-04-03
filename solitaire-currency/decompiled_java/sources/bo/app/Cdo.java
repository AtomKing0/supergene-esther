package bo.app;

/* JADX INFO: renamed from: bo.app.do, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class Cdo extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cp f2668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z80 f2669b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cdo(cp cpVar, z80 z80Var) {
        super(0);
        this.f2668a = cpVar;
        this.f2669b = z80Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Could not merge other request: " + this.f2668a + " into parent: " + this.f2669b;
    }
}
