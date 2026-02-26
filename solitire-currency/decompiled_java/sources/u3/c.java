package u3;

import a4.o0;
import a4.p0;
import a4.t;
import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n3.i;
import n3.k;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: TtmlDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends n3.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Pattern f34527p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Pattern f34528q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Pattern f34529r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final Pattern f34530s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final Pattern f34531t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Pattern f34532u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Pattern f34533v = Pattern.compile("^(\\d+) (\\d+)$");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final b f34534w = new b(30.0f, 1, 1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final a f34535x = new a(32, 15);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final XmlPullParserFactory f34536o;

    /* JADX INFO: compiled from: TtmlDecoder.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f34537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f34538b;

        a(int i10, int i11) {
            this.f34537a = i10;
            this.f34538b = i11;
        }
    }

    /* JADX INFO: compiled from: TtmlDecoder.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f34539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f34540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f34541c;

        b(float f10, int i10, int i11) {
            this.f34539a = f10;
            this.f34540b = i10;
            this.f34541c = i11;
        }
    }

    /* JADX INFO: renamed from: u3.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TtmlDecoder.java */
    private static final class C0705c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f34542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f34543b;

        C0705c(int i10, int i11) {
            this.f34542a = i10;
            this.f34543b = i11;
        }
    }

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f34536o = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    private static a A(XmlPullParser xmlPullParser, a aVar) throws k {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f34533v.matcher(attributeValue);
        if (!matcher.matches()) {
            t.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i10 = Integer.parseInt((String) a4.a.e(matcher.group(1)));
            int i11 = Integer.parseInt((String) a4.a.e(matcher.group(2)));
            if (i10 != 0 && i11 != 0) {
                return new a(i10, i11);
            }
            throw new k("Invalid cell resolution " + i10 + " " + i11);
        } catch (NumberFormatException unused) {
            t.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static void B(String str, g gVar) throws k {
        Matcher matcher;
        String str2;
        String[] strArrH0 = o0.H0(str, "\\s+");
        if (strArrH0.length == 1) {
            matcher = f34529r.matcher(str);
        } else {
            if (strArrH0.length != 2) {
                throw new k("Invalid number of entries for fontSize: " + strArrH0.length + ".");
            }
            matcher = f34529r.matcher(strArrH0[1]);
            t.i("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new k("Invalid expression for fontSize: '" + str + "'.");
        }
        str2 = (String) a4.a.e(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                gVar.z(3);
                break;
            case "em":
                gVar.z(2);
                break;
            case "px":
                gVar.z(1);
                break;
            default:
                throw new k("Invalid unit for fontSize: '" + str2 + "'.");
        }
        gVar.y(Float.parseFloat((String) a4.a.e(matcher.group(1))));
    }

    private static b C(XmlPullParser xmlPullParser) throws k {
        float f10;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i10 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (o0.H0(attributeValue2, " ").length != 2) {
                throw new k("frameRateMultiplier doesn't have 2 parts");
            }
            f10 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f10 = 1.0f;
        }
        b bVar = f34534w;
        int i11 = bVar.f34540b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i11 = Integer.parseInt(attributeValue3);
        }
        int i12 = bVar.f34541c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i12 = Integer.parseInt(attributeValue4);
        }
        return new b(i10 * f10, i11, i12);
    }

    private static Map<String, g> D(XmlPullParser xmlPullParser, Map<String, g> map, a aVar, @Nullable C0705c c0705c, Map<String, e> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (p0.e(xmlPullParser, TtmlNode.TAG_STYLE)) {
                String strA = p0.a(xmlPullParser, TtmlNode.TAG_STYLE);
                g gVarI = I(xmlPullParser, new g());
                if (strA != null) {
                    for (String str : J(strA)) {
                        gVarI.a(map.get(str));
                    }
                }
                String strG = gVarI.g();
                if (strG != null) {
                    map.put(strG, gVarI);
                }
            } else if (p0.e(xmlPullParser, "region")) {
                e eVarG = G(xmlPullParser, aVar, c0705c);
                if (eVarG != null) {
                    map2.put(eVarG.f34557a, eVarG);
                }
            } else if (p0.e(xmlPullParser, TtmlNode.TAG_METADATA)) {
                E(xmlPullParser, map3);
            }
        } while (!p0.c(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    private static void E(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (p0.e(xmlPullParser, "image") && (strA = p0.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!p0.c(xmlPullParser, TtmlNode.TAG_METADATA));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static u3.d F(org.xmlpull.v1.XmlPullParser r20, @androidx.annotation.Nullable u3.d r21, java.util.Map<java.lang.String, u3.e> r22, u3.c.b r23) throws n3.k {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.c.F(org.xmlpull.v1.XmlPullParser, u3.d, java.util.Map, u3.c$b):u3.d");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b4  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static u3.e G(org.xmlpull.v1.XmlPullParser r17, u3.c.a r18, @androidx.annotation.Nullable u3.c.C0705c r19) {
        /*
            Method dump skipped, instruction units count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.c.G(org.xmlpull.v1.XmlPullParser, u3.c$a, u3.c$c):u3.e");
    }

    private static float H(String str) {
        Matcher matcher = f34530s.matcher(str);
        if (!matcher.matches()) {
            t.i("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) a4.a.e(matcher.group(1)))));
        } catch (NumberFormatException e10) {
            t.j("TtmlDecoder", "Failed to parse shear: " + str, e10);
            return Float.MAX_VALUE;
        }
    }

    private static g I(XmlPullParser xmlPullParser, g gVar) {
        String attributeValue;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            attributeValue = xmlPullParser.getAttributeValue(i10);
            String attributeName = xmlPullParser.getAttributeName(i10);
            attributeName.hashCode();
            switch (attributeName) {
                case "fontStyle":
                    gVar = x(gVar).B(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case "fontFamily":
                    gVar = x(gVar).x(attributeValue);
                    break;
                case "textAlign":
                    gVar = x(gVar).H(z(attributeValue));
                    break;
                case "textDecoration":
                    String strE = e5.c.e(attributeValue);
                    strE.hashCode();
                    switch (strE) {
                        case "nounderline":
                            gVar = x(gVar).K(false);
                            break;
                        case "underline":
                            gVar = x(gVar).K(true);
                            break;
                        case "nolinethrough":
                            gVar = x(gVar).C(false);
                            break;
                        case "linethrough":
                            gVar = x(gVar).C(true);
                            break;
                    }
                    break;
                case "fontWeight":
                    gVar = x(gVar).v(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case "id":
                    if (!TtmlNode.TAG_STYLE.equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        gVar = x(gVar).A(attributeValue);
                        break;
                    }
                    break;
                case "ruby":
                    String strE2 = e5.c.e(attributeValue);
                    strE2.hashCode();
                    switch (strE2) {
                        case "baseContainer":
                        case "base":
                            gVar = x(gVar).F(2);
                            break;
                        case "container":
                            gVar = x(gVar).F(1);
                            break;
                        case "delimiter":
                            gVar = x(gVar).F(4);
                            break;
                        case "textContainer":
                        case "text":
                            gVar = x(gVar).F(3);
                            break;
                    }
                    break;
                case "color":
                    gVar = x(gVar);
                    try {
                        gVar.w(a4.f.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        t.i("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                    break;
                case "shear":
                    gVar = x(gVar).G(H(attributeValue));
                    break;
                case "textCombine":
                    String strE3 = e5.c.e(attributeValue);
                    strE3.hashCode();
                    if (!strE3.equals("all")) {
                        if (strE3.equals("none")) {
                            gVar = x(gVar).I(false);
                        }
                        break;
                    } else {
                        gVar = x(gVar).I(true);
                        break;
                    }
                    break;
                case "fontSize":
                    try {
                        gVar = x(gVar);
                        B(attributeValue, gVar);
                        break;
                    } catch (k unused2) {
                        t.i("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                    break;
                case "textEmphasis":
                    gVar = x(gVar).J(u3.b.a(attributeValue));
                    break;
                case "rubyPosition":
                    String strE4 = e5.c.e(attributeValue);
                    strE4.hashCode();
                    if (!strE4.equals(TtmlNode.ANNOTATION_POSITION_BEFORE)) {
                        if (strE4.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                            gVar = x(gVar).E(2);
                        }
                        break;
                    } else {
                        gVar = x(gVar).E(1);
                        break;
                    }
                    break;
                case "backgroundColor":
                    gVar = x(gVar);
                    try {
                        gVar.u(a4.f.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        t.i("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                    break;
                case "multiRowAlign":
                    gVar = x(gVar).D(z(attributeValue));
                    break;
            }
        }
        return gVar;
    }

    private static String[] J(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : o0.H0(strTrim, "\\s+");
    }

    private static long K(String str, b bVar) throws k {
        double d10;
        double d11;
        double d12;
        Matcher matcher = f34527p.matcher(str);
        if (matcher.matches()) {
            double d13 = (Long.parseLong((String) a4.a.e(matcher.group(1))) * 3600) + (Long.parseLong((String) a4.a.e(matcher.group(2))) * 60) + Long.parseLong((String) a4.a.e(matcher.group(3)));
            String strGroup = matcher.group(4);
            return (long) ((d13 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / bVar.f34539a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / ((double) bVar.f34540b)) / ((double) bVar.f34539a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f34528q.matcher(str);
        if (!matcher2.matches()) {
            throw new k("Malformed time expression: " + str);
        }
        d10 = Double.parseDouble((String) a4.a.e(matcher2.group(1)));
        String str2 = (String) a4.a.e(matcher2.group(2));
        str2.hashCode();
        switch (str2) {
            case "f":
                d11 = bVar.f34539a;
                d10 /= d11;
                return (long) (d10 * 1000000.0d);
            case "h":
                d12 = 3600.0d;
                break;
            case "m":
                d12 = 60.0d;
                break;
            case "t":
                d11 = bVar.f34541c;
                d10 /= d11;
                return (long) (d10 * 1000000.0d);
            case "ms":
                d11 = 1000.0d;
                d10 /= d11;
                return (long) (d10 * 1000000.0d);
            default:
                return (long) (d10 * 1000000.0d);
        }
        d10 *= d12;
        return (long) (d10 * 1000000.0d);
    }

    @Nullable
    private static C0705c L(XmlPullParser xmlPullParser) {
        String strA = p0.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (strA == null) {
            return null;
        }
        Matcher matcher = f34532u.matcher(strA);
        if (!matcher.matches()) {
            t.i("TtmlDecoder", "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new C0705c(Integer.parseInt((String) a4.a.e(matcher.group(1))), Integer.parseInt((String) a4.a.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            t.i("TtmlDecoder", "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    private static g x(@Nullable g gVar) {
        return gVar == null ? new g() : gVar;
    }

    private static boolean y(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals("body") || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals("br") || str.equals(TtmlNode.TAG_STYLE) || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(TtmlNode.TAG_METADATA) || str.equals("image") || str.equals("data") || str.equals(TtmlNode.TAG_INFORMATION);
    }

    @Nullable
    private static Layout.Alignment z(String str) {
        String strE = e5.c.e(str);
        strE.hashCode();
        switch (strE) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    @Override // n3.h
    protected i v(byte[] bArr, int i10, boolean z10) throws k {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f34536o.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new e(""));
            C0705c c0705cL = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i10), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarC = f34534w;
            a aVarA = f34535x;
            int i11 = 0;
            h hVar = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i11 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            bVarC = C(xmlPullParserNewPullParser);
                            aVarA = A(xmlPullParserNewPullParser, f34535x);
                            c0705cL = L(xmlPullParserNewPullParser);
                        }
                        C0705c c0705c = c0705cL;
                        b bVar2 = bVarC;
                        a aVar = aVarA;
                        if (y(name)) {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                bVar = bVar2;
                                D(xmlPullParserNewPullParser, map, aVar, c0705c, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    d dVarF = F(xmlPullParserNewPullParser, dVar, map2, bVar);
                                    arrayDeque.push(dVarF);
                                    if (dVar != null) {
                                        dVar.a(dVarF);
                                    }
                                } catch (k e10) {
                                    t.j("TtmlDecoder", "Suppressing parser error", e10);
                                    i11++;
                                }
                            }
                            bVarC = bVar;
                        } else {
                            t.f("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i11++;
                            bVarC = bVar2;
                        }
                        c0705cL = c0705c;
                        aVarA = aVar;
                    } else if (eventType == 4) {
                        ((d) a4.a.e(dVar)).a(d.d(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            hVar = new h((d) a4.a.e((d) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i11++;
                } else if (eventType == 3) {
                    i11--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new k("No TTML subtitles found");
        } catch (IOException e11) {
            throw new IllegalStateException("Unexpected error when reading input.", e11);
        } catch (XmlPullParserException e12) {
            throw new k("Unable to decode source", e12);
        }
    }
}
