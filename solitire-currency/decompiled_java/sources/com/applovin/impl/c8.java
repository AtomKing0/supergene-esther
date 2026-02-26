package com.applovin.impl;

import android.util.Xml;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public class c8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f4961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Stack f4962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StringBuilder f4963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f4965e;

    private static class b extends b8 {
        b(String str, Map map, b8 b8Var) {
            super(str, map, b8Var);
        }

        void a(b8 b8Var) {
            if (b8Var == null) {
                throw new IllegalArgumentException("None specified.");
            }
            this.f4915e.add(b8Var);
        }

        void d(String str) {
            this.f4914d = str;
        }
    }

    c8(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f4961a = jVar.I();
    }

    public static b8 a(String str, com.applovin.impl.sdk.j jVar) {
        return new c8(jVar).a(str);
    }

    public b8 a(String str) throws SAXException {
        if (str != null) {
            this.f4963c = new StringBuilder();
            this.f4962b = new Stack();
            this.f4965e = null;
            Xml.parse(str, new a());
            b bVar = this.f4965e;
            if (bVar != null) {
                return bVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map a(Attributes attributes) {
        if (attributes != null) {
            int length = attributes.getLength();
            HashMap map = new HashMap(length);
            for (int i10 = 0; i10 < length; i10++) {
                map.put(attributes.getQName(i10), attributes.getValue(i10));
            }
            return map;
        }
        return Collections.emptyMap();
    }

    class a implements ContentHandler {
        a() {
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i10, int i11) {
            String strTrim = new String(Arrays.copyOfRange(cArr, i10, i11)).trim();
            if (StringUtils.isValidString(strTrim)) {
                c8.this.f4963c.append(strTrim);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - c8.this.f4964d;
            com.applovin.impl.sdk.n unused = c8.this.f4961a;
            if (com.applovin.impl.sdk.n.a()) {
                c8.this.f4961a.a("XmlParser", "Finished parsing in " + seconds + " seconds");
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            c8 c8Var = c8.this;
            c8Var.f4965e = (b) c8Var.f4962b.pop();
            c8.this.f4965e.d(c8.this.f4963c.toString().trim());
            c8.this.f4963c.setLength(0);
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
            com.applovin.impl.sdk.n unused = c8.this.f4961a;
            if (com.applovin.impl.sdk.n.a()) {
                c8.this.f4961a.a("XmlParser", "Begin parsing...");
            }
            c8.this.f4964d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            try {
                b bVar = !c8.this.f4962b.isEmpty() ? (b) c8.this.f4962b.peek() : null;
                b bVar2 = new b(str2, c8.this.a(attributes), bVar);
                if (bVar != null) {
                    bVar.a(bVar2);
                }
                c8.this.f4962b.push(bVar2);
            } catch (Exception e10) {
                com.applovin.impl.sdk.n unused = c8.this.f4961a;
                if (com.applovin.impl.sdk.n.a()) {
                    c8.this.f4961a.a("XmlParser", "Unable to process element <" + str2 + ">", e10);
                }
                throw new SAXException("Failed to start element", e10);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i10, int i11) {
        }
    }
}
