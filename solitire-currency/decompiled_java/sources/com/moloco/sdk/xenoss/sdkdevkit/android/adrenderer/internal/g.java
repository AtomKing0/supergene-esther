package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    @NotNull
    public static final String a(@NotNull String str) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.t.i(str, "<this>");
        URI uri = new URI(str);
        String string = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
        kotlin.jvm.internal.t.h(string, "URI(this).run { URI(sche…l, fragment).toString() }");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = string.getBytes(p9.d.f32952b);
        kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.t.h(bArrDigest, "md.digest()");
        return l.a(bArrDigest);
    }
}
