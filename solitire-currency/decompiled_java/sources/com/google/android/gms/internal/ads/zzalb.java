package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalb implements zzaka {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzakz zzh = new zzakz(30.0f, 1, 1);

    public zzalb() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.zzi = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long zzd(java.lang.String r13, com.google.android.gms.internal.ads.zzakz r14) throws com.google.android.gms.internal.ads.zzajw {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalb.zzd(java.lang.String, com.google.android.gms.internal.ads.zzakz):long");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.text.Layout.Alignment zze(java.lang.String r5) {
        /*
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfuf.zza(r5)
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L38;
                case 100571: goto L2e;
                case 3317767: goto L24;
                case 108511772: goto L1a;
                case 109757538: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L42
        L10:
            java.lang.String r0 = "start"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r4
            goto L43
        L1a:
            java.lang.String r0 = "right"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r3
            goto L43
        L24:
            java.lang.String r0 = "left"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = 0
            goto L43
        L2e:
            java.lang.String r0 = "end"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r2
            goto L43
        L38:
            java.lang.String r0 = "center"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r1
            goto L43
        L42:
            r5 = -1
        L43:
            if (r5 == 0) goto L55
            if (r5 == r4) goto L55
            if (r5 == r3) goto L52
            if (r5 == r2) goto L52
            if (r5 == r1) goto L4f
            r5 = 0
            return r5
        L4f:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            return r5
        L52:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            return r5
        L55:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalb.zze(java.lang.String):android.text.Layout$Alignment");
    }

    private static zzale zzf(@Nullable zzale zzaleVar) {
        return zzaleVar == null ? new zzale() : zzaleVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static zzale zzg(XmlPullParser xmlPullParser, zzale zzaleVar) {
        String attributeValue;
        byte b10;
        Matcher matcher;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            attributeValue = xmlPullParser.getAttributeValue(i10);
            b10 = -1;
            switch (xmlPullParser.getAttributeName(i10)) {
                case "id":
                    if (!TtmlNode.TAG_STYLE.equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        zzaleVar = zzf(zzaleVar);
                        zzaleVar.zzs(attributeValue);
                        break;
                    }
                    break;
                case "backgroundColor":
                    zzaleVar = zzf(zzaleVar);
                    try {
                        zzaleVar.zzm(zzdl.zzb(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        zzea.zzf("TtmlParser", "Failed parsing background value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                    break;
                case "color":
                    zzaleVar = zzf(zzaleVar);
                    try {
                        zzaleVar.zzo(zzdl.zzb(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused2) {
                        zzea.zzf("TtmlParser", "Failed parsing color value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                    break;
                case "fontFamily":
                    zzaleVar = zzf(zzaleVar);
                    zzaleVar.zzp(attributeValue);
                    break;
                case "fontSize":
                    try {
                        zzaleVar = zzf(zzaleVar);
                        int i11 = zzet.zza;
                        String[] strArrSplit = attributeValue.split("\\s+", -1);
                        int length = strArrSplit.length;
                        if (length == 1) {
                            matcher = zze.matcher(attributeValue);
                        } else {
                            if (length != 2) {
                                throw new zzajw("Invalid number of entries for fontSize: " + length + ".");
                            }
                            matcher = zze.matcher(strArrSplit[1]);
                            zzea.zzf("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
                        }
                        if (!matcher.matches()) {
                            throw new zzajw("Invalid expression for fontSize: '" + attributeValue + "'.");
                        }
                        String strGroup = matcher.group(3);
                        strGroup.getClass();
                        int iHashCode = strGroup.hashCode();
                        if (iHashCode != 37) {
                            if (iHashCode != 3240) {
                                if (iHashCode == 3592 && strGroup.equals("px")) {
                                    b10 = 0;
                                }
                            } else if (strGroup.equals("em")) {
                                b10 = 1;
                            }
                        } else if (strGroup.equals("%")) {
                            b10 = 2;
                        }
                        if (b10 == 0) {
                            zzaleVar.zzr(1);
                        } else if (b10 == 1) {
                            zzaleVar.zzr(2);
                        } else {
                            if (b10 != 2) {
                                throw new zzajw("Invalid unit for fontSize: '" + strGroup + "'.");
                            }
                            zzaleVar.zzr(3);
                        }
                        String strGroup2 = matcher.group(1);
                        strGroup2.getClass();
                        zzaleVar.zzq(Float.parseFloat(strGroup2));
                        break;
                    } catch (zzajw unused3) {
                        zzea.zzf("TtmlParser", "Failed parsing fontSize value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                    break;
                case "fontWeight":
                    zzaleVar = zzf(zzaleVar);
                    zzaleVar.zzn(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case "fontStyle":
                    zzaleVar = zzf(zzaleVar);
                    zzaleVar.zzt(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case "textAlign":
                    zzaleVar = zzf(zzaleVar);
                    zzaleVar.zzz(zze(attributeValue));
                    break;
                case "multiRowAlign":
                    zzaleVar = zzf(zzaleVar);
                    zzaleVar.zzv(zze(attributeValue));
                    break;
                case "textCombine":
                    String strZza = zzfuf.zza(attributeValue);
                    int iHashCode2 = strZza.hashCode();
                    if (iHashCode2 != 96673) {
                        if (iHashCode2 == 3387192 && strZza.equals("none")) {
                            b10 = 0;
                        }
                    } else if (strZza.equals("all")) {
                        b10 = 1;
                    }
                    if (b10 == 0) {
                        zzaleVar = zzf(zzaleVar);
                        zzaleVar.zzA(false);
                        break;
                    } else {
                        if (b10 == 1) {
                            zzaleVar = zzf(zzaleVar);
                            zzaleVar.zzA(true);
                        }
                        break;
                    }
                    break;
                case "ruby":
                    String strZza2 = zzfuf.zza(attributeValue);
                    switch (strZza2.hashCode()) {
                        case -618561360:
                            if (strZza2.equals(TtmlNode.RUBY_BASE_CONTAINER)) {
                                b10 = 2;
                            }
                            break;
                        case -410956671:
                            if (strZza2.equals(TtmlNode.RUBY_CONTAINER)) {
                                b10 = 0;
                            }
                            break;
                        case -250518009:
                            if (strZza2.equals(TtmlNode.RUBY_DELIMITER)) {
                                b10 = 5;
                            }
                            break;
                        case -136074796:
                            if (strZza2.equals(TtmlNode.RUBY_TEXT_CONTAINER)) {
                                b10 = 4;
                            }
                            break;
                        case 3016401:
                            if (strZza2.equals(TtmlNode.RUBY_BASE)) {
                                b10 = 1;
                            }
                            break;
                        case 3556653:
                            if (strZza2.equals("text")) {
                                b10 = 3;
                            }
                            break;
                    }
                    if (b10 == 0) {
                        zzaleVar = zzf(zzaleVar);
                        zzaleVar.zzx(1);
                        break;
                    } else {
                        if (b10 == 1 || b10 == 2) {
                            zzaleVar = zzf(zzaleVar);
                            zzaleVar.zzx(2);
                        } else if (b10 == 3 || b10 == 4) {
                            zzaleVar = zzf(zzaleVar);
                            zzaleVar.zzx(3);
                        } else if (b10 == 5) {
                            zzaleVar = zzf(zzaleVar);
                            zzaleVar.zzx(4);
                        }
                        break;
                    }
                    break;
                case "rubyPosition":
                    String strZza3 = zzfuf.zza(attributeValue);
                    int iHashCode3 = strZza3.hashCode();
                    if (iHashCode3 != -1392885889) {
                        if (iHashCode3 == 92734940 && strZza3.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                            b10 = 1;
                        }
                    } else if (strZza3.equals(TtmlNode.ANNOTATION_POSITION_BEFORE)) {
                        b10 = 0;
                    }
                    if (b10 == 0) {
                        zzaleVar = zzf(zzaleVar);
                        zzaleVar.zzw(1);
                        break;
                    } else {
                        if (b10 == 1) {
                            zzaleVar = zzf(zzaleVar);
                            zzaleVar.zzw(2);
                        }
                        break;
                    }
                    break;
                case "textDecoration":
                    String strZza4 = zzfuf.zza(attributeValue);
                    switch (strZza4.hashCode()) {
                        case -1461280213:
                            if (strZza4.equals(TtmlNode.NO_UNDERLINE)) {
                                b10 = 3;
                            }
                            break;
                        case -1026963764:
                            if (strZza4.equals(TtmlNode.UNDERLINE)) {
                                b10 = 2;
                            }
                            break;
                        case 913457136:
                            if (strZza4.equals(TtmlNode.NO_LINETHROUGH)) {
                                b10 = 1;
                            }
                            break;
                        case 1679736913:
                            if (strZza4.equals(TtmlNode.LINETHROUGH)) {
                                b10 = 0;
                            }
                            break;
                    }
                    if (b10 == 0) {
                        zzaleVar = zzf(zzaleVar);
                        zzaleVar.zzu(true);
                        break;
                    } else {
                        if (b10 == 1) {
                            zzaleVar = zzf(zzaleVar);
                            zzaleVar.zzu(false);
                        } else if (b10 == 2) {
                            zzaleVar = zzf(zzaleVar);
                            zzaleVar.zzC(true);
                        } else if (b10 == 3) {
                            zzaleVar = zzf(zzaleVar);
                            zzaleVar.zzC(false);
                        }
                        break;
                    }
                    break;
                case "textEmphasis":
                    zzaleVar = zzf(zzaleVar);
                    zzaleVar.zzB(zzakx.zza(attributeValue));
                    break;
                case "shear":
                    zzaleVar = zzf(zzaleVar);
                    Matcher matcher2 = zza.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher2.matches()) {
                        try {
                            String strGroup3 = matcher2.group(1);
                            strGroup3.getClass();
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup3)));
                        } catch (NumberFormatException e10) {
                            zzea.zzg("TtmlParser", "Failed to parse shear: ".concat(String.valueOf(attributeValue)), e10);
                        }
                    } else {
                        zzea.zzf("TtmlParser", "Invalid value for shear: ".concat(String.valueOf(attributeValue)));
                    }
                    zzaleVar.zzy(fMin);
                    break;
            }
        }
        return zzaleVar;
    }

    private static String[] zzh(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        int i10 = zzet.zza;
        return strTrim.split("\\s+", -1);
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i10, int i11, zzajz zzajzVar, zzdn zzdnVar) {
        zzaju.zza(zzc(bArr, i10, i11), zzajzVar, zzdnVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:168:0x037a A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #6, #7, #9, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03f5 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #6, #7, #9, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0443 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #6, #7, #9, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x04ae A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #6, #7, #9, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04d8 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #6, #7, #9, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04e9 A[LOOP:1: B:113:0x026f->B:254:0x04e9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x04e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0181 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #6, #7, #9, #12, #15 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzajv zzc(byte[] r42, int r43, int r44) {
        /*
            Method dump skipped, instruction units count: 1768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalb.zzc(byte[], int, int):com.google.android.gms.internal.ads.zzajv");
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final /* synthetic */ void zzb() {
    }
}
