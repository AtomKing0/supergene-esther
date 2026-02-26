package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class AndroidFileDescriptorHelper {

    @NotNull
    public static final AndroidFileDescriptorHelper INSTANCE = new AndroidFileDescriptorHelper();

    private AndroidFileDescriptorHelper() {
    }

    @DoNotInline
    @RequiresApi(26)
    @NotNull
    public final android.graphics.Typeface create(@NotNull ParcelFileDescriptor fileDescriptor) {
        t.i(fileDescriptor, "fileDescriptor");
        android.graphics.Typeface typefaceBuild = new Typeface.Builder(fileDescriptor.getFileDescriptor()).build();
        t.h(typefaceBuild, "Builder(fileDescriptor.fileDescriptor).build()");
        return typefaceBuild;
    }
}
