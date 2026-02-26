package bo.app;

import android.graphics.BitmapFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class tc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitmapFactory.Options f3910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3912c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tc(BitmapFactory.Options options, int i10, int i11) {
        super(0);
        this.f3910a = options;
        this.f3911b = i10;
        this.f3912c = i11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Calculating sample size for source image bounds: (width " + this.f3910a.outWidth + " height " + this.f3910a.outHeight + ") and destination image bounds: (width " + this.f3911b + " height " + this.f3912c + ')';
    }
}
