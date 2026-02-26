package bo.app;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class pd extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f3621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f3622b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pd(float f10, ImageView imageView) {
        super(0);
        this.f3621a = f10;
        this.f3622b = imageView;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Resizing ImageView to aspect ratio " + this.f3621a + " based on width: " + this.f3622b.getWidth() + " trueWidth: " + this.f3622b.getLayoutParams().width + " height: " + this.f3622b.getLayoutParams().height + " layoutParams: " + this.f3622b.getLayoutParams() + ' ' + this.f3622b;
    }
}
