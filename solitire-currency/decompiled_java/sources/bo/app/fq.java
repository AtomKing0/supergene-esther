package bo.app;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class fq extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f2839a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fq(Uri uri) {
        super(0);
        this.f2839a = uri;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Image url specifies that it should not be cached. Not caching " + this.f2839a;
    }
}
