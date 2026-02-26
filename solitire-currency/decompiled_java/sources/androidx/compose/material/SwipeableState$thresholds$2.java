package androidx.compose.material;

import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
final class SwipeableState$thresholds$2 extends v implements p<Float, Float, Float> {
    public static final SwipeableState$thresholds$2 INSTANCE = new SwipeableState$thresholds$2();

    SwipeableState$thresholds$2() {
        super(2);
    }

    @NotNull
    public final Float invoke(float f10, float f11) {
        return Float.valueOf(0.0f);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Float mo4invoke(Float f10, Float f11) {
        return invoke(f10.floatValue(), f11.floatValue());
    }
}
