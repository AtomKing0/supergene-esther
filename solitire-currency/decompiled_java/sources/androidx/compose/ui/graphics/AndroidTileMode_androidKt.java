package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.TileMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidTileMode.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTileMode_androidKt {

    /* JADX INFO: compiled from: AndroidTileMode.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shader.TileMode.values().length];
            iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
            iArr[Shader.TileMode.MIRROR.ordinal()] = 2;
            iArr[Shader.TileMode.REPEAT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: isSupported-0vamqd0, reason: not valid java name */
    public static final boolean m1510isSupported0vamqd0(int i10) {
        return Build.VERSION.SDK_INT >= 31 || !TileMode.m1901equalsimpl0(i10, TileMode.Companion.m1906getDecal3opZhB0());
    }

    @NotNull
    /* JADX INFO: renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m1511toAndroidTileMode0vamqd0(int i10) {
        TileMode.Companion companion = TileMode.Companion;
        return TileMode.m1901equalsimpl0(i10, companion.m1905getClamp3opZhB0()) ? Shader.TileMode.CLAMP : TileMode.m1901equalsimpl0(i10, companion.m1908getRepeated3opZhB0()) ? Shader.TileMode.REPEAT : TileMode.m1901equalsimpl0(i10, companion.m1907getMirror3opZhB0()) ? Shader.TileMode.MIRROR : TileMode.m1901equalsimpl0(i10, companion.m1906getDecal3opZhB0()) ? Build.VERSION.SDK_INT >= 31 ? TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal() : Shader.TileMode.CLAMP : Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(@NotNull Shader.TileMode tileMode) {
        kotlin.jvm.internal.t.i(tileMode, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[tileMode.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? (Build.VERSION.SDK_INT < 31 || tileMode != Shader.TileMode.DECAL) ? TileMode.Companion.m1905getClamp3opZhB0() : TileModeVerificationHelper.INSTANCE.m1909getComposeTileModeDecal3opZhB0() : TileMode.Companion.m1908getRepeated3opZhB0() : TileMode.Companion.m1907getMirror3opZhB0() : TileMode.Companion.m1905getClamp3opZhB0();
    }
}
