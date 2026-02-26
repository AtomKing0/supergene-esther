package com.vungle.ads.internal.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdAsset.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    @NotNull
    private final String adIdentifier;
    private long fileSize;

    @NotNull
    private final EnumC0510a fileType;
    private final boolean isRequired;

    @NotNull
    private final String localPath;

    @NotNull
    private final String serverPath;

    @NotNull
    private b status;

    /* JADX INFO: renamed from: com.vungle.ads.internal.model.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdAsset.kt */
    public enum EnumC0510a {
        ZIP,
        ASSET
    }

    /* JADX INFO: compiled from: AdAsset.kt */
    public enum b {
        NEW,
        DOWNLOAD_RUNNING,
        DOWNLOAD_FAILED,
        DOWNLOAD_SUCCESS,
        PROCESSED
    }

    public a(@NotNull String adIdentifier, @NotNull String serverPath, @NotNull String localPath, @NotNull EnumC0510a fileType, boolean z10) {
        t.i(adIdentifier, "adIdentifier");
        t.i(serverPath, "serverPath");
        t.i(localPath, "localPath");
        t.i(fileType, "fileType");
        this.adIdentifier = adIdentifier;
        this.serverPath = serverPath;
        this.localPath = localPath;
        this.fileType = fileType;
        this.isRequired = z10;
        this.status = b.NEW;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(a.class, obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        if (this.status == aVar.status && this.fileType == aVar.fileType && this.fileSize == aVar.fileSize && this.isRequired == aVar.isRequired && t.d(this.adIdentifier, aVar.adIdentifier) && t.d(this.serverPath, aVar.serverPath)) {
            return t.d(this.localPath, aVar.localPath);
        }
        return false;
    }

    @NotNull
    public final String getAdIdentifier() {
        return this.adIdentifier;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    @NotNull
    public final EnumC0510a getFileType() {
        return this.fileType;
    }

    @NotNull
    public final String getLocalPath() {
        return this.localPath;
    }

    @NotNull
    public final String getServerPath() {
        return this.serverPath;
    }

    @NotNull
    public final b getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.adIdentifier.hashCode() * 31) + this.serverPath.hashCode()) * 31) + this.localPath.hashCode()) * 31) + this.status.hashCode()) * 31) + this.fileType.hashCode()) * 31;
        long j10 = this.fileSize;
        return ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + androidx.compose.foundation.e.a(this.isRequired);
    }

    public final boolean isRequired() {
        return this.isRequired;
    }

    public final void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public final void setStatus(@NotNull b bVar) {
        t.i(bVar, "<set-?>");
        this.status = bVar;
    }

    @NotNull
    public String toString() {
        return "AdAsset{, adIdentifier='" + this.adIdentifier + "', serverPath='" + this.serverPath + "', localPath='" + this.localPath + "', status=" + this.status + ", fileType=" + this.fileType + ", fileSize=" + this.fileSize + ", isRequired=" + this.isRequired + '}';
    }
}
