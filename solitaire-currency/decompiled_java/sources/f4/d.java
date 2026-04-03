package f4;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ChildrenAlphaProperty.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends Property<ViewGroup, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property<ViewGroup, Float> f25674a = new d("childrenAlpha");

    private d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f10 = (Float) viewGroup.getTag(e4.f.E);
        return f10 != null ? f10 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f10) {
        float fFloatValue = f10.floatValue();
        viewGroup.setTag(e4.f.E, Float.valueOf(fFloatValue));
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            viewGroup.getChildAt(i10).setAlpha(fFloatValue);
        }
    }
}
