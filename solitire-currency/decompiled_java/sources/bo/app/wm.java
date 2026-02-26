package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wm extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4220a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wm(String str) {
        super(0);
        this.f4220a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Server card is marked as removed. Removing from card storage with id: " + this.f4220a;
    }
}
