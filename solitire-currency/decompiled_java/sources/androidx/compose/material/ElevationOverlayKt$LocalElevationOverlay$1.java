package androidx.compose.material;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ElevationOverlay.kt */
/* JADX INFO: loaded from: classes.dex */
final class ElevationOverlayKt$LocalElevationOverlay$1 extends v implements a<ElevationOverlay> {
    public static final ElevationOverlayKt$LocalElevationOverlay$1 INSTANCE = new ElevationOverlayKt$LocalElevationOverlay$1();

    ElevationOverlayKt$LocalElevationOverlay$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @Nullable
    public final ElevationOverlay invoke() {
        return DefaultElevationOverlay.INSTANCE;
    }
}
