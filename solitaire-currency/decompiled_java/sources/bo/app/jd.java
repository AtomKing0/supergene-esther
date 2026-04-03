package bo.app;

import android.graphics.BitmapFactory;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public final class jd extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ URL f3149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitmapFactory.Options f3150b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd(URL url, BitmapFactory.Options options) {
        super(0);
        this.f3149a = url;
        this.f3150b = options;
    }

    @Override // h9.a
    public final Object invoke() {
        return "The bitmap metadata with image url " + this.f3149a + " had bounds: (height " + this.f3150b.outHeight + " width " + this.f3150b.outWidth + "). Returning a bitmap with no sampling.";
    }
}
