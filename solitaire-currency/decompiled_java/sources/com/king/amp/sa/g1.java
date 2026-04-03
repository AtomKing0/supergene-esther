package com.king.amp.sa;

/* JADX INFO: compiled from: IHttpDownloadHandler.java */
/* JADX INFO: loaded from: classes4.dex */
interface g1 {
    void onHttpDataReceived(String str, long j10, long j11);

    void onHttpDownloadCompleted(String str);

    void onHttpDownloadFailed(String str, int i10, String str2);

    void onHttpDownloadStarted(String str, long j10);
}
