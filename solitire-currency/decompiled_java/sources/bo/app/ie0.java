package bo.app;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ie0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f3050b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ie0(String str, Map map) {
        super(0);
        this.f3049a = str;
        this.f3050b = map;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not caching " + this.f3049a + " due to headers " + this.f3050b;
    }
}
