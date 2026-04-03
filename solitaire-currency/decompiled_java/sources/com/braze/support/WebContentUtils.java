package com.braze.support;

import android.content.Context;
import bo.app.aj0;
import bo.app.bj0;
import bo.app.qi0;
import bo.app.ri0;
import bo.app.si0;
import bo.app.ti0;
import bo.app.ui0;
import bo.app.vi0;
import bo.app.wi0;
import bo.app.xi0;
import bo.app.yi0;
import bo.app.zi0;
import com.braze.support.BrazeLogger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import p9.q;
import p9.r;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class WebContentUtils {
    public static final WebContentUtils INSTANCE = new WebContentUtils();

    private WebContentUtils() {
    }

    public static final File getHtmlInAppMessageAssetCacheDirectory(Context context) {
        t.i(context, "context");
        return new File(context.getCacheDir().getPath() + "/braze-html-inapp-messages");
    }

    public static final String getLocalHtmlUrlFromRemoteUrl(File localDirectory, String remoteZipUrl) {
        t.i(localDirectory, "localDirectory");
        t.i(remoteZipUrl, "remoteZipUrl");
        if (q.z(remoteZipUrl)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) qi0.f3712a, 6, (Object) null);
            return null;
        }
        String absolutePath = localDirectory.getAbsolutePath();
        String strValueOf = String.valueOf(IntentUtils.getRequestCode());
        String str = absolutePath + '/' + strValueOf;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        WebContentUtils webContentUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ri0(remoteZipUrl, str), 7, (Object) null);
        try {
            File fileA = BrazeFileUtils.downloadFileToPath(str, remoteZipUrl, strValueOf, ".zip").a();
            BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ti0(remoteZipUrl, str), 7, (Object) null);
            if (unpackZipIntoDirectory(str, fileA)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new vi0(str), 7, (Object) null);
                return str;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ui0.f4026a, 6, (Object) null);
            BrazeFileUtils.deleteFileOrDirectory(new File(str));
            return null;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new si0(remoteZipUrl), 4, (Object) null);
            BrazeFileUtils.deleteFileOrDirectory(new File(str));
            return null;
        }
    }

    public static final String replacePrefetchedUrlsWithLocalAssets(String originalString, Map<String, String> remoteToLocalAssetMap) {
        t.i(originalString, "originalString");
        t.i(remoteToLocalAssetMap, "remoteToLocalAssetMap");
        String strG = originalString;
        for (Map.Entry<String, String> entry : remoteToLocalAssetMap.entrySet()) {
            String value = entry.getValue();
            if (new File(value).exists()) {
                String key = entry.getKey();
                if (r.P(value, "ab_triggers", false, 2, null)) {
                    String str = "https://iamcache.braze/ab_triggers" + ((String) r.C0(value, new String[]{"ab_triggers"}, false, 0, 6, null).get(1));
                    if (r.P(strG, key, false, 2, null)) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new xi0(key, str), 7, (Object) null);
                        strG = q.G(strG, key, str, false, 4, null);
                    }
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new wi0(value), 6, (Object) null);
            }
        }
        return strG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Object, java.lang.String] */
    public static final boolean unpackZipIntoDirectory(String unpackDirectory, File zipFile) {
        t.i(unpackDirectory, "unpackDirectory");
        t.i(zipFile, "zipFile");
        if (q.z(unpackDirectory)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) yi0.f4369a, 6, (Object) null);
            return false;
        }
        new File(unpackDirectory).mkdirs();
        try {
            n0 n0Var = new n0();
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
            try {
                for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                    ?? name = nextEntry.getName();
                    t.h(name, "zipEntry.name");
                    n0Var.f29834a = name;
                    Locale US = Locale.US;
                    t.h(US, "US");
                    String lowerCase = name.toLowerCase(US);
                    t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (!q.K(lowerCase, "__macosx", false, 2, null)) {
                        try {
                            String strValidateChildFileExistsUnderParent = validateChildFileExistsUnderParent(unpackDirectory, unpackDirectory + '/' + ((String) n0Var.f29834a));
                            if (nextEntry.isDirectory()) {
                                new File(strValidateChildFileExistsUnderParent).mkdirs();
                            } else {
                                try {
                                    File parentFile = new File(strValidateChildFileExistsUnderParent).getParentFile();
                                    if (parentFile != null) {
                                        parentFile.mkdirs();
                                    }
                                } catch (Exception e10) {
                                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new zi0(n0Var), 4, (Object) null);
                                }
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(strValidateChildFileExistsUnderParent));
                                try {
                                    f9.b.b(zipInputStream, bufferedOutputStream, 0, 2, null);
                                    f9.c.a(bufferedOutputStream, null);
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        f9.c.a(bufferedOutputStream, th);
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Exception e11) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) new aj0(n0Var), 4, (Object) null);
                        }
                    }
                    zipInputStream.closeEntry();
                }
                k0 k0Var = k0.f35197a;
                f9.c.a(zipInputStream, null);
                return true;
            } finally {
            }
        } catch (Throwable th3) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, th3, false, (h9.a) new bj0(zipFile, unpackDirectory), 4, (Object) null);
            return false;
        }
    }

    public static final String validateChildFileExistsUnderParent(String intendedParentDirectory, String childFilePath) throws IOException {
        t.i(intendedParentDirectory, "intendedParentDirectory");
        t.i(childFilePath, "childFilePath");
        String parentCanonicalPath = new File(intendedParentDirectory).getCanonicalPath();
        String childFileCanonicalPath = new File(childFilePath).getCanonicalPath();
        t.h(childFileCanonicalPath, "childFileCanonicalPath");
        t.h(parentCanonicalPath, "parentCanonicalPath");
        if (q.K(childFileCanonicalPath, parentCanonicalPath, false, 2, null)) {
            return childFileCanonicalPath;
        }
        throw new IllegalStateException("Invalid file with original path: " + childFilePath + " with canonical path: " + childFileCanonicalPath + " does not exist under intended parent with  path: " + intendedParentDirectory + " and canonical path: " + parentCanonicalPath);
    }
}
