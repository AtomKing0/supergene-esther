package com.vungle.ads.internal.util;

import androidx.annotation.VisibleForTesting;
import com.vungle.ads.internal.util.p;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UnzipUtility.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class w {
    private static final int BUFFER_SIZE = 4096;

    @NotNull
    public static final w INSTANCE = new w();
    private static final String TAG = w.class.getCanonicalName();

    /* JADX INFO: compiled from: UnzipUtility.kt */
    public interface a {
        boolean matches(@Nullable String str);
    }

    /* JADX INFO: compiled from: UnzipUtility.kt */
    public static final class b extends IOException {
        public b(@Nullable String str) {
            super(str);
        }
    }

    private w() {
    }

    public static /* synthetic */ List unzip$default(w wVar, String str, String str2, a aVar, int i10, Object obj) throws IOException {
        if ((i10 & 4) != 0) {
            aVar = null;
        }
        return wVar.unzip(str, str2, aVar);
    }

    private final String validateFilename(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        String canonicalID = new File(str2).getCanonicalPath();
        kotlin.jvm.internal.t.h(canonicalPath, "canonicalPath");
        kotlin.jvm.internal.t.h(canonicalID, "canonicalID");
        if (p9.q.K(canonicalPath, canonicalID, false, 2, null)) {
            return canonicalPath;
        }
        p.a aVar = p.Companion;
        String TAG2 = TAG;
        kotlin.jvm.internal.t.h(TAG2, "TAG");
        aVar.e(TAG2, "File is outside extraction target directory.");
        throw new b("File is outside extraction target directory.");
    }

    @VisibleForTesting
    public final void extractFile(@NotNull InputStream zipIn, @Nullable String str) throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        kotlin.jvm.internal.t.i(zipIn, "zipIn");
        File file = new File(str);
        i.delete(file);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = zipIn.read(bArr);
                        if (i10 == -1) {
                            i iVar = i.INSTANCE;
                            iVar.closeQuietly(zipIn);
                            iVar.closeQuietly(bufferedOutputStream);
                            iVar.closeQuietly(fileOutputStream);
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, i10);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i iVar2 = i.INSTANCE;
                    iVar2.closeQuietly(zipIn);
                    iVar2.closeQuietly(bufferedOutputStream);
                    iVar2.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            bufferedOutputStream = null;
        }
    }

    @NotNull
    public final List<File> unzip(@Nullable String str, @NotNull String destDirectory) throws IOException {
        kotlin.jvm.internal.t.i(destDirectory, "destDirectory");
        return unzip$default(this, str, destDirectory, null, 4, null);
    }

    @NotNull
    public final List<File> unzip(@Nullable String str, @NotNull String destDirectory, @Nullable a aVar) throws Throwable {
        kotlin.jvm.internal.t.i(destDirectory, "destDirectory");
        if (str == null || str.length() == 0) {
            throw new IOException("Path is empty");
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }
        File file2 = new File(destDirectory);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String str2 = destDirectory + File.separator + zipEntryNextElement.getName();
                    if (aVar == null || aVar.matches(str2)) {
                        validateFilename(str2, destDirectory);
                        if (zipEntryNextElement.isDirectory()) {
                            File file3 = new File(str2);
                            if (!file3.exists()) {
                                file3.mkdirs();
                            }
                        } else {
                            InputStream inputStream = zipFile2.getInputStream(zipEntryNextElement);
                            kotlin.jvm.internal.t.h(inputStream, "zipFile.getInputStream(entry)");
                            extractFile(inputStream, str2);
                            arrayList.add(new File(str2));
                        }
                    }
                }
                try {
                    zipFile2.close();
                } catch (IOException unused) {
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
