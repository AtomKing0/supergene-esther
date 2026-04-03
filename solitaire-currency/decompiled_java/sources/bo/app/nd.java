package bo.app;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class nd extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f3481a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nd(ImageView imageView) {
        super(0);
        this.f3481a = imageView;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Bitmap dimensions cannot be 0. Not resizing ImageView " + this.f3481a;
    }
}
