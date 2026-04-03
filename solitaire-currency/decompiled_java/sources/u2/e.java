package u2;

import a4.p0;
import a4.t;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import com.google.common.collect.y;
import java.io.IOException;
import java.io.StringReader;
import k2.j2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import u2.b;

/* JADX INFO: compiled from: XmpMotionPhotoDescriptionParser.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f34516a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f34517b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f34518c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    public static b a(String str) throws IOException {
        try {
            return b(str);
        } catch (NumberFormatException | j2 | XmlPullParserException unused) {
            t.i("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    @Nullable
    private static b b(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!p0.e(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw j2.a("Couldn't find xmp metadata", null);
        }
        y<b.a> yVarQ = y.q();
        long jE = C.TIME_UNSET;
        do {
            xmlPullParserNewPullParser.next();
            if (p0.e(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!d(xmlPullParserNewPullParser)) {
                    return null;
                }
                jE = e(xmlPullParserNewPullParser);
                yVarQ = c(xmlPullParserNewPullParser);
            } else if (p0.e(xmlPullParserNewPullParser, "Container:Directory")) {
                yVarQ = f(xmlPullParserNewPullParser, "Container", "Item");
            } else if (p0.e(xmlPullParserNewPullParser, "GContainer:Directory")) {
                yVarQ = f(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!p0.c(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (yVarQ.isEmpty()) {
            return null;
        }
        return new b(jE, yVarQ);
    }

    private static y<b.a> c(XmlPullParser xmlPullParser) {
        for (String str : f34518c) {
            String strA = p0.a(xmlPullParser, str);
            if (strA != null) {
                return y.s(new b.a(MimeTypes.IMAGE_JPEG, "Primary", 0L, 0L), new b.a(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return y.q();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f34516a) {
            String strA = p0.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String str : f34517b) {
            String strA = p0.a(xmlPullParser, str);
            if (strA != null) {
                long j10 = Long.parseLong(strA);
                return j10 == -1 ? C.TIME_UNSET : j10;
            }
        }
        return C.TIME_UNSET;
    }

    private static y<b.a> f(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        y.a aVarK = y.k();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (p0.e(xmlPullParser, str3)) {
                String strA = p0.a(xmlPullParser, str2 + ":Mime");
                String strA2 = p0.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = p0.a(xmlPullParser, str2 + ":Length");
                String strA4 = p0.a(xmlPullParser, str2 + ":Padding");
                if (strA == null || strA2 == null) {
                    return y.q();
                }
                aVarK.a(new b.a(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
            }
        } while (!p0.c(xmlPullParser, str4));
        return aVarK.k();
    }
}
