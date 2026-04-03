package bo.app;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class xc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f4261a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xc(Uri uri) {
        super(0);
        this.f4261a = uri;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Local bitmap path is null. URI: " + this.f4261a;
    }
}
