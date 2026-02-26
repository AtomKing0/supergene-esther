package r0;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Key.java */
/* JADX INFO: loaded from: classes2.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f33247a = Charset.forName("UTF-8");

    void b(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
