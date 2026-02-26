package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
@Deprecated
public interface Bundleable {

    @Deprecated
    public interface Creator<T extends Bundleable> {
        T fromBundle(Bundle bundle);
    }

    Bundle toBundle();
}
