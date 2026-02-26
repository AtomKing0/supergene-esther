package bo.app;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import bo.app.cq;
import com.braze.enums.BrazeViewBounds;
import com.braze.support.BrazeImageUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class cq implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeViewBounds f2591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f2592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f2593c;

    public cq(BrazeViewBounds brazeViewBounds, ImageView imageView, Bitmap bitmap) {
        this.f2591a = brazeViewBounds;
        this.f2592b = imageView;
        this.f2593c = bitmap;
    }

    public static final void a(Bitmap bitmap, ImageView imageView) {
        kotlin.jvm.internal.t.i(imageView, "$imageView");
        BrazeImageUtils.resizeImageViewToBitmapDimensions(bitmap, imageView);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View v10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        kotlin.jvm.internal.t.i(v10, "v");
        if (this.f2591a == BrazeViewBounds.BASE_CARD_VIEW) {
            final ImageView imageView = this.f2592b;
            final Bitmap bitmap = this.f2593c;
            imageView.post(new Runnable() { // from class: i.d
                @Override // java.lang.Runnable
                public final void run() {
                    cq.a(bitmap, imageView);
                }
            });
        }
        v10.removeOnLayoutChangeListener(this);
    }
}
