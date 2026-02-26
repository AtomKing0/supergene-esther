package bo.app;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class om extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f3572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f3573b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public om(LinkedHashSet linkedHashSet, Set set) {
        super(0);
        this.f3572a = linkedHashSet;
        this.f3573b = set;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Retaining card ids: " + this.f3572a + " among cached card ids: " + this.f3573b;
    }
}
