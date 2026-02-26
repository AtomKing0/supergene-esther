package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class sh0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3861b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sh0(String str, Object obj) {
        super(0);
        this.f3860a = str;
        this.f3861b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Could not write to custom attributes json object with key: [" + this.f3860a + "] value: [" + this.f3861b + ']';
    }
}
