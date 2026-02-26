package bo.app;

import com.braze.images.DefaultBrazeImageLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class jp extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultBrazeImageLoader f3173b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp(String str, DefaultBrazeImageLoader defaultBrazeImageLoader) {
        super(0);
        this.f3172a = str;
        this.f3173b = defaultBrazeImageLoader;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Got bitmap from mem cache for key " + this.f3172a + "\nMemory cache stats: " + this.f3173b.getMemoryCache();
    }
}
