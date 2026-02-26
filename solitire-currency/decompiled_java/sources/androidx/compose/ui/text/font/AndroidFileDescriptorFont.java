package androidx.compose.ui.text.font;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class AndroidFileDescriptorFont extends AndroidPreloadedFont {

    @Nullable
    private final String cacheKey;

    @NotNull
    private final ParcelFileDescriptor fileDescriptor;
    private final int style;

    @NotNull
    private final android.graphics.Typeface typefaceInternal;

    @NotNull
    private final FontWeight weight;

    public /* synthetic */ AndroidFileDescriptorFont(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i10, k kVar) {
        this(parcelFileDescriptor, fontWeight, i10);
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    @Nullable
    public String getCacheKey() {
        return this.cacheKey;
    }

    @NotNull
    public final ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int mo3361getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    @NotNull
    public android.graphics.Typeface getTypefaceInternal() {
        return this.typefaceInternal;
    }

    @Override // androidx.compose.ui.text.font.Font
    @NotNull
    public FontWeight getWeight() {
        return this.weight;
    }

    @NotNull
    public String toString() {
        return "Font(fileDescriptor=" + this.fileDescriptor + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m3415toStringimpl(mo3361getStyle_LCdwA())) + ')';
    }

    public /* synthetic */ AndroidFileDescriptorFont(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i10, int i11, k kVar) {
        this(parcelFileDescriptor, (i11 & 2) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i11 & 4) != 0 ? FontStyle.Companion.m3418getNormal_LCdwA() : i10, null);
    }

    private AndroidFileDescriptorFont(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i10) {
        this.fileDescriptor = parcelFileDescriptor;
        this.weight = fontWeight;
        this.style = i10;
        if (Build.VERSION.SDK_INT >= 26) {
            this.typefaceInternal = AndroidFileDescriptorHelper.INSTANCE.create(parcelFileDescriptor);
            return;
        }
        throw new IllegalArgumentException("Cannot create font from file descriptor for SDK < 26");
    }
}
