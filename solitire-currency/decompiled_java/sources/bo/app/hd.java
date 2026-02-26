package bo.app;

import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public final class hd extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ URL f2974b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd(int i10, URL url) {
        super(0);
        this.f2973a = i10;
        this.f2974b = url;
    }

    @Override // h9.a
    public final Object invoke() {
        return "HTTP response code was " + this.f2973a + ". Bitmap with url " + this.f2974b + " could not be downloaded.";
    }
}
