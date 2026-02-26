package io.sentry;

import androidx.webkit.internal.AssetHelper;
import com.ironsource.nb;
import io.sentry.protocol.ViewHierarchy;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Attachment.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private byte[] f27580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final h2 f27581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Callable<byte[]> f27582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private String f27583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f27584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final String f27585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f27586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private String f27587h;

    public b(@NotNull byte[] bArr, @NotNull String str, @Nullable String str2, boolean z10) {
        this(bArr, str, str2, "event.attachment", z10);
    }

    @NotNull
    public static b a(@NotNull Callable<byte[]> callable, @NotNull String str, @Nullable String str2, boolean z10) {
        return new b(callable, str, str2, "event.attachment", z10);
    }

    @NotNull
    public static b b(byte[] bArr) {
        return new b(bArr, "thread-dump.txt", AssetHelper.DEFAULT_MIME_TYPE, false);
    }

    @NotNull
    public static b c(ViewHierarchy viewHierarchy) {
        return new b((h2) viewHierarchy, "view-hierarchy.json", nb.L, "event.view_hierarchy", false);
    }

    @Nullable
    public String d() {
        return this.f27587h;
    }

    @Nullable
    public Callable<byte[]> e() {
        return this.f27582c;
    }

    @Nullable
    public byte[] f() {
        return this.f27580a;
    }

    @Nullable
    public String g() {
        return this.f27585f;
    }

    @NotNull
    public String h() {
        return this.f27584e;
    }

    @Nullable
    public String i() {
        return this.f27583d;
    }

    @Nullable
    public h2 j() {
        return this.f27581b;
    }

    boolean k() {
        return this.f27586g;
    }

    public b(@NotNull byte[] bArr, @NotNull String str, @Nullable String str2, @Nullable String str3, boolean z10) {
        this.f27580a = bArr;
        this.f27581b = null;
        this.f27582c = null;
        this.f27584e = str;
        this.f27585f = str2;
        this.f27587h = str3;
        this.f27586g = z10;
    }

    public b(@NotNull h2 h2Var, @NotNull String str, @Nullable String str2, @Nullable String str3, boolean z10) {
        this.f27580a = null;
        this.f27581b = h2Var;
        this.f27582c = null;
        this.f27584e = str;
        this.f27585f = str2;
        this.f27587h = str3;
        this.f27586g = z10;
    }

    public b(@NotNull Callable<byte[]> callable, @NotNull String str, @Nullable String str2, @Nullable String str3, boolean z10) {
        this.f27580a = null;
        this.f27581b = null;
        this.f27582c = callable;
        this.f27584e = str;
        this.f27585f = str2;
        this.f27587h = str3;
        this.f27586g = z10;
    }
}
