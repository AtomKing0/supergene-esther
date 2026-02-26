package com.vungle.ads.internal.util;

import android.os.Build;
import android.webkit.URLUtil;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.internal.util.p;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FileUtility.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    @NotNull
    public static final i INSTANCE = new i();

    @NotNull
    private static a objectInputStreamProvider = new a() { // from class: com.vungle.ads.internal.util.h
        @Override // com.vungle.ads.internal.util.i.a
        public final ObjectInputStream provideObjectInputStream(InputStream inputStream) {
            return i.m4116objectInputStreamProvider$lambda0(inputStream);
        }
    };
    private static final String TAG = i.class.getSimpleName();

    @NotNull
    private static final List<Class<?>> allowedClasses = kotlin.collections.v.n(LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class);

    /* JADX INFO: compiled from: FileUtility.kt */
    public interface a {
        @NotNull
        ObjectInputStream provideObjectInputStream(@Nullable InputStream inputStream) throws IOException, ClassNotFoundException;
    }

    private i() {
    }

    public static final void delete(@Nullable File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        deleteContents(file);
                    }
                    if (file.delete()) {
                        return;
                    }
                    p.a aVar = p.Companion;
                    String TAG2 = TAG;
                    kotlin.jvm.internal.t.h(TAG2, "TAG");
                    aVar.d(TAG2, "Failed to delete file: " + file);
                }
            } catch (Exception e10) {
                p.a aVar2 = p.Companion;
                String TAG3 = TAG;
                kotlin.jvm.internal.t.h(TAG3, "TAG");
                aVar2.e(TAG3, "Failed to delete file: " + e10.getLocalizedMessage());
            }
        }
    }

    public static final void deleteAndLogIfFailed(@NotNull File file) {
        kotlin.jvm.internal.t.i(file, "file");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Files.delete(file.toPath());
            } else if (!file.delete()) {
                p.a aVar = p.Companion;
                String TAG2 = TAG;
                kotlin.jvm.internal.t.h(TAG2, "TAG");
                aVar.e(TAG2, "Cannot delete " + file.getName());
            }
        } catch (Exception e10) {
            p.a aVar2 = p.Companion;
            String TAG3 = TAG;
            kotlin.jvm.internal.t.h(TAG3, "TAG");
            aVar2.e(TAG3, "Cannot delete " + file.getName(), e10);
        }
    }

    public static final void deleteContents(@NotNull File folder) {
        kotlin.jvm.internal.t.i(folder, "folder");
        File[] fileArrListFiles = folder.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            delete(file);
        }
    }

    private final String getIndentString(int i10) {
        StringBuilder sb = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append("|  ");
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "sb.toString()");
        return string;
    }

    public static /* synthetic */ String guessFileName$default(i iVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return iVar.guessFileName(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: objectInputStreamProvider$lambda-0, reason: not valid java name */
    public static final ObjectInputStream m4116objectInputStreamProvider$lambda0(InputStream inputStream) {
        return new t(inputStream, allowedClasses);
    }

    public static final void printDirectoryTree(@Nullable File file) {
    }

    private final void printFile(File file, int i10, StringBuilder sb) {
        sb.append(getIndentString(i10));
        sb.append("+--");
        sb.append(file.getName());
        sb.append('\n');
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b2: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:179), block:B:39:0x00b2 */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.vungle.ads.internal.util.i] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.vungle.ads.internal.util.i] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.vungle.ads.internal.util.i] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.vungle.ads.internal.util.i$a] */
    @Nullable
    public static final <T> T readSerializable(@NotNull File file) {
        Closeable closeable;
        ObjectInputStream objectInputStreamProvideObjectInputStream;
        ?? r12;
        kotlin.jvm.internal.t.i(file, "file");
        ?? Exists = file.exists();
        Closeable closeable2 = null;
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                Exists = new FileInputStream(file);
                try {
                    objectInputStreamProvideObjectInputStream = objectInputStreamProvider.provideObjectInputStream(Exists);
                    try {
                        T t10 = (T) objectInputStreamProvideObjectInputStream.readObject();
                        ?? r02 = INSTANCE;
                        r02.closeQuietly(objectInputStreamProvideObjectInputStream);
                        r02.closeQuietly(Exists);
                        return t10;
                    } catch (IOException e10) {
                        e = e10;
                        p.a aVar = p.Companion;
                        String TAG2 = TAG;
                        kotlin.jvm.internal.t.h(TAG2, "TAG");
                        aVar.e(TAG2, "IOException: " + e.getMessage());
                        r12 = Exists;
                        ?? r03 = INSTANCE;
                        r03.closeQuietly(objectInputStreamProvideObjectInputStream);
                        r03.closeQuietly(r12);
                        try {
                            delete(file);
                        } catch (IOException unused) {
                        }
                        return null;
                    } catch (ClassNotFoundException e11) {
                        e = e11;
                        p.a aVar2 = p.Companion;
                        String TAG3 = TAG;
                        kotlin.jvm.internal.t.h(TAG3, "TAG");
                        aVar2.e(TAG3, "ClassNotFoundException: " + e.getMessage());
                        r12 = Exists;
                        ?? r032 = INSTANCE;
                        r032.closeQuietly(objectInputStreamProvideObjectInputStream);
                        r032.closeQuietly(r12);
                        delete(file);
                        return null;
                    } catch (Exception e12) {
                        e = e12;
                        p.a aVar3 = p.Companion;
                        String TAG4 = TAG;
                        kotlin.jvm.internal.t.h(TAG4, "TAG");
                        aVar3.e(TAG4, "cannot read serializable " + e.getMessage());
                        r12 = Exists;
                        ?? r0322 = INSTANCE;
                        r0322.closeQuietly(objectInputStreamProvideObjectInputStream);
                        r0322.closeQuietly(r12);
                        delete(file);
                        return null;
                    }
                } catch (IOException e13) {
                    e = e13;
                    objectInputStreamProvideObjectInputStream = null;
                } catch (ClassNotFoundException e14) {
                    e = e14;
                    objectInputStreamProvideObjectInputStream = null;
                } catch (Exception e15) {
                    e = e15;
                    objectInputStreamProvideObjectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    ?? r04 = INSTANCE;
                    r04.closeQuietly(closeable2);
                    r04.closeQuietly(Exists);
                    throw th;
                }
            } catch (IOException e16) {
                e = e16;
                Exists = 0;
                objectInputStreamProvideObjectInputStream = null;
            } catch (ClassNotFoundException e17) {
                e = e17;
                Exists = 0;
                objectInputStreamProvideObjectInputStream = null;
            } catch (Exception e18) {
                e = e18;
                Exists = 0;
                objectInputStreamProvideObjectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                Exists = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable2 = closeable;
        }
    }

    public static final void writeSerializable(@NotNull File file, @Nullable Serializable serializable) {
        OutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        kotlin.jvm.internal.t.i(file, "file");
        if (file.exists()) {
            deleteAndLogIfFailed(file);
        }
        if (serializable == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e10) {
            e = e10;
            objectOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e11) {
            e = e11;
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            i iVar = INSTANCE;
            iVar.closeQuietly(outputStream);
            iVar.closeQuietly(fileOutputStream);
            throw th;
        }
        try {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.reset();
            i iVar2 = INSTANCE;
            iVar2.closeQuietly(objectOutputStream);
            iVar2.closeQuietly(fileOutputStream);
        } catch (IOException e12) {
            e = e12;
            outputStream = fileOutputStream;
            try {
                p.a aVar = p.Companion;
                String TAG2 = TAG;
                kotlin.jvm.internal.t.h(TAG2, "TAG");
                aVar.e(TAG2, String.valueOf(e.getMessage()));
                i iVar3 = INSTANCE;
                iVar3.closeQuietly(objectOutputStream);
                iVar3.closeQuietly(outputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = outputStream;
                outputStream = objectOutputStream;
                i iVar4 = INSTANCE;
                iVar4.closeQuietly(outputStream);
                iVar4.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = objectOutputStream;
            i iVar42 = INSTANCE;
            iVar42.closeQuietly(outputStream);
            iVar42.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public final void closeQuietly(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @NotNull
    public final List<Class<?>> getAllowedClasses$vungle_ads_release() {
        return allowedClasses;
    }

    @VisibleForTesting
    @NotNull
    public final a getObjectInputStreamProvider() {
        return objectInputStreamProvider;
    }

    @NotNull
    public final String guessFileName(@NotNull String url, @Nullable String str) {
        kotlin.jvm.internal.t.i(url, "url");
        String strGuessFileName = URLUtil.guessFileName(url, null, str);
        kotlin.jvm.internal.t.h(strGuessFileName, "guessFileName(url, null, ext)");
        return strGuessFileName;
    }

    public final boolean isValidUrl(@Nullable String str) {
        return ((str == null || str.length() == 0) || ga.v.f26216k.f(str) == null) ? false : true;
    }

    @Nullable
    public final String readString(@NotNull File file) {
        kotlin.jvm.internal.t.i(file, "file");
        if (!file.exists()) {
            return null;
        }
        try {
            return f9.k.h(file, null, 1, null);
        } catch (IOException e10) {
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.e(TAG2, "IOException: " + e10.getMessage());
            return null;
        } catch (Exception e11) {
            p.a aVar2 = p.Companion;
            String TAG3 = TAG;
            kotlin.jvm.internal.t.h(TAG3, "TAG");
            aVar2.e(TAG3, "cannot read string " + e11.getMessage());
            return null;
        }
    }

    @VisibleForTesting
    public final void setObjectInputStreamProvider(@NotNull a aVar) {
        kotlin.jvm.internal.t.i(aVar, "<set-?>");
        objectInputStreamProvider = aVar;
    }

    public final long size(@Nullable File file) {
        long size = 0;
        if (file == null || !file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            if (!(fileArrListFiles.length == 0)) {
                for (File file2 : fileArrListFiles) {
                    size += size(file2);
                }
            }
        }
        return size;
    }

    public final void writeString(@NotNull File file, @Nullable String str) {
        kotlin.jvm.internal.t.i(file, "file");
        if (str == null) {
            return;
        }
        try {
            f9.k.j(file, str, p9.d.f32952b);
        } catch (IOException e10) {
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.e(TAG2, String.valueOf(e10.getMessage()));
        }
    }

    private final void printDirectoryTree(File file, int i10, StringBuilder sb) {
        if (file == null) {
            return;
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory".toString());
        }
        sb.append(getIndentString(i10));
        sb.append("+--");
        sb.append(file.getName());
        sb.append("/\n");
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                printDirectoryTree(file2, i10 + 1, sb);
            } else {
                kotlin.jvm.internal.t.h(file2, "file");
                printFile(file2, i10 + 1, sb);
            }
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getAllowedClasses$vungle_ads_release$annotations() {
    }
}
