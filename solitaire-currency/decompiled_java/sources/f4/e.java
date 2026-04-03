package f4;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: DrawableAlphaProperty.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property<Drawable, Integer> f25675b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f25676a;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f25676a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(@NonNull Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
