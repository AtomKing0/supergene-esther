package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.ExperimentalTextApi;
import java.io.File;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontKt {
    @Stable
    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: Font-RetOiIg, reason: not valid java name */
    public static final Font m3364FontRetOiIg(@NotNull File file, @NotNull FontWeight weight, int i10) {
        t.i(file, "file");
        t.i(weight, "weight");
        return new AndroidFileFont(file, weight, i10, null);
    }

    /* JADX INFO: renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m3366FontRetOiIg$default(File file, FontWeight fontWeight, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i11 & 4) != 0) {
            i10 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        return m3364FontRetOiIg(file, fontWeight, i10);
    }

    @Stable
    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: Font-wCLgNak, reason: not valid java name */
    public static final Font m3367FontwCLgNak(@NotNull AssetManager assetManager, @NotNull String path, @NotNull FontWeight weight, int i10) {
        t.i(assetManager, "assetManager");
        t.i(path, "path");
        t.i(weight, "weight");
        return new AndroidAssetFont(assetManager, path, weight, i10, null);
    }

    /* JADX INFO: renamed from: Font-wCLgNak$default, reason: not valid java name */
    public static /* synthetic */ Font m3369FontwCLgNak$default(AssetManager assetManager, String str, FontWeight fontWeight, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i11 & 8) != 0) {
            i10 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        return m3367FontwCLgNak(assetManager, str, fontWeight, i10);
    }

    @ExperimentalTextApi
    @NotNull
    @Stable
    @RequiresApi(26)
    /* JADX INFO: renamed from: Font-RetOiIg, reason: not valid java name */
    public static final Font m3363FontRetOiIg(@NotNull ParcelFileDescriptor fileDescriptor, @NotNull FontWeight weight, int i10) {
        t.i(fileDescriptor, "fileDescriptor");
        t.i(weight, "weight");
        return new AndroidFileDescriptorFont(fileDescriptor, weight, i10, null);
    }

    @Stable
    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: Font-wCLgNak, reason: not valid java name */
    public static final Font m3368FontwCLgNak(@NotNull String path, @NotNull AssetManager assetManager, @NotNull FontWeight weight, int i10) {
        t.i(path, "path");
        t.i(assetManager, "assetManager");
        t.i(weight, "weight");
        return new AndroidAssetFont(assetManager, path, weight, i10, null);
    }

    /* JADX INFO: renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m3365FontRetOiIg$default(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i11 & 4) != 0) {
            i10 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        return m3363FontRetOiIg(parcelFileDescriptor, fontWeight, i10);
    }

    /* JADX INFO: renamed from: Font-wCLgNak$default, reason: not valid java name */
    public static /* synthetic */ Font m3370FontwCLgNak$default(String str, AssetManager assetManager, FontWeight fontWeight, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i11 & 8) != 0) {
            i10 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        return m3368FontwCLgNak(str, assetManager, fontWeight, i10);
    }
}
