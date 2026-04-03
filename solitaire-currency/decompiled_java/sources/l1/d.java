package l1;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DrawableImageViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l1.e
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void n(@Nullable Drawable drawable) {
        ((ImageView) this.f30220a).setImageDrawable(drawable);
    }
}
