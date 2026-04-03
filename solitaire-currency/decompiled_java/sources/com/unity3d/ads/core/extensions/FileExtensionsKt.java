package com.unity3d.ads.core.extensions;

import java.io.File;
import java.util.LinkedList;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FileExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FileExtensionsKt {
    public static final long getDirectorySize(@NotNull File file) {
        File[] fileArrListFiles;
        t.i(file, "<this>");
        long length = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(file);
        while (true) {
            if (!(!linkedList.isEmpty())) {
                return length;
            }
            File file2 = (File) linkedList.remove(0);
            if (file2.exists() && (fileArrListFiles = file2.listFiles()) != null) {
                if (!(fileArrListFiles.length == 0)) {
                    for (File child : fileArrListFiles) {
                        if (child.isDirectory()) {
                            t.h(child, "child");
                            linkedList.add(child);
                        } else {
                            length += child.length();
                        }
                    }
                }
            }
        }
    }
}
