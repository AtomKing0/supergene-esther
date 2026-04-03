package a4;

import androidx.annotation.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: XmlPullParserUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p0 {
    @Nullable
    public static String a(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            if (xmlPullParser.getAttributeName(i10).equals(str)) {
                return xmlPullParser.getAttributeValue(i10);
            }
        }
        return null;
    }

    public static boolean b(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean d(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2;
    }

    public static boolean e(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return d(xmlPullParser) && xmlPullParser.getName().equals(str);
    }
}
