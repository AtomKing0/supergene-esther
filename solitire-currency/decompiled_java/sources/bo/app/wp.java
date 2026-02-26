package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wp extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4223a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wp(String str) {
        super(0);
        this.f4223a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Skipping disk cache for key: " + this.f4223a;
    }
}
