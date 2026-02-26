package ua;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: -JvmPlatform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e1 {
    @NotNull
    public static final byte[] a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        byte[] bytes = str.getBytes(p9.d.f32952b);
        kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @NotNull
    public static final String b(@NotNull byte[] bArr) {
        kotlin.jvm.internal.t.i(bArr, "<this>");
        return new String(bArr, p9.d.f32952b);
    }
}
