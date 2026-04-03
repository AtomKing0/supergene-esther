package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ug0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4018a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ug0(String str) {
        super(0);
        this.f4018a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Deleting outdated triggered action id "), this.f4018a, " from stored re-eligibility list. In-memory re-eligibility list is unchanged.");
    }
}
