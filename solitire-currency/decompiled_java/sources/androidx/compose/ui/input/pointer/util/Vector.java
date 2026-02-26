package androidx.compose.ui.input.pointer.util;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes.dex */
final class Vector {

    @NotNull
    private final Float[] elements;
    private final int length;

    public Vector(int i10) {
        this.length = i10;
        Float[] fArr = new Float[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            fArr[i11] = Float.valueOf(0.0f);
        }
        this.elements = fArr;
    }

    public final float get(int i10) {
        return this.elements[i10].floatValue();
    }

    @NotNull
    public final Float[] getElements() {
        return this.elements;
    }

    public final int getLength() {
        return this.length;
    }

    public final float norm() {
        return (float) Math.sqrt(times(this));
    }

    public final void set(int i10, float f10) {
        this.elements[i10] = Float.valueOf(f10);
    }

    public final float times(@NotNull Vector a10) {
        t.i(a10, "a");
        int i10 = this.length;
        float f10 = 0.0f;
        for (int i11 = 0; i11 < i10; i11++) {
            f10 += get(i11) * a10.get(i11);
        }
        return f10;
    }
}
