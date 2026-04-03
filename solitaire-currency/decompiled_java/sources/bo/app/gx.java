package bo.app;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class gx extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f2928a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx(Set set) {
        super(0);
        this.f2928a = set;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Storage manager is closed. Not deleting events: " + this.f2928a;
    }
}
