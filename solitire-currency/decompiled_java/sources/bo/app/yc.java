package bo.app;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class yc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f4350a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc(Uri uri) {
        super(0);
        this.f4350a = uri;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Local bitmap file does not exist. URI: " + this.f4350a;
    }
}
