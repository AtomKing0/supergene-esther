package com.vungle.ads.internal.util;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputOutputUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    @NotNull
    public static final n INSTANCE = new n();

    private n() {
    }

    @NotNull
    public final String convertForSending(@NotNull String stringToConvert) throws IOException {
        kotlin.jvm.internal.t.i(stringToConvert, "stringToConvert");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(stringToConvert.length());
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                byte[] bytes = stringToConvert.getBytes(p9.d.f32952b);
                kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                kotlin.jvm.internal.t.h(strEncodeToString, "encodeToString(compressed, Base64.NO_WRAP)");
                f9.c.a(gZIPOutputStream, null);
                f9.c.a(byteArrayOutputStream, null);
                return strEncodeToString;
            } finally {
            }
        } finally {
        }
    }
}
