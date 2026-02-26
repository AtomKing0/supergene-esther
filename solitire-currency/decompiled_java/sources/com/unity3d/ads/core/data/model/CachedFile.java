package com.unity3d.ads.core.data.model;

import androidx.compose.animation.a;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CachedFile.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CachedFile {
    private final long contentLength;

    @Nullable
    private final String extension;

    @Nullable
    private final File file;

    @NotNull
    private final String name;

    @NotNull
    private final String objectId;
    private final int priority;

    @NotNull
    private final String protocol;

    @NotNull
    private final String url;

    public CachedFile(@NotNull String objectId, @NotNull String url, @NotNull String name, @Nullable File file, @Nullable String str, long j10, @NotNull String protocol, int i10) {
        t.i(objectId, "objectId");
        t.i(url, "url");
        t.i(name, "name");
        t.i(protocol, "protocol");
        this.objectId = objectId;
        this.url = url;
        this.name = name;
        this.file = file;
        this.extension = str;
        this.contentLength = j10;
        this.protocol = protocol;
        this.priority = i10;
    }

    @NotNull
    public final String component1() {
        return this.objectId;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @Nullable
    public final File component4() {
        return this.file;
    }

    @Nullable
    public final String component5() {
        return this.extension;
    }

    public final long component6() {
        return this.contentLength;
    }

    @NotNull
    public final String component7() {
        return this.protocol;
    }

    public final int component8() {
        return this.priority;
    }

    @NotNull
    public final CachedFile copy(@NotNull String objectId, @NotNull String url, @NotNull String name, @Nullable File file, @Nullable String str, long j10, @NotNull String protocol, int i10) {
        t.i(objectId, "objectId");
        t.i(url, "url");
        t.i(name, "name");
        t.i(protocol, "protocol");
        return new CachedFile(objectId, url, name, file, str, j10, protocol, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedFile)) {
            return false;
        }
        CachedFile cachedFile = (CachedFile) obj;
        return t.d(this.objectId, cachedFile.objectId) && t.d(this.url, cachedFile.url) && t.d(this.name, cachedFile.name) && t.d(this.file, cachedFile.file) && t.d(this.extension, cachedFile.extension) && this.contentLength == cachedFile.contentLength && t.d(this.protocol, cachedFile.protocol) && this.priority == cachedFile.priority;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    @Nullable
    public final String getExtension() {
        return this.extension;
    }

    @Nullable
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getObjectId() {
        return this.objectId;
    }

    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final String getProtocol() {
        return this.protocol;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = ((((this.objectId.hashCode() * 31) + this.url.hashCode()) * 31) + this.name.hashCode()) * 31;
        File file = this.file;
        int iHashCode2 = (iHashCode + (file == null ? 0 : file.hashCode())) * 31;
        String str = this.extension;
        return ((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + a.a(this.contentLength)) * 31) + this.protocol.hashCode()) * 31) + this.priority;
    }

    @NotNull
    public String toString() {
        return "CachedFile(objectId=" + this.objectId + ", url=" + this.url + ", name=" + this.name + ", file=" + this.file + ", extension=" + this.extension + ", contentLength=" + this.contentLength + ", protocol=" + this.protocol + ", priority=" + this.priority + ')';
    }

    public /* synthetic */ CachedFile(String str, String str2, String str3, File file, String str4, long j10, String str5, int i10, int i11, k kVar) {
        this(str, str2, str3, (i11 & 8) != 0 ? null : file, (i11 & 16) != 0 ? "" : str4, (i11 & 32) != 0 ? -1L : j10, (i11 & 64) != 0 ? "" : str5, (i11 & 128) != 0 ? Integer.MAX_VALUE : i10);
    }
}
