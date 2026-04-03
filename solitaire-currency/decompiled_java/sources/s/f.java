package s;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import v.n;

/* JADX INFO: compiled from: ResourceUriMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements d<Uri, Uri> {
    private final boolean b(Uri uri) {
        if (!t.d(uri.getScheme(), "android.resource")) {
            return false;
        }
        String authority = uri.getAuthority();
        return !(authority == null || q.z(authority)) && uri.getPathSegments().size() == 2;
    }

    @Override // s.d
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Uri a(@NotNull Uri uri, @NotNull n nVar) throws PackageManager.NameNotFoundException {
        if (!b(uri)) {
            return null;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            authority = "";
        }
        Resources resourcesForApplication = nVar.g().getPackageManager().getResourcesForApplication(authority);
        List<String> pathSegments = uri.getPathSegments();
        int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        if (!(identifier != 0)) {
            throw new IllegalStateException(("Invalid android.resource URI: " + uri).toString());
        }
        Uri uri2 = Uri.parse("android.resource://" + authority + '/' + identifier);
        t.h(uri2, "parse(this)");
        return uri2;
    }
}
