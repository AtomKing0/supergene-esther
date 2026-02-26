package com.braze.support;

import android.content.res.AssetManager;
import android.net.TrafficStats;
import android.net.Uri;
import androidx.webkit.ProxyConfig;
import bo.app.da;
import bo.app.ga;
import bo.app.ha;
import bo.app.ia;
import bo.app.ih0;
import bo.app.ja;
import bo.app.ka;
import bo.app.la;
import bo.app.ma;
import com.braze.Braze;
import com.braze.support.BrazeLogger;
import com.ironsource.v8;
import f9.m;
import f9.p;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import p9.q;
import v8.s;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeFileUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("BrazeFileUtils");
    public static final List<String> REMOTE_SCHEMES = v.n(ProxyConfig.MATCH_HTTP, "https", "ftp", "ftps", "about", "javascript");

    public static final void deleteFileOrDirectory(File fileOrDirectory) {
        t.i(fileOrDirectory, "fileOrDirectory");
        if (m.p(fileOrDirectory)) {
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new da(fileOrDirectory), 12, (Object) null);
    }

    public static final s<File, Map<String, String>> downloadFileToPath(String downloadDirectoryAbsolutePath, String remoteFileUrl, String outputFilename, String str) throws Exception {
        Exception exc;
        File file;
        HttpURLConnection httpURLConnectionA;
        t.i(downloadDirectoryAbsolutePath, "downloadDirectoryAbsolutePath");
        t.i(remoteFileUrl, "remoteFileUrl");
        t.i(outputFilename, "outputFilename");
        TrafficStats.setThreadStatsTag(1337);
        if (Braze.Companion.getOutboundNetworkRequestsOffline()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new ga(remoteFileUrl), 12, (Object) null);
            throw new Exception("SDK is offline. File not downloaded for url: " + remoteFileUrl);
        }
        if (q.z(downloadDirectoryAbsolutePath)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) ha.f2964a, 12, (Object) null);
            throw new Exception("Download directory is blank. File not downloaded.");
        }
        if (q.z(remoteFileUrl)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) ia.f3039a, 12, (Object) null);
            throw new Exception("Zip file url is blank. File not downloaded.");
        }
        if (q.z(outputFilename)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) ja.f3143a, 12, (Object) null);
            throw new Exception("Output filename is blank. File not downloaded.");
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                new File(downloadDirectoryAbsolutePath).mkdirs();
                if (str != null && !q.z(str)) {
                    outputFilename = outputFilename + str;
                }
                file = new File(downloadDirectoryAbsolutePath, outputFilename);
                httpURLConnectionA = ih0.f3062a.a(new URL(remoteFileUrl));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            exc = e10;
        }
        try {
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode != 200) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ka(remoteFileUrl, responseCode), 14, (Object) null);
                throw new Exception("HTTP response code was " + responseCode + ". File with url " + remoteFileUrl + " could not be downloaded.");
            }
            DataInputStream dataInputStream = new DataInputStream(httpURLConnectionA.getInputStream());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    f9.b.b(dataInputStream, fileOutputStream, 0, 2, null);
                    f9.c.a(fileOutputStream, null);
                    f9.c.a(dataInputStream, null);
                    Map<String, List<String>> headerFields = httpURLConnectionA.getHeaderFields();
                    t.h(headerFields, "urlConnection.headerFields");
                    LinkedHashMap linkedHashMapA = i.a(headerFields);
                    httpURLConnectionA.disconnect();
                    return new s<>(file, linkedHashMapA);
                } finally {
                }
            } finally {
            }
        } catch (Exception e11) {
            exc = e11;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) exc, false, (h9.a) new la(remoteFileUrl), 8, (Object) null);
            throw new Exception("Exception during download of file from url : " + remoteFileUrl);
        } catch (Throwable th2) {
            httpURLConnection = httpURLConnectionA;
            th = th2;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static /* synthetic */ s downloadFileToPath$default(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        return downloadFileToPath(str, str2, str3, str4);
    }

    public static final String getAssetFileStringContents(AssetManager assetManager, String assetPath) {
        t.i(assetManager, "<this>");
        t.i(assetPath, "assetPath");
        InputStream inputStreamOpen = assetManager.open(assetPath);
        t.h(inputStreamOpen, "this.open(assetPath)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, p9.d.f32952b);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String strE = p.e(bufferedReader);
            f9.c.a(bufferedReader, null);
            return strE;
        } finally {
        }
    }

    public static final boolean isLocalUri(Uri uri) {
        t.i(uri, "<this>");
        String scheme = uri.getScheme();
        return scheme == null || q.z(scheme) || t.d(scheme, v8.h.f15781b);
    }

    public static final boolean isRemoteUri(Uri uri) {
        t.i(uri, "<this>");
        String scheme = uri.getScheme();
        if (scheme != null && !q.z(scheme)) {
            return REMOTE_SCHEMES.contains(scheme);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) ma.f3401a, 12, (Object) null);
        return false;
    }
}
