package bo.app;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class jw extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f3182b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw(Class cls, HashSet hashSet) {
        super(0);
        this.f3181a = cls;
        this.f3182b = hashSet;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Triggering " + this.f3181a.getName() + " on " + this.f3182b.size() + " subscribers.";
    }
}
