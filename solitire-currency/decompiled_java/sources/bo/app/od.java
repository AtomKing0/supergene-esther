package bo.app;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class od extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f3557a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public od(ImageView imageView) {
        super(0);
        this.f3557a = imageView;
    }

    @Override // h9.a
    public final Object invoke() {
        return "ImageView dimensions cannot be 0. Not resizing ImageView " + this.f3557a;
    }
}
