package bo.app;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class vc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f4108a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc(Uri uri) {
        super(0);
        this.f4108a = uri;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Uri with unknown scheme received. Not getting image. Uri: " + this.f4108a;
    }
}
