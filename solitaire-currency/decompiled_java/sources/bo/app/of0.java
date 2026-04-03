package bo.app;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class of0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f3562a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public of0(List list) {
        super(0);
        this.f3562a = list;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Registering " + this.f3562a.size() + " new triggered actions.";
    }
}
