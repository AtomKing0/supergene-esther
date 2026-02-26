package bo.app;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class nc0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f3480a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nc0(Set set) {
        super(0);
        this.f3480a = set;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Storage provider is closed. Not deleting events: " + this.f3480a;
    }
}
