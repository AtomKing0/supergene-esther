package l1;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: compiled from: BitmapImageViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l1.e
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void n(Bitmap bitmap) {
        ((ImageView) this.f30220a).setImageBitmap(bitmap);
    }
}
