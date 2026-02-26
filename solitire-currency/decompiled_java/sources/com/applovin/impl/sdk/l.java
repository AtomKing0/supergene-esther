package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.applovin.impl.f6;
import com.applovin.impl.l4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v1;
import com.applovin.impl.w4;
import com.applovin.impl.y1;
import com.applovin.impl.z6;
import com.ironsource.v8;
import com.unity3d.services.UnityAdsConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f7163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f7164c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f7167f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7162a = "FileManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f7165d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f7166e = new HashSet();

    l(j jVar) {
        this.f7163b = jVar;
        this.f7164c = jVar.I();
        this.f7167f = ((Boolean) jVar.a(l4.O0)).booleanValue();
    }

    private boolean e(File file) {
        if (file == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f7165d) {
            if (this.f7166e.contains(absolutePath)) {
                return false;
            }
            d(file);
            return true;
        }
    }

    private boolean g(File file) {
        if (n.a()) {
            this.f7164c.a("FileManager", "Removing file " + file.getName() + " from filesystem...");
        }
        try {
            d(file);
            boolean zDelete = file.delete();
            if (!zDelete) {
                HashMap<String, String> mapHashMap = CollectionUtils.hashMap("path", file.getAbsolutePath());
                mapHashMap.put("details", b(file));
                this.f7163b.A().a(y1.f7796n0, "removeFile", mapHashMap);
            }
            return zDelete;
        } catch (Throwable th) {
            try {
                if (n.a()) {
                    this.f7164c.a("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", th);
                }
                this.f7163b.A().a("FileManager", "removeFile", th);
                h(file);
                return false;
            } finally {
                h(file);
            }
        }
    }

    private void h(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f7165d) {
            if (!this.f7166e.remove(absolutePath)) {
                this.f7163b.A().a(y1.f7796n0, "unlockFile", CollectionUtils.hashMap("path", absolutePath));
            }
            this.f7165d.notifyAll();
        }
    }

    public void c(final com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.f7163b.j0().a((w4) new f6(this.f7163b, false, "removeCachedResourcesForAd", new Runnable() { // from class: com.applovin.impl.sdk.a1
            @Override // java.lang.Runnable
            public final void run() {
                this.f6927a.a(bVar, context);
            }
        }), r5.b.CACHING);
    }

    public void d(final com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.f7163b.j0().a((w4) new f6(this.f7163b, false, "removeCachedVideoResourceForAd", new Runnable() { // from class: com.applovin.impl.sdk.z0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7387a.b(bVar, context);
            }
        }), r5.b.CACHING);
    }

    public String f(File file) throws Throwable {
        if (file == null) {
            return null;
        }
        if (n.a()) {
            this.f7164c.a("FileManager", "Reading resource from filesystem: " + file.getName());
        }
        boolean z10 = true;
        try {
            try {
                try {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            d(file);
                            String strA = a(fileInputStream);
                            boolean z11 = strA == null;
                            fileInputStream.close();
                            if (z11 && ((Boolean) this.f7163b.a(l4.G0)).booleanValue()) {
                                a(file, "removeFileAfterReadFail");
                            }
                            h(file);
                            return strA;
                        } catch (Throwable th) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z10 = false;
                        if (z10 && ((Boolean) this.f7163b.a(l4.G0)).booleanValue()) {
                            a(file, "removeFileAfterReadFail");
                        }
                        h(file);
                        throw th;
                    }
                } catch (Throwable th4) {
                    if (n.a()) {
                        this.f7164c.a("FileManager", "Unknown failure to read file.", th4);
                    }
                    this.f7164c.a("FileManager", th4);
                    this.f7163b.A().a("FileManager", "readFile", th4);
                    if (((Boolean) this.f7163b.a(l4.G0)).booleanValue()) {
                        a(file, "removeFileAfterReadFail");
                    }
                    h(file);
                    return null;
                }
            } catch (FileNotFoundException e10) {
                if (n.a()) {
                    this.f7164c.d("FileManager", "File not found. " + e10);
                }
                this.f7164c.a("FileManager", e10);
                this.f7163b.A().a("FileManager", "readFileNotFound", e10);
                if (0 != 0 && ((Boolean) this.f7163b.a(l4.G0)).booleanValue()) {
                    a(file, "removeFileAfterReadFail");
                }
                h(file);
                return null;
            } catch (IOException e11) {
                if (n.a()) {
                    this.f7164c.a("FileManager", "Failed to read file: " + file.getName() + e11);
                }
                this.f7164c.a("FileManager", e11);
                this.f7163b.A().a("FileManager", "readFileIO", e11);
                if (((Boolean) this.f7163b.a(l4.G0)).booleanValue()) {
                    a(file, "removeFileAfterReadFail");
                }
                h(file);
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private boolean c(File file) {
        boolean zContains;
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f7165d) {
            zContains = this.f7166e.contains(absolutePath);
        }
        return zContains;
    }

    private void d(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f7165d) {
            boolean zAdd = this.f7166e.add(absolutePath);
            while (!zAdd) {
                try {
                    this.f7165d.wait();
                    zAdd = this.f7166e.add(absolutePath);
                } catch (InterruptedException e10) {
                    if (n.a()) {
                        this.f7164c.a("FileManager", "Lock '" + absolutePath + "' interrupted", e10);
                    }
                    throw new RuntimeException(e10);
                }
            }
        }
    }

    public File a(String str, Context context) {
        return a(str, true, context);
    }

    public boolean b(InputStream inputStream, File file, boolean z10) {
        return a(inputStream, file, z10, false);
    }

    private File a(String str, boolean z10, Context context) {
        if (!StringUtils.isValidString(str)) {
            if (n.a()) {
                this.f7164c.a("FileManager", "Nothing to look up, skipping...");
            }
            return null;
        }
        if (n.a()) {
            this.f7164c.a("FileManager", "Looking up cached resource: " + str);
        }
        if (str.contains(v8.h.H0)) {
            str = str.replace(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, "_").replace(".", "_");
        }
        File fileD = d(context);
        File file = new File(fileD, str);
        if (z10) {
            try {
                fileD.mkdirs();
            } catch (Throwable th) {
                if (n.a()) {
                    this.f7164c.a("FileManager", "Unable to make cache directory at " + fileD, th);
                }
                this.f7163b.A().a("FileManager", "createCacheDir", th);
                return null;
            }
        }
        return file;
    }

    public void b(Context context) {
        if (this.f7163b.x0()) {
            if (n.a()) {
                this.f7164c.a("FileManager", "Compacting cache...");
            }
            a(a(context), context);
        }
    }

    private List c(Context context) {
        File[] fileArrListFiles;
        File fileD = d(context);
        if (fileD.isDirectory() && (fileArrListFiles = fileD.listFiles()) != null) {
            return Arrays.asList(fileArrListFiles);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.ad.b bVar, Context context) {
        if (bVar.p0() == null) {
            return;
        }
        g(a(bVar.p0().getLastPathSegment(), context));
    }

    public void e(Context context) {
        try {
            a(".nomedia", context);
            File file = new File(d(context), ".nomedia");
            if (a(file)) {
                return;
            }
            if (n.a()) {
                this.f7164c.a("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
            }
            if (file.createNewFile()) {
                return;
            }
            if (n.a()) {
                this.f7164c.b("FileManager", "Failed to create .nomedia file");
            }
            this.f7163b.A().a(y1.f7796n0, "createNoMediaFile");
        } catch (IOException e10) {
            if (n.a()) {
                this.f7164c.a("FileManager", "Failed to create .nomedia file", e10);
            }
        }
    }

    private String b(File file) {
        try {
            boolean zExists = file.exists();
            boolean zIsDirectory = file.isDirectory();
            String[] list = file.list();
            boolean z10 = true;
            boolean z11 = zIsDirectory && list != null && list.length == 0;
            File parentFile = file.getParentFile();
            boolean z12 = parentFile != null && parentFile.exists();
            if (!z12 || !parentFile.canWrite()) {
                z10 = false;
            }
            return "fileExists: " + zExists + "\nisDirectory: " + zIsDirectory + "\nisEmptyDirectory: " + z11 + "\nparentDirectoryExists: " + z12 + "\nisParentDirectoryWritable: " + z10;
        } catch (Throwable th) {
            return "Error retrieving file deletion failure reason: " + th;
        }
    }

    private File d(Context context) {
        return new File(context.getFilesDir(), "al");
    }

    public boolean c(String str, Context context) {
        if (this.f7167f) {
            return b(str, context);
        }
        boolean z10 = false;
        File fileA = a(str, false, context);
        if (!e(fileA)) {
            return false;
        }
        if (fileA.exists() && !fileA.isDirectory()) {
            z10 = true;
        }
        h(fileA);
        return z10;
    }

    public String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bArr = new byte[8192];
            } finally {
            }
        } catch (Throwable th) {
            this.f7164c.a("FileManager", th);
            this.f7163b.A().a("FileManager", "readInputStreamAsString", th);
            return null;
        }
        while (true) {
            int i10 = inputStream.read(bArr, 0, 8192);
            if (i10 >= 0) {
                byteArrayOutputStream.write(bArr, 0, i10);
            } else {
                String string = byteArrayOutputStream.toString("UTF-8");
                byteArrayOutputStream.close();
                return string;
            }
            this.f7164c.a("FileManager", th);
            this.f7163b.A().a("FileManager", "readInputStreamAsString", th);
            return null;
        }
    }

    public boolean b(String str, Context context) {
        return a(a(str, false, context));
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01b0 A[EDGE_INSN: B:170:0x01b0->B:111:0x01b0 BREAK  A[LOOP:1: B:94:0x0182->B:171:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1 A[Catch: all -> 0x0110, TryCatch #12 {all -> 0x0110, blocks: (B:58:0x00eb, B:60:0x00f1, B:61:0x00f6), top: B:163:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(java.io.InputStream r18, java.io.File r19, boolean r20, boolean r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.l.a(java.io.InputStream, java.io.File, boolean, boolean):boolean");
    }

    public boolean a(File file, String str, List list, int i10, String str2) {
        return a(file, str, list, true, i10, str2);
    }

    private boolean a(File file, String str, List list, boolean z10, int i10, String str2) {
        HashMap map = new HashMap(1);
        map.put("url", str);
        this.f7163b.g().d(y1.f7805s, map);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i11 = 1; i11 <= i10; i11++) {
            if (a(file, str, list, z10, str2)) {
                a(true, str, i11, jElapsedRealtime);
                return true;
            }
        }
        a(false, str, i10, jElapsedRealtime);
        return false;
    }

    private boolean a(File file, String str, List list, boolean z10, String str2) {
        Boolean bool = (Boolean) this.f7163b.a(l4.P0);
        if (bool.booleanValue()) {
            d(file);
        }
        if (a(file)) {
            if (n.a()) {
                this.f7164c.a("FileManager", "File exists for " + str);
            }
            this.f7163b.g().d(y1.f7807t, CollectionUtils.hashMap("url", str));
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            InputStream inputStreamA = a(str, list, z10);
            try {
                boolean zA = a(inputStreamA, file, bool.booleanValue());
                if (zA) {
                    double d10 = z6.d(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    double dC = z6.c(file.length());
                    long j10 = (long) (dC / d10);
                    HashMap<String, String> mapHashMap = CollectionUtils.hashMap("path", file.getAbsolutePath());
                    CollectionUtils.putObjectToStringIfValid("network_throughput_kbps", Long.valueOf(j10), mapHashMap);
                    CollectionUtils.putObjectToStringIfValid("details", Double.valueOf(dC), mapHashMap);
                    this.f7163b.g().d(y1.f7815x, mapHashMap);
                    if (StringUtils.isValidString(str2) && str.endsWith(str2)) {
                        this.f7163b.y().a(Long.valueOf(j10));
                    }
                }
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                if (bool.booleanValue()) {
                    h(file);
                }
                return zA;
            } finally {
            }
        } catch (Throwable th) {
            try {
                this.f7164c.a("FileManager", th);
                this.f7163b.A().a("FileManager", "loadAndCacheResource", th);
                if (!bool.booleanValue()) {
                    return false;
                }
                h(file);
                return false;
            } finally {
                if (bool.booleanValue()) {
                    h(file);
                }
            }
        }
    }

    private void a(boolean z10, String str, int i10, long j10) {
        y1 y1Var = z10 ? y1.f7809u : y1.f7811v;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
        HashMap map = new HashMap(3);
        map.put("attempt_number", Integer.toString(i10));
        map.put("url", str);
        map.put("duration_ms", String.valueOf(jElapsedRealtime));
        this.f7163b.g().d(y1Var, map);
    }

    public InputStream a(String str, List list, boolean z10) {
        HttpURLConnection httpURLConnection;
        if (z10 && !z6.a(str, list)) {
            if (n.a()) {
                this.f7164c.a("FileManager", "Domain is not whitelisted, skipping precache for url: " + str);
            }
            return null;
        }
        if (((Boolean) this.f7163b.a(l4.H2)).booleanValue() && !str.contains("https://")) {
            if (n.a()) {
                this.f7164c.k("FileManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            }
            str = str.replace("http://", "https://");
        }
        if (n.a()) {
            this.f7164c.a("FileManager", "Loading " + str + "...");
        }
        this.f7163b.g().d(y1.f7813w, CollectionUtils.hashMap("url", str));
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(((Integer) this.f7163b.a(l4.F2)).intValue());
                httpURLConnection.setReadTimeout(((Integer) this.f7163b.a(l4.G2)).intValue());
                httpURLConnection.setDefaultUseCaches(true);
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                this.f7163b.A().a("loadResource", str, responseCode, httpURLConnection.getResponseMessage());
                if (responseCode >= 200 && responseCode < 300) {
                    if (n.a()) {
                        this.f7164c.a("FileManager", "Opened stream to resource " + str);
                    }
                    return httpURLConnection.getInputStream();
                }
                if (((Boolean) this.f7163b.a(l4.f5626e3)).booleanValue()) {
                    z6.a(httpURLConnection, this.f7163b);
                }
                return null;
            } catch (Throwable th) {
                th = th;
                try {
                    if (n.a()) {
                        this.f7164c.a("FileManager", "Error loading " + str, th);
                    }
                    this.f7163b.A().a("FileManager", "loadResource", th, CollectionUtils.hashMap("url", str));
                    if (((Boolean) this.f7163b.a(l4.f5626e3)).booleanValue()) {
                        z6.a(httpURLConnection, this.f7163b);
                    }
                    return null;
                } finally {
                    if (((Boolean) this.f7163b.a(l4.f5626e3)).booleanValue()) {
                        z6.a(httpURLConnection, this.f7163b);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    private boolean a(InputStream inputStream, File file, boolean z10) {
        if (file == null) {
            return false;
        }
        if (n.a()) {
            this.f7164c.a("FileManager", "Caching " + file.getAbsolutePath() + "...");
        }
        if (!a(inputStream, file, false, z10)) {
            if (n.a()) {
                this.f7164c.b("FileManager", "Unable to cache " + file.getAbsolutePath());
            }
            this.f7163b.g().d(y1.f7817y, CollectionUtils.hashMap("path", file.getAbsolutePath()));
            return false;
        }
        if (!n.a()) {
            return true;
        }
        this.f7164c.a("FileManager", "Caching completed for " + file);
        return true;
    }

    public int a(String str, com.applovin.impl.sdk.ad.b bVar) {
        List listX = bVar.X();
        if (bVar.Q0() || listX.contains(str)) {
            return bVar.G();
        }
        return 1;
    }

    public String a(Context context, String str, String str2, List list, boolean z10, int i10, String str3) {
        return a(context, str, str2, list, z10, false, i10, str3);
    }

    public String a(Context context, String str, String str2, List list, boolean z10, boolean z11, int i10, String str3) {
        if (!StringUtils.isValidString(str)) {
            if (n.a()) {
                this.f7164c.a("FileManager", "Nothing to cache, skipping...");
            }
            this.f7163b.A().a(y1.f7796n0, "cacheResource");
            return null;
        }
        String strA = z6.a(Uri.parse(str), str2, this.f7163b);
        File fileA = a(strA, context);
        if (!a(fileA, str, list, z10, i10, str3)) {
            return null;
        }
        if (n.a()) {
            this.f7164c.a("FileManager", "Caching succeeded for file " + strA);
        }
        return z11 ? Uri.fromFile(fileA).toString() : strA;
    }

    private long a(Context context) {
        boolean zG;
        long jA = a();
        boolean z10 = jA != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        List listC = this.f7163b.c(l4.E0);
        long length = 0;
        for (File file : c(context)) {
            if (!z10 || listC.contains(file.getName()) || c(file) || seconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) <= jA) {
                zG = false;
            } else {
                if (n.a()) {
                    this.f7164c.a("FileManager", "File " + file.getName() + " has expired, removing...");
                }
                zG = g(file);
            }
            if (zG) {
                this.f7163b.E().c(v1.f7560j);
            } else {
                length += file.length();
            }
        }
        return length;
    }

    private void a(long j10, Context context) {
        long jIntValue = ((Integer) this.f7163b.a(l4.A0)).intValue();
        if (jIntValue == -1) {
            if (n.a()) {
                this.f7164c.a("FileManager", "Cache has no maximum size set; skipping drop...");
            }
        } else {
            if (a(j10) > jIntValue) {
                if (n.a()) {
                    this.f7164c.a("FileManager", "Cache has exceeded maximum size; dropping...");
                }
                Iterator it = c(context).iterator();
                while (it.hasNext()) {
                    g((File) it.next());
                }
                this.f7163b.E().c(v1.f7561k);
                return;
            }
            if (n.a()) {
                this.f7164c.a("FileManager", "Cache is present but under size limit; not dropping...");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, Context context) {
        ArrayList arrayList = new ArrayList(bVar.i());
        CollectionUtils.addObjectIfExists(bVar.p0(), arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g(a(((Uri) it.next()).getLastPathSegment(), context));
        }
    }

    public void a(File file, String str) {
        if (n.a()) {
            this.f7164c.a("FileManager", "Removing file " + file.getName() + " for source " + str + ".");
        }
        try {
            if (file.delete()) {
                return;
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("path", file.getAbsolutePath());
            mapHashMap.put("details", b(file));
            this.f7163b.A().a(y1.f7796n0, str, mapHashMap);
        } catch (Throwable th) {
            if (n.a()) {
                this.f7164c.a("FileManager", "Failed to remove file " + file.getName() + " from filesystem after failed operation.", th);
            }
            this.f7163b.A().a("FileManager", str, th);
        }
    }

    private long a() {
        long jLongValue = ((Long) this.f7163b.a(l4.f5786z0)).longValue();
        if (jLongValue >= 0) {
            return jLongValue;
        }
        return -1L;
    }

    private long a(long j10) {
        return j10 / 1048576;
    }

    public boolean a(File file) {
        return (file == null || !file.exists() || file.isDirectory()) ? false : true;
    }
}
