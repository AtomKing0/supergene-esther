package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.EditText;
import androidx.media3.extractor.ts.PsExtractor;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Om, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1888Om implements InterfaceC2109Xe {
    public static byte[] A04;
    public C2361cu A00;
    public TE A01;
    public InterfaceC2466ed A02;
    public final Executor A03;

    static {
        A06();
    }

    public static String A03(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A04 = new byte[]{98, 103, 103, 97, 100, 105, 97, 99, 102, 98, 99, 96, 103, 97, 98, 92, 87, 89, 94, 93, 91, 90, 92, 94, 86, 86, 91, 90, 93, 90, 95, 80, 90, 80, 92, 90, 80, 93, 89, 80, 80, 94, 80, 89, 88, 21, 80, 11, 15, 91, 80, 8, 88, 15, 91, 94, 93, 92, 94, 93, 95, 8, 95, 10, 95, 89, 13, 94, 89, 94, 15, 92, 11, 10, 91, 90, 10, 91, 94, 124, 115, 126, 120, 113, 109, 65, 89, 0, 79, 84, 72, 69, 82, 83, 0, 76, 79, 71, 73, 78, 0, 65, 83, 0, 89, 79, 85, 0, 84, 79, 0, 68, 69, 66, 85, 71, 31, 0, 104, 79, 87, 0, 68, 79, 0, 89, 79, 85, 0, 82, 69, 80, 82, 79, 68, 85, 67, 69, 0, 84, 72, 69, 0, 73, 83, 83, 85, 69, 31, 53, 3, 8, 2, 70, 52, 3, 22, 9, 20, 18, 62, 1, 8, 29, 73, 33, 8, 25, 25, 12, 7, 12, 13, 86, 27, 25, 25, 31, 9, 9, 37, 14, 21, 17, 31, 20, 25, 27, 14, 31, 29, 21, 8, 3, 37, 19, 30, 47, 32, 37, 41, 34, 56, 19, 56, 37, 33, 41, 99, 108, 105, 101, 110, 116, 95, 116, 111, 107, 101, 110, 89, 85, 84, 92, 83, 93, 101, 83, 94, 1, 0, 22, 6, 23, 12, 21, 17, 12, 10, 11, 47, 39, 54, 35, 38, 35, 54, 35, 57, 61, 39, 55, 11, 61, 58, 50, 59, 116, 114, 100, 115, 94, 104, 101, 100, 111, 117, 104, 103, 104, 100, 115};
    }

    public C1888Om(Executor executor, TE te, C2387dL c2387dL) {
        this.A00 = c2387dL.A02();
        this.A02 = C2484ev.A01(this.A00);
        this.A03 = executor;
        this.A01 = te;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A02(String str) {
        C2480er c2480er = new C2480er();
        C2480er c2480er2 = new C2480er();
        C2480er c2480er3 = new C2480er();
        c2480er.put(A03(257, 15, 52), AbstractC1971Rr.A00().A03());
        c2480er.put(A03(220, 9, 15), A03(15, 15, 91));
        c2480er.put(A03(186, 11, 79), A03(0, 15, 101));
        c2480er.put(A03(174, 12, 79), A03(30, 48, 92));
        c2480er.put(A03(197, 11, 121), (System.currentTimeMillis() / 1000) + A03(0, 0, 108));
        String strA09 = this.A01.A09();
        if (strA09 != null) {
            c2480er3.put(A03(208, 12, 53), strA09);
        }
        c2480er2.put(A03(229, 11, 80), str);
        c2480er2.put(A03(248, 9, 97), AbstractC2096Wr.A01(c2480er3));
        c2480er.A04(A03(PsExtractor.VIDEO_STREAM_MASK, 8, 119), AbstractC2096Wr.A01(c2480er2));
        return c2480er;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(TE te) {
        this.A01 = te;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2109Xe
    public final void AFD() {
        Activity activityA00 = ActivityUtils.A00();
        if (activityA00 == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activityA00);
        builder.setTitle(A03(160, 14, 92));
        EditText editText = new EditText(activityA00);
        editText.setSingleLine(false);
        editText.setImeOptions(1073741824);
        editText.setHint(A03(84, 65, 21));
        editText.setMaxLines(2);
        editText.setMinLines(2);
        builder.setView(editText);
        builder.setNegativeButton(A03(78, 6, 40), new DialogInterfaceOnClickListenerC2106Xb(this));
        builder.setPositiveButton(A03(149, 11, 83), new DialogInterfaceOnClickListenerC2107Xc(this, editText));
        builder.create().show();
    }
}
