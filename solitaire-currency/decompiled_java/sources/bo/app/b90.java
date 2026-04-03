package bo.app;

import android.net.Uri;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public final class b90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f2426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URL f2427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2428d;

    public b90(Uri uri, boolean z10) {
        kotlin.jvm.internal.t.i(uri, "uri");
        this.f2426b = uri;
        String string = uri.toString();
        kotlin.jvm.internal.t.h(string, "uri.toString()");
        this.f2425a = string;
        this.f2427c = new URL(string);
        this.f2428d = z10;
    }

    public final String a() {
        return this.f2425a;
    }

    public final String toString() {
        return this.f2425a;
    }

    public /* synthetic */ b90(String str) {
        this(str, false);
    }

    public b90(String urlString, boolean z10) {
        kotlin.jvm.internal.t.i(urlString, "urlString");
        Uri uri = Uri.parse(urlString);
        kotlin.jvm.internal.t.h(uri, "parse(urlString)");
        this.f2426b = uri;
        this.f2425a = urlString;
        this.f2427c = new URL(urlString);
        this.f2428d = z10;
    }
}
