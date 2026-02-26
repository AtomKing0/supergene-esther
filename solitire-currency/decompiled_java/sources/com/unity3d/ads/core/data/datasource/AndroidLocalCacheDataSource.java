package com.unity3d.ads.core.data.datasource;

import androidx.media3.extractor.ts.PsExtractor;
import com.unity3d.ads.core.data.model.CacheError;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CacheSource;
import com.unity3d.ads.core.data.model.CachedFile;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: AndroidLocalCacheDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidLocalCacheDataSource implements CacheDataSource {
    @Override // com.unity3d.ads.core.data.datasource.CacheDataSource
    @Nullable
    public Object getFile(@NotNull File file, @NotNull String str, @Nullable String str2, @Nullable Integer num, @NotNull d<? super CacheResult> dVar) {
        File file2 = new File(file, str);
        if (file2.exists()) {
            return new CacheResult.Success(new CachedFile("", str2 == null ? "" : str2, str, file2, null, 0L, null, 0, PsExtractor.VIDEO_STREAM_MASK, null), CacheSource.LOCAL);
        }
        return new CacheResult.Failure(CacheError.FILE_NOT_FOUND, CacheSource.LOCAL);
    }
}
