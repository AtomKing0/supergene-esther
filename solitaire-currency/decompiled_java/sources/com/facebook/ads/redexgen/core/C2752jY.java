package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2752jY implements KW {
    public static String[] A05 = {"ueDbV1wfakHSWIQF7BEzGoLlZXsjLXAz", "DUk", "o0l", "JXBQRCbHgV51hCMTPiBs95yrGLtJ9vRB", "UUCtZFjpq77XJSMaCIYouODFHgisrwF4", "OUp13aafPcRzH6W84Z44X0AbLYnCU3jN", "RRsP4MaHzu2rfmisltpPpgYoVzHnYDNm", "WbSPhlBTq3Mh8neaDCFEdYJRI0JZWypJ"};
    public final int A00;
    public final /* synthetic */ C2751jX A04;
    public final C4I A03 = new C4I(new byte[5]);
    public final SparseArray<InterfaceC1780Kf> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 14 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0176  */
    @Override // com.facebook.ads.redexgen.core.KW
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A52(com.facebook.ads.redexgen.core.C4J r13) {
        /*
            Method dump skipped, instruction units count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2752jY.A52(com.facebook.ads.redexgen.X.4J):void");
    }

    public C2752jY(C2751jX c2751jX, int i10) {
        this.A04 = c2751jX;
        this.A00 = i10;
    }

    private C1776Kb A00(C4J c4j, int i10) {
        int descriptorTag = c4j.A09();
        int descriptorLength = descriptorTag + i10;
        int i11 = -1;
        String strTrim = null;
        ArrayList arrayList = null;
        while (c4j.A09() < descriptorLength) {
            int positionOfNextDescriptor = c4j.A0I();
            int iA09 = c4j.A09() + c4j.A0I();
            if (iA09 > descriptorLength) {
                break;
            }
            if (positionOfNextDescriptor == 5) {
                long jA0Q = c4j.A0Q();
                if (jA0Q == 1094921523) {
                    i11 = 129;
                } else if (jA0Q == 1161904947) {
                    i11 = 135;
                } else if (jA0Q == 1094921524) {
                    i11 = TsExtractor.TS_STREAM_TYPE_AC4;
                } else if (jA0Q == 1212503619) {
                    i11 = 36;
                }
            } else if (positionOfNextDescriptor == 106) {
                i11 = 129;
            } else if (positionOfNextDescriptor == 122) {
                i11 = 135;
            } else {
                String[] strArr = A05;
                String str = strArr[1];
                String str2 = strArr[2];
                int descriptorsStartPosition = str.length();
                if (descriptorsStartPosition != str2.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A05;
                strArr2[0] = "GzIOqzBb8TAh93bRV2CN08O62ZCaAqRX";
                strArr2[3] = "fp9XAk3ifz38aVsym619EhTf04al4HEa";
                if (positionOfNextDescriptor == 127) {
                    int descriptorsStartPosition2 = c4j.A0I();
                    if (descriptorsStartPosition2 == 21) {
                        i11 = TsExtractor.TS_STREAM_TYPE_AC4;
                    }
                } else if (positionOfNextDescriptor == 123) {
                    i11 = 138;
                } else {
                    String[] strArr3 = A05;
                    String str3 = strArr3[1];
                    String str4 = strArr3[2];
                    int descriptorsStartPosition3 = str3.length();
                    if (descriptorsStartPosition3 != str4.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A05;
                    strArr4[5] = "wqYpRyaK4cDMDpt9hZQKwXCqV01Ydwf6";
                    strArr4[4] = "1qKbohas3rI7JmruTyrxsTuTEMq9fdbm";
                    if (positionOfNextDescriptor == 10) {
                        String strA0W = c4j.A0W(3);
                        String[] strArr5 = A05;
                        String str5 = strArr5[1];
                        String str6 = strArr5[2];
                        int descriptorsStartPosition4 = str5.length();
                        if (descriptorsStartPosition4 != str6.length()) {
                            strTrim = strA0W.trim();
                        } else {
                            A05[6] = "aW10g0SpfKclE3j5mqsPv8AasgcB3Ji3";
                            strTrim = strA0W.trim();
                        }
                    } else if (positionOfNextDescriptor == 89) {
                        i11 = 89;
                        arrayList = new ArrayList();
                        while (c4j.A09() < iA09) {
                            String strTrim2 = c4j.A0W(3).trim();
                            int iA0I = c4j.A0I();
                            byte[] bArr = new byte[4];
                            c4j.A0k(bArr, 0, 4);
                            arrayList.add(new C1775Ka(strTrim2, iA0I, bArr));
                        }
                    } else if (positionOfNextDescriptor == 111) {
                        i11 = 257;
                    }
                }
            }
            c4j.A0g(iA09 - c4j.A09());
        }
        c4j.A0f(descriptorLength);
        return new C1776Kb(i11, strTrim, arrayList, Arrays.copyOfRange(c4j.A0l(), descriptorTag, descriptorLength));
    }

    @Override // com.facebook.ads.redexgen.core.KW
    public final void AA2(C4R c4r, GY gy, C1779Ke c1779Ke) {
    }
}
