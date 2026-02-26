package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class pn extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3638a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pn(Object obj) {
        super(0);
        this.f3638a = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "JSON Array size (" + this.f3638a.toString().length() + " bytes) exceeds 76800";
    }
}
