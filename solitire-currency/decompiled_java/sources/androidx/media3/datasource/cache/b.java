package androidx.media3.datasource.cache;

import androidx.media3.datasource.DataSpec;

/* JADX INFO: compiled from: CacheKeyFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b {
    static {
        CacheKeyFactory cacheKeyFactory = CacheKeyFactory.DEFAULT;
    }

    public static /* synthetic */ String a(DataSpec dataSpec) {
        String str = dataSpec.key;
        return str != null ? str : dataSpec.uri.toString();
    }
}
