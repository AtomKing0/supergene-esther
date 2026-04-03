package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ka extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3235b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ka(String str, int i10) {
        super(0);
        this.f3234a = i10;
        this.f3235b = str;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("HTTP response code was ");
        sb.append(this.f3234a);
        sb.append(". File with url ");
        return d1.a(sb, this.f3235b, " could not be downloaded.");
    }
}
