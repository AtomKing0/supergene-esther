package androidx.media3.common.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.unity3d.services.UnityAdsConstants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class UriUtil {
    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON = 0;

    private UriUtil() {
    }

    @UnstableApi
    public static String getRelativePath(Uri uri, Uri uri2) {
        if (uri.isOpaque() || uri2.isOpaque()) {
            return uri2.toString();
        }
        String scheme = uri.getScheme();
        String scheme2 = uri2.getScheme();
        if (!(scheme != null ? !(scheme2 == null || !e5.c.a(scheme, scheme2)) : scheme2 == null) || !Util.areEqual(uri.getAuthority(), uri2.getAuthority())) {
            return uri2.toString();
        }
        List<String> pathSegments = uri.getPathSegments();
        List<String> pathSegments2 = uri2.getPathSegments();
        int iMin = Math.min(pathSegments.size(), pathSegments2.size());
        int i10 = 0;
        for (int i11 = 0; i11 < iMin && pathSegments.get(i11).equals(pathSegments2.get(i11)); i11++) {
            i10++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i12 = i10; i12 < pathSegments.size(); i12++) {
            sb.append("../");
        }
        while (i10 < pathSegments2.size()) {
            sb.append(pathSegments2.get(i10));
            if (i10 < pathSegments2.size() - 1) {
                sb.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
            }
            i10++;
        }
        return sb.toString();
    }

    private static int[] getUriIndices(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i10 = iIndexOf5 + 2;
        if (i10 < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i10) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }

    public static boolean isAbsolute(@Nullable String str) {
        return (str == null || getUriIndices(str)[0] == -1) ? false : true;
    }

    private static String removeDotSegments(StringBuilder sb, int i10, int i11) {
        int i12;
        int iLastIndexOf;
        if (i10 >= i11) {
            return sb.toString();
        }
        if (sb.charAt(i10) == '/') {
            i10++;
        }
        int i13 = i10;
        int i14 = i13;
        while (i13 <= i11) {
            if (i13 == i11) {
                i12 = i13;
            } else if (sb.charAt(i13) == '/') {
                i12 = i13 + 1;
            } else {
                i13++;
            }
            int i15 = i14 + 1;
            if (i13 == i15 && sb.charAt(i14) == '.') {
                sb.delete(i14, i12);
                i11 -= i12 - i14;
            } else {
                if (i13 == i14 + 2 && sb.charAt(i14) == '.' && sb.charAt(i15) == '.') {
                    iLastIndexOf = sb.lastIndexOf(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, i14 - 2) + 1;
                    int i16 = iLastIndexOf > i10 ? iLastIndexOf : i10;
                    sb.delete(i16, i12);
                    i11 -= i12 - i16;
                } else {
                    iLastIndexOf = i13 + 1;
                }
                i14 = iLastIndexOf;
            }
            i13 = i14;
        }
        return sb.toString();
    }

    public static Uri removeQueryParameter(Uri uri, String str) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str2 : uri.getQueryParameterNames()) {
            if (!str2.equals(str)) {
                Iterator<String> it = uri.getQueryParameters(str2).iterator();
                while (it.hasNext()) {
                    builderBuildUpon.appendQueryParameter(str2, it.next());
                }
            }
        }
        return builderBuildUpon.build();
    }

    public static String resolve(@Nullable String str, @Nullable String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] uriIndices = getUriIndices(str2);
        if (uriIndices[0] != -1) {
            sb.append(str2);
            removeDotSegments(sb, uriIndices[1], uriIndices[2]);
            return sb.toString();
        }
        int[] uriIndices2 = getUriIndices(str);
        if (uriIndices[3] == 0) {
            sb.append((CharSequence) str, 0, uriIndices2[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (uriIndices[2] == 0) {
            sb.append((CharSequence) str, 0, uriIndices2[2]);
            sb.append(str2);
            return sb.toString();
        }
        int i10 = uriIndices[1];
        if (i10 != 0) {
            int i11 = uriIndices2[0] + 1;
            sb.append((CharSequence) str, 0, i11);
            sb.append(str2);
            return removeDotSegments(sb, uriIndices[1] + i11, i11 + uriIndices[2]);
        }
        if (str2.charAt(i10) == '/') {
            sb.append((CharSequence) str, 0, uriIndices2[1]);
            sb.append(str2);
            int i12 = uriIndices2[1];
            return removeDotSegments(sb, i12, uriIndices[2] + i12);
        }
        int i13 = uriIndices2[0] + 2;
        int i14 = uriIndices2[1];
        if (i13 >= i14 || i14 != uriIndices2[2]) {
            int iLastIndexOf = str.lastIndexOf(47, uriIndices2[2] - 1);
            int i15 = iLastIndexOf == -1 ? uriIndices2[1] : iLastIndexOf + 1;
            sb.append((CharSequence) str, 0, i15);
            sb.append(str2);
            return removeDotSegments(sb, uriIndices2[1], i15 + uriIndices[2]);
        }
        sb.append((CharSequence) str, 0, i14);
        sb.append('/');
        sb.append(str2);
        int i16 = uriIndices2[1];
        return removeDotSegments(sb, i16, uriIndices[2] + i16 + 1);
    }

    public static Uri resolveToUri(@Nullable String str, @Nullable String str2) {
        return Uri.parse(resolve(str, str2));
    }
}
