package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class km extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3262a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public km(String str) {
        super(0);
        this.f3262a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to read card json from storage. Json: " + this.f3262a;
    }
}
