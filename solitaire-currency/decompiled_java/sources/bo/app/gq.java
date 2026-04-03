package bo.app;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class gq extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f2921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f2922b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq(Map.Entry entry, Uri uri) {
        super(0);
        this.f2921a = entry;
        this.f2922b = uri;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Headers specify that this image should not be cached (" + this.f2921a + "). Not caching " + this.f2922b;
    }
}
