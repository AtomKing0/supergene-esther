package bo.app;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class bq extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f2468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f2469b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(ImageView imageView, Bitmap bitmap, z8.d dVar) {
        super(2, dVar);
        this.f2468a = imageView;
        this.f2469b = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new bq(this.f2468a, this.f2469b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new bq(this.f2468a, this.f2469b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        this.f2468a.setImageBitmap(this.f2469b);
        return v8.k0.f35197a;
    }
}
