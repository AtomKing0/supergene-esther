package androidx.core.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.provider.FontProvider;

/* JADX INFO: compiled from: FontProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d {
    public static FontProvider.ContentQueryWrapper a(Context context, Uri uri) {
        return Build.VERSION.SDK_INT < 24 ? new FontProvider.ContentQueryWrapperApi16Impl(context, uri) : new FontProvider.ContentQueryWrapperApi24Impl(context, uri);
    }
}
