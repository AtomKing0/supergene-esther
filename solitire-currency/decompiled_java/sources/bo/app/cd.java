package bo.app;

import android.graphics.BitmapFactory;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class cd extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f2503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitmapFactory.Options f2504b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(Uri uri, BitmapFactory.Options options) {
        super(0);
        this.f2503a = uri;
        this.f2504b = options;
    }

    @Override // h9.a
    public final Object invoke() {
        return "The bitmap metadata with image uri " + this.f2503a + " had bounds: (height " + this.f2504b.outHeight + " width " + this.f2504b.outWidth + "). Returning a bitmap with no sampling.";
    }
}
