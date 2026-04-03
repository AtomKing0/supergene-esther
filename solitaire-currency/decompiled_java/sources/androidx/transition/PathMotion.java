package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    @NonNull
    public abstract Path getPath(float f10, float f11, float f12, float f13);

    public PathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
    }
}
