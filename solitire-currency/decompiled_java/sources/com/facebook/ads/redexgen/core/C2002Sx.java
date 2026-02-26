package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.PsExtractor;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.ironsource.c3;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2002Sx {
    public static AtomicInteger A00;
    public static byte[] A01;
    public static String[] A02 = {"Y", "xyQF3sxjnp2qUSvJDNu5P0iyyc584Vpd", "idh0g523ELVLwEFfu1u5qrhcL3DPrNZC", "UJ0fDp2QsgF1WBSdDofKnf2EwbpjWzp9", "LsjKEz1u6vy", "QA8fX7ramcT9ifSsWPTVo7ChqvJDDBqT", "HHR99srKdCFKOrgMnrhL9AMY8z42dkOr", "PWBGS5sCKwM35N3BbQj09sXNColJxvDn"};
    public static final Object A03;
    public static final String A04;
    public static final Map<String, Integer> A05;
    public static final Set<String> A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C2004Sz A01(String str, SQ sq, Map<String, String> map) {
        C2004Sz c2004Sz = null;
        try {
            c2004Sz = new C2004Sz(sq.A09().A01(), sq.A09().A02(), new C1988Sj(str, map, true).A02());
            A0C(c2004Sz, sq);
            return c2004Sz;
        } catch (Exception unused) {
            return c2004Sz;
        }
    }

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static JSONArray A04(SQ sq, int i10) {
        InterfaceC1999Su interfaceC1999SuA08;
        JSONArray jSONArray = new JSONArray();
        synchronized (A03) {
            FileInputStream fileInputStreamOpenFileInput = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            try {
                try {
                    if (new File(sq.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 27), sq)).exists()) {
                        fileInputStreamOpenFileInput = sq.openFileInput(ProcessUtils.getProcessSpecificName(A02(281, 9, 27), sq));
                        inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null || i10 == 0) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            if (!jSONObject.has(A02(260, 7, 82))) {
                                jSONObject.put(A02(260, 7, 82), String.valueOf(0));
                            }
                            String string = jSONObject.getString(A02(343, 2, 110));
                            if (!A06.contains(string)) {
                                int i11 = jSONObject.getInt(A02(260, 7, 82));
                                if (A05.containsKey(string)) {
                                    jSONObject.put(A02(260, 7, 82), String.valueOf(A05.get(string)));
                                } else {
                                    A0E(string, i11);
                                }
                                jSONArray.put(jSONObject);
                                if (i10 > 0) {
                                    i10--;
                                }
                            }
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            e = e10;
                            interfaceC1999SuA08 = sq.A08();
                            interfaceC1999SuA08.A4A(e);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                } catch (IOException | JSONException e11) {
                    sq.A08().A4A(e11);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e12) {
                            e = e12;
                            interfaceC1999SuA08 = sq.A08();
                            interfaceC1999SuA08.A4A(e);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                }
            } finally {
                if (bufferedReader != null) {
                    try {
                    } catch (IOException e13) {
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void A06() {
        A01 = new byte[]{-73, -24, -36, 0, 46, 43, 44, -1, 43, 49, 42, 48, 33, 46, -10, -36, -73, -43, -30, -101, -24, -108, -40, -39, -32, -39, -24, -39, -108, -40, -39, -42, -23, -37, -108, -39, -22, -39, -30, -24, -25, -108, -38, -35, -32, -39, -94, 30, 60, 73, 2, 79, -5, 63, 64, 71, 64, 79, 64, -5, 65, 68, 71, 64, -4, 25, 26, 23, 42, 28, 52, 37, 39, 26, 27, -43, 6, -11, -2, 4, -45, -1, 5, -2, 4, 3, -1, -2, 50, 33, 38, 34, 43, 32, 34, 11, 34, 49, 52, 44, 47, 40, -36, 1, -2, -13, -15, -84, -16, -15, -18, 1, -13, -84, -15, 2, -15, -6, 0, -1, -84, -14, -11, -8, -15, -70, -106, -46, -11, -8, -15, -84, -1, -11, 6, -15, -58, -84, 32, 56, 54, 61, 61, 50, 49, -19, 50, 67, 50, 59, 65, 64, -5, 1, 25, 23, 30, 30, 23, 28, 21, -50, 17, 29, 32, 32, 35, 30, 34, 19, 18, -50, 18, 19, 16, 35, 21, -50, 19, 36, 19, 28, 34, -50, 26, 23, 28, 19, -36, 44, 74, 81, 65, 70, 63, -8, 76, 71, -8, 77, 72, 60, 57, 76, 61, -8, 77, 70, 74, 61, 59, 71, 74, 60, 61, 60, -8, 60, 61, 58, 77, 63, 36, 71, 63, 29, 78, 61, 70, 76, 6, -8, 57, 60, 60, 65, 70, 63, -8, 76, 71, -8, 39, 70, 63, 71, 65, 70, 63, 29, 78, 61, 70, 76, 6, 36, 57, 42, 50, 53, 29, 48, 48, 33, 41, 44, 48, -13, -16, 3, -16, -45, -44, -50, -37, -34, -42, -42, -40, -35, -42, -23, -22, -25, -6, -20, -15, -12, -20, -8, 34, 37, 42, 37, 47, 36, 33, 32, -36, 33, 50, 33, 42, 48, -36, 47, 36, 43, 49, 40, 32, -36, 42, 43, 48, -36, 30, 33, -36, 49, 44, 32, 29, 48, 33, 32, -36, 48, 43, -36, 11, 42, 35, 43, 37, 42, 35, 1, 50, 33, 42, 48, -22, 65, 60, -7, -21, -7, -7, -17, -11, -12, -27, -17, -22, -13, -27, -13, -13, -23, -17, -18, -33, -12, -23, -19, -27, 49, 41, 39, 46, 46, 35, 34, 3, 52, 35, 44, 50, 49, -34, -5, -34, -34, -32, -51, -33, -28, -37, -48, 19, 21, 2, 20, 25, 16, 5, -1, 3, 15, 4, 5, 70, 59, 63, 55, 74, 79, 70, 59};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static boolean A0G(SQ sq) {
        JSONArray jSONArray = new JSONArray();
        synchronized (A03) {
            int i10 = 0;
            FileInputStream fileInputStreamOpenFileInput = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    if (new File(sq.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 27), sq)).exists()) {
                        fileInputStreamOpenFileInput = sq.openFileInput(ProcessUtils.getProcessSpecificName(A02(281, 9, 27), sq));
                        inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            String string = jSONObject.getString(A02(343, 2, 110));
                            if (!A06.contains(string)) {
                                if (A05.containsKey(string)) {
                                    Integer num = A05.get(string);
                                    Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 0);
                                    int iA02 = U9.A02(sq);
                                    if (iA02 <= -1 || numValueOf.intValue() <= iA02 - 1) {
                                        jSONObject.put(A02(260, 7, 82), String.valueOf(numValueOf));
                                        jSONArray.put(jSONObject);
                                    } else {
                                        A0D(string);
                                        i10++;
                                    }
                                } else {
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = jSONArray.length();
                        for (int i11 = 0; i11 < length; i11++) {
                            sb.append(jSONArray.getJSONObject(i11).toString()).append('\n');
                        }
                        fileOutputStreamOpenFileOutput = sq.openFileOutput(ProcessUtils.getProcessSpecificName(A02(281, 9, 27), sq), 0);
                        fileOutputStreamOpenFileOutput.write(sb.toString().getBytes());
                    }
                    A09(sq, A00(sq));
                    if (i10 > 0) {
                        sq.A08().AAy(A02(271, 10, 5), AbstractC2000Sv.A2Y, new C2001Sw(A02(138, 15, 99), A02(367, 16, 84) + i10));
                    }
                    return true;
                } finally {
                    if (0 != 0) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            sq.A08().A4A(e10);
                            A06.clear();
                            A05.clear();
                        }
                    }
                    if (0 != 0) {
                        inputStreamReader.close();
                    }
                    if (0 != 0) {
                        fileInputStreamOpenFileInput.close();
                    }
                    if (0 != 0) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                    A06.clear();
                    A05.clear();
                }
            } catch (IOException | JSONException e11) {
                sq.A08().A4A(e11);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        sq.A08().A4A(e12);
                        A06.clear();
                        A05.clear();
                        return false;
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStreamOpenFileInput != null) {
                    fileInputStreamOpenFileInput.close();
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
                A06.clear();
                A05.clear();
                return false;
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01fc A[Catch: IOException -> 0x020a, all -> 0x0254, TryCatch #7 {IOException -> 0x020a, blocks: (B:94:0x01ed, B:96:0x01f2, B:98:0x01f7, B:100:0x01fc, B:102:0x0201, B:104:0x0206), top: B:137:0x01ed, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0201 A[Catch: IOException -> 0x020a, all -> 0x0254, TryCatch #7 {IOException -> 0x020a, blocks: (B:94:0x01ed, B:96:0x01f2, B:98:0x01f7, B:100:0x01fc, B:102:0x0201, B:104:0x0206), top: B:137:0x01ed, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0206 A[Catch: IOException -> 0x020a, all -> 0x0254, TRY_LEAVE, TryCatch #7 {IOException -> 0x020a, blocks: (B:94:0x01ed, B:96:0x01f2, B:98:0x01f7, B:100:0x01fc, B:102:0x0201, B:104:0x0206), top: B:137:0x01ed, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0229 A[Catch: IOException -> 0x0241, all -> 0x0254, TryCatch #8 {IOException -> 0x0241, blocks: (B:115:0x0224, B:117:0x0229, B:119:0x022e, B:121:0x0233, B:123:0x0238, B:125:0x023d), top: B:139:0x0224, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x022e A[Catch: IOException -> 0x0241, all -> 0x0254, TryCatch #8 {IOException -> 0x0241, blocks: (B:115:0x0224, B:117:0x0229, B:119:0x022e, B:121:0x0233, B:123:0x0238, B:125:0x023d), top: B:139:0x0224, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0233 A[Catch: IOException -> 0x0241, all -> 0x0254, TryCatch #8 {IOException -> 0x0241, blocks: (B:115:0x0224, B:117:0x0229, B:119:0x022e, B:121:0x0233, B:123:0x0238, B:125:0x023d), top: B:139:0x0224, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0238 A[Catch: IOException -> 0x0241, all -> 0x0254, TryCatch #8 {IOException -> 0x0241, blocks: (B:115:0x0224, B:117:0x0229, B:119:0x022e, B:121:0x0233, B:123:0x0238, B:125:0x023d), top: B:139:0x0224, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023d A[Catch: IOException -> 0x0241, all -> 0x0254, TRY_LEAVE, TryCatch #8 {IOException -> 0x0241, blocks: (B:115:0x0224, B:117:0x0229, B:119:0x022e, B:121:0x0233, B:123:0x0238, B:125:0x023d), top: B:139:0x0224, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x005d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f2 A[Catch: IOException -> 0x020a, all -> 0x0254, TryCatch #7 {IOException -> 0x020a, blocks: (B:94:0x01ed, B:96:0x01f2, B:98:0x01f7, B:100:0x01fc, B:102:0x0201, B:104:0x0206), top: B:137:0x01ed, outer: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f7 A[Catch: IOException -> 0x020a, all -> 0x0254, TryCatch #7 {IOException -> 0x020a, blocks: (B:94:0x01ed, B:96:0x01f2, B:98:0x01f7, B:100:0x01fc, B:102:0x0201, B:104:0x0206), top: B:137:0x01ed, outer: #17 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0H(com.facebook.ads.redexgen.core.SQ r17) {
        /*
            Method dump skipped, instruction units count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2002Sx.A0H(com.facebook.ads.redexgen.X.SQ):boolean");
    }

    static {
        A06();
        A04 = C2002Sx.class.getName();
        A03 = new Object();
        A06 = Collections.synchronizedSet(new HashSet());
        A05 = Collections.synchronizedMap(new HashMap());
        A00 = new AtomicInteger();
    }

    public static int A00(Context context) {
        return context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 107), context), 0).getInt(A02(75, 10, 38), 0) - A06.size();
    }

    public static JSONArray A03(SQ sq) {
        return A04(sq, -1);
    }

    public static JSONObject A05(C2004Sz c2004Sz) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(A02(343, 2, 110), UUID.randomUUID().toString());
        jSONObject.put(A02(c3.a.b.f11497f, 4, 108), c2004Sz.A03());
        jSONObject.put(A02(TypedValues.CycleType.TYPE_VISIBILITY, 4, 104), XG.A03(c2004Sz.A01()));
        jSONObject.put(A02(355, 12, 22), XG.A03(c2004Sz.A00()));
        jSONObject.put(A02(345, 10, 28), c2004Sz.A02());
        jSONObject.put(A02(267, 4, 37), c2004Sz.A04() != null ? new JSONObject(c2004Sz.A04()) : new JSONObject());
        jSONObject.put(A02(260, 7, 82), String.valueOf(0));
        return jSONObject;
    }

    public static void A07(Context context) {
        synchronized (A03) {
            File file = new File(context.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 27), context));
            if (file.exists()) {
                file.delete();
            }
            A09(context, 0);
            A06.clear();
            A05.clear();
        }
    }

    public static void A08(Context context) {
        A09(context, context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 107), context), 0).getInt(A02(75, 10, 38), 0) + 1);
    }

    public static void A09(Context context, int i10) {
        int i11 = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 107), context), 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (i10 >= 0) {
            i11 = i10;
        }
        if (A02[1].charAt(3) != 'F') {
            throw new RuntimeException();
        }
        A02[0] = CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT;
        editorEdit.putInt(A02(75, 10, 38), i11).apply();
    }

    public static void A0A(SQ sq, String str) {
        File file = new File(sq.getFilesDir(), str);
        if (file.exists() && !file.delete()) {
            sq.A08().A4A(new RuntimeException(A02(47, 18, 113)));
        }
    }

    public static void A0B(C2361cu c2361cu, String str) {
        Integer num = A05.get(str);
        if (num == null) {
            if (c2361cu.A05().AAF()) {
                Log.e(A04, A02(PsExtractor.PRIVATE_STREAM_1, 66, 110));
            }
            num = 0;
        } else {
            A05.remove(str);
        }
        Map<String, Integer> map = A05;
        Integer attempt = Integer.valueOf(num.intValue() + 1);
        map.put(str, attempt);
    }

    public static void A0C(C2004Sz c2004Sz, SQ sq) {
        if (c2004Sz != null && sq != null) {
            synchronized (A03) {
                try {
                    String processSpecificName = ProcessUtils.getProcessSpecificName(A02(281, 9, 27), sq);
                    File file = new File(sq.getFilesDir(), processSpecificName);
                    if (file.exists()) {
                        int debugLogFileSizeLimit = U9.A07(sq);
                        long length = file.length();
                        if (debugLogFileSizeLimit > 0 && length > debugLogFileSizeLimit) {
                            boolean zDelete = file.delete();
                            A09(sq, 0);
                            A06.clear();
                            A05.clear();
                            if (zDelete) {
                                Map<String, String> mapA5S = sq.A04().A5S();
                                mapA5S.put(A02(383, 7, 1), A02(271, 10, 5));
                                mapA5S.put(A02(390, 12, 54), String.valueOf(IronSourceConstants.IS_CAP_SESSION));
                                A01(A02(102, 36, 34) + length + A02(1, 15, 82) + A00.getAndIncrement(), sq, mapA5S);
                                return;
                            }
                            String processSpecificName2 = A02(85, 17, 83);
                            Log.e(processSpecificName2, A02(16, 31, 10));
                        }
                    }
                    JSONObject jSONObjectA05 = A05(c2004Sz);
                    FileOutputStream outputStream = sq.openFileOutput(processSpecificName, 32768);
                    outputStream.write((jSONObjectA05.toString() + A02(0, 1, 67)).getBytes());
                    outputStream.close();
                    A08(sq);
                } catch (Exception e10) {
                    sq.A08().A4A(e10);
                }
            }
        }
    }

    public static void A0D(String str) {
        A05.remove(str);
        A06.add(str);
    }

    public static void A0E(String str, int i10) {
        if (!A06.contains(str)) {
            if (A05.containsKey(str)) {
                A05.remove(str);
            }
            A05.put(str, Integer.valueOf(i10));
            return;
        }
        throw new RuntimeException(A02(290, 53, 82));
    }

    public static boolean A0F(SQ sq) {
        if (U9.A0O(sq)) {
            return A0H(sq);
        }
        return A0G(sq);
    }

    public static boolean A0I(String str) {
        return A06.contains(str) || A05.containsKey(str);
    }
}
