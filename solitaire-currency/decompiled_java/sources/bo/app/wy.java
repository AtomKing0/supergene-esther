package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wy extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4232b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wy(String str, String str2) {
        super(0);
        this.f4231a = str;
        this.f4232b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("The received cards are for user ");
        sb.append(this.f4231a);
        sb.append(" and the current user is ");
        return d1.a(sb, this.f4232b, ", the cards will be discarded and no changes will be made.");
    }
}
