package bo.app;

import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class t30 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KProperty f3894b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t30(Object obj, KProperty kProperty) {
        super(0);
        this.f3893a = obj;
        this.f3894b = kProperty;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Cannot assign " + this.f3893a + " to only-set-once property " + this.f3894b.getName();
    }
}
