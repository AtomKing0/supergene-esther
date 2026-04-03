package bo.app;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class je0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f3153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3154b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je0(String str, Uri uri) {
        super(0);
        this.f3153a = uri;
        this.f3154b = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Storing local triggered action asset at local path " + this.f3153a.getPath() + " for remote path " + this.f3154b;
    }
}
