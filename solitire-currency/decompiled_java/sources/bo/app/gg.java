package bo.app;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class gg extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f2910a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg(List list) {
        super(0);
        this.f2910a = list;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Removing non-string keys from map. Removed keys: " + this.f2910a;
    }
}
