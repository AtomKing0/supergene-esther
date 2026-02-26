package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ry extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3811a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ry(String str) {
        super(0);
        this.f3811a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Cannot create card control event for Feed card. Returning null. Card id: " + this.f3811a;
    }
}
