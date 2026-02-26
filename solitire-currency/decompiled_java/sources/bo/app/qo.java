package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class qo extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zo f3721a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo(zo zoVar) {
        super(0);
        this.f3721a = zoVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Flush interval was too low (" + this.f3721a.f4462g + "), moving to minimum of 1000 ms";
    }
}
